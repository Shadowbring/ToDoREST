package com.shadowbring.todo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "id")
@SequenceGenerator(name = "itemSequence", sequenceName = "itemSequence", allocationSize = 1)
public class ToDoItem {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequence")
  private Long id;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private Boolean done;

  @ManyToOne(optional = false)
  @JoinColumn(name = "toDoUserId")
  private ToDoUser toDoUser;
}
