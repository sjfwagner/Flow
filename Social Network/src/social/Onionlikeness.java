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
public class Onionlikeness {

    public MyNetwork graph;
    DirectedSparseMultigraph<MyNode, MyEdge> jg;

    public Onionlikeness(MyNetwork g) {
        this.graph = g;
        this.jg = JungGraphFactory.makeDirectedGraph(graph.getNodes(), graph.getEdges());

        Collection<MyNode> sk = new HashSet<MyNode>();
        sk = jg.getVertices();
        
//        
//        for(MyNode no: sk){
//           System.out.println("Number , " + no.getNumber() + ", Name ," + no.getName()) ;
//        }

        for (int i = 0; i < graph.getNodes().getSize(); i++) {
            MyNode mn = graph.getNodes().getNode(i);
            
            //if(jg.containsVertex(graph.getNodes().getNode(i))==false)//{
             //   graph.getNodes().getNode(i).setDegree(0);//}
             //System.out.println("I " + i + "degree " + mn);
           // else
                mn.setDegree(jg.degree(mn));
            
           

        }


    }

    public Integer identifyKStar() {
        int kstar = 0;

        for (int i = 0; i < graph.getN(); i++) {
            int test = graph.getNodes().getNode(i).getDegree();

            if (test > kstar) {
                kstar = test;
            }

        }
        return kstar;
    }

    public Integer identifyNK(int k) {
        int nk = 0;

        for (int i = 0; i < graph.getN(); i++) {
            int test = graph.getNodes().getNode(i).getDegree();

            if (k == test) {
                nk++;
            }

        }
        return nk;


    }

    //does k meet basic req? 
    public boolean basicSKreq(int k) {
        // do any nodes with that k exist? 
        if ((identifyNK(k) == 0) || (identifyNK(k) == 1)) {
            return false;
        }

        return true;

    }

    //returns an arraylist 
    public Integer findSK(int k) {
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
            Collection vertices = copy.getVertices();
            Object [] nodes =  vertices.toArray();
            for (int i = 0; i < vertices.size(); i++) { 
                //for all nodes contained in the copy can  any two with the same k-score reach each other w/o using a direct link??
                MyNode copyi =(MyNode ) nodes[i];
                System.out.println(""+i+" "+copyi);
                    for (int j = 0; j < vertices.size(); j++) {
                      
                      MyNode copyj =(MyNode ) nodes[j];
                      
                      //System.out.println(""+j+" "+copyj);
                            if(copyi.getDegree() == k && k==copyj.getDegree()){
                           MyEdge me = (MyEdge) copy.findEdge(copyi.getNumber(), copyj.getNumber());
                                if (me == null )//i.e. there's no direct connection between the nodes to have to worry about
                                {
                                    DijkstraDistance dd = new DijkstraDistance(copy);
                                    Number dist = dd.getDistance(copyi,copyj);

                                    if (dist != null) {
                                        sk.add(copyi);
                                    }



                                } 


                                else //there is a direct connection, and we're gonna have to get rid of it to test if the two are connected through other means, which means making a copy of copy
                                {
                                   
                                    
                                    //SparseMultigraph copycopy = JungGraphFactory.copyGraph(copy);
                                 
                                    copy.removeEdge(me); 
                                        
                                    
                                    DijkstraDistance dd = new DijkstraDistance(copy);
                                    Number dist = dd.getDistance(copyi,copyj);
                                    if (dist != null) {
                                        sk.add(copyi);
                                    }
                                    
                                    
                                    copy.addEdge( me.getFrom(),me.getTo(), EdgeType.DIRECTED);
                                    
                                }
                          }

                        }

            }
        }
                //}


            






        


        return sk.size();
    }

    public Double SumSKoverNK(int kstar) {

        int i = kstar;
        double sum = 0.0;
        int x = 1; 
        while (x <= i) {
            double nk = identifyNK(i).doubleValue();
            double sk = findSK(i).doubleValue();
            x++;
            if(nk==0)continue;
            if (nk > 0) {
                sum = sum + (sk / nk);
            }

           System.out.println(i + " sk=" + sk + " nk=" + nk);
        }


           // System.out.println("sum=" +sum);
        return sum;
    }

    public Double OnionScore() {
        Integer kstar = identifyKStar();
        double kaystar = kstar.doubleValue();
        double summation = SumSKoverNK(kstar);

        double leftside = 1 / kaystar;

        double c = leftside * summation;

        return c;
    }
}
