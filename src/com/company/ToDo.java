package com.company;


import com.exception.IncorrectFormatDateException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class ToDo implements Serializable {


   private Map<String, List<Task>> mapToDO = new HashMap<>();

    public Map<String, List<Task>> getMapToDO() {
        return mapToDO;
    }

    public void setMapToDO(Map<String, List<Task>> mapToDO) {
        this.mapToDO = mapToDO;
    }

    FileWriter fw;

    {
        try {
            fw = new FileWriter("test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<Task> addTask(String task) {
        List<Task> listTask = new ArrayList<>();
        listTask.add(new Task(task));
        return listTask;
    }

    public void printTasklist()  {
        for(String x : mapToDO.keySet()) {
            System.out.println("\t"+"Date: "+ x);
            for (int i = 0; i < mapToDO.get(x).size(); i++) {
                System.out.println(i+1+". "+mapToDO.get(x).get(i).toString());

            }
        }
    }

    public void showTaskListByDate(String date){
        for (int i = 0; i < mapToDO.get(date).size(); i++) {
            System.out.println(i+1+". "+mapToDO.get(date).get(i).toString());

        }
    }
    public void editListOfCasesByNumber(String date, int number, String task){
        mapToDO.get(date).add(number-1,new Task(task));
    }
    public void deleteListByNumber(String date, int number){
        try {
            mapToDO.get(date).remove(number-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getTaskNumber(String date, int number) {

        try {
            System.out.println(mapToDO.get(date).get(number-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStatusTaskCompleted(String date, int number) {
        try {
            mapToDO.get(date).get(number-1).setStatus(Status.DONE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //меняет статус дела по обращению к индексу

    }
    public void getStatusTaskUncompleted(String date, int number) {
        try {
            mapToDO.get(date).get(number-1).setStatus(Status.DONE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //меняет статус дела по обращению к индексу

    }


    public void setMapTaskFirstValue(String date, String task) {
        mapToDO.put(date,addTask(task));
     }
     public  void setMapTaskAddValue(String date, String task){
        mapToDO.get(date).add(new Task(task));

     }

     public boolean keyVerification(String date){
        for(String x : mapToDO.keySet()){
            if(date.equals(x)){
                return true;
            }
        }
        return false;
     }
     public boolean taskSearchDuplicates(String date, String task){
        for(int i = 0;  i<mapToDO.get(date).size(); i++){
            if(task.equals(mapToDO.get(date).get(i))) {
                return true;
            }

        }
        return false;
     }

    public boolean toDoMapIsEmpty(){
       if (mapToDO.size()==0){
           return true;
       }
       return false;

    }
    public void showAllDateList(){
        System.out.println("Список всех дат в списке: ");
        System.out.println(mapToDO.keySet());
    }
    public void showDateCurrentOfWeek(ArrayList<String> strDate){
        for (String x : strDate) {
            System.out.println("\t"+"Date: "+ x);
           showTaskListByDate(x);
        }
    }


//    stream.sorted().forEach(x -> System.out.println(x));






}
