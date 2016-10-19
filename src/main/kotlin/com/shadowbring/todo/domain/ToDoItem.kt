package com.shadowbring.todo.domain

import javax.persistence.*

@Entity
@SequenceGenerator(name = "itemSequence", sequenceName = "itemSequence", allocationSize = 1)
data class ToDoItem(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequence")
        var id: Long = 0,

        var description: String = "",
        var done: Boolean = false,

        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        @JoinColumn(name = "toDoUserId")
        var toDoUser: ToDoUser = ToDoUser()
)