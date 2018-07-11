package com.view;

import com.common.util.ExcelUtil;
import com.model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 11:38:01 $
 * $Log: ExcelView.java,v $
 */
public class ExcelView extends AbstractXlsView {
  @Override
  protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
    // change the file name
    response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

    @SuppressWarnings("unchecked")
    List<Employee> employees = (List<Employee>) model.get("employees");

    // create excel xls sheet
    Sheet sheet = workbook.createSheet("Employee Detail");
    sheet.setDefaultColumnWidth(30);

    // create header row
    CellStyle style = ExcelUtil.createHeaderStyle(workbook);
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("Last Name");
    headerRow.createCell(1).setCellValue("First Name");
    headerRow.createCell(2).setCellValue("Birthday");
    headerRow.createCell(3).setCellValue("Job Title");
    headerRow.createCell(4).setCellValue("Company");
    headerRow.createCell(5).setCellValue("Address");
    headerRow.createCell(6).setCellValue("City");
    headerRow.createCell(7).setCellValue("Country");
    headerRow.createCell(8).setCellValue("Phone Number");
    for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
      headerRow.getCell(i).setCellStyle(style);
    }

    int rowCount = 1;
    for (Employee employee : employees) {
      Row userRow = sheet.createRow(rowCount++);
      userRow.createCell(0).setCellValue(employee.getLastName());
      userRow.createCell(1).setCellValue(employee.getFirstName());
      userRow.createCell(2).setCellValue(employee.getBirthDay());
      userRow.createCell(3).setCellValue(employee.getJobTitle());
      userRow.createCell(4).setCellValue(employee.getCompany());
      userRow.createCell(5).setCellValue(employee.getAddress());
      userRow.createCell(6).setCellValue(employee.getCity());
      userRow.createCell(7).setCellValue(employee.getCountry());
      userRow.createCell(8).setCellValue(employee.getPhoneNumber());

    }
  }
}
