/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class NetworkPrinter {
    private MyNetwork mn; 
    
    public NetworkPrinter(MyNetwork network)
    {
        this.mn = network; 
    }
    
    public String PrintStrength()
    {
    
    
        String s = "\n"; 
       // String p = "Region " + r1 + " to " + r2 + "\n"; 
        
        
      
        
        int i = 0;
        
        
        while(i < mn.getN()){
            //System.out.println("test");
            
                s += "\n" + mn.getNodes().getNode(i).getName();
                int j = 0;
                while( j < mn.getN())
                {
                    if(mn.getEdges().getEdge(i, j).getStrength()>0.0){s+= ", " + mn.getEdges().getEdge(i, j).getStrength();}
                    else{s+= "," + mn.getEdges().getEdge(i, j).getStrength();}
                    j++;
   
                 }
                
            
           
           if (i == mn.getN()){ s += "\n";}
           i++; 
         }
        
        
        return s; 
    }
    
    public String PrintFlow()
    {
    
    
        String s = "\n"; 
       // String p = "Region " + r1 + " to " + r2 + "\n"; 
        
        
      
        
        int i = 0;
        
        
        while(i < mn.getN()){
            //System.out.println("test");
            
                s += "\n" + mn.getNodes().getNode(i).getName();
                int j = 0;
                while( j < mn.getN())
                {
                    
                    if(i==j){ s += ",  ";}
                    
                    else if (i != j){s+= "," + mn.getEdges().getEdge(i, j).getFlow();}
                    
                    j++;
   
                 }
                
            
           
           if (i == mn.getN()){ s += "\n";}
           i++; 
         }
        
        
        return s; 
    }
    
    
    public String PrintBottleneckDegree()
    {
    
    
        String s = "\n"; 
       // String p = "Region " + r1 + " to " + r2 + "\n"; 
        
        
      
        
        int i = 0;
        
        
        while(i < mn.getN()){
            //System.out.println("test");
            
                s += "\n" + mn.getNodes().getNode(i).getName();
                int j = 0;
                while( j < mn.getN())
                {
                    
                    if(i==j){ s += ",  ";}
                    
                    else if (i != j){s+= "," + mn.getEdges().getEdge(i, j).getBottleneckdegree();}
                    
                    j++;
   
                 }
                
            
           
           if (i == mn.getN()){ s += "\n";}
           i++; 
         }
        
        
        return s; 
    }
}
