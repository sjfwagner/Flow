/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.SparseMultigraph;

/**
 *
 * @author sophiewagner
 */
public class StdCloseness {
    SparseMultigraph<MyNode, MyEdge> sm;
    MyNetwork mn; 
    
   
    
    public StdCloseness(SparseMultigraph<MyNode, MyEdge> graph, MyNetwork net)
    {
        this.sm = graph; 
        this.mn = net; 
    }
    
    public double findCloseness(int i )
    {
        int n = mn.getNodes().getSize(); 
        double numerator = 1.0; 
        double total = 0.0; 
        
        for (int j = 0; j < n; j++)
        {
            if(j != i){
                
                double distance = ShortestPath.ShortestDistance(mn.nodes.getNode(i), mn.nodes.getNode(j), sm);
                if (distance != 0)
                    total = total + (numerator/distance);
                    System.out.println(distance);
            }
        }
        
        
        return total; 
    }
    
}
