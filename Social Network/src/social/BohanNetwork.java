/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sophiewagner
 */
public class BohanNetwork {
    public MyNetwork n; 

    public MyNetwork getNet() {
        return n;
    }
    
    public MyNetwork BohanAdd(MyNetwork q) throws FileNotFoundException
    {
        String filename = "VaticanLogit1.csv";
        String line = "";
        String[] parts = null;
        Scanner infile = new Scanner(new File(filename));
        
        line = infile.nextLine();
        int length = line.split(",").length;
        int x = 0;
        
        
        while(infile.hasNextLine() && x < q.getN())
        {
            line = infile.nextLine();
            parts = line.split(",");  
            
            q.getNodes().getNode(x).setAge(Integer.parseInt(parts[1]));
            q.getNodes().getNode(x).setGender(Integer.parseInt(parts[2]));
            q.getNodes().getNode(x).setNationality(Integer.parseInt(parts[3]));
            q.getNodes().getNode(x).setSupremacy(Integer.parseInt(parts[4]));
            q.getNodes().getNode(x).setPopulace(Integer.parseInt(parts[5]));

            x +=1;

        }
        
        return q;
        

    }
    
    public BohanNetwork(MyNetwork q) throws FileNotFoundException
    {
        
        String filename = "BohanNetworkData.csv";

        
        
        q = BohanAdd(q);
        this.n = q; 
        String line = "";
        String[] parts = null;
        Scanner infile = new Scanner(new File(filename));
        
        
        
        while(infile.hasNextLine())
        {
            line = infile.nextLine();
            parts = line.split(",");
            //System.out.println("new line");
            ArrayList<String> names = new ArrayList();
            ArrayList<Integer> NodeNums = new ArrayList();
            
            for(int i =0; i < parts.length; i++)
                {
                    parts[i] = parts[i].trim();
                }
            
            if(parts.length > 2)
            {
                for(String x: parts)
                {
                    names.add(x);
                    
                    for(int i =0; i < n.getN(); i++)
                    {
                        if(x.equalsIgnoreCase(n.getNodes().getNode(i).getName()))
                            NodeNums.add(i);
                    }
                }
                
               
            
            }
            
            //for(int i = 0; i < parts.length; i++)
            //{
                
              //  parts[0] = parts[0].trim();
                
                
                
                if(parts[0].equals("Secretary") || parts[0].equalsIgnoreCase("Institute of Curia1"))
                {
                    //System.out.println(parts[0]);
                    for(int j = 0; j < n.getN(); j++)
                    {
                        if(parts[1].equalsIgnoreCase(n.getNodes().getNode(j).getName()))
                        {
                            n.getEdges().getEdge(0, j).setStrength(1.0);
                            
                             n.getEdges().getEdge(j, 0).setStrength(1.0);
                               // System.out.println(n.getNodes().getNode(0).getName());
                                //System.out.println(n.getNodes().getNode(j).getName());
                        }
                    
                    }
                }
                
                else if(parts[0].equalsIgnoreCase("Congregation") || parts[0].equalsIgnoreCase("Tribunal") || parts[0].equalsIgnoreCase("Pontifical Council") || parts[0].equalsIgnoreCase("Pontifical Commission") || parts[0].equalsIgnoreCase("Other Commission1"))
                {
                    for(int j = 0; j < n.getN(); j++)
                    {
                        if(parts[1].equalsIgnoreCase(n.getNodes().getNode(j).getName()))
                        {
                            n.getEdges().getEdge(0, j).setStrength(1.0);
                            n.getEdges().getEdge(1, j).setStrength(1.0);
                            
                            n.getEdges().getEdge(j, 0).setStrength(1.0);
                            n.getEdges().getEdge(j, 1).setStrength(1.0);
                        
                        }
                    
                    }
                
                }
                
                
                else if(parts[0].equalsIgnoreCase("Interdicasterial Commission")|| parts[0].equalsIgnoreCase("Office") || parts[0].equalsIgnoreCase("Institution with Holy See") || parts[0].equalsIgnoreCase("Institute of Curia2") || parts[0].equalsIgnoreCase("Other Commission"))
                {
                    for(int j = 0; j < n.getN(); j++)
                    {
                        if(parts[1].equalsIgnoreCase(n.getNodes().getNode(j).getName()))
                        {
                            n.getEdges().getEdge(1, j).setStrength(1.0);
                            n.getEdges().getEdge(j, 1).setStrength(1.0);
                        
                        }
                    
                    }
                }
                else {
                    //System.out.println(line);
                }
                
                
                
            
            //}
            
            
            //ArrayList<Integer> NodeNums2 = new ArrayList();
            //NodeNums2 = NodeNums; 
            
            for(int i = 0; i < NodeNums.size(); i++)
            {
                for(int j = 0; j < NodeNums.size(); j++)
                {
                    if(i!=j)
                        n.getEdges().getEdge(NodeNums.get(i), NodeNums.get(j)).setStrength(1.0);
                
                }
            
            }
            
            
            
        }
        
        
        for(int i =0; i< n.getN(); i++){
            for(int j = 0; j< n.getN(); j++)
            {
                String[] p = n.getNodes().getNode(i).getName().split(" ");
                String[] t = n.getNodes().getNode(j).getName().split(" ");
                
                if(p[0].equalsIgnoreCase("Cardinal") && t[0].equalsIgnoreCase("Cardinal") )
                {
                    n.getEdges().getEdge(j, i).setStrength(1.0);
                    n.getEdges().getEdge(i, j).setStrength(1.0);
                }
                
            
            }}
        
        
    
    }
    
}
