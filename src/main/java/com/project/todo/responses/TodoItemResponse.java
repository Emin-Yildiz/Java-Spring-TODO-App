package com.project.todo.responses;

import com.project.todo.entities.TodoItem;
import lombok.Data;

@Data
public class TodoItemResponse {

    Long id;
    String title;
    Boolean done;
    Long userId;
    String userName;

    public TodoItemResponse(TodoItem todoItem) {
        this.id = todoItem.getId();
        this.title = todoItem.getTitle();
        this.done = todoItem.isDone();
        this.userId = todoItem.getUser().getId();
        this.userName = todoItem.getUser().getUserName();
    }

}
