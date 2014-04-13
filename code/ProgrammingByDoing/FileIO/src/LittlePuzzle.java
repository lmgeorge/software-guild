
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LittlePuzzle {

  public static void main(String[] args) throws Exception {
    URL anUrl = new URL("http://programmingbydoing.com/a/examples/puzzle.txt");

    Scanner webIn = new Scanner(anUrl.openStream());

    while (webIn.hasNextLine()) {
      String line = webIn.nextLine();

      for (int i = 2; i < line.length(); i += 3) {
        System.out.print(line.charAt(i));
      }
    }
    System.out.println();
    webIn.close();

  }
}
