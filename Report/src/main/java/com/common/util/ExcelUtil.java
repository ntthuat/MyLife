package com.common.util;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/06/29 17:28:28 $
 * $Log: ExelUtil.java,v $
 */
public class ExcelUtil {

  public static String FONT_ARIAL = "Arial";
  public static String FONT_TIMES_NEW_ROMAN = "Times New Roman";


  public static CellStyle createHeaderStyle(Workbook workbook) {
    CellStyle style = workbook.createCellStyle();
    Font font = workbook.createFont();
    font.setFontName(ExcelUtil.FONT_ARIAL);
    style.setFillForegroundColor(HSSFColor.GREEN.index);
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    font.setBold(true);
    font.setColor(HSSFColor.WHITE.index);
    style.setFont(font);

    return style;
  }
}
