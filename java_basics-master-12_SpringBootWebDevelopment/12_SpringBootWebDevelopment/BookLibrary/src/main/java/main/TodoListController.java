package main;

import model.TodoListRepository;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import model.TodoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoListController
{
    @Autowired
    private TodoListRepository todoListRepository;

    @GetMapping("/todolist/")
    public List<TodoList> todoList(){

       Iterable<TodoList> todoListIterable = todoListRepository.findAll();
        ArrayList<TodoList> todoLists = new ArrayList<>();
        for (TodoList todoList : todoListIterable){
            todoLists.add(todoList);
        }
        return todoLists;
    }

    @PostMapping("/todolist/")
    public int add(TodoList todoList){
        TodoList newTodoList = todoListRepository.save(todoList);
        return  newTodoList.getId();
    }

    @DeleteMapping("/todolist/{id}")
    public ResponseEntity deleteById(int id){
        Optional<TodoList> optionalTodoList = todoListRepository.findById(id);
        if (!optionalTodoList.isPresent()){
            System.out.println("TodoList is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todoListRepository.delete(todoList().get(id));
        return new ResponseEntity(optionalTodoList.get(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/todolist/")
    public TodoList deleteAll(TodoList todoList){
        if (todoList != null) {
            todoListRepository.deleteAll();
        }
        System.out.println("TodoList is cleaned up");
        return todoList;
    }

    @PutMapping("/todolist/")
    public ResponseEntity updateList(@PathVariable int id, TodoList todoList){
        TodoList newTodoList = (TodoList) todoListRepository.findAll();
        todoListRepository.save(todoList);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/todolist/{id}")
    public ResponseEntity get(@PathVariable int id){

        Optional<TodoList> optionalTodoList = todoListRepository.findById(id);
        if (!optionalTodoList.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTodoList.get(), HttpStatus.OK);
    }
}