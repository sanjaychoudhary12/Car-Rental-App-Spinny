package com.spinny.Controller;

import com.spinny.Repository.CarActualDetailRepository;
import com.spinny.entity.CarActualDetail;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car_actual_detail")
public class CarActualDetailController {

    private CarActualDetailRepository carActualDetailRepository;

    public CarActualDetailController(CarActualDetailRepository carActualDetailRepository) {
        this.carActualDetailRepository = carActualDetailRepository;
    }

    //Agent
    @PostMapping("/upload")
    public String uploadCarDetail(
            @RequestBody CarActualDetail carActualDetail
            ) {
        CarActualDetail save = carActualDetailRepository.save(carActualDetail);
        return "Car details uploaded successfully!";
    }

    //EvaluationTeam
    @PutMapping("/actualprice")
    public  String updateCarActualDetail(
            @RequestParam int actualprice,
            @RequestParam int carActualDetailId
    ){
        CarActualDetail carActualDetail = carActualDetailRepository.findById(carActualDetailId).get();
        carActualDetail.setOffered_price(actualprice);

        return "done";
    }

    //Evaluation Team
    @PutMapping("/finalizedprice")
    public  String finalizedCarActualDetail(
            @RequestParam int actualprice,
            @RequestParam int carActualDetailId
    ){
        CarActualDetail carActualDetail = carActualDetailRepository.findById(carActualDetailId).get();
        carActualDetail.setOffered_price(actualprice);
        carActualDetail.setStatus("Completed");

        return "done";
    }
}
