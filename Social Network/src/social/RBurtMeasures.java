/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;


import com.sun.org.apache.xpath.internal.operations.Number;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.algorithms.shortestpath.Distance;
import edu.uci.ics.jung.algorithms.util.IterativeProcess;
import edu.uci.ics.jung.algorithms.importance.AbstractRanker;
import edu.uci.ics.jung.algorithms.importance.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.metrics.StructuralHoles;


/**
 *
 * @author sophiewagner
 */
public class RBurtMeasures {
    private BetweennessCentrality ranker;
    private int num = 0; 
    private StructuralHoles efficiency; 
    private MyNetwork original;
    private MyNetwork ncopy;
    private MyNodes nodes; 
    private MyEdges edges; 
    Transformer<social.MyEdge, Double> wtTransformer = new Transformer<social.MyEdge, Double>() {
            @Override
            public Double transform(social.MyEdge link) {
                return link.getStrength();
            }
        };
    
//   public void setGraph(SparseMultigraph<MyNode, MyEdge> graph) {
//        this.graph = graph;
//    }
/*    
    public RBurtMeasures(MyNodes un, MyEdges con, SparseMultigraph<MyNode, MyEdge> graph)  {

        // create a simple graph for the demo
        
        //SparseMultigraph<MyNode, MyEdge> jg =  JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());
        this.nodes  = new MyNodes(un);
        this.edges = new MyEdges(con);
       int n = un.getSize();

        //this.which = "b";


        //Integer[] v = graph.createVertices(n);
        // add some sample data (graph manipulated via JGraphT)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //ask for dr. wierman's comments on the first if statment

                if (i != j) {
                    if (!con.getEdge(i, j).isDeleted()) {
                        for (int z = 0; z < con.getEdge(i, j).getStrength().intValue(); z++) {
                            graph.addEdge(con.getEdge(i, j), un.getNode(i), un.getNode(j), EdgeType.DIRECTED);
                        }
                    }
                }
            }
        }



    }
  */  
    public void Metrics(MyNetwork original,SparseMultigraph<MyNode, MyEdge> graph) {
       // this.graph = Jgraph.getGraph();
        
        this.efficiency = new StructuralHoles(graph, wtTransformer);
        
        
        this.original = original;
    }
    
    public double getEfficency(MyNode v)
    {
        
        return this.efficiency.efficiency(v);
    }
    
    public double getEfficencyNetworkAvg(SparseMultigraph<MyNode, MyEdge> sm)
    {
        this.efficiency = new StructuralHoles(sm, wtTransformer);
        double total = 0;
        Collection<MyNode> vertices = sm.getVertices();

        for (MyNode no : vertices) {
           total = (total + getEfficency(no)); 
        }
         
        
        
        return total / vertices.size();  
    }
    
    public double getDiffEfficiency(MyNode v, SparseMultigraph<MyNode, MyEdge> graph)
    {
        
        //this is the beginning efficiency
        double startEff = getEfficencyNetworkAvg(graph); 
        double endingEff = 0.0; 
        //create a copy graph to test on
        //SparseMultigraph<MyNode, MyEdge> now = JungGraphFactory.copyGraph(graph);
        //Collection<MyNode> tempnodes = now.getVertices(); 
        //temp.removeVertex(v);
        
        
        //the total # of nodes
        //int n = this.nodes.getSize();
        
        Collection<MyNode> vertices = graph.getVertices();

        for (MyNode no : vertices) {
            SparseMultigraph<MyNode, MyEdge> temp = JungGraphFactory.copyGraph(graph);
            temp.removeVertex(no);
            double tempEff = getEfficencyNetworkAvg(temp);
            if(tempEff > endingEff){endingEff = tempEff; }
            
        }
        
        
        
       // this.nodes.deleteNode(v);

        //ending efficency value w/o deleted node
        //endingEff = getEfficencyNetworkAvg(temp); 
        
        return endingEff - startEff; 
    }
    
    public MyNode ReportGreatestDiffEfficency(MyNodes un, SparseMultigraph<MyNode, MyEdge> graph)
    {
        double bigdiff = 0.0;
        MyNode bigdiffnode = null; 
        
        int n = graph.getVertexCount();
        
        for(int i =0; i <n; i++)
        {
            double diff = getDiffEfficiency( un.getNode(i) , graph); 
            if(bigdiff < diff)
            {
                bigdiffnode = un.getNode(i); 
            }
            
        }  
        
        return bigdiffnode;
    
    
    }
    
    public void deleteMaxNodeEff(MyNodes un, MyEdges con,SparseMultigraph<MyNode, MyEdge> graph, Integer most) {

        MyNode maxNode = un.getNode(most);
        if (maxNode == null) {
            return;
        }
        int k = maxNode.getNumber();
        graph.removeVertex(un.getNode(k));

        int n = un.getSize();
        System.out.println("deleting Node " + num + ": " + k + " name: " + maxNode.getName() + " degree: " + graph.degree(maxNode) );
        num ++; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == k || j == k) {
                    con.deleteEdge(i, j);
                }

            }
        }

    }
}
