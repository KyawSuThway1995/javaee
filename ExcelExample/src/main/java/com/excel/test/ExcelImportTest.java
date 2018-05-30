package com.excel.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.vo.Employee;

public class ExcelImportTest {

	public static void main(String[] args) {

		Employee emp = new Employee();
		List<Employee> list = new ArrayList<>();

		try {
			FileInputStream fin = new FileInputStream(new File("EmployeeList.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sheet = wb.getSheetAt(0);

			Row row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				emp.setName(row.getCell(0).getStringCellValue());
				emp.setEmail(row.getCell(1).getStringCellValue());
				emp.setDob(row.getCell(2).getDateCellValue());
				emp.setAddress(row.getCell(3).getStringCellValue());
				System.out.println(emp.toString());
			}

			fin.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
