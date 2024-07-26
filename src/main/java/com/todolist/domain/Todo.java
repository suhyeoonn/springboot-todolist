package com.todolist.domain;

public class Todo {
    private Long id;
    private String content;
    private Category category;
    private boolean isDone;

    public Todo(String content, Category category) {
        this.content = content;
        this.category = category;
        this.isDone = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setDone(boolean status) {
        isDone = status;
    }
}
