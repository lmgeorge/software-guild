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
public class Product {
  private double costPerSqft;
  private double laborPerSqft;
  private String name;

  public double getCostPerSqft() {
    return costPerSqft;
  }

  public void setCostPerSqft(double costPerSqft) {
    this.costPerSqft = costPerSqft;
  }

  public double getLaborPerSqft() {
    return laborPerSqft;
  }

  public void setLaborPerSqft(double laborPerSqft) {
    this.laborPerSqft = laborPerSqft;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
