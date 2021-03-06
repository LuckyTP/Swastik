import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import jxl.Workbook;
import java.io.File;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Start extends JFrame {

	private JPanel contentPane;
	private JTextField OrganisationText;
	private JTextField DisplayNameText;
	private JTextField EmailText;
	private JTextField UsernameText;
	private JPasswordField PasswordText;
	private JPasswordField ConfirmText;
	private JPanel Basic_Information;
	private JPanel Management_Scales;
	private JPanel Acceptance_Criteria; 
	private JPanel FourTControls;
	private JPanel Control_Set_Selection;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private static int state =1;      
	private JComboBox<String> Formula ;
	private JPanel RiskCalculator;
	private Border border;
	private JSpinner CL;
	private JSpinner II;
	private JSpinner IL;
	private JSpinner AI;
	private JSpinner AL;
	private int FormulaToRisk;
	private JSpinner CI;
	private JButton DownloadExcel;
	private JSlider LikeHood;
	private JSlider Impact_1;
	private int row=1;
	private JTextArea textArea;
	private JLabel BasicInfoLabel;
	private JLabel CSSLabel;
	private JLabel MSLabel;
	private JLabel ACLabel;
	private JLabel FTCLabel;
	private JLabel TRTLabel;
	private JLabel lblImpact_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JPanel Treat;
	private JLabel RBCLabel;
	private JButton btnCreateExcel;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	/* *
	 * state value for page direction 
	 * 1 ==> Basic Information
	 * 2 ==> Control set selection
	 * 3 ==> Management scales
	 * 4 ==> AAcceptance criteria
	 * 
	 * FormulaToRisk
	 * 0==>L+I
	 * 1==>L-I
	 * 2==>L+I-1
	 * 3==>L-I-1
	 * 4==>L*I
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		border = BorderFactory.createLineBorder(Color.black, 1, true);
		
		Control_Set_Selection = new JPanel();
		Control_Set_Selection.setBackground(Color.WHITE);
		Control_Set_Selection.setVisible(false);
		
		Basic_Information = new JPanel();
		Basic_Information.setBackground(Color.WHITE);
		Basic_Information.setBounds(264, 0, 720, 513);
		Basic_Information.setVisible(true);
		
		Management_Scales = new JPanel();
		Management_Scales.setBackground(Color.WHITE);
		Management_Scales.setVisible(false);
		
		FourTControls = new JPanel();
		FourTControls.setBackground(Color.WHITE);
		FourTControls.setVisible(false);
		
		Acceptance_Criteria = new JPanel();
		Acceptance_Criteria.setBackground(Color.WHITE);
		Acceptance_Criteria.setVisible(false);
		
		Treat = new JPanel();
		Treat.setBackground(Color.WHITE);
		Treat.setBounds(264, 0, 720, 513);
		contentPane.add(Treat);
		Treat.setLayout(null);
		Treat.setVisible(false);
		
		JLabel lblTreat = new JLabel("Treat");
		lblTreat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTreat.setBounds(36, 11, 107, 33);
		Treat.add(lblTreat);
		
		JLabel label_16 = new JLabel("Risk");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_16.setBounds(44, 54, 73, 22);
		Treat.add(label_16);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 437, 309, 65);
		Treat.add(textField_1);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(153, 54, 508, 22);
		Treat.add(comboBox_2);

		
		
		comboBox_2.addItem("Hardware: Breach of information system maintainability caused by insufficient maintenance of storage media.");
		comboBox_2.addItem("Hardware: Destruction of equipment or media caused by lack of periodic replacement schemes.");
		comboBox_2.addItem("Hardware: Dust, corrosion, freezing caused by susceptibility to humidity, dust, soiling.");
		comboBox_2.addItem("Hardware: Electromagnetic radiation caused by sensitivity to electromagnetic radiation.");
		comboBox_2.addItem("Hardware: Error in use caused by lack of efficient configuration change control.");
		
		
		
		comboBox_2.addItem("Software: Abuse of rights caused by lack of audit trail.");
		comboBox_2.addItem("Software: Error in use caused by complicated user interface.");
		comboBox_2.addItem("Software: Corruption of data caused by widely distributed software.");
		comboBox_2.addItem("Software: Error in use caused by lack of documentation.");
		comboBox_2.addItem("Software: Error in use caused by incorrect dates.");
		
		
		comboBox_2.addItem("Network: Denial of actions caused by lack of proof of sending or receiving a message.");
		comboBox_2.addItem("Network: Evesdropping caused by unprotected communication lines.");
		comboBox_2.addItem("Network: Evesdropping caused by unprotected sensitive traffic.");
		comboBox_2.addItem("Network: Remotes spying caused by insecured network architecture.");
		comboBox_2.addItem("Network: Failure of tele-communication equipment caused by poor joint cabling.");
		

comboBox_2.addItem("Personnel: Error in use caused by lack of security awareness.");
comboBox_2.addItem("Personnel: Theft of media caused by unsupervised work by outside or cleaning staff.");
comboBox_2.addItem("Personnel: Illegal processing of data caused by lack of monitoring mechanisms.");


comboBox_2.addItem("Site: Flood caused by location in an area susceptible to flood.");
comboBox_2.addItem("Site: Loss of power supply caused by unstable power grid.");
comboBox_2.addItem("Site: Theft of equipment caused by lack of physical protection of the building, doors and windows.");



comboBox_2.addItem("Organization: Abuse of rights caused by lack of regular audits.");
comboBox_2.addItem("Organization: Abuse of rights caused by lack of procedure of monitoring of information processing facilities.");
comboBox_2.addItem("Organization: Abuse of rights caused by lack of formal procedure for user registration and de-registration.");
comboBox_2.addItem("Organization: Abuse of rights caused by lack of formal process for access right review.");
comboBox_2.addItem("Organization: Unauthorized use of equipment caused by lack of regular management reviews.");
		
		JLabel label_20 = new JLabel("Compromises");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_20.setBounds(35, 168, 154, 22);
		Treat.add(label_20);
		
		JLabel label_21 = new JLabel("Risk Rating     =");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_21.setBounds(44, 378, 145, 22);
		Treat.add(label_21);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(border);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(216, 159, 309, 186);
		Treat.add(panel_7);
		
		JLabel label_22 = new JLabel("C");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBorder(border);
		label_22.setBounds(31, 11, 55, 43);
		panel_7.add(label_22);
		
		JLabel label_23 = new JLabel("I");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBorder(border);
		label_23.setBounds(135, 11, 55, 43);
		panel_7.add(label_23);
		
		JLabel label_24 = new JLabel("A");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setBorder(border);
		label_24.setBounds(231, 11, 55, 43);
		panel_7.add(label_24);
		
		JCheckBox checkBox_3 = new JCheckBox("New check box");
		checkBox_3.setVerticalAlignment(SwingConstants.TOP);
		checkBox_3.setBounds(48, 61, 21, 23);
		panel_7.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("New check box");
		checkBox_4.setVerticalAlignment(SwingConstants.TOP);
		checkBox_4.setBounds(152, 60, 21, 23);
		panel_7.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("New check box");
		checkBox_5.setVerticalAlignment(SwingConstants.TOP);
		checkBox_5.setBounds(248, 61, 21, 23);
		panel_7.add(checkBox_5);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner.setBackground(Color.WHITE);
		spinner.setBounds(48, 111, 38, 20);
		panel_7.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_1.setBackground(Color.WHITE);
		spinner_1.setBounds(47, 147, 39, 20);
		panel_7.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_2.setBackground(Color.WHITE);
		spinner_2.setBounds(151, 111, 39, 20);
		panel_7.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_3.setBackground(Color.WHITE);
		spinner_3.setBounds(150, 147, 40, 20);
		panel_7.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_4.setBackground(Color.WHITE);
		spinner_4.setBounds(248, 111, 38, 20);
		panel_7.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_5.setBackground(Color.WHITE);
		spinner_5.setBounds(247, 147, 39, 20);
		panel_7.add(spinner_5);
		
		JLabel label_25 = new JLabel("I");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_25.setBounds(10, 113, 22, 14);
		panel_7.add(label_25);
		
		JLabel label_26 = new JLabel("L");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_26.setBounds(10, 150, 22, 14);
		panel_7.add(label_26);
		
		JLabel label_29 = new JLabel("Comment");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_29.setBorder(border);
		label_29.setBounds(27, 437, 127, 20);
		Treat.add(label_29);
		
		JLabel label_27 = new JLabel("");
		label_27.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_27.setBounds(176, 378, 117, 22);
		Treat.add(label_27);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(154, 87, 451, 29);
		Treat.add(comboBox_1);
		comboBox_1.addItem("(A.5.1.1)Information security policy document");
		comboBox_1.addItem("(A.5.1.2)Review of the information security policy");
		comboBox_1.addItem("(A.6.1.1)Management commitment to information security");
		comboBox_1.addItem("(A.6.1.2)Information security coordination");
		comboBox_1.addItem("(A.6.1.3)Allocation of information security responsibilities");
		comboBox_1.addItem("(A.6.1.4)Authorization process for information processing facilities");
		comboBox_1.addItem("(A.6.1.5)Confidentiality agreements");
		comboBox_1.addItem("(A.6.1.6)Contact with authorities");
		comboBox_1.addItem("(A.6.1.7)Contact with special interest groups");
		comboBox_1.addItem("(A.6.1.8)Independent review of information security");
		comboBox_1.addItem("(A.6.1.9)Identification of risks related to external parties");
		
		JLabel label_28 = new JLabel("Control");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_28.setBounds(12, 94, 105, 29);
		Treat.add(label_28);
		
		btnCreateExcel = new JButton("Create Excel");
		btnCreateExcel.setVisible(false);
		btnCreateExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateExcel();
			}
		});
		btnCreateExcel.setBorder(border);
		btnCreateExcel.setBackground(Color.WHITE);
		btnCreateExcel.setBounds(545, 243, 129, 49);
		Treat.add(btnCreateExcel);
		
		JButton button_5 = new JButton("Calculate");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!checkBox_3.isSelected()&&!checkBox_4.isSelected()&&!checkBox_5.isSelected()) {
					JOptionPane.showMessageDialog(contentPane,"Please Select anyone of Compromises");
				}else {
					int Risk = RiskCal();
					label_27.setText(String.valueOf(Risk));
					btnCreateExcel.setVisible(true);
				}
			}
			private int RiskCal() {
				int sum=0;
				int flag=0;
				if(checkBox_3.isSelected()) {
					sum+= Calculate((int)CI.getValue(),(int)CL.getValue());
					flag++;
			//		System.out.println(sum);
				}
				if(checkBox_4.isSelected()) {
					sum+= Calculate((int)II.getValue(),(int)IL.getValue());
					flag++;
			//		System.out.println(sum);
				}
				if(checkBox_5.isSelected()) {
					sum+= Calculate((int)AI.getValue(),(int)AL.getValue());
					flag++;
					//System.out.println(sum);
				}
				return sum/flag;
			}
		});
		button_5.setBounds(545, 183, 129, 49);
		Treat.add(button_5);
		button_5.setBorder(border);
		button_5.setBackground(Color.WHITE);
		

		RiskCalculator = new JPanel();
		RiskCalculator.setBackground(Color.WHITE);
		RiskCalculator.setBounds(264, 0, 720, 513);
		contentPane.add(RiskCalculator);
		RiskCalculator.setVisible(false);
		RiskCalculator.setLayout(null);
		
		JLabel label_18 = new JLabel("Risk Details");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_18.setBounds(55, 33, 162, 33);
		RiskCalculator.add(label_18);
		
		JLabel lblRisk = new JLabel("Risk");
		lblRisk.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRisk.setBounds(55, 89, 73, 22);
		RiskCalculator.add(lblRisk);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(138, 90, 508, 22);
		
		comboBox.addItem("Hardware: Breach of information system maintainability caused by insufficient maintenance of storage media.");
		comboBox.addItem("Hardware: Destruction of equipment or media caused by lack of periodic replacement schemes.");
		comboBox.addItem("Hardware: Dust, corrosion, freezing caused by susceptibility to humidity, dust, soiling.");
		comboBox.addItem("Hardware: Electromagnetic radiation caused by sensitivity to electromagnetic radiation.");
		comboBox.addItem("Hardware: Error in use caused by lack of efficient configuration change control.");
		
		
		
		comboBox.addItem("Software: Abuse of rights caused by lack of audit trail.");
		comboBox.addItem("Software: Error in use caused by complicated user interface.");
		comboBox.addItem("Software: Corruption of data caused by widely distributed software.");
		comboBox.addItem("Software: Error in use caused by lack of documentation.");
		comboBox.addItem("Software: Error in use caused by incorrect dates.");
		
		
		comboBox.addItem("Network: Denial of actions caused by lack of proof of sending or receiving a message.");
		comboBox.addItem("Network: Evesdropping caused by unprotected communication lines.");
		comboBox.addItem("Network: Evesdropping caused by unprotected sensitive traffic.");
		comboBox.addItem("Network: Remotes spying caused by insecured network architecture.");
		comboBox.addItem("Network: Failure of tele-communication equipment caused by poor joint cabling.");
		

comboBox.addItem("Personnel: Error in use caused by lack of security awareness.");
comboBox.addItem("Personnel: Theft of media caused by unsupervised work by outside or cleaning staff.");
comboBox.addItem("Personnel: Illegal processing of data caused by lack of monitoring mechanisms.");


comboBox.addItem("Site: Flood caused by location in an area susceptible to flood.");
comboBox.addItem("Site: Loss of power supply caused by unstable power grid.");
comboBox.addItem("Site: Theft of equipment caused by lack of physical protection of the building, doors and windows.");



comboBox.addItem("Organization: Abuse of rights caused by lack of regular audits.");
comboBox.addItem("Organization: Abuse of rights caused by lack of procedure of monitoring of information processing facilities.");
comboBox.addItem("Organization: Abuse of rights caused by lack of formal procedure for user registration and de-registration.");
comboBox.addItem("Organization: Abuse of rights caused by lack of formal process for access right review.");
comboBox.addItem("Organization: Unauthorized use of equipment caused by lack of regular management reviews.");

		
		RiskCalculator.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Compromises");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(55, 194, 135, 22);
		RiskCalculator.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(border);
		panel_4.setBounds(200, 179, 309, 186);
		RiskCalculator.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblC = new JLabel("C");
		lblC.setBorder(border);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBounds(31, 11, 55, 43);
		panel_4.add(lblC);
		
		JLabel lblI_1 = new JLabel("I");
		lblI_1.setBorder(border);
		lblI_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblI_1.setBounds(135, 11, 55, 43);
		panel_4.add(lblI_1);
		
		JLabel lblA = new JLabel("A");
		lblA.setBorder(border);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(231, 11, 55, 43);
		panel_4.add(lblA);
		
		JCheckBox Check_C = new JCheckBox("New check box");
		Check_C.setVerticalAlignment(SwingConstants.TOP);
		Check_C.setBounds(48, 61, 21, 23);
		panel_4.add(Check_C);
		
		JCheckBox Check_I = new JCheckBox("New check box");
		Check_I.setVerticalAlignment(SwingConstants.TOP);
		Check_I.setBounds(152, 60, 21, 23);
		panel_4.add(Check_I);
		
		JCheckBox Check_A = new JCheckBox("New check box");
		Check_A.setVerticalAlignment(SwingConstants.TOP);
		Check_A.setBounds(248, 61, 21, 23);
		panel_4.add(Check_A);
		
		CI = new JSpinner();
		CI.setBackground(Color.WHITE);
		CI.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		CI.setBounds(48, 111, 38, 20);
		panel_4.add(CI);
		
		CL = new JSpinner();
		CL.setBackground(Color.WHITE);
		CL.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		CL.setBounds(47, 147, 39, 20);
		panel_4.add(CL);
		
		II = new JSpinner();
		II.setBackground(Color.WHITE);
		
			II.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			II.setBounds(151, 111, 39, 20);
			panel_4.add(II);
			
			IL = new JSpinner();
			IL.setBackground(Color.WHITE);
			IL.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			IL.setBounds(150, 147, 40, 20);
			panel_4.add(IL);
			
			AI = new JSpinner();
			AI.setBackground(Color.WHITE);
			AI.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			AI.setBounds(248, 111, 38, 20);
			panel_4.add(AI);
			
			AL = new JSpinner();
			AL.setBackground(Color.WHITE);
			AL.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			AL.setBounds(247, 147, 39, 20);
			panel_4.add(AL);
			
			JLabel lblI = new JLabel("I");
			lblI.setBounds(10, 113, 22, 14);
			panel_4.add(lblI);
			lblI.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblI.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblL = new JLabel("L");
			lblL.setHorizontalAlignment(SwingConstants.CENTER);
			lblL.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblL.setBounds(10, 150, 22, 14);
			panel_4.add(lblL);
			
			JLabel RiskRatingLabel = new JLabel("Risk Rating     =");
			RiskRatingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			RiskRatingLabel.setBounds(55, 438, 141, 22);
			RiskCalculator.add(RiskRatingLabel);
			
			JLabel RiskRatingText = new JLabel("");
			RiskRatingText.setFont(new Font("Tahoma", Font.BOLD, 15));
			RiskRatingText.setBounds(209, 438, 117, 22);
			RiskCalculator.add(RiskRatingText);
			
			JButton btnCalculate = new JButton("Calculate");
			btnCalculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!Check_C.isSelected()&&!Check_I.isSelected()&&!Check_A.isSelected()) {
						JOptionPane.showMessageDialog(contentPane,"Please Select anyone of Compromises");
					}else {
						int Risk = RiskCal();
						RiskRatingText.setText(String.valueOf(Risk));
//						DownloadExcel.setVisible(true);
						button_2.setEnabled(true);
					}
				}

				private int RiskCal() {
					int sum=0;
					int flag=0;
					if(Check_C.isSelected()) {
						sum+= Calculate((int)CI.getValue(),(int)CL.getValue());
						flag++;
				//		System.out.println(sum);
					}
					if(Check_I.isSelected()) {
						sum+= Calculate((int)II.getValue(),(int)IL.getValue());
						flag++;
				//		System.out.println(sum);
					}
					if(Check_A.isSelected()) {
						sum+= Calculate((int)AI.getValue(),(int)AL.getValue());
						flag++;
						//System.out.println(sum);
					}
					return sum/flag;
				}
			});
			btnCalculate.setBackground(Color.WHITE);
			btnCalculate.setBorder(border);
			btnCalculate.setBounds(517, 194, 129, 49);
			RiskCalculator.add(btnCalculate);
			
			DownloadExcel = new JButton("CreateExcel");
			DownloadExcel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//	JFileChooser jf = new JFileChooser();
					//jf.showOpenDialog(contentPane);
//					GenerateExcel();
				}

			});
			DownloadExcel.setBorder(border);
			DownloadExcel.setVisible(false);
			DownloadExcel.setBackground(Color.WHITE);
			DownloadExcel.setBounds(517, 291, 129, 49);
			RiskCalculator.add(DownloadExcel);
		Acceptance_Criteria.setBounds(264, 2, 720, 513);
		contentPane.add(Acceptance_Criteria);
		Acceptance_Criteria.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(34, 39, 651, 395);
		Acceptance_Criteria.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(338, 40, 14, 14);
		panel_3.add(panel_2);
		panel_2.setBackground(Color.YELLOW);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(199, 320, 14, 14);
		panel_3.add(panel_5);
		panel_5.setBackground(Color.RED);
		
		lblImpact_1 = new JLabel("Impact");
		lblImpact_1.setBounds(218, 320, 91, 14);
		panel_3.add(lblImpact_1);
		lblImpact_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_3 = new JLabel("Likelihood");
		lblNewLabel_3.setBounds(366, 40, 123, 14);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		FourTControls.setBounds(264, 2, 720, 513);
		contentPane.add(FourTControls);
		FourTControls.setLayout(null);
		
		
		JButton btnTreat = new JButton("TREAT");
		btnTreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state+=1;
				MoveTo(state);
			}
		});
		btnTreat.setBackground(Color.WHITE);
		btnTreat.setBorder(border);
		btnTreat.setBounds(170, 150, 174, 83);
		FourTControls.add(btnTreat);
		
		JButton btnTolerate = new JButton("TOLERATE");
		btnTolerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(contentPane, "Comment","Tolerate",1);
			}
		});
		btnTolerate.setBackground(Color.WHITE);
		btnTolerate.setBorder(border);
		btnTolerate.setBounds(354, 150, 174, 83);
		FourTControls.add(btnTolerate);
		
		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(contentPane, "Comment","Transfer",2);
			}
		});
		btnTransfer.setBackground(Color.WHITE);
		btnTransfer.setBorder(border);
		btnTransfer.setBounds(170, 244, 174, 83);
		FourTControls.add(btnTransfer);
		
		JButton btnTerminate = new JButton("TERMINATE");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(contentPane, "Comment","Terminate",3);
			}
		});
		btnTerminate.setBackground(Color.WHITE);
		btnTerminate.setBorder(border);
		btnTerminate.setBounds(354, 244, 174, 83);
		FourTControls.add(btnTerminate);
		
		JLabel lblNewLabel_1 = new JLabel("4T Controls");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(170, 103, 356, 36);
		FourTControls.add(lblNewLabel_1);
		
		Management_Scales.setBounds(264, 0, 720, 513);
		contentPane.add(Management_Scales);
		Management_Scales.setLayout(null);
		
		JLabel lblManagementScales = new JLabel("Management Scales");
		lblManagementScales.setBounds(23, 11, 154, 28);
		Management_Scales.add(lblManagementScales);
		
		JLabel lblLikelihood = new JLabel("Likelihood");
		lblLikelihood.setBounds(23, 60, 154, 28);
		Management_Scales.add(lblLikelihood);
		
		JLabel lblImpact = new JLabel("Impact");
		lblImpact.setBounds(23, 257, 154, 28);
		Management_Scales.add(lblImpact);
		
		JLabel label_2 = new JLabel("1");
		label_2.setBounds(171, 144, 15, 14);
		Management_Scales.add(label_2);
		
		JLabel label_3 = new JLabel("2");
		label_3.setBounds(279, 144, 15, 14);
		Management_Scales.add(label_3);
		
		JLabel label_4 = new JLabel("3");
		label_4.setBounds(392, 144, 15, 14);
		Management_Scales.add(label_4);
		
		JLabel label_5 = new JLabel("4");
		label_5.setBounds(502, 144, 15, 14);
		Management_Scales.add(label_5);
		
		JLabel label_9 = new JLabel("5");
		label_9.setBounds(610, 142, 15, 14);
		Management_Scales.add(label_9);
		
		JLabel label_10 = new JLabel("1");
		label_10.setBounds(171, 334, 15, 14);
		Management_Scales.add(label_10);
		
		JLabel label_11 = new JLabel("2");
		label_11.setBounds(279, 334, 15, 14);
		Management_Scales.add(label_11);
		
		JLabel label_12 = new JLabel("3");
		label_12.setBounds(392, 334, 15, 14);
		Management_Scales.add(label_12);
		
		JLabel label_13 = new JLabel("4");
		label_13.setBounds(502, 334, 15, 14);
		Management_Scales.add(label_13);
		
		JLabel label_14 = new JLabel("5");
		label_14.setBounds(610, 332, 15, 14);
		Management_Scales.add(label_14);
		
		LikeHood = new JSlider();
		LikeHood.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(LikeHood.getValue()<=12) {
					LikeHood.setValue(0);
					
				}else if(LikeHood.getValue()>12&&LikeHood.getValue()<37)
				{
					LikeHood.setValue(25);
				}
				else if(LikeHood.getValue()>32&&LikeHood.getValue()<62){
					LikeHood.setValue(50);
				}
				else if(LikeHood.getValue()>62&&LikeHood.getValue()<87){
					LikeHood.setValue(75);
				}else {
					LikeHood.setValue(100);
				}
			}
		});
		LikeHood.setBackground(Color.WHITE);
		LikeHood.setValue(75);
		LikeHood.setOpaque(true);
		LikeHood.setBounds(171, 107, 446, 26);
		Management_Scales.add(LikeHood);
		
		Impact_1 = new JSlider();
		Impact_1.setBackground(Color.WHITE);
		Impact_1.setBounds(171, 297, 446, 26);
		Impact_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Impact_1.getValue()<=12) {
					Impact_1.setValue(0);
					
				}else if(Impact_1.getValue()>12&&Impact_1.getValue()<37)
				{
					Impact_1.setValue(25);
				}
				else if(Impact_1.getValue()>32&&Impact_1.getValue()<62){
					Impact_1.setValue(50);
				}
				else if(Impact_1.getValue()>62&&Impact_1.getValue()<87){
					Impact_1.setValue(75);
				}else {
					Impact_1.setValue(100);
				}
			}
		});
		Management_Scales.add(Impact_1);
		
		JLabel lblOperational = new JLabel("Operational");
		lblOperational.setBounds(48, 421, 71, 14);
		Management_Scales.add(lblOperational);
		
		Formula = new JComboBox<String>();
		Formula.setBounds(155, 418, 161, 20);
		Formula.addItem(new String("Likelihood+Impact"));
		Formula.addItem(new String("Likelihood-Impact"));
		Formula.addItem(new String("Likelihood+Impact-1"));
		Formula.addItem(new String("Likelihood-Impact-1"));
		Formula.addItem(new String("Likelihood*Impact"));
		Management_Scales.add(Formula);
		contentPane.add(Basic_Information);
		Basic_Information.setLayout(null);
		
		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setBounds(58, 11, 205, 38);
		Basic_Information.add(lblBasicInformation);
		
		JLabel lblSoLets = new JLabel("So, let's configure vsRisk!");
		lblSoLets.setBounds(58, 50, 205, 38);
		Basic_Information.add(lblSoLets);
		
		JLabel label_1 = new JLabel("First, we need a few basic details.");
		label_1.setBounds(58, 88, 205, 38);
		Basic_Information.add(label_1);
		
		JLabel OrganisationLabel = new JLabel("Organisation:");
		OrganisationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		OrganisationLabel.setBounds(128, 148, 86, 31);
		Basic_Information.add(OrganisationLabel);
		
		OrganisationText = new JTextField();
		OrganisationText.setBounds(214, 152, 189, 20);
		Basic_Information.add(OrganisationText);
		OrganisationText.setColumns(10);
		
		JLabel DisplayNameLabel = new JLabel("Display Name:");
		DisplayNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		DisplayNameLabel.setBounds(128, 190, 86, 31);
		Basic_Information.add(DisplayNameLabel);
		
		DisplayNameText = new JTextField();
		DisplayNameText.setColumns(10);
		DisplayNameText.setBounds(214, 194, 189, 20);
		Basic_Information.add(DisplayNameText);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EmailLabel.setBounds(128, 232, 86, 31);
		Basic_Information.add(EmailLabel);
		
		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(214, 236, 189, 20);
		Basic_Information.add(EmailText);
		
		JLabel UsernameLabel = new JLabel("Username:");
		UsernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		UsernameLabel.setBounds(128, 268, 86, 31);
		Basic_Information.add(UsernameLabel);
		
		UsernameText = new JTextField();
		UsernameText.setColumns(10);
		UsernameText.setBounds(214, 272, 189, 20);
		Basic_Information.add(UsernameText);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PasswordLabel.setBounds(128, 306, 86, 31);
		Basic_Information.add(PasswordLabel);
		
		PasswordText = new JPasswordField();
		PasswordText.setColumns(10);
		PasswordText.setBounds(214, 310, 189, 20);
		Basic_Information.add(PasswordText);
		
		JLabel ConfrimLabel = new JLabel("Confirm:");
		ConfrimLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ConfrimLabel.setBounds(128, 348, 86, 31);
		Basic_Information.add(ConfrimLabel);
		
		ConfirmText = new JPasswordField();
		ConfirmText.setColumns(10);
		ConfirmText.setBounds(214, 352, 189, 20);
		Basic_Information.add(ConfirmText);
		
		
		Control_Set_Selection.setBounds(264, 0, 720, 513);
		contentPane.add(Control_Set_Selection);
		Control_Set_Selection.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Please tick the control sets you wish to use during the risk assessment (more than one can be selected):");
		lblNewLabel_2.setBounds(71, 21, 568, 30);
		Control_Set_Selection.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ISO 27001:2005");
		chckbxNewCheckBox.setBounds(256, 78, 131, 23);
		Control_Set_Selection.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("ISO 27001:2013");
		checkBox.setBounds(256, 116, 131, 23);
		checkBox.setSelected(true);
		Control_Set_Selection.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("ISO 27001:2012");
		checkBox_1.setBounds(256, 155, 131, 23);
		Control_Set_Selection.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("NIST 800-53");
		checkBox_2.setBounds(256, 199, 131, 23);
		Control_Set_Selection.add(checkBox_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 263, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configuration");
		lblNewLabel.setBounds(0, 0, 263, 50);
		panel.add(lblNewLabel);
		
		BasicInfoLabel = new JLabel("Basic Information");
		BasicInfoLabel.setForeground(Color.WHITE);
		BasicInfoLabel.setBounds(76, 270, 127, 27);
		panel.add(BasicInfoLabel);
		
		CSSLabel = new JLabel("Control Set selection");
		CSSLabel.setBounds(76, 308, 127, 27);
		panel.add(CSSLabel);
		
		MSLabel = new JLabel("Management scales");
		MSLabel.setBounds(76, 346, 127, 27);
		panel.add(MSLabel);
		
		ACLabel = new JLabel("Acceptance criteria");
		ACLabel.setBounds(76, 380, 127, 27);
		panel.add(ACLabel);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(0, 47, 263, 114);
		textArea.setText("Before you can undertake your assessment"
				+ " \nyou will need to perform some basic\n"
				+ "configuration steps. Please follow this "
				+ "\nwizard to configure the assessment.");
		panel.add(textArea);
		
		FTCLabel = new JLabel("4TControls");
		FTCLabel.setBounds(76, 448, 127, 27);
		panel.add(FTCLabel);
		
		TRTLabel = new JLabel("Treat");
		TRTLabel.setBounds(76, 486, 127, 27);
		panel.add(TRTLabel);
		
		RBCLabel = new JLabel("Risk Calculator");
		RBCLabel.setBounds(76, 414, 127, 27);
		panel.add(RBCLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(264, 514, 720, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state =1 ;
				MoveTo(1);
				Referesh();
			}
		});
		button.setBounds(10, 5, 103, 23);
		button.setBackground(Color.WHITE);
		panel_1.add(button);
		
		button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state-=1;
				MoveTo(state);
			}
		});
		button_1.setBounds(150, 5, 103, 23);
		button_1.setEnabled(false);
		button_1.setBackground(Color.WHITE);
		panel_1.add(button_1);
		
		 button_2 = new JButton("Next");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(state ==1) {

					if(OrganisationText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Organisation Name");
					}else if(DisplayNameText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Display Name");
					}else if(EmailText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Email Address");
					}else if(UsernameText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Username");
					}else if(PasswordText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Password");
					}else if(ConfirmText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Confirm your Password");
					}else if(ConfirmText.getText().equals(PasswordText.getText())){
						
						state=2;
						MoveTo(state);
						
					}else {
						ConfirmText.setText("");
						JOptionPane.showMessageDialog(Basic_Information, "Please check your password");
					}
				}
				else if(state==3){
					state+=1;
					MoveTo(state);
					int Likelihood = Calculate(LikeHood.getValue()/25+1,Impact_1.getValue()/25+1);
					
					MyComponent myComponent = new MyComponent(Likelihood);
					myComponent.setBounds(10, 5, 400, 400);
					panel_3.add(myComponent);
				}else{
					state+=1;
					MoveTo(state);
				}
				
			}
		});
		button_2.setBounds(313, 5, 110, 23);
		button_2.setBackground(Color.WHITE);
		panel_1.add(button_2);
		
		button_3 = new JButton("Finish");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setBounds(593, 5, 89, 23);
		button_3.setEnabled(false);
		button_3.setBackground(Color.WHITE);
		panel_1.add(button_3);
		
	}
	private void GenerateExcel() {
		String filename = "RiskData.xls";
		try {
			WritableWorkbook ww = Workbook.createWorkbook(new File(filename));
			WritableSheet sh = ww.createSheet("sheet1",0);

			sh.addCell(new Label(0,0,"Organisation"));
			sh.addCell(new Label(0,row,OrganisationText.getText()));
			sh.addCell(new Label(1,0,"Display Name"));
			sh.addCell(new Label(1,row,DisplayNameText.getText()));
			sh.addCell(new Label(2,0,"UserName"));
			sh.addCell(new Label(2,row,UsernameText.getText()));
			sh.addCell(new Label(3,0,"Likelihood"));
			sh.addCell(new Label(3,row,String.valueOf(LikeHood.getValue())));
			sh.addCell(new Label(4,0,"Impact"));
			sh.addCell(new Label(4,row,String.valueOf(Impact_1.getValue())));
			sh.addCell(new Label(5,0,"Confidentiality LikeliHood"));
			sh.addCell(new Label(5,row,String.valueOf(CL.getValue())));
			sh.addCell(new Label(6,0,"Confidentiality Impact"));
			sh.addCell(new Label(6,row,String.valueOf(CI.getValue())));
			sh.addCell(new Label(7,0,"Integrity LikeliHood"));
			sh.addCell(new Label(7,row,String.valueOf(IL.getValue())));
			sh.addCell(new Label(8,0,"Integrity Impact"));
			sh.addCell(new Label(8,row,String.valueOf(II.getValue())));
			sh.addCell(new Label(9,0,"Availability LikeliHood"));
			sh.addCell(new Label(9,row,String.valueOf(AL.getValue())));
			sh.addCell(new Label(10,0,"Availability Impact"));
			sh.addCell(new Label(10,row,String.valueOf(AI.getValue())));
			sh.addCell(new Label(13,0,"Risk"));
			sh.addCell(new Label(13,row,comboBox_1.getSelectedItem().toString()));
			sh.addCell(new Label(11,0,"Control"));
			sh.addCell(new Label(11,row,comboBox_2.getSelectedItem().toString()));
			sh.addCell(new Label(12,0,"Comment"));
			sh.addCell(new Label(12,row,textField_1.getText()));
			row++;
			ww.write();
			ww.close();
			
		}catch(Exception e) {
			
		}
		
	}
//	public  void AddToData() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","1234");
//			Statement st = con.createStatement();
//			int rs = st.executeUpdate("insert into DEMODB.VSRISK values('"+OrganisationText.getText()+"','"+DisplayNameText.getText()+"','"+
//			EmailText.getText()+"','"+UsernameText.getText()+"','"+PasswordText.getText()+"',0,0)");
//			con.close();	
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	private void MoveTo(int i) {
		if(i==1) {		
			Basic_Information.setVisible(true);
			RiskCalculator.setVisible(false);
			Management_Scales.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			FourTControls.setVisible(false);
			Treat.setVisible(false);
			button.setEnabled(true);
			button_1.setEnabled(false);
			button_2.setEnabled(true);
			button_3.setEnabled(false);
			RBCLabel.setForeground(Color.black);
			BasicInfoLabel.setForeground(Color.white);
			CSSLabel.setForeground(Color.black);
			ACLabel.setForeground(Color.BLACK);
			MSLabel.setForeground(Color.BLACK);
			FTCLabel.setForeground(Color.BLACK);
			
			TRTLabel.setForeground(Color.BLACK);
			textArea.setText("Before you can undertake your assessment"
					+ " \nyou will need to perform some basic\n"
					+ "configuration steps. Please follow this "
					+ "\nwizard to configure the assessment.");
			
		}else if(i==2) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(true);
			Acceptance_Criteria.setVisible(false);
			FourTControls.setVisible(false);
			Treat.setVisible(false);
			button_1.setEnabled(true);
			button_2.setEnabled(true);
			button_3.setEnabled(false);
			RBCLabel.setForeground(Color.black);
			BasicInfoLabel.setForeground(Color.black);
			CSSLabel.setForeground(Color.white);
			ACLabel.setForeground(Color.BLACK);
			MSLabel.setForeground(Color.BLACK);
			FTCLabel.setForeground(Color.BLACK);
			TRTLabel.setForeground(Color.BLACK);
			textArea.setText("These are the default control"
					+ "\nsets available with vmmRisk. On"
					+ "\nthis screen you can choose which"
					+ "\ncontrol sets you wish to use.");
		}else if(i==3) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(true);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			FourTControls.setVisible(false);
			Treat.setVisible(false);
			button_1.setEnabled(true);
			button_2.setEnabled(true);
			RBCLabel.setForeground(Color.black);
			button_3.setEnabled(false);
			BasicInfoLabel.setForeground(Color.black);
			CSSLabel.setForeground(Color.black);
			ACLabel.setForeground(Color.black);
			MSLabel.setForeground(Color.white);
			FTCLabel.setForeground(Color.BLACK);
			TRTLabel.setForeground(Color.BLACK);
			textArea.setText("Now you need to set the"
					+ "\nthe impact (or consequence)"
					+ "\nand Likelihood (or probability)"
					+ "\nscales you will use during your"
					+ "\nAssessment. The minimum is three,"
					+ "\nand the maximum is seven. You"
					+ "\ncan also edit the guidance provided"
					+ "\nfor each value as required.");
		}else if(i==4) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(true);
			FourTControls.setVisible(false);
			Treat.setVisible(false);
			button_1.setEnabled(true);
			button_2.setEnabled(true);
			button_3.setEnabled(false);
			FTCLabel.setForeground(Color.BLACK);
			RBCLabel.setForeground(Color.black);
			TRTLabel.setForeground(Color.BLACK);
			BasicInfoLabel.setForeground(Color.black);
			CSSLabel.setForeground(Color.black);
			ACLabel.setForeground(Color.white);
			MSLabel.setForeground(Color.BLACK);
			lblImpact_1.setText("Impact("+Impact_1.getValue()+")");
			lblNewLabel_3.setText("Likelihood("+LikeHood.getValue()+")");
		}else if(i==5){
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(true);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			FourTControls.setVisible(false);
			Treat.setVisible(false);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(false);
			FTCLabel.setForeground(Color.black);
			TRTLabel.setForeground(Color.BLACK);
			RBCLabel.setForeground(Color.white);
			BasicInfoLabel.setForeground(Color.black);
			CSSLabel.setForeground(Color.black);
			ACLabel.setForeground(Color.BLACK);
			MSLabel.setForeground(Color.BLACK);
		}else if(i==6){

			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			FourTControls.setVisible(true);
			Treat.setVisible(false);
			button_1.setEnabled(true);
			button_3.setEnabled(true);
			button_2.setEnabled(false);
			FTCLabel.setForeground(Color.BLACK);
			TRTLabel.setForeground(Color.WHITE);
			BasicInfoLabel.setForeground(Color.black);
			CSSLabel.setForeground(Color.black);
			RBCLabel.setForeground(Color.black);
			ACLabel.setForeground(Color.BLACK);
			MSLabel.setForeground(Color.BLACK);
		}else if(i==7){

			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			FourTControls.setVisible(false);
			Treat.setVisible(true);
			button_1.setEnabled(true);
			button_3.setEnabled(true);
			button_2.setEnabled(false);
			FTCLabel.setForeground(Color.BLACK);
			TRTLabel.setForeground(Color.WHITE);
			BasicInfoLabel.setForeground(Color.black);
			CSSLabel.setForeground(Color.black);
			RBCLabel.setForeground(Color.black);
			ACLabel.setForeground(Color.BLACK);
			MSLabel.setForeground(Color.BLACK);
		}
	}
	private void Referesh() {
		OrganisationText.setText(null);
		DisplayNameText.setText(null);
		EmailText.setText(null);
		UsernameText.setText(null);
		PasswordText.setText(null);
		ConfirmText.setText(null);
	}
	private int Calculate(int Like, int Impact) {
		FormulaToRisk = Formula.getSelectedIndex();
		
		switch(FormulaToRisk) {
		case 0:
			return Like+Impact;
			
		case 1:
			return Like-Impact;
			
		case 2:
			return Like+Impact-1;
			
		case 3:
			return Like-Impact-1;
		case 4:
			return Like*Impact;
		}
		return 0;
	}
}
class Part {
	   double value;
	   Color color;
	   
	   public Part(double value, Color color) {
	      this.value = value;
	      this.color = color;
	   }
	}
class MyComponent extends JComponent {
	   Part[] slices = { 
	      new Part(15, Color.yellow), new Part(30, Color.red)
	   }; 
	   MyComponent(int are) {
		   slices[0].value = are;
		   slices[1].value = 25-are;
	   }
	   public void paint(Graphics g) {
	      drawPie((Graphics2D) g, getBounds(), slices);
	   } 
	   void drawPie(Graphics2D g, Rectangle area, Part[] slices) {
	      double total = 0.0D;
	      for (int i = 0; i < slices.length; i++) {
	         total += slices[i].value;
	      } 
	      double curValue = 0.0D;
	      int startAngle = 0;
	      for (int i = 0; i < slices.length; i++) {
	         startAngle = (int) (curValue * 360 / total);
	         int arcAngle = (int) (slices[i].value * 360 / total);
	         
	         g.setColor(slices[i].color);
	         g.fillArc(area.x, area.y,300, 300, startAngle, arcAngle);
	         curValue += slices[i].value;
	      } 
	   }
	}
