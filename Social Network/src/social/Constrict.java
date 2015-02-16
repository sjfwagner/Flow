/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class Constrict {
    public MyNetwork traffic; 
    public MyNetwork od; 
    
    
    public Constrict(MyNetwork t, MyNetwork o)
    {
    
        traffic = t; 
        od = o; 
        
        
        
    //         FlowAnalysis fa = new FlowAnalysis(trafficmap,origindestination);
//         fa.DoAnalysis();
//         
//         NetworkPrinter np = new NetworkPrinter(fa.ReturnPathFlowGraph());
//         System.out.println("Path flow \n \n " +np.PrintFlow() + "\n \n \n");
//         
//         NetworkPrinter pn = new NetworkPrinter(fa.ReturnODFlowGraph());
//         System.out.println("OD flow \n \n " +pn.PrintFlow() + "\n \n \n");
    
    }
    
    
    public void InterdictBottleneckDegree(int iterations)
    {
        
        MyNetwork traff = null ;
        MyNetwork ood = null; 
        for (int y = 0; y < iterations; y++)
        {
            
            
           if(y == 0){
               FlowAnalysis fa = new FlowAnalysis(traffic,od);
               fa.DoAnalysis();
               traff = fa.ReturnPathFlowGraph();
               ood = fa.ReturnODFlowGraph();

               NetworkPrinter np = new NetworkPrinter(traff);
               System.out.println("Path flow \n \n " +np.PrintFlow() + "\n \n \n");
               NetworkPrinter pn = new NetworkPrinter(ood);
               System.out.println("OD flow \n \n " +pn.PrintFlow() + "\n \n \n");
               
               int test = 0; 
               MyEdge t = null; 
               for(int i = 0; i < traffic.getN(); i++){
                   for(int j = 0; j < traffic.getN(); j++)
                   {
                       if(traff.getEdges().getEdge(i, j).getBottleneckdegree() > test){
                           test = traff.getEdges().getEdge(i, j).getBottleneckdegree();
                           t = traff.getEdges().getEdge(i, j);
                       }
                           
                       
                   
                   }
               
               }
               System.out.println("Deleting, " + traff.getNodes().getNode(t.getFrom()).getName() + ", " + traff.getNodes().getNode(t.getTo()).getName());
               traff.getEdges().getEdge(t.getFrom(), t.getTo()).setStrength(0.0);
               
               
               
           }
           
           FlowAnalysis fa = new FlowAnalysis(traff,ood);
               fa.DoAnalysis();
               traff = fa.ReturnPathFlowGraph();
               ood = fa.ReturnODFlowGraph();

               NetworkPrinter np = new NetworkPrinter(traff);
               System.out.println("Path flow \n \n " +np.PrintFlow() + "\n \n \n");
               NetworkPrinter pn = new NetworkPrinter(ood);
               System.out.println("OD flow \n \n " +pn.PrintFlow() + "\n \n \n");
               
               int test = 0; 
               MyEdge t = null; 
               for(int i = 0; i < traffic.getN(); i++){
                   for(int j = 0; j < traffic.getN(); j++)
                   {
                       if(traff.getEdges().getEdge(i, j).getBottleneckdegree() > test){
                           test = traff.getEdges().getEdge(i, j).getBottleneckdegree();
                           t = traff.getEdges().getEdge(i, j);
                       }
                           
                       
                   
                   }
               
               }
               System.out.println("Deleting, " + traff.getNodes().getNode(t.getFrom()).getName() + ", " + traff.getNodes().getNode(t.getTo()).getName());
               traff.getEdges().getEdge(t.getFrom(), t.getTo()).setStrength(0.0);
           
           
           
    
        
        }
    
    
    
    }
    
}
