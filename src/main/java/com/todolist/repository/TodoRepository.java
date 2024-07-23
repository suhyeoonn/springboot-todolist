package com.todolist.repository;

import com.todolist.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepository {
    private static Map<Long, Todo> store = new HashMap<>();
    private static long sequence = 0L;

    public Todo save(Todo todo) {
        todo.setId(++sequence);
        store.put(todo.getId(), todo);
        return todo;
    }

    public Todo findById(Long id) {
        return store.get(id);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }
}
