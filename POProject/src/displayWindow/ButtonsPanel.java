public class ButtonsPanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setLayout(new GridLayout(1,2));  //this oznacza obiekt tej klasy, który będzie utworzony w main (i każdy kolejny obiekt)
		
    ButtonsPanel panel1;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JLabel label;	
    public ButtonsPanel() throws HeadlessException{   //konstruktor
      panel1 = new ButtonsPanel();
      panel1.setBackground(Color.white);
      panel1.setSize(500, 400);
      panel1.setLayout(new BorderLayoutLayout);
      button1 = new JButton ("długość terenu");
      button2 = new JButton ("szerokość terenu");
      button3 = new JButton ("maksymalna wysokość punktu");
	    button4 = new JButton ("minimalna wysokość punktu");
	    button5 = new JButton ("ziarnistość terenu");
	    button6 = new JButton ("ziarno");
	    button7 = new JButton ("względna zależność wysokości punktu od najbliższego otoczenia");
	    button8 = new JButton ("Generuj");
	    
      label = new JLabel ("Tutaj bedzie widoczny wygenerowany teren.");
	    
	    
	    
    }
	
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(label);
		panel1.add(field);
		
		ThreeShapesPanel panel2 = new ThreeShapesPanel();
		panel2.setBackground(Color.lightGray);
		panel2.setSize(500, 400);
		
		this.add(panel1);
		this.add(panel2);
	
	public static void main(String[] args) {
		ButtonsPanel buttonspanel = new ButtonsPanel();
		buttonspanel.setVisible(true);
	}

}

