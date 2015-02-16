/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;
import edu.uci.ics.jung.algorithms.filters.KNeighborhoodFilter;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import java.util.Set;
import edu.uci.ics.jung.algorithms.filters.KNeighborhoodFilter.EdgeType;
import edu.uci.ics.jung.graph.Graph;



/**
 *
 * @author sophiewagner
 */
public class ConstrictGraph {
     
      
     //private Set set; 
    
    

    public static Graph<MyNode,MyEdge> MyFilter(MyNetwork net, MyNode s, int r) {
      DirectedSparseMultigraph<MyNode, MyEdge> jg;
      MyNetwork mn; 
      MyNode source; 
      Integer radius;
      KNeighborhoodFilter<MyNode,MyEdge> nf; 
     mn = net; 
     source = s; 
     radius = r; 
        
        jg = JungGraphFactory.makeDirectedGraph(mn.getNodes(), mn.getEdges());
        
        
        
        nf = new KNeighborhoodFilter(source, radius, EdgeType.OUT);
        Graph<MyNode,MyEdge> result = nf.transform(jg);
        return result; 
    }
    
    
    
    
    
    
    
}
