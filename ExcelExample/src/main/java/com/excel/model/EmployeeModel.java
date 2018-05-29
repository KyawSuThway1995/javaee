package com.excel.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.excel.vo.Employee;

public class EmployeeModel {
	
	public EmployeeModel() {
		super();
	}

	public List<Employee> getAll(){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<Employee> list = new ArrayList<>();
			list.add(new Employee("Mg Mg", "mgmg@gmail.com", new Date(), "Yangon"));
			list.add(new Employee("Aye Aye", "ayeaye@gmail.com", sdf.parse("2018-05-01"), "NayPyiTaw"));
			list.add(new Employee("Hla Hla", "hlahla@gmail.com", sdf.parse("2018-05-01"), "Mandalay"));
			list.add(new Employee("Kyaw Kyaw", "kyaw@gmail.com", sdf.parse("2018-05-01"), "Pyay"));
			list.add(new Employee("Mya Mya", "myamya@gmail.com", sdf.parse("2018-05-01"), "MawHlaMyaing"));
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}
