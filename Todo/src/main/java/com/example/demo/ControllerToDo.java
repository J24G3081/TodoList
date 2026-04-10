package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerToDo {
    private List<Todo> todolist = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todolist);
        
        long total = todolist.size();
        long completedCount = todolist.stream().filter(Todo::isCompleted).count();
        int totalRate = (total == 0) ? 0 : (int) ((double) completedCount / total * 100);
        
        model.addAttribute("totalRate", totalRate);
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title) {
        if(!title.isEmpty()) todolist.add(new Todo(title));
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int index) {
        todolist.remove(index);
        return "redirect:/";
    }

    @PostMapping("/toggle")
    public String toggle(@RequestParam int index) {
        Todo todo = todolist.get(index);
        todo.setCompleted(!todo.isCompleted());
        return "redirect:/";
    }

    @PostMapping("/updateProgress")
    public String updateProgress(@RequestParam int index, @RequestParam int progress) {
        Todo todo = todolist.get(index);
        todo.setProgress(progress);
        todo.setCompleted(progress == 100);
        return "redirect:/";
    }
}