package module.service;

import java.util.List;

import module.entity.Task;

public interface ITaskService {

    final String STATUS_PENDING = "Pending";
    final String STATUS_COMPLETED = "Completed";
    public List<Task> listAllTasks();
    public Boolean deleteTask(Long id);
    public Task createTask(Task task);
    public Task updateTask(Long id);
}
