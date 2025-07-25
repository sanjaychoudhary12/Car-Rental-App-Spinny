package com.spinny.Controller;

import com.spinny.Repository.ScheduleVisitRepository;
import com.spinny.entity.ScheduleVisit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedulevisit")
public class ScheduleVisitController {
    private ScheduleVisitRepository scheduleVisitRepository;

    public ScheduleVisitController(ScheduleVisitRepository scheduleVisitRepository) {
        this.scheduleVisitRepository = scheduleVisitRepository;
    }

    //Add Schedule visit details only by agents
    @PostMapping("/add_schedule_visit_details")
    public String addScheduleVisit(@RequestBody ScheduleVisit scheduleVisit){
        scheduleVisitRepository.save(scheduleVisit);
        return "Schedule Visit Updated Sccessfully by Agent";
    }

    //GEt all Schedule Visit Details
    @GetMapping("/allVisits")
    public List<ScheduleVisit> getAllScheduleDetails(){
        return scheduleVisitRepository.findAll();
    }

    //Get All Schedule Visit Details
    @GetMapping("/{id}")
    public ScheduleVisit getscheduleVisitById(@PathVariable Integer id){
        return scheduleVisitRepository.findById(id).orElse(null);
    }
}
