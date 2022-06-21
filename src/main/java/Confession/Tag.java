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
            ResultSet rs = mysql.sqlSelect("select * from tag order by idtag desc limit 1", conn);rs.next();
            tag = Integer.parseInt(rs.getString("idtag")) + 1;
	    
	    PreparedStatement prp = conn.prepareStatement("insert into tag (note) values ('a')");
	    prp.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "u got error btw lmao (tag error)\n\n"+e.getMessage());
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
}
