package com.example.fm6app.service.dto;

import com.example.fm6app.domain.DemandeState;

public class ProcessDemandeDTO {
    private Long id;
    private DemandeState state;
    private String commentaire;
    // Date of Processing the Demande
    private String processedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public DemandeState getState() {
        return state;
    }

    public void setState(DemandeState state) {
        this.state = state;
    }
}
