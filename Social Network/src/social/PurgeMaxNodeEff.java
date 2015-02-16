/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;



import java.util.ArrayList;
import java.util.Collection;
import edu.uci.ics.jung.graph.SparseMultigraph;
/**
 *
 * @author sophiewagner
 */
//this is kathleen mcglynn's method
public class PurgeMaxNodeEff {

    MyNetwork original;
    ArrayList<SparseMultigraph<MyNode, MyEdge>> deleteSeries;
    SparseMultigraph<MyNode, MyEdge> jg;
    AvgDistance ad;
    GlobalEfficiencyHelper geh; 
    NodeDegree nd; 

    public PurgeMaxNodeEff(MyNetwork original) {
        this.deleteSeries = new ArrayList<SparseMultigraph<MyNode, MyEdge>>();
        this.jg =  JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());
        this.original = original;
        geh= new GlobalEfficiencyHelper(original);
    }

    public String deleteAllNodes(MyNodes un)  {
       
        this.deleteSeries.add(jg);
        
        //this.nd = new NodeDegree(); 
        
        //geh= new GlobalEfficiencyHelper(original);
        while (jg.getEdgeCount() > 0) {
            //if(jg == null)
            //{
            //  return "finished"; 
            //}

            //else {
            //System.out.println(jg.toString());
            //System.out.println("edgecount of the network:" + jg.getEdgeCount());
              MyNode most = geh.ReportGreatestDiffEfficency();
              if(most == null){return "finished";}
              System.out.println("");
              int mostnum = most.getNumber();
            //double avg  = rb.getEfficencyNetworkAvg(jg);
            
            geh.deleteMaxNodeEff(original.getNodes(), original.getEdges(),jg, mostnum);
            jg =  JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());
            this.deleteSeries.add(jg);
            
            

            ad = new AvgDistance(jg, original);

           System.out.println("Node w/ greatest Diff Efficiency: " + most);
            //System.out.println("Avg Efficency score" + );
            System.out.println("density of the network:" + ad.Density());
           // System.out.println("avg degree of the network:" ad.avgDegDistance());

            //} 



        }
        return "finished";
    }

    public String ReturnLeftovers() {
        String s = "Not Deleted: \n";
        MyNodes nodes = original.getNodes();
        int n = nodes.getSize();
        for (int i = 0; i < n; i++) {
            //if (!nodes.getNode(i).isDeleted()) {
                s += nodes.getNode(i).getName() + "\n";

           // }
        }
        return s;

    }
}
