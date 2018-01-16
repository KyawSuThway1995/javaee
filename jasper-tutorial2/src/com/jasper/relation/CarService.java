package com.jasper.relation;

import java.io.InputStream;
import java.util.List;

import com.jasper.model.Car;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class CarService {

	public void relationCar(List<Car> list) throws JRException {

		InputStream in = CarService.class.getResourceAsStream("/Relation/RelationCar.jrxml");

		JasperReport report = JasperCompileManager.compileReport(in);

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));

		JasperViewer.viewReport(print, false);

	}
}
