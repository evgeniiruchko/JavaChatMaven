package ru.geekbrains.client;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class History {
    private final static int MAX_MESSAGES = 100;

    public static LinkedList<String> readHistory(String fileName){
        LinkedList<String> history = new LinkedList<>();
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
                if (history.size() > MAX_MESSAGES){
                    history.remove(0);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return history;
    }

    public static void writeHistory(String fileName, String Message){
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(Message);
            bufferWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
