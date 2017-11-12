package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.JRadioButton;

public class Form {

	private JFrame frame;

	private JLabel label_6;

	private JButton kushat;

	private JButton put_petr;

	private JLabel label_5;

	private JButton add_oil;

	private JButton add_others;

	private JButton add_meat;

	private JButton get_meat;

	private JLabel label_4;

	private JButton put_meat;

	private JButton add_coal;

	private JLabel label_3;

	private JButton zarezat;

	private JButton srediing_pepper;

	private JButton sredding_klukva;

	private JLabel label_2;

	private JCheckBox checkBox_1;

	private JButton put_pan;

	private JButton get_pan;

	private JLabel label_1;

	private JButton pepper_wash;

	private JButton petrushka_wash;

	private JButton pig_wash;

	private JLabel label;

	private JLabel pig;

	private JSpinner numericPig;

	private JLabel kuka;

	private JSpinner numericKlukva;

	private JLabel labelOil;

	private JSpinner numericOil;

	private JSpinner numericKvas;

	private JLabel kvasik;

	private JLabel bl_per;

	private JSpinner numericBlack;

	private JLabel gor_perec;

	private JSpinner numericGor;

	private JLabel petrusha;

	private JSpinner numericPetrusha;

	private JLabel labelSalt;

	private JSpinner numericSalt;

	private JLabel labelCoal;

	private JSpinner numericCoal;

	private Pig meat;

	private BlackPepper black_pepper;

	private Coal coal;

	private Dish dish;

	private GorikiyPepper gor_pepper;

	private Grille grille;

	private Klukva klukva;

	private Knife knife;

	private Kvas kvas;

	private Oil oil;

	private Pan pan;

	private Petrushka petrushka;

	private Salt salt;

	private Stove stove;

	private WaterTap tap;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;

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
		dish = new Dish();
		grille = new Grille();
		knife = new Knife();
		pan = new Pan();
		stove = new Stove();
		tap = new WaterTap();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 668, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(31, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
				.addGap(11)));
		panel_6.setLayout(null);

		label_6 = new JLabel("\u0411\u043B\u044E\u0434\u043E");
		label_6.setBounds(53, 5, 75, 14);
		panel_6.add(label_6);

		kushat = new JButton(
				"<html>\u041F\u0435\u0440\u0435\u043B\u043E\u0436\u0438\u0442\u044C<br>\u043C\u044F\u0441\u043E</html>");
		kushat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kushat.setEnabled(false);
				dish.setMeat(meat);
				meat = null;
				if (petrushka.getDirty() == 0) {
					put_petr.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Петрушка то грязная");
				}
			}
		});
		kushat.setEnabled(false);
		kushat.setBounds(10, 25, 118, 37);
		panel_6.add(kushat);

		put_petr = new JButton(
				"<html>\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C<br>\u043F\u0435\u0442\u0440\u0443\u0448\u043A\u0443</html>");
		put_petr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				put_petr.setEnabled(false);
	            dish.setPetrushka(petrushka);
	            petrushka = null;
	            JOptionPane.showMessageDialog(frame, "Шашлык из свинины готов!");
			}
		});
		put_petr.setEnabled(false);
		put_petr.setBounds(10, 70, 118, 37);
		panel_6.add(put_petr);
		panel_5.setLayout(null);

		label_5 = new JLabel("\u041A\u0430\u0441\u0442\u0440\u044E\u043B\u044F");
		label_5.setBounds(41, 4, 87, 14);
		panel_5.add(label_5);

		add_oil = new JButton(
				"<html>\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C<br>\u043C\u0430\u0441\u043B\u043E</html>");
		add_oil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan.AddOil(oil);
				if (stove.isState()) {
					put_pan.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Масло нужно растопить");
				}
				add_oil.setEnabled(false);
			}
		});
		add_oil.setEnabled(false);
		add_oil.setBounds(10, 29, 118, 37);
		panel_5.add(add_oil);

		add_others = new JButton(
				"<html>\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C<br>\u043F\u0440\u043E\u0447\u0438\u0435<br>\u0438\u043D\u0433\u0440\u0438\u0434\u0438\u0435\u0442\u043D\u044B<br>\u043C\u0430\u0440\u0438\u043D\u0430\u0434\u0430</html>");
		add_others.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_others.setEnabled(false);
				pan.CreateMarinade(klukva, kvas, salt, gor_pepper, black_pepper);
				klukva = null;
				salt = null;
				kvas = null;
				gor_pepper = null;
				black_pepper = null;
				if (meat.getHas_sredded() == 10) {
					add_meat.setEnabled(true);
				}
			}
		});
		add_others.setEnabled(false);
		add_others.setBounds(10, 70, 118, 71);
		panel_5.add(add_others);

		add_meat = new JButton(
				"<html>\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C<br>\u0441\u0432\u0438\u043D\u0438\u043D\u0443</html>");
		add_meat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan.addMeat(meat);
				meat = null;
				if (pan.MeatIn()) {
					while (!pan.ReadyToCook()) {
						pan.GetMarinade();
					}
				}
				get_meat.setEnabled(true);
				add_meat.setEnabled(false);
				JOptionPane.showMessageDialog(frame, "Мясо замариновалось");
			}
		});
		add_meat.setEnabled(false);
		add_meat.setBounds(10, 146, 118, 37);
		panel_5.add(add_meat);

		get_meat = new JButton(
				"<html>\u0418\u0437\u0432\u043B\u0435\u0447\u044C<br>\u0441\u0432\u0438\u043D\u0438\u043D\u0443</html>");
		get_meat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meat = pan.GetMeat();
				if (!grille.coalReady()) {
					JOptionPane.showMessageDialog(frame, "Пора приготовить угли");
				} else {
					put_meat.setEnabled(true);
				}
				get_meat.setEnabled(false);
				if (grille.coalReady()) {
					put_meat.setEnabled(true);
				}
			}
		});
		get_meat.setEnabled(false);
		get_meat.setBounds(10, 187, 118, 37);
		panel_5.add(get_meat);
		panel_4.setLayout(null);

		label_4 = new JLabel("\u0413\u0440\u0438\u043B\u044C");
		label_4.setBounds(52, 5, 73, 14);
		panel_4.add(label_4);

		put_meat = new JButton("<html>\u0416\u0430\u0440\u0438\u0442\u044C<br>\u043C\u044F\u0441\u043E</html>");
		put_meat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				put_meat.setEnabled(false);
				grille.setMeat(meat);
				meat = null;
				while (!grille.isReady()) {
					grille.cook();
				}
				meat = grille.getMeat();
				if (meat.isReady()) {
					JOptionPane.showMessageDialog(frame, "Мясо готово, теперь украсим зеленью");
					kushat.setEnabled(true);
				}
			}
		});
		put_meat.setEnabled(false);
		put_meat.setBounds(10, 91, 118, 37);
		panel_4.add(put_meat);

		add_coal = new JButton(
				"<html>\u0417\u0430\u043F\u0440\u0430\u0432\u0438\u0442\u044C \u0438<br>\u0440\u0430\u0437\u0436\u0435\u0447\u044C \u0443\u0433\u043E\u043B\u044C</html>");
		add_coal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_coal.setEnabled(false);
				if (coal != null) {
					grille.setCoal(coal);
				} else {
					JOptionPane.showMessageDialog(frame, "Чурки уголь спиздили. Добавить ещё угля?");
					coal = new Coal();
					coal.setWeight(2000);
				}
				grille.getCoal().setBurning(true);
				while (!grille.coalReady()) {
					grille.cookCoal();
				}
				if (meat == null || !meat.Has_zamarinade()) {
					JOptionPane.showMessageDialog(frame, "Займись мясом");
				} else {
					put_meat.setEnabled(true);
				}
			}
		});
		add_coal.setEnabled(false);
		add_coal.setBounds(10, 30, 118, 50);
		panel_4.add(add_coal);
		panel_3.setLayout(null);

		label_3 = new JLabel("\u041D\u043E\u0436");
		label_3.setBounds(42, 5, 45, 14);
		panel_3.add(label_3);

		zarezat = new JButton(
				"<html>\u041D\u0430\u0440\u0435\u0437\u0430\u0442\u044C<br>\u0441\u0432\u0438\u043D\u0438\u043D\u0443</html>");
		zarezat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (meat.getDirty() == 0) {
					knife.Sredding_pig(meat);
				}
				zarezat.setEnabled(false);
				if (pan.MarinadeReady()) {
					add_meat.setEnabled(true);
				}
			}
		});
		zarezat.setEnabled(false);
		zarezat.setBounds(10, 30, 118, 37);
		panel_3.add(zarezat);

		srediing_pepper = new JButton(
				"<html>\u041D\u0430\u0440\u0435\u0437\u0430\u0442\u044C<br>\u0433\u043E\u0440\u044C\u043A\u0438\u0439 \u043F\u0435\u0440\u0435\u0446</html>");
		srediing_pepper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				knife.Sredding_pepper(gor_pepper);
				srediing_pepper.setEnabled(false);
				if (isReadyToMarinade()) {
					add_others.setEnabled(true);
				}
			}
		});
		srediing_pepper.setEnabled(false);
		srediing_pepper.setBounds(10, 72, 118, 37);
		panel_3.add(srediing_pepper);

		sredding_klukva = new JButton(
				"<html>\u041D\u0430\u0440\u0435\u0437\u0430\u0442\u044C<br>\u043A\u043B\u044E\u043A\u0432\u0443</html>");
		sredding_klukva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				knife.Sredding_klukva(klukva);
				sredding_klukva.setEnabled(false);
				if (isReadyToMarinade()) {
					add_others.setEnabled(true);
				}
			}
		});
		sredding_klukva.setEnabled(false);
		sredding_klukva.setBounds(10, 111, 118, 37);
		panel_3.add(sredding_klukva);
		panel_2.setLayout(null);

		label_2 = new JLabel("\u041F\u043B\u0438\u0442\u0430");
		label_2.setBounds(10, 11, 54, 14);
		panel_2.add(label_2);

		checkBox_1 = new JCheckBox("\u0412\u043A\u043B.");
		checkBox_1.setBounds(70, 7, 58, 23);
		checkBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stove.setState(checkBox_1.isSelected());
				if (stove.isState() && pan.OilIn()) {
					put_pan.setEnabled(true);
				}

			}

		});
		panel_2.add(checkBox_1);

		put_pan = new JButton(
				"<html>\u041F\u043E\u0441\u0442\u0430\u0432\u0438\u0442\u044C<br>\u043A\u0430\u0441\u0442\u0440\u044E\u043B\u044E</html>");
		put_pan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pan.OilIn()) {
					while (!pan.OilReady()) {
						pan.GetHeat();
					}
				}
				JOptionPane.showMessageDialog(frame, "Масло готово");
				checkBox_1.setSelected(false);
				put_pan.setEnabled(false);
				get_pan.setEnabled(true);
			}
		});
		put_pan.setEnabled(false);
		put_pan.setBounds(10, 36, 118, 37);
		panel_2.add(put_pan);

		get_pan = new JButton(
				"<html>\u0423\u0431\u0440\u0430\u0442\u044C<br>\u043A\u0430\u0441\u0442\u0440\u044E\u043B\u044E</html>");
		get_pan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isReadyToMarinade()) {
					add_others.setEnabled(true);
				}
				get_pan.setEnabled(false);
			}
		});
		get_pan.setEnabled(false);
		get_pan.setBounds(10, 76, 118, 35);
		panel_2.add(get_pan);
		panel_1.setLayout(null);

		label_1 = new JLabel("\u041A\u0440\u0430\u043D");
		label_1.setBounds(41, 4, 47, 14);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_1);

		pepper_wash = new JButton(
				"<html>\u041F\u043E\u043C\u044B\u0442\u044C<br>\u0433\u043E\u0440\u044C\u043A\u0438\u0439 \u043F\u0435\u0440\u0435\u0446</html>");
		pepper_wash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tap.WahPepper(gor_pepper);
				if (gor_pepper.isDirty()) {
					srediing_pepper.setEnabled(true);
				}
				pepper_wash.setEnabled(false);
			}
		});
		pepper_wash.setEnabled(false);
		pepper_wash.setBounds(6, 76, 118, 37);
		panel_1.add(pepper_wash);

		petrushka_wash = new JButton(
				"<html>\u041F\u043E\u043C\u044B\u0442\u044C<br>\u043F\u0435\u0442\u0440\u0443\u0448\u043A\u0443</html>");
		petrushka_wash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tap.WashPetrushka(petrushka);
				petrushka_wash.setEnabled(false);
				if (dish.isMeat()) {
					put_petr.setEnabled(true);
				}
			}
		});
		petrushka_wash.setEnabled(false);
		petrushka_wash.setBounds(6, 120, 118, 37);
		panel_1.add(petrushka_wash);

		pig_wash = new JButton(
				"<html>\u041F\u043E\u043C\u044B\u0442\u044C<br>\u0441\u0432\u0438\u043D\u0438\u043D\u0443</html>");
		pig_wash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tap.WashPig(meat);
				if (meat.getDirty() == 0) {
					zarezat.setEnabled(true);
				}
				pig_wash.setEnabled(false);
			}
		});
		pig_wash.setEnabled(false);
		pig_wash.setBounds(6, 162, 118, 34);
		panel_1.add(pig_wash);

		radioButton1 = new JRadioButton("\u041E\u0442\u043A\u0440\u044B\u0442");
		radioButton1.setBounds(6, 20, 109, 23);
		radioButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButton1.isSelected()) {
					if (pig.isEnabled()) {
						pig_wash.setEnabled(true);
					}
					if (gor_perec.isEnabled()) {
						pepper_wash.setEnabled(true);
					}
					if (petrusha.isEnabled()) {
						petrushka_wash.setEnabled(true);
					}
					tap.setState(true);
				}

			}

		});
		panel_1.add(radioButton1);

		radioButton2 = new JRadioButton("\u0417\u0430\u043A\u0440\u044B\u0442");
		radioButton2.setBounds(6, 46, 109, 23);
		radioButton2.setSelected(true);
		radioButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButton2.isSelected()) {
					if (pig_wash.isEnabled()) {
						pig_wash.setEnabled(false);
					}
					if (pepper_wash.isEnabled()) {
						pepper_wash.setEnabled(false);
					}
					if (petrushka_wash.isEnabled()) {
						petrushka_wash.setEnabled(false);
					}
					tap.setState(false);
				}

			}

		});
		panel_1.add(radioButton2);
		panel.setLayout(null);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);

		label = new JLabel("\u0418\u043D\u0433\u0440\u0438\u0434\u0438\u0435\u043D\u0442\u044B");
		label.setBounds(34, 5, 110, 14);
		panel.add(label);

		pig = new JLabel("\u0421\u0432\u0438\u043D\u0438\u043D\u0430");
		pig.setEnabled(false);
		pig.setBounds(10, 33, 86, 14);
		panel.add(pig);

		numericPig = new JSpinner();
		numericPig.setModel(new SpinnerNumberModel(0, null, 10000, 500));
		numericPig.setBounds(106, 30, 55, 20);
		numericPig.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				meat = new Pig();
				if ((int) numericPig.getValue() >= 1500) {
					pig.setEnabled(true);
					numericPig.setEnabled(false);
					if (radioButton1.isSelected()) {
						pig_wash.setVisible(true);
					}
				}

			}

		});
		panel.add(numericPig);

		kuka = new JLabel("\u041A\u043B\u044E\u043A\u0432\u0430");
		kuka.setEnabled(false);
		kuka.setBounds(10, 57, 86, 14);
		panel.add(kuka);

		numericKlukva = new JSpinner();
		numericKlukva.setModel(new SpinnerNumberModel(0, null, 1000, 50));
		numericKlukva.setBounds(106, 54, 55, 20);
		numericKlukva.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (klukva == null) {
					klukva = new Klukva();
				}
				klukva.setWeight((int) numericKlukva.getValue());
				if (klukva.getWeight() >= 200) {
					sredding_klukva.setEnabled(true);
					kuka.setEnabled(true);
					numericKlukva.setEnabled(false);
				}
			}

		});
		panel.add(numericKlukva);

		labelOil = new JLabel("\u041C\u0430\u0441\u043B\u043E");
		labelOil.setEnabled(false);
		labelOil.setBounds(10, 82, 86, 14);
		panel.add(labelOil);

		numericOil = new JSpinner();
		numericOil.setModel(new SpinnerNumberModel(0, null, 200, 50));
		numericOil.setBounds(106, 79, 55, 20);
		numericOil.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				oil = new Oil();
				if ((int) numericOil.getValue() >= 200) {
					numericOil.setEnabled(false);
					labelOil.setEnabled(true);
					add_oil.setEnabled(true);
				}

			}

		});
		panel.add(numericOil);

		kvasik = new JLabel("\u041A\u0432\u0430\u0441");
		kvasik.setEnabled(false);
		kvasik.setBounds(10, 106, 86, 14);
		panel.add(kvasik);

		numericKvas = new JSpinner();
		numericKvas.setModel(new SpinnerNumberModel(0, null, 500, 100));
		numericKvas.setBounds(106, 103, 55, 20);
		numericKvas.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (kvas == null)
					kvas = new Kvas();
				kvas.setVolume((int) numericKvas.getValue());
				if (kvas.getVolume() >= 200) {
					kvasik.setEnabled(true);
					numericKvas.setEnabled(false);
					if (isReadyToMarinade()) {
						add_others.setEnabled(true);
					}
				}

			}

		});
		panel.add(numericKvas);

		bl_per = new JLabel(
				"<html>\u0427\u0435\u0440\u043D\u044B\u0439<br>\u043C\u043E\u043B\u043E\u0442\u044B\u0439<br>\u043F\u0435\u0440\u0435\u0446</html>");
		bl_per.setEnabled(false);
		bl_per.setBounds(10, 129, 86, 44);
		panel.add(bl_per);

		numericBlack = new JSpinner();
		numericBlack.setModel(new SpinnerNumberModel(0, null, 200, 20));
		numericBlack.setBounds(106, 127, 55, 20);
		numericBlack.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (black_pepper == null) {
					black_pepper = new BlackPepper();
				}
				black_pepper.setCount((int) numericBlack.getValue());
				if (black_pepper.getCount() >= 100) {
					numericBlack.setEnabled(false);
					if (isReadyToMarinade()) {
						add_others.setEnabled(true);
					}
					bl_per.setEnabled(true);
				}

			}

		});
		panel.add(numericBlack);

		gor_perec = new JLabel(
				"<html>\u0413\u043E\u0440\u044C\u043A\u0438\u0439<br>\u043F\u0435\u0440\u0435\u0446</html>");
		gor_perec.setEnabled(false);
		gor_perec.setBounds(10, 179, 86, 34);
		panel.add(gor_perec);

		numericGor = new JSpinner();
		numericGor.setModel(new SpinnerNumberModel(0, null, 10, 1));
		numericGor.setBounds(106, 179, 55, 20);
		numericGor.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				gor_pepper = new GorikiyPepper();
				if ((int) numericGor.getValue() > 0) {
					gor_perec.setEnabled(true);
					numericGor.setEnabled(false);
					if (radioButton1.isSelected()) {
						pepper_wash.setEnabled(true);
					}
				}

			}

		});
		panel.add(numericGor);

		petrusha = new JLabel("\u041F\u0435\u0442\u0440\u0443\u0448\u043A\u0430");
		petrusha.setEnabled(false);
		petrusha.setBounds(10, 217, 86, 14);
		panel.add(petrusha);

		numericPetrusha = new JSpinner();
		numericPetrusha.setModel(new SpinnerNumberModel(0, null, 10, 1));
		numericPetrusha.setBounds(106, 214, 55, 20);
		numericPetrusha.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (petrushka == null)
					petrushka = new Petrushka();
				if ((int) numericPetrusha.getValue() > 0) {
					petrusha.setEnabled(true);
					numericPetrusha.setEnabled(false);
					if (radioButton1.isSelected()) {
						petrushka_wash.setEnabled(true);
					}
				}

			}

		});
		panel.add(numericPetrusha);

		labelSalt = new JLabel("\u0421\u043E\u043B\u044C");
		labelSalt.setEnabled(false);
		labelSalt.setBounds(10, 244, 86, 14);
		panel.add(labelSalt);

		numericSalt = new JSpinner();
		numericSalt.setModel(new SpinnerNumberModel(0, null, 500, 50));
		numericSalt.setBounds(106, 241, 55, 20);
		numericSalt.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (salt == null)
					salt = new Salt();
				salt.setCount((int) numericSalt.getValue());
				if (salt.getCount() >= 100) {
					numericSalt.setEnabled(false);
					labelSalt.setEnabled(true);
					if (isReadyToMarinade()) {
						add_others.setEnabled(true);
					}
				}

			}

		});
		panel.add(numericSalt);

		labelCoal = new JLabel("\u0423\u0433\u043E\u043B\u044C");
		labelCoal.setEnabled(false);
		labelCoal.setBounds(10, 270, 86, 14);
		panel.add(labelCoal);

		numericCoal = new JSpinner();
		numericCoal.setModel(new SpinnerNumberModel(0, null, 10000, 500));
		numericCoal.setBounds(106, 267, 55, 20);
		numericCoal.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (coal == null)
					coal = new Coal();
				coal.setWeight((int) numericCoal.getValue());
				if (coal.getWeight() >= 2000) {
					numericCoal.setEnabled(false);
					labelCoal.setEnabled(true);
					add_coal.setEnabled(true);
				}

			}

		});
		panel.add(numericCoal);
		frame.getContentPane().setLayout(groupLayout);
	}

	private boolean isReadyToMarinade() {
		if (klukva == null) {
			return false;
		} else if (klukva.getHas_sredded() != 10) {
			return false;
		}

		if (gor_pepper == null) {
			return false;
		} else if (gor_pepper.isSredded()) {
			return false;
		}

		if (!pan.OilReady()) {
			return false;
		}

		if (black_pepper == null) {
			return false;
		} else if (black_pepper.getCount() != black_pepper.needCount()) {
			return false;
		}

		if (salt == null) {
			return false;
		} else if (salt.getCount() != salt.NeedCount()) {
			return false;
		}

		if (kvas == null) {
			return false;
		}
		if (kvas.getVolume() != kvas.NeedVolume()) {
			return false;
		}

		return true;
	}
}
