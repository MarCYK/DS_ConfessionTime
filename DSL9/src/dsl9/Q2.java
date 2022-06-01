/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsl9;

/**
 *
 * @author User
 */
public class Q2 {
    
    public static void main(String [] args){
        permuteString("","ABC");
    }
    
    public static void permuteString(String a, String b){
        if(b.length() <= 1)
            System.out.println(a + b);
        
        else{
            for(int i = 0; i < b.length(); i++){
                String c = b.substring(0,i) + b.substring(i+1);
                permuteString(a + b.charAt(i), c);
            }
        }
    }
}

//permuteString(A,B)
//permuteString(B,AB)
//permuteString(C,AB)

