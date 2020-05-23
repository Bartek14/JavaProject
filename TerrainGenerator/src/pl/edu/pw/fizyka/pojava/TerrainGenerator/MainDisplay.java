package pl.edu.pw.fizyka.pojava.TerrainGenerator;



import java.awt.BorderLayout;


import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class MainDisplay extends JFrame {
	
	final public static int HEIGHT = 700;
	final public static int WIDTH = 1000;
	
	   public static void main( String[] args ) {

		 //getting the capabilities object of GL2 profile
		      final GLProfile profile = GLProfile.get(GLProfile.GL2);
		      GLCapabilities capabilities = new GLCapabilities(profile);
		      
		      // The canvas 
		      final GLCanvas glcanvas = new GLCanvas(capabilities);
		     

		      ConfigPanel conf = new ConfigPanel();
		      
//		      Params params = new Params(Long.parseLong(conf.getSetSeedTextField().getText()), Float.parseFloat(conf.getSetRoughnessTextField().getText()),
//		    		  Float.parseFloat(conf.getSetMaxHeightTextField().getText()),3, Float.parseFloat(conf.getSetRelativnessTextField().getText()));
//		       //creating frame
		      final JFrame frame = new JFrame ("mesh");
		      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		      frame.setLayout(new BorderLayout());
		      frame.setJMenuBar(conf.menuBar);	
		      //adding canvas to frame
		      frame.getContentPane().add(glcanvas);
		   
		      frame.setSize(WIDTH,HEIGHT);
		 
		      
		      frame.add(glcanvas, BorderLayout.CENTER);
		      frame.add(conf,BorderLayout.EAST);
		      frame.setVisible(true);
		      while(conf.getSeedTextField().getText().isEmpty()) {
		    	  System.out.println(conf.getSeedTextField().getText());
		      }
		      Params params = new Params(Long.parseLong(conf.getSeedTextField().getText()),0.3f,
		    		  170f,3, 4f);
		      
		      MeshPanel mesh = new MeshPanel(params);
		     
		      glcanvas.addGLEventListener(mesh);
		
		      
		     
		      
		      final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true); 
		         animator.start();
		   }
		   

}