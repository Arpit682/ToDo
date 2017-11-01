package ToDo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ToDo.entity.Task;
import ToDo.service.TaskService;;

@RestController
public class TaskController {

	@Autowired
	TaskService taskService;
	List<Task> tasks = null;

	//Load saved tasks
	@RequestMapping("/api/allTasks")
	public List<Task> getAllTasks(){
		tasks = taskService.listAllTasks();
		return this.tasks;
	}
	
	//Delete a task
	@RequestMapping(value="/api/deleteTask/{taskId}", method = RequestMethod.DELETE)
	public Boolean deleteTasks(@PathVariable("taskId") Long id){
		taskService.deleteTask(id);
		return true;
	}
	
	//Create a new task
	@RequestMapping(value="/api/newTask", method = RequestMethod.POST)
	public Task addNewTask(@RequestBody Task task){
		return taskService.createTask(task);
	}
	
	//Mark a task resolved
	@RequestMapping(value="/api/markComplete/{taskId}", method = RequestMethod.PUT)
	public Boolean markComplete(@PathVariable("taskId") Long id){
		taskService.updateTask(id);
		return true;
	}
}
