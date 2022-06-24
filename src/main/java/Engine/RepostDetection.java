package Engine;

/**
 *
 * @author Marvin Chin Yi Kai
 */

import SQLOperations.operationTest;
import info.debatty.java.stringsimilarity.*;
import java.util.ArrayList;
import java.sql.*;

/*
The Levenshtein distance between two words is the minimum number of single-character edits 
(insertions, deletions or substitutions) required to change one word into the other.
This distance is computed as levenshtein distance divided by the length of the longest string. 
The resulting value is always in the interval [0.0 1.0]

The similarity is computed as 1 - normalized distance.
*/
public class RepostDetection {
    NormalizedLevenshtein ro = new NormalizedLevenshtein();
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
        String str = "content ";
        System.out.println(rp.checkRepost(str));
    }
}
