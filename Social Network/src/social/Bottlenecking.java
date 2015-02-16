/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sophiewagner
 */
public class Bottlenecking {
    
    private MyNetwork network; 
    private MyNetwork origindestination; 
    private Set<MyEdge>s;
    private ArrayList<Integer> avg = new ArrayList<Integer>(); 
     Map<MyEdge,Number> efm;
    
    public Bottlenecking(MyNetwork original, MyNetwork od)
    {
           this.network = original; 
           this.origindestination = od; 
    
    }
    
    public Set<MyEdge> CutSetSmallGraph(EdmondsKarp ek)
    {
        
        Set<MyEdge> arcs = ek.mincut;
        return arcs; 
    }
    
    //public void 
    
    public EdmondsKarp Flow(MyNode source, MyNode sink)
    {
        //Graph<MyNode,MyEdge> constrict = ConstrictGraph.MyFilter(this.network, source, 10);
        
     //  DirectedSparseMultigraph<MyNode,MyEdge> dg;
        
       // dg = new DirectedSparseMultigraph<MyNode, MyEdge>();
        
        //DirectedSparseMultigraph<MyNode, MyEdge> constrict = JungGraphFactory.makeDirectedGraph(network.getNodes(), network.getEdges());
        
//        Collection<MyEdge> edges = constrict.getEdges(EdgeType.DIRECTED);
//        
//        for (MyNode mn : constrict.getVertices())
//            dg.addVertex(mn);
//
//        for (MyEdge e : edges)
//            dg.addEdge(e, constrict.getIncidentVertices(e));
        
        EdmondsKarp ek = new EdmondsKarp(network, source, sink);
        
         //Map<MyEdge,Double> mp = ek.edgeFlowMap;
        return ek;
    
    }
    
    public Number FlowMap(EdmondsKarp ek, MyEdge e)
    {
       efm = ek.getEdgeFlowMap();
        
        if (efm.containsKey(e))
        {
//            System.out.println(e);
//             int x=mp.get(e);
           return efm.get(e);
        }
        
        else{return 0.0;}
        
        
        
    }
    
    public int ModifyEdges(Set<MyEdge> a, EdmondsKarp ek)
    {
        Double weight = 1.0 / (a.size()); 
        this.avg.add(a.size());
        
        int f = ek.getMaxFlowValue(); 
        
        DirectedSparseMultigraph<MyNode, MyEdge> rfg = ek.returnFlowGraph();
        Collection<MyEdge> t = rfg.getEdges();
        
//        for(MyEdge me: t)
//        {
//            this.network.getEdges().getEdge(me.getFrom(), me.getTo()).setTotalFlow(FlowMap(ek,me).doubleValue());
//        }
        
        Double totalflow = 0.0; 
        
        for (MyEdge e : a){
            this.network.getEdges().getEdge(e.getFrom(), e.getTo()).setBottleneckdegree(1);
            this.network.getEdges().getEdge(e.getFrom(), e.getTo()).addToBottleneckWeighted(weight);
            
            totalflow = totalflow + FlowMap(ek, e).doubleValue();
        }
        
        for (MyEdge e : a){
            this.network.getEdges().getEdge(e.getFrom(), e.getTo()).setBottleneckweightedv2(FlowMap(ek, e).doubleValue(), totalflow);
        }
        
        return f; 
    }
    
    
    
    
    public Double Average()
    {
        int sum = 0;  
                
        for(int i: avg)
        {
            sum = sum + i; 
        }
        Double sumD = (double)sum; 
        return sumD /avg.size();
    
    }
    
    
    
    
    public void ForAllOriginDestinations()
    {
       int n  =  this.origindestination.getNodes().getSize();
       
       for (int i = 0; i < n; i++)
           for(int j = 0; j < n; j++)
           {    
               if(i!=j && this.origindestination.getEdges().getEdge(i, j).getStrength()> 0.0)
               
               {
                   EdmondsKarp ek = Flow(this.network.getNodes().getNode(i),this.network.getNodes().getNode(j));
                   int x = ModifyEdges(CutSetSmallGraph(ek), ek);
                    //TODO fixup the origin destination portion (only alter the one edge)
                   //MAKE MATRIX COPIES AND EDIT THE COPIES
                   this.origindestination.getEdges().getEdge(i, j).setFlow((double)x);
               
               }
               
           }
      
    
    }
    
    public ArrayList<MyEdge> ReportHighestBottleneckers()
    {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<MyEdge> elist = new ArrayList<MyEdge>();

        
        ForAllOriginDestinations(); 
        int tester = 0; 
        
        while(tester < 168){
        Integer x = 0; 
        Double z = 0.0; 
        String xx = null;
        Double y = 0.0;
        
        int n  =  this.network.getNodes().getSize();
       
       for (int i = 0; i < n; i++)
           for(int j = 0; j < n; j++)
           {
               if(x < this.network.getEdges().getEdge(i, j).getBottleneckdegree() && (elist.contains(this.network.getEdges().getEdge(i, j)) == false) )
               {
                   x = this.network.getEdges().getEdge(i, j).getBottleneckdegree();
                   z = this.network.getEdges().getEdge(i, j).getBottleneckWeighted();
                   y = this.network.getEdges().getEdge(i, j).getBottleneckweightedv2();
                   xx = this.network.getNodes().getNode(this.network.getEdges().getEdge(i, j).getFrom()).getName() + " ~ " + this.network.getNodes().getNode(this.network.getEdges().getEdge(i, j).getTo()).getName() + " ,"+ x + " ,"+ z +" ,"+ y; 
                   list.add(xx);
                   elist.add(this.network.getEdges().getEdge(i, j));
                   
               }
               
           }
       
        tester ++; 
      // list.add(xx);
 
//       for (int i = 0; i < n; i++)
//           for(int j = 0; j < n; j++)
//           {
//               if(x == this.network.getEdges().getEdge(i, j).getBottleneckdegree())
//               {
//                   
//                   list.add(this.network.getNodes().getNode(this.network.getEdges().getEdge(i, j).getFrom()).getName() + " - " + this.network.getNodes().getNode(this.network.getEdges().getEdge(i, j).getTo()).getName()+ "/n");
//               }
//               
//           }
       
       //}
       
       
    }
        return elist;
    }
    
    
    
}
