package com.spring.ai.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "help_desk_tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String summery;

    private String catagory;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING) // IT will save Enum as a string in DB
    private Priority priority;

    private String email;

    private Status status;

    private LocalDateTime createdTimeStamp;

    private LocalDateTime updatedTimeStamp;

}
