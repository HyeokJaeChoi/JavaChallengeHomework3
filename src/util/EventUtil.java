package util;

import event.data.Event;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventUtil {
    static final String path = EventUtil.class.getResource("").getPath();

    public static void writeEventToFile(List<String> eventContents) {
        try {
            File eventFile = new File(path + "event.txt");
            BufferedWriter bufferedWriter;

            bufferedWriter = new BufferedWriter(new FileWriter(eventFile, true));

            for(int i = 0; i < eventContents.size(); i++) {
                bufferedWriter.write(eventContents.get(i));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Event readEventFromFile(String eventDate) {
        try {
            File eventFile = new File(path + "event.txt");
            if(!eventFile.exists()) {
                eventFile.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(eventFile));

            String read = bufferedReader.readLine();
            while(read != null) {
                System.out.println("ReadLine : " + read);
                if(read.equals(eventDate)) {
                    break;
                }

                read = bufferedReader.readLine();
            }

            if(read == null) {
                bufferedReader.close();
                return null;
            }
            else {
                List<String> eventContents = new ArrayList<>();

                while (!read.equals(System.lineSeparator())) {
                    System.out.println("ReadLineEqualDate : " + read);
                    eventContents.add(read);
                    read = bufferedReader.readLine();

                    if(read == null) {
                        break;
                    }
                }

                bufferedReader.close();

                return new Event(
                        eventContents.get(0),
                        eventContents.get(1),
                        eventContents.get(2),
                        eventContents.get(3),
                        eventContents.get(4)
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
