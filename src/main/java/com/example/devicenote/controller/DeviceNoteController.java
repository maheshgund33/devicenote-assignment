package com.example.devicenote.controller;

import com.example.devicenote.dto.CreateNoteRequest;
import com.example.devicenote.service.DeviceNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceNoteController {

    @Autowired
    private DeviceNoteService service;

    @PostMapping("/{deviceId}/notes")
    public ResponseEntity<?> create(
            @PathVariable Long deviceId,
            @RequestHeader("X-User") String user,
            @RequestBody CreateNoteRequest req) {

        return ResponseEntity.ok(
                service.createNote(deviceId, req.getNote(), user)
        );
    }

    @GetMapping("/{deviceId}/notes")
    public ResponseEntity<?> list(
            @PathVariable Long deviceId,
            @RequestParam(defaultValue = "20") int limit) {

        return ResponseEntity.ok(
                service.getNotes(deviceId, limit)
        );
    }
}

