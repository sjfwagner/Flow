/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;


/**
 *
 * @author sophiewagner
 */
public class Normalize {
    public MyNetwork norm; 
    private Double alpha; 
    private Double min;
    private Double max;
    
    
    public Normalize(MyNetwork net, double xmin, double xmax, double alpha)
    {
        this.norm = net; 
        this.alpha = alpha;
        this.min = xmin;
        this.max = xmax;
 
    }
    
    public MyNetwork Probability()
    {
        double exponent = 1- this.alpha;
        double denom = Math.pow(this.min,exponent) - Math.pow(this.max,exponent);
        
        for(int i = 0; i < norm.getN(); i++)
        {
            for(int j= 0; j < norm.getN(); j++)
            {
                
                if(norm.getEdges().getEdge(i, j).getStrength() > 0 )
                {
                    double numer = Math.pow(this.min, exponent) - Math.pow(norm.getEdges().getEdge(i, j).getStrength(), exponent);
                    double prob = numer/denom;
                    norm.getEdges().getEdge(i, j).setStrength(prob);
                    
                
                }
            }
        }
        
        
        return norm;
    }
     
}
