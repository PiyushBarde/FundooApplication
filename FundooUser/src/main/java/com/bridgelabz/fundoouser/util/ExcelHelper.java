package com.bridgelabz.fundoouser.util;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bridgelabz.fundoouser.model.User;

//Creates field in excel sheet to get from mysql db
public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "userId", "fName", "lName", "mobileNumber", "email", "password"
		  					, "dateOfBirth", "date", "verified"};
  static String SHEET = "UserRegistration";
  public static ByteArrayInputStream usersToExcel(List<User> users) {
    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);
      // Header
      Row headerRow = sheet.createRow(0);
      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }
      int rowIdx = 1;
      for (User user : users) {
        Row row = sheet.createRow(rowIdx++);
        row.createCell(0).setCellValue(user.getUserId());
        row.createCell(1).setCellValue(user.getFName());
        row.createCell(2).setCellValue(user.getLName());
        row.createCell(3).setCellValue(user.getMobileNumber());
        row.createCell(4).setCellValue(user.getEmail());
        row.createCell(5).setCellValue(user.getPassword());
        row.createCell(6).setCellValue(user.getDateOfBirth());
        row.createCell(7).setCellValue(user.getDate());
        row.createCell(8).setCellValue(user.isVerified());
      }
      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }
}