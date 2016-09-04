package com.shadowbring.todo;

import com.shadowbring.todo.domain.ToDoItem;
import com.shadowbring.todo.domain.ToDoUser;
import com.shadowbring.todo.repository.ToDoItemRepository;
import com.shadowbring.todo.repository.ToDoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ToDoRestApplication implements CommandLineRunner {

  @Autowired
  private ToDoUserRepository toDoUserRepository;

  @Autowired
  private ToDoItemRepository toDoItemRepository;

  public static void main(String[] args) {
    SpringApplication.run(ToDoRestApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    ToDoUser dmytro = new ToDoUser();
    ToDoUser marina = new ToDoUser();

    ToDoItem item1 = new ToDoItem();
    ToDoItem item2 = new ToDoItem();
    ToDoItem item3 = new ToDoItem();
    ToDoItem item4 = new ToDoItem();
    ToDoItem item5 = new ToDoItem();
    ToDoItem item6 = new ToDoItem();

    dmytro.setName("Dmytro");
    marina.setName("Marina");

    item1.setDescription("Call Marina");
    item1.setDone(true);
    item1.setToDoUser(dmytro);

    item2.setDescription("Buy flowers");
    item2.setDone(true);
    item2.setToDoUser(dmytro);

    item3.setDescription("Go to Boryspil");
    item3.setDone(false);
    item3.setToDoUser(dmytro);

    item4.setDescription("Call Dmytro");
    item4.setDone(false);
    item4.setToDoUser(marina);

    item5.setDescription("Buy watermelon");
    item5.setDone(true);
    item5.setToDoUser(marina);

    item6.setDescription("Go to Boryspil");
    item6.setDone(true);
    item6.setToDoUser(marina);

    List<ToDoItem> dmytrosToDoItems = Arrays.asList(item1, item2, item3);
    dmytro.setToDoItems(dmytrosToDoItems);
    toDoUserRepository.save(dmytro);
    toDoItemRepository.save(dmytrosToDoItems);

    List<ToDoItem> marinasToDoItems = Arrays.asList(item4, item5, item6);
    marina.setToDoItems(marinasToDoItems);
    toDoUserRepository.save(marina);
    toDoItemRepository.save(marinasToDoItems);
  }
}
