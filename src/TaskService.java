import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TaskService {
    Set<Task> tasksSet = new HashSet<>();
    Task task=new Task();

    public TaskService() {
        task = new Task(task.getId(),"Task test","Description test",4,TaskStatus.PENDING, LocalDateTime.of(2024, 1,1,1,1));
        tasksSet.add(task);
        task = new Task(task.getId(),"Task test2","Description test2",2,TaskStatus.COMPLETED, LocalDateTime.now().plusDays(4));
        tasksSet.add(task);
        System.out.println(task);
    }
    public Set<Task> filterTasks(Predicate<Task> condition) {
        Set<Task> result = new HashSet<>();
        for (Task task : tasksSet) {
            if (condition.test(task)) {
                result.add(task);
            }
        }
        return result;
    }

    public Set<Task> getTasksSet(Supplier<Set<Task>> supplier) {
        return supplier.get();
    }

    public List<String> taskSummaryForAllTasks(Function<Task,String> function){
        List<String> taskSummaryList=new ArrayList<>();
        for (Task task :
                tasksSet) {
            taskSummaryList.add(function.apply(task));
        }
        return taskSummaryList;
    }

    public void changeStatusAsDeadline(Consumer<Set<Task>> consumer){
        consumer.accept(tasksSet);
    }

}
