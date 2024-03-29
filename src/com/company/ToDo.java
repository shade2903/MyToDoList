package com.company;

import java.io.Serializable;
import java.util.*;



public class ToDo implements Serializable {


   private Map<String, List<Task>> mapToDO;
   public ToDo(){
       mapToDO =  new TreeMap<>();
   }

    public Map<String, List<Task>> getMapToDO() {
        return mapToDO;
    }

    public void setMapToDO(Map<String, List<Task>> mapToDO) {
        this.mapToDO = mapToDO;
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

        try {
            for (int i = 0; i < mapToDO.get(date).size(); i++) {
                System.out.println(i+1+". "+mapToDO.get(date).get(i).toString());

            }
        } catch (Exception e) {
            System.out.println("No current tasks for today");
        }
    }
    public void editListOfCasesByNumber(String date, int number, String task){
        mapToDO.get(date).set(number-1,new Task(task));
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


    }
    public void getStatusTaskUncompleted(String date, int number) {
        try {
            mapToDO.get(date).get(number-1).setStatus(Status.DONE);
        } catch (Exception e) {
            e.printStackTrace();
        }


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
        System.out.println("List of all dates in the list: ");
        System.out.println(mapToDO.keySet());

    }

    public void showDateCurrentOfWeek(ArrayList<String> strDate){
        if(strDate.size()!=0) {
            for (String x : strDate) {
                System.out.println("\t" + "Date: " + x);
                showTaskListByDate(x);
            }
        }else{
            System.out.println("No cases this week");
        }
    }

}
