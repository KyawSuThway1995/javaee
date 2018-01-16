package com.jasper.view;

import java.util.ArrayList;
import java.util.List;

import com.jasper.model.Car;
import com.jasper.relation.CarService;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;

public class JasperController {

	@FXML
	private TextField name;
	@FXML
	private TextField color;
	@FXML
	private TextField model;
	@FXML
	private TextField carNo;
	@FXML
	private TableView<Car> carView;

	private List<Car> list;

	public JasperController() {
		list = new ArrayList<>();
	}

	public void pressButton() {
		Car c = new Car();
		c.setName(name.getText());
		c.setColor(color.getText());
		c.setModel(model.getText());
		c.setCarNo(Integer.parseInt(carNo.getText()));

		list.add(c);

		carView.getItems().addAll(c);

		name.clear();
		color.clear();
		model.clear();
		carNo.clear();

	}

	public void showReport() {
		CarService service = new CarService();
		try {
			service.relationCar(list);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
