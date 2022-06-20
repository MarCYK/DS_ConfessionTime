package Engine;

import SQLOperations.operationTest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StringSimilarity {
    
    static ArrayList<String> content = new ArrayList<>();
    
    // initialize all contents available
    public StringSimilarity() {
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
    
    public static double similarity(String str1, String str2) {
        String longer = str1, shorter = str2;
        if(str1.length() < str2.length()) {
            longer = str2; shorter = str1;        
        }
        
        int longerLength = longer.length();
        if(longerLength == 0) return 1.0;
        
        return (longerLength - editDistance(longer, shorter))/(double) longerLength;
    }
    
    public static int editDistance(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        int[] costs = new int[str2.length() + 1];
        for(int i = 0; i <= str1.length(); i++) {
            int lastValue = i;
            for(int j = 0; j <= str2.length(); j++) {
                if(i == 0) costs[j] = j;
                else {
                    if(j > 0) {
                        int newValue = costs[j - 1];
                        if(str1.charAt(i - 1) != str2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if(i > 0)
                costs[str2.length()] = lastValue;
        }
        return costs[str2.length()];
    }
    
    public static boolean isSimilar(String str) {
        for(String temp : content) {
            System.out.println(str + " " + temp);
            System.out.println(similarity(str, temp));
            if(similarity(temp, str) >= 0.8)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        StringSimilarity ss = new StringSimilarity();
        isSimilar("");
        isSimilar("1234567890");
        isSimilar("1234567890");
        isSimilar("1234567890");
        isSimilar("1234567890");
    }
    
}
