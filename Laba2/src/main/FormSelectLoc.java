package main;

import javax.swing.*;
import java.awt.Color;
import javax.swing.border.LineBorder;

import components.*;
import train.ITransport;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Order the locomotive
 * @author Zemlyanskiy
 *
 */

public class FormSelectLoc extends JDialog {
	private DraggebleLabel labelLoc;
	private DropTargetPanel panel;
	
	private DraggebleLabel labelHeat;
	private DropTargetLabel labelMainColor;
	private DropTargetLabel labelDopColor;
	private DropTargetLabel labelChimneyColor;
	private JPanel panel_3;
	private JPanel panelGreen;
	private JPanel panelGray;
	private JLabel lblColors;
	
	private boolean result;


	public FormSelectLoc(JFrame parent){
		super(parent,true);
		initialize();
	}
	
	public boolean execute(){
		setVisible(true);
		return result;
	}
	
	public ITransport getLoc(){
		return panel.getLoc();
	}

	
	private void initialize() {
		setBounds(100, 100, 401, 370);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 240, 248);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel = new DropTargetPanel();
		panel.setBounds(10, 11, 147, 228);
		panel_1.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		
		labelMainColor = new DropTargetLabel("Main");
		labelMainColor.setBounds(167, 142, 65, 29);
		panel_1.add(labelMainColor);
		labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainColor.setBorder(new LineBorder(Color.BLACK));
		labelMainColor.setLabelFor(panel);
		
		labelDopColor = new DropTargetLabel("Secondary");
		labelDopColor.setBounds(167, 176, 65, 29);
		panel_1.add(labelDopColor);
		labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDopColor.setBorder(new LineBorder(Color.BLACK));
		labelDopColor.setLabelFor(panel);
		
		labelChimneyColor = new DropTargetLabel("Chimney");
		labelChimneyColor.setBounds(167, 210, 65, 29);
		panel_1.add(labelChimneyColor);
		labelChimneyColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelChimneyColor.setBorder(new LineBorder(Color.BLACK));
		labelChimneyColor.setLabelFor(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(260, 11, 118, 80);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(10, 0, 66, 14);
		panel_2.add(lblNewLabel);
		
		labelHeat = new DraggebleLabel("Locomotive");
		labelHeat.setHorizontalAlignment(SwingConstants.CENTER);
		labelHeat.setBounds(10, 49, 94, 22);
		labelHeat.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(labelHeat);
		labelHeat.setText("Heatovoz");
		
		labelLoc = new DraggebleLabel("Locomotive");
		labelLoc.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoc.setBounds(10, 24, 94, 22);
		labelLoc.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(labelLoc);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(260, 102, 118, 224);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		panelGreen = new DraggeblePanel();
		panelGreen.setBackground(new Color(0, 128, 0));
		panelGreen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGreen.setBounds(10, 20, 40, 40);
		panel_3.add(panelGreen);
		
		panelGray = new DraggeblePanel();
		panelGray.setBackground(new Color(211, 211, 211));
		panelGray.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGray.setBounds(60, 20, 40, 40);
		panel_3.add(panelGray);
		
		DraggeblePanel panelBlue = new DraggeblePanel();
		panelBlue.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlue.setBackground(new Color(0, 0, 255));
		panelBlue.setBounds(10, 71, 40, 40);
		panel_3.add(panelBlue);
		
		DraggeblePanel panelPurple = new DraggeblePanel();
		panelPurple.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPurple.setBackground(new Color(148, 0, 211));
		panelPurple.setBounds(60, 71, 40, 40);
		panel_3.add(panelPurple);
		
		DraggeblePanel panelBlack = new DraggeblePanel();
		panelBlack.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlack.setBackground(new Color(0, 0, 0));
		panelBlack.setBounds(10, 122, 40, 40);
		panel_3.add(panelBlack);
		
		DraggeblePanel panelPink = new DraggeblePanel();
		panelPink.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPink.setBackground(new Color(255, 0, 255));
		panelPink.setBounds(60, 122, 40, 40);
		panel_3.add(panelPink);
		
		DraggeblePanel panelYellow = new DraggeblePanel();
		panelYellow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelYellow.setBackground(new Color(255, 255, 0));
		panelYellow.setBounds(10, 173, 40, 40);
		panel_3.add(panelYellow);
		
		DraggeblePanel panelGold = new DraggeblePanel();
		panelGold.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGold.setBackground(new Color(255, 215, 0));
		panelGold.setBounds(60, 173, 40, 40);
		panel_3.add(panelGold);
		
		lblColors = new JLabel("Colors");
		lblColors.setBounds(10, 0, 46, 14);
		panel_3.add(lblColors);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result=true;
				dispose();
			}
		});
		add.setBounds(10, 284, 109, 30);
		getContentPane().add(add);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result=false;
				dispose();
			}
		});
		cancel.setBounds(141, 284, 109, 30);
		getContentPane().add(cancel);
	}
}
