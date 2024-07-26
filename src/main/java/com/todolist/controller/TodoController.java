package com.todolist.controller;

import com.todolist.domain.Category;
import com.todolist.domain.Todo;
import com.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PatchMapping("/todos/{id}")
    public ResponseEntity<Void> updateTodo(@PathVariable("id") Long id, @RequestBody Map<String, Object> body) {
        if (!body.containsKey("isDone")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        service.updateStatus(id, (Boolean) body.get("isDone"));
        System.out.println(service.findTodos().get(0).getIsDone()); // test
        return ResponseEntity.noContent().build();
    }

}
