package ToDo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ToDo.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAll();
}
