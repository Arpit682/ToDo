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

    final String STATUS_PENDING = "Pending";
    final String STATUS_COMPLETED = "Completed";
    public List<Task> listAllTasks() {
        return repository.findAll();
    }

    public Boolean deleteTask(Long id) {
        repository.delete(id);
        return true;
    }

    public Task createTask(Task task) {
        return repository.save(new Task(task.getTaskDescription(), STATUS_PENDING, new java.util.Date(), null));
    }

    public Task updateTask(Long id) {
        Task t = repository.findOne(id);
        t.setTaskStatus(STATUS_COMPLETED);
        t.setCompletionDate(new java.util.Date());
        return repository.save(t);
    }
}
