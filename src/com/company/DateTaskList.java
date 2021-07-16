package com.company;




import com.exception.IncorrectFormatDateException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTaskList {


    private ArrayList<LocalDate> listDate = new ArrayList<>();

    public ArrayList<LocalDate> getListDate() {
        return listDate;
    }


    public void setListDate(ArrayList<LocalDate> listDate) {
        this.listDate = listDate;
    }

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final String text = dtf.format(LocalDateTime.now());
    private LocalDate currentDate = LocalDate.now();



    public String inPutDate() {
        String str;
        Scanner in = new Scanner(System.in);
        try {
            str = in.nextLine();
            LocalDate.parse(str, dtf);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Повторно введите дату в формате: dd/MM/yyyy");
            return inPutDate();

        }

    }

    public void ParseAllStringOfDate(Map<String,List<Task>> map) {
        for (String x : map.keySet()) {
            listDate.add(LocalDate.parse(x, dtf));
        }

    }

    public String CurrentDate() {
        for (LocalDate x : listDate) {
            if (currentDate.equals(x)) {
                return dtf.format(x);
            }
        }
        return "null";
    }

    public int beginOfTheWeek() {
        return currentDate.getDayOfMonth() - (currentDate.getDayOfWeek().getValue() - 1);
    }


    ArrayList<String> strDate = new ArrayList<>();

    public ArrayList<String> dateListCurrentOnTheWeek(){
        for (LocalDate x : listDate) {
            if (x.getMonth().equals(currentDate.getMonth())&&x.getDayOfMonth() >= beginOfTheWeek()&& x.getDayOfMonth() < (beginOfTheWeek()+7)) {
                strDate.add(dtf.format(x));
            }
        }
        return strDate;

    }

    }













