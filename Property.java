/*
 * Class: CMSC203
 * Instructor: Khandan Monshi
 * Description: Assignment 4: management company with driver
 * Due: 11/11/2026
 * Platform/compiler: Win11 26H2 build 26430.9767 / openjdk 21.0.1 (Microsoft provided)
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Michael Jarman
 */

public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	
	public Property () {
		this.propertyName = "Default Property";
		this.city = "Default City";
		this.rentAmount = 420420420420420.00;
		this.owner = "Default Owner";
	}
	
	public Property (String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	public Property (Property p) {
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.rentAmount = p.rentAmount;
		this.owner = p.owner;
	}
	
	public String getPropertyName () {
		return this.propertyName;
	}
	
	public String getCity () {
		return this.city;
	}
	
	public double getRentAmount () {
		return this.rentAmount;
	}
	
	public String getOwner () {
		return this.owner;
	}
	
	public void setPropertyName (String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setCity (String city) {
		this.city = city;
	}
	
	public void setRentAmount (double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public void setOwner (String owner) {
		this.owner = owner;
	}
	
	public String toString () {
		return String.format("%s, %s, Rent: $%.2f, Owner: %s", propertyName, city, rentAmount, owner);
	}
}
