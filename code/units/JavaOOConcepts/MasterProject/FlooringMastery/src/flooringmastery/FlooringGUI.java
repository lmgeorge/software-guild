/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmastery;

import java.util.List;
import java.util.Set;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface FlooringGUI {
  public int mainMenu();
	public String convertDate();
	public String getUserState(Set keys);
	public String getUserMatType(Set keys) ;
	public double getUserArea() ;
	public long getUserOrderNum() ;
	public String getUserCustName(String oldName);
	public boolean confirm(String prompt);
	public void print(String str) ;
	public void printTitle(int choice);
	public String toString(Order order);
	public String toString(List<Order> al, String delimiter);
}
