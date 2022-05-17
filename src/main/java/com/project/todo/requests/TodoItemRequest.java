package com.project.todo.requests;

import lombok.Data;

@Data
public class TodoItemRequest {
    Long id;
    String title;
    Boolean done;
    Long userId;
}
