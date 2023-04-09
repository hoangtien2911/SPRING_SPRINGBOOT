package com.hoangtien.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("in28minutes");
		model.put("todos", todos);
		return "listTodos";
	}

	// GET
	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		return "todo";
	}

	// GET
	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model) {		
		return "redirect:list-todos";
	}
}
