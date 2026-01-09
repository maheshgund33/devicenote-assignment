package com.example.devicenote.dto;

import java.time.LocalDateTime;

public class DeviceNoteResponse {

    private Long id;
    private String note;
    private String createdBy;
    private LocalDateTime createdAt;

    public DeviceNoteResponse(Long id, String note, String createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.note = note;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
