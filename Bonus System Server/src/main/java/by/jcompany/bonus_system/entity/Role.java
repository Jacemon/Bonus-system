package by.jcompany.bonus_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private transient Set<User> users = new LinkedHashSet<>(); // todo
    
    public Role(String name) {
        this.name = name;
    }
}