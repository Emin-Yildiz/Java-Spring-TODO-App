package com.project.todo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "todo_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private boolean done;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // user silindiği zaman bütün todoitem'lar silinecek.
    @JsonIgnore//@JsonIgnore anotasyonu user ile ilgili bilgilerin bize gelmesini engeller.
    private User user;
}
