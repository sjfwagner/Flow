/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author sophiewagner
 */
public class RegionComparison {
    private MyNetwork mn; 
    
    public RegionComparison(MyNetwork graph)
    {
        this.mn = graph; 
    }
    
    public Integer CompareRegion(int r1, int r2)
    {
        
        String s = "Region " + r1 + " to " + r2 + "\n"; 
        String p = "Region " + r1 + " to " + r2 + "\n"; 
        
        
        int x = 0; 
        
        int i = 0;
        
        
        while(i < mn.getN()){
            //System.out.println("test");
            if(mn.getNodes().getNode(i).getRegion() == r1)
            {
                s += "\n" + mn.getNodes().getNode(i).getName();
                int j = 0;
                while( j < mn.getN())
                {
                    if (mn.getNodes().getNode(j).getRegion() == r2 || (j == (mn.getN() -1))){
                        if(mn.getNodes().getNode(j).getRegion() == r2 && !(j == (mn.getN() -1)))  {
                             s+= "," + mn.getEdges().getEdge(i, j).getStrength() ;
                             x +=  mn.getEdges().getEdge(i, j).getStrength() ;
                        }
                        else if(mn.getNodes().getNode(j).getRegion() == r2 && (j == (mn.getN() -1))){ 
                            s+= "," + mn.getEdges().getEdge(i, j).getStrength() ;
                            x +=  mn.getEdges().getEdge(i, j).getStrength() ;
                            
                        }
                   
                    }
                    
                    j++;
   
                 }
                
            }
           
           //if (i == mn.getN()){ s += "\n";}
           i++; 
         }
        
        //System.out.println(s);
        //System.out.println(p);
        //System.out.println(x);
        return x; 
    }
    
    public Integer CompareSubRegion(int r1, int r2)
    {
        
        String s = "SubRegion " + r1 + " to " + r2 + "\n"; 
        String p = "SubRegion " + r1 + " to " + r2 + "\n"; 
        
        
        int x = 0; 
        
        int i = 0;
        
        
        while(i < mn.getN()){
            //System.out.println("test");
            if(mn.getNodes().getNode(i).getSubregion() == r1)
            {
                s += "\n" + mn.getNodes().getNode(i).getName();
                int j = 0;
                while( j < mn.getN())
                {
                    if (mn.getNodes().getNode(j).getSubregion() == r2 || (j == (mn.getN() -1))){
                        if(mn.getNodes().getNode(j).getSubregion() == r2 && !(j == (mn.getN() -1)))  {
                             s+= "," + mn.getEdges().getEdge(i, j).getStrength() ;
                             x +=  mn.getEdges().getEdge(i, j).getStrength() ;
                        }
                        else if(mn.getNodes().getNode(j).getSubregion() == r2 && (j == (mn.getN() -1))){ 
                            s+= "," + mn.getEdges().getEdge(i, j).getStrength() ;
                            x +=  mn.getEdges().getEdge(i, j).getStrength() ;
                            
                        }
                   
                    }
                    
                    j++;
   
                 }
                
            }
           
           //if (i == mn.getN()){ s += "\n";}
           i++; 
         }
        
       // System.out.println(s);
        //System.out.println(p);
        //System.out.println(x);
        return x; 
    }
    
    public void CompareAllRegions(int cap)
    {
        for(int i = 1; i <= cap; i++)
            for (int j = 1; j <=cap; j++)
            {
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                CompareRegion(i,j);
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                
            }
    
    }
    
    public void CompareAllSubRegions(int cap)
    {
        for(int i = 1; i <= cap; i++)
            for (int j = 1; j <=cap; j++)
            {
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                CompareSubRegion(i,j);
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                
            }
    
    }
    
    public void CompareAllRegionsPercent(double total)
    {
        System.out.println(" Region to Region | Percent");
        System.out.println("---------------------------------");
        double y = 0; 
        for(int i = 1; i <= 4; i++)
            for (int j = 1; j <=4; j++)
            {
                
                int x = CompareRegion(i,j);
                double percent = x / total;
                percent = percent * 100; 
                y += percent; 
                
                System.out.println("Region " + i + " to " + j + "     | " +  percent);
                
               
                
                
            }
        System.out.println();
        System.out.println("TOTAL : " + y);
    }
    
    public void CompareAllSubRegionsPercent(double total)
    {
        System.out.println(" SubRegion to SubRegion | Percent");
        System.out.println("---------------------------------------");
        double y = 0; 
        double r = 0; 
        double k1 = 0; 
         double k2 = 0; 
          double k3 = 0; 
           double k4 = 0; 
            double k5 = 0; 
             double k6 = 0; 
              double k7 = 0; 
               double k8 = 0; 
        for(int i = 1; i <= 8; i++)
            for (int j = 1; j <=8; j++)
            {
                
                int x = CompareSubRegion(i,j);
                double percent = x / total;
                percent = percent * 100; 
                y += percent; 
                
                System.out.println("Region " + i + " to " + j + "           | " +  percent);
                
                if (i == j) 
                    r += percent; 
                
                if(i != 1 && j == 1)
                    k1 += percent;
                else if(i != 2 && j == 2)
                    k2 += percent;
                else if(i != 3 && j == 3)
                    k3 += percent;
                else if(i != 4 && j == 4)
                    k4 += percent;
                else if(i != 5 && j == 5)
                    k5 += percent;
                else if(i != 6 && j == 6)
                    k6 += percent;
                else if(i != 7 && j == 7)
                    k7 += percent;
                else if(i != 8 && j == 8)
                    k8 += percent;
               
                
                
            }
        System.out.println("total into region 1:" + k1);
        System.out.println("total into region 2:" + k2);
        System.out.println("total into region 3:" + k3);
        System.out.println("total into region 4:" + k4);
        System.out.println("total into region 5:" + k5);
        System.out.println("total into region 6:" + k6);
        System.out.println("total into region 7:" + k7);
        System.out.println("total into region 8:" + k8);
        
        System.out.println();
        System.out.println("TOTAL : " + y);
        System.out.println("TOTAL Region into Itself: " + r);
    }
    
    
    public void CompareRegiontoNation(MyNode n, int r)
    {
    
        
        
    }
    
}
