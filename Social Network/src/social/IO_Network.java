/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class IO_Network {
    BufferedWriter nodeStream ;
    BufferedWriter edgeStream ;

    String timestamp;
    
    public IO_Network(){
        timestamp= getDateTime();
        try {
            nodeStream = new BufferedWriter(new FileWriter("snaNode."+timestamp+".tab"));
            edgeStream = new BufferedWriter(new FileWriter("snaEdge."+timestamp+".tab"));
        } catch (IOException ex) {
            Logger.getLogger(IO_Network.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private   static String getDateTime()  
{  
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");  
    df.setTimeZone(TimeZone.getTimeZone("America/Chicago"));  
    return df.format(new Date());  
} 
    public  void WriteNodeToCSV(MyNodes un,boolean flag) throws  IOException
		{
			int Un_i,At_j;
			// open output file
			

			if(flag)
			nodeStream.write(un.WriteHeader());

                        if(un==null)
                            
                            nodeStream.close();
			else
                            nodeStream.write(un.WriteNodes());

		
			
		
		}
    public  void WriteEdgesToCSV(MyEdges un,boolean flag) throws  IOException
		{
			int Un_i,At_j;
			// open output file
			

			if(flag)
			edgeStream.write(un.WriteHeader());

                        if(un==null)
                            
                            edgeStream.close();
			else
                            edgeStream.write(un.WriteEdges());

		
                        
                        
			
		
		}

    void close() {
        try {
            nodeStream.close();
            edgeStream.close();
        } catch (IOException ex) {
            Logger.getLogger(IO_Network.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTimestamp() {
        return timestamp;
    }


    
}
