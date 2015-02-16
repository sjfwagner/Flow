/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class AttackEdgeswithDoAnalysis {
    public MyNetwork t; 
    public MyNetwork o; 
    public MyNetwork pf; 
    public MyNetwork od;
    
    public AttackEdgeswithDoAnalysis(int iterations, MyNetwork traffic, MyNetwork origindestination)
    {
        int iter = 0; 
        
        o = origindestination; 
        t = traffic; 
        
        String Iterations = "Iteration, ";
        String TotalFlow = "Total Flow, ";
        String DiffFlow = "Difference in Flow, ";
        String DeletionsAtIter = "Deletions, ";
        double prevFlow = 0.0; 
        
        
        while( iter < iterations )
        {
            Iterations = Iterations + ", " + iter; 
            
            if(iter == 0){
                FlowAnalysis fa = new FlowAnalysis(t,o);
                fa.DoAnalysis();
                pf = fa.ReturnPathFlowGraph();
                od = fa.ReturnODFlowGraph();
            }
            else{
                FlowAnalysis fa = new FlowAnalysis(pf,o);
                fa.DoAnalysis();
                pf = fa.ReturnPathFlowGraph();
                od = fa.ReturnODFlowGraph();
            
            
            
            }
      
            int degree = 0; 
            MyEdge delete = null;
            
            double flowT= 0.0; 
            
            for(int i = 0; i < pf.getN(); i ++){
                for(int j = 0; j < pf.getN(); j++)
                {
                    int deg = pf.getEdges().getEdge(i, j).getBottleneckdegree();
                    
                    if(deg > degree)
                    {
                        degree = deg;
                        delete = pf.getEdges().getEdge(i, j);
                    
                    }
                    
                    flowT = flowT + od.getEdges().getEdge(i, j).getFlow();
                
                }
            }
            
            
            
            TotalFlow = TotalFlow + ", " + flowT; 
            if(iter == 0){
                prevFlow = flowT;
                DiffFlow = DiffFlow + ", " + "NaN"; 
            
            }
                
            else{
                DiffFlow = DiffFlow + ", " + (prevFlow-flowT);
                prevFlow = flowT; 
            }
            
            
            pf.getEdges().getEdge(delete.getFrom(), delete.getTo()).setStrength(0.0);
            int x = 1; 
            for(int i = 0; i < pf.getN(); i ++){
                for(int j = 0; j < pf.getN(); j++){
                    if (i != delete.getFrom() && j != delete.getTo())
                    {
                        if(pf.getEdges().getEdge(i, j).getBottleneckdegree() == delete.getBottleneckdegree())
                        {
                            pf.getEdges().getEdge(i, j).setStrength(0.0);
                            x += 1; 
                        
                        }
                    
                    }
                
                }}
            
            DeletionsAtIter = ", " + x; 
            
            
            for(int i = 0; i < pf.getN(); i ++){
                for(int j = 0; j < pf.getN(); j++){
                    pf.getEdges().getEdge(i, j).calcCapacity();
                
                }}
            
            
            
            
            
            iter ++; 
        
        
        
        
        }
        System.out.println(Iterations);
        System.out.println(TotalFlow);
        System.out.println(DiffFlow);
        System.out.println(DeletionsAtIter);
        
       
        

    }
    
}
