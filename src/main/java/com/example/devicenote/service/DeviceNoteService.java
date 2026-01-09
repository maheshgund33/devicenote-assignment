package com.example.devicenote.service;

import com.example.devicenote.entity.DeviceNote;
import com.example.devicenote.repository.DeviceNoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceNoteService {

    @Autowired
    private DeviceNoteRepository repository;

    @Transactional
    public DeviceNote createNote(Long deviceId, String note, String user) {

        if (user == null || user.isBlank())
            throw new IllegalArgumentException("X-User header is mandatory");

        if (note == null || note.isBlank())
            throw new IllegalArgumentException("Note must not be blank");

        if (note.length() > 1000)
            throw new IllegalArgumentException("Note length must be <= 1000");

        DeviceNote dn = new DeviceNote();
        dn.setDeviceId(deviceId);
        dn.setNote(note);
        dn.setCreatedBy(user);
        dn.setCreatedAt(LocalDateTime.now());

        return repository.save(dn);
    }

    public List<DeviceNote> getNotes(Long deviceId, int limit) {

        if (limit < 1 || limit > 100)
            throw new IllegalArgumentException("Limit must be between 1 and 100");

        Pageable pageable = PageRequest.of(0, limit);
        return repository.findByDeviceIdOrderByCreatedAtDesc(deviceId, (java.awt.print.Pageable) pageable);
    }
}
