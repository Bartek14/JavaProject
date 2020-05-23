package pl.edu.pw.fizyka.pojava.TerrainGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ConfigurationListener implements ActionListener {

	ConfigPanel confPanel;

	public ConfigurationListener(ConfigPanel configPanel) {
		// TODO Auto-generated constructor stub
		this.confPanel = configPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String optionPicked = e.getActionCommand();

		switch (optionPicked) {
		case "LENGHT": {
			System.out.println("Nothing to do here with length");

			
			  String lengthString = confPanel.getLengthTextField().getText(); 
			  int length = 0;
			  try {
			  length = Integer.parseInt(lengthString);
			  } 
			  
			  catch (NumberFormatException ex) {
			  length = 700;
			  }
			 
			break;
		}

		case "WIDTH": {
			System.out.println("Nothing to do here with width");
			String widthString = confPanel.getWidthTextField().getText();
			int width = 0; 
			width = Integer.parseInt(widthString);
			try
			{
			width = Integer.parseInt(widthString);
			}
			catch (NumberFormatException ex)
			{
				width = 1000;
			}
			break;
		}
		case "MAX": {
			System.out.println("Nothing to do here with max");
			String maxHeightString = confPanel.getMaxHeightTextField().getText();
			float maxHeight = 0;
			maxHeight = Float.parseFloat(maxHeightString);
			try
			{
			maxHeight = Float.parseFloat(maxHeightString);
			}
			catch (NumberFormatException ex)
			{
				maxHeight = 70;
			}
			break;
		}
		case "MIN": {
			System.out.println("Nothing to do here with min");
			String minHeightString = confPanel.getMinHeightTextField().getText();
			float minHeight = 0;
			minHeight = Float.parseFloat(minHeightString);
			try
			{
			minHeight = Float.parseFloat(minHeightString);
			}
			catch (NumberFormatException ex)
			{
				minHeight = 10;
			}
			break;
		}
		case "ROUGHNESS": {
			System.out.println("Nothing to do here with roughness");
			String roughnessString = confPanel.getRoughnessTextField().getText();
			float roughness = 0;
			roughness = Float.parseFloat(roughnessString);
			try
			{
			roughness = Float.parseFloat(roughnessString);
			}
			catch (NumberFormatException ex)
			{
				roughness = 0.3f;
			}
			break;
		}
		case "SEED": {
			System.out.println("Nothing to do here with seed");
			String seedString = confPanel.getSeedTextField().getText();
			long seed;
			seed = Long.parseLong(seedString);
			try
			{
			seed = Long.parseLong(seedString);
			}
			catch (NumberFormatException ex)
			{
				seed = 	7347248;
			}
		break;	
		}
		case "RELATION": {
			System.out.println("Nothing to do here with relation");
			String relativnessString = confPanel.getRelativnessTextField().getText();
			float relativness = 0;
			relativness = Float.parseFloat(relativnessString);
			try
			{
			relativness = Float.parseFloat(relativnessString);
			}
			catch (NumberFormatException ex)
			{
				relativness = 2f;
			}
			break;
		}
		case "GENERATE": {
			System.out.println("generate");
			confPanel.setGenerating(true);
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