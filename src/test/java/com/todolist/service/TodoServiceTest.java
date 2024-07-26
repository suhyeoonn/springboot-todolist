package com.todolist.service;

import com.todolist.domain.Category;
import com.todolist.domain.Todo;
import com.todolist.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class TodoServiceTest {

    private final TodoService service = new TodoService();
    private final TodoRepository repository = new TodoRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void createTodo() {
        Todo todo = new Todo("todo", Category.STUDY);

        Long id = service.createTodo(todo);

        assertThat(todo.getId()).isEqualTo(repository.findById(id).getId());
    }

    @Test
    void findTodos() {
        Todo todo1 = new Todo("todo1", Category.STUDY);
        service.createTodo(todo1);
        Todo todo2 = new Todo("todo2", Category.HOUSEWORK);
        service.createTodo(todo2);

        List<Todo> result = service.findTodos();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void deleteTodo() {
        Todo todo1 = new Todo("todo1", Category.STUDY);
        service.createTodo(todo1);

        service.deleteTodo(todo1.getId());

        List<Todo> result = service.findTodos();
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void updateStatus() {
        Todo todo = new Todo("todo", Category.STUDY);
        service.createTodo(todo);

        service.updateStatus(todo.getId(), true);

        Todo result = repository.findById(todo.getId());
        assertThat(result.getIsDone()).isEqualTo(true);

        service.updateStatus(todo.getId(), false);
        assertThat(result.getIsDone()).isEqualTo(false);
    }
}