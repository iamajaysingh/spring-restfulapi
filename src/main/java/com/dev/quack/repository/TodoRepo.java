package com.dev.quack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.quack.models.Todo;

@Repository
public interface TodoRepo extends CrudRepository<Todo,Long> {
}
