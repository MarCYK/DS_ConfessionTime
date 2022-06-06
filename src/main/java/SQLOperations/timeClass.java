/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQLOperations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Irfan
 */
public class timeClass<T> {
    public String timeNow(){
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mmaa");  
	LocalDateTime now = LocalDateTime.now();
	return dtf.format(now);
    }
}
