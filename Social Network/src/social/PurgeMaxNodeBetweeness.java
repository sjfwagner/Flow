///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package social;
//
//import edu.uci.ics.jung.graph.SparseMultigraph;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// *
// * @author sophiewagner
// */
//public class PurgeMaxNodeBetweeness {
//
//    MyNetwork original;
//    ArrayList<SparseMultigraph<MyNode, MyEdge>> deleteSeries;
//    AvgDistance ad;
//    NodeDegree nd; 
//    Betweeness nb; 
//    Integer num = 1; 
//    
//    SparseMultigraph<MyNode, MyEdge> jg;
//
//    public PurgeMaxNodeBetweeness(MyNetwork original) {
//        this.deleteSeries = new ArrayList<SparseMultigraph<MyNode, MyEdge>>();
//        this.original = original;
//        this.jg = JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());
//    }
//
//    public String deleteAllNodes() throws FileNotFoundException {
//        //this.nd = new NodeDegree(); >yo ok, why is the the problem?? 
//        //this.nd = new NodeDegree();
//        //nd.findNodeDegree(null, jg);
//        int x = 0; 
//        this.nb = new Betweeness();
//        this.deleteSeries.add(jg);
//        String s = "Density: \n";
//        String v = "Betweness: \n";
//        String y = "Num of Nodes: \n";
//
//        while (jg.getEdgeCount() > 0) {
//            if (jg == null) {
//                return "finished";
//            } 
//            else if(x == 10)
//            {
//                System.out.println("");
//                System.out.println("HEY THIS IS ME AT 10");
//                nb.ReportAllBetweeness(jg);
//                System.out.println("");
//                x = x + 1; 
//
//            }
//            else if(x == 20)
//            {
//                System.out.println("");
//                System.out.println("HEY THIS IS ME AT 20");
//                nb.ReportAllBetweeness(jg);
//                System.out.println("");
//                x = x + 1;
//
//            }
//            else if(x == 80)
//            {
//                System.out.println("");
//                System.out.println("HEY THIS IS ME AT 80");
//                nb.ReportAllBetweeness(jg);
//                System.out.println("");
//                x = x + 1;
//
//            }
//            else {
//                
//                ad = new AvgDistance(jg, original);
//
//                //System.out.println("avg betweenness,  " + ad.avgBetDistance());
//                //System.out.println("density of the network ," + ad.Density());
//                
//                double bet = ad.avgBetDistance();
//                double den = ad.Density();
//                int numi = jg.getVertexCount();
//                s = s + "" + den + "\n";
//                v = v + "" + bet + "\n";
//                y = y + "" + numi + "\n";
//                //System.out.println("avg distance, " + ad.avgDegDistance());
//
//                deleteMaxNodeBetweeness();
//                x = x +1; 
//          
//
//                //jg =  JungGraphFactory.makeGraph(original.getNodes(), original.getEdges()); // TODO mjw
//                this.deleteSeries.add(jg);
//
//            }
//            ad = new AvgDistance(jg, original);
//
//            
//
//
//        }
//        System.out.println(s);
//        System.out.println(v);
//        System.out.println(y);
//        return "finished";
//    }
//
//    public String ReturnLeftovers() {
//        String s = "Not Deleted: \n";
//        MyNodes nodea = original.getNodes();
//        Collection<MyNode> nodes = jg.getVertices(); 
//        //int n = nodes.getSize();
//        int n = nodea.getSize();
//        for (int i = 0; i < n; i++) {
//            //if (!nodes.getNode(i).isDeleted()) {
//                //s += nodes.getNode(i).getName() + "\n";
//            
//            if(nodes.contains(nodea.getNode(i))){
//                s += nodea.getNode(i).getName();
//            }
//
//            //}
//        }
//        return s;
//
//    }
//
//    public double Density() {
//        double denominator = jg.getVertexCount() / 2;
//        int numerator = jg.getEdgeCount();
//
//        double density = denominator / numerator;
//
//        return density;
//    }
//    
//    
//    public void deleteMaxNodeBetweeness() {
//
//        MyNode maxNode = nb.findMaxNodeBetweeness(jg);
//        if (maxNode == null) {
//            return;
//        }
//        int k = maxNode.getNumber();
//        //un.deleteNode(k);
//        this.jg.removeVertex(maxNode);
//        
//
//        int n = jg.getVertexCount();
//        //System.out.println("deleting Node " + num + ": " + k + " name: " + maxNode.getName() + " betweenness rank: " + nb.getRanker(maxNode));
//        System.out.println( "Node, " + maxNode.getName() + " , betweenness rank ,  " + nb.getRanker(maxNode) );
//
//        num ++; 
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == k || j == k) {
//                    //con.deleteEdge(i, j);
//                    jg.removeEdge(original.getEdges().getEdge(i, j));
//                    
//                }
//
//            }
//        }
//         
//
//    }
//    
//}
