package by.jcompany.bonus_system.entity;

import by.jcompany.bonus_system.util.json.Exclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "task")
@DynamicInsert
public class Task implements IdHandler {
    @Getter
    private static Float pointCost = null;
    public static void setPointCost(Float pointCost) {
        if (pointCost != null && pointCost >= 0.0f) {
            Task.pointCost = pointCost;
        } else {
            Task.pointCost = null;
        }
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Lob
    @Column(name = "description", nullable = false)
    private String description;
    
    /**
     * Use Task.setCreationTime() in persisted Tasks, or there will be no effect
     */
    @Generated(GenerationTime.INSERT)
    @Column(name = "creation_time", nullable = false, insertable = false)
    private Instant creationTime;
    
    /**
     * Use Task.setComplete() in persisted Tasks, or there will be no effect
     */
    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;
    
    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;
    
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "bonus_id", nullable = false)
    private Bonus bonus;
    
    @Exclude
    @ToString.Exclude // todo 1
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee; // 1
    
    /**
     * Use Task.setBonus() for adding bonus
     */
    public Task(String description) {
        this.description = description;
    }
    
    public Task(String description, Bonus bonus) {
        this.description = description;
        this.bonus = bonus;
    }
    
    public Float getAmount() {
        Float amount = null;
        switch (bonus.getType()) {
            case MONEY -> amount = bonus.getAmount();
            case POINTS -> {
                if (pointCost != null) {
                    amount = bonus.getAmount() * pointCost;
                }
            }
        }
        return amount;
    }
    
    @Override
    public Object getIdField() {
        return getId();
    }
}