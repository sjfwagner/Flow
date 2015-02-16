/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sophiewagner
 */
public class NodeFlow {
    public MyNetwork traffic; 
    public MyNetwork od; 
    public MyNode target; 
    public DirectedSparseMultigraph flowGraph; 
    
    
    public NodeFlow(MyNetwork t, MyNetwork o)
    {
        traffic = t; 
        od = o; 
        
    
    }
 
    
    public void DoAnalysis()
    {
        for (int j = 0; j < od.getN(); j++)
        {
            if(od.getEdges().getEdge(target.getNumber(), j).getStrength() > 0 )
            {
                EdmondsKarp ek = new EdmondsKarp(traffic, target, traffic.getNodes().getNode(j));
                AppendFlowOnAllODPaths(ek);
                FindBottleneckingAreas(ek);   
                
            }
        
        }
    
        
    }
    
    public MyNetwork ReturnPathFlowGraph()
    {
        return traffic; 
    }
    
    public MyNetwork ReturnODFlowGraph()
    {
        return od; 
    
    }
    
    
    
    public void AppendFlowOnAllODPaths(EdmondsKarp ek)
    {
   
        for(int i = 0; i < traffic.getN(); i++){
            for(int j = 0; j < traffic.getN(); j++)
            {
                //if the edge hasn't had flow added to it, put initial flow down
                if(traffic.getEdges().getEdge(i, j).getFlow() == 0.0)
                    traffic.getEdges().getEdge(i, j).setFlow(EdgeFlowValue(ek, traffic.getEdges().getEdge(i, j)).doubleValue());
                
                //if the edge has had flow added to it, increase the total
                traffic.getEdges().getEdge(i, j).addFlow(EdgeFlowValue(ek, traffic.getEdges().getEdge(i, j)).doubleValue());
            }
        }
    
    } 

    
    //create a sister method to REPORT the bottlenecking areas
    public void FindBottleneckingAreas(EdmondsKarp ek)
    {
       Set<MyEdge> arcs = ek.mincut;
       
       
       for (MyEdge a: arcs)
       {
           for(int i = 0; i < traffic.getN(); i++){
            for(int j = 0; j < traffic.getN(); j++){
                if(a.getFrom() == i && a.getTo() == j)
                {
                    traffic.getEdges().getEdge(i, j).setBottleneckdegree(1);
                }
            
            }
           
           }
       }
       //return arcs; 
    
    }
    
     public Number EdgeFlowValue(EdmondsKarp ek, MyEdge e)
    {
        Map<MyEdge,Number> mp = ek.edgeFlowMap;
        
        if (mp.containsKey(e))
        {
           return mp.get(e);
        }
        
        else{return 0.0;}
        
        
        
    }
    
    //a method that returns the destinations of target nation and max flow to that nation
    //a method that returns a graph with all ^^ information
    //
    
}
