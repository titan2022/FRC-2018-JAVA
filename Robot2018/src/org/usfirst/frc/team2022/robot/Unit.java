package org.usfirst.frc.team2022.robot;

import java.util.HashMap;
import java.util.Map;

public class Unit {
	
	public enum UnitType
	{
		INCHES, FEET, YARDS, MILES,
		CENTIMETERS, METERS, KILOMETERS
	} 
	
	//how to convert from this unit to meters, which everything is stored in. 
	private static Map<UnitType, Double> conversion_ = new HashMap<UnitType, Double>(){
		{
			put(UnitType.METERS, 1.0d);
			put(UnitType.CENTIMETERS, 0.01d);
			put(UnitType.INCHES, 0.0254d);
			put(UnitType.FEET, 0.3048d);
			put(UnitType.YARDS, 0.9144d);
			put(UnitType.MILES, 1609.34d);
			put(UnitType.KILOMETERS, 1000.0d);
		}	
	};
	
	//value of the number, stored in meters
	private double value_;
	
	public Unit(Double value, UnitType type){
		this.value_ = value * conversion_.get(type);
	}
	
	public double getValueAs(UnitType type)
	{
		return this.value_ / conversion_.get(type);
	}
	
	public void setValue(double value, UnitType type)
	{
		this.value_ = value * conversion_.get(type);
	}
	
}
