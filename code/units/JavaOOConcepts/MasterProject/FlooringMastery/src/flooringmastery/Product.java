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
  private float costPerSqft;
  private float laborPerSqft;
  private String name;

  public float getCostPerSqft() {
    return costPerSqft;
  }

  public void setCostPerSqft(float costPerSqft) {
    this.costPerSqft = costPerSqft;
  }

  public float getLaborPerSqft() {
    return laborPerSqft;
  }

  public void setLaborPerSqft(float laborPerSqft) {
    this.laborPerSqft = laborPerSqft;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
