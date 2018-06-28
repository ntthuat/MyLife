package com.view;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/28 17:37:59 $
 * $Log: MyExcelView.java,v $
 */
public class MyExcelView extends AbstractXlsView
{
  @SuppressWarnings("unchecked")
  protected void buildExcelDocument(Map<String, Object> model,
                                    HSSFWorkbook workbook,
                                    HttpServletRequest request,
                                    HttpServletResponse response)
  {
    //VARIABLES REQUIRED IN MODEL
    String sheetName = (String) model.get("sheetname");
    List<String> headers = (List<String>) model.get("headers");
    List<List<String>> results = (List<List<String>>) model.get("results");
    List<String> numericColumns = new ArrayList<String>();
    if (model.containsKey("numericcolumns"))
      numericColumns = (List<String>) model.get("numericcolumns");
    //BUILD DOC
    HSSFSheet sheet = workbook.createSheet(sheetName);
    sheet.setDefaultColumnWidth((short) 12);
    int currentRow = 0;
    short currentColumn = 0;
    //CREATE STYLE FOR HEADER
    HSSFCellStyle headerStyle = workbook.createCellStyle();
    HSSFFont headerFont = workbook.createFont();
    headerStyle.setFont(headerFont);
    //POPULATE HEADER COLUMNS
    HSSFRow headerRow = sheet.createRow(currentRow);
    for (String header : headers) {
      HSSFRichTextString text = new HSSFRichTextString(header);
      HSSFCell cell = headerRow.createCell(currentColumn);
      cell.setCellStyle(headerStyle);
      cell.setCellValue(text);
      currentColumn++;
    }
    //POPULATE VALUE ROWS/COLUMNS
    currentRow++;//exclude header
  }

  @Override
  protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception
  {

  }
}
