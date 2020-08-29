package com.dev.quack.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.quack.models.Todo;
import com.dev.quack.repository.TodoRepo;

@Service
public class TodoService {
	private static List<Todo> todoList = new ArrayList<Todo>();
	private static int countTodo = 0;

	static {

		todoList.add(new Todo(countTodo++, "ajay", " To Learn Java", new Date(), false, true));
		todoList.add(new Todo(countTodo++, "ajay", " To Learn Spring Boot", new Date(), false, true));
		todoList.add(new Todo(countTodo++, "ajay", " To Learn Oracle Database", new Date(), false, true));
		todoList.add(new Todo(countTodo++, "ajay", " To Learn AWS developer", new Date(), false, true));
		todoList.add(new Todo(countTodo++, "ajay", " To Learn Angular7", new Date(), false, true));
	}

	public List<Todo> findAll() {
		return todoList;
	}

	public Todo save(Todo todo) {
		System.out.println(todo);
		if (todo.getId() == 0) {
			todo.setId(countTodo++);
		}
		todoList.add(todo);
		return todo;
	}

	public Todo findOne(int id) {

		for (Todo t1 : todoList) {
			if (t1.getId() == id) {
				return t1;
			}}
		return null;

	}

}
