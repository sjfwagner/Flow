/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sophiewagner
 */
public class SN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        // MyNetwork trafficmap = new MyNetwork("ModernWorld.csv");
         MyNetwork trafficmap = new MyNetwork("ntm.csv");
         MyNetwork origindestination = new MyNetwork("McGlynn.csv");
         //MyNetwork maxflow = new MyNetwork("newflow.csv");
         MyNetwork maxTradeflow = new MyNetwork("FlowTrade+Migration.csv");
         MyNetwork intflow = new MyNetwork("internetflow.csv");
         MyNetwork internet = new MyNetwork("InternetCountry.csv");
         MyNetwork migration = new MyNetwork("Migration.csv");
         MyNetwork diplomaticEight = new MyNetwork("diplomatic84.csv");
         
         
         AddCorruption ac = new AddCorruption(trafficmap);
         AddSD sd = new AddSD(trafficmap);
         for(int i = 0 ; i < trafficmap.getN(); i++){
             for(int j = 0 ; j < trafficmap.getN(); j++)
             {
                 trafficmap.getEdges().getEdge(i, j).calcCapacity();
             
             }}
         
         
         
       
         
         //ArrayList<MyNetwork>  nets = new ArrayList<MyNetwork>(); 
         
//         nets.add(trafficmap);
//         nets.add(origindestination);
//         nets.add(internet);
//         nets.add(migration);
//         nets.add(diplomaticEight);
         
         IO_Network ion = new IO_Network();
         
         MyNetwork original = new MyNetwork(origindestination);
         System.out.println(original.getN());
         
         DirectedSparseMultigraph<MyNode, MyEdge> jg = JungGraphFactory.makeDirectedGraph(original.getNodes(), original.getEdges());
         SparseMultigraph<MyNode, MyEdge> ig = JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());

         //System.out.println(original.toString());
         MyNetwork next = new MyNetwork(trafficmap); 
         ion.WriteNodeToCSV(trafficmap.getNodes(), true);
         ion.WriteEdgesToCSV(trafficmap.getEdges(), true);
         ion.close();
         
         Interdict inter = new Interdict(trafficmap, origindestination);
         inter.ReportFreqOnNet();
         inter.ReportFlowsOnOD();
         inter.DeleteInterdict(100);
         
         
         //AttackEdgeswithDoAnalysis aewda = new AttackEdgeswithDoAnalysis(15,trafficmap, origindestination);
         
//         for (int i = 0; i < origindestination.getN(); i++){
//             for(int j = 0; j < origindestination.getN(); j++)
//             {
//                 if (origindestination.getEdges().getEdge(i, j).getStrength() > 0 )
//                 {
//                     System.out.println(origindestination.getNodes().getNode(i).getName() + "," + origindestination.getNodes().getNode(j).getName());
//                 
//                 }
//             
//             }
//         
//         }
//         
//          for (int i = 0; i < trafficmap.getN(); i++){
//             for(int j = 0; j < trafficmap.getN(); j++)
//             {
//                 if (trafficmap.getEdges().getEdge(i, j).getStrength() > 0 )
//                 {
//                     double x = trafficmap.getEdges().getEdge(i, j).getStrength();
//                     for(int y = 0; y < x; y++)
//                        System.out.println(trafficmap.getNodes().getNode(i).getName() + "," + trafficmap.getNodes().getNode(j).getName());
//                 
//                 }
//             
//             }
//         
//         }
//         
         
         
         //Constrict ct = new Constrict(trafficmap, origindestination);
         //ct.InterdictBottleneckDegree(2);
         
         
//         for(int i = 0; i < nets.size(); i++){
//             System.out.println("\n");
//             Degree degree = new Degree(nets.get(i));
//             MyNetwork d = degree.AssignTotalDegree(); 
//             OnionDegree od = new OnionDegree(d);
//             System.out.println("K* ," + od.identifyKStar());
//             double score = od.OnionScore(); 
//             System.out.println("Onion Score: " + score);
//             System.out.println("Range: " + (1.0/od.identifyKStar()) + " < x< 1"  );
//             double tot = 1 - 1.0/od.identifyKStar();
//             double perc = score/ tot; 
//             System.out.println("Percentage of Range Achieved: " + (perc*100));
//             System.out.println("\n");
//         }
//         
         
//         
         
////         System.out.println("I'm starting");
////         ReportNationalFlowOutAnalysis rnfoa = new ReportNationalFlowOutAnalysis("nigeria",trafficmap,origindestination);
////         System.out.println("Bottleneckers");
////         rnfoa.ReportBottleneckers();
////         System.out.println("Destinations & Flow");
////         rnfoa.ReportFlowDestinations();
////         System.out.println("Paths & Flow");
////         rnfoa.ReportPaths();
//////         
////  
//         
//         System.out.println("I'm starting");
//         ReportNationalFlowInAnalysis rnfoa = new ReportNationalFlowInAnalysis("United States",trafficmap,origindestination);
//         System.out.println(" \n \n Bottleneckers");
//         rnfoa.ReportBottleneckers();
//         System.out.println("\n \n Destinations & Flow");
//         rnfoa.ReportFlowOrigins();
//         System.out.println("\n \n Paths & Flow");
//         rnfoa.ReportPaths();
         
         
////         
//         FlowAnalysis fa = new FlowAnalysis(trafficmap,origindestination);
//         fa.DoAnalysis();
//         
//         NetworkPrinter np = new NetworkPrinter(fa.ReturnPathFlowGraph());
//         System.out.println("Path flow \n \n " +np.PrintFlow() + "\n \n \n");
//         
//         NetworkPrinter pn = new NetworkPrinter(fa.ReturnODFlowGraph());
//         System.out.println("OD flow \n \n " +pn.PrintFlow() + "\n \n \n");
//         
//         Breaks breaky = new Breaks(intflow);
//         breaky.fourtybreaks();
//////         
//         OnionTwo onion = new OnionTwo(intflow);
//         System.out.println(onion.OnionScore());
         
         
//         for(int i = 0; i < maxflow.getN(); i++){
//             //String x = maxflow.getNodes().getNode(i).getName() + ", ";
//             String x = "";
//             int y = 0; 
//             for(int j = 0; j < maxflow.getN(); j++)
//             {
//                 y += maxflow.getEdges().getEdge(i,j).getStrength();
//                 y += maxflow.getEdges().getEdge(j,i).getStrength();
//                // if (i == 1){System.out.println(maxflow.getNodes().getNode(i).getName() +", "+maxflow.getNodes().getNode(j).getName() +", "+ +maxflow.getEdges().getEdge(i,j).getStrength());}
//             }
//             double r = y/6334.0;
//             x += r; 
//             System.out.println(x);
//         }
         
//         for(int i = 0; i < maxflow.getN(); i++){
//             
//             ArrayList<MyEdge> x = new ArrayList<MyEdge>();
//             int t = 0; 
//                 for(int j = 0; j < maxflow.getN(); j++)
//                 {
//                     if((maxflow.getEdges().getEdge(i, j).getStrength() > 0) || (maxflow.getEdges().getEdge(j, i).getStrength() > 0))
//                     {
//                         
//                         if(maxflow.getEdges().getEdge(i, j).getStrength() > 0)
//                            x.add(maxflow.getEdges().getEdge(i, j));
//                         else 
//                             x.add(maxflow.getEdges().getEdge(j, i));
//                     }
//
//             }
//             if(x.size()<= 10)
//             {
//                 for(int z = 0; z < x.size(); z++)
//                 {
//                     MyEdge y = x.get(z);
//                     
//                     System.out.println(maxflow.getNodes().getNode(y.getFrom()).getName() +" ," + maxflow.getNodes().getNode(y.getTo()).getName()+" ," + y.getStrength());
//                 }
//                 break; 
//             }
//                 
//             
//             String x = maxflow.getNodes().getNode(i).getName() + ", ";
//             int y = 0; 
//             for(int j = 0; j < maxflow.getN(); j++)
//             {
//                 y += maxflow.getEdges().getEdge(i,j).getStrength();
//                 y += maxflow.getEdges().getEdge(j,i).getStrength();
//                // if (i == 1){System.out.println(maxflow.getNodes().getNode(i).getName() +", "+maxflow.getNodes().getNode(j).getName() +", "+ +maxflow.getEdges().getEdge(i,j).getStrength());}
//             }
//             x += y; 
//             System.out.println(x);
//         }
         
//         Onionlikeness o = new Onionlikeness(trafficmap);
//         System.out.println("Onion Score Global Network: "+o.OnionScore());
         //System.out.println("^ K* : "+o.identifyKStar());
         
         
//         Onionlikeness n = new Onionlikeness(origindestination);
        // System.out.println("Onion Score Human Trafficking: "+n.OnionScore());
         //System.out.println("^ K* : "+n.identifyKStar());
//         
//         Onionlikeness i = new Onionlikeness(internet);
//         System.out.println("Onion Score Human Trafficking: "+i.OnionScore());
//         
//         Onionlikeness l = new Onionlikeness(migration);
//         System.out.println("Onion Score Human Trafficking: "+l.OnionScore());

         
         
         
         
         
         
//         for(int i = 0; i < migration.getN(); i++)
//             for(int j = 0; j < migration.getN(); j++)
//             {
//                 if(migration.getEdges().getEdge(i, j).getStrength()>1){
//                     migration.getEdges().getEdge(i, j).setStrength(1.0);
//                 }
//             
//             }
         
         
//         

////         
     //AddRegion ar = new AddRegion("Regions.csv",maxTradeflow);
////////           for(int i = 0; i < maxflow.getN(); i++)
////////             System.out.println("Name: " + maxflow.getNodes().getNode(i).getName() + ", Region: " +  maxflow.getNodes().getNode(i).getRegion() 
////////                                + ", Sub-Region: "  + maxflow.getNodes().getNode(i).getSubregion() );
////////  
////////             for(int i = 0; i < maxflow.getN(); i++)
////////                 for(int j = 0; j < maxflow.getN(); j++)
////////                     System.out.println(maxflow.getEdges().getEdge(i, j).getStrength());
////// 
//////         
         //RegionComparison rc = new RegionComparison(maxTradeflow);
//////         //rc.CompareRegion(1, 1);
//////         //rc.CompareAllRegions(4);
//        rc.CompareAllRegionsPercent(852757.0);
//////         
// //       rc.CompareAllSubRegions(8);
//////         
       // rc.CompareAllSubRegionsPercent(279191.0);
//         
       
         
         
//         int x = 0; 
//         for(int i = 0; i< trafficmap.getN(); i++)
//             for(int j = 0; j < trafficmap.getN(); j++)
//             {
//                 
//                 if(trafficmap.getEdges().getEdge(i, j).getStrength()> 0){
//                     x += 1; 
//                 
//                 }
//                 
//             
//             }
//         
//         System.out.println(x);
//         
//         Interdict inter = new Interdict(trafficmap, origindestination);
//         inter.ReportFreqOnNet();
//         inter.ReportFlowsOnOD();
//         inter.DeleteInterdict(15);
         //inter.ReduceInterdict(2);
         //inter.RandomDeleteInterdict();
         
//         
//         ArrayList<String> list = new ArrayList<String>();
//         Bottlenecking bn = new Bottlenecking(trafficmap,origindestination);
//         list = bn.ReportHighestBottleneckers();
//         for(String s : list)
//         {
//             System.out.println(s);
//         }
//         System.out.println(bn.Average());
//         
//         StdCloseness sc = new StdCloseness(ig, trafficmap);
//         for(int i = 0; i < trafficmap.getN(); i++)
//         {  
//             double close = sc.findCloseness(i);
//             System.out.println("" + trafficmap.nodes.getNode(i).getName()+ "  " +  "closeness:" + close);
//         }
//         for(int i = 0; i < trafficmap.getN(); i++)
//         {
//             double total = 0.0; 
//             
//             for(int j = 0; j < trafficmap.getN(); j++)
//             {
//                total += trafficmap.getEdges().getEdge(i, j).getBottleneckdegree();
//                total += trafficmap.getEdges().getEdge(j, i).getBottleneckdegree();
//                
//             }
//             trafficmap.getNodes().getNode(i).setFreq((int)total);
//         }
//         for(int i = 0; i < trafficmap.getN(); i++)
//         {
//             System.out.println(trafficmap.getNodes().getNode(i).getName() +"," + trafficmap.getNodes().getNode(i).getFreq());
//         
//         }
         
         
         
         
         //EdgeStrengthNormalizer esn = new EdgeStrengthNormalizer(original);
         //esn.normalize();
         
         
         
         
//         Integration it = new Integration(trafficmap);
//         int i = 36; 
//         System.out.println(trafficmap.nodes.getNode(i).toString());
//         Double result = it.NormalizedIntegration(trafficmap.nodes.getNode(i));
//         System.out.println(result);
         
        // NetworkWriter fp = new NetworkWriter(trafficmap);
         //PathFinder pf = new PathFinder(original, original.nodes.getNode(1), original.nodes.getNode(6)); 
         //pf.getPaths().toString();
        // pf.getPaths().print(pf.getPaths());
         
//         VCluster vc = new VCluster(ig, ig.getVertexCount());
//         vc.Cluster(7);
        
         
           //NodeBetweeness nb = new NodeBetweeness();  
           //nb.ReportAllBetweeness(ig);
//         
//         PurgeMaxNodeDegree pmn=new PurgeMaxNodeDegree(original);
//         pmn.deleteAllNodes();
//         System.out.println(pmn.ReturnLeftovers());
//         
//         PurgeMaxNodeDegreeDemonstration pmnd =new PurgeMaxNodeDegreeDemonstration(original);
//         String deleteAllNodes = pmnd.deleteAllNodes();
//         System.out.println(pmnd.ReturnLeftovers());
//         
//         NodeDegree nd = new NodeDegree(ig);
//         nd.returnAllDegree();
         
//         
         
//         original = new MyNetwork(trafficmap); 
//
//         PurgeMaxNodeBetweeness pmnb = new PurgeMaxNodeBetweeness(original);
//         pmnb.deleteAllNodes();
//         System.out.println(pmnb.ReturnLeftovers());
         
//         PurgeMaxNodeEff pmne = new PurgeMaxNodeEff(original);
//         pmne.deleteAllNodes(original.getNodes()); 
//         System.out.println(pmne.ReturnLeftovers());
//         
//           GlobalEfficiency ge = new GlobalEfficiency(original, ); 
//           double x = ge.EfficiencyResult();
//           System.out.println(x);
////         
//         PurgeMaxNodeEff pmne = new PurgeMaxNodeEff(original);
//         pmne.deleteAllNodes(original.getNodes());
//         System.out.println(pmne.ReturnLeftovers());
         
         //GlobalEfficiencyHelper geffh = new GlobalEfficiencyHelper(original);
         
         //for(int u = 0; s)
         
         //System.out.println(geffh.getGlobalEfficiency(original));
            //int c = 1;
         
         
         //System.out.println(original.nodes.getSize());
            
//            for(int s = 0; s<original.getNodes().getSize();s++){
//                System.out.println("NODE: " + original.getNodes().getNode(s).getName());
//                
//                for(int t=0;t<=original.getNodes().getSize();t++){
//                if(s==t){ System.out.println(" ");}
//                else if(t == original.getNodes().getSize()){System.out.println("BREAK/n");}
//                else{
//                    System.out.println(trafficmap.getNodes().getNode(t).getName());
//                    EdmondsKarp ek = new EdmondsKarp(jg, original.getNodes().getNode(s),original.getNodes().getNode(t));
//                }
//            }
//            }
            
           // EdmondsKarp ek = new EdmondsKarp(jg, original.nodes.getNode(37), original.nodes.getNode(188));
//            System.out.println(); 
//             SNFrame snf = new SNFrame();
//         EdgeLabelPanel3 elp = new EdgeLabelPanel3(trafficmap.getNodes(), trafficmap.getEdges(), ek.getFlow());
//         snf.setSize(1000, 1000);
//         snf.getContentPane().add(elp);
//         snf.setVisible(true);
         
//            EdmondsKarp ke1 = new EdmondsKarp(jg, original.getNodes().getNode(37),original.getNodes().getNode(185));
//            EdmondsKarp ke2 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(187));
            //EdmondsKarp ke3 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(84));
//            EdmondsKarp ke4 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(169));
//            EdmondsKarp ke5 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(152));
//            EdmondsKarp ke6 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(37));
//            EdmondsKarp ke7 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(162));
//            EdmondsKarp ke8 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(46));
//            EdmondsKarp ke9 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(79));
//            EdmondsKarp ke10 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(164));
//            EdmondsKarp ke11 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(66));
//            EdmondsKarp ke12 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(181));
//            EdmondsKarp ke13 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(67));
//            EdmondsKarp ke14 = new EdmondsKarp(jg, original.getNodes().getNode(84),original.getNodes().getNode(175));
            
    }
    
    
}
