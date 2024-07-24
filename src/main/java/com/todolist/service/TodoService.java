package com.todolist.service;

import com.todolist.domain.Todo;
import com.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository = new TodoRepository();

    public Long createTodo(Todo todo) {
        repository.save(todo);
        return todo.getId();
    }

    public List<Todo> findTodos() {
        return repository.findAll();
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}
