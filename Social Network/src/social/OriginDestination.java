/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author sophiewagner
 */
 

public class OriginDestination {
    public MyEdges edges;
    public MyNodes nodes;
    private Integer n; 

    public Integer getN() {
        return n;
    }
    

    public MyEdges getEdges() {
        return edges;
    }

    public MyNodes getNodes() {
        return nodes;
    }
 
    
    public OriginDestination() throws java.io.FileNotFoundException
    {
        
        String filename = "EKX.csv";
        //String filename = "mcglynn.csv";
        String line="";
        String[] parts=null;
        Scanner infile = new Scanner(new File(filename));
        
        // process irst line
        line = infile.nextLine();
        parts = line.split(",");
        this.n=parts.length-1;
        this.nodes = new MyNodes(this.n);
        this.edges = new MyEdges(this.n);
        //System.out.println("Number of countries = "+n);
        
        for(int i = 0; i<this.n;i++)
        {
             line = infile.nextLine();
             parts = line.split(",");
            String nodeName = parts[0];
            
            //nodes.add(new Node(nodeName, new Integer(i)));
            MyNode a = new MyNode(nodeName, new Integer(i),'r');
            nodes.setNode(i, a);
            
            //System.out.println("Countries name= "+nodeName);
            for(int j = 0; j<n;j++) {
                String value=parts[j+1];
                //System.out.println("i="+ i+ " j=" +j+ " value= "+value);
           
                MyEdge e = new MyEdge(new Integer(i), new Integer(j), new Double(value) ,true);
                //System.out.println(e);
                edges.setEdge(i,j,e);
                }
       
            
             
        }
        edges.setNodes(nodes);
        
        
        
    }
/*
    public OriginDestination(social.MyNetwork nw) {
       this.edges = new MyEdges(nw.edges);
       this.nodes = new MyNodes(nw.nodes);
    
    }
*/
    @Override
    public String toString() {
        return edges.toString() + "\n " + nodes.toString();
    }

  
    
    int getNonDeletedCountEdge() {
        int count = 0;
        
        for( int i = 0; i < nodes.getSize(); i++)
        for( int j = 0; j < nodes.getSize(); j++)

        {
            if(!edges.getEdge(i, j).isDeleted())
            {
               count ++;  
            }
        }
        
        return count; 
    }
    
    
}

