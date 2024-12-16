package com.nadia.book.reclamation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    List<Reclamation> findByStatus(Reclamation.Status status);
    List<Reclamation> findByCustomerEmail(String customerEmail);
}
