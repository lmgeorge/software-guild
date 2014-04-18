/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitoneskillcheck;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Counter {

  ConsoleIO4 cio = new ConsoleIO4();

  public static void main(String[] args) {
    ConsoleIO4 cio = new ConsoleIO4();
    Counter ctr = new Counter();

    ctr.to10();
    cio.println();

    ctr.toN(3);
    cio.println();

    //ctr.toN(8);
    cio.println();

    //ctr.toN(200);
    cio.println();

  }

  public void to10() {
    for (int i = 1; i <= 10; i++) {
      cio.println(i);
    }
  }

  public void toN(int n) {
    for (int i = 0; i <= n; i++) {
      cio.println(i);
    }
  }

}
