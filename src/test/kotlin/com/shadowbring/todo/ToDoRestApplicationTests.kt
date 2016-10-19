package com.shadowbring.todo

import com.shadowbring.todo.repository.ToDoItemRepository
import com.shadowbring.todo.repository.ToDoUserRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ToDoRestApplicationTests {

    @Autowired
    private lateinit var toDoItemRepository: ToDoItemRepository

    @Autowired
    private lateinit var toDoUserRepository: ToDoUserRepository

    @Test
    fun testInitialDataLoaded() {
        assertEquals("Total amount of ToDoItems must be equal to 6", 6, toDoItemRepository.findAll().size)
        assertEquals("Total amount of ToDoUsers must be equal to 2", 2, toDoUserRepository.findAll().size)
        assertEquals("Total amount of Dmytro's ToDoItems must be equal to 3", 3,
                toDoUserRepository.findOne(1L).toDoItems.size)
        assertEquals("Total amount of Marina's ToDoItems must be equal to 3", 3,
                toDoUserRepository.findOne(2L).toDoItems.size)
    }

    @Test
    fun testFindByDone() {
        assertEquals("Total amount of done ToDoItems must be equal to 4", 4,
                toDoItemRepository.findByDone(true).size)
        assertEquals("Total amount of undone ToDoItems must be equal to 2", 2,
                toDoItemRepository.findByDone(false).size)
    }
}