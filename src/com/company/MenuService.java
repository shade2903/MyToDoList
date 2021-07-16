package com.company;


import java.io.IOException;
import java.util.Scanner;

public class MenuService {
    ToDo toDo = new ToDo();
    DateTaskList dateTaskList = new DateTaskList();
    Scanner in = new Scanner(System.in);
    Scanner intask = new Scanner(System.in);
    String choice = "";



    public   void showMenu() throws IOException {

if(MyFile.fileExist("toDoList.bin")){
        try {
            toDo.setMapToDO( MyFile.readFile());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }}



        while (!choice.equals("4")) {
            System.out.println("Выберите пункт: ");
            System.out.println("1.Добавить задание");
            System.out.println("2.Выбрать задание");
            System.out.println("3.Показать список дел");
            System.out.println("4.Завершить работу");
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
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println("Не корректный ввод команды");


            }

        }

    }
    private void menuButtonOne() throws IOException {
        System.out.println("Введите дату: dd/MM/YYYY");
        String date = dateTaskList.inPutDate();
        System.out.println("Введите задание:");
        String task = intask.nextLine();
        if (toDo.toDoMapIsEmpty()) {
            toDo.setMapTaskFirstValue(date, task);
        } else if (toDo.keyVerification(date)) {
            toDo.setMapTaskAddValue(date, task);
        } else  {
            toDo.setMapTaskFirstValue(date, task);
        }
        MyFile.serializationInFile(toDo.getMapToDO());

    }
    private void menuButtonTwo(){

        toDo.showAllDateList();
        System.out.println("Введите дату");
        String date1 = dateTaskList.inPutDate();
        toDo.showTaskListByDate(date1);
        System.out.println("Введите номер задания:");
        int number = in.nextInt();
        toDo.getTaskNumber(date1, number);
        while (!choice.equals("5")) {
            System.out.println("1.Изменить  описание");
            System.out.println("2.Удалить");
            System.out.println("3.Пометить как выполненое");
            System.out.println("4.Пометить как  не выполненое");
            System.out.println("5.Назад");
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Введите новое описание");
                    String newTask = intask.nextLine();
                    if (toDo.taskSearchDuplicates(date1, newTask)) {
                        System.out.println("Такое дело уже есть");
                    }
                    toDo.editListOfCasesByNumber(date1, number, newTask);
                    break;
                case "2":
                    System.out.println("Вы действительно хотите удалить выбранное дело?(y/n)");
                    String answer = in.nextLine();

                    switch (answer) {
                        case "y":
                            toDo.deleteListByNumber(date1, number);
                            System.out.println("Дело удалено");
                            break;
                        case "n":
                            System.out.println("Отмена");
                            break;
                        default:
                            System.out.println("Не корректный ввод");
                    }
                    break;
                case "3":
                    System.out.println("Изменяем статус на выполненое");
                    toDo.getStatusTaskCompleted(date1, number);
                    break;
                case "4":
                    System.out.println("Изменяем статус на невыполненое");
                    toDo.getStatusTaskUncompleted(date1, number);
                    break;
                case "5":
                    System.out.println("Назад");
                    break;
                default:
                    System.out.println("Не корректный ввод команды");

            }
        }
    }
    private void menuButtonThree() throws IOException {
        dateTaskList.ParseAllStringOfDate(toDo.getMapToDO());
        while (!choice.equals("6")) {
            System.out.println("1.На сегодня");
            System.out.println("2.На эту неделю");
            System.out.println("3.На выбранную дату");
            System.out.println("4.Весь список");
            System.out.println("5.Cохранить список в .txt");
            System.out.println("6.Назад");
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("На сегодня:");
                    toDo.showTaskListByDate(dateTaskList.CurrentDate());
                    break;
                case "2":
                    System.out.println("На эту неделю:");
                    toDo.showDateCurrentOfWeek(dateTaskList.dateListCurrentOnTheWeek());
                    break;
                case "3":
                    System.out.println("Введите дату");
                    String date3 = in.nextLine();
                    toDo.showTaskListByDate(date3);
                    break;
                case "4":
                    System.out.println("Весь список:");
                    toDo.printTasklist();

                    break;
                case "5":
                    System.out.println("Назад");
                    break;
                case "6":
                    System.out.println("Cохранение списка дел в txt формате");
                    MyFile.saveInFileTxt(toDo.getMapToDO());
                    break;
                default:
                    System.out.println("Не корректный ввод команды");
                    MyFile.saveInFileTxt(toDo.getMapToDO());
            }
        }
    }


}
