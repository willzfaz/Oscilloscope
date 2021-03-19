import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
@SuppressWarnings("serial")
public class group_project_with_colour_changer extends JFrame {
   // private variables of GUI components
   private JLabel labelForTest;
   private String imgGraphFilename = "graph.jpg";
   private String labelTest = "Graph";
   private Icon iconGraph;
   private JRadioButton rightBoxLeft, rightBoxCentre, rightBoxRight, rightButtonTop, rightButtonMiddle, rightButtonBottom;
   private JCheckBox checkBoxText, checkBoxIcon;
   private JComboBox <String> graphColour;
 
   /** Constructor to setup the UI components */
   public group_project_with_colour_changer() {
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
 
      
      //BUTTON DECLARATIONS
      //ADD NEW HORIZONAL BUTTONS HERE
      // Create radio buttons for setting horizontal alignment of the JLabel
      rightBoxLeft = new JRadioButton("Left", true);// button selected by default
      rightBoxLeft.setMnemonic(KeyEvent.VK_L);
      rightBoxCentre = new JRadioButton("Center");  
      rightBoxCentre.setMnemonic(KeyEvent.VK_C);
      rightBoxRight = new JRadioButton("Right");
      rightBoxRight.setMnemonic(KeyEvent.VK_R);
      
      //ADD NEW VERTICAL BUTTONS HERE
      // Create radio buttons for setting vertical alignment of the JLabel
      rightButtonTop = new JRadioButton("Top", true);// selected button by default
      rightButtonTop.setMnemonic(KeyEvent.VK_T);
      rightButtonMiddle = new JRadioButton("Middle");  
      rightButtonMiddle.setMnemonic(KeyEvent.VK_M);
      rightButtonBottom = new JRadioButton("Bottom");
      rightButtonBottom.setMnemonic(KeyEvent.VK_B);
            
      // Put the radio buttons into a ButtonGroup to ensure exclusive selection
      ButtonGroup buttonGroupH = new ButtonGroup();
      buttonGroupH.add(rightBoxLeft);
      buttonGroupH.add(rightBoxRight);
      buttonGroupH.add(rightBoxCentre);
      // Set up a JPanel to hold all radio buttons
      JPanel panelRightButtonH = new JPanel(new GridLayout(1, 0)); // single row
      panelRightButtonH.add(rightBoxLeft);
      panelRightButtonH.add(rightBoxCentre);
      panelRightButtonH.add(rightBoxRight);
      panelRightButtonH.setBorder(BorderFactory.createTitledBorder("Horizontal Alignment"));
      
      // A ItemListener for all Radio buttons
      ItemListener listener = new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               if (e.getSource() == rightBoxLeft) {
                  labelForTest.setHorizontalAlignment(SwingConstants.LEFT);
               } else if (e.getSource() == rightBoxCentre) {
                  labelForTest.setHorizontalAlignment(SwingConstants.CENTER);
               } else if (e.getSource() == rightBoxRight) {
                  labelForTest.setHorizontalAlignment(SwingConstants.RIGHT);
               }
            }
         }
      };
      rightBoxLeft.addItemListener(listener);
      rightBoxCentre.addItemListener(listener);
      rightBoxRight.addItemListener(listener);
       
      // Radio buttons send an action event too
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
 

      String[] strColors = {"Red","Orange", "Blue", "Green",
                            "Cyan", "Magenta", "Yellow", "Black", "White"};
      final Color[] colors = {Color.RED, Color.ORANGE, Color.BLUE, Color.GREEN,
                        Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.BLACK, Color.WHITE};
      graphColour = new JComboBox<String>(strColors);
      graphColour.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               labelForTest.setForeground(colors[graphColour.getSelectedIndex()]);
            }
         }
      });

      JPanel panelGraph = new JPanel(new FlowLayout());
      panelGraph.add(graphColour);
 
      // Set up the content-pane with BorderLayout and adds the panels
      Container cp = this.getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(labelForTest, BorderLayout.CENTER);
      cp.add(panelRightButtonH, BorderLayout.NORTH);
      cp.add(panelGraphBox, BorderLayout.WEST);
      cp.add(panelGraph, BorderLayout.EAST);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Graph GUI");
      setSize(400, 300);  // or pack() the components
      setLocationRelativeTo(null);
      setVisible(true);
   }
 

   public static void main(String[] args) {

      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new group_project_with_colour_changer();  
         }
      });
   }
}