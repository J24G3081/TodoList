package com.example.demo;

public class Todo {
    private String title;
    private boolean completed;
    private int progress;


    public Todo(String title) {
        this.title = title;
        this.completed = false;
        this.progress = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}