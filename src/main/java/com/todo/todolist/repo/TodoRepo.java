package com.todo.todolist.repo;

import com.todo.todolist.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<TodoItem, Long> {
}
