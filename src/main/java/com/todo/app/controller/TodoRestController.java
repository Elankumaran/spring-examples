/**
 * 
 */
package com.todo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.entity.TodoItem;
import com.todo.app.service.TodoService;

/**
 * @author A0747449
 *
 */
@RestController
@RequestMapping("/api/todo")
public class TodoRestController {

	@Autowired
	private TodoService todoService;

	/**
	 * 
	 */
	public TodoRestController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Iterable<TodoItem> getTodos() {
		return this.todoService.getTodos();
	}

	/**
	 * 
	 * @param todoId
	 * @return
	 */
	@RequestMapping(value = "{todoId}", method = RequestMethod.GET)
	public TodoItem getTodo(@PathVariable long todoId) {
		return this.todoService.getTodo(todoId);
	}

	/**
	 * 
	 * @param todoItem
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public TodoItem createTodo(@RequestBody TodoItem todoItem) {
		return this.todoService.createTodo(todoItem);
	}

	/**
	 * 
	 * @param todoItem
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public TodoItem updateTodo(@RequestBody TodoItem todoItem) {
		return this.todoService.updateTodo(todoItem);
	}

	/**
	 * 
	 * @param todoId
	 */
	@RequestMapping(value = "{todoId}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable long todoId) {
		this.todoService.deleteTodo(todoId);
	}
}
