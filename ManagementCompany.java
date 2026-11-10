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

import java.text.NumberFormat;
import java.util.Locale;

public class ManagementCompany {
	private String name;
	private String taxId;
	private Property[] properties;
	private int propertyCount;
	public static final int MAX_PROPERTIES = 5;

	public ManagementCompany () {
		this.name = "Default Mgmt Company";
		this.taxId = "123ABC";
		this.propertyCount = 0;
		this.properties = new Property[MAX_PROPERTIES];

	}

	public ManagementCompany (String name, String taxId) {
		this.name = name;
		this.taxId = taxId;
		this.propertyCount = 0;
		this.properties = new Property[MAX_PROPERTIES];
	}

	public ManagementCompany (String name, String taxId, Property[] properties, int propertyCount) {
		this.name = name;
		this.taxId = taxId;
		this.properties = properties;
		this.propertyCount = propertyCount;
	}
	
	public ManagementCompany (ManagementCompany mc) {
		this.name = mc.name;
		this.propertyCount = mc.propertyCount;
		this.taxId = mc.taxId;
		this.properties = new Property[MAX_PROPERTIES];
		for (int i = 0; i < this.propertyCount; i++) {
			this.properties[i] = new Property(mc.properties[i]);
		}
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setTaxId (String taxId) {
		this.taxId = taxId;
	}

	public void setProperties (Property[] p) {
		this.properties = p;
		int count = 0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				count++;
			}
		}
		this.propertyCount = count;
	}

	public String getName () {
		return this.name;
	}

	public String getTaxId () {
		return this.taxId;
	}

	public Property getProperty (int index) {
		return properties[index];
	}

	public double totalRent () {
		double sum = 0;
		for (int i = 0; i < propertyCount; i++) {
			sum += properties[i].getRentAmount();
		}
		return sum;
	}

	public int addProperty(Property p) {
		try {
			properties[propertyCount] = new Property(p);
			propertyCount++;
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
		return propertyCount - 1;
	}

	public int getPropertyCount () {
		return this.propertyCount;
	}

	// This is only for JUnit testing
	public boolean checkDeepCopy (ManagementCompany m) {
		for (int i = 0; i < m.propertyCount; i++) {
			if (properties[i] == m.properties[i])
				return false;
		}
		return true;
	}

	public static String formatMoney(double amount) {
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		return moneyFormat.format(amount);
	}

	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Management Company: " + this.name +
				" (Tax ID: " + this.taxId + ")");
		if (propertyCount == 0)
				return sb + "\nThere are no valid properties.";
		sb.append("\nProperties:");
		for (int i = 0; i < propertyCount; i++) {
			sb.append("\n " + i + ": " + properties[i].getPropertyName() + ", " +
						properties[i].getCity() +
						", Rent: " + formatMoney(properties[i].getRentAmount()) +
						", Owner: " + properties[i].getOwner());
		}
		sb.append("\nTotal Rent: " + formatMoney(totalRent()));
		return sb.toString();
	}
}
