/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapsandcollections;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Human {
  private String firstName;
  private String lastName;
  private String address;
  
  public Human(String firstName, String lastName, String address){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
