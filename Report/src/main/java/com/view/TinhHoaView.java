package com.view;

import com.common.util.ExcelUtil;
import com.model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/07/22 20:38:05 $
 * $Log: TinhHoaView.java,v $
 */
public class TinhHoaView extends AbstractXlsView {

  @Override
  protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
    // change the file name
    response.setHeader("Content-Disposition", "attachment; filename=\"LLV.xls\"");

    @SuppressWarnings("unchecked")
    List<Employee> employees = (List<Employee>) model.get("employees");

    // create excel xls sheet
    Sheet sheet = workbook.createSheet("R028- T1");
    //sheet.setDefaultColumnWidth(10);

    // create header 1:
    createHeader1(sheet, workbook);
    createHeader2(sheet, workbook);
    // create header row
    /*CellStyle style = ExcelUtil.createHeaderStyle(workbook);
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("Full Name");
    headerRow.createCell(1).setCellValue("Birthday");
    headerRow.createCell(2).setCellValue("Job Title");
    headerRow.createCell(3).setCellValue("Company");
    headerRow.createCell(4).setCellValue("Address");
    headerRow.createCell(5).setCellValue("City");
    headerRow.createCell(6).setCellValue("Country");
    headerRow.createCell(7).setCellValue("Phone Number");
    for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
      headerRow.getCell(i).setCellStyle(style);
    }

    int rowCount = 1;
    for (Employee employee : employees) {
      Row userRow = sheet.createRow(rowCount++);
      userRow.createCell(0).setCellValue(employee.getFullName());
      userRow.createCell(1).setCellValue(employee.getBirthDay());
      userRow.createCell(2).setCellValue(employee.getJobTitle());
      userRow.createCell(3).setCellValue(employee.getCompany());
      userRow.createCell(4).setCellValue(employee.getAddress());
      userRow.createCell(5).setCellValue(employee.getCity());
      userRow.createCell(6).setCellValue(employee.getCountry());
      userRow.createCell(7).setCellValue(employee.getPhoneNumber());
    }*/

    /*sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.autoSizeColumn(2);
    sheet.autoSizeColumn(3);
    sheet.autoSizeColumn(4);
    sheet.autoSizeColumn(5);
    sheet.autoSizeColumn(6);*/
  }

  private void createHeader1(Sheet sheet, Workbook workbook){
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("LỊCH LÀM VIỆC  F&B THÁNG 07 CN H028 .");
    sheet.addMergedRegion(new CellRangeAddress(0,0,0,10)); // Merge A1 -> K11

    CellStyle style = workbook.createCellStyle();

    // setting for font
    Font font = workbook.createFont();
    font.setFontName(ExcelUtil.FONT_TIMES_NEW_ROMAN);
    font.setBold(true);
    font.setFontHeightInPoints((short) 18);
    style.setFont(font);

    headerRow.getCell(0).setCellStyle(style);
  }

  private void createHeader2(Sheet sheet, Workbook workbook) {
    //TODO
  }
}
