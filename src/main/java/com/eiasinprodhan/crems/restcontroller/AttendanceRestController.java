package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Attendance;
import com.eiasinprodhan.crems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceRestController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/")
    public ResponseEntity<List<Attendance>> findAll() {
        List<Attendance> attendances = attendanceService.findAll();
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> findById(@PathVariable Integer id) {
        Attendance attendance = attendanceService.findById(id);
        if (attendance != null) {
            return ResponseEntity.ok(attendance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Attendance> save(@RequestBody Attendance attendance) {
        Attendance saved = attendanceService.save(attendance);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/")
    public ResponseEntity<Attendance> update(@RequestBody Attendance attendance) {
        Attendance updated = attendanceService.save(attendance);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Attendance attendance = attendanceService.findById(id);
        if (attendance != null) {
            attendanceService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Attendance>> findAllByStageId(@RequestParam Integer stageId) {
        List<Attendance> attendances = attendanceService.findByStageId(stageId);
        return ResponseEntity.ok(attendances);
    }
}
