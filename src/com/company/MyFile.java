package com.company;

import java.io.*;
import java.util.List;
import java.util.Map;

public class MyFile {
    private static File createFile(String path) {
        File f = new File(path);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;

    }

    public static void saveInFileTxt(Map<String, List<Task>> map) throws IOException {

        FileWriter fw = new FileWriter(createFile("ToDoList.txt"));

        for (String x : map.keySet()) {
            fw.write("\t" + "Date: " + x + " \n");
            for (int i = 0; i < map.get(x).size(); i++) {
                fw.write(i + 1 + ". " + map.get(x).get(i).toString() + " \n");
            }
        }

        fw.close();

    }

     public static void serializationInFile(Map<String, List<Task>> map) throws IOException {

         FileOutputStream fos = new FileOutputStream(createFile("toDoList.bin"));
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(map);
         oos.close();
         fos.close();
     }
     public static Map<String, List<Task>> readFile() throws IOException, ClassNotFoundException {

         FileInputStream fis = new FileInputStream(createFile("toDoList.bin"));
         ObjectInputStream ois = new ObjectInputStream(fis);
         Map<String, List<Task>> map = (Map<String, List<Task>>) ois.readObject();
         ois.close();
         fis.close();
         return map;
     }
     public static boolean fileExist(String path){
         File f = new File(path);
         if(!f.exists()){
             return true;
                     }

        return false;
     }
}
