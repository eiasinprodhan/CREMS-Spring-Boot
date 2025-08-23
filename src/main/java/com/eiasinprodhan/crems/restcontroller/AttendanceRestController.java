package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Attendance;
import com.eiasinprodhan.crems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
@CrossOrigin("*")
public class AttendanceRestController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/")
    public List<Attendance> findAll() {
        return attendanceService.findAll();
    }

    @GetMapping("/{id}")
    public Attendance findById(@PathVariable Integer id) {
        return attendanceService.findById(id);
    }

    @PostMapping("/")
    public Attendance save(@RequestBody Attendance attendance) {
        return attendanceService.save(attendance);
    }

    @PutMapping("/")
    public Attendance update(@RequestBody Attendance attendance) {
        return attendanceService.save(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        attendanceService.deleteById(id);
    }

    @GetMapping("")
    public List<Attendance> findAllByStageId(@RequestParam Integer stageId) {
        return attendanceService.findByStageId(stageId);
    }
}
