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
public class AddSD {
    
    public AddSD( MyNetwork graph) throws java.io.FileNotFoundException
    {
        
        String filename = "tsd.csv";
        
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
            System.out.println(line);
            parts = line.split(",");
            double t = Double.parseDouble(parts[1]);
            double s = Double.parseDouble(parts[2]);
            double d = Double.parseDouble(parts[3]);
            
            //int sr = Integer.parseInt(parts[2]);
            
            graph.getNodes().getNode(i).setD(d);
            graph.getNodes().getNode(i).setS(s);
            graph.getNodes().getNode(i).setT(t);
            //graph.getNodes().getNode(i).setSubregion(sr);
        }
        
        for (int i = 0; i < graph.getNodes().getSize(); i++)
        {
            for (int j = 0; j < graph.getNodes().getSize(); j++)
            {
                
                graph.getEdges().getEdge(i, j).setSi(graph.getNodes().getNode(i).getS());
                graph.getEdges().getEdge(i, j).setDj(graph.getNodes().getNode(i).getD());
            
            }
                
        }
    
    }
    
} 
