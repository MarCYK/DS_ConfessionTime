package Confession;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Tag {
    private String thisID;
    static private int tag = -1;

    public String makeTag() {
        tag++;
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
