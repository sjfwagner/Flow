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
public class TextAnalyzer {
    //this should be an empty network w/ all the nodes names all all empty 0s for connections
    MyNetwork mn = new MyNetwork("sample.csv");
    //MyNodes nodes = mn.getNodes();
    //MyEdges edges = mn.getEdges();

    public MyNetwork getMn() {
        return mn;
    }
    
    public TextAnalyzer(String name, MyNetwork graph) throws java.io.FileNotFoundException
    {
        
        String filename = name;
        //String filename = "mcglynn.csv";

        String line="";
        String[] parts=null;
        Scanner infile = new Scanner(new File(filename));
        
        //line = infile.nextLine();
        //parts = line.split(",");
        //String nodeName = parts[0];
        
        while(infile.hasNext()){
        
            line = infile.nextLine();
            parts = line.split(",");
            String nodeName = parts[0];
            
            for(int i = 0; i < mn.getNodes().getSize(); i++)
            {
                if(nodeName.equalsIgnoreCase(mn.getNodes().getNode(i).getName()))
                {
                    int tofrom = 0; 
                    
                    //if cntname = 1, p[j] is not a country name and should be tested
                    // 1 is to, 2 is from
                    String text = parts[1];
                    String[] p = text.split(" ");
                    for(int j = 0; j < p.length; j++)
                    {
                        int cntname = 1; 
                        
                        if(p[j].contains("to") || p[j].contains("through") ){tofrom = 1; cntname = 0; }
                        else if(p[j].contains("from") || p[j].contains("in")){tofrom = 2; cntname = 0; }
                        else if(cntname == 1){
                        for(int x = 0; x < mn.getNodes().getSize(); x++)
                        {
                            
                            if(p[j].contains(mn.getNodes().getNode(x).getName()) && tofrom > 0){
                                if(x != i){
                                if(tofrom == 1){ mn.getEdges().getEdge(i, x).setStrength(1.0);}
                                else if(tofrom == 2){mn.getEdges().getEdge(x, i).setStrength(1.0);}
                                }
                            }
                        }
                    }
                    }
                    
                    
                }
            
            }
           
            
            
        } 
    
    }
    
}   
