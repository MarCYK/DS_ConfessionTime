/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsl9;

/**
 *
 * @author User
 */
public class DSL9Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print(substituteAI("flabbergasted"));
    }
    
    public static String substituteAI(String str){
        String rplcstr = "";
        if(str.length() == 0)
            return rplcstr;
        
        else{
            char rplc = str.charAt(0);
            if(rplc == 'a'){
                rplcstr = rplcstr + 'i' + substituteAI(str.substring(1)); 
            }
            else{
                rplcstr = rplcstr + rplc + substituteAI(str.substring(1));
            }
        }
        return rplcstr;
    }
}
        
        
    
            
    

