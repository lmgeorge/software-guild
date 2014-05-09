/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringcalculator;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Calculator {

  private double materialCost;
  private double totalCost;
  private double laborCost;

  public double calcMaterialCost(double area, double costPerLnFt) {
    materialCost = area * costPerLnFt;
    return materialCost;
  }

  public double calcLaborCost(double area) {
		double laborPerHr = 86;
		
    laborCost = (Math.floor(area/5)) * (laborPerHr/4);
    
    return laborCost;
  }

 
  public double calcTotalCost() {
    totalCost = materialCost + laborCost;
    return totalCost;
  }

  public double getMaterialCost() {
    return materialCost;
  }



  public double getTotalCost() {
    return totalCost;
  }

  public double getLaborCost() {
    return laborCost;
  }


}
