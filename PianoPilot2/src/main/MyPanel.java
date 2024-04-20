package src.main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;

import src.bezel.Bezel;
import src.piano.MyPiano;

public class MyPanel extends JPanel implements Runnable{
	
	Thread appThread = new Thread();
	
	MyPiano myPiano = new MyPiano();
	Bezel b = new Bezel();

	MouseHandler mh = new MouseHandler();
	
	
	int FPS = 60;
	
	public static int screenWidth = 1920;
	public static int screenHeight = 1080;
	
	public MyPanel() {
		setPreferredSize(new Dimension(screenWidth,screenHeight));
		setFocusable(true);
		add(myPiano);
		addMouseListener(mh);
		

	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
	//App loop
	public void startAppThread() {
		appThread = new Thread(); // this is how you instantiate a thread
		appThread.start(); // automatically calls the run method
	}
	
	public void run() {// This will contain the main loop which will be the core of its performance
		//Here we are using the sleep method to achieve 60 FPS
        double drawInterval = 1000000000/FPS;// This is the total time between each frame 
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        	
        	while(appThread != null) {
        		//1,000,000,000 nanoseconds is equal to 1 second
        		//long currentTime = System.nanoTime();//returns the current value of the running java virtual machines high-resolution time source, in nanoseconds
        		
        		
        		update();// updates information 
        		repaint();// Draws the screen with the updated information
        		
        		try {
        			double remainingTime = nextDrawTime - System.nanoTime();
        			
        			if(remainingTime < 0) {
        				remainingTime = 0;
        			}
        			Thread.sleep((long)remainingTime/1000000);
        			nextDrawTime += drawInterval;
        		}
        		catch(InterruptedException e) {
        			e.printStackTrace();
        		}
        	}
	}
	
	
	public void update() {
		
	}
	
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        myPiano.draw(g2);
        b.draw(g2);
        
        g2.dispose();//This disposes of this graphics context and release any system resources that it is using.
    }


}
