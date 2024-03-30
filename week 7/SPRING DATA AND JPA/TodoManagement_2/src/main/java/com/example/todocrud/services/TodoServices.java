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
       return toDoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
    }

    public void addTodo(Long userId, Todo todo){
        List<Todo> todoList = new ArrayList<>();
        Users user = userServices.getUserById(userId);
        todoList.add(todo);
        user.setTodoList(todoList);
        toDoRepository.save(todo);
        userRepository.save(user);
    }
    public void deleteTodo(Long userId,Long todoId){
        Todo removedTodo = new Todo();
        Users user = userServices.getUserById(userId);
        Todo todo = this.getTodoById(todoId);
        for(int i = 0 ; i < user.getTodoList().size() ; i++){
            if(user.getTodoList().get(i).getId() == todo.getId()){
                removedTodo  = user.getTodoList().remove(i);
            }
        }
        System.out.println("removed todo -> " + removedTodo.getId() + " | " + removedTodo.getContent());
        userRepository.save(user);
        toDoRepository.deleteById(todoId);
    }

    public void toggleTodoCompleted(Long todoId){
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }


    public void updateTodo(Todo todo) {
        if(toDoRepository.existsById(todo.getId())){
            toDoRepository.save(todo);
        }
        else{
            throw new RuntimeException("Todo Not found");
        }
    }
}
