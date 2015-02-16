/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.util.ArrayList;
import edu.uci.ics.jung.algorithms.shortestpath.DistanceStatistics;
import java.lang.*;
import java.util.Random;

/**
 *
 * @author sophiewagner
 */
public class Interdict {
    
    private MyNetwork network; 
    private MyNetwork origindestination; 
    private ArrayList<MyEdge> elist;
    private Bottlenecking bn; 
    private DistanceStatistics ds; 
    private Degree deg;
    private Betweeness bc; 
    
    public Interdict(MyNetwork original, MyNetwork od)
    {
        this.network = original; 
        this.origindestination = od; 
        elist = new ArrayList<MyEdge>();
        this.bn = new Bottlenecking(network,origindestination);
        bn.ForAllOriginDestinations();
        System.out.println("Done");
        elist = bn.ReportHighestBottleneckers();
        this.ds = new DistanceStatistics();
        
        
   
    } 
    
    public void ReportFlowsOnOD()
    {
        
        System.out.println("///////////// ORIGIN DESTINATION MAX FLOWS /////////////");
        //System.out.println("///////////// DIAMETER OF NETWORK: " + ds.diameter(origindestination) "/////////////");
        for(int i = 0; i < origindestination.getN(); i ++){
            String x = origindestination.getNodes().getNode(i).getName() + ",";
            
           
            for(int j = 0; j < origindestination.getN(); j++)
            {
                
                x += (origindestination.getEdges().getEdge(i, j).getFlow() + ",");
                
            
            }
            System.out.println(x +",");
            
        }
        
//        NetworkPrinter np = new NetworkPrinter(origindestination);
//        System.out.println(np.PrintFlow());
        
    
    }
    
     public void ReportFreqOnNet()
    {
        
        System.out.println("///////////// NETWORK FREQUENCIES /////////////");
        for(int i = 0; i < network.getN(); i ++){
            String x = network.getNodes().getNode(i).getName() + ",";
            
           
            for(int j = 0; j < network.getN(); j++)
            {
                
                x += (network.getEdges().getEdge(i, j).getBottleneckdegree() + ",");
                
            
            }
            System.out.println(x +",");
            
        }
        
//         NetworkPrinter np = new NetworkPrinter(network);
//         System.out.println(np.PrintBottleneckDegree());
    }
    
    public void RandomDeleteInterdict()
    {
        ArrayList<MyEdge> what = new ArrayList<MyEdge>();
        Random r = new Random();
        while(what.size() < 18)
        {
           
            
            int g = r.nextInt(197);
            int t = r.nextInt(197);
            
            for(MyEdge e: elist)
            {
                if(((e.getFrom() == g) && ( e.getTo() == t)) && (what.contains(e) == false))
                {
                    this.network.getEdges().deleteEdge(e.getFrom(), e.getTo());
                    what.add(e);
                
                }
                    
            
            }
        
        System.out.println("Done");
        
            
        
        }
        System.out.println(what.size());
        ReportFlowsOnOD();
        ReportFreqOnNet(); 

    
    }
     
    public void DeleteInterdict(int repeat)
    {
        ArrayList<MyEdge> what = new ArrayList<MyEdge>();
        
        while(what.size() < repeat){
        //for(int r = 0; r < repeat; r ++){
                double x = 0.0; 
                this.deg = new Degree(this.network);
                this.deg.AssignTotalDegree();
                
                ArrayList<MyEdge> tops = new ArrayList<MyEdge>(); 

                for(MyEdge e: elist)
                {
                    double t = e.getBottleneckweightedv2();
                    //double t = e.getBottleneckdegree();
                    //double t = ((this.network.getNodes().getNode(e.getFrom()).getDegree().doubleValue() + this.network.getNodes().getNode(e.getTo()).getDegree().doubleValue()) / 2.0) ;

                    if(t > x)
                    {
                        if(!what.contains(e))
                            x = t; 


                    }

                }

                for(MyEdge e: elist)
                {
                    //double t = e.getBottleneckweightedv2();
                    //double t = e.getBottleneckdegree(); 
                    double t = (this.network.getNodes().getNode(e.getFrom()).getDegree().doubleValue() + this.network.getNodes().getNode(e.getTo()).getDegree().doubleValue()) / 2.0 ;
                    
                    if(t == x)
                    {
                        if(!what.contains(e))
                            tops.add(e);

                    }

                }

                for(MyEdge e: tops){
                    this.network.getEdges().deleteEdge(e.getFrom(), e.getTo());
                    System.out.println("EDGE DELETED" + network.getNodes().getNode(e.getFrom()).getName() + ", " +network.getNodes().getNode(e.getTo()).getName() );
                    what.add(e);


                }
                this.bn = new Bottlenecking(network,origindestination);
                bn.ForAllOriginDestinations();
                this.elist = bn.ReportHighestBottleneckers();
                System.out.println("Done");
                ReportFlowsOnOD();
                ReportFreqOnNet();

        }
        
        for(MyEdge e: what)
        {
            System.out.println("From: "+ origindestination.getNodes().getNode(e.getFrom()).getName() + " To: " +origindestination.getNodes().getNode(e.getTo()).getName());
        }
        
        
        
        }
    
    public void ReduceInterdict(int repeat)
    {
        ArrayList<MyEdge> what = new ArrayList<MyEdge>();
         ArrayList<MyEdge> tops = new ArrayList<MyEdge>(); 
        
         for(int r = 0; r < repeat; r ++){
            double x = 0.0; 
            for(MyEdge e: elist)
        {
            double t = e.getBottleneckdegree();
            
            if(t > x)
            {
                x = t; 
                
            
            }
        
        }
        
        for(MyEdge e: elist)
        {
            double t = e.getBottleneckdegree();
            
            if(t == x)
            {
                tops.add(e);
            
            }
        
        }
        
        for(MyEdge e: tops){
            this.network.getEdges().getEdge(e.getFrom(), e.getTo()).introduceInterceptors(1);
            what.add(e);
            
    
        }
          
         
//           
            this.bn = new Bottlenecking(network,origindestination);
            bn.ForAllOriginDestinations();
            this.elist = bn.ReportHighestBottleneckers();
            System.out.println("Done");
            ReportFlowsOnOD();
            ReportFreqOnNet();
    
        }
        
        for(MyEdge e: what)
        {
            System.out.println("From: "+ origindestination.getNodes().getNode(e.getFrom()).getName() + " To: " +origindestination.getNodes().getNode(e.getTo()).getName());
        }
    
    }
    
}
