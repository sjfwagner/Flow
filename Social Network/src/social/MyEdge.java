package social;

/*
 * Edge creates an edge obj with a attributes
 */

/**
 *
 * @author sophiewagner
 */
public class MyEdge implements Comparable {
    
    private Integer from;
    private Integer to;
    private Double migration; 
    private Double strength;
    private boolean directed;
    private boolean deleted; 
    private Integer bottleneckdegree;
    private Double bottleneckweighted; 
    private Integer intercept; 
    private Double bottleneckweightedv2; 
    private Double Flow; 
    private Double CorruptionTo; 
    private Double Si; 
    private Double Dj; 
    private Double capacity; 
    private Double betweeness; 
    private Double totalFlow; 

    public Double getMigration() {
        return migration;
    }

    public void setMigration(Double migration) {
        this.migration = migration;
    }

    
    public Double getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(Double tf) {
        this.totalFlow += tf;
    }


    public Double getBetweeness() {
        return betweeness;
    }

    public void setBetweeness(Double betweeness) {
        this.betweeness = betweeness;
    }

    public Double getCapacity() {
        if( this.deleted == false)
        {
        return strength;
        }
        else if(this.deleted == true)
        {
        return 0.0; 
        }
        
        return strength; 
    }
    
    public void calcCapacity()
    {
        


//            double c = Math.pow( , m); 
//            double s  = Math.pow( , n);
//            double cap = s * c;  

            //double scScore = Math.pow((Si * Dj), m); 
            //double scScore = (Si * Dj); 
            //capacity = scScore * strength * CorruptionTo; 
            
            capacity = strength;
        
    }

    public Double getSi() {
        return Si;
    }

    public void setSi(Double Si) {
        this.Si = Si;
    }

    public Double getDj() {
        return Dj;
    }

    public void setDj(Double Dj) {
        this.Dj = Dj;
    }

    public Double getCorruptionTo() {
        return CorruptionTo;
    }

    public void setCorruptionTo(Double CorruptionTo) {
        this.CorruptionTo = CorruptionTo;
    }
    
//    public Edge( int in, int out, double Strength)
//    {
//        this.from = in;
//        this.to = out;
//        this.strength = Strength;
//       
//    }

    /**
     * Constructor for MyEdge
     * @param from
     * @param to
     * @param strength
     * @param directed
     */
    public MyEdge(Integer from, Integer to, Double strength, boolean directed) {
        this.from = from;
        this.to = to;
        this.strength = strength;
        this.directed = directed;
        this.deleted = false; 
        this.bottleneckdegree = 0; 
        this.bottleneckweighted = 0.0; 
        this.intercept = 0 ; 
       this.bottleneckweightedv2 = 0.0; 
       this.Flow = 0.0; 
       
    }

    public Double getFlow() {
        return Flow;
    }

    public void setFlow(Double Flow) {
        this.Flow = Flow;
    }
    
    public void addFlow(Double f) {
        this.Flow += f; 
    }


    

    public Double getBottleneckweightedv2() {
        return bottleneckweightedv2;
    }

    public void setBottleneckweightedv2(Double numerator,Double denominator) {
        this.bottleneckweightedv2 += (numerator/denominator);
    }

    public MyEdge(MyEdge e) {
        this.from = e.from;
        this.to = e.to;
        this.strength = e.strength;
        this.directed = e.directed;
        this.deleted = e.deleted; 

    }

    public Integer getBottleneckdegree() {
        return bottleneckdegree;
    }

    public void setBottleneckdegree(Integer increment) {
        
        this.bottleneckdegree = this.bottleneckdegree + increment;
    }
    
    public Double getBottleneckWeighted() {
        return bottleneckweighted;
    }

    public void addToBottleneckWeighted(Double increment) {
        
        this.bottleneckweighted += bottleneckweighted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Double getStrength() {
        
        if( this.deleted == false)
        {
        return strength;
        }
        else if(this.deleted == true)
        {
        return 0.0; 
        }
        
        return strength; 
        
    }
    
    public void introduceInterceptors(int o)
    {
        this.intercept = this.intercept + o ;  
        this.strength = this.strength * (.5 * this.intercept);
    
    }

    public void setStrength(Double strength) {
        //this.strength += strength;
        this.strength = strength;
        
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    @Override
    public String toString() {
        return "Edge{" + "from=" + from + ", to=" + to + ", strength=" + strength + ", directed=" + directed + '}';
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
