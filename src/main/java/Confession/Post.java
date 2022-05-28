package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Post implements Serializable{
    private String thisID = "#UM";
    private String content;
    private Timestamp date;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mmaa");

    public Post(int thisID, String content) {
        String formatted = String.format("%05d", thisID);
        this.thisID += formatted;
        this.content = content;
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public String getThisID() {
        return thisID;
    }

    public void setThisID(int thisID) {
        String formatted = String.format("%05d", thisID);
        this.thisID += formatted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return thisID + "\n[" + sdf.format(date) + "]\n\n" + content; 
    }
}


