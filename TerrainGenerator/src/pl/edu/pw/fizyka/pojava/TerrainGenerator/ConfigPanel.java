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
	
	JTextField setLengthTextField;
    JTextField setWidthTextField;
    JTextField setMaxHeightTextField;
    JTextField setMinHeightTextField;
    JTextField setRoughnessTextField;
    JTextField setSeedTextField;
    JTextField setRelativnessTextField;
    JButton generateButton;
    
	JLabel setLengthLabel;
	JLabel setWidthLabel;
	JLabel setMaxHeightLabel;
	JLabel setMinHeightLabel;
	JLabel setRoughnessLabel;
	JLabel setSeedLabel;
	JLabel setRelativnessLabel;
	
    JMenu mainMenu;	
    JMenuItem saveMenuItem;
    JMenuItem openMenuItem;
    JMenuItem newMenuItem;
	JMenu interpolationMenu;
	JMenuItem interpolationMenuLinear;
	JMenuItem interpolationMenuTrigonometric;
	JMenuBar menuBar;
	boolean isLinear;
    
    public ConfigPanel() {
		
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
         setLengthLabel = new JLabel ("Set length");
   	    setLengthTextField = new JTextField(); 
   	    setLengthTextField.setActionCommand("LENGHT");
   	    	setLengthTextField.addActionListener(new ConfigurationListener(this));
         setWidthLabel = new JLabel ("Set width");
   	    setWidthTextField = new JTextField();
   	    setWidthTextField.setActionCommand("WIDTH");
   	    	setWidthTextField.addActionListener(new ConfigurationListener(this));
         setMaxHeightLabel = new JLabel ("Set maximum height");
         	    setMaxHeightTextField = new JTextField();
   	    setMaxHeightTextField.setActionCommand("MAX");
          		setMaxHeightTextField.addActionListener(new ConfigurationListener(this));
         setMinHeightLabel = new JLabel  ("Set minimum height");
   	    setMinHeightTextField = new JTextField();
   	    setMinHeightTextField.setActionCommand("MIN");
   	       setMinHeightTextField.addActionListener(new ConfigurationListener(this));
         setRoughnessLabel = new JLabel  ("Set roughness");
   	    setRoughnessTextField = new JTextField();
   	    setRoughnessTextField.setActionCommand("ROUGHNESS");
   	       setRoughnessTextField.addActionListener(new ConfigurationListener(this));
         setSeedLabel = new JLabel ("Seed");
   	    setSeedTextField = new JTextField();
   	    setSeedTextField.setActionCommand("SEED");
   	       setSeedTextField.addActionListener(new ConfigurationListener(this));
         setRelativnessLabel = new JLabel  ("Height relativeness of the neighbour points");
   	    setRelativnessTextField = new JTextField();
   	    setRelativnessTextField.setActionCommand("RELATION");
         		setRelativnessTextField.addActionListener(new ConfigurationListener(this));
   	    generateButton = new JButton ("Generate");
   	    generateButton.setActionCommand("GENERATE");
   	    generateButton.addActionListener(new ConfigurationListener(this));

           this.add(setLengthLabel);
           this.add(setLengthTextField);
           this.add(setWidthLabel);
           this.add(setWidthTextField);
           this.add(setMaxHeightLabel);
           this.add(setMaxHeightTextField);
           this.add(setMinHeightLabel);
           this.add(setMinHeightTextField);
           this.add(setRoughnessLabel);
           this.add(setRoughnessTextField);
           this.add(setSeedLabel);
           this.add(setSeedTextField);
           this.add(setRelativnessLabel);
           this.add(setRelativnessTextField);
           this.add(generateButton);
    }
	public JTextField getSetLengthTextField() {
		return setLengthTextField;
	}
	public JTextField getSetWidthTextField() {
		return setWidthTextField;
	}
	public JTextField getSetMaxHeightTextField() {
		return setMaxHeightTextField;
	}
	public JTextField getSetMinHeightTextField() {
		return setMinHeightTextField;
	}
	public JTextField getSetRoughnessTextField() {
		return setRoughnessTextField;
	}
	public JTextField getSetSeedTextField() {
		return setSeedTextField;
	}
	public JTextField getSetRelativnessTextField() {
		return setRelativnessTextField;
	}
	
	public boolean isLinear() {
		return isLinear;
	}


}