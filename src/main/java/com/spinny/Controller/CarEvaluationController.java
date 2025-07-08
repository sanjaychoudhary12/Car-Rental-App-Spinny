package com.spinny.Controller;



import com.spinny.Repository.CarEvaluationRepository;
import com.spinny.Services.CarEvaluationService;
import com.spinny.entity.CarEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1/cars")
public class CarEvaluationController {

        @Autowired
        private CarEvaluationService carEvaluationService;
        private CarEvaluationRepository carEvaluationRepository;

    public CarEvaluationController(CarEvaluationRepository carEvaluationRepository) {
        this.carEvaluationRepository = carEvaluationRepository;
    }


    @PostMapping("/upload")
        public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
            if (!carEvaluationService.isExcelFormat(file)) {
                return ResponseEntity.badRequest().body("Invalid file format. Please upload a .xlsx Excel file.");
            }

            try {
                carEvaluationService.saveFromExcel(file);
                return ResponseEntity.ok("Car evaluation data uploaded successfully!");
            } catch (Exception e) {
                return ResponseEntity
                        .status(500)
                        .body("Error uploading file: " + e.getMessage());
            }
        }

        @GetMapping("/get-evaluation")
        public CarEvaluation getEvaluationById(
                @RequestParam int yearOfManufacturing,
                @RequestParam int minDriveKm,
                @RequestParam int maxDriveKm
        ){
            CarEvaluation evaluationDetails = carEvaluationRepository.findCarsByYearAndKmRange(
                    yearOfManufacturing, minDriveKm, maxDriveKm);

            return evaluationDetails;
        }

    }


