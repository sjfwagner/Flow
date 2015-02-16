/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import java.util.ArrayList;

/**
 *
 * @author sophiewagner
 */
public class PathFinder {
    Paths paths = new Paths();

    public Paths getPaths() {
        return paths;
    }

    public PathFinder(MyNetwork mn, MyNode source, MyNode sink) {

        //source = source; 

        MyEdges con = mn.getEdges();
        MyNodes un = mn.getNodes();
        Integer num = mn.getN();
        ArrayList<Integer> pathlist = new ArrayList<Integer>();

        
        //
        //Paths paths = new Paths();
        
        // I'm pretty proud of how neat this is. Does Dr. Wierman think that it will work? I think it will :) 
        // THIS WILL TAKE FOREVER TO RUN UNLESS WE RESTRICT THE SIZE OF THE GRAPH. THE GRAPH MUST BE MADE SMALLER
        
//        int i = source.getNumber(); 
//        pathlist.add(i);
//        int j = 0;
//        while( j < num){
//            if(con.getEdge(i, j).getStrength() > 0.0){
//                Path a = new Path(un.getNode(i));
//                a.addNode(un.getNode(j));
//                if(un.getNode(j)==sink){
//                    paths.addPath(a);
//                    j++; 
//                }
//                else j++;
//                
//                int k = 0; 
//                while(k < num){
//                    if(con.getEdge(j, k).getStrength() > 0.0){
//                        a.addNode(un.getNode(k));
//                        if(un.getNode(k) == sink){
//                            paths.addPath(a);
//                            k++;
//                        }
//                        else k++; 
//                    
//                        int t = 0;
//                        while (t< num){
//                            if(con.getEdge(k, t).getStrength() > 0.0){
//                                a.addNode(un.getNode(t));
//                                if(un.getNode(k)==sink){
//                                    paths.addPath(a);
//                                    t++;
//                                }
//                                else t++; 
//                                
//                                int s = 0; 
//                                while(s < num){
//                                    if(con.getEdge(t, s).getStrength() > 0.0){
//                                        a.addNode(un.getNode(s));
//                                        paths.addPath(a);
//                                        s++;
//                                    }
//                                    else s++;
//                                    
//                                    int q = 0; 
//                                    while(q < num)
//                                    {
//                                        if(con.getEdge(s, q).getStrength() > 0.0){
//                                            a.addNode(un.getNode(q));
//                                            paths.addPath(a);
//                                            q++;
//                                        }
//                                        else q++; 
//                                    
//                                    }
//                                    
//                                }
//                            
//                            }
//                        
//                        }
//                    
//                    }
//                
//                
//                }
//                
//            }
//            
//        
//        }
//
//       
//    
//        
//        
//        Paths paths = new Paths();
//        
//        int i = source.getNumber(); 
//        pathlist.add(i);
//        Graph<MyNode,MyEdge> constrict = ConstrictGraph.MyFilter(mn, source, 3);
//        int n = constrict.getVertexCount();
//        
//        for(int j = 0; j < n; j++)
//        {
//            if(constrict.getPredecessors(mn.getNodes().getNode(j)).contains(source)){
//                if(constrict.getPredecessorCount(mn.getNodes().getNode(j)))
//            }
//        
//        }
        
        
        
        
    }
    
}
