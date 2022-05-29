/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Confession;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Submit<E> {
    
    private String contents;
    private String reply;
    private String IDcontents;
    private String IDreply;
    private int line;
    private Date date = new Date();
    private LinkedList<E> rep = new LinkedList<>();
    private LinkedList<E> crt = new LinkedList<>();

    public Submit() {
        contents = "";
        reply = "";
        this.IDcontents = IDcontents;
        this.IDreply = IDreply;
        this.date = date;
        this.rep = rep;
        this.crt = crt;
        line = 0;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getIDcontents() {
        return IDcontents;
    }

    public void setIDcontents(String IDcontents) {
        this.IDcontents = IDcontents;
    }

    public String getIDreply() {
        return IDreply;
    }

    public void setIDreply(String IDreply) {
        this.IDreply = IDreply;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Queue<E> getRep() {
        return rep;
    }

    public void setRep(LinkedList<E> rep) {
        this.rep = rep;
    }

    public Queue<E> getCrt() {
        return crt;
    }

    public void setCrt(LinkedList<E> crt) {
        this.crt = crt;
    }

    public int getLine() {
        return line-1;
    }

    public void setLine(int line) {
        this.line = line;
    }
    
    
    //Method to generate ID for contents
    public String IDcontentsgenerate(){
        try{
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\User\\OneDrive\\Documents\\UM SE\\Y1S2\\WIA1002 UM\\ConfessionContent.txt"));
            line=0;
            while(in.hasNextLine()){
                in.nextLine();
                line++;

            
            }
            in.close();
        }
        
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
        IDcontents = String.format("%04d",getLine());
        return "UM" + getIDcontents();
                
    }
    
    //Method to generate ID for reply
    public String IDreplygenerate(){
        try{
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\User\\OneDrive\\Documents\\UM SE\\Y1S2\\WIA1002 UM\\ConfessionReply.txt"));
            while(in.hasNextLine()){
                in.nextLine();
                line++;

            
            }
            in.close();
        }
        
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
        IDreply = String.format("%04d",getLine());
        return "UM" + getIDreply();
                
    }
    
    //Method to save reply to text file after they have been submitted
    public void saveToReplyTxt(){
        try{
            PrintWriter out = new PrintWriter(new FileOutputStream("C:\\Users\\User\\OneDrive\\Documents\\UM SE\\Y1S2\\WIA1002 UM\\ConfessionReply.txt",true));
            out.print(getDate() + " || " + IDreplygenerate() + " || " + " || " + IDcontentsgenerate() + " || " + getReply());
            out.close();
        }

        catch(IOException e){
            System.out.println("Problem with file output");
        }
    }
    
    //Method to save contents to text file after they have been submitted
    public void saveToContentsTxt(){
        try{
           PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\User\\OneDrive\\Documents\\UM SE\\Y1S2\\WIA1002 UM\\ConfessionContent.txt",true));
           // FileWriter fw = new FileWriter("C:\\Users\\User\\OneDrive\\Documents\\UM SE\\Y1S2\\WIA1002 UM\\ConfessionContent.txt",true);
           // BufferedWriter bw = new BufferedWriter(fw);
           // PrintWriter pw = new PrintWriter(bw);
           pw.println(getDate() + " || " + IDcontentsgenerate() + " || " + getContents());
//            pw.flush();
           pw.close();
        }

        catch(IOException e){
            System.out.println("Problem with file output");
        }
    }
    
    //Method to type reply to an exisiting contents
    public void reply(){
        String brek = "-1";
        Scanner sc = new Scanner(System.in);
            
        System.out.println("---------------------------------------------------------------");
        System.out.println(">> Confession post ID exists!");
        System.out.println("===============================================================");
        System.out.println();
        System.out.println();
        System.out.println("===============================================================");
        System.out.println(">> Please enter your confession content.");
        System.out.println(">> Insert \"-1\" to submit your confession.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Confession content:");
                    
        while(!contents.equals(brek)){
            contents = sc.next();
            line++;
            if(line > 5)
                break;
        }
                    
        System.out.println("===============================================================");
        System.out.println();
        System.out.println();
        System.out.println("===============================================================");
        System.out.println(">> Submitted at " + date);
        System.out.println(">> Confession post ID: " + IDreplygenerate());
            
        System.out.println(">> Your confession will be published soon.");
        System.out.println("===============================================================");
    }
    
    //Method to create new contents into confession page
    public void create(){
        String brek = "-1";
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================================================");
        System.out.println(">> Please enter your confession content.");
        System.out.println(">> Insert \"-1\" to submit your confession.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Confession content:");
                   
        while(!contents.equals(brek)){
            contents = sc.next();
            line++;
            if(line > 5)
                break;
        }    
        System.out.println("===============================================================");
        System.out.println();
        System.out.println();
        System.out.println("===============================================================");
        System.out.println(">> Submitted at " + date);
        System.out.println(">> Confession post ID: " + IDcontentsgenerate());
            
        System.out.println(">> Your confession will be published soon.");
        System.out.println("===============================================================");
    }
    
    public void enqueueRep(E e){
        rep.addLast(e);
        
    }
    
    public void enqueueCrt(E e){
        crt.addLast(e);
    }
    
    public E dequeueRep(){
        return rep.removeFirst();
        
    }
    
    public E dequeueCrt(){
        return crt.removeFirst();
    }
    
    public int getSizeRep(){
        return rep.size();
    }
    
    public int getSizeCrt(){
        return crt.size();
    }
  
}
