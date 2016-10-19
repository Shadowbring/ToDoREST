package com.shadowbring.todo.domain

import java.util.*
import javax.persistence.*

@Entity
@SequenceGenerator(name = "userSequence", sequenceName = "userSequence", allocationSize = 1)
data class ToDoUser(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
        var id: Long = 0,

        var name: String = "",

        @OneToMany(mappedBy = "toDoUser", fetch = FetchType.EAGER)
        var toDoItems: List<ToDoItem> = ArrayList()
)