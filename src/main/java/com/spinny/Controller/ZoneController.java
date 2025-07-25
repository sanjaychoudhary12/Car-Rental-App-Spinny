package com.spinny.Controller;

import com.spinny.Repository.ZoneRepository;
import com.spinny.entity.Zone;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
    private ZoneRepository zoneRepository;

    public ZoneController(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    //Add a new Zone
    @PostMapping("/addzone")
    public String addZone(@RequestBody Zone zone){
        zoneRepository.save(zone);
        return "Zone Added Successfully";
    }

    //get all ZOnes
    @GetMapping("/allzones")
    public List<Zone> getAllZones(){
        return zoneRepository.findAll();
    }

    //get ZOne by id
    @GetMapping("/{id}")
    public Zone getZoneById(@PathVariable Integer id){
        return  zoneRepository.findById(id).orElse(null);
    }
}
