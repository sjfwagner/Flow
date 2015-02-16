//package social;
//
//import edu.uci.ics.jung.graph.SparseMultigraph;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Collection;
//
//
///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author sophiewagner
// */
////this is kathleen mcglynn's method
//public class PurgeMaxNodeDegree {
//
//    MyNetwork original;
//    ArrayList<SparseMultigraph<MyNode, MyEdge>> deleteSeries;
//    
//    AvgDistance ad;
//    NodeDegree nd;
//    SparseMultigraph<MyNode, MyEdge> ig;
//
//    public PurgeMaxNodeDegree(MyNetwork original) {
//        this.deleteSeries = new ArrayList<SparseMultigraph<MyNode, MyEdge>>();
//        this.original = original;
//        this.ig = JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());
//
//    }
//
//    public String deleteAllNodes() throws FileNotFoundException {
//        //SparseMultigraph<MyNode, MyEdge> ig =  JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());
//        this.nd = new NodeDegree(ig); 
//        this.deleteSeries.add(ig);
//        
//        String s = "Density: \n";
//        String v = "Betweness: \n";
//        String y = "Num of Nodes: \n";
//
//        while (ig.getEdgeCount() > 0) {
//            //if(jg == null)
//            //{
//            //  return "finished"; 
//            //}
//
//            //else {
//
//            //System.out.println("density of the network:" + ad.Density());
//
//            //this.nd.(original.getNodes(), original.getEdges());
//             
//            nd.deleteMaxNodeDegree(original.getNodes(), original.getEdges(),ig);
//          
//            ig =  JungGraphFactory.makeGraph(original.getNodes(), original.getEdges());
//            this.deleteSeries.add(ig);
//
//            ad = new AvgDistance(ig, original);
//
//            double bet = ad.avgBetDistance();
//            double den = ad.Density();
//            int numi = ig.getVertexCount();
//            s = s + "" + den + "\n";
//            v = v + "" + bet + "\n";
//            y = y + "" + numi + "\n";
//
//            //} 
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
//        Collection<MyNode> nodes = ig.getVertices(); 
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
//}
