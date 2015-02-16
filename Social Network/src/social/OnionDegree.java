/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraDistance;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sophiewagner
 */
//we store degree on it's own, because on the copies it will change as we delete those that are higher than it
public class OnionDegree {

    public MyNetwork graph;
    DirectedSparseMultigraph<MyNode, MyEdge> jg;

    public OnionDegree(MyNetwork g) {
        this.graph = g;
        this.jg = JungGraphFactory.makeDirectedGraph(graph.getNodes(), graph.getEdges());

        Collection<MyNode> sk = new HashSet<MyNode>();
        sk = jg.getVertices();
        
//        
//        for(MyNode no: sk){
//           System.out.println("Number , " + no.getNumber() + ", Name ," + no.getName()) ;
//        }

//        for (int i = 0; i < graph.getNodes().getSize(); i++) {
//            MyNode mn = graph.getNodes().getNode(i);
//            
//            //if(jg.containsVertex(graph.getNodes().getNode(i))==false)//{
//             //   graph.getNodes().getNode(i).setDegree(0);//}
//             //System.out.println("I " + i + "degree " + mn);
//           // else
//                mn.setDegree(jg.degree(mn));
//            
//           
//
//        }


    }

    public Double identifyKStar() {
        double kstar = 0.0;

        for (int i = 0; i < graph.getN(); i++) {
            double test = graph.getNodes().getNode(i).getDegree();

            if (test > kstar) {
                kstar = test;
            }

        }
        return kstar;
    }

    public Integer identifyNK(double k) {
        int nk = 0;

        for (int i = 0; i < graph.getN(); i++) {
            double test = graph.getNodes().getNode(i).getDegree();

            if (k == test) {
                nk++;
            }

        }
        return nk;


    }

    //does k meet basic req? 
    public boolean basicSKreq(double k) {
        // do any nodes with that k exist? 
        if ((identifyNK(k) == 0) || (identifyNK(k) == 1)) {
            return false;
        }

        return true;

    }

    //returns an arraylist 
    public Integer findSK(double k) {
        int SK = 0;
        //ArrayList<MyNode> sk = new ArrayList<MyNode>();
        Set<MyNode> sk = new HashSet<MyNode>();
        
        
        DirectedSparseMultigraph copy = JungGraphFactory.copyDirectedGraph(jg);
        if (basicSKreq(k)) //does it pass the basic test?
        {
            for (int i = 0; i < graph.getN(); i++)// delete all nodes/edges that are greater than the target k-score
            {
                MyNode x = graph.getNodes().getNode(i);
                if (x.getDegree() > k && jg.containsVertex(graph.getNodes().getNode(i))) {
                    copy.removeVertex(x);

                }

            }
//            Collection vertices = copy.getVertices();
//            Object [] nodes =  vertices.toArray();
//            for (int i = 0; i < vertices.size(); i++) { 
//                //for all nodes contained in the copy can  any two with the same k-score reach each other w/o using a direct link??
//                MyNode copyi =(MyNode ) nodes[i];
//                System.out.println(""+i+" "+copyi);
//                    for (int j = 0; j < vertices.size(); j++) {
//                      
//                      MyNode copyj =(MyNode ) nodes[j];
//                      
//                      //System.out.println(""+j+" "+copyj);
//                            if(copyi.getDegree() == k && k==copyj.getDegree()){
//                           MyEdge me = (MyEdge) copy.findEdge(copyi.getNumber(), copyj.getNumber());
//                                if (me == null )//i.e. there's no direct connection between the nodes to have to worry about
//                                {
//                                    DijkstraDistance dd = new DijkstraDistance(copy);
//                                    Number dist = dd.getDistance(copyi,copyj);
//
//                                    if (dist != null) {
//                                        sk.add(copyi);
//                                    }
//
//
//
//                                } 
//
//
//                                else //there is a direct connection, and we're gonna have to get rid of it to test if the two are connected through other means, which means making a copy of copy
//                                {
//                                   
//                                    
//                                    //SparseMultigraph copycopy = JungGraphFactory.copyGraph(copy);
//                                 
//                                    copy.removeEdge(me); 
//                                        
//                                    
//                                    DijkstraDistance dd = new DijkstraDistance(copy);
//                                    Number dist = dd.getDistance(copyi,copyj);
//                                    if (dist != null) {
//                                        sk.add(copyi);
//                                    }
//                                    
//                                    
//                                    copy.addEdge( me.getFrom(),me.getTo(), EdgeType.DIRECTED);
//                                    
//                                }
//                          }
//
//                        }
//
//            }
            
            
            
            for (int i = 0; i < graph.getN(); i++){
                if(copy.containsVertex(graph.getNodes().getNode(i))){
                    for(int j = 0; j < graph.getN(); j++){
                         if(copy.containsVertex(graph.getNodes().getNode(j)))
                         {
                            if((graph.getNodes().getNode(i).getDegree()== k) && (graph.getNodes().getNode(j).getDegree()== k)){
                                if((copy.containsEdge(graph.getEdges().getEdge(i, j)) == false) && (copy.containsEdge(graph.getEdges().getEdge(j, i) ) == false))
                                {
                                        DijkstraDistance dd = new DijkstraDistance(copy);
                                        Number dist = dd.getDistance(graph.getNodes().getNode(i), graph.getNodes().getNode(j));

                                        if (dist != null) {
                                            sk.add(graph.getNodes().getNode(i));
                                        }

                                }
                                else if((copy.containsEdge(graph.getEdges().getEdge(i, j)) == true) || (copy.containsEdge(graph.getEdges().getEdge(j, i) ) == true))
                                {
                                        
                                        DirectedSparseMultigraph copycopy = JungGraphFactory.copyDirectedGraph(copy);
                                        if(copy.containsEdge(graph.getEdges().getEdge(i, j)) == true)
                                            copycopy.removeEdge(graph.getEdges().getEdge(i, j));
                                        if(copy.containsEdge(graph.getEdges().getEdge(j, i)) == true)
                                            copycopy.removeEdge(graph.getEdges().getEdge(i, j));
                                    
                                    
                                        DijkstraDistance dd = new DijkstraDistance(copycopy);
                                        Number dist = dd.getDistance(graph.getNodes().getNode(i), graph.getNodes().getNode(j));

                                        if (dist != null) {
                                            sk.add(graph.getNodes().getNode(i));
                                        }

                                }
                             
                         }
                         }
                    
                    }
            
                }
                        
            
            
            }
        }
                //}

        
        

            






        


        return sk.size();
    }

    public Double SumSKoverNK(double kstar) {

        
//        double sum = 0.0;
//        int x = 0; 
//        while (x <= kstar) {
//            double nk = identifyNK(x).doubleValue();
//            double sk = findSK(i).doubleValue();
//            x++;
//            if(nk==0)continue;
//            if (nk > 0) {
//                sum = sum + (sk / nk);
//            }
//
//           System.out.println(i + " sk=" + sk + " nk=" + nk);
//        }
//
//
//           // System.out.println("sum=" +sum);
//        return sum;
        
        double k = kstar; 
        double sum = 0; 
        for(double x = 0; x <= kstar; x++)
        {
            double nk = identifyNK(x); 
            double sk = findSK(x).doubleValue();
            
            
            
            if(nk == 0)
                continue;
            sum = sum + (sk/nk);
            
            
        
        
        }
        
        return sum; 
        
        
    }

    public Double OnionScore() {
        Double kstar = identifyKStar();
        //double kaystar = kstar.doubleValue();
        double summation = SumSKoverNK(kstar);

        double leftside = 1 / kstar;

        double c = leftside * summation;

        return c;
    }
}
