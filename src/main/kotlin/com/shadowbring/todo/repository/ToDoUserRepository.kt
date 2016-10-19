package com.shadowbring.todo.repository

import com.shadowbring.todo.domain.ToDoUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ToDoUserRepository : JpaRepository<ToDoUser, Long> {
}
