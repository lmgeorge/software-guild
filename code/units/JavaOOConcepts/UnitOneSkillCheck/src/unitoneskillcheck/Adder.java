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
public class Adder {

  public static void main(String[] args) {
    ConsoleIO4 cio = new ConsoleIO4();
    Adder adder = new Adder();
    int c;
    float percent = 0;
    c = adder.add(1, 1);
    if (c == 2) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }

    c = adder.add(2, 3);
    if (c == 2 + 3) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }

    c = adder.add(5, 8);
    if (c == 5 + 8) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }

    c = adder.add(95, 42);
    if (c == 95 + 42) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }

    cio.println((percent / 4) * 100 + "% of Adder tests passed.\n");

  }

  public int add(int a, int b) {
    return a + b;

  }

}
