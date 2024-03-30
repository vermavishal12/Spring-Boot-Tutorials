package com.example.todocrud.services;

import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoServices {

    @Autowired
     UserServices userServices;
    @Autowired
    ToDoRepository toDoRepository;
    @Autowired
     UserRepository userRepository;

    public Todo getTodoById(Long todoId){
        return toDoRepository.findById(todoId).get();
    }

    public void addTodo(Long userId, Todo todo){
    	Users user = userServices.getUserById(userId);
    	List<Todo> todoList = user.getTodoList();
    	todoList.add(todo);
    	user.setTodoList(todoList);
    	userServices.updateUser(user);
        toDoRepository.save(todo);
    }
    public void deleteTodo(Long userId,Long todoId){
    	Users user = userServices.getUserById(userId);
    	List<Todo> toDoList = user.getTodoList();
    	Todo todo = getTodoById(todoId);
    	toDoList.remove(todo);
    	toDoRepository.delete(todo);
    	user.setTodoList(toDoList);
    	userServices.updateUser(user);
    }

    public void toggleTodoCompleted(Long todoId){
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
    	toDoRepository.save(todo);
    }

}
