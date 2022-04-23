package com.todo.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "todoitem")
@Getter //Getter metodlarını yazmamıza gerke kalmadan getter anotasyonu ile hallettik.
@Setter //Setter motedlarını yazmamıza gerek kalmadan setter anotasyonu ile hallettik.
@NoArgsConstructor //Boş constructor oluşturdu.
@AllArgsConstructor //Class içindeki bütün class değişkenlerini kullanarak bir constructor oluşturdu.
public class TodoItem {

    @Id //veri tabanında hangi değişkenin pk olduğunu belirttiğimiz anotasyon
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Id'nin id'sini otomatik olarak vermemizi sağlıyan anotasyon
    private Long id;

    @Column(name = "title") // Veri tabanında todoitem tablosunda bu değişken hnagi column'a karşılık geliyor bunu belirttiğimiz anotasyon
    private String title;

    @Column(name = "done")
    private boolean done;

}
