import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SKKU_Application_Form extends JFrame {
	
	// All variables for GUI
	private JPanel contentPane;
	private JPanel pnImage;
	private JPanel pnMain;
	private JLabel lblWallpaper;
	private JLabel lblTitle;
	private JPanel panel;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblBirth;
	private JTextField txtBirth;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblDegree;
	private JLabel lblUniversity;
	private JTextField txtUniversity;
	private JLabel lblGPA;
	private JTextField txtGPA;
	private JLabel lblMajor;
	private JTextField txtMajor;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblStatement;
	private JButton btnSubmit;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JComboBox cbbDegree;
	private JTextArea txtStatement;
	private JScrollPane pnStatement;
	private JLabel lblPicture;
	private JLabel lblNewLabel;
	
	
	// This is for checking the email format. I use Pattern.matches method
	// Email should have '@' and '.'
	public boolean isEmail(String str) {
	    return Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", str);
	}
	
	// This is for checking the name format. I use Pattern.matches method
	// Name should have first name and last name for more(example middle name)
	public boolean isName(String str) {
		return Pattern.matches("[a-zA-Z]+ [a-zA-Z]+[a-zA-Z]*$", str);
	}
	
	// This is for checking the birth date format. I use Pattern.matches method
	// Birth date should be 'DD/MM/YYYY' format
	public boolean isBirth(String str) {
		return Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", str);
	}
	
	// This is for checking the phone number format. I use Pattern.matches method
	// Phone number should be '010-1234-5678' or '10-1234-5678'
	public boolean isPhone(String str) {
		return Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", str);
	}
	
	// This is for checking the address format. I use Pattern.matches method
	// Address must be in 'number, street, district, city' format.
	public boolean isAddress(String str) {
		return Pattern.matches("[0-9]+,[a-z0-9A-Z._-]+,[a-z0-9A-Z._-]+,[a-z0-9A-Z._-]+$", str);
	}
	

	// All variables setting for GUI
	public SKKU_Application_Form() {
		setBackground(new Color(255, 255, 255));
		setTitle("SKKU New Students Enrollment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 762);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnImage = new JPanel();
		pnImage.setBounds(5, 5, 278, 556);
		pnImage.setBackground(new Color(255, 255, 255));
		contentPane.add(pnImage);
		pnImage.setLayout(null);
		
		lblWallpaper = new JLabel("");
		lblWallpaper.setBounds(5, 5, 268, 550);
		lblWallpaper.setIcon(new ImageIcon(SKKU_Application_Form.class.getResource("/images/skku_wallpaper.png")));
		pnImage.add(lblWallpaper);
		
		pnMain = new JPanel();
		pnMain.setBounds(283, 5, 588, 556);
		pnMain.setBackground(new Color(255, 255, 255));
		contentPane.add(pnMain);
		pnMain.setLayout(null);
		
		lblTitle = new JLabel("");
		lblTitle.setBounds(0, 0, 576, 67);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(SKKU_Application_Form.class.getResource("/images/title_label.png")));
		pnMain.add(lblTitle);
		
		panel = new JPanel();
		panel.setBounds(0, 67, 576, 489);
		panel.setBackground(new Color(255, 255, 255));
		pnMain.add(panel);
		panel.setLayout(null);
		
		lblName = new JLabel("Applicant Name:");
		lblName.setFont(new Font("굴림", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(12, 10, 257, 21);
		panel.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(281, 10, 283, 21);
		panel.add(txtName);
		txtName.setColumns(10);
		
		lblBirth = new JLabel("Birth Date:");
		lblBirth.setFont(new Font("굴림", Font.BOLD, 12));
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirth.setBounds(12, 41, 257, 21);
		panel.add(lblBirth);
		
		txtBirth = new JTextField();
		txtBirth.setColumns(10);
		txtBirth.setBounds(281, 41, 283, 21);
		panel.add(txtBirth);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("굴림", Font.BOLD, 12));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(12, 72, 257, 21);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(281, 72, 283, 21);
		panel.add(txtEmail);
		
		lblDegree = new JLabel("Degree:");
		lblDegree.setFont(new Font("굴림", Font.BOLD, 12));
		lblDegree.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDegree.setBounds(12, 103, 257, 21);
		panel.add(lblDegree);
		
		lblUniversity = new JLabel("Attended university (for Graduates):");
		lblUniversity.setFont(new Font("굴림", Font.BOLD, 12));
		lblUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUniversity.setBounds(12, 134, 257, 21);
		panel.add(lblUniversity);
		
		txtUniversity = new JTextField();
		txtUniversity.setEnabled(false);
		txtUniversity.setColumns(10);
		txtUniversity.setBounds(281, 134, 283, 21);
		panel.add(txtUniversity);
		
		lblGPA = new JLabel("GPA (for Graduates):");
		lblGPA.setFont(new Font("굴림", Font.BOLD, 12));
		lblGPA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGPA.setBounds(12, 165, 257, 21);
		panel.add(lblGPA);
		
		txtGPA = new JTextField();
		txtGPA.setEnabled(false);
		txtGPA.setColumns(10);
		txtGPA.setBounds(281, 165, 283, 21);
		panel.add(txtGPA);
		
		lblMajor = new JLabel("Major");
		lblMajor.setFont(new Font("굴림", Font.BOLD, 12));
		lblMajor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMajor.setBounds(12, 196, 257, 21);
		panel.add(lblMajor);
		
		txtMajor = new JTextField();
		txtMajor.setColumns(10);
		txtMajor.setBounds(281, 196, 283, 21);
		panel.add(txtMajor);
		
		lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("굴림", Font.BOLD, 12));
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(12, 226, 257, 21);
		panel.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(281, 226, 283, 21);
		panel.add(txtPhone);
		
		lblStatement = new JLabel("Personal Statement");
		lblStatement.setFont(new Font("굴림", Font.BOLD, 15));
		lblStatement.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatement.setBounds(12, 294, 552, 40);
		panel.add(lblStatement);
		
		btnSubmit = new JButton("Submit Application");
		btnSubmit.setFont(new Font("굴림", Font.BOLD, 14));
		// When user click the 'Submit Application' button, program will check the data that user wrote in
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String problems = ""; // for storing the all problems
				int count = 1; // for count the number of problems
				String empty = ""; // for storing the name of empty text field
				
				// try and catch
				// If the user fill the text field in wrong format the text color changes to red
				try {
					
					// if the name text field is empty, store in empty variable
					// else store the problem in problems variable
					if(!isName(txtName.getText())) {
						if(txtName.getText().isBlank()) {
							empty += "name text field, ";
						}
						else {
							txtName.setForeground(Color.red); 
							problems += count + ". You forgot to write your name or surname. Or forgot the space between the name.\n";
							count++; // increase the count
						}
						
					}
					else {
						txtName.setForeground(Color.black);
					}
					
					// if the birth date text field is empty, store in empty variable
					// else store the problem in problems variable
					if(!isBirth(txtBirth.getText())) {
						if(txtBirth.getText().isBlank()) {
							empty += "Birth Date text field, ";
						}
						else {
							txtBirth.setForeground(Color.red);
							problems += count + ". Birthdate must be in '06/06/1995' format.\n";
							count++; // increase the count
						}
						
					}
					else {
						txtBirth.setForeground(Color.black);
					}
					
					// if the email text field is empty, store in empty variable
					// else store the problem in problems variable
					if(!isEmail(txtEmail.getText())) {
						if(txtEmail.getText().isBlank()) {
							empty += "Email text field, ";
						}
						else {
							txtEmail.setForeground(Color.red);
							problems += count + ". Email must be in example@some.some.\n";
							count++; // increase the count
						}
						
					}
					else {
						txtEmail.setForeground(Color.black);
					}
					// if the major text field is empty, store in empty variable
					if(txtMajor.getText().isBlank()) {
						empty += "Major text field, ";
					}
					
					// if the phone number text field is empty, store in empty variable
					// else store the problem in problems variable
					if(!isPhone(txtPhone.getText())) {
						if(txtPhone.getText().isBlank()) {
							empty += "Phone Number text field, ";
						}
						else {
							txtPhone.setForeground(Color.red);
							problems += count + ". Proper format for a phone number is '010-2158-0222'.\n";
							count++; // increase the count
						}
						
					}
					else {
						txtPhone.setForeground(Color.black);
					}
					
					// if the email text field is empty, store in empty variable
					// else store the problem in problems variable
					if(!isAddress(txtAddress.getText())) {
						if(txtAddress.getText().isBlank()) {
							empty += "Address text field, ";
						}
						else {
							txtAddress.setForeground(Color.red);
							problems += count + ". Your address must be in 'number,street,district,city' format(without space, only comma).\n";
							count++;
						}
						
					}
					else {
						txtAddress.setForeground(Color.black);
					}
					
					// If the Degree isn't 'Bachelor', user have to fill in the previous university and GPA.
					// If it is empty, store in problems variable
					if(cbbDegree.getSelectedItem()!= "Bachelor") {
						if(txtUniversity.getText().isBlank() || txtGPA.getText().isBlank()) {
							problems += count + ". For graduate, you have to enter previous university and GPA.\n";
							count++; // increase the count
						}
					}
					// Also the GPA should be in between 0 and 4.5 (SKKU has 4.5 GPA system)
					// If the txtGPA is empty, parseDouble method can raise error
					if(!txtGPA.getText().isBlank()) {
						if(Double.parseDouble(txtGPA.getText())> 4.5 || Double.parseDouble(txtGPA.getText()) < 0) {
							txtGPA.setForeground(Color.red);
							problems += count + ". GPA must be between 0 and 4.5.\n";
							count++; // increase the count
						}
						else {
							txtGPA.setForeground(Color.black);
						}
					}
					
					// The statement should be at least 100 words.
					if(txtStatement.getText().length() < 100) {
						txtStatement.setForeground(Color.red);
						problems += count + ". Your Personal Statement must be at least 100 words.\n";
						count++; // increase the count
					}
					else {
						txtStatement.setForeground(Color.black);
					}
					
					// If the empty variable isn't empty, it add to the problems variable
					if(empty != "") {
						problems += count + ". You forgot to fill the " + empty +"Please fill it.\n";
					}
					
					// If the problems isn't empty, throw the ProblemCheck() exception
					if(problems != "") {
						throw new ProblemCheck();
					}
					// If the problems is empty, it means that all answer are correct.
					// So pop up the success messages and initialize the text fields.
					else {
						JOptionPane.showMessageDialog(null,"Successfully Submitted","Success Message",JOptionPane.INFORMATION_MESSAGE);
						txtName.setText("");
						txtBirth.setText("");
						txtEmail.setText("");
						cbbDegree.setSelectedIndex(0);
						txtUniversity.setText("");
						txtGPA.setText("");
						txtMajor.setText("");
						txtPhone.setText("");
						txtAddress.setText("");
						txtStatement.setText("");
					}
					
					// catch the exceptions
					// Pop up the error message that shows all the problems
				}catch(ProblemCheck e1) {
					JOptionPane.showMessageDialog(null,problems + "\n\n All answer should be wrote in ENGLISH!","You have following problems:",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnSubmit.setBackground(new Color(0, 128, 0));
		btnSubmit.setForeground(new Color(255, 255, 128));
		btnSubmit.setBounds(200, 444, 186, 35);
		panel.add(btnSubmit);
		
		lblAddress = new JLabel("Home Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("굴림", Font.BOLD, 12));
		lblAddress.setBounds(12, 257, 257, 21);
		panel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(281, 257, 283, 21);
		panel.add(txtAddress);
		
		cbbDegree = new JComboBox();
		cbbDegree.addActionListener(new ActionListener() {
			// When user chose the degree in combobox
			public void actionPerformed(ActionEvent e) {
				
				// If the degree is 'Bachelor' user don't need to fill in the previous university and GPA
				// So, make the txtUniversity and txtGPA text fields enable false
				// It is because to avoid the inefficient and wrong answer
				
				if(cbbDegree.getSelectedItem() == "Bachelor") {
					txtUniversity.setEnabled(false);
					txtGPA.setEnabled(false);
				}
				// else make the txtUniversity and txtGPA text fields enable true
				else {
					txtUniversity.setEnabled(true);
					txtGPA.setEnabled(true);
				}
			}
		});
		
		// Set combobox 'Bachelor', 'Master', 'Ph.D'
		cbbDegree.setModel(new DefaultComboBoxModel(new String[] {"Bachelor", "Master", "Ph.D", "Transfer"}));
		cbbDegree.setBounds(281, 103, 283, 23);
		panel.add(cbbDegree);
		
		txtStatement = new JTextArea();
		txtStatement.setFont(new Font("Monospaced", Font.ITALIC, 13));
		txtStatement.setText("At least 100 words...");
		// for many statement, use scrollPane
		pnStatement = new JScrollPane(txtStatement);
		pnStatement.setBounds(12, 344, 552, 78);
		panel.add(pnStatement);
		
		lblPicture = new JLabel("");
		lblPicture.setIcon(new ImageIcon(SKKU_Application_Form.class.getResource("/images/명륜당.png")));
		lblPicture.setBounds(283, 571, 588, 144);
		contentPane.add(lblPicture);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(SKKU_Application_Form.class.getResource("/images/로고.png")));
		lblNewLabel.setBounds(5, 571, 266, 144);
		contentPane.add(lblNewLabel);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SKKU_Application_Form frame = new SKKU_Application_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
