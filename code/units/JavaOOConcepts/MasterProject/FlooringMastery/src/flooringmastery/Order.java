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
  private float taxRate;
  private float costPerSqft;
  private float materialCost;
  private float laborCost;
  private float totalTax;
  private float totalCost;
  private String productType;
  private float area;

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

  public float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(float taxRate) {
    this.taxRate = taxRate;
  }

  public float getCostPerSqft() {
    return costPerSqft;
  }

  public void setCostPerSqft(float costPerSqft) {
    this.costPerSqft = costPerSqft;
  }

  public float getMaterialCost() {
    return materialCost;
  }

  public void setMaterialCost(float materialCost) {
    this.materialCost = materialCost;
  }

  public float getLaborCost() {
    return laborCost;
  }

  public void setLaborCost(float laborCost) {
    this.laborCost = laborCost;
  }

  public float getTotalTax() {
    return totalTax;
  }

  public void setTotalTax(float totalTax) {
    this.totalTax = totalTax;
  }

  public float getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(float totalCost) {
    this.totalCost = totalCost;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public float getArea() {
    return area;
  }

  public void setArea(float area) {
    this.area = area;
  }
  
}
