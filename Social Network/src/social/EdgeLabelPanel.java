package social;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.*;
import edu.uci.ics.jung.visualization.renderers.EdgeLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.visualization.renderers.VertexLabelRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.apache.commons.collections15.Transformer;

public class EdgeLabelPanel extends JPanel {
	


        public void vvRepaint(){vv.repaint();}
	/**
		 * 
		 */
		private static final long serialVersionUID = -6077157664507049647L;

		/**
	     * the graph
	     */
	    Graph<MyNode,MyEdge> graph;

	    /**
	     * the visual component and renderer for the graph
	     */
	    VisualizationViewer<MyNode,MyEdge> vv;
	    
	    /**
	     */
	    VertexLabelRenderer vertexLabelRenderer;
	    EdgeLabelRenderer edgeLabelRenderer;
	    
	    ScalingControl scaler = new CrossoverScalingControl();
	    
	    /**
	     * create an instance of a simple graph with controls to
	     * demo the label positioning features
	     * 
	     */
	    
	    
	    /**
	     * create an instance of a simple graph with controls to
	     * demo the label positioning features
	     * 
	     */
	    @SuppressWarnings("serial")
		public EdgeLabelPanel(MyNodes un,MyEdges con, DirectedSparseMultigraph dsmg) {
	        
	        // create a simple graph for the demo
                
	        graph = new SparseMultigraph<MyNode,MyEdge>();
//	        int x=un.getSize();
//                int yes = 0; 
//                MyNodes in = null; 
//                int n = 0 ;
//                Collection vertices = dsmg.getVertices();
//                for(Object v : vertices){
//                 MyNode mn = (MyNode)v;
//                 
//                }
//	       
//               for(int i = 0; i < x; i++){
//	       if(dsmg.containsVertex(un.getNode(i))){
//                   //Integer num;
//                   //num = un.getNode(i).getNumber();
//                    MyNode a = new MyNode(un.getNode(i).getName(), new Integer(i),'r');
//                    in.setNode(i, a);
//                    n = n+1; 
//                   }
//               }
               
               //int n = in.getSize();
                int n = un.getSize(); 
                
	        Integer[] v = createVertices(n); 
	        // add some sample data (graph manipulated via JGraphT)
	        for(int i=0;i<n;i++)
	        	for(int j=0;j<n;j++)
	        	{
                            if((i!=j) && (con.getEdge(i, j).getStrength() > 0.0))
                            graph.addEdge(con.getEdge(i,j),un.getNode(i),un.getNode(j),EdgeType.DIRECTED);
        	  	}

	    
	  
	        Layout<MyNode,MyEdge> layout = new CircleLayout<MyNode,MyEdge>(graph);
	        vv =  new VisualizationViewer<MyNode,MyEdge>(layout, new Dimension(1400,1000));
	        vv.setBackground(Color.white);

	        vertexLabelRenderer = vv.getRenderContext().getVertexLabelRenderer();
	        edgeLabelRenderer = vv.getRenderContext().getEdgeLabelRenderer();
	        
	        Transformer<MyEdge,String> edgeStringer = new Transformer<MyEdge,String>(){
	            public String transform(MyEdge e) {
	            	String s = e.getStrength().toString();
	            	if(s.length()>5)s=s.substring(0,6);
	                return s;//e.substring(k+1);
	            }
	        };
                
                 Transformer<MyNode,String> nodeStringer = new Transformer<MyNode,String>(){
	            public String transform(MyNode e) {
	            	String s = e.getName().toString();
	            	if(s.length()>5)s=s.substring(0,6);
	                return s;//e.substring(k+1);
	            }
	        };
                
                
                
                Transformer<MyNode,Paint> vertexPaint = new Transformer<MyNode,Paint>() {
            public Paint transform(MyNode s) {
//                if(s.maxAtrributeChar()=='C')
//                return Color.GREEN;
//                else  if(s.maxAtrributeChar()=='A')
//                return Color.YELLOW;
//                 else  if(s.maxAtrributeChar()=='P')
//                return Color.ORANGE;
//                 else  if(s.maxAtrributeChar()=='U')
//                return Color.RED;
//                return Color.PINK;
                return Color.RED; 
                
            }
        };  
        // Set up a new stroke Transformer for the edges
        float dash[] = {10.0f};
        final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
             BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        Transformer<MyEdge, Stroke> edgeStrokeTransformer = 
              new Transformer<MyEdge, Stroke>() {
            public Stroke transform(MyEdge we) {
                return new BasicStroke((float)(1.0*we.getStrength()));
               // return edgeStroke;
            }
        };
        
         Transformer<MyEdge, Paint> edgePaintTransformer = 
              new Transformer<MyEdge, Paint>() {
            public Paint transform(MyEdge we) {
                float f=new Float(we.getStrength());
                //return Color.YELLOW;
                return new Color(0,(int)(20*f),(int)(20+f));
               // return edgeStroke;
            }
        };
        vv.getRenderContext().setEdgeDrawPaintTransformer(edgePaintTransformer);
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
        vv.getRenderContext().setVertexLabelTransformer(nodeStringer);
        vv.getRenderContext().setEdgeLabelTransformer(edgeStringer);
       // vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
	        vv.getRenderContext().setEdgeLabelTransformer(edgeStringer);
	        //vv.getRenderContext().setEdgeDrawPaintTransformer(new PickableEdgePaintTransformer<MyEdge>(vv.getPickedEdgeState(), Color.black, Color.cyan));
	       // vv.getRenderContext().setVertexFillPaintTransformer(new PickableVertexPaintTransformer<MyNode>(vv.getPickedVertexState(), Color.red, Color.yellow));
	        // add my listener for ToolTips
	        vv.setVertexToolTipTransformer(new ToStringLabeller<MyNode>());
	        
	        // create a frome to hold the graph
	        final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
	        this.add(panel);
	        
	        final DefaultModalGraphMouse<Integer,MyEdge> graphMouse = new DefaultModalGraphMouse<Integer,MyEdge>();
	        vv.setGraphMouse(graphMouse);
	        
	        JButton plus = new JButton("+");
	        plus.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                scaler.scale(vv, 1.1f, vv.getCenter());
	            }
	        });
	        JButton minus = new JButton("-");
	        minus.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                scaler.scale(vv, 1/1.1f, vv.getCenter());
	            }
	        });
	        
	        ButtonGroup radio = new ButtonGroup();
	        JRadioButton lineButton = new JRadioButton("Line");
	        lineButton.addItemListener(new ItemListener(){
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED) {
	                    vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<MyNode,MyEdge>());
	                    vv.repaint();
	                }
	            }
	        });
	        
	        JRadioButton quadButton = new JRadioButton("QuadCurve");
	        quadButton.addItemListener(new ItemListener(){
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED) {
	                    vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.QuadCurve<MyNode,MyEdge>());
	                    vv.repaint();
	                }
	            }
	        });
	        
	        JRadioButton cubicButton = new JRadioButton("CubicCurve");
	        cubicButton.addItemListener(new ItemListener(){
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED) {
	                    vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.CubicCurve<MyNode,MyEdge>());
	                    vv.repaint();
	                }
	            }
	        });
	        radio.add(lineButton);
	        radio.add(quadButton);
	        radio.add(cubicButton);

	        graphMouse.setMode(ModalGraphMouse.Mode.TRANSFORMING);
	        
	        JCheckBox rotate = new JCheckBox("<html><center>EdgeType<p>Parallel</center></html>");
	        rotate.addItemListener(new ItemListener(){
	            public void itemStateChanged(ItemEvent e) {
	                AbstractButton b = (AbstractButton)e.getSource();
	                edgeLabelRenderer.setRotateEdgeLabels(b.isSelected());
	                vv.repaint();
	            }
	        });
	        rotate.setSelected(true);
	        MutableDirectionalEdgeValue mv = new MutableDirectionalEdgeValue(.5, .7);
	       // vv.getRenderContext().setEdgeLabelClosenessTransformer(mv);
	        JSlider directedSlider = new JSlider(mv.getDirectedModel()) {
	            public Dimension getPreferredSize() {
	                Dimension d = super.getPreferredSize();
	                d.width /= 2;
	                return d;
	            }
	        };
	        JSlider undirectedSlider = new JSlider(mv.getUndirectedModel()) {
	            public Dimension getPreferredSize() {
	                Dimension d = super.getPreferredSize();
	                d.width /= 2;
	                return d;
	            }
	        };
	        
	        JSlider edgeOffsetSlider = new JSlider(0,50) {
	            public Dimension getPreferredSize() {
	                Dimension d = super.getPreferredSize();
	                d.width /= 2;
	                return d;
	            }
	        };
	        edgeOffsetSlider.addChangeListener(new ChangeListener() {

	            public void stateChanged(ChangeEvent e) {
	                JSlider s = (JSlider)e.getSource();
	                AbstractEdgeShapeTransformer<MyNode,MyEdge> aesf = 
	                    (AbstractEdgeShapeTransformer<MyNode,MyEdge>)vv.getRenderContext().getEdgeShapeTransformer();
	                aesf.setControlOffsetIncrement(s.getValue());
	                vv.repaint();
	            }
	        	
	        });
	        
	        Box controls = Box.createHorizontalBox();

	        JPanel zoomPanel = new JPanel(new GridLayout(0,1));
	        zoomPanel.setBorder(BorderFactory.createTitledBorder("Scale"));
	        zoomPanel.add(plus);
	        zoomPanel.add(minus);

	        JPanel edgePanel = new JPanel(new GridLayout(0,1));
	        edgePanel.setBorder(BorderFactory.createTitledBorder("EdgeType Type"));
	        edgePanel.add(lineButton);
	        edgePanel.add(quadButton);
	        edgePanel.add(cubicButton);

	        JPanel rotatePanel = new JPanel();
	        rotatePanel.setBorder(BorderFactory.createTitledBorder("Alignment"));
	        rotatePanel.add(rotate);

	        JPanel labelPanel = new JPanel(new BorderLayout());
	        JPanel sliderPanel = new JPanel(new GridLayout(3,1));
	        JPanel sliderLabelPanel = new JPanel(new GridLayout(3,1));
	        JPanel offsetPanel = new JPanel(new BorderLayout());
	        offsetPanel.setBorder(BorderFactory.createTitledBorder("Offset"));
	        sliderPanel.add(directedSlider);
	        sliderPanel.add(undirectedSlider);
	        sliderPanel.add(edgeOffsetSlider);
	        sliderLabelPanel.add(new JLabel("Directed", JLabel.RIGHT));
	        sliderLabelPanel.add(new JLabel("Undirected", JLabel.RIGHT));
	        sliderLabelPanel.add(new JLabel("Edges", JLabel.RIGHT));
	        offsetPanel.add(sliderLabelPanel, BorderLayout.WEST);
	        offsetPanel.add(sliderPanel);
	        labelPanel.add(offsetPanel);
	        labelPanel.add(rotatePanel, BorderLayout.WEST);
	        
	        JPanel modePanel = new JPanel(new GridLayout(2,1));
	        modePanel.setBorder(BorderFactory.createTitledBorder("Mouse Mode"));
	        modePanel.add(graphMouse.getModeComboBox());

	        controls.add(zoomPanel);
	        controls.add(edgePanel);
	        controls.add(labelPanel);
	        controls.add(modePanel);
	        this.add(controls, BorderLayout.SOUTH);
	        quadButton.setSelected(true);
	    }
	    
	    /**
	     * subclassed to hold two BoundedRangeModel instances that
	     * are used by JSliders to move the edge label positions
	     * @author Tom Nelson
	     *
	     *
	     */
	    class MutableDirectionalEdgeValue extends ConstantDirectionalEdgeValueTransformer<Integer,MyEdge> {
	        BoundedRangeModel undirectedModel = new DefaultBoundedRangeModel(5,0,0,10);
	        BoundedRangeModel directedModel = new DefaultBoundedRangeModel(7,0,0,10);
	        
	        public MutableDirectionalEdgeValue(double undirected, double directed) {
	            super(undirected, directed);
	            undirectedModel.setValue((int)(undirected*10));
	            directedModel.setValue((int)(directed*10));
	            
	            undirectedModel.addChangeListener(new ChangeListener(){
	                public void stateChanged(ChangeEvent e) {
	                    setUndirectedValue(new Double(undirectedModel.getValue()/10f));
	                    vv.repaint();
	                }
	            });
	            directedModel.addChangeListener(new ChangeListener(){
	                public void stateChanged(ChangeEvent e) {
	                    setDirectedValue(new Double(directedModel.getValue()/10f));
	                    vv.repaint();
	                }
	            });
	        }
	        /**
	         * @return Returns the directedModel.
	         */
	        public BoundedRangeModel getDirectedModel() {
	            return directedModel;
	        }

	        /**
	         * @return Returns the undirectedModel.
	         */
	        public BoundedRangeModel getUndirectedModel() {
	            return undirectedModel;
	        }
	    }
	    
	    /**
	     * create some vertices
	     * @param count how many to create
	     * @return the Vertices in an array
	     */
	    private Integer[] createVertices(int count) {
	        Integer[] v = new Integer[count];
	        for (int i = 0; i < count; i++) {
	            v[i] = new Integer(i);
	         //   graph.addVertex(v[i]);
	        }
	        return v;
	    } 

	  
}