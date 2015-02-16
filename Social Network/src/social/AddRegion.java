/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author sophiewagner
 */
public class AddRegion {
    
    public AddRegion(String name, MyNetwork graph) throws java.io.FileNotFoundException
    {
        
        String filename = name;
        //String filename = "mcglynn.csv";

        String line="";
        String[] parts=null;
        Scanner infile = new Scanner(new File(filename));
        
//        line = infile.nextLine();
//        parts = line.split(",");
        //String nodeName = parts[0];
        
        for (int i = 0; i < graph.getNodes().getSize(); i++)
        {
            line = infile.nextLine();
            parts = line.split(",");
            int r = Integer.parseInt(parts[1]);
            int sr = Integer.parseInt(parts[2]);
            
            graph.getNodes().getNode(i).setRegion(r);
            graph.getNodes().getNode(i).setSubregion(sr);
        }
    
    }
    
}   
