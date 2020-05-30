package pl.edu.pw.fizyka.pojava.TerrainGenerator;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigPanel extends JPanel {
	
	JTextField lengthTextField;
    JTextField widthTextField;
    JTextField maxHeightTextField;
    JTextField minHeightTextField;
    JTextField roughnessTextField;
    JTextField seedTextField;
    JTextField relativnessTextField;
    JButton generateButton;
    
	JLabel lengthLabel;
	JLabel widthLabel;
	JLabel maxHeightLabel;
	JLabel minHeightLabel;
	JLabel roughnessLabel;
	JLabel seedLabel;
	JLabel relativnessLabel;
	
    JMenu mainMenu;	
    JMenuItem saveMenuItem;
    JMenuItem openMenuItem;
    JMenuItem newMenuItem;
	JMenu interpolationMenu;
	JMenuItem interpolationMenuLinear;
	JMenuItem interpolationMenuTrigonometric;
	JMenuBar menuBar;
	
	static Params param;
	boolean isLinear;
	static boolean generating;
    
    public ConfigPanel(Params p) {
		
    	//copy constructor
    	//ConfigPanel.param=new Params(p);
    	
    	 menuBar = new JMenuBar();
	 mainMenu = new JMenu("Menu");
	    mainMenu.setActionCommand("MAINMENU");
   	    mainMenu.addActionListener(new ConfigurationListener(this));
	 saveMenuItem = new JMenuItem("Save");
	    saveMenuItem.setActionCommand("SAVE");
   	    saveMenuItem.addActionListener(new ConfigurationListener(this));
	 openMenuItem = new JMenuItem("Open");
	    openMenuItem.setActionCommand("OPEN");
   	    openMenuItem.addActionListener(new ConfigurationListener(this));
	 newMenuItem = new JMenuItem("New");
	    newMenuItem.setActionCommand("NEW");
   	    newMenuItem.addActionListener(new ConfigurationListener(this));
	    
	 interpolationMenu = new JMenu("Interpolation");
	    interpolationMenu.setActionCommand("INTERPOLATIONMENU");
   	    interpolationMenu.addActionListener(new ConfigurationListener(this));
	 interpolationMenuLinear = new JMenuItem("Linear");
	    interpolationMenuLinear.setActionCommand("LINEAR");
   	    interpolationMenuLinear.addActionListener(new ConfigurationListener(this));
	 interpolationMenuTrigonometric = new JMenuItem("Trigonometric");
	    interpolationMenuTrigonometric.setActionCommand("TRIGONOMETRIC");
   	    interpolationMenuTrigonometric.addActionListener(new ConfigurationListener(this));
	    
	        mainMenu.add(saveMenuItem);
	        mainMenu.add(openMenuItem);
	        mainMenu.add(newMenuItem);

	    	interpolationMenu.add(interpolationMenuLinear);
	    	interpolationMenu.add(interpolationMenuTrigonometric);
	    	mainMenu.add(interpolationMenu);

	        menuBar.add(mainMenu);
	        //this.setJMenuBar(menuBar);	
	    
	    
	 this.setLayout(new GridLayout(15,1));	
         lengthLabel = new JLabel ("Set length");
   	    lengthTextField = new JTextField(); 
   	    lengthTextField.setText(Integer.toString(Params.getLength()));
   	    lengthTextField.setActionCommand("LENGHT");
   	    lengthTextField.addActionListener(new ConfigurationListener(this));
         widthLabel = new JLabel ("Set width");
   	    widthTextField = new JTextField();
   	    widthTextField.setText(Integer.toString(Params.getWidth()));
   	    widthTextField.setActionCommand("WIDTH");
   	    widthTextField.addActionListener(new ConfigurationListener(this));
         maxHeightLabel = new JLabel ("Set maximum height");
        maxHeightTextField = new JTextField();
        maxHeightTextField.setText(Float.toString(Params.getMaxHeight()));
        maxHeightTextField.setActionCommand("MAX");
        maxHeightTextField.addActionListener(new ConfigurationListener(this));
         minHeightLabel = new JLabel  ("Set minimum height");
   	    minHeightTextField = new JTextField();
   	    minHeightTextField.setText(Float.toString(Params.getMinHeight()));
   	    minHeightTextField.setActionCommand("MIN");
   	    minHeightTextField.addActionListener(new ConfigurationListener(this));
         roughnessLabel = new JLabel  ("Set roughness");
   	    roughnessTextField = new JTextField();
   	    roughnessTextField.setText(Float.toString(Params.getRoughness()));
   	    roughnessTextField.setActionCommand("ROUGHNESS");
   	    roughnessTextField.addActionListener(new ConfigurationListener(this));
         seedLabel = new JLabel ("Seed");
   	    seedTextField = new JTextField();
   	    seedTextField.setText(Long.toString(Params.getSeed()));
   	    seedTextField.setActionCommand("SEED");
   	    seedTextField.addActionListener(new ConfigurationListener(this));
         relativnessLabel = new JLabel  ("Height relativeness of the neighbour points");
   	    relativnessTextField = new JTextField();
   	    relativnessTextField.setText(Float.toString(Params.getRelativness()));
   	    relativnessTextField.setActionCommand("RELATION");
        relativnessTextField.addActionListener(new ConfigurationListener(this));
   	     generateButton = new JButton ("Generate");
   	    generateButton.setActionCommand("GENERATE");
   	    generateButton.addActionListener(new ConfigurationListener(this));

           this.add(lengthLabel);
           this.add(lengthTextField);
           this.add(widthLabel);
           this.add(widthTextField);
           this.add(maxHeightLabel);
           this.add(maxHeightTextField);
           this.add(minHeightLabel);
           this.add(minHeightTextField);
           this.add(roughnessLabel);
           this.add(roughnessTextField);
           this.add(seedLabel);
           this.add(seedTextField);
           this.add(relativnessLabel);
           this.add(relativnessTextField);
           this.add(generateButton);
           
           
    }
	public JTextField getLengthTextField() {
		return lengthTextField;
	}
	public JTextField getWidthTextField() {
		return widthTextField;
	}
	public JTextField getMaxHeightTextField() {
		return maxHeightTextField;
	}
	public JTextField getMinHeightTextField() {
		return minHeightTextField;
	}
	public JTextField getRoughnessTextField() {
		return roughnessTextField;
	}
	public JTextField getSeedTextField() {
		return seedTextField;
	}
	public JTextField getRelativnessTextField() {
		return relativnessTextField;
	}
	
	public boolean getIsLinear() {
		return isLinear;
	}
	public static void setGenerating(boolean g) {
		generating = g;
	}
	public static boolean getGenerating() {
		return generating;
	}


}