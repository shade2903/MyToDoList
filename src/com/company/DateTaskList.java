package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTaskList {

    private ArrayList<LocalDate> listDate;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final String text = dtf.format(LocalDateTime.now());
    private LocalDate currentDate = LocalDate.now();

    public DateTaskList(){
        listDate = new ArrayList<>();
    }

    public String inPutDate() {
        String str;
        Scanner in = new Scanner(System.in);
        try {
            str = in.nextLine();
            LocalDate.parse(str, dtf);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Repeat enter date in format: dd/MM/yyyy");
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

    private LocalDate beginOfTheWeek() {
        return currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1);
    }
    private  LocalDate endOfWeek(){
        return beginOfTheWeek().plusDays(6);
    }

    ArrayList<String> strDate = new ArrayList<>();

    public ArrayList<String> dateListCurrentOnTheWeek(){
        for (LocalDate x : listDate) {
            if (x.isAfter(beginOfTheWeek().minusDays(1))&&x.isBefore(endOfWeek().plusDays(1))) {
                strDate.add(dtf.format(x));
            }
        }
        return strDate;
    }

    }













