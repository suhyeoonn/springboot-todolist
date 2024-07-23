package com.todolist.controller;

import com.todolist.domain.Category;
import com.todolist.domain.Todo;
import com.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
    private final TodoService service = new TodoService();

    @GetMapping("/")
    public String list(Model model) {
        // 등록 기능 구현 후 제거 예정
        service.createTodo(new Todo("todo1", Category.STUDY));
        service.createTodo(new Todo("todo2", Category.HOUSEWORK));

        model.addAttribute("todos", service.findTodos());

        return "todo/list";
    }
}
