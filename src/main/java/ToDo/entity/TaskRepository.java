package ToDo.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAll();
}
