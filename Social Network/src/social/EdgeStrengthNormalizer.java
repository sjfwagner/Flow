/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class EdgeStrengthNormalizer {

    private MyEdges edges;
    private MyNetwork mn;

    public  EdgeStrengthNormalizer(MyNetwork nm) {
        this.edges = nm.getEdges();
        this.mn = nm;
    }

    public Double findStrongest() {
        Double strongest = 0.0;
        for (int i = 0; i < mn.getN(); i++) {
            for (int j = 0; j < mn.getN(); j++) {
                Double test = this.edges.getEdge(i, j).getStrength();
                if (test > strongest) {
                    strongest = test;

                }
            }
        }

        return strongest;

    }
    
    public double normalize(){
        Double denom = findStrongest(); 
        for (int i = 0; i < mn.getN(); i++) {
            for (int j = 0; j < mn.getN(); j++) {
                
                Double numer = this.edges.getEdge(i, j).getStrength();
                Double newvalue = numer/denom; 
                
                this.edges.getEdge(i, j).setStrength(newvalue);
            }
        }
        
        
        
        return 0.0; 
    }
     
    
    
    
}
