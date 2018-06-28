package com.viewResolver;

import com.view.ExcelView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;


public class ExcelViewResolver implements ViewResolver
{
  @Override
  public View resolveViewName(String s, Locale locale) throws Exception
  {
    System.out.println("ExcelViewResolver: " + s);
    if (s.equals("download")){
      return new ExcelView();
    } else {
      return null;
    }
  }

}
