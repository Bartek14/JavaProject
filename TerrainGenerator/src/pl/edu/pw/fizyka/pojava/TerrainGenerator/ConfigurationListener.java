package pl.edu.pw.fizyka.pojava.TerrainGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JFileChooser;
public class ConfigurationListener implements ActionListener {

	ConfigPanel confPanel;
	//Params param;
	public ConfigurationListener(ConfigPanel configPanel) {
		// TODO Auto-generated constructor stub
		this.confPanel = configPanel;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String optionPicked = e.getActionCommand();

		switch (optionPicked) {

		case "GENERATE": {
			System.out.println("generate");
			ConfigPanel.setGenerating(true);
			
			 String lengthString = confPanel.lengthTextField().getText(); 
			  try {
			  Params.setLength(Math.abs(Integer.parseInt(lengthString)));
			  } 
			  catch (NumberFormatException ex) {
				  System.out.println("Nothing to do here with length");
			  }
			  
				String widthString = confPanel.widthTextField().getText();
				try
				{
					 Params.setWidth(Math.abs(Integer.parseInt(widthString)));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with width");
				}
			  
				String maxHeightString = confPanel.maxHeightTextField().getText();
				try
				{
					Params.setMaxHeight(Float.parseFloat(maxHeightString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with max");
				}
				
				
				String minHeightString = confPanel.minHeightTextField().getText();
				try
				{
					Params.setMinHeight(Float.parseFloat(minHeightString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with min");
				}
				
				String roughnessString = confPanel.roughnessTextField().getText();
				try
				{
					Params.setRoughness(Float.parseFloat(roughnessString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with roughness");
				}
				
				String seedString = confPanel.seedTextField().getText();
				try
				{
					Params.setSeed(Integer.parseInt(seedString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with seed");
				}
				
				String relativnessString = confPanel.relativnessTextField().getText();
				try
				{
					Params.setRelativness(Float.parseFloat(relativnessString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with relativness");
				}
				
			break;
			
			

		}
		case "LINEAR": {
			System.out.println("Nothing to do here with linear");
			Params.setIsLinear(true);
		break;	
		}
		case "TRIGONOMETRIC": {
			System.out.println("Nothing to do here with trigonometric");
			Params.setIsLinear(false);
		break;	
		}
		case "SAVE": {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Choose file");
			int result = chooser.showDialog(null, "Choose");
			if(JFileChooser.APPROVE_OPTION == result) {
				System.out.println("File chosen: " + chooser.getSelectedFile().toPath());
				FileWriter writer = null;
				BufferedWriter bufferedWriter = null;
				String lengthString = confPanel.lengthTextField().getText();
				try 
				{
					writer = new FileWriter(chooser.getSelectedFile());
					bufferedWriter = new BufferedWriter(writer);
					  bufferedWriter.write(lengthString);
					  bufferedWriter.newLine();
				} 
				catch (NumberFormatException | IOException ex) 
				{
					  System.out.println("Nothing to do here with length");
				}
			String widthString = confPanel.widthTextField().getText();
				try 
				{
					  bufferedWriter.write(widthString);
					  bufferedWriter.newLine();
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with width");
				}
			String maxHeightString = confPanel.maxHeightTextField().getText();
				try 
				{
					  bufferedWriter.write(maxHeightString);
					  bufferedWriter.newLine();
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with max");
				}
			String minHeightString = confPanel.minHeightTextField().getText();
				try 
				{
					  bufferedWriter.write(minHeightString);
					  bufferedWriter.newLine();
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with min");
				}
			String roughnessString = confPanel.roughnessTextField().getText();
				try 
				{
					  bufferedWriter.write(roughnessString);
					  bufferedWriter.newLine();
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with roughness");
				}
			String seedString = confPanel.seedTextField().getText();
				try 
				{
					  bufferedWriter.write(seedString);
					  bufferedWriter.newLine();
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with seed");
				}
			String relativnessString = confPanel.relativnessTextField().getText();
				try 
				{
					  bufferedWriter.write(relativnessString);
					  bufferedWriter.newLine();
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with relativness");
				}
				try {
					
					for (int x = 0; x<Params.getWidth()-1; x++) {
						for (int y = 0; y<Params.getLength()-1; y++) {
						String str = Float.toString(MeshPanel.height[x][y]);
						bufferedWriter.write(str);
						bufferedWriter.newLine();
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}	

					try {
						bufferedWriter.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
			}
			else 
				System.out.println("No file has been chosen");
			break;
		}
		case "OPEN": {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Choose file");
			int result = chooser.showDialog(null, "Choose");
			if(JFileChooser.APPROVE_OPTION == result) {
				System.out.println("File chosen: " + chooser.getSelectedFile());
				FileReader reader = null;
				BufferedReader bufferedReader = null;
				try 
				{
					reader = new FileReader(chooser.getSelectedFile());
					bufferedReader = new BufferedReader(reader);
					  String lengthString = bufferedReader.readLine();
					  Params.setLength(Integer.parseInt(lengthString));
					  confPanel.lengthTextField().setText(lengthString);
				} 
				catch (NumberFormatException | IOException ex) 
				{
					  System.out.println("Nothing to do here with length");
				}
				try 
				{
					 String widthString = bufferedReader.readLine();
					  Params.setWidth(Integer.parseInt(widthString));
					  confPanel.widthTextField().setText(widthString);
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with width");
				}
				try 
				{
					 String maxHeightString = bufferedReader.readLine();
					  Params.setMaxHeight(Integer.parseInt(maxHeightString));
					  confPanel.maxHeightTextField().setText(maxHeightString);
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with max");
				}
				try 
				{
					 String minHeightString = bufferedReader.readLine();
					  Params.setMinHeight(Integer.parseInt(minHeightString));
					  confPanel.minHeightTextField().setText(minHeightString);
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with min");
				}
				try 
				{
					 String roughnessString = bufferedReader.readLine();
					  Params.setRoughness(Float.parseFloat(roughnessString));
					  confPanel.roughnessTextField().setText(roughnessString);
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with roughness");
				}
				try 
				{
					 String seedString = bufferedReader.readLine();
					  Params.setSeed(Integer.parseInt(seedString));
					  confPanel.seedTextField().setText(seedString);
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with seed");
				}
				try 
				{
					 String relativnessString = bufferedReader.readLine();
					  Params.setRelativness(Float.parseFloat(relativnessString));
					  confPanel.relativnessTextField().setText(relativnessString);
				}
				catch (NumberFormatException | IOException ex) 
				{
						System.out.println("Nothing to do here with relativness");
				}
				try {
					MeshPanel.height= new float[Params.getWidth()][Params.getLength()];
					for (int x = 0; x<Params.getWidth()-1; x++) {
						for (int y = 0; y<Params.getLength()-1; y++) {
							 String str = bufferedReader.readLine();
							MeshPanel.height[x][y] = Float.parseFloat(str);
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				

				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
			else 
				System.out.println("No file has been chosen");
			break;
		}
		case "NEW": {
			  try {				
			  Params.setLength(0);
			  } 
			  catch (NumberFormatException ex) {
				  System.out.println("Nothing to do here with length");
			  }
			  try {
				  Params.setWidth(0);
			  } 
			  catch (NumberFormatException ex) {
					  System.out.println("Nothing to do here with width");
			  }
			  try {
				  Params.setMaxHeight(0);
			  } 
			  catch (NumberFormatException ex) {
					  System.out.println("Nothing to do here with max");
			  }
			  try {
				  Params.setMinHeight(0);
			  } 
			  catch (NumberFormatException ex) {
					  System.out.println("Nothing to do here with min");
			  }
			  try {
				  Params.setRoughness(0);
			  } 
			  catch (NumberFormatException ex) {
					  System.out.println("Nothing to do here with roughness");
			  }
			  try {
				  Params.setSeed(0);
			  } 
			  catch (NumberFormatException ex) {
					  System.out.println("Nothing to do here with seed");
			  }
			  try {
				  Params.setRelativness(0);
			  } 
			  catch (NumberFormatException ex) {
					  System.out.println("Nothing to do here with relativness");
			  }
			  
			  confPanel.lengthTextField().setText("0");
			  confPanel.widthTextField().setText("0");
			  confPanel.maxHeightTextField().setText("0");
			  confPanel.minHeightTextField().setText("0");
			  confPanel.roughnessTextField().setText("0");
			  confPanel.seedTextField().setText("0");
			  confPanel.relativnessTextField().setText("0");
			  break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + optionPicked);
		}

	}

}