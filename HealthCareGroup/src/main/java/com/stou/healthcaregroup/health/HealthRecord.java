package com.stou.healthcaregroup.health;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthRecord {
    @Id
    private String id; // ID ของบันทึกสุขภาพ
    private String time; // เวลา
    private String date; // วันที่
    private String name; // ชื่อ
    private String pressure; // ความดัน
    private String heartRate; // อัตราการเต้นของหัวใจ
    private int age; // อายุ
    private double weight; // น้ำหนัก
    private double height; // ส่วนสูง
    private String collector; // ผู้เก็บข้อมูล
}