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
            repository.save(new Task("Buy", "Pending", new java.util.Date(), null));
            repository.save(new Task("Run", "Completed", new java.util.Date(), new java.util.Date()));
            repository.save(new Task("Move", "Pending", new java.util.Date(), null));
            repository.save(new Task("Work", "Pending", new java.util.Date(), null));
            repository.save(new Task("Leave", "Pending", new java.util.Date(), null));
        };
    }
}
