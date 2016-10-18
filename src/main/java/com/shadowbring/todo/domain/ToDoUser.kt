package com.shadowbring.todo.domain

import java.util.*
import javax.persistence.*

@Entity
@SequenceGenerator(name = "userSequence", sequenceName = "userSequence", allocationSize = 1)
data class ToDoUser(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
        private var id: Long = 0,

        @Column(nullable = false)
        private var name: String = "",

        @OneToMany(mappedBy = "toDoUser")
        private var toDoItems: List<ToDoItem> = ArrayList()
)