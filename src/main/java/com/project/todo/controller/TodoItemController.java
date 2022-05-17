package com.project.todo.controller;

import com.project.todo.entities.TodoItem;
import com.project.todo.requests.TodoItemRequest;
import com.project.todo.responses.TodoItemResponse;
import com.project.todo.services.TodoItemService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todoitem")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping()
    public List<TodoItemResponse> getAllTodoItem(@Validated @NotNull @PathVariable Optional<Long> userId){ //user id'yi postman'da nasıl göndericem acaba?????
        return todoItemService.getAllTodoItems(userId);
    }

    // user nesnesini boş olarak algılıyor. O yüzden hata alıp nesne gönderemiyoruz.
    @PostMapping
    public TodoItem createTodoItem(@Validated @NotNull @RequestBody TodoItemRequest todoItemRequest){ // todoitem eklerken user_id'yi nasıl göndericez bence hata ondan kaynaklı
        return todoItemService.createOneTodoItem(todoItemRequest);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@Validated @NotNull @PathVariable Long id,@Validated @NotNull @RequestBody TodoItem todoItem){
        return todoItemService.updateTodoItem(id, todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable Long id){
        todoItemService.deleteTodoItemById(id);
    }


}
