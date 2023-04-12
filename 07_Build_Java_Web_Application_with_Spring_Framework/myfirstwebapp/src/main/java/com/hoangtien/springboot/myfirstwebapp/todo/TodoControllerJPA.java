package com.hoangtien.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoControllerJPA {	
	private TodoRepository todoRepository;

	public TodoControllerJPA(TodoRepository todoRepository) {
		super();	
		this.todoRepository = todoRepository;
	}
		

	// list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		String username = getLoggedInUsername(model);		
		List<Todo> todos = todoRepository.findByUsername(username);
		model.put("todos", todos);
		return "listTodos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	// GET
	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);		
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	// POST
	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}		
		todo.setUsername(getLoggedInUsername(model));
		todoRepository.save(todo);
		
//		todoService.addTodo(getLoggedInUsername(model), todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}

	// delete-todo
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//Delete todo
		todoRepository.deleteById(id);
		return "redirect:list-todos";		
	}
	
	//update-todo
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {				
		Todo todo = todoRepository.findById(id).get();
		model.put("todo", todo);
		return "todo";		
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
}
