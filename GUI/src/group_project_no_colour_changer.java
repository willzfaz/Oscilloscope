import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/** Test JRadioButton, JCheckBox and JComboBox */
@SuppressWarnings("serial")
public class group_project_no_colour_changer extends JFrame {
   // private variables of GUI components
   private JLabel labelForTest;
   private String imgGraphFilename = "graph.jpg";
   private String labelTest = "Graph Goes Here";
   private Icon iconGraph;
   private JRadioButton rightButtonLeft, rightButtonCenter, rightButtonRight, rightButtonTop, rightButtonMiddle, rightButtonBottom;
   private JCheckBox checkBoxText, checkBoxIcon;

 
   /** Constructor to setup the UI components */
   public group_project_no_colour_changer() {
      // Create a JLabel with text and icon for manipulation
      if (imgGraphFilename != null) {
         iconGraph = new ImageIcon(imgGraphFilename);
      } else {
         System.err.println("Couldn't find file: " + imgGraphFilename);
      }
      labelForTest = new JLabel(labelTest, iconGraph, SwingConstants.CENTER);
      labelForTest.setOpaque(true);
      labelForTest.setBackground(new Color(204, 238, 241));
      labelForTest.setForeground(Color.RED);
      labelForTest.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
 
      //ADD NEW HORIZONAL BUTTONS HERE
      // Create radio buttons for setting horizontal alignment of the JLabel
      rightButtonLeft = new JRadioButton("Left", true);// button selected by default
      rightButtonLeft.setMnemonic(KeyEvent.VK_L);
      rightButtonCenter = new JRadioButton("Center");  
      rightButtonCenter.setMnemonic(KeyEvent.VK_C);
      rightButtonRight = new JRadioButton("Right");
      rightButtonRight.setMnemonic(KeyEvent.VK_R);
      
      
      
      // Put the radio buttons into a ButtonGroup to ensure exclusive selection
      ButtonGroup buttonGroupH = new ButtonGroup();
      buttonGroupH.add(rightButtonLeft);
      buttonGroupH.add(rightButtonRight);
      buttonGroupH.add(rightButtonCenter);
      // Set up a JPanel to hold all radio buttons
      JPanel panelRightButtonH = new JPanel(new GridLayout(1, 0)); // single row
      panelRightButtonH.add(rightButtonLeft);
      panelRightButtonH.add(rightButtonCenter);
      panelRightButtonH.add(rightButtonRight);
      panelRightButtonH.setBorder(BorderFactory.createTitledBorder("Horizontal Alignment"));
 
      // A ItemListener for all Radio buttons
      ItemListener listener = new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               if (e.getSource() == rightButtonLeft) {
                  labelForTest.setHorizontalAlignment(SwingConstants.LEFT);
               } else if (e.getSource() == rightButtonCenter) {
                  labelForTest.setHorizontalAlignment(SwingConstants.CENTER);
               } else if (e.getSource() == rightButtonRight) {
                  labelForTest.setHorizontalAlignment(SwingConstants.RIGHT);
               }
            }
         }
      };
      rightButtonLeft.addItemListener(listener);
      rightButtonCenter.addItemListener(listener);
      rightButtonRight.addItemListener(listener);
 
      
      
      //ADD NEW VERTICAL BUTTONS HERE
      // Create radio buttons for setting vertical alignment of the JLabel
      rightButtonTop = new JRadioButton("Top", true);// selected button by default
      rightButtonTop.setMnemonic(KeyEvent.VK_T);
      rightButtonMiddle = new JRadioButton("Middle");  
      rightButtonMiddle.setMnemonic(KeyEvent.VK_M);
      rightButtonBottom = new JRadioButton("Bottom");
      rightButtonBottom.setMnemonic(KeyEvent.VK_B);
      
      // Put the radio buttons into a ButtonGroup to ensure exclusive selection
      ButtonGroup btnGroupV = new ButtonGroup();
      btnGroupV.add(rightButtonTop);
      btnGroupV.add(rightButtonMiddle);
      btnGroupV.add(rightButtonBottom);
      
      // Set up a JPanel to hold all radio buttons
      JPanel panelRightButtonV = new JPanel(new GridLayout(1, 0)); // single row
      panelRightButtonV.add(rightButtonTop);
      panelRightButtonV.add(rightButtonMiddle);
      panelRightButtonV.add(rightButtonBottom);
      panelRightButtonV.setBorder(BorderFactory.createTitledBorder("Vertical Alignment"));
 
      // Radio buttons also fire ActionEvent
      rightButtonTop.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            labelForTest.setVerticalAlignment(SwingConstants.TOP);
         }
      });
      rightButtonMiddle.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            labelForTest.setVerticalAlignment(SwingConstants.CENTER);
         }
      });
      rightButtonBottom.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            labelForTest.setVerticalAlignment(SwingConstants.BOTTOM);
         }
      });
 
      // Create check boxes for selecting text, icon, or both, or none
      checkBoxText = new JCheckBox("Text", true);  // selected
      checkBoxText.setMnemonic(KeyEvent.VK_T);
      checkBoxIcon = new JCheckBox("Icon", true);  // selected
      checkBoxIcon.setMnemonic(KeyEvent.VK_I);
      checkBoxIcon.setSelected(true);
      
      
      // Set up a JPanel to hold all check boxes
      JPanel panelGraphBox = new JPanel(new GridLayout(0, 1)); // single column
      panelGraphBox.add(checkBoxText);
      panelGraphBox.add(checkBoxIcon);
      
      
      // Check boxes fire ItemEvent. Use an anonymous inner class as ItemListener
      checkBoxText.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            // Need to handle both SELECTED and DESELECTED
            if (e.getStateChange() == ItemEvent.SELECTED) {
               labelForTest.setText(labelTest);
            } else {
               labelForTest.setText("");
            }
         }
      });
      checkBoxIcon.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            // Need to handle both SELECTED and DESELECTED
            if (e.getStateChange() == ItemEvent.SELECTED) {
               labelForTest.setIcon(iconGraph);
            } else {
               labelForTest.setIcon(null);
            }
         }
      });
 


      // Set up the content-pane with BorderLayout and adds the panels
      Container cp = this.getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(labelForTest, BorderLayout.CENTER);
      cp.add(panelRightButtonH, BorderLayout.NORTH);
      cp.add(panelRightButtonV, BorderLayout.SOUTH);
      cp.add(panelGraphBox, BorderLayout.WEST);

 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Graph GUI");
      setSize(400, 300);  // or pack() the components
      setLocationRelativeTo(null);
      setVisible(true);
   }
 

   public static void main(String[] args) {

      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new group_project_no_colour_changer();  
         }
      });
   }
}