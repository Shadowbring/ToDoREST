package com.shadowbring.todo.repository

import com.shadowbring.todo.domain.ToDoItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ToDoItemRepository : JpaRepository<ToDoItem, Long> {

}