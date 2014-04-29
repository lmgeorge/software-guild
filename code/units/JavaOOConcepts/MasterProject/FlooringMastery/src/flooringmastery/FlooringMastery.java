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
public class FlooringMastery {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception {
    InvoicesInterface impl = new InvoicesImpl();

    Order order1 = new Order();
    order1.setOrderNum(201);
    order1.setCustomerName("Hunter Gervelis");
    order1.setState("OH");
    order1.setTaxRate(5.0);
    order1.setProductType("hardwood");
    order1.setArea(10000.0);
    order1.setCostPerSqft(5.50);
    order1.setLaborCostPerSqft(2.50);
    order1.setMaterialCost(6.0);
    order1.setLaborCost(30.0);
    order1.setTotalTax(500.0);
    order1.setTotalCost(1000.0);

    Order order2 = new Order();

    order2.setOrderNum(202);
    order2.setCustomerName("Hunter Gervelis");
    order2.setState("OH");
    order2.setTaxRate(5.0);
    order2.setProductType("hardwood");
    order2.setArea(10000.0);
    order2.setCostPerSqft(5.50);
    order2.setLaborCostPerSqft(2.50);
    order2.setMaterialCost(6.0);
    order2.setLaborCost(30.0);
    order2.setTotalTax(500.0);
    order2.setTotalCost(1000.0);

    impl.add(order1, "04282014");
    impl.add(order2, "04282014");

    impl.writeFile("04282014");
    
    Order orderTest = impl.getOrder("04282014", 201);
    
  }

}
