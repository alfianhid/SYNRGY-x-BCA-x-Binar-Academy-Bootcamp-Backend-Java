package com.binarxbca.chapter5.model.film;

import com.binarxbca.chapter5.model.AuditModel;
import com.binarxbca.chapter5.model.schedule.Schedule;
import com.binarxbca.chapter5.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Table(name = "film")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film extends AuditModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "name", nullable = false, length = 100)
    @NotEmpty(message = "name must not be empty!")
    private String name;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", schedules=" + schedules +
                '}';
    }
}
