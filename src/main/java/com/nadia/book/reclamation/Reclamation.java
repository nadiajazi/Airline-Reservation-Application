package com.nadia.book.reclamation;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime dateCreated;

    @Column(nullable = false)
    private String customerEmail;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Enum pour les statuts de réclamation
    public enum Status {
        PENDING,
        IN_PROGRESS,
        RESOLVED
    }
}
