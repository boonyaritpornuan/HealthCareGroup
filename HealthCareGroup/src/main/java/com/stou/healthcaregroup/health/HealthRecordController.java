package com.stou.healthcaregroup.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class HealthRecordController {
    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("healthRecords", healthRecordService.getAllHealthRecords());
        return "index";
    }

    @GetMapping("/healthrecordform")
    public String getHealthRecordForm(Model model) {
        model.addAttribute("healthRecordForm", new HealthRecord());
        return "healthrecordform";
    }

    @PostMapping("/addhealthrecord")
    public String addHealthRecord(@ModelAttribute HealthRecord healthRecord) {
        healthRecordService.addHealthRecord(healthRecord);
        return "redirect:/";
    }

    @GetMapping("/deletehealthrecord/{id}")
    public String deleteHealthRecord(@PathVariable String id) {
        healthRecordService.deleteHealthRecord(id);
        return "redirect:/";
    }

    @GetMapping("/getupdatehealthrecordform/{id}")
    public String updateHealthRecordForm(@PathVariable String id, Model model) {
        Optional<HealthRecord> found = healthRecordService.findHealthRecordById(id);
        model.addAttribute("toUpdateHealthRecordForm", found.orElse(null));
        return "updatehealthrecordform";
    }

    @PostMapping("/updatehealthrecord")
    public String updateHealthRecord(@ModelAttribute("healthRecordFormUpdate") HealthRecord healthRecord) {
        healthRecordService.updateHealthRecord(healthRecord);
        return "redirect:/";
    }
}