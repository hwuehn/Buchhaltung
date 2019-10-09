package de.company.accounting.data;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class Invoice {

	private String articleDescription;
	private int itemQuantity;
	private double itemPrice;
	private LocalDate date;
	private double totalNetPrice;
	private double inputTax;
	private double grossFinalPrice;
	private int documentNumber;

	public int getDocumentNumber() {
		return documentNumber;
	}
	public String getArticleDescription() {
		return articleDescription;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public double getTotalNetPrice() {
		return totalNetPrice;
	}
	public double getInputTax() {
		return inputTax;
	}
	public double getGrossFinalPrice() {
		return grossFinalPrice;
	}
	public void setTotalNetPrice() {
		totalNetPrice = getItemPrice() * getItemQuantity();
	}
	public void setInputTax() {
		
		inputTax = 1.19 * getTotalNetPrice() - getTotalNetPrice();
		
	}
	public void setGrossFinalPrice() {
		grossFinalPrice = getTotalNetPrice() + getInputTax();
	}

	public Invoice(LocalDate date, int documentNumber, String articleDescription, int itemQuantity, double itemPrice) {
		this.date = date;
	    this.articleDescription = articleDescription;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		setTotalNetPrice();
		setInputTax();
		setGrossFinalPrice();
		this.documentNumber = documentNumber;
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return "Invoice: " + " [Rechnugsdatum = " + date + ", Artikel = " + articleDescription + ", Menge = " + itemQuantity
				+ ", Preis = " + itemPrice + ", Gesamtpreis=" + formatTwoDecimal(totalNetPrice) + ", Vorsteuer=" + formatTwoDecimal(inputTax)
				+ ", Endpreis=" + formatTwoDecimal(grossFinalPrice)  + "]";
	}
	
	public String formatTwoDecimal(double value) {
		String newValue = "";
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		for (Number n : Arrays.asList(value)) {
			Double d = n.doubleValue();	
			newValue = df.format(d);
		}
		return newValue;
		
			    
		} 
	}
	
	
	

