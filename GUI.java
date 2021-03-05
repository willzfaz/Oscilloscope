package front;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Scanner;
import java.util.*; 
public class GUI extends JPanel{
	ArrayList<Float> coordinates = new ArrayList<Float>();
	static boolean running = true;
    int yMar=250;
    int xMar = 100;
    protected void paintComponent(Graphics g){
    	Scanner sc= new Scanner(System.in);    //System.in is a standard input stream   
		float value= sc.nextInt(); 
		coordinates.add(-value);
		if (coordinates.size()>10) {
			coordinates.remove(0);
		}
		System.out.println(coordinates);
        super.paintComponent(g);
        Graphics2D g1=(Graphics2D)g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int width=getWidth();
        int height=getHeight();
        g1.draw(new Line2D.Double(xMar,yMar,xMar,height-yMar));
        double x=(double)(width-2*xMar)/(coordinates.size()-1);
        double scale=(double)(height-2*yMar)/((Math.abs(largest(getMax(), getMin()))));
        g1.setPaint(Color.BLUE);
        System.out.print(coordinates.size()+ "\n");  
        System.out.print(coordinates+"\n");  
        for(int i=0;i<coordinates.size();i++){
            double x1=xMar+i*x;
            double y1 = 0;
            y1=0.5*height-0.5*scale*coordinates.get(i);
            if (i==coordinates.size()-1) {
            	g1.fill(new Ellipse2D.Double(x1-2,y1-2,4,4));
            }
            else {
            	double x2=xMar+(i+1)*x;
            	double y2=0.5*height-0.5*scale*coordinates.get(i+1);
            	g1.draw(new Line2D.Double(x1, y1, x2, y2));
            }
        }
        
        
        
    }
    private double getMax(){
        double max=-Integer.MAX_VALUE;
        for(int i=0;i<coordinates.size();i++){
            if(coordinates.get(i)>max)
                max=coordinates.get(i);
           
        }return max;
    }  
    
    private double getMin() {
    	double min= 0;
    	for(int i=0; i<coordinates.size();i++) {
    		if(coordinates.get(i)<min)
    			min=coordinates.get(i);
    	}return min;
    }
    public void listen() {
    	Scanner sc= new Scanner(System.in);    //System.in is a standard input stream   
		float value= sc.nextInt(); 
		coordinates.add(value);
		System.out.println(coordinates);
    }
    public static void main(String args[]){
    	boolean done = false;
    	System.out.print("a"); 
        JFrame frame =new JFrame();
        System.out.print("b"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.print("c"); 
        frame.add(new GUI());
        System.out.print("d"); 
        frame.setSize(400,400);
        System.out.print("e"); 
        frame.setLocation(200,200);
        System.out.print("f"); 
        frame.setVisible(true);
        System.out.print("g"); 
        while(!done) {
        	frame.invalidate();
        	frame.validate();
        	frame.repaint();
        }
        System.out.print("h"); 
    }
    public double largest(double x,double y) {
    	if(x*x>y*y) {
    		return x;
    	}
    	else {
    		return y;
    	}
    }
}