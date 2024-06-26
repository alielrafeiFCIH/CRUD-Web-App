package com.ali.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;
    static{
        todos.add(new Todo(++todoCount, "ali", "Learn Machine Learning", 
        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "ali", "Learn Deep Learning", 
        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "ali", "Learn Statisitcs", 
        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "ali", "Learn Linear Algebra", 
        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "ali", "Graphs", 
        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "ali", "Dynamic Programming", 
        LocalDate.now().plusYears(1), false));
    }
    public List<Todo> findByUserName(String username){
        return todos;
    }
    public void addTodo(String name , String description ,LocalDate targDate, boolean done){
        Todo todo = new Todo(++todoCount, name, description, targDate, done);
        todos.add(todo);
        
    }
    public void deleteTodo(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
        
    }
    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public void UpdateTodoItem(Todo todo) {
      deleteTodo(todo.getId());
      todos.add(todo);
    }
}