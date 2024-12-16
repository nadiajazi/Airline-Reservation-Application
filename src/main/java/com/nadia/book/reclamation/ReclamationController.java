package com.nadia.book.reclamation;

import com.nadia.book.flight.Flight;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

    private final ReclamationService reclamationService;

    public ReclamationController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    // Ajouter une réclamation
    @PostMapping
    public ResponseEntity<Reclamation> addReclamation(@RequestBody Reclamation reclamation) {
        return ResponseEntity.ok(reclamationService.addReclamation(reclamation));
    }


    // Récupérer toutes les réclamations
    @GetMapping
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        return ResponseEntity.ok(reclamationService.getAllReclamations());
    }

    // Récupérer les réclamations par statut
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Reclamation>> getReclamationsByStatus(@PathVariable Reclamation.Status status) {
        return ResponseEntity.ok(reclamationService.getReclamationsByStatus(status));
    }

    // Mettre à jour le statut d'une réclamation
    @PutMapping("/{id}/status")
    public ResponseEntity<Reclamation> updateReclamationStatus(@PathVariable Long id,
                                                               @RequestParam Reclamation.Status status) {
        Reclamation reclamation = reclamationService.updateReclamationStatus(id, status);
        return ResponseEntity.ok(reclamation);
    }
    // Get reclamations by customer email
    @GetMapping("/email/{customerEmail}")
    public ResponseEntity<List<Reclamation>> getReclamationsByEmail(@PathVariable String customerEmail) {
        List<Reclamation> reclamations = reclamationService.getReclamationsByEmail(customerEmail);
        return ResponseEntity.ok(reclamations);
    }
}
