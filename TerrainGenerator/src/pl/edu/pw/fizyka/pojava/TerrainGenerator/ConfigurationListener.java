package pl.edu.pw.fizyka.pojava.TerrainGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ConfigurationListener implements ActionListener {

	ConfigPanel confPanel;
	//Params param;
	public ConfigurationListener(ConfigPanel configPanel) {
		// TODO Auto-generated constructor stub
		this.confPanel = configPanel;
		//this.param = new Params();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String optionPicked = e.getActionCommand();

		switch (optionPicked) {

		case "GENERATE": {
			System.out.println("generate");
			ConfigPanel.setGenerating(true);
			
			 String lengthString = confPanel.getLengthTextField().getText(); 
			  try {
			  Params.setLength(Integer.parseInt(lengthString));
			  } 
			  catch (NumberFormatException ex) {
				  System.out.println("Nothing to do here with length");
			  }
			  
				String widthString = confPanel.getWidthTextField().getText();
				try
				{
					 Params.setWidth(Integer.parseInt(widthString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with width");
				}
			  
				
				String maxHeightString = confPanel.getMaxHeightTextField().getText();
				try
				{
					Params.setMaxHeight(Float.parseFloat(maxHeightString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with max");
				}
				
				
				String minHeightString = confPanel.getMinHeightTextField().getText();
				try
				{
					Params.setMinHeight(Float.parseFloat(minHeightString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with min");
				}
				
				
				String roughnessString = confPanel.getRoughnessTextField().getText();
				try
				{
					Params.setRoughness(Float.parseFloat(roughnessString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with roughness");
				}
				
				String seedString = confPanel.getSeedTextField().getText();
				try
				{
					Params.setSeed(Integer.parseInt(seedString));
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nothing to do here with seed");
				}
				
			break;
			
			

		}
		case "LINEAR": {
			System.out.println("Nothing to do here with linear");
			confPanel.isLinear = true;
		break;	
		}
		case "TRIGONOMETRIC": {
			System.out.println("Nothing to do here with trigonometric");
			confPanel.isLinear = false;
		break;	
		}		
		default:
			throw new IllegalArgumentException("Unexpected value: " + optionPicked);
		}

	}

}