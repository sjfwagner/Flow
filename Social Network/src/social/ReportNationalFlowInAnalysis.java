/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class ReportNationalFlowInAnalysis {
   
    
    public NationalFlowInAnalysis nfoa;
    
    
    public ReportNationalFlowInAnalysis(String x, MyNetwork t, MyNetwork o)
    {
        
        MyNode n = null;
        for(int i = 0; i < t.getN(); i++)
        {
            if(t.getNodes().getNode(i).getName().equalsIgnoreCase(x)){
                n = t.getNodes().getNode(i); 
            }
        
        }
        
        nfoa = new NationalFlowInAnalysis(t, o, n);
        nfoa.DoAnalysis();
    
    
    }
    
    public void ReportBottleneckers()
    {
        MyNetwork g  = nfoa.ReturnPathFlowGraph(); 
        
        for(int i = 0; i < g.getN(); i++)
        {
            for(int j = 0; j < g.getN(); j++){
                int x = g.getEdges().getEdge(i, j).getBottleneckdegree(); 
                if(x > 0)
                    System.out.println(g.getNodes().getNode(i).getName() + ", to ," + g.getNodes().getNode(j).getName() + ", Flow = ,"+x);
            }
        
        }
    
    
    }
    
    public void ReportPaths()
    {
        MyNetwork g  = nfoa.ReturnPathFlowGraph(); 

            for(int i = 0; i < g.getN(); i++)
            {
                for(int j = 0; j < g.getN(); j++){
                    double x = g.getEdges().getEdge(i, j).getFlow(); 
                    if(x > 0)
                        System.out.println(g.getNodes().getNode(i).getName() + ", to ," + g.getNodes().getNode(j).getName() + ", Flow = ,"+x);
                }

            }

    
    }
    
    public void ReportFlowOrigins()
    {
        MyNetwork g  = nfoa.ReturnODFlowGraph();

                int j = nfoa.target.getNumber();
                    for(int i = 0; i < g.getN(); i++){
                        double x = g.getEdges().getEdge(i, j).getFlow(); 
                        if(x > 0)
                            System.out.println(g.getNodes().getNode(i).getName()  + ", to ," + nfoa.target.getName()  + ", Flow = ,"+x);
                    }

                

    }
    
}
