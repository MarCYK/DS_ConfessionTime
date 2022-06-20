package Engine;

/**
 *
 * @author Marvin Chin Yi Kai
 */

//use to clean data scrapped from facebook/twitter/etc
import java.io.*;
import java.util.*;
public class Clean {

    public static void main(String[] args) {
        int count = 1;
        try {          
            Scanner sc = new Scanner(new File("src\\main\\resources\\DataSet\\FBdata.txt"));
            sc.useDelimiter(",,,");
            while(sc.hasNext()) {
                String str = sc.nextLine();
                System.out.println(count);
                System.out.print(str);
                count++;
            }
            sc.close();        
        } catch (Exception e) {
            System.out.println("Error in Cleaning data");
        }
        
        System.out.println(count);
    }
    
}
