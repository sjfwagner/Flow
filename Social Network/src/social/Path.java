/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.util.ArrayList;

/**
 *
 * @author sophiewagner
 */
public class Path {
    ArrayList<MyNode> path = new ArrayList<MyNode>();
   
   
    //Integer numEdges; 
    Integer numNodes;
    private Integer number; 
    
   
    
    public Path(MyNode Start) {
       path.add(Start);
      

    }
    
    public String print(Path x)
    {
       String X = null; 
       for (int i = 0; i < x.numNodes; i++){
           X = X + ", " + x.getNode(i).getName();
           
       }
       
       return X; 
    }

    public void addNode(MyNode a) {
       path.add(a);
        
    }

    public MyNode getNode(int i) {
        return path.get(i);
    }
    
    public Integer size()
    {
        return path.size();
    }
    
}
