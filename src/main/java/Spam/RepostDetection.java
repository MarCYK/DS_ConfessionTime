package Spam;

/**
 *
 * @author Marvin Chin Yi Kai
 */

import SQLOperations.operationTest;
import info.debatty.java.stringsimilarity.RatcliffObershelp;
import java.util.ArrayList;
import java.sql.*;

public class RepostDetection {
    RatcliffObershelp ro = new RatcliffObershelp();
    static ArrayList<String> content = new ArrayList<>();
    
    // initialize all contents available
    public RepostDetection() {
        operationTest sql = new operationTest();
        String text = "";
        try{
            Connection conn = sql.getConnection();
            ResultSet rs = sql.sqlSelect("select * from node", conn);
            int i=0;
            while(rs.next()){
                text = rs.getString("content");
                content.add(i, text);
                i++;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // if >0.9 similirity score, label as repost
    public boolean checkRepost(String str) {
        for(String temp : content) {
            System.out.println(str + " " + temp);
            System.out.println(ro.similarity(temp, str));
            if(ro.similarity(temp, str) >= 0.8)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        RepostDetection rp = new RepostDetection();
        String str = "tset Abobe CreativeSi1te 5 M1ster C0llection fr0m chaep 4zp";
        System.out.println(rp.checkRepost(str));
    }
}
