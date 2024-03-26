package com.reservationapp.util;

import com.reservationapp.entity.Passenger;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelGeneratorService {

    public byte[] generateExcel(List<Passenger> passengers) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Passenger Data");


            Row headerRow = sheet.createRow(0);
            String[] columns = {"Id", "First Name", "Last Name", "Email", "Mobile", "Bus Id", "Route Id"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }
            int rowNum = 1;
            for (int i = 0; i < passengers.size(); i++) {
                Row row = sheet.createRow(i + 1);
                Passenger passenger = passengers.get(i);
                row.createCell(0).setCellValue(passenger.getId());
                row.createCell(1).setCellValue(passenger.getFirstName());
                row.createCell(2).setCellValue(passenger.getLastName());
                row.createCell(3).setCellValue(passenger.getEmail());
                row.createCell(4).setCellValue(passenger.getMobile());
                row.createCell(5).setCellValue(passenger.getBusId());
                row.createCell(6).setCellValue(passenger.getRouteId());

            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }

    }
}
