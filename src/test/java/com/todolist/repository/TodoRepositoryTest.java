package com.todolist.repository;

import com.todolist.domain.Category;
import com.todolist.domain.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TodoRepositoryTest {
    private final TodoRepository repository = new TodoRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

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

    @Test
    void deleteById() {
        Todo todo1 = new Todo("todo1", Category.STUDY);
        repository.save(todo1);

        repository.deleteById(todo1.getId());

        List<Todo> result = repository.findAll();
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void updateStatus() {
        Todo todo = new Todo("todo1", Category.STUDY);
        repository.save(todo);

        repository.updateStatus(todo.getId(), true);
        assertThat(todo.getIsDone()).isEqualTo(true);

        repository.updateStatus(todo.getId(), false);
        assertThat(todo.getIsDone()).isEqualTo(false);
    }
}