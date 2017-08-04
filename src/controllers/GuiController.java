package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import interfaces.AddButtonListener;
import interfaces.ArchiveButtonListener;
import models.Car;
import views.GuiView;

public class GuiController implements AddButtonListener, ArchiveButtonListener {
	private GuiView _view;
	private ArrayList<Car> _cars = new ArrayList<Car>();
	
	public GuiController() {
		_view = new GuiView();
		
		_view.setAddButtonListener(this);
		_view.setArchiveButtonListener(this);
		
		_view.setVisible(true);
	}

	@Override
	public void onAddClick() {
		String cat = _view.getCategory();
		String type = _view.getTransmission();
		String brand = _view.getBrand();
		String model = _view.getModel();
		int year = _view.getYear();
		
		if (cat.length() == 0)
			return;
		if (type.length() == 0)
			return;
		if (brand.length() == 0)
			return;
		if (model.length() == 0)
			return;
		if (year < 1900) 
			return;
		
		Car car = new Car(cat, brand, model, year, type);
		
		_cars.add(car);
	}

	@Override
	public void onArchiveClick() {
		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\CDI\\serialisations\\Cars.data");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			for (Iterator iterator = _cars.iterator(); iterator.hasNext();) {
				out.writeObject((Car) iterator.next());
			}
			
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in Cars.data");
			
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
