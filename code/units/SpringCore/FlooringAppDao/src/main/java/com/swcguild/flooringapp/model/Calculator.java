/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringapp.model;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Calculator {

  private double materialCost;
  private double totalTax;
  private double totalCost;
  private double laborCost;

  public double calcMaterialCost(double area, double costPerSqft) {
    materialCost = area * costPerSqft;
    return materialCost;
  }

  public double calcLaborCost(double area, double laborPerSqft) {
    laborCost = area * laborPerSqft;
    
    return laborCost;
  }

  public double calcTotalTax(double taxRate) {
    totalTax = (taxRate/100) * (materialCost + laborCost);
    return totalTax;
  }

  public double calcTotalCost() {
    totalCost = totalTax + materialCost + laborCost;
    return totalCost;
  }

  public double getMaterialCost() {
    return materialCost;
  }

  public void setMaterialCost(double materialCost) {
    this.materialCost = materialCost;
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

  public double getLaborCost() {
    return laborCost;
  }

  public void setLaborCost(double laborCost) {
    this.laborCost = laborCost;
  }

}
