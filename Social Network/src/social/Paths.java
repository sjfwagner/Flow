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
public class Paths {
    
    ArrayList<Path> paths = new ArrayList<Path>();
   
   
    //Integer numEdges; 
    Integer numNodes;
    private Integer number; 
    
   
    
    public Paths() {
       paths = null; 
      

    }
    
     public String print(Paths x)
    {
       String X = null; 
       for (int i = 0; i < x.size(); i++){
           X = X + ": " + x.getPath(i).print(x.getPath(i));
           
       }
       
       return X; 
    }

    public void addPath(Path a) {
       paths.add(a);
        
    }

    public Path getPath(int i) {
        return paths.get(i);
    }
    
    public Integer size()
    {
        return paths.size();
    }
    
    
}
