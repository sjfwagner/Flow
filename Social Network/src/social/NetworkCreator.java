/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import java.util.Collection;

/**
 *
 * @author sophiewagner
 */
public class NetworkCreator {
    private MyEdges edges;
    public MyNodes nodes;
    private Integer n; 
    
    public NetworkCreator(DirectedSparseMultigraph dsmg){
        
        this.n = dsmg.getVertexCount();
        this.nodes = new MyNodes(this.n);
        this.edges = new MyEdges(this.n);
        //Collection mg = dsmg.getVertices();
        
        
        for(int i = 0; i < this.n; i++){
            
            
           // MyNode a = new MyNode(, new Integer(i),'r');
        }
        
    
    
    
    
    }
    
}
