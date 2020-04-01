package displayWindow;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import planeDrawer.Plane;

public class MainDisplay extends JFrame{

		  
    JPanel ButonPanel;
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
    JMenuItem SaveMenuItem;
    JMenuItem OpenMenuItem;
    JMenuItem NewMenuItem;
    JMenuItem InterpolationMenuItem;
    JMenuBar menuBar;
    
    JPanel terrainPanel;
    
    public MainDisplay() throws HeadlessException{   //konstruktor
     
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(new GridLayout(1,2));		//this oznacza obiekt tej klasy, ktory bedzie utworzony w main (i kazdy kolejny obiekt)
	this.setSize(MeshFrame.HEIGHT, MeshFrame.WIDTH/2);
	menuBar = new JMenuBar();
	
	mainMenu = new JMenu("Menu");       // menu1 jako zm. globalna

	        SaveMenuItem = new JMenuItem("Save");
	        OpenMenuItem = new JMenuItem("Open");
	        NewMenuItem = new JMenuItem("New");
	        InterpolationMenuItem = new JMenuItem("Interpolation");
	    
	        mainMenu.add(SaveMenuItem);
	        mainMenu.add(OpenMenuItem);
	        mainMenu.add(NewMenuItem);
	    	mainMenu.add(InterpolationMenuItem);
	        menuBar.add(mainMenu);
	        this.setJMenuBar(menuBar);	//dodaje do okna obiekt klasy JMenuBar	
	        
	        terrainPanel = new JPanel();
	        this.add(terrainPanel);
      
	        ButonPanel = new JPanel();		
      ButonPanel.setBackground(Color.white);		
      ButonPanel.setLayout(new GridLayout(15,1));	//w tym ukladzie wszystkie te przyciski beda rownej wielkosci, jesli Generuj ma byc wiekszy to trzeba to jakos zmienic
      setLenghtLabel = new JLabel ("Set lenght");
	    setLenghtTextField = new JTextField; 
      setLenghtTextField.addActionListener(new ActionListener() {	//to wyrzucamy?
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			terrainPanel.setBackground(new Color(123));
			
		}
	});
      setWidthLabel = new JLabel ("Set width");
	    setWidthTextField = new JTextField;
      setMaxHeightLabel = new JLabel ("Set maximum height");
      	    setMaxHeightTextField = new JTextField;
      setMinHeightLabel = new JLabel  ("Set minimum height");
	    setMinHeightTextField = new JTextField;
      setRoughnessLabel = new JLabel  ("Set roughness");
	    setRoughnessTextField = new JTextField;
      setSeedLabel = new JLabel ("Seed");
	    setSeedTextField = new JTextField;
      setRelativnessLabel = new JLabel  ("Height relativness of the neighbour points");
	    setRelativnessTextField = new JTextField;
	    generateButton = new JButton ("Generate");
	    

        ButonPanel.add(setLenghtLabel);
	ButonPanel.add(setLenghtTextField);
	ButonPanel.add(setWidthLabel);
	ButonPanel.add(setWidthTextField);
	ButonPanel.add(setMaxHeightLabel);
	ButonPanel.add(setMaxHeightTextField);
	ButonPanel.add(setMinHeightLabel);
	ButonPanel.add(setMinHeightTextField);
	ButonPanel.add(setRoughnessLabel);
	ButonPanel.add(setRoughnessTextField);
	ButonPanel.add(setSeedLabel);
	ButonPanel.add(setSeedTextField);
	ButonPanel.add(setRelativnessLabel);
	ButonPanel.add(setRelativnessTextField);
	ButonPanel.add(generateButton);
	    this.add(ButonPanel);
	    
	    
    }
	
	public static void main(String[] args) {
			
			MeshFrame frameDisplay = new MeshFrame();
			
			
	}
	

}



