/**
 * 
 */
package com.todo.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.todo.app.entity.TodoItem;
import com.todo.app.service.TodoService;

/**
 * @author A0747449
 *
 */
@Controller
@RequestMapping("/web/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	/**
	 * 
	 */
	public TodoController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showDashBoard(Model model) {
		Iterable<TodoItem> todos = this.todoService.getTodos();
		model.addAttribute("todos", todos);

		return "dashboard";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RedirectView createTodo(HttpServletRequest request) {
		String taskName = request.getParameter("taskName");

		TodoItem todoItem = new TodoItem();
		todoItem.setTaskName(taskName);
		todoItem.setCompleted(false);

		this.todoService.createTodo(todoItem);

		return new RedirectView("/web/todo/", true);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RedirectView updateTodo(HttpServletRequest request) {

		String todoId = request.getParameter("todoId");
		String deleteFlag = request.getParameter("deleteFlag");
		String taskName = request.getParameter("taskName");
		String completed = request.getParameter("completed");

		if (Boolean.valueOf(deleteFlag)) {
			this.todoService.deleteTodo(Long.valueOf(todoId));
		} else if (Boolean.valueOf(completed)) {
			TodoItem todoItem = this.todoService.getTodo(Long.valueOf(todoId));
			todoItem.setCompleted(Boolean.valueOf(completed));

			this.todoService.updateTodo(todoItem);
		} else {
			TodoItem todoItem = this.todoService.getTodo(Long.valueOf(todoId));
			todoItem.setTaskName(taskName);
			this.todoService.updateTodo(todoItem);
		}

		return new RedirectView("/web/todo/", true);
	}

}
