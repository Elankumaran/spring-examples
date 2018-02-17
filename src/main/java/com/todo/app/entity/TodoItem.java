/**
 * 
 */
package com.todo.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author A0747449
 *
 */
@Entity
public class TodoItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5272584566524046571L;
	@Id
	@GeneratedValue
	private long todoId;
	private String taskName;
	private boolean completed;

	/**
	 * 
	 */
	public TodoItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the todoId
	 */
	public long getTodoId() {
		return todoId;
	}

	/**
	 * @param todoId
	 *            the todoId to set
	 */
	public void setTodoId(long todoId) {
		this.todoId = todoId;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName
	 *            the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * @param completed
	 *            the completed to set
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
