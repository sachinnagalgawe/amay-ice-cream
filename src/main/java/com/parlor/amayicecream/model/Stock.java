package com.parlor.amayicecream.model;

public class Stock {

	private int stockRemaining;
	
	private int totalOrdered;

	public double getStockRemaining() {
		return stockRemaining;
	}

	public void setStockRemaining(int stockRemaining) {
		this.stockRemaining = stockRemaining;
	}

	public double getTotalOrdered() {
		return totalOrdered;
	}

	public void setTotalOrdered(int totalOrdered) {
		this.totalOrdered = totalOrdered;
	}
}
