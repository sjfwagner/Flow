/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class ReportNationalFlowOutAnalysis {
   
    
    public NationalFlowOutAnalysis nfoa;
    
    
    public ReportNationalFlowOutAnalysis(String x, MyNetwork t, MyNetwork o)
    {
        
        MyNode n = null;
        for(int i = 0; i < t.getN(); i++)
        {
            if(t.getNodes().getNode(i).getName().equalsIgnoreCase(x)){
                n = t.getNodes().getNode(i); 
            }
        
        }
        
        nfoa = new NationalFlowOutAnalysis(t, o, n);
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
    
    public void ReportFlowDestinations()
    {
        MyNetwork g  = nfoa.ReturnODFlowGraph();

                int i = nfoa.target.getNumber();
                    for(int j = 0; j < g.getN(); j++){
                        double x = g.getEdges().getEdge(i, j).getFlow(); 
                        if(x > 0)
                            System.out.println(nfoa.target.getName() + ", to ," + g.getNodes().getNode(j).getName() + ", Flow = ,"+x);
                    }

                

    }
    
}
