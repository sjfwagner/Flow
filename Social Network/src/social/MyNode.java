package social;

import java.util.ArrayList;
import java.util.Random;

/*
 * Class to create a node object
 */

/**
 *
 * @author sophiewagner
 */
public class MyNode {
    private String name;
    private Integer number;
    private Double power;
    private Double betweenness;
    private Integer freq; 
    private Integer region; 
    private Integer subregion;
    private Double flow; 
    private Integer degree;
    private Double FlowDegree; 
    private Double Corruption; 
    private Double s; 
    private Double d; 
    private Integer leader; 
    private String section;
    private Integer age;
    private Integer gender;
    private Integer nationality;
    private Integer supremacy;
    private Integer populace;
    private Double t;

    public Double getT() {
        return t;
    }

    public void setT(Double t) {
        this.t = t;
    }

    // private Integer[] values;
    //    private ArrayList<Integer> values;
    //
    //    public ArrayList<Integer>  getValues() {
    //        return values;
    //    }
    //
    //    public void setValues(ArrayList<Integer>  values) {
    //        this.values = values;
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setNationality(Integer nationality) {
        this.nationality = nationality;
    }

    public void setSupremacy(Integer supremacy) {
        this.supremacy = supremacy;
    }

    public void setPopulace(Integer populace) {
        this.populace = populace;
    }
    //    
    //
    public Integer getAge() {
        return age;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getNationality() {
        return nationality;
    }

    public Integer getSupremacy() {
        return supremacy;
    }

    public Integer getPopulace() {
        return populace;
    }


    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getCorruption() {
        return Corruption;
    }

    public void setCorruption(Double Corruption) {
        this.Corruption = Corruption;
    }
    

    public Double getBreakscore() {
        return breakscore;
    }

    public void setBreakscore(Double breakscore) {
        this.breakscore = breakscore;
    }
    private Double breakscore; 

    public Integer getDegree() {
        return degree;
    }

    public Double getFlowDegree() {
        return FlowDegree;
    }

    public void setFlowDegree(Double FlowDegree) {
        this.FlowDegree = FlowDegree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getSubregion() {
        return subregion;
    }

    public void setSubregion(Integer subregion) {
        this.subregion = subregion;
    }
    

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer f) {
        this.freq = freq; 
    }
   
    
    
    public MyNode(MyNode nodeOriginal)
    {
        this.name = nodeOriginal.name; 
        this.number = nodeOriginal.number;
        this.power = nodeOriginal.power;
        this.freq = nodeOriginal.freq;
       
    }
    public MyNode(String name, Integer number)
    {
        this.name = name; 
        this.number = number;
        this.power = 0.0; 
        this.freq = 0; 
       
    }
    

    public MyNode(String name, Integer number,char type)
    {
        Random r = new Random(); 
        this.name = name; 
        this.number = number;
        this.freq = 0; 

        
        if(type == 'r')
        {
            this.power = r.nextDouble();
        }
        else {
        this.power = 0.0;    
        }
         
    }

  
    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getBetweenness() {
        return betweenness;
    }

    public void setBetweenness(Double betweenness) {
        this.betweenness = betweenness;
    }
    
    @Override
    public String toString() {
        return "Node{" + "name=" + name + ", number=" + number + ", power=" + power + '}';
    }

//    boolean isNeighborOf(MyNode input) {
//        
//      input.number;   
//        
//      return true;   
//    }
 
    
}
