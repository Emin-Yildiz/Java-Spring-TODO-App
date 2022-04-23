package com.todo.todolist.controller;

import com.sun.istack.NotNull;
import com.todo.todolist.model.TodoItem;
import com.todo.todolist.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    
    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> showAllTodo(){
        return todoRepo.findAll();
    }

    @PostMapping
    public TodoItem addToDo(@Validated @NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @PutMapping
    public TodoItem updateToDo(@Validated @NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteToDo(@PathVariable Long id){
        todoRepo.deleteById(id);
    }
}
