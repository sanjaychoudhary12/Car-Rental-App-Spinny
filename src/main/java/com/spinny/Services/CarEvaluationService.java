package com.spinny.Services;


import com.spinny.Repository.CarEvaluationRepository;
import com.spinny.entity.CarEvaluation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
    public class CarEvaluationService {

    @Autowired
    private CarEvaluationRepository carEvaluationRepository;

    public void saveFromExcel(MultipartFile file) {
        try (InputStream is = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) rows.next(); // skip header

            List<CarEvaluation> carList = new ArrayList<>();

            while (rows.hasNext()) {
                Row row = rows.next();

                CarEvaluation car = CarEvaluation.builder()
                        .carCompanyName(getCellValueAsString(row.getCell(1)))
                        .yearOfManufacturing((int) row.getCell(2).getNumericCellValue())
                        .minDrivenKm((int) row.getCell(3).getNumericCellValue())
                        .maxDrivenKm((int) row.getCell(4).getNumericCellValue())
                        .approxCarAmountMin(row.getCell(5).getNumericCellValue())
                        .approxCarAmountMax(row.getCell(6).getNumericCellValue())
                        .build();

                carList.add(car);
            }

            carEvaluationRepository.saveAll(carList);

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse or store data: " + e.getMessage());
        }
    }

    private String getCellValueAsString(Cell cell) {
        return cell == null? "" : cell.getStringCellValue();
    }

    public boolean isExcelFormat(MultipartFile file) {
        return file.getOriginalFilename().endsWith(".xlsx");
    }

}

