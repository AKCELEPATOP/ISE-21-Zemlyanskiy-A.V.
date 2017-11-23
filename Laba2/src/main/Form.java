package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import components.MainPanel;
import components.Rotate;
import train.Heatovoz;
import train.ITransport;
import train.Locomotive;

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
	private JLabel lblNewLabel_1;
	private JPanel returnPanel;
	private JPanel panel;
	private JTextField formattedTextField;
	private JPanel panelGet;
	private JButton buttonGet;
	private JPanel panel_1;
	private JList listBoxLevels;
	private JButton orderLoc;
	
	private FormSelectLoc dialog;

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
		depo = new Depo(5);
		initialize();
		maxCountPassegers = 2;
		maxSpeed = 300;
		weight = 100;
		carrying = 200;
		countFuel = 50;
		color = Color.GREEN.darker();
		dopColor = Color.GRAY.brighter();
		chimneyColor = Color.GRAY.brighter();
		
		listBoxLevels.setSelectedIndex(depo.getCurrentLevel());
	}

	private void buttonGet_Click() {
		if (listBoxLevels.getSelectedIndex() < 0) {
			return;
		}
		try {
			ITransport loc = depo.GetLocInDepo(Integer.parseInt(formattedTextField.getText()));

			Graphics2D g = (Graphics2D) returnPanel.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, returnPanel.getWidth(), returnPanel.getHeight());
			if (loc != null) {
				loc.setPosition(returnPanel.getWidth() >> 1, returnPanel.getHeight() >> 1);
				Rotate.imageRotate(g, loc.Pict(), 0, loc.Center());
			}
			panel.repaint();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Неверный номер");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Хьюстон, у нас проблемы!");
		}

	}
	
	private void order_Click(){
		dialog=new FormSelectLoc(frame);
		if(dialog.execute()){
			ITransport loc=dialog.getLoc();
			int place = depo.PutLocInDepo(loc);
			panel.repaint();
			JOptionPane.showMessageDialog(frame, "Ваше место " + place);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 739, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelGet = new JPanel();
		panelGet.setBounds(554, 153, 159, 306);
		panelGet.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGet.setToolTipText("");
		panelGet.setLayout(null);

		lblNewLabel_1 = new JLabel("Забрать локомотив");
		lblNewLabel_1.setBounds(10, 5, 139, 14);
		panelGet.add(lblNewLabel_1);

		returnPanel = new JPanel();
		returnPanel.setBackground(Color.WHITE);
		returnPanel.setBounds(10, 94, 139, 201);
		panelGet.add(returnPanel);

		formattedTextField = new JTextField();
		formattedTextField.setBounds(10, 29, 59, 20);
		panelGet.add(formattedTextField);

		buttonGet = new JButton("Получить");
		buttonGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGet_Click();
			}
		});
		buttonGet.setBounds(10, 60, 111, 23);
		panelGet.add(buttonGet);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(554, 11, 159, 140);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\u0423\u0440\u043E\u0432\u043D\u0438:");
		lblNewLabel_2.setBounds(59, 5, 62, 14);
		panel_1.add(lblNewLabel_2);

		String[] elements = new String[5];
		for (int i = 0; i < 5; i++) {
			elements[i] = "Level" + (i+1);
		}
		listBoxLevels = new JList(elements);
		listBoxLevels.setBounds(10, 18, 139, 111);
		listBoxLevels.setLayoutOrientation(JList.VERTICAL);
		listBoxLevels.setVisibleRowCount(0);
		listBoxLevels.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				depo.setCurrentLevel(listBoxLevels.getSelectedIndex());
				panel.repaint();
			}

		});
		panel_1.add(listBoxLevels);
		
		panel = new MainPanel(depo,listBoxLevels);
		panel.setBounds(10, 11, 534, 382);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		
		orderLoc = new JButton("<html>\u0417\u0430\u043A\u0430\u0437\u0430\u0442\u044C \u043B\u043E\u043A\u043E\u043C\u043E\u0442\u0438\u0432</html>");
		orderLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order_Click();
			}
		});
		orderLoc.setBounds(381, 404, 163, 32);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(orderLoc);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panelGet);
		frame.getContentPane().add(panel_1);
	}
}
