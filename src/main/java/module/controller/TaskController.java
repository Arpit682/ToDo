package module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import module.entity.Task;
import module.service.TaskService;;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
    List<Task> tasks = null;

    /**
     * Returns all the tasks from the database
     * @return list of Task entity
     */
    @RequestMapping("/api/allTasks")
    public List<Task> getAllTasks(){
        tasks = taskService.listAllTasks();
        return this.tasks;
    }

    /**
     * Delete a task based on the Id
     * @param Id of the task to be deleted
     */
    @RequestMapping(value="/api/deleteTask/{id}", method = RequestMethod.DELETE)
    public Boolean deleteTasks(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return true;
    }

    /**
     * Add a new task
     * @param Task object to be saved
     * @return Return the saved task
     */
    @RequestMapping(value="/api/newTask", method = RequestMethod.POST)
    public Task addNewTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    /**
     * Mark the task completed
     * @param Id of the task to be updated
     */
    @RequestMapping(value="/api/markComplete/{id}", method = RequestMethod.PUT)
    public Task markComplete(@PathVariable("id") Long id){
        return taskService.updateTask(id);
    }
}
