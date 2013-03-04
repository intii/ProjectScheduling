package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import java.awt.TextArea;
import javax.swing.JRadioButton;

import AlgorithmExecution.Executor;
import DataHandler.SolutionHandler;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorCompletionService;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.SwingConstants;



public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 745, 519);
		frame.getContentPane().add(tabbedPane);
		frame.getContentPane().add(tabbedPane);
		
		/*
		 * Options description
		 * 
		*/
		String[] ActivityMutatorList = {"A","B"};
		String[] ResourceMutatorList = {"A"};
		String[] ActivityCrosserList = {"A","B"};
		String[] ResourceCrosserList = {"A","B"};
		String[] ParentSelectorList = {"A","B"};
		String[] PopulationReplacerList = {"A","B","C"};
		
		
		JComponent panel1 = new JPanel(false);
		tabbedPane.addTab("Config", null,panel1,"Does nothing");
		JSeparator separator = new JSeparator();
		
		JLabel lblPopulationConfig = new JLabel("Population config");
		
		JLabel lblComponentsConfig = new JLabel("Mutator");
		
		JLabel lblPm = new JLabel("PM");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPc = new JLabel("PC");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblMutator = new JLabel("AMutator");
		JComboBox comboBox = new JComboBox(ActivityMutatorList);
		
		JLabel lblRmutator = new JLabel("RMutator");
		JComboBox comboBox_1 = new JComboBox(ResourceMutatorList);
		
		JLabel lblRcrosser = new JLabel("RCrosser");
		JComboBox comboBox_2 = new JComboBox(ResourceCrosserList);
		
		JLabel lblAcrosser = new JLabel("ACrosser");
		JComboBox comboBox_3 = new JComboBox(ActivityCrosserList);
		
		JLabel lblPselector = new JLabel("PSelector");
		JComboBox comboBox_4 = new JComboBox(ParentSelectorList);
		
		JLabel lblPreplacer = new JLabel("PReplacer");
		JComboBox comboBox_5 = new JComboBox(PopulationReplacerList);
		
		JRadioButton rdbtnMultiple = new JRadioButton("Multiple");
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		
		JLabel lblCrosser = new JLabel("Crosser");
		
		JLabel lblPopulators = new JLabel("Populators");
		
		JLabel lblFitnessCalculation = new JLabel("Fitness Calculation");
		
		JLabel lblCc = new JLabel("CC");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblCd = new JLabel("CD");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnRun = new JButton("Run -->");
		
		JSeparator separator_1 = new JSeparator();
		
		JSeparator separator_2 = new JSeparator();
		
		JSeparator separator_3 = new JSeparator();
		
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPopulationConfig)
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(lblPm)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblCc, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(lblPc)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblCd, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(504, Short.MAX_VALUE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(lblComponentsConfig)
							.addContainerGap(692, Short.MAX_VALUE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(rdbtnSingle)
							.addPreferredGap(ComponentPlacement.RELATED, 512, Short.MAX_VALUE)
							.addComponent(btnRun, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(86))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(rdbtnMultiple)
							.addContainerGap(669, Short.MAX_VALUE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(lblMutator)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(lblRmutator)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(lblPopulators)
							.addContainerGap(679, Short.MAX_VALUE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(lblPselector, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(lblPreplacer, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(427, Short.MAX_VALUE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(lblFitnessCalculation)
							.addContainerGap(641, Short.MAX_VALUE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCrosser)
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(lblAcrosser, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(52)
									.addComponent(lblRcrosser, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPopulationConfig)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPm)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPc)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(3)
									.addComponent(lblCc))
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(3)
									.addComponent(lblCd))
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblComponentsConfig)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMutator)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRmutator))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCrosser)
					.addGap(18)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAcrosser))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRcrosser))
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblPopulators)
					.addGap(18)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPselector)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPreplacer))
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(21)
							.addComponent(lblFitnessCalculation)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnMultiple)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnSingle)
							.addContainerGap())
						.addGroup(gl_panel1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addComponent(btnRun)
							.addGap(21))))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(334)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(143, Short.MAX_VALUE))
		);
		panel1.setLayout(gl_panel1);
		
		JComponent panel2 = new JPanel(false);
		panel2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Run", null,panel2,"Does nothing");
		tabbedPane.setForegroundAt(1, Color.BLACK);
		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[] {10, 580};
		gbl_panel2.rowHeights = new int[] {50, 100};
		gbl_panel2.columnWeights = new double[]{1.0};
		gbl_panel2.rowWeights = new double[]{1.0, 0.0};
		panel2.setLayout(gbl_panel2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel2.add(panel, gbc_panel);
		
		JLabel lblNOfAct = new JLabel("N. of Act :");
		lblNOfAct.setBounds(10, 35, 50, 14);
		lblNOfAct.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNOfAct);
		
		JLabel lblConfiguration = new JLabel("Configuration");
		lblConfiguration.setBounds(41, 0, 65, 14);
		panel.add(lblConfiguration);
		
		JLabel lblPm_1 = new JLabel("PM :");
		lblPm_1.setBounds(10, 60, 46, 14);
		panel.add(lblPm_1);
		
		JLabel lblPc_1 = new JLabel("PC : ");
		lblPc_1.setBounds(10, 85, 46, 14);
		panel.add(lblPc_1);
		
		JLabel lblCc_1 = new JLabel("CC : ");
		lblCc_1.setBounds(10, 110, 46, 14);
		panel.add(lblCc_1);
		
		JLabel lblNewLabel = new JLabel("CD : ");
		lblNewLabel.setBounds(10, 135, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblACrosser = new JLabel("A. Crosser :");
		lblACrosser.setBounds(10, 173, 65, 14);
		panel.add(lblACrosser);
		
		JLabel lblRCrosser = new JLabel("R. Crosser : ");
		lblRCrosser.setBounds(10, 200, 70, 14);
		panel.add(lblRCrosser);
		
		JLabel lblAMutator = new JLabel("A. Mutator :");
		lblAMutator.setBounds(10, 226, 65, 14);
		panel.add(lblAMutator);
		
		JLabel lblRMutator = new JLabel("R. Mutator : ");
		lblRMutator.setBounds(10, 252, 65, 14);
		panel.add(lblRMutator);
		
		JLabel lblPSelector = new JLabel("P. Selector :");
		lblPSelector.setBounds(10, 277, 65, 14);
		panel.add(lblPSelector);
		
		JLabel lblPReplacer = new JLabel("P. Replacer : ");
		lblPReplacer.setBounds(10, 301, 65, 14);
		panel.add(lblPReplacer);
		
		JLabel lblFitnessCalculator = new JLabel("Fitness Calculator : ");
		lblFitnessCalculator.setBounds(10, 326, 96, 14);
		panel.add(lblFitnessCalculator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel2.add(panel_1, gbc_panel_1);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(50, 18, 55, 23);
		panel_1.add(btnStop);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(50, 52, 55, 23);
		panel_1.add(btnBack);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel2.add(panel_2, gbc_panel_2);
		
		final JTextArea textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setRows(23);
		textArea.setColumns(50);
		textArea.setEditable(false); 
		panel_2.add(scroll);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel2.add(panel_3, gbc_panel_3);
		
		JButton btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.setBounds(481, 39, 89, 23);
		panel_3.add(btnNext);
		
		JComponent panel3 = new JPanel(false);
		tabbedPane.addTab("Analysis", null,panel3,"Does nothing");
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setEnabledAt(2, false);
		frame.getContentPane().add(tabbedPane);
		
		/*
		 * 
		 */
		final Document outputDoc = new DefaultStyledDocument();
		textArea.setDocument(outputDoc);
		
		/*
		 * Run button action listener
		 */
		btnRun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setSelectedIndex(1);
				SolutionHandler sh = new SolutionHandler(32, 103, 4);
				Executor exec = new Executor(sh);
				int[] options = {0,0,0,0,0,0};
				double[] configValues = {0.9,0.2,200,0.5};
				exec.setEnvironment(configValues, options,outputDoc);
				Thread thrd = new Thread(exec);
				thrd.start();
			}
		});
	}
}
