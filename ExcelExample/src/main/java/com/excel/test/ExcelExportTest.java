package com.excel.test;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.model.EmployeeModel;
import com.excel.vo.Employee;

public class ExcelExportTest {
	
	public static void main(String[] args) {
		try {
			EmployeeModel model = new EmployeeModel();
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("Employee List");
			
			Row row = sheet.createRow(0);
			row.createCell(0).setCellValue("Name");
			row.createCell(1).setCellValue("Email");
			row.createCell(2).setCellValue("DOB");
			row.createCell(3).setCellValue("Address");
			
			for(int i=0; i<4; i++) {
				CellStyle styleRowHead= workBook.createCellStyle();
				Font font = workBook.createFont();
				font.setBoldweight((short) 11);
				font.setFontName(HSSFFont.FONT_ARIAL);
				styleRowHead.setFont(font);
		 		styleRowHead.setVerticalAlignment(CellStyle.ALIGN_CENTER);
				row.getCell(i).setCellStyle(styleRowHead);
			}
			
			for(int i=0; i<4; i++) {
				sheet.autoSizeColumn(i);;
			}
			
			int r=1;
			for(Employee emp : model.getAll()) {
				
				Row rowSheet = sheet.createRow(r);
				
				Cell cellName = rowSheet.createCell(0);
				cellName.setCellValue(emp.getName());
				
				Cell cellEmail = rowSheet.createCell(1);
				cellEmail.setCellValue(emp.getEmail());
				
				Cell cellDob = rowSheet.createCell(2);
				cellDob.setCellValue(emp.getDob());
				CellStyle style = workBook.createCellStyle();
				XSSFDataFormat format = workBook.createDataFormat();
				style.setDataFormat(format.getFormat("yyyy-MM-dd"));
				cellDob.setCellStyle(style);
				
				Cell cellAddress = rowSheet.createCell(3);
				cellAddress.setCellValue(emp.getAddress());
				
				
				
				r++;
			}
			FileOutputStream out = new FileOutputStream(new File("d:\\EmployeeList.xlsx"));
			workBook.write(out);
			out.close();
			System.out.println("Excel written successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
