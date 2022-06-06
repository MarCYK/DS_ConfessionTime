package Confession;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.swing.JOptionPane;
import SQLOperations.operationTest;

public class Tag {
    private String thisID;
    static private int tag = -1;

    public String makeTag() {
        operationTest mysql = new operationTest();
        try{
            Connection conn = mysql.getConnection();
            ResultSet rs = mysql.sqlSelect("select * from node order by id desc limit 1", conn);rs.next();
            tag = Integer.parseInt(rs.getString("id")) + 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "u got error btw lmao\n\n"+e.getMessage());
        }
        String formatted = String.format("%05d", tag);
        this.thisID = "#UM" + formatted;
        return thisID;
    }

    public String getThisID() {
        return thisID;
    }

    public void setThisID(String thisID) {
        this.thisID = thisID;
    }

    public int getTag() {
        return tag;
    }

    public static void setTag(int tag) {
        Tag.tag = tag;
    }
    
    //make getLastTag()
}
