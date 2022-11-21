package com.binarxbca.chapter4.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "films")
@Entity
@Getter
@Setter
public class Films {
    @Id
    @Column(name = "film_code", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String film_code;

    @Column(name = "film_name", nullable = false, length = 100)
    private String film_name;

    @Column(name = "film_status", nullable = false)
    private Boolean film_status;

    @OneToMany(mappedBy = "films", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Schedules> schedules;
}
