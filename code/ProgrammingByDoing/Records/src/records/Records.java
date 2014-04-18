/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Records {

  /**
   * @param args the command line arguments
   */


  public static void main(String[] args) throws Exception {
    ConsoleIO7 cio = new ConsoleIO7();

//    WebAddresses wAdd = new WebAddresses();
//    wAdd.run();
//
//    cio.println();
//
//    WebAddressesArray wAddAry = new WebAddressesArray();
//    wAddAry.run();
//    
//    cio.println();
//    
//    AddressToString aToStr = new AddressToString();
//    aToStr.run();
    
//    cio.println();
//    
//    BasicRecords b = new BasicRecords();
//    b.run();
//   
    
//    GettingDataFromAFile g = new GettingDataFromAFile();
//    g.run();
    
    
      StoringDataInFile s = new StoringDataInFile();
      //String fileName = s.writeMemory();
      s.readFile("cars.txt"/*fileName*/);
  }

}
