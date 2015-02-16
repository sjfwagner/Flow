 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.io.FileNotFoundException;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author sophiewagner
 */
public class GlobalEfficiency {
    
    private Double sumDistances;
    private Double normalizer; 
    private Double result; 
    private MyNetwork graph;
    private ParallelFloydWarshallJung<MyNode,MyEdge> shortestpaths; 
    private DirectedSparseMultigraph<MyNode, MyEdge> jg;
    Transformer<MyEdge, Double> wtTransformer = new Transformer<MyEdge, Double>() {
            @Override
            public Double transform(MyEdge link) {
                return link.getStrength();
            }
        };
   

    public MyNetwork getGraph() {
        return graph;
    }    

    GlobalEfficiency(MyNetwork input ) {
        this.graph = input;
        this.jg = JungGraphFactory.makeDirectedGraph(graph.getNodes(), graph.getEdges());
        //this.jg =  network;
        //here is threads
        int numThreads = 4; 
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);     
        this.shortestpaths = new ParallelFloydWarshallJung<MyNode,MyEdge>(jg, wtTransformer,executorService ,numThreads);
        this.shortestpaths.solve();
        executorService.shutdown();

    }
    
    public double Normalizator()
    {
        int n = jg.getVertexCount();
        int k = n-1; 
        int m = n*k;
        this.normalizer = 1.0/m; 
        
        return  this.normalizer; 
    }
    
    public double EfficiencyResult()
    {
        this.result = Normalizator() * DistanceSum();
        //System.out.println("Global Efficiency is: "+result);
        return this.result; 
        
        
        
        
    }
    
    public double DistanceSum() throws IllegalArgumentException
    {
        this.sumDistances = 0.0; 
        double length;
        Integer n = this.jg.getVertexCount();
        MyNode source, sink;
        //length = (double)path.getDistance(this.original.nodes.getNode(i),this.original.nodes.getNode(j));
        
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
            if(i!=j){
                source = this.graph.nodes.getNode(i); 
                sink = this.graph.nodes.getNode(j); 
                
                if(jg.containsVertex(source) && 
                        jg.containsVertex(sink) && 
                        (this.jg.inDegree(sink) > 0) && 
                        (this.jg.outDegree(source)>0))
                {

                length = shortestpaths.getShortestPathLength(source,sink);
                //System.out.println(source.toString()+ " " + sink.toString() + " " + length);     
                
                if(  Math.abs(length)>0.000001){
                this.sumDistances = this.sumDistances + (1.0/length); 
                }
                }
//                else{
//                System.out.println(sink.getName() + " " + source.getName());
//                }
            }
         }
        
        //System.out.println(this.sumDistances);
        
        
        return this.sumDistances; 
    }
    
}
