package com.example.model;

import java.util.*;


public class BeerExpert {
	// in the environment of jre 1.6 etc
	// use Generics will give a warning. For containers which
	// support the generics should first define the type of genrics and then use it
	@SuppressWarnings("unchecked")
	public List getBrands(String color) {
		List brands = new ArrayList();
		if(color.equals("amber")) {
			brands.add("Jack Amber");
			brands.add("Red Moose");
		}
		else{
			brands.add("Jail Pale Ale");
			brands.add("Gout Stout");
		}
		return brands;
	}
}
