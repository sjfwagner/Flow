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
public class AddCorruption {
    
    public AddCorruption( MyNetwork graph) throws java.io.FileNotFoundException
    {
        
        String filename = "new_corruption.csv";
        
        //String filename = "mcglynn.csv";

        String line="";
        String[] parts=null;
        Scanner infile = new Scanner(new File(filename));
        
//        line = infile.nextLine();
//        parts = line.split(",");
        //String nodeName = parts[0];
        
        //corruption is a nodal attribut that acts backwards on other edges
        for (int i = 0; i < graph.getNodes().getSize(); i++)
        {
            line = infile.nextLine();
            parts = line.split(",");
            double c = Double.parseDouble(parts[1]);
            c = 100 - c; 
            //int sr = Integer.parseInt(parts[2]);
            
            graph.getNodes().getNode(i).setCorruption(c);
            //graph.getNodes().getNode(i).setSubregion(sr);
        }
        
        for (int i = 0; i < graph.getNodes().getSize(); i++)
        {
            for (int j = 0; j < graph.getNodes().getSize(); j++)
            {
                
                graph.getEdges().getEdge(i, j).setCorruptionTo(graph.getNodes().getNode(j).getCorruption());
            
            }
                
        }
    
    }
    
} 
