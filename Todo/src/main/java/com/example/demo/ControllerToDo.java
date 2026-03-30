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
		
		model.addAttribute("todos" , todolist);
		return "index";
	}
	@PostMapping("/add")
	public String add(@RequestParam String title) {
		todolist.add(new Todo(title));
		return"redirect:/";
	}
	@PostMapping("/delete")
	public String delete(@RequestParam int index) {
		todolist.remove(index);
		return"redirect:/";
	}
}
