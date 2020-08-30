package com.dev.quack.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.quack.exception.TaskNotFound;
import com.dev.quack.models.Todo;
import com.dev.quack.services.TodoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("tst")
public class TodoResourceController {
	@Autowired
	TodoService todoService;

	@GetMapping("/todo-list")
	public List<Todo> getUserTodoList() {

		List<Todo>  todo =todoService.findAll();
		if(todo.isEmpty()) {
			
			throw new TaskNotFound("No task has created yet");
		}
		
		return todo;
		

	}

	@GetMapping("todo/{id}")
	public Todo gettodo(@PathVariable int id) {
		
		Todo t1=todoService.findOne(id);
		if (t1 == null) {
			throw new TaskNotFound("id:-" + id);
		}
		return t1;
	}

	

	@PostMapping("/todo")
	public ResponseEntity<Object> saveTodo(@RequestBody Todo todo) {

		Todo savedtodo = todoService.save(todo);
		//to sent url location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedtodo.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
