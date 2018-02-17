/**
 * 
 */
package com.todo.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todo.app.entity.TodoItem;

/**
 * @author A0747449
 *
 */
@Repository
public interface TodoRepository extends CrudRepository<TodoItem, Long> {

}
