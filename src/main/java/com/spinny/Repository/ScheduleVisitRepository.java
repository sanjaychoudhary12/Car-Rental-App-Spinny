package com.spinny.Repository;

import com.spinny.entity.ScheduleVisit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleVisitRepository extends JpaRepository<ScheduleVisit, Integer> {

}