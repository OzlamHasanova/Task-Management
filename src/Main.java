import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

       TaskService taskService=new TaskService();
        //Predicate
        Set<Task> highPriorityTasks = taskService.filterTasks(task -> task.getPriority() >= 3);
        System.out.println("High Priority Tasks: " + highPriorityTasks);

        //Predicate2
        Set<Task> completedTasks = taskService.filterTasks(task -> task.getStatus() ==TaskStatus.COMPLETED);
        System.out.println("Completed Tasks: " + completedTasks);

        //Supplier
        Set<Task> generatedTasks = taskService.getTasksSet(() -> taskService.tasksSet);
        System.out.println("Generated Tasks: "+generatedTasks);

        //Function
        List<String> allTaskSummaryList=taskService.taskSummaryForAllTasks((task -> "\n"+task.getName()+"\n"+task.getDescription()));
        System.out.println(allTaskSummaryList);

        //Consumer
        taskService.changeStatusAsDeadline((taskSet)-> {
            for (Task task :
                    taskSet) {
                if (Duration.between( LocalDateTime.now(),task.getDeadline()).isNegative()&&TaskStatus.PENDING.equals(task.getStatus())){
                    task.setStatus(TaskStatus.FAILED);
                    System.out.println("This task is failed: "+task);
                }
            }
        });
    }
}