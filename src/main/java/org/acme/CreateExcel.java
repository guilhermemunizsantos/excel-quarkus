package org.acme;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CreateExcel implements QuarkusApplication
{

  @Override
  public int run(String... args) throws Exception
  {
    try (SXSSFWorkbook workbook = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE/* 100 */);)
    {
      Sheet sheet = workbook.createSheet();
      Row row = sheet.createRow(0);
      Cell cell = row.createCell(0);
      cell.setCellValue("test");
      
      try (BufferedOutputStream fos = new BufferedOutputStream(
          new FileOutputStream("excel.xlsx"));)
      {
        workbook.write(fos);
      }
      System.exit(0);
      return 0;
    }
  }

}
