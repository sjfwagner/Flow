/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.util.List;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author sophiewagner
 */
public class ShortestPath {
    
    
    
      public static Double ShortestDistance(MyNode v1, MyNode v2, SparseMultigraph<MyNode, MyEdge> graph) {
        Transformer<MyEdge, Double> wtTransformer = new Transformer<MyEdge, Double>() {
            @Override
            public Double transform(MyEdge link) {
                return link.getStrength();
            }
        };
        DijkstraShortestPath<MyNode, MyEdge> alg = new DijkstraShortestPath(graph,
                wtTransformer);
        //List<MyEdge> l = alg.getPath(v1, v2);
        
        Number dist = 0.0; 
        try{
         dist = alg.getDistance(v1, v2);}
        catch(IllegalArgumentException e) { dist = 0; }
       // System.out.print("The shortest path from" + v1.getNumber() + " to " + v2.getNumber() + " is:");
      //  System.out.println(l.toString());
      //  System.out.println("and the length of the path is: " + dist);
        if(dist == null ) return 0.0;   
        return dist.doubleValue();
        
    }
      
    
      
    public static Double Diameter(SparseMultigraph<MyNode, MyEdge> graph, MyNodes un)
    {
        
        Double diameter = 0.0; 
        for(int i = 0; i < graph.getVertexCount(); i++)
            for(int j = 0; j < graph.getVertexCount(); j ++)
                if (i != j)
                {
                    Double test = ShortestDistance(un.getNode(i),un.getNode(j), graph);
                    if(test > diameter) {diameter = test; }
            
                }
        return diameter; 
    }
    
    public static Double ShortestPossibleLength(MyNode v,SparseMultigraph<MyNode, MyEdge> graph, MyNodes un)
    {
        Double minLength = 0.0; 
        for(int i = 0; i < graph.getVertexCount(); i++){
            
            int j = v.getNumber();
            if (i != j)
                {
                    Double test = ShortestDistance(un.getNode(i),un.getNode(j), graph);
                    if(test < minLength) {minLength = test; }
                      } 
        }
   
    return minLength; 
    }
    
    public static Double LongestShortestPossibleLength(MyNode v,SparseMultigraph<MyNode, MyEdge> graph, MyNodes un)
    {
        Double maxLength = 0.0; 
        for(int i = 0; i < graph.getVertexCount(); i++){
            
            int j = v.getNumber();
            if (i != j)
                {
                    Double test = ShortestDistance(un.getNode(i),un.getNode(j), graph);
                    if(test > maxLength) {maxLength = test; }
                      } 
        }
   
    return maxLength; 
    }
    
    
}
