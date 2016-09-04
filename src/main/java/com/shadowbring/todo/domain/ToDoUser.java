package com.shadowbring.todo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "id")
@SequenceGenerator(name = "userSequence", sequenceName = "userSequence", allocationSize = 1)
public class ToDoUser {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "toDoUser")
  private List<ToDoItem> toDoItems;
}
