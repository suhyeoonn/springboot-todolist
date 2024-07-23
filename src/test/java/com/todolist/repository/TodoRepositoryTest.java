package com.todolist.repository;

import com.todolist.domain.Category;
import com.todolist.domain.Todo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class TodoRepositoryTest {
    private final TodoRepository repository = new TodoRepository();

    @Test
    void save() {
        Todo todo = new Todo("todo", Category.STUDY);

        repository.save(todo);

        Todo result = repository.findById(todo.getId());
        assertThat(todo).isEqualTo(result);
    }

    @Test
    void findAll() {
        Todo todo1 = new Todo("todo1", Category.STUDY);
        repository.save(todo1);
        Todo todo2 = new Todo("todo2", Category.HOUSEWORK);
        repository.save(todo2);

        List<Todo> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }
}