package com.stou.healthcaregroup.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthRecordService {
    @Autowired
    private HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> getAllHealthRecords() {
        return healthRecordRepository.findAll();
    }

    public void addHealthRecord(HealthRecord healthRecord) {
        healthRecordRepository.save(healthRecord);
    }

    public void deleteHealthRecord(String id) {
        healthRecordRepository.deleteById(id);
    }

    public Optional<HealthRecord> findHealthRecordById(String id) {
        return healthRecordRepository.findById(id);
    }

    public void updateHealthRecord(HealthRecord healthRecord) {
        healthRecordRepository.save(healthRecord);
    }
}