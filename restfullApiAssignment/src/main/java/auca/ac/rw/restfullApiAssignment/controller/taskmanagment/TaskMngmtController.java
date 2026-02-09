package auca.ac.rw.restfullApiAssignment.controller.taskmanagment;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class TaskMngmtController {

    public static class Task {
        public Long taskId;
        public String title;
        public String description;
        public Boolean completed;
        public String priority;
        public String dueDate;

        public Task(Long taskId, String title, String description, Boolean completed, String priority, String dueDate) {
            this.taskId = taskId;
            this.title = title;
            this.description = description;
            this.completed = completed;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    public List<Long> taskId = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L));
    public List<String> title = new ArrayList<>(Arrays.asList("Complete assignment", "Buy groceries", "Call dentist", "Review code"));
    public List<String> description = new ArrayList<>(Arrays.asList("Finish REST API assignment", "Get milk and eggs", "Schedule appointment", "Review pull requests"));
    public List<Boolean> completed = new ArrayList<>(Arrays.asList(false, true, false, false));
    public List<String> priority = new ArrayList<>(Arrays.asList("HIGH", "MEDIUM", "LOW", "HIGH"));
    public List<String> dueDate = new ArrayList<>(Arrays.asList("2024-12-20", "2024-12-15", "2024-12-18", "2024-12-19"));

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < title.size(); i++) {
            tasks.add(new Task(taskId.get(i), title.get(i), description.get(i), completed.get(i), priority.get(i), dueDate.get(i)));
        }
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public List<Task> getTaskById(@PathVariable Long id) {
        for (int i = 0; i < taskId.size(); i++) {
            if (taskId.get(i).equals(id)) {
                List<Task> task = new ArrayList<>();
                task.add(new Task(taskId.get(i), title.get(i), description.get(i), completed.get(i), priority.get(i), dueDate.get(i)));
                return task;
            }
        }
        return null;
    }

    @GetMapping("/tasks/status")
    public List<Task> getTasksByStatus(@RequestParam boolean completed) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < this.completed.size(); i++) {
            if (this.completed.get(i).equals(completed)) {
                tasks.add(new Task(taskId.get(i), title.get(i), description.get(i), this.completed.get(i), priority.get(i), dueDate.get(i)));
            }
        }
        return tasks;
    }

    @GetMapping("/tasks/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < this.priority.size(); i++) {
            if (this.priority.get(i).equalsIgnoreCase(priority)) {
                tasks.add(new Task(taskId.get(i), title.get(i), description.get(i), completed.get(i), this.priority.get(i), dueDate.get(i)));
            }
        }
        return tasks;
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam String title, @RequestParam String description, @RequestParam boolean completed, @RequestParam String priority, @RequestParam String dueDate) {
        this.taskId.add((long) (this.taskId.size() + 1));
        this.title.add(title);
        this.description.add(description);
        this.completed.add(completed);
        this.priority.add(priority);
        this.dueDate.add(dueDate);
        return "Task added successfully";
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @RequestParam String title, @RequestParam String description, @RequestParam boolean completed, @RequestParam String priority, @RequestParam String dueDate) {
        for (int i = 0; i < taskId.size(); i++) {
            if (taskId.get(i).equals(id)) {
                this.title.set(i, title);
                this.description.set(i, description);
                this.completed.set(i, completed);
                this.priority.set(i, priority);
                this.dueDate.set(i, dueDate);
                return "Task updated successfully";
            }
        }
        return "Task not found";
    }

    @PatchMapping("/tasks/{id}/complete")
    public String markTaskComplete(@PathVariable Long id) {
        for (int i = 0; i < taskId.size(); i++) {
            if (taskId.get(i).equals(id)) {
                this.completed.set(i, true);
                return "Task marked as completed";
            }
        }
        return "Task not found";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        for (int i = 0; i < taskId.size(); i++) {
            if (taskId.get(i).equals(id)) {
                this.taskId.remove(i);
                this.title.remove(i);
                this.description.remove(i);
                this.completed.remove(i);
                this.priority.remove(i);
                this.dueDate.remove(i);
                return "Task deleted successfully";
            }
        }
        return "Task not found";
    }
}
