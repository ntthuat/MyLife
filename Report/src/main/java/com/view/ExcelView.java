package com.view;

import com.model.Employee;
import org.apache.poi.hssf.util.HSSFColor;
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
public class ExcelView extends AbstractXlsView
{
  @Override
  protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    // change the file name
    response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

    @SuppressWarnings("unchecked")
    List<Employee> employees = (List<Employee>) model.get("employees");

    // create excel xls sheet
    Sheet sheet = workbook.createSheet("User Detail");
    sheet.setDefaultColumnWidth(30);

    // create style for header cells
    CellStyle style = workbook.createCellStyle();
    Font font = workbook.createFont();
    font.setFontName("Arial");
    style.setFillForegroundColor(HSSFColor.BLUE.index);
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    font.setBold(true);
    font.setColor(HSSFColor.WHITE.index);
    style.setFont(font);

    int rowCount = 1;

    for (Employee employee : employees) {
      Row userRow = sheet.createRow(rowCount++);
      userRow.createCell(0).setCellValue(employee.getFirstName());
      userRow.createCell(1).setCellValue(employee.getLastName());
      userRow.createCell(2).setCellValue(employee.getBirthDay());
      userRow.createCell(3).setCellValue(employee.getJobTitle());
      userRow.createCell(4).setCellValue(employee.getCompany());
      userRow.createCell(5).setCellValue(employee.getAddress());
      userRow.createCell(7).setCellValue(employee.getCountry());
      userRow.createCell(8).setCellValue(employee.getPhoneNumber());

    }
  }
}
