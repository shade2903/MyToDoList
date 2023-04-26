package com.company;


import java.io.IOException;
import java.util.Scanner;

public class MenuService {
    private ToDo toDo ;
    private DateTaskList dateTaskList;
   private Scanner in;
    private String choice = "";
    public MenuService(){
        this.toDo = new ToDo();
        this.dateTaskList = new DateTaskList();
        this.in = new Scanner(System.in);
    }

    public   void showMenu() throws IOException {

if(!MyFile.fileExist("toDoList.bin")){
        try {
            toDo.setMapToDO( MyFile.readFile());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }}

        while (!choice.equals("4")) {
            System.out.println("Select  item: ");
            System.out.println("1.Add task");
            System.out.println("2.Choose task");
            System.out.println("3.Show to-do list");
            System.out.println("4.To finish work");
            choice = in.nextLine();
            switch (choice) {
                case "1":
                menuButtonOne();
                    break;
                case "2":
                   menuButtonTwo();
                    break;
                case "3":
                    menuButtonThree();
                    break;
                case "4":
                    System.out.println("Shutdown");
                    break;
                default:
                    System.out.println("incorrect input");


            }

        }

    }
    private void menuButtonOne() throws IOException {
        System.out.println("Enter date: dd/MM/YYYY");
        String date = dateTaskList.inPutDate();
        System.out.println("Enter task:");
        String task = in.nextLine();
        if (toDo.toDoMapIsEmpty()) {
            toDo.setMapTaskFirstValue(date, task);
        } else if (toDo.keyVerification(date)) {
            toDo.setMapTaskAddValue(date, task);
        } else  {
            toDo.setMapTaskFirstValue(date, task);
        }
        MyFile.serializationInFile(toDo.getMapToDO());

    }
    private void menuButtonTwo() throws IOException {

        toDo.showAllDateList();
        System.out.println("Enter date");
        String date1 = dateTaskList.inPutDate();
        toDo.showTaskListByDate(date1);
        System.out.println("enter  task number:");
        int number = in.nextInt();
        toDo.getTaskNumber(date1, number);
        while (!choice.equals("5")) {
            System.out.println("1.Change description");
            System.out.println("2.Delete");
            System.out.println("3.Mark as done");
            System.out.println("4.Mark as undone");
            System.out.println("5.Back");
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter a new description");
                    String newTask = in.nextLine();
                    if (toDo.taskSearchDuplicates(date1, newTask)) {
                        System.out.println("This task already exists");
                    }
                    toDo.editListOfCasesByNumber(date1, number, newTask);
                    break;
                case "2":
                    System.out.println("Are you sure you want to delete the selected task?(y/n)");
                    String answer = in.nextLine();

                    switch (answer) {
                        case "y":
                            toDo.deleteListByNumber(date1, number);
                            System.out.println("Task deleted");
                            break;
                        case "n":
                            System.out.println("Cancel");
                            break;
                        default:
                            System.out.println("Incorrect input");
                    }
                    MyFile.serializationInFile(toDo.getMapToDO());
                    break;
                case "3":
                    System.out.println("Change the status to completed");
                    toDo.getStatusTaskCompleted(date1, number);
                    break;
                case "4":
                    System.out.println("Change the status to not completed");
                    toDo.getStatusTaskUncompleted(date1, number);
                    break;
                case "5":
                    System.out.println("Back");
                    break;
                default:
                    System.out.println("incorrect input command");

            }
        }
    }
    private void menuButtonThree() throws IOException {
        dateTaskList.ParseAllStringOfDate(toDo.getMapToDO());
        while (!choice.equals("6")) {
            System.out.println("1.On today");
            System.out.println("2.On that week");
            System.out.println("3.On the selected date");
            System.out.println("4.All list");
            System.out.println("5.Save list in txt");
            System.out.println("6.Back");
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("On today:");
                    toDo.showTaskListByDate(dateTaskList.CurrentDate());
                    break;
                case "2":
                    System.out.println("On that week:");
                    toDo.showDateCurrentOfWeek(dateTaskList.dateListCurrentOnTheWeek());
                    break;
                case "3":
                    System.out.println("Input day");
                    String date3 = in.nextLine();
                    toDo.showTaskListByDate(date3);
                    break;
                case "4":
                    System.out.println("All list:");
                    toDo.printTasklist();

                    break;
                case "5":
                    System.out.println("Back");
                    break;
                case "6":
                    System.out.println("Save to-do list in txt format");
                    MyFile.saveInFileTxt(toDo.getMapToDO());
                    break;
                default:
                    System.out.println("Incorrect input command");
                    MyFile.saveInFileTxt(toDo.getMapToDO());
            }
        }
    }


}
