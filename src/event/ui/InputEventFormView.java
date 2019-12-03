package event.ui;

import calendar.ui.DayView;
import event.data.Event;
import util.EventUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InputEventFormView extends JPanel {
    private JLabel title;
    private JLabel selectedDate;
    private InputEventTitleForm inputEventTitleForm;
    private SelectTimeForm selectStartTimeForm;
    private SelectTimeForm selectEndTimeForm;
    private InputEventContentForm inputEventContentForm;
    private SaveRemoveButtonForm saveRemoveButtonForm;
    private DayView selectedDayView;
    private Event eventInSelectedDay;

    public InputEventFormView() {
        setSize(300, 450);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        title = new JLabel("이벤트");
        selectedDate = new JLabel();
        inputEventTitleForm = new InputEventTitleForm();
        selectStartTimeForm = new SelectTimeForm("시작");
        selectEndTimeForm = new SelectTimeForm("종료");
        inputEventContentForm = new InputEventContentForm();
        saveRemoveButtonForm = new SaveRemoveButtonForm();

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectedDate.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(title);
        add(selectedDate);
        add(inputEventTitleForm);
        add(selectStartTimeForm);
        add(selectEndTimeForm);
        add(inputEventContentForm);
        add(saveRemoveButtonForm);
    }

    public void setDaySelected(DayView selectedDayView, String selectedDate) {
        if(this.selectedDayView != null) {
            this.selectedDayView.updateDayUnSelected();
        }
        this.selectedDayView = selectedDayView;
        this.selectedDayView.updateDaySelected();
        this.selectedDate.setText(selectedDate);

        eventInSelectedDay = EventUtil.readEventFromFile(selectedDate);

        if(eventInSelectedDay != null) {
            if(this.selectedDayView.getEventName().isEmpty()) {
                this.selectedDayView.setEventName(eventInSelectedDay.getTitle());
            }
            this.inputEventTitleForm.setEventTitle(eventInSelectedDay.getTitle());
            this.selectStartTimeForm.setSelectedTimes(eventInSelectedDay.getStartTime());
            this.selectEndTimeForm.setSelectedTimes(eventInSelectedDay.getEndTime());
            this.inputEventContentForm.setEventContent(eventInSelectedDay.getContent());
        }
        else {
            this.inputEventTitleForm.setEventTitle("");
            this.selectStartTimeForm.setSelectedTimes("");
            this.selectEndTimeForm.setSelectedTimes("");
            this.inputEventContentForm.setEventContent("");
        }
    }

    public void executeCommand(String command) {
        switch (command) {
            case SaveRemoveButtonForm.SAVE :
                if(eventInSelectedDay == null) {
                    if(selectStartTimeForm.getSelectedTimes().compareTo(selectEndTimeForm.getSelectedTimes()) > 0) {
                        //JDialog 등으로 알림 처리 필요!
                        System.out.println("시작시간이 종료시간보다 뒤인 상태");
                    }
                    else {
                        selectedDayView.setEventName(inputEventTitleForm.getEventTitle());

                        ArrayList<String> eventContents = new ArrayList<>();
                        eventContents.add(selectedDate.getText());
                        eventContents.add(inputEventTitleForm.getEventTitle());
                        eventContents.add(selectStartTimeForm.getSelectedTimes());
                        eventContents.add(selectEndTimeForm.getSelectedTimes());
                        eventContents.add(inputEventContentForm.getEventContent());

                        EventUtil.writeEventToFile(eventContents);
                    }
                }
                break;
            case SaveRemoveButtonForm.REMOVE :
                selectedDayView.setEventName("");
                break;
        }
    }
}
