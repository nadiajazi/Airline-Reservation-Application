package com.nadia.book.reclamation;


import com.nadia.book.flight.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReclamationService {

    private final ReclamationRepository reclamationRepository;

    public ReclamationService(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    // Ajouter une réclamation

    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    // Récupérer toutes les réclamations
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    // Récupérer les réclamations par statut
    public List<Reclamation> getReclamationsByStatus(Reclamation.Status status) {
        return reclamationRepository.findByStatus(status);
    }

    // Changer le statut d'une réclamation
    public Reclamation updateReclamationStatus(Long id, Reclamation.Status status) {
        Reclamation reclamation = reclamationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reclamation not found"));
        reclamation.setStatus(status);
        return reclamationRepository.save(reclamation);
    }

    // Get reclamations by customer email
    public List<Reclamation> getReclamationsByEmail(String customerEmail) {
        return reclamationRepository.findByCustomerEmail(customerEmail);
    }
}
