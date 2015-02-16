/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import edu.uci.ics.jung.graph.SparseMultigraph;
import java.util.Collection;


/**
 *
 * @author sophiewagner
 */
public class NodeDegree {
    int num=0;
    SparseMultigraph g = null ; 
    
    public NodeDegree(SparseMultigraph<MyNode, MyEdge> graph) {
        MyNode maxNode = null;
        this.g = graph; 
        

    }
    
    public MyNode findMaxNodeDegree(SparseMultigraph<MyNode, MyEdge> graph) {
        MyNode maxNode = null;
        this.g = graph; 
        Integer maxDegree = -1;
        Collection<MyNode> vertices = graph.getVertices();

        for (MyNode no : vertices) {
            if (graph.degree(no) > maxDegree) {
                maxNode = no;
                maxDegree = graph.degree(no);
            }
        }

        return maxNode;

    }
    
    public double findNodeDegree(MyNode i,SparseMultigraph<MyNode, MyEdge> graph)
    {
        return graph.degree(i);
    }
    
    public void returnAllDegree() 
    {
        String s = "Degree All Nodes \n";
        Collection<MyNode> vertices = g.getVertices(); 
        for(MyNode no : vertices)
        {
            double val = findNodeDegree(no, g); 
            s += val + "\n";
        }
        System.out.println(s);
    }

    public void deleteMaxNodeDegree(MyNodes un, MyEdges con,SparseMultigraph<MyNode, MyEdge> graph) {

        MyNode maxNode = findMaxNodeDegree(graph);
        if (maxNode == null) {
            return;
        }
        int k = maxNode.getNumber();
        //un.deleteNode(k);
        graph.removeVertex(maxNode);

        int n = graph.getVertexCount();
        System.out.println("deleting Node " + num + ": " + k + " name: " + maxNode.getName() + " degree: " + graph.degree(maxNode) );
        num ++; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == k || j == k) {
                    //con.deleteEdge(i, j);
                    graph.removeEdge(con.getEdge(i, j));
                }

            }
        }

    }
    
}
