    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author sophiewagner
 */
public class Betweeness {

    
    public static BetweennessCentrality  getBetweeness(SparseMultigraph<MyNode, MyEdge> graph)
    {
        Transformer<MyEdge, Double> wtTransformer = new Transformer<MyEdge, Double>() {
            @Override
            public Double transform(MyEdge link) {
                return link.getStrength();
            }
        };
        BetweennessCentrality bc = new BetweennessCentrality(graph,wtTransformer);
         return bc;
    }
//        Collection<MyNode> vertices = graph.getVertices();
//        Collection<MyEdge> edges = graph.getEdges();
//        //bc.//computeBetweenness(new  LinkedList(graph.getVertices()), wtTransformer);
//        
//        for(MyNode vertex: vertices)
//        {
//            double b = bc.getVertexScore(vertex);
//            
//        }
//        
//        for(MyEdge edge: edges)
//        {
//            double c = bc.getEdgeScore(edge);
//        
//        }
      
//        for (int i = 0; i < N.getNodes().getSize(); i++)
//        {
//            double b = bc.getVertexScore(N.getNodes().getNode(i));
//            //double d = bc.getVertexScore();
//            N.getNodes().getNode(i).setBetweenness(b);
//            for (int j = 0; j < N.getNodes().getSize(); j++)
//            {
//                if(N.getEdges().getEdge(i, j).getStrength() > 0.0){
//                    double c = bc.getEdgeScore(N.getEdges().getEdge(i, j));
//                    N.getEdges().getEdge(i, j).setBetweeness(c);
//                }
//            }
//            
//        }  


     
}     
    