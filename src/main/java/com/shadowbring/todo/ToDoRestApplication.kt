package com.shadowbring.todo

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.shadowbring.todo.domain.ToDoItem
import com.shadowbring.todo.domain.ToDoUser
import com.shadowbring.todo.repository.ToDoItemRepository
import com.shadowbring.todo.repository.ToDoUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
open class ToDoRestApplication : CommandLineRunner {

    @Autowired
    private lateinit var toDoUserRepository: ToDoUserRepository

    @Autowired
    private lateinit var toDoItemRepository: ToDoItemRepository

    @Bean
    open fun objectMapperBuilder(): Jackson2ObjectMapperBuilder
            = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())


    override fun run(vararg p0: String?) {
        val dmytro = ToDoUser(name = "Dmytro")
        val marina = ToDoUser(name = "Marina")

        val item1 = ToDoItem(description = "Call Marina", done = true, toDoUser = dmytro)
        val item2 = ToDoItem(description = "Buy flowers", done = true, toDoUser = dmytro)
        val item3 = ToDoItem(description = "Go to Boryspil", done = false, toDoUser = dmytro)
        val item4 = ToDoItem(description = "Call Dmytro", done = false, toDoUser = marina)
        val item5 = ToDoItem(description = "Buy watermelon", done = true, toDoUser = marina)
        val item6 = ToDoItem(description = "Go to Boryspil", done = true, toDoUser = marina)

        val dmytrosToDoItems = listOf(item1, item2, item3)
        toDoUserRepository.save(dmytro)
        toDoItemRepository.save(dmytrosToDoItems)

        val marinasToDoItems = listOf(item4, item5, item6)
        toDoUserRepository.save(marina)
        toDoItemRepository.save(marinasToDoItems)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(ToDoRestApplication::class.java, *args)
}