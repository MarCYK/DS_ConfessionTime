package Engine;

import SQLOperations.operationTest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    static ArrayList<Integer> id = new ArrayList<>();
    static operationTest sql = new operationTest();

    public static ArrayList<Integer> getId() {
	return id;
    }

    public static void main(String[] args) {
	System.out.println("1: keyword \n2: id \n3: date \n4: date & time");
	Scanner scan = new Scanner(System.in);
	int choice = scan.nextInt();
	System.out.println("Search: ");
	scan.nextLine();
	String search = scan.nextLine();
	switch(choice){
	    case 1: searchKeyword(search);
		    break;
	    case 2: searchID(search);
		    break;
	    case 3: searchDate(search);
		    break;
	    case 4: searchDateTime(search);
		    break;
	}
	
	if(id.isEmpty()) {
	    System.out.println("Not found");
	} else {
	    for(int i : id) {
		System.out.println(i);
	    }
	}
    }
    
    //search based on keyword
    public static void searchKeyword(String keyword) {
	try{
            Connection conn = sql.getConnection();
            ResultSet rs = sql.sqlSelect("select * from node", conn);
            while(rs.next()){
                String content = rs.getString("content");
		if(checkKeyword(keyword, content)) {
		    id.add(rs.getInt("id"));
		}
            }
	}catch(Exception e){
	    System.out.println("get ratioed lmao");
	}
    }
    
    public static boolean checkKeyword(String keyword, String content) {
	return content.toLowerCase().contains(keyword.toLowerCase());
    }
    
    //Search based on ID
    public static void searchID(String keyword) {
	try{
            Connection conn = sql.getConnection();
            ResultSet rs = sql.sqlSelect("select * from node", conn);
            while(rs.next()){
                String content = rs.getString("thisID");
		if(checkID(keyword, content)) {
		    id.add(rs.getInt("id"));
		}
            }
	}catch(Exception e){
	    System.out.println("get ratioed lmao");
	}
    }
    
    public static boolean checkID(String keyword, String content) {
	return content.toLowerCase().equals(keyword.toLowerCase());
    }
    
    //search based on Date
    public static void searchDate(String keyword) {
	try{
            Connection conn = sql.getConnection();
            ResultSet rs = sql.sqlSelect("select * from node", conn);
            while(rs.next()){
                String content = rs.getString("date");
		String[] date = content.split("\\s");
		if(checkDate(keyword, date[0])) {
		    id.add(rs.getInt("id"));
		}
            }
	}catch(Exception e){
	    System.out.println("get ratioed lmao");
	}
    }
    
    public static boolean checkDate(String keyword, String content) {
	return content.toLowerCase().equals(keyword.toLowerCase());
    }   
    
    //search based on Date & Time
    public static void searchDateTime(String keyword) {
	try{
            Connection conn = sql.getConnection();
            ResultSet rs = sql.sqlSelect("select * from node", conn);
            while(rs.next()){
                String content = rs.getString("date");
		if(checkDateTime(keyword, content)) {
		    id.add(rs.getInt("id"));
		}
            }
	}catch(Exception e){
	    System.out.println("get ratioed lmao");
	}
    }
    
    public static boolean checkDateTime(String keyword, String content) {
	return content.toLowerCase().equals(keyword.toLowerCase());
    }  
    
}
