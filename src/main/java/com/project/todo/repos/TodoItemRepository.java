package com.project.todo.repos;

import com.project.todo.entities.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

    List<TodoItem> findByUserId(Long userId);

    @Query(value = "select id from todo_item where user_id = :userId", nativeQuery = true)
    List<TodoItem> findUserTodoItemById(@Param("userId")Long id);

}
