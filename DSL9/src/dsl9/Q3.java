/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsl9;

/**
 *
 * @author User
 */
public class Q3 {
    
    public static void main(String [] args){
        System.out.print(exponent(10,3));
        
    }
    
    public static long exponent(int x, int m){
        if(m == 0)
            return 1;
        
        else{
            return x * exponent(x,m-1);
        }
    }
}
