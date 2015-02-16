package social;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sophiewagner
 */


import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


public class MyNetwork {
    private MyEdges edges;
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
    
//    public Integer getE()
//    {
//    
//    
//    }
// 
    
    public MyNetwork(String fn) throws java.io.FileNotFoundException
    {
        
        String filename = fn;
        //String filename = "mcglynn.csv";

        String line="";
        String[] parts=null;
        Scanner infile = new Scanner(new File(filename));
        
        // process first line
        line = infile.nextLine();
        parts = line.split(",");
        
        for(int i =0; i < parts.length; i++)
                {
                    parts[i] = parts[i].trim();
                }
        
        this.n = parts.length-1;
        //this.n = parts.length; 
        
        this.nodes = new MyNodes(this.n);
        this.edges = new MyEdges(this.n);
        //System.out.println("Number of countries = "+n);
        
        for(int i = 0; i<this.n;i++)
        {
             line = infile.nextLine();
             parts = line.split(",");
             
             for(int x =0; x < parts.length; x++)
                {
                    parts[x] = parts[x].trim();
                }
             
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

    public MyNetwork(MyNetwork nw) {
       this.edges = new MyEdges(nw.edges);
       this.nodes = new MyNodes(nw.nodes);
       this.n = nw.getN();
    
    }

    @Override
    public String toString() {
        return edges.toString() + "\n " + nodes.toString();
    }

   
    
   
    
    
}
