package module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import module.entity.Task;
import module.repository.TaskRepository;

@Repository
public class TaskService {

    @Autowired
    TaskRepository repository;

    public List<Task> listAllTasks() {
        return repository.findAll();
    }

    public Boolean deleteTask(Long id) {
        repository.delete(id);
        return true;
    }

    public Task createTask(Task task) {
        return repository.save(new Task(task.getTaskDescription(), "Pending"));
    }

    public void updateTask(Long id) {
        Task t = repository.findOne(id);
        t.setTaskStatus("Completed");
        repository.save(t);
    }
}
