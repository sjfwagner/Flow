/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class MyEdges {
    
    private String header;
    private String rows;
    MyEdge [][] edges;
    MyNodes nodes; 
    private int n; 
    private int edgeCount; 

    public int getEdgeCount() {
        return edgeCount;
    }
    
    public void deleteEdge(int i, int j)
    {
        edges[i][j].setDeleted(true);
        
    }
    
    public void unDeleteEdge(int i, int j)
    {
        edges[i][j].setDeleted(false);
    }
   
    public MyEdges(int n) {
        edges =new MyEdge[n][n]; 
        this.n = n; 
    }

    public MyEdges(MyEdges e) {
        this.n = e.n;
         edges =new MyEdge[n][n]; 
        for ( int i = 0; i<n; i++)
        for (int j = 0; j < n; j++)
        {
            this.edges[i][j]=new MyEdge(e.edges[i][j]);
            this.edgeCount = this.edgeCount +1; 
        }
    }
    
    public void setEdge(int i,int j,MyEdge e)
    {
        edges[i][j]=e;
    }
    public MyEdge getEdge(int i,int j){
        return edges[i][j];
    }
    
    
   

    @Override
    public String toString() {
        String S="";
        for ( int i = 0; i<n; i++)
        for (int j = 0; j < n; j++)
        {
            S+=this.edges[i][j].toString()+"\n";
        }
        return S;
    }

    public String WriteEdges() {
        this.rows = "";

       for (int i = 0; i < n; i++) {
           this.rows += nodes.getNode(i).getName() + "\t";
           for (int j = 0; j < n; j++) {
           this.rows += this.getEdge(i, j).getStrength() + "\t";
            
           }
           this.rows += "\n";
        }
        


        return this.rows;

    }

    void setNodes(MyNodes nodes) {
        this.nodes= nodes;
    }

    public String WriteHeader() {
        this.header = "\t";

       for (int i = 0; i < n; i++) {
            this.header += nodes.getNode(i).getName() + "\t";


        }
        


        return this.header;

    }
    
    
}
