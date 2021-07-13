package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SaveFile {

    public static void saveInFileTxt(Map<String, List<Task>> map) throws IOException {
        FileWriter fw = new FileWriter("test2.txt");

        for (String x : map.keySet()) {
            fw.write("\t" + "Date: " + x + " \n");
            for (int i = 0; i < map.get(x).size(); i++) {
                fw.write(i + 1 + ". " + map.get(x).get(i).toString() + " \n");
            }
        }

        fw.close();

    }
    public void saveInFile(Map<String, List<Task>> map){

    }
}
