package ToDo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ToDo.entity.Task;
import ToDo.entity.TaskRepository;

@RestController
public class TaskController {

	List<Task> tasks = null;
	@Autowired
	TaskRepository repository;
	//Load saved tasks
	@RequestMapping("/api/allTasks")
	public List<Task> getAllTasks(){
		tasks = repository.findAll();
		return this.tasks;
	}
	
	//Delete a task
	@RequestMapping(value="/api/deleteTask/{taskId}", method = RequestMethod.DELETE)
	public List<Task> deleteTasks(@PathVariable("taskId") Long id){
		repository.delete(id);
		tasks = repository.findAll();
		return this.tasks;
	}
	
	//Create a new task
	@RequestMapping(value="/api/newTask", method = RequestMethod.POST)
	public List<Task> addNewTask(@RequestBody Task task){
		repository.save(new Task(task.getTaskDescription(), "Pending"));
		tasks = repository.findAll();
		return this.tasks;
	}

   
 
}
