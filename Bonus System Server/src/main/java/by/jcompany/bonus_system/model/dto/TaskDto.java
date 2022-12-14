package by.jcompany.bonus_system.model.dto;

import by.jcompany.bonus_system.entity.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaskDto {
    private Integer id;
    private String description;
    private Instant creationTime;
    private boolean isCompleted;
    private boolean isPaid;
    
    private BonusDto bonus;
    
    private EmployeeDto employee;
    
    public TaskDto(Task task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.creationTime = task.getCreationTime();
        this.isCompleted = task.isCompleted();
        this.isPaid = task.isPaid();
        this.bonus = new BonusDto(task.getBonus());
        this.employee = null;
        if (task.getEmployee() != null) {
            this.employee = new EmployeeDto(task.getEmployee(), true);
        }
    }
    
    public TaskDto(Task task, boolean clean) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.creationTime = task.getCreationTime();
        this.isCompleted = task.isCompleted();
        this.isPaid = task.isPaid();
        this.bonus = new BonusDto(task.getBonus());
        this.employee = null;
    }
}