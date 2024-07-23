package com.todolist.domain;

public class Todo {
    private Long id;
    private String content;
    private Category category;

    public Todo(String content, Category category) {
        this.content = content;
        this.category = category;
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
}
