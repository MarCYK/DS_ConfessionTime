package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */
//Quality for life methods
import java.util.ArrayList;
import java.util.Scanner;
public class util {
    private static ArrayList<ArrayList<String>> choices = new ArrayList<>();
    
    public static String ask(int len, String command, String choices) {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println(choices);
            System.out.println(command);
            String sc = in.nextLine();
            if(isInteger(sc)) {
                Integer res = Integer.parseInt(sc);
                if(0 <= res && res <= len) {
                    return res.toString();
                } else {
                    System.out.println("Invalid Input");
                    prompt_any();
                } 
            } else {
                System.out.println("Invalid input");
                prompt_any();
            }
        }
    }
    
    public static boolean isInteger(String sc){
        try{
            Integer.parseInt(sc);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static void prompt_any(){
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to continue.");
        in.nextLine();
    }
}
