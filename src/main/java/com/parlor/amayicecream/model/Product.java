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
	private String barcode;
	
	// product group
	private String group;
	
	// product description
	private String description;
	
	// product ea
	private float ea;
	
	// product mrp
	private float mrp;
	
	// product rtlrMargin
	private float rtlrMargin;
	
	// product priceToRtlr
	private float priceToRtlr;

	// Getter and setter methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public float getEa() {
		return ea;
	}

	public void setEa(float ea) {
		this.ea = ea;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getMrp() {
		return mrp;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public float getRtlrMargin() {
		return rtlrMargin;
	}

	public void setRtlrMargin(float rtlrMargin) {
		this.rtlrMargin = rtlrMargin;
	}

	public float getPriceToRtlr() {
		return priceToRtlr;
	}

	public void setPriceToRtlr(float priceToRtlr) {
		this.priceToRtlr = priceToRtlr;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", number=" + number + ", barcode=" + barcode + ", group=" + group
				+ ", description=" + description + ", ea=" + ea + ", mrp=" + mrp + ", rtlrMargin=" + rtlrMargin
				+ ", priceToRtlr=" + priceToRtlr + "]";
	}
}
