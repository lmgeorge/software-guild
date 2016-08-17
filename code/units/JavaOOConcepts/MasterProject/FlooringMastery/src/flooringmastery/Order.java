/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Order {

	private long orderNum;
	private String customerName;
	private String state;
	private double taxRate;
	private double costPerSqft;
	private double materialCost;
	private double laborCost;
	private double laborCostPerSqft;
	private double totalTax;
	private double totalCost;
	private String productType;
	private double area;

	
	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getCostPerSqft() {
		return costPerSqft;
	}

	public void setCostPerSqft(double costPerSqft) {
		this.costPerSqft = costPerSqft;
	}

	public double getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(double materialCost) {
		this.materialCost = materialCost;
	}

	public double getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(double laborCost) {
		this.laborCost = laborCost;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getLaborCostPerSqft() {
		return laborCostPerSqft;
	}

	public void setLaborCostPerSqft(double laborCostPerSqft) {
		this.laborCostPerSqft = laborCostPerSqft;
	}


}
