package main;

import response.TodoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage
{
    private static  int currentId = 1;

    private static HashMap<Integer, TodoList> todoLists = new HashMap<>();
    public static List<TodoList> getAllTodoList(){

        ArrayList<TodoList> todoLists1 = new ArrayList<>();
        todoLists1.addAll(todoLists.values());
        return todoLists1;
    }

    public static int addTodoList(TodoList todoList){

        int id = currentId++;
        todoList.setId(id);
        todoLists.put(id, todoList);
        return id;
    }

    public static TodoList getTodoList(int todoListId){
        if (todoLists.containsKey(todoListId)){
            return todoLists.get(todoListId);
        }
        return null;
    }
}