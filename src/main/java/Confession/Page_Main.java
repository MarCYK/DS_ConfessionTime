package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */
import java.util.Arrays;
import SQLOperations.operationTest;
import java.sql.*;
import java.util.Scanner;

import Spam.SpamDetection;
import static Confession.util.*;
import java.io.File;
public class Page_Main {
    
    public static void main(String[] args) {
        SpamDetection spam = new SpamDetection();
        String str = "";
        System.out.println(spam.classifySpam(str));
    }
    
    public static void user_Page() {
        String str;
        do {
            System.out.println("Welcome to Confession Time");
            str = ask(2,"'0' to close\n'1' to create new post\n'2' to reply to an existing post", "");
            if(isInteger(str)) {
                int choice = Integer.parseInt(str);
                switch(choice) {
                    case 0: return;
                    case 1: newPost();
                    case 2: replyPost();
                }           
            }
        } while(true);
    }
    
    public static void newPost() {
        Scanner in = new Scanner(System.in);
        System.out.println("~~~ Create New Post ~~~");
        System.out.println("Add Content:");
        String content = in.nextLine();
        
        
    }
    
    public static void replyPost() {

    }
}
