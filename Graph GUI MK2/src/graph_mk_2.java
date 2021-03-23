import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class graph_mk_2 {

	private JLabel amplitude, frequency, averaging, extra;
	private final int WINDOW_X_SIZE = 1000;
	private final int WINDOW_Y_SIZE = 800;
	private JRadioButton topButtonright, topButtonRightCenter, topButtonLeftCenter, topButtonLeft, topButtonDeadCenter;
	private JLabel amplitudeVal,frequencyVal, averagingVal, extraVal ;
	
	public graph_mk_2() {
		JFrame frame = new JFrame();
		frame.setTitle("Graph GUI");
		frame.setSize(WINDOW_X_SIZE, WINDOW_Y_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		ImageIcon graph = new ImageIcon("graph.jpg");
		JLabel graphLabel = new JLabel(graph);
		frame.add(graphLabel);
		frame.revalidate();
		
		topButtonLeft = new JRadioButton("show frequency", true);
		topButtonLeftCenter = new JRadioButton("show amplitude", true); 
		topButtonDeadCenter = new JRadioButton("toggle Maths", true); 
		topButtonRightCenter = new JRadioButton("averaging", true);
		topButtonright = new JRadioButton("extra functions here", true);
		amplitude = new JLabel("amplitude:-  ");
		frequency = new JLabel("frequency:-  ");
		averaging = new JLabel("averaging:-  ");
		extra = new JLabel("extra:-  ");
		amplitudeVal = new JLabel("Amplitude Value here ");
		frequencyVal = new JLabel("Frequency Value here ");
		averagingVal = new JLabel("Average Value here ");
		extraVal = new JLabel("Extra Value here ");
		JPanel frequencyDisplay = new JPanel(new GridLayout(0,2));
		JPanel amplitudeDisplay = new JPanel(new GridLayout(0,2));
		JPanel averageDisplay = new JPanel(new GridLayout(0,2));
		JPanel extraDisplay = new JPanel(new GridLayout(0,2));
		JPanel topButtons = new JPanel(new GridLayout(1,0));
		JPanel sideDisplay = new JPanel(new GridLayout(4,0));
		topButtons.add(topButtonLeft);
		topButtons.add(topButtonLeftCenter);
		topButtons.add(topButtonDeadCenter);
		topButtons.add(topButtonRightCenter);
		topButtons.add(topButtonright);
		topButtons.setBorder(BorderFactory.createTitledBorder("Sample Buttons"));
		frequencyDisplay.add(frequency);
		frequencyDisplay.add(frequencyVal);
		frequencyDisplay.setBorder(BorderFactory.createTitledBorder("Frequency"));
		amplitudeDisplay.add(amplitude);
		amplitudeDisplay.add(amplitudeVal);
		averageDisplay.setBorder(BorderFactory.createTitledBorder("Average"));
		averageDisplay.add(averaging);
		averageDisplay.add(averagingVal);
		amplitudeDisplay.setBorder(BorderFactory.createTitledBorder("Amplitude"));
		extraDisplay.add(extra);
		extraDisplay.add(extraVal);
		extraDisplay.setBorder(BorderFactory.createTitledBorder("Extra"));
		sideDisplay.add(frequencyDisplay);
		sideDisplay.add(amplitudeDisplay);
		sideDisplay.add(averageDisplay);
		sideDisplay.add(extraDisplay);
		sideDisplay.setBorder(BorderFactory.createTitledBorder("Maths"));
		
		
		ItemListener listener = new ItemListener() {
	         @Override
	         public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	               if (e.getSource() == topButtonright) {
	            	  extraDisplay.setVisible(true);
	               } else if (e.getSource() == topButtonRightCenter) {
	            	   averageDisplay.setVisible(true);
	               } else if (e.getSource() == topButtonLeftCenter) {
	            	   amplitudeDisplay.setVisible(true);
	               } else if (e.getSource() == topButtonLeft) {
	            	   frequencyDisplay.setVisible(true);
	               } else if (e.getSource() == topButtonDeadCenter) {
	            	   sideDisplay.setVisible(true);
	               }
	               frame.revalidate();
	            }
	            if (e.getStateChange() == ItemEvent.DESELECTED) {
		               if (e.getSource() == topButtonright) {
		            	  extraDisplay.setVisible(false);
		               } else if (e.getSource() == topButtonRightCenter) {
		            	   averageDisplay.setVisible(false);
		               } else if (e.getSource() == topButtonLeftCenter) {
		            	   amplitudeDisplay.setVisible(false);
		               } else if (e.getSource() == topButtonLeft) {
		            	   frequencyDisplay.setVisible(false);
		               } else if (e.getSource() == topButtonDeadCenter) {
		            	   sideDisplay.setVisible(false);
		               }
		               frame.revalidate();
		            }
	         }
	      };
	      
	      topButtonLeft.addItemListener(listener);
	      topButtonLeftCenter.addItemListener(listener);
	      topButtonDeadCenter .addItemListener(listener);
	      topButtonRightCenter.addItemListener(listener);
	      topButtonright.addItemListener(listener);
	      
	    frame.add(topButtons, BorderLayout.NORTH);
	    frame.add(sideDisplay, BorderLayout.WEST);

		frame.revalidate();

	}
	
	public static void main(String[] args) {
		System.out.println("test gui");
		new graph_mk_2();
	}
}
