package event.data;

public class Event {
    private String date;
    private String title;
    private String startTime;
    private String endTime;
    private String content;

    public Event(String date, String title, String startTime, String endTime, String content) {
        this.date = date;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
