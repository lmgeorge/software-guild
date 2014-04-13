
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleWebInput {

  public static void main(String[] args) throws Exception {
    URL anUrl = new URL("http://textfiles.com/games/ARCADE/aehowto.txt");
    
    Scanner webIn = new Scanner(anUrl.openStream());
    
    while (webIn.hasNextLine()) {
      String line = webIn.nextLine();
      System.out.println(line);
    }
    webIn.close();

  }
}
