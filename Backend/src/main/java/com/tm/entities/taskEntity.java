package com.tm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity extends BaseEntity {
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String description;
    @Column(nullable = false)
    private TaskStatus status = TaskStatus.PENDING;
    @Column(nullable = false)
    private int priority;
    @Column(nullable = false)
    private LocalDateTime dueDate;

}
