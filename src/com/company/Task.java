package com.company;

import java.io.Serializable;

public class Task implements Serializable {
   private String task;
    private Status status;
    public  Task(String task){
        this.task = task;
        this.status = Status.UNCOMPLETED;
    }

    @Override
    public String toString() {
        return ""+ task +":("+ status+")";
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
