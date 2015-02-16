/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.SparseMultigraph;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author sophiewagner
 */
public class AvgDistance {
    MyNetwork original; 
    ArrayList <SparseMultigraph<MyNode, MyEdge>> deleteSeries; 
    SparseMultigraph<MyNode, MyEdge> jg;
    Betweeness nb;
    NodeDegree nd; 
    
    public  AvgDistance (SparseMultigraph ig, MyNetwork original) {
        this.deleteSeries = new ArrayList<SparseMultigraph<MyNode, MyEdge>> ();
        this.original = original;
        this.jg = ig;
        
    }
    
//    public double avgBetDistance() throws FileNotFoundException{
//        //jg = JungGraphFactory.makeGraph(original.getNodes(),original.getEdges());
//        nb = new Betweeness(); 
//        int n = original.getNodes().getSize();
//        double avgNumerator = 0;
//        double avgDenominator = 0; 
//        double avgBetDistance = 0; 
//        Double d;
//        
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                //ask for dr. wierman's comments on the first if statment
//
//                if (i != j) {
//                    //if (!original.getEdges().getEdge(i, j).isDeleted()){
//                    
//                    //add up totals and number of nodes then average and then divide by two
//                      MyNode v1 = original.getNodes().getNode(i);
//                      MyNode v2 = original.getNodes().getNode(j); 
//                      if(jg.containsVertex(v1) && jg.containsVertex(v2)){
//
//                      //adding up the total of betweeness
//                          d= nb.findDistance(v1, v2, jg);
//                          if(d!=null){
//                      avgNumerator = avgNumerator + d;
//                      //create a running count of all the nodes you add
//                      avgDenominator = avgDenominator +1; }
//                      }
//
//                   // }  
//                }
//            }
//        }   
//        //divide it by two because each point a to point b will be counted as well as b to a 
////        avgDenominator = avgDenominator/2; 
////        avgNumerator = avgNumerator/2; 
//        avgBetDistance = avgNumerator/avgDenominator; 
//        return avgBetDistance; 
//
//    }
    public double avgDegDistance() throws FileNotFoundException{
        //jg= JungGraphFactory.makeGraph(original.getNodes(),original.getEdges());
        nd = new NodeDegree(jg);
        int n = original.getNodes().getSize();
        double avgNumerator = 0;
        double avgDenominator = 0; 
        double avgDegDistance = 0; 
        
        for (int i = 0; i < n; i++) {
            
                //ask for dr. wierman's comments on the first if statment

                
                    //if (!original.getNodes().getNode(i).isDeleted()){
                    
                      MyNode v1 = original.getNodes().getNode(i);
                      //adding up the total of betweeness
                      if(jg.containsVertex(v1))
                      avgNumerator = avgNumerator + nd.findNodeDegree(v1, jg);
                      //create a running count of all the nodes you add
                      avgDenominator = jg.getEdgeCount() * 2;
                      

                  //  }  
                
            
        }   
        
        avgDegDistance = avgNumerator/avgDenominator; 
        return avgDegDistance; 

    }
    
     public double Density()
    {
        //double denominator = jg.getVertexCount() * 2; 
        double denominator = original.getN(); 
        int numerator = jg.getEdgeCount();
        
        double density = denominator/numerator; 
        
        return density;
    }
}
