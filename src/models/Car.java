package models;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Car implements Serializable {
	
	private String _category;
	private String _brand;
	private String _model;
	private int _year;
	private String _type;
	
	Car() {
		
	}
	
	public Car(String category, String brand, String model, int year, String type) {
		this._category = category;
		this._brand = brand;
		this._model = model;
		this._year = year;
		this._type = type;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		if (_category != null) {
			s += "Catégorie : " + _category + "\n";
		}		
		if (_brand != null) {
			s += "Marque : " + _brand + "\n";
		}
		if (_model != null) {
			s += "Modèle : " + _model + "\n";
		}
		
		s += "Année : " + _year + "\n";
		if (_type != null) {
			s += "Type : " + _type + "\n";
		}
		
		return s;
	}

	public String get_category() {
		return _category;
	}

	public void set_category(String _category) {
		this._category = _category;
	}

	public String get_brand() {
		return _brand;
	}

	public void set_brand(String _brand) {
		this._brand = _brand;
	}

	public String get_model() {
		return _model;
	}

	public void set_model(String _model) {
		this._model = _model;
	}

	public int get_year() {
		return _year;
	}

	public void set_year(int _year) {
		this._year = _year;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}
}
