package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class showPost{
    private StringProperty thisID;
    private StringProperty content;
    private StringProperty date;
    private StringProperty dateOnly;

    public showPost(String thisID, String content, String date) {
        this.thisID = new SimpleStringProperty(thisID);
        this.content = new SimpleStringProperty(content);
        this.date = new SimpleStringProperty(date);
        String[] temp = (date.toString()).split("\\s");
        this.dateOnly = new SimpleStringProperty(temp[0]);
    }
   

    public String getThisID() {
        return thisID.get();
    }

    public void setThisID(String thisID) {
       this.thisID.setValue(thisID);
    }

    public String getContent() {
        return content.get();
    }

    public void setContent(String content) {
        this.content.setValue(content);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.setValue(date);
    }

    public String getDateOnly() {
        return dateOnly.get();
    }

    public void setDateOnly(String dateOnly) {
        this.dateOnly.setValue(dateOnly);
    }

    @Override
    public String toString() {
        return thisID + "\n[" + date + "]\n\n" + content; 
    }
}


