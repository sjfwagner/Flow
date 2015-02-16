/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.util.Collection;

/**
 *
 * @author sophiewagner
 */

//has helper methods for purgemaxnode efficiency
public class GlobalEfficiencyHelper {
    private GlobalEfficiency ge; 
    private GlobalEfficiency second;
    private DirectedSparseMultigraph<MyNode, MyEdge> djg;
    private MyNetwork graph;
    private int num = 0; 
  

    public GlobalEfficiencyHelper(MyNetwork graph)
    {
        this.graph = graph; 
         this.djg = JungGraphFactory.makeDirectedGraph(graph.getNodes(), graph.getEdges());
    }
    //get the diff efficiency by cutting out edges...this will take ALOT longer...that good? or bad?? (
    
    public double getGlobalEfficiency(MyNetwork input)
    {
        MyNetwork ggei = input; 
        //DirectedSparseMultigraph<MyNode, MyEdge> idea = JungGraphFactory.makeDirectedGraph(ggei.getNodes(), ggei.getEdges());
        GlobalEfficiency gge = new GlobalEfficiency(ggei);
        return gge.EfficiencyResult();
    }
    public double getDiffEfficiency(MyNode i)
    {
       
        
        this.ge = new GlobalEfficiency(graph);
        //this is the beginning efficiency
        double startEff = ge.EfficiencyResult(); 
        double endingEff = 0.0; 
        //create a copy graph to test on
        //SparseMultigraph<MyNode, MyEdge> now = JungGraphFactory.copyGraph(graph);
        //Collection<MyNode> tempnodes = now.getVertices(); 
        //temp.removeVertex(v);
        
        
        //the total # of nodes
        //int n = this.nodes.getSize();
        Collection<MyNode> verticies = this.djg.getVertices(); 
        //Collection<MyEdge> edges = this.djg.getEdges();
            //for (MyEdge ed : edges)
        
         
        DirectedSparseMultigraph<MyNode, MyEdge> temp = JungGraphFactory.copyDirectedGraph(djg);
            //temp.removeEdge(ed);
        temp.removeVertex(i);
        this.second = new GlobalEfficiency(graph);
 
         endingEff = second.EfficiencyResult();
        
            
        
        
        
        
       // this.nodes.deleteNode(v);

        //ending efficency value w/o deleted node
        //endingEff = getEfficencyNetworkAvg(temp); 
        
        return startEff - endingEff; 
    }
    
    public MyNode ReportGreatestDiffEfficency()
    {
        double bigdiff = 0.0;
        MyNode bigdiffnode = null; 
        
        MyNodes un = this.graph.getNodes();
        
        //int n = 0; 
        int n = this.djg.getVertices().size();
        //int i = 0; 
        //for node # i get the difference in efficiency
        for(int i =0; i <n; i++)
        {
            double diff = getDiffEfficiency(graph.getNodes().getNode(i)); 
            if(bigdiff < diff)
            {
                bigdiffnode = un.getNode(i);
                bigdiff = diff; 
            }
            
        }  
        if(bigdiffnode == null)
        { return null; }
        System.out.println("Node w/ the biggest diff is: " + bigdiffnode.getName()+" ,Diff is:" + bigdiff);
        return bigdiffnode;

    }
    
    public void deleteMaxNodeEff(MyNodes un, MyEdges con,SparseMultigraph<MyNode, MyEdge> graph, Integer most) {

        MyNode maxNode = un.getNode(most);
        if (maxNode == null) {
            return;
        }
        int k = maxNode.getNumber();
        

        int n = graph.getVertexCount();
        System.out.println("deleting Node " + num + ": " + k + " Name: " + maxNode.getName() + " Degree: " + graph.degree(maxNode));
        graph.removeVertex(maxNode);
        djg.removeVertex(maxNode);
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
