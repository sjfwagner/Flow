/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class MyNodes {

    MyNode[] nodes;
    public int n;
    

    public int getSize() {
        return n;
    }
    private String header;
    private String rows;

    public MyNodes(int n) {
        this.nodes = new MyNode[n];
        this.n = n;
    }

    // copy constructor
    public MyNodes(MyNodes nodeOriginal) {
        this.n = nodeOriginal.n;
        this.nodes = new MyNode[n];
        for (int i = 0; i < n; i++) {
            this.nodes[i] = new MyNode(nodeOriginal.nodes[i]);
        }

    }

    public void setNode(int i, MyNode a) {
        nodes[i] = a;
    }

    public MyNode getNode(int i) {
        return nodes[i];
    }

    @Override
    public String toString() {
        String S = "";
        for (int i = 0; i < n; i++) {
            S += this.nodes[i].toString() + "\n";
        }

        // System.out.println(S);
        return S;
    }

    public String WriteHeader() {
        this.header = "Number\tName\tPower\n";

//        for (int i = 0; i < n; i++) {
//            this.header += nodes[i].getName() + "\t";
//
//
//        }
        


        return this.header;

    }

    public String WriteNodes() {
        this.rows = "";

        for (int i = 0; i < n; i++) {
           
              
                {

                    this.rows += nodes[i].getNumber() + "\t" + nodes[i].getName() + "\t" + nodes[i].getPower() +"\n";



                }
                

        } 

        return this.rows;

    }

    
}