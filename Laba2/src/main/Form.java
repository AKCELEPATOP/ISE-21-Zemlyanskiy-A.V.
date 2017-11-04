package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Form {
	
	private Depo depo;
	
	private Color color;
	private Color dopColor;
	private Color chimneyColor;

	private int maxCountPassegers;
	private double carrying;
	private double weight;
	private int maxSpeed;
	private int countFuel;
	
	private JFrame frame;
	private JButton buttonColor;
	private JButton buttonDopColor;
	private JButton buttonChimney;
	private JButton buttonLoc;
	private JButton buttonHeat;
	private JLabel lblNewLabel_1;
	private JPanel returnPanel;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblDopcolor;
	private JLabel lblChimneycolor;
	private JTextField formattedTextField;
	private JPanel panelGet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form() {
		depo=new Depo();
		initialize();
		maxCountPassegers = 2;
		maxSpeed = 300;
		weight = 100;
		carrying = 200;
		countFuel = 50;
		color = Color.GREEN.darker();
		dopColor = Color.GRAY.brighter();
		chimneyColor = Color.GRAY.brighter();
		buttonColor.setBackground(color);
		buttonDopColor.setBackground(dopColor);
		buttonChimney.setBackground(chimneyColor);

	}
	
	private void buttonLoc_Click(){
		ITransport loc = new Locomotive(maxSpeed, maxCountPassegers, weight, carrying, color, dopColor);
		int place=depo.PutLocInDepo(loc);
		panel.repaint();
		JOptionPane.showMessageDialog(frame, "Ваше место "+place);
	}
	
	private void buttonHeat_Click(){
		ITransport loc = new Heatovoz(maxSpeed, maxCountPassegers, weight, carrying, color, dopColor, true, true,
				countFuel, chimneyColor);
		int place=depo.PutLocInDepo(loc);
		panel.repaint();
		JOptionPane.showMessageDialog(frame, "Ваше место "+place);
	}
	
	private void buttonGet_Click(){
		try{
			ITransport loc=depo.GetLocInDepo(Integer.parseInt(formattedTextField.getText()));
			
			Graphics2D g=(Graphics2D) returnPanel.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, returnPanel.getWidth(), returnPanel.getHeight());
			if(loc!=null){
				loc.setPosition(returnPanel.getWidth()>>1, returnPanel.getHeight()>>1);
				Rotate.imageRotate(g, loc.Pict(), 0, loc.Center());
			}
			panel.repaint();
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(frame, "Неверный номер");
		}catch(Exception e){
			JOptionPane.showMessageDialog(frame, "Хьюстон, у нас проблемы!");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 739, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new MainPanel(depo);
		panel.setBounds(10, 11, 534, 382);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);

		buttonLoc = new JButton("set locomotive");
		buttonLoc.setBounds(10, 404, 122, 23);
		buttonLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLoc_Click();
			}
		});

		buttonHeat = new JButton("set heatovoz");
		buttonHeat.setBounds(141, 405, 122, 23);
		buttonHeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonHeat_Click();
			}
		});

		lblNewLabel = new JLabel("Color");
		lblNewLabel.setBounds(565, 329, 37, 14);

		lblDopcolor = new JLabel("dopColor");
		lblDopcolor.setBounds(554, 359, 63, 14);

		lblChimneycolor = new JLabel("chimney");
		lblChimneycolor.setBounds(554, 391, 63, 14);

		buttonColor = new JButton("");
		buttonColor.setBounds(612, 328, 68, 21);
		lblNewLabel.setLabelFor(buttonColor);

		buttonColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(frame, "Select a color", color);
				buttonColor.setBackground(color);
			}
		});

		buttonDopColor = new JButton("");
		buttonDopColor.setBounds(612, 359, 68, 21);
		lblDopcolor.setLabelFor(buttonDopColor);
		buttonDopColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dopColor = JColorChooser.showDialog(frame, "Select a color", dopColor);
				buttonDopColor.setBackground(dopColor);
			}
		});

		buttonChimney = new JButton("");
		buttonChimney.setBounds(612, 389, 68, 21);
		lblChimneycolor.setLabelFor(buttonChimney);
		buttonChimney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chimneyColor = JColorChooser.showDialog(frame, "Select a color", dopColor);
				buttonChimney.setBackground(chimneyColor);
			}
		});
		panelGet = new JPanel();
		panelGet.setBounds(554, 11, 159, 306);
		panelGet.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGet.setToolTipText("");
		panelGet.setLayout(null);

		lblNewLabel_1 = new JLabel(
				"Забрать локомотив");
		lblNewLabel_1.setBounds(10, 5, 139, 14);
		panelGet.add(lblNewLabel_1);

		returnPanel = new JPanel();
		returnPanel.setBackground(Color.WHITE);
		returnPanel.setBounds(10, 94, 139, 201);
		panelGet.add(returnPanel);

		formattedTextField = new JTextField();
		formattedTextField.setBounds(10, 29, 59, 20);
		panelGet.add(formattedTextField);

		JButton buttonGet = new JButton("Получить");
		buttonGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGet_Click();
			}
		});
		buttonGet.setBounds(10, 60, 111, 23);
		panelGet.add(buttonGet);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(buttonLoc);
		frame.getContentPane().add(buttonHeat);
		frame.getContentPane().add(panelGet);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(buttonColor);
		frame.getContentPane().add(buttonDopColor);
		frame.getContentPane().add(lblDopcolor);
		frame.getContentPane().add(buttonChimney);
		frame.getContentPane().add(lblChimneycolor);
	}
}
