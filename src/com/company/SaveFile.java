package com.company;

import java.io.*;
import java.util.List;
import java.util.Map;

public class SaveFile {

    public static void saveInFileTxt(Map<String, List<Task>> map) throws IOException {
        File f = new File("test2.txt");
        if(!f.exists()){
            f.createNewFile();
        }

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
     public static void serializationInFile(Map<String, List<Task>> map) throws IOException {
         File f = new File("toDoList.bin");
         if(!f.exists()){
             try {
                 f.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         FileOutputStream fos = new FileOutputStream(f);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(map);
         oos.close();
         fos.close();
     }
     public static Map<String, List<Task>> readFile() throws IOException, ClassNotFoundException {
         File f = new File("toDoList.bin");
         if(!f.exists()){
             try {
                 f.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         FileInputStream fis = new FileInputStream(f);
         ObjectInputStream ois = new ObjectInputStream(fis);
         Map<String, List<Task>> map = (Map<String, List<Task>>) ois.readObject();
         ois.close();
         fis.close();
         return map;
     }
}
