package ToDo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import ToDo.entity.Task;
import ToDo.entity.TaskRepository;

@SpringBootApplication
@EntityScan("ToDo.entity")
public class ToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.deleteAll();
			repository.save(new Task("Buy", ""));
			repository.save(new Task("Chloe", "O'Brian"));
			repository.save(new Task("Kim", "Bauer"));
		};
	}
}
