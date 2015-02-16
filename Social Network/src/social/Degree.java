/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.algorithms.scoring.DegreeScorer;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

/**
 *
 * @author sophiewagner
 */
public class Degree {
    
    public MyNetwork graph;
    public DirectedSparseMultigraph<MyNode, MyEdge> jg;
    //public DegreeScorer degree; 
    
    public Degree(MyNetwork g)
    {
        graph = g; 
        //jg = JungGraphFactory.makeDirectedGraph(graph.getNodes(), graph.getEdges());
        
        //degree = new DegreeScorer(jg);
        
       
    
    }
    
    public Integer OutDegree(MyNode x)
    {
        int degreecount = 0; 
        int i = x.getNumber();
        for(int j = 0; j < graph.getN(); j++)
        {
            if(graph.getEdges().getEdge(i, j).getStrength() > 0)
            {
                degreecount++; 
            }
        }
        
        System.out.println(x.getName() + ", " + degreecount);
        return degreecount; 
    
    
    }
    
     public Integer InDegree(MyNode x)
    {
        int degreecount = 0; 
        int i = x.getNumber();
        for(int j = 0; j < graph.getN(); j++)
        {
            if(graph.getEdges().getEdge(j, i).getStrength() > 0)
            {
                degreecount++; 
            }
        }
        
        System.out.println(x.getName() + ", " + degreecount);
        return degreecount; 
    
    
    }
     
     
    public Integer TotalDegree(MyNode x)
    {
        int degreecount = 0; 
        int i = x.getNumber();
        for(int j = 0; j < graph.getN(); j++)
        {
            if(graph.getEdges().getEdge(j, i).getStrength() > 0 && (graph.getEdges().getEdge(j, i).isDeleted() == false))
            {
                degreecount++; 
            }
             if(graph.getEdges().getEdge(i, j).getStrength() > 0 && (graph.getEdges().getEdge(i, j).isDeleted() == false))
            {
                degreecount++; 
            }
        }
        
        System.out.println(x.getName() + ", " + degreecount);
        return degreecount; 
    
    
    }
    
    
    public MyNetwork AssignOutDegree()
    {
         for(int i = 0; i < graph.getN(); i++)
        {
            graph.getNodes().getNode(i).setDegree(OutDegree(graph.getNodes().getNode(i)));
        }
    
         return graph; 
    }
    
     public MyNetwork AssignInDegree()
    {
         for(int i = 0; i < graph.getN(); i++)
        {
            graph.getNodes().getNode(i).setDegree(InDegree(graph.getNodes().getNode(i)));
        }
    
         return graph; 
    }
     
     public MyNetwork AssignTotalDegree()
    {
         for(int i = 0; i < graph.getN(); i++)
        {
            graph.getNodes().getNode(i).setDegree(TotalDegree(graph.getNodes().getNode(i)));
        }
         
        return graph; 
    
    }
    
}
