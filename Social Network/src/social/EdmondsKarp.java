/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.algorithms.flows.EdmondsKarpMaxFlow;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author sophiewagner
 */
public class EdmondsKarp {

    public EdmondsKarpMaxFlow ekmf;
    private MyNetwork graph;
    private DirectedSparseMultigraph<MyNode, MyEdge> jg;
    private MyNode source;
    private MyNode sink;
    public DirectedSparseMultigraph<MyNode, MyEdge> flow;
    public Set<MyEdge> mincut;
    public Integer f;
    public Set<MyNode> sPart;
    public Set<MyNode> tPart;
    Map<MyEdge, Number> edgeFlowMap;

    public Map<MyEdge, Number> getEdgeFlowMap() {
        return edgeFlowMap;
    }
    
    
    
    Transformer<MyEdge, Double> wtTransformer = new Transformer<MyEdge, Double>() {
        @Override
        public Double transform(MyEdge link) {


            return link.getCapacity();

            //return link.getStrength();
        }
    };
    // This Factory produces new edges for use by the algorithm
    Factory<MyEdge> edgeFactory = new Factory<MyEdge>() {
        public MyEdge create() {
            return new MyEdge(0, 0, 1.0, true);
        }
    };

    public EdmondsKarp(MyNetwork graph,
            MyNode source,
            MyNode sink) {
        this.edgeFlowMap = new HashMap<MyEdge, Number>();
        DirectedSparseMultigraph<MyNode, MyEdge> jg = JungGraphFactory.makeDirectedGraph(graph.getNodes(), graph.getEdges());

        //System.out.println("Source="+jg.containsVertex(source));
        //System.out.println("sink="+jg.containsVertex(sink));
        //System.out.println("count="+jg.getVertexCount());

//  for(int i = 0; i < 197; i++){
//      System.out.println("sink="+jg.containsVertex(sink));
//  
//  }
        // System.out.println(jg.getVertices().toString());

        EdmondsKarpMaxFlow<MyNode, MyEdge> alg =
                new EdmondsKarpMaxFlow(jg, source, sink, wtTransformer, edgeFlowMap,
                edgeFactory);
        alg.evaluate();
        this.flow = (DirectedSparseMultigraph<MyNode, MyEdge>) alg.getFlowGraph();
        this.mincut = alg.getMinCutEdges();


        //System.out.println("The max flow is: " + alg.getMaxFlow());
        System.out.println(alg.getMaxFlow());
        this.f = alg.getMaxFlow();
        //System.out.println("The edge set is: " + alg.getMinCutEdges().toString());
        //System.out.println("The graph is: " + alg.returnFlowGraph()); 

        this.sPart = alg.getNodesInSourcePartition();
        this.tPart = alg.getNodesInSinkPartition();

    }

    //returns maxflow
    public Integer getMaxFlowValue() {
        return f;
    }

    //returns flow graph
    public DirectedSparseMultigraph<MyNode, MyEdge> returnFlowGraph() {
        return flow;
    }

    //returns mincut
    public Set<MyEdge> MinCut() {
        return this.mincut;

    }
}
