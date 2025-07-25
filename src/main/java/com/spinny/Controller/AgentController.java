package com.spinny.Controller;

import com.spinny.Repository.AgentRepository;
import com.spinny.entity.Agent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentRepository agentRepository;

    public AgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    //Add a new Agent
    @PostMapping("/add")
    public  String addAgent(@RequestBody Agent agent){
        agentRepository.save(agent);
            return "Agent Added Succesfully";

    }

    //Get All Agents
    @GetMapping("/allAgents")
    public List<Agent> getAllAgents(){
        return agentRepository.findAll();
    }

    //Delete agents by Id
    @DeleteMapping("/delete/{id}")
    public  String deleteAgent(@PathVariable Integer id){
        if (!agentRepository.existsById(id)){
            return "ID Not Found:";
        }
        else {
            agentRepository.deleteById(id);
            return "Agent Deleted Successfully";
        }
    }
}
