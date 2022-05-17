package com.project.todo.services;

import com.project.todo.entities.TodoItem;
import com.project.todo.entities.User;
import com.project.todo.repos.TodoItemRepository;
import com.project.todo.requests.TodoItemRequest;
import com.project.todo.responses.TodoItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private UserService userService;

    public List<TodoItemResponse> getAllTodoItems(Optional<Long> userId) { // tüm userları getirmek için kullanıcaz
        List<TodoItem> list;
        if(userId.isPresent()){
            list = todoItemRepository.findUserTodoItemById(userId.get());
        }else{
            list = todoItemRepository.findAll();
        }
        return list.stream().map(todoItem -> new TodoItemResponse(todoItem)).collect(Collectors.toList());
    }

    public TodoItem createOneTodoItem(TodoItemRequest todoItemRequest) {
        User user = userService.getUserById(todoItemRequest.getUserId());
        if(user == null){
            return null;
        }else {
            TodoItem newTodoItem = new TodoItem();
            newTodoItem.setId(todoItemRequest.getId());
            newTodoItem.setTitle(todoItemRequest.getTitle());
            newTodoItem.setDone(todoItemRequest.getDone());
            newTodoItem.setUser(user);
            return todoItemRepository.save(newTodoItem);
        }

    }

    public TodoItem updateTodoItem(Long todoItemId, TodoItem newTodoItem) { // user güncellemek için kullanıcaz
        Optional<TodoItem> todoitem = todoItemRepository.findById(todoItemId);
        if(todoitem.isPresent()){ // user var mı yok mu kontrolü burada yapılıyor.
            TodoItem foundTodoItem = todoitem.get();
            foundTodoItem.setTitle(newTodoItem.getTitle());
            todoItemRepository.save(foundTodoItem);
            return foundTodoItem;
        }else {
            return null;
        }
    }

    public void deleteTodoItemById(Long id){
        todoItemRepository.deleteById(id);
    }

}
