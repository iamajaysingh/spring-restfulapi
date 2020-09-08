package com.dev.quack.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@Autowired
	MessageSource messageSource;

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
	public ResponseEntity<Object> saveTodo(@Valid @RequestBody Todo todo) {

		Todo savedtodo = todoService.save(todo);
		//to sent uri location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedtodo.getId())
				.toUri();
		
		//Resource<Todo> resource = new  Resource<Todo>();
	//	EntityModel<Integer> resource = EntityModel.of(savedtodo.getId());
		//@SuppressWarnings("deprecation")
		//ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUserTodoList());
		//resource.add(linkTo.withRel("todo-list"));
		
		return  ResponseEntity.created(location).build();
	}
	
	@GetMapping("/get-title")
	public String  getMessages() {

		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
		
	}
	
}
