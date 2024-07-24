package com.todolist.controller;

import com.todolist.domain.Category;
import com.todolist.domain.Todo;
import com.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {
    private final TodoService service = new TodoService();

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("todos", service.findTodos());

        return "todo/list";
    }

    @PostMapping("/todos/new")
    public String createTodo(TodoCreateForm form) {
        Todo todo = new Todo(form.getContent(), Category.valueOf(form.getCategory()));
        service.createTodo(todo);
        return "redirect:/";
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        service.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

}
