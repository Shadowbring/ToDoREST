package com.shadowbring.todo.domain

import javax.persistence.*

@Entity
@SequenceGenerator(name = "itemSequence", sequenceName = "itemSequence", allocationSize = 1)
data class ToDoItem(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequence")
        private var id: Long = 0,

        @Column(nullable = false)
        var description: String = "",

        @Column(nullable = false)
        var done: Boolean = false,

        @ManyToOne(optional = false)
        @JoinColumn(name = "toDoUserId")
        private var toDoUser: ToDoUser = ToDoUser()
)