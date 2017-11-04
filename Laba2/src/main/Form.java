package main;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Form {

	private JFrame frame;
	private JTextField SpeedField;
	private JTextField weightField;
	private JTextField passengersField;
	private JTextField carryingField;
	private JTextField fuelField;
	private JButton buttonColor;
	private JButton buttonDopColor;
	private JButton buttonChimney;
	private JButton buttonLoc;
	private JButton buttonHeat;

	private JCheckBox cheakBoxTop;
	private JCheckBox checkBoxBotm;

	private Color color;
	private Color dopColor;
	private Color chimneyColor;

	private ITransport shit;
	private int maxCountPassegers;
	private double carrying;
	private double weight;
	private int maxSpeed;
	private int countFuel;

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

	private boolean cheakFields() {
		try {
			maxSpeed = Integer.parseInt(SpeedField.getText());
			maxCountPassegers = Integer.parseInt(passengersField.getText());
			weight = Double.parseDouble(weightField.getText());
			carrying = Double.parseDouble(carryingField.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean cheakFuel() {
		try {
			countFuel = Integer.parseInt(fuelField.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 140, 219);
		panel.setBackground(Color.WHITE);

		JLabel labelSpeed = new JLabel("Max Speed");
		labelSpeed.setBounds(10, 239, 103, 14);

		SpeedField = new JTextField();
		SpeedField.setBounds(117, 236, 63, 20);
		labelSpeed.setLabelFor(SpeedField);
		SpeedField.setColumns(10);

		weightField = new JTextField();
		weightField.setBounds(255, 236, 63, 20);
		weightField.setColumns(10);

		JLabel labelWeight = new JLabel("Weight");
		labelWeight.setBounds(184, 239, 53, 14);

		JLabel labelPassengers = new JLabel("Max Passengers");
		labelPassengers.setBounds(10, 270, 101, 14);

		passengersField = new JTextField();
		passengersField.setBounds(117, 267, 63, 20);
		passengersField.setColumns(10);

		JLabel labelCarrying = new JLabel("Max Speed");
		labelCarrying.setBounds(184, 270, 75, 14);

		carryingField = new JTextField();
		carryingField.setBounds(255, 267, 63, 20);
		carryingField.setColumns(10);

		cheakBoxTop = new JCheckBox("Top chimney");
		cheakBoxTop.setBounds(318, 236, 108, 23);

		checkBoxBotm = new JCheckBox("Botm chimney");
		checkBoxBotm.setBounds(318, 267, 101, 23);

		fuelField = new JTextField();
		fuelField.setBounds(300, 298, 56, 20);
		fuelField.setColumns(10);

		JLabel labelFuel = new JLabel("Fuel");
		labelFuel.setBounds(265, 298, 31, 14);

		buttonLoc = new JButton("set locomotive");
		buttonLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cheakFields()) {
					shit = new Locomotive(maxSpeed, maxCountPassegers, weight, carrying, color, dopColor);
					shit.setPosition(panel.getWidth() >> 1, panel.getHeight()>>1);
					Graphics2D gr = (Graphics2D) panel.getGraphics();
					gr.clearRect(0, 0, panel.getWidth(), panel.getHeight());
					Rotate.imageRotate(gr, shit.Pict(), 0, shit.Center());
				}
			}
		});
		buttonLoc.setBounds(10, 298, 122, 23);

		buttonHeat = new JButton("set heatovoz");
		buttonHeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cheakFields() && cheakFuel()) {
					shit = new Heatovoz(maxSpeed, maxCountPassegers, weight, carrying, color, dopColor,
							cheakBoxTop.isSelected(), checkBoxBotm.isSelected(), countFuel, chimneyColor);
					shit.setPosition(panel.getWidth() >> 1, panel.getHeight()>>1);
					Graphics2D gr = (Graphics2D) panel.getGraphics();
					gr.clearRect(0, 0, panel.getWidth(), panel.getHeight());
					Rotate.imageRotate(gr, shit.Pict(), 0, shit.Center());
				}
			}
		});
		buttonHeat.setBounds(142, 298, 122, 23);

		JLabel lblNewLabel = new JLabel("Color");
		lblNewLabel.setBounds(436, 240, 37, 14);

		JLabel lblDopcolor = new JLabel("dopColor");
		lblDopcolor.setBounds(425, 270, 63, 14);

		JLabel lblChimneycolor = new JLabel("chimney");
		lblChimneycolor.setBounds(425, 302, 63, 14);

		buttonColor = new JButton("");
		buttonColor.setBounds(483, 239, 68, 21);

		buttonColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(frame, "Select a color", color);
				buttonColor.setBackground(color);
			}
		});

		buttonDopColor = new JButton("");
		buttonDopColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dopColor = JColorChooser.showDialog(frame, "Select a color", dopColor);
				buttonDopColor.setBackground(dopColor);
			}
		});
		buttonDopColor.setBounds(483, 270, 68, 21);

		buttonChimney = new JButton("");
		buttonChimney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chimneyColor = JColorChooser.showDialog(frame, "Select a color", dopColor);
				buttonChimney.setBackground(chimneyColor);
			}
		});
		buttonChimney.setBounds(483, 300, 68, 21);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(buttonLoc);
		frame.getContentPane().add(labelSpeed);
		frame.getContentPane().add(labelPassengers);
		frame.getContentPane().add(passengersField);
		frame.getContentPane().add(labelCarrying);
		frame.getContentPane().add(carryingField);
		frame.getContentPane().add(SpeedField);
		frame.getContentPane().add(labelWeight);
		frame.getContentPane().add(weightField);
		frame.getContentPane().add(buttonHeat);
		frame.getContentPane().add(cheakBoxTop);
		frame.getContentPane().add(labelFuel);
		frame.getContentPane().add(fuelField);
		frame.getContentPane().add(checkBoxBotm);
		frame.getContentPane().add(lblChimneycolor);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblDopcolor);
		frame.getContentPane().add(buttonChimney);
		frame.getContentPane().add(buttonDopColor);
		frame.getContentPane().add(buttonColor);
	}
}
