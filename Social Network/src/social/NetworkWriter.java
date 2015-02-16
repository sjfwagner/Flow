/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class NetworkWriter {
    
    public NetworkWriter(MyNetwork nw)
    {
        System.out.println("i,wc,e,v");
        int n = nw.getN(); 
        MyNodes nodes = nw.getNodes(); 
        for(int i = 0; i < n; i++)
            for (int j = 0; j <n; j++){
                if(nw.getEdges().getEdge(i, j).getStrength()>0.0){
                MyEdge edge = nw.getEdges().getEdge(i, j);
                
                System.out.println(nodes.getNode(edge.getTo()).getName() + ",mil,"+ nodes.getNode(edge.getFrom()).getName() +"," + edge.getStrength());
                }
            }
    
    
    }
    
}
