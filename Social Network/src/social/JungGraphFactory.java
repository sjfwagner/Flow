/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.algorithms.shortestpath.Distance;
import edu.uci.ics.jung.algorithms.util.IterativeProcess;
import edu.uci.ics.jung.algorithms.importance.AbstractRanker;
import edu.uci.ics.jung.algorithms.importance.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.transformation.DirectionTransformer;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.Graph;


/**
 *
 * @author sophiewagner
 */
public class JungGraphFactory {

  
    MyNodes nodes = null; 
    MyEdge [] sinkColl;
    



    //changed con from "network" to edges... 
    public static SparseMultigraph<MyNode, MyEdge> makeGraph(MyNodes un, MyEdges con)  {
        SparseMultigraph<MyNode, MyEdge> graph;
        // create a simple graph for the demo
        graph = new SparseMultigraph<MyNode, MyEdge>();
        int n = un.getSize();
        

       //this.nodes = un; 

        Integer[] v = createVertices(n);
        // add some sample data (graph manipulated via JGraphT)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //ask for dr. wierman's comments on the first if statment

                if (i != j) {
                    if(Math.abs(con.getEdge(i, j).getStrength())>0.000000001)
                        //for (double z = 0; z < con.getEdge(i, j).getStrength(); z++) {
                             graph.addEdge(con.getEdge(i,j), un.getNode(i), un.getNode(j), EdgeType.DIRECTED);
                        //}
                    
                }
            }
        }
        
        return graph;

    }
    
    public static DirectedSparseMultigraph<MyNode, MyEdge> makeDirectedGraph(MyNodes un, MyEdges con)  {
        DirectedSparseMultigraph<MyNode, MyEdge> graph;
        // create a simple graph for the demo
        graph = new DirectedSparseMultigraph<MyNode, MyEdge>();
        int n = un.getSize();
        

       //this.nodes = un; 

        Integer[] v = createVertices(n);
        // add some sample data (graph manipulated via JGraphT)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //ask for dr. wierman's comments on the first if statment

                if (i != j) {
                    
                       // for (int z = 0; z < con.getEdge(i, j).getStrength().intValue(); z++) {
                            graph.addEdge(con.getEdge(un.getNode(i).getNumber(),un.getNode(j).getNumber()), un.getNode(i), un.getNode(j), EdgeType.DIRECTED);
                        
                  //  }
                }
            }
        }

    return graph;

    }

    public MyNodes getNodes() {
        return nodes;
    }
    
//    public static MyEdge[] SinkColl(SparseMultigraph<MyNode, MyEdge> original){
//        MyEdge [] sinkColl = null;
//        for(MyEdge me: original.getEdges()){
//            sinkColl[] = new  
//        }
//        
//        
//    return; 
//    }
    

    
    
    public static SparseMultigraph<MyNode, MyEdge> copyGraph(SparseMultigraph<MyNode, MyEdge> original)
    {
        SparseMultigraph<MyNode, MyEdge> temp;
        temp = new SparseMultigraph<MyNode, MyEdge> ();
         for (MyNode mn : original.getVertices())
            temp.addVertex(mn);

        for (MyEdge me : original.getEdges())
            temp.addEdge(me, original.getIncidentVertices(me));
        
    
        return temp; 
    }

    public static DirectedSparseMultigraph<MyNode, MyEdge> copyDirectedGraph(DirectedSparseMultigraph<MyNode, MyEdge> original)
    {
        DirectedSparseMultigraph<MyNode, MyEdge> temp;
        temp = new DirectedSparseMultigraph<MyNode, MyEdge> ();
         for (MyNode mn : original.getVertices())
            temp.addVertex(mn);

        for (MyEdge me : original.getEdges())
            temp.addEdge(me, original.getIncidentVertices(me));
        
        
    
        return temp; 
    }


    /**
     * create some vertices
     *
     * @param count how many to create
     * @return the Vertices in an array
     */
    public static Integer[] createVertices(int count) {
        Integer[] v = new Integer[count];
        for (int i = 0; i < count; i++) {
            v[i] = new Integer(i);
            //   graph.addVertex(v[i]);
        }
        return v;
    }
    
   
   
//    public static DirectedGraph<MyNode,MyEdge> GraphtoDirected(Graph<MyNode,MyEdge> graph)
//    {
//        this.dt = new DirectionTransformer(); 
//        dt.toDirected();
//        
//        
//        return null;
//    }
//    
   
    
//    public static DirectedSparseMultigraph<MyNode, MyEdge> GraphtoDirectedSparseMultigraph(Graph constrict)
//    {
//        
//    
//    
//    }
   
}
