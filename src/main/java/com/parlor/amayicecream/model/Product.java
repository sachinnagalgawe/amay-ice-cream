package com.parlor.amayicecream.model;

/**
 * 
 * Product model
 * 
 * @author sachin
 */
public class Product {

	private String id;
	
	// product Number
	private int number;
	
	// product barcode
	private double barcode;
	
	// product group
	private String group;
	
	// product description
	private String description;
	
	// product ea
	private double ea;
	
	// product mrp
	private double mrp;
	
	// product rtlrMargin
	private double rtlrMargin;
	
	// product priceToRtlr
	private double priceToRtlr;
	
	private double stockRemaining;

	// Getter and setter methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBarcode() {
		return barcode;
	}

	public void setBarcode(double barcode) {
		this.barcode = barcode;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getEa() {
		return ea;
	}

	public void setEa(double ea) {
		this.ea = ea;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getRtlrMargin() {
		return rtlrMargin;
	}

	public void setRtlrMargin(double rtlrMargin) {
		this.rtlrMargin = rtlrMargin;
	}

	public double getPriceToRtlr() {
		return priceToRtlr;
	}

	public void setPriceToRtlr(double priceToRtlr) {
		this.priceToRtlr = priceToRtlr;
	}

	public double getStockRemaining() {
		return stockRemaining;
	}

	public void setStockRemaining(double stockRemaining) {
		this.stockRemaining = stockRemaining;
	}
}
