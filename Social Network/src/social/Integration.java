/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.SparseMultigraph;

/**
 *
 * @author sophiewagner
 */
public class Integration {
    
    private SparseMultigraph<MyNode, MyEdge> ig;
    
    private MyNetwork mn; 
    
    public Integration(MyNetwork mn)
    {
        this.ig = JungGraphFactory.makeGraph(mn.getNodes(), mn.getEdges());
        this.mn = mn; 
        
    
    }
    
    public Double ReverseDistance(MyNode v, MyNode i)
    {
        Double diameter = ShortestPath.Diameter(this.ig, this.mn.getNodes()); 
        Double minLengthIV = ShortestPath.ShortestDistance(v, i, this.ig);
        
        
        
        Double result = (diameter - minLengthIV) + 1; 
        
        return result;
    }
    
    public Double SumReverseDistance(MyNode v)
    {
        Double sum = 0.0; 
        for(int i = 0; i < this.mn.getNodes().getSize(); i++){
            System.out.println(this.mn.getNodes().getNode(i));
            Double test = ReverseDistance(this.mn.getNodes().getNode(i), v);
            sum = sum + test; 
        }
        
        Double result = null;
        result = sum/(this.mn.getNodes().getSize()-1); 
            
        return result;
    }
    
    public Double NormalizedIntegration(MyNode v)
    {
        Double result = 0.0; 
        
        Double numerator = SumReverseDistance(v);
        Double denominator = ShortestPath.LongestShortestPossibleLength(v, ig, this.mn.getNodes());
        
        result = numerator/denominator; 
    
        return result; 
    }
    
    
    
    
    
    
    
    
    
    
}
