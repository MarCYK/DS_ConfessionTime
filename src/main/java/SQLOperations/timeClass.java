package SQLOperations;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Irfan
 */
public class timeClass {
    private Timestamp date;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mmaa");
    
    public String timeNow(){
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");  
//	LocalDateTime now = LocalDateTime.now();

	this.date = new Timestamp(System.currentTimeMillis());
	return sdf.format(date);
    }
}
