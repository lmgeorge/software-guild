/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arraylists;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Car {
  private String make;
  private String model;
  private int year;
  private String license;

  ConsoleIO cio = new ConsoleIO();

  public void toStringer(){
    
    cio.println(
      getMake() + " "
    + getModel() + " "
    + getYear() + " "
    + getLicense()
    );
    
  }
  
  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }
  
  
}
