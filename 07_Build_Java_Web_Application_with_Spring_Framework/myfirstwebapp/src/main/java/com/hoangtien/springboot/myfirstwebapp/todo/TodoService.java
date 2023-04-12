package com.hoangtien.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCounts = 0;
	static {
		todos.add(new Todo(++todosCounts, "in28minutes", "Learn AWS 1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCounts, "in28minutes", "Learn DevOps 1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCounts, "in28minutes", "Learn FullStack 1", LocalDate.now().plusYears(1), false));
	}

	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCounts, username, description, targetDate, done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		// todo.getId() == id
		// todo -> todo.getId() == id (Lamda function)
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().get();
	}

	public void updateTodo(@Valid Todo todo) {		
		deleteById(todo.getId());
		todos.add(todo);
	}
}
