package com.todolist.service;

import com.todolist.domain.Category;
import com.todolist.domain.Todo;
import com.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class TodoServiceTest {

    private final TodoService service = new TodoService();
    private final TodoRepository repository = new TodoRepository();

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
}