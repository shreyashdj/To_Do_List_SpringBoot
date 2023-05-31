package com.bridgelabz.todolist.entity;

import com.bridgelabz.todolist.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * @author - Shreyash Jadhav
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaskData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private boolean done;
    private LocalDate startDate;
    private LocalDate endDate;
    private int userId;

    public TaskData(TaskDTO taskDTO) {
        this.taskTitle = taskDTO.getTaskTitle();
        this.taskDescription = taskDTO.getTaskDescription();
        this.done = false;
    }
}
