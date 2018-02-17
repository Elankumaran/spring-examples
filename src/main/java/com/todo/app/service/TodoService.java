/**
 * 
 */
package com.todo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.dao.TodoRepository;
import com.todo.app.entity.TodoItem;

/**
 * @author A0747449
 *
 */
@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	/**
	 * 
	 */
	public TodoService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param todoId
	 * @return
	 */
	public TodoItem getTodo(long todoId) {
		return this.todoRepository.findOne(todoId);
	}

	/**
	 * 
	 * @return
	 */
	public Iterable<TodoItem> getTodos() {
		return this.todoRepository.findAll();
	}

	/**
	 * 
	 * @param todoItem
	 * @return
	 */
	public TodoItem createTodo(TodoItem todoItem) {
		return this.todoRepository.save(todoItem);
	}

	/**
	 * 
	 * @param todoItem
	 * @return
	 */
	public TodoItem updateTodo(TodoItem todoItem) {
		return this.todoRepository.save(todoItem);
	}

	/**
	 * 
	 * @param todoId
	 */
	public void deleteTodo(long todoId) {
		this.todoRepository.delete(todoId);
	}
}
