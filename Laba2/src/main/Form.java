package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.slf4j.*;

import components.*;
import train.ITransport;

public class Form {

	private Depo depo;

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

	private JFileChooser fileChooser;

	public static Logger logger;

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
		logger = LoggerFactory.getLogger(Form.class);
		listBoxLevels.setSelectedIndex(depo.getCurrentLevel());
	}

	private void buttonGet_Click() {
		if (listBoxLevels.getSelectedIndex() < 0) {
			return;
		}
		try {
			int place = Integer.parseInt(formattedTextField.getText());
			ITransport loc = depo.GetLocInDepo(place);

			Graphics2D g = (Graphics2D) returnPanel.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, returnPanel.getWidth(), returnPanel.getHeight());
			if (loc != null) {
				loc.setPosition(returnPanel.getWidth() >> 1, returnPanel.getHeight() >> 1);
				Rotate.imageRotate(g, loc.Pict(), 0, loc.Center());
			}
			panel.repaint();
			logger.info("Выдан объект класса " + loc.getClass().getName() + " с уровня " + depo.getCurrentLevel()
					+ " места " + place);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Неверный номер");
		} catch (DepoIndexOutOfRangeException ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}

	}

	private void order_Click() {
		FormSelectLoc dialog = new FormSelectLoc(new LocCallBack() {
			@Override
			public void takeLoc(ITransport loc) {
				try {
					int place = depo.PutLocInDepo(loc);
					panel.repaint();
					JOptionPane.showMessageDialog(frame, "Ваше место " + place);
					logger.info("Добавлен новый объект класса " + loc.getClass().getName() + " на уровень "
							+ depo.getCurrentLevel() + " место " + place);
				} catch (DepoOverflowException ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage());
				}
			}
		});
		logger.info("Открытие окна заказа локомотива");
	}

	private void SaveActionPerformed() {
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

			if (depo.SaveData(getPath())) {
				JOptionPane.showMessageDialog(frame, "save successfully");
				logger.info("Запись в файл "+getPath());
			} else {
				JOptionPane.showMessageDialog(frame, "preservation failed");
				logger.info("Провалена запись в файл "+getPath());
			}
		}
	}

	private void OpenActionPerformed() {
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (depo.LoadData(fileChooser.getSelectedFile())) {
				JOptionPane.showMessageDialog(frame, "loaded");
				logger.info("Загрузка из файла "+fileChooser.getSelectedFile());
			} else {
				JOptionPane.showMessageDialog(frame, "haven't uploaded");
				logger.info("Провалена загрузка из файла "+fileChooser.getSelectedFile());
			}
		}
		panel.repaint();
	}

	private File getPath() {
		String path = fileChooser.getSelectedFile().getAbsolutePath();
		String extension = "." + ((FileNameExtensionFilter) fileChooser.getFileFilter()).getExtensions()[0];
		if (path.contains(extension)) {
			path = path.substring(0, path.indexOf(extension));
		}
		return new File(path + extension);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 606, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelGet = new JPanel();
		panelGet.setBounds(419, 153, 159, 294);
		panelGet.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGet.setToolTipText("");
		panelGet.setLayout(null);

		lblNewLabel_1 = new JLabel("Забрать локомотив");
		lblNewLabel_1.setBounds(10, 5, 139, 14);
		panelGet.add(lblNewLabel_1);

		returnPanel = new JPanel();
		returnPanel.setBackground(Color.WHITE);
		returnPanel.setBounds(10, 94, 139, 189);
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
		panel_1.setBounds(419, 11, 159, 140);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\u0423\u0440\u043E\u0432\u043D\u0438:");
		lblNewLabel_2.setBounds(59, 5, 62, 14);
		panel_1.add(lblNewLabel_2);

		String[] elements = new String[5];
		for (int i = 0; i < 5; i++) {
			elements[i] = "Level" + (i + 1);
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
				logger.info("Переход на новый уровень. Текущий уровень "+depo.getCurrentLevel());
			}

		});
		panel_1.add(listBoxLevels);

		panel = new MainPanel(depo, listBoxLevels);
		panel.setBounds(10, 11, 399, 382);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);

		orderLoc = new JButton(
				"<html>\u0417\u0430\u043A\u0430\u0437\u0430\u0442\u044C \u043B\u043E\u043A\u043E\u043C\u043E\u0442\u0438\u0432</html>");
		orderLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order_Click();
			}
		});
		orderLoc.setBounds(246, 404, 163, 32);

		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		String path = System.getProperty("java.class.path");
		String FileSeparator = (String) System.getProperty("file.separator");
		fileChooser.setCurrentDirectory(new File(path.substring(0, path.lastIndexOf(FileSeparator) + 1)));

		JMenuBar menuBar = new JMenuBar();

		Font font = new Font("Verdana", Font.PLAIN, 11);
		JMenu fileMenu = new JMenu("Menu");
		fileMenu.setFont(font);
		JMenuItem Save = new JMenuItem("Save");
		Save.setFont(font);
		fileMenu.add(Save);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveActionPerformed();
			}
		});

		JMenuItem Load = new JMenuItem("Open");
		Load.setFont(font);
		fileMenu.add(Load);
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenActionPerformed();
			}
		});
		menuBar.add(fileMenu);

		frame.setJMenuBar(menuBar);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(orderLoc);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panelGet);
		frame.getContentPane().add(panel_1);
	}
}
