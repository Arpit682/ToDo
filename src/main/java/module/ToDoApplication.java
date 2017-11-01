package module;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import module.entity.Task;
import module.repository.TaskRepository;

@SpringBootApplication
public class ToDoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TaskRepository repository) {
        return (args) -> {
            // save a couple of Tasks
            repository.deleteAll();
            repository.save(new Task("Buy", "Pending"));
            repository.save(new Task("Run", "Completed"));
            repository.save(new Task("Move", "Pending"));
            repository.save(new Task("Work", "Pending"));
        };
    }
}
