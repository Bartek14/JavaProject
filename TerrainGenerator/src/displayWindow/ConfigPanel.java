package displayWindow;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigPanel extends JPanel implements ActionListener {
	
	JTextField setLenghtTextField;
    JTextField setWidthTextField;
    JTextField setMaxHeightTextField;
    JTextField setMinHeightTextField;
    JTextField setRoughnessTextField;
    JTextField setSeedTextField;
    JTextField setRelativnessTextField;
    JButton generateButton;
    
	JLabel setLenghtLabel;
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
		
    	 menubar = new MenuBar();
	 mainMenu = new JMenu("Menu");
	    mainMenu.setActionCommand("MAINMENU");
   	    mainMenu.addActionListener(new ConfigurationListener());
	 saveMenuItem = new JMenuItem("Save");
	    saveMenuItem.setActionCommand("SAVE");
   	    saveMenuItem.addActionListener(new ConfigurationListener());
	 openMenuItem = new JMenuItem("Open");
	    openMenuItem.setActionCommand("OPEN");
   	    openMenuItem.addActionListener(new ConfigurationListener());
	 newMenuItem = new JMenuItem("New");
	    newMenuItem.setActionCommand("NEW");
   	    newMenuItem.addActionListener(new ConfigurationListener());
	    
	 interpolationMenu = new JMenu("Interpolation");
	    interpolationMenu.setActionCommand("INTERPOLATIONMENU");
   	    interpolationMenu.addActionListener(new ConfigurationListener());
	 interpolationMenuLinear = new JMenuItem("Linear");
	    interpolationMenuLinear.setActionCommand("LINEAR");
   	    interpolationMenulinear.addActionListener(new ConfigurationListener());
	 interpolationMenuTrigonometric = new JMenuItem("Trigonometric");
	    interpolationMenuTrigonometric.setActionCommand("TRIGONOMETRIC");
   	    interpolationMenuTrigonometric.addActionListener(new ConfigurationListener());
	    
	        mainMenu.add(SaveMenuItem);
	        mainMenu.add(OpenMenuItem);
	        mainMenu.add(NewMenuItem);

	    	InterpolationMenu.add(InterpolationMenuLinear);
	    	InterpolationMenu.add(InterpolationMenuTrigonometric);
	    	mainMenu.add(InterpolationMenu);

	        menuBar.add(mainMenu);
	        this.setJMenuBar(menuBar);	
	    
	    
	 this.setLayout(new GridLayout(15,1));	//w tym ukladzie wszystkie te przyciski beda rownej wielkosci, jesli Generuj ma byc wiekszy to trzeba to jakos zmienic
         setLenghtLabel = new JLabel ("Set lenght");
   	    setLenghtTextField = new JTextField(); 
   	    setLenghtTextField.setActionCommand("LENGHT");
   	    	setLenghtTextField.addActionListener(new ConfigurationListener());
         setWidthLabel = new JLabel ("Set width");
   	    setWidthTextField = new JTextField();
   	    setWidthTextField.setActionCommand("WIDTH");
   	    	setWidthTextField.addActionListener(new ConfigurationListener());
         setMaxHeightLabel = new JLabel ("Set maximum height");
         	    setMaxHeightTextField = new JTextField();
   	    setMaxHeightTextField.setActionCommand("MAX");
          		setMaxHeightTextField.addActionListener(new ConfigurationListener());
         setMinHeightLabel = new JLabel  ("Set minimum height");
   	    setMinHeightTextField = new JTextField();
   	    setMinHeightTextField.setActionCommand("MIN");
   	       setMinHeightTextField.addActionListener(new ConfigurationListener());
         setRoughnessLabel = new JLabel  ("Set roughness");
   	    setRoughnessTextField = new JTextField();
   	    setRoughnessTextField.setActionCommand("ROUGHNESS");
   	       setRoughnessTextField.addActionListener(new ConfigurationListener());
         setSeedLabel = new JLabel ("Seed");
   	    setSeedTextField = new JTextField();
   	    setSeedTextField.setActionCommand("SEED");
   	       setSeedTextField.addActionListener(new ConfigurationListener());
         setRelativnessLabel = new JLabel  ("Height relativeness of the neighbour points");
   	    setRelativnessTextField = new JTextField();
   	    setRelativnessTextField.setActionCommand("RELATION");
         		setRelativnessTextField.addActionListener(new ConfigurationListener());
   	    generateButton = new JButton ("Generate");
   	    generateButton.setActionCommand("GENERATE");
   	    generateButton.addActionListener(new ConfigurationListener());

           this.add(setLenghtLabel);
           this.add(setLenghtTextField);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
