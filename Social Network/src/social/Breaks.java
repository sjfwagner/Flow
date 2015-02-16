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
public class Breaks {
    MyNetwork network; 
    public Breaks(MyNetwork maxflow)
    {
     this.network = maxflow; 
     for(int i = 0; i < network.getN(); i++){
             String x = maxflow.getNodes().getNode(i).getName() + ", ";
             //String x = "";
             
             int y = 0; 
             for(int j = 0; j < network.getN(); j++)
             {
                 y += network.getEdges().getEdge(i,j).getStrength();
                 y += network.getEdges().getEdge(j,i).getStrength();
                 
                 
             }
             
             double r = y; 
             network.getNodes().getNode(i).setFlowDegree(r);
             x += r; 
             //System.out.println(x);
         }
     
     double u = 0.0; 
     
     for(int i = 0; i < network.getN(); i++)
     {
        
        double test = network.getNodes().getNode(i).getFlowDegree();
        if(test> u){u = test; }
     }
     
     for(int i = 0; i < network.getN(); i++)
     {
        double r = (network.getNodes().getNode(i).getFlowDegree())/u;
        network.getNodes().getNode(i).setFlowDegree(r);
        
     }
    }
    
    public String fourtybreaks()
    {
        ArrayList<MyNode> x = new ArrayList<MyNode>();
        //x = network.getNodes();
        String result = "";
                
               
        for (int i =0; i< network.getN(); i++){
            double z = 0.0; 
            while (z < 41)
            {
               double u = z/40; 
               double v = (z+1)/40;
               
               if(u< network.getNodes().getNode(i).getFlowDegree() && v>= network.getNodes().getNode(i).getFlowDegree())
               {
                   network.getNodes().getNode(i).setBreakscore(z+1);
               
               }
               if(network.getNodes().getNode(i).getFlowDegree() == 0 ){network.getNodes().getNode(i).setBreakscore(0.0); }
               
               z++;

            }
        }
        for (int i =0; i< network.getN(); i++)
        {
            System.out.println(network.getNodes().getNode(i).getName() + ", " + network.getNodes().getNode(i).getBreakscore());
            result += network.getNodes().getNode(i).getName() + ", " + network.getNodes().getNode(i).getBreakscore() + "\n";
        
        }
        
        return result;
        
    
    }
    
}
