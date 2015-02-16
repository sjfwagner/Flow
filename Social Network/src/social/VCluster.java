/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.algorithms.cluster.VoltageClusterer;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sophiewagner
 */
public class VCluster extends VoltageClusterer {
    
   
    
    public VCluster(SparseMultigraph<MyNode, MyEdge> graph, int num){
    
    super(graph,num);
    
    }
    
    public MyNodes Seeds(MyNodes nodes){
    
        
        
        return null; 
    }
    
    public void Cluster(int numcluster){
        Collection cluster = this.cluster(numcluster);
        List seedCandidates = this.getSeedCandidates(cluster);
        for(Object s:cluster) {
            Set<MyNodes> setNodes = (Set<MyNodes>) s;
//            for (MyNodes n : (Set<MyNodes>) s)
//            {
//                for(int i = 0; i < n.getSize(); i++)
//                {
//                    System.out.println(n.getNode(i).getName() + "/n");
//                }
//            }
//          
            System.out.println(s);
            System.out.println();
             System.out.println();
            }
        System.out.println("Seed Candidates" + seedCandidates);
       
        
    
    }
    
}
