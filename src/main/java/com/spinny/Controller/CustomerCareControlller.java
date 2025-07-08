package com.spinny.Controller;


import com.spinny.Repository.AgentRepository;
import com.spinny.Repository.ScheduleVisitRepository;
import com.spinny.Repository.ZoneRepository;
import com.spinny.entity.Agent;
import com.spinny.entity.ScheduleVisit;
import com.spinny.entity.Zone;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer-care")
public class CustomerCareControlller {


    private ScheduleVisitRepository scheduleVisitRepository;
    private ZoneRepository zoneRepository;

    public CustomerCareControlller(ScheduleVisitRepository scheduleVisitRepository,ZoneRepository zoneRepository) {
        this.scheduleVisitRepository = scheduleVisitRepository;
        this.zoneRepository = zoneRepository;
    }

    @PostMapping
    public String allocateAgent(
            @RequestParam long scheduleVisitId
    ){
        ScheduleVisit scheduleVisit = scheduleVisitRepository.findById((int) scheduleVisitId).get();
       Zone zone = findZone(scheduleVisit.getLocation());
      Agent agent = zone.getAgent();
        scheduleVisit.setAgent(agent);
        scheduleVisitRepository.save(scheduleVisit);
       return  "allocated agent";
    }
    public Zone findZone(String area){
       return zoneRepository.findByArea(area);
    }
}
