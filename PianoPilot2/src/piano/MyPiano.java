package src.piano;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import src.main.MyPanel;

public class MyPiano extends JPanel{
	public final int totalKeys = 88; //total keys for the entire piano
	public final int totalOctaves = 7; // total number of octaves in the piano
	
	int octaveOnScreen1 = 1; // the first octave on screen
	int octaveOnScreen2 = 2; //the second octave on screen
	int whiteKeysScreen = 17; // number of white keys on screen
	int blackKeysScreen = 10; // number of black keys on screen
	

	
	public int pianoWidth = MyPanel.screenWidth; // the piano is the full width of the screen
	public int pianoHeight = (MyPanel.screenHeight * 4)/5; // the piano height is 4/5ths of the screen
	
	KeyHandler kh = new KeyHandler();
	String notes[] = {"C", "D", "E", "F", "G", "A", "B"}; // labels for white notes 
    String sharpNotes[] = {"C#", "D#", "F#", "G#", "A#"}; // labels for black notes 
	PlayKey pk = new PlayKey();

	
	public MyPiano(){
		setFocusable(true);
		addKeyListener(kh);
		
	}
	
	
	public void draw (Graphics2D g2) {
		int blackX = (MyWhiteKey.width * 2)/3;// the starting position of the black key x cordinate in reference to drawing the rectangle, it must be at the two thirds of the way of the white key
		int blackY = (MyPanel.screenHeight)/5; // the starting position of the black key y cordinate in reference to drawing the rectangle it must be the same as the white key
		int blackWidth = (MyWhiteKey.width * 2)/3; // 2/3 the width of white key
		int blackHeight = (MyWhiteKey.height * 2)/3;// 2/3 the height of white key


		for(int i = 0; i < whiteKeysScreen; i++) {
			int x1 = i * MyWhiteKey.width;
			int x2 = (i+1) * MyWhiteKey.width;
			int y1 = (MyPanel.screenHeight)/5;
			int y2 = MyPanel.screenHeight;

			g2.setColor(Color.BLACK);
			
			g2.drawLine(x1, y1, x2, y1);//top horizontal
			g2.drawLine(x1, y2, x2, y2);//bottom horizontal
			g2.drawLine(x1, y1, x1, y2);//left vertical
			g2.drawLine(x2, y1, x2, y2);//right vertical
			
		}

		for(int i = 0; i < blackKeysScreen; i++){
			
			//g2.setColor(Color.BLACK);
			if(i == 0 || i == 1 || i == 5 || i == 6){
				g2.fillRect(blackX, blackY, blackWidth, blackHeight);

				if(i == 1 || i == 6){
					blackX += MyWhiteKey.width * 2;
				}
				else if(i == 0 || i == 5){
					blackX += MyWhiteKey.width;
				}
			}
			else if(i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9){
				g2.fillRect(blackX, blackY, blackWidth, blackHeight);

				if(i == 4 || i == 9){
					blackX += MyWhiteKey.width * 2;
				}
				else{
					blackX += MyWhiteKey.width;
				}
			}
		}
	}
	
	
	
	class KeyHandler implements KeyListener{
	        
	        @Override
	        public void keyPressed(KeyEvent e) {
	            int key = e.getKeyCode(); //registers the key typed
	            //white keys
	            if(key == KeyEvent.VK_A){
	            	
	            	try {
						pk.playSound("key09.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_S){
	            	try {
						pk.playSound("key10.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            
	            	
	            }
	            if(key == KeyEvent.VK_D){
	            	try {
						pk.playSound("key11.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_F){
	            	try {
						pk.playSound("key12.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_G){
	            	try {
						pk.playSound("key13.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_J){
	            	try {
						pk.playSound("key14.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_K){
	            	try {
						pk.playSound("key15.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	
	            //black keys
	            if(key == KeyEvent.VK_W){
	            	try {
						pk.playSound("key17.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_E){
	            	try {
						pk.playSound("key18.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_T){
	            	try {
						pk.playSound("key20.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_Y){
	            	try {
						pk.playSound("key21.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	            if(key == KeyEvent.VK_U){
	            	try {
						pk.playSound("key22.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
	            }
	        
	        
	
	            
	        }
	

	
	        @Override
	        public void keyTyped(KeyEvent arg0){
	
	        }



			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
	    }
	
	
}
