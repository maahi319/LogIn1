/*import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblYourUsername;
	private JLabel lblNewPassword;
	private JTextField passwordTextField;
	private JLabel lblYourFirstName;
	private JLabel lblYourLastName;
	private JTextField fNameTextField;
	private JTextField lNameTextField;
	private JLabel lblYourAddress;
	private JLabel lblYourZipCode;
	private JLabel lblYourCity;
	private JTextField addressTextField;
	private JTextField zipCodeTextField;
	private JTextField cityTextField;
	private JLabel lblWillBeGenerated;
	private JButton btnNewButton;
	
	PatientManager pm = new PatientManager();
	private JButton btnBackToLogin;*/
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
/*	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JLabel lblSignUpHere = new JLabel("Sign Up Here!");
		lblSignUpHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUpHere.setFont(new Font("Barlow SemiBold", Font.PLAIN, 15));
		lblSignUpHere.setBounds(0, 29, 586, 13);
		contentPane.add(lblSignUpHere);
		
		lblYourUsername = new JLabel("Your Username:");
		lblYourUsername.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblYourUsername.setBounds(45, 63, 108, 13);
		contentPane.add(lblYourUsername);
		
		lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblNewPassword.setBounds(45, 87, 108, 13);
		contentPane.add(lblNewPassword);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(163, 86, 200, 19);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		lblYourFirstName = new JLabel("Your First Name:");
		lblYourFirstName.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		lblYourFirstName.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblYourFirstName.setBounds(45, 110, 108, 13);
		contentPane.add(lblYourFirstName);
		
		lblYourLastName = new JLabel("Your Last Name:");
		lblYourLastName.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblYourLastName.setBounds(45, 133, 108, 13);
		contentPane.add(lblYourLastName);
		
		fNameTextField = new JTextField();
		fNameTextField.setColumns(10);
		fNameTextField.setBounds(163, 109, 200, 19);
		contentPane.add(fNameTextField);
		
		lNameTextField = new JTextField();
		lNameTextField.setColumns(10);
		lNameTextField.setBounds(163, 132, 200, 19);
		contentPane.add(lNameTextField);
		
		lblYourAddress = new JLabel("Your Address:");
		lblYourAddress.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblYourAddress.setBounds(45, 156, 108, 13);
		contentPane.add(lblYourAddress);
		
		lblYourZipCode = new JLabel("Your Zip Code:");
		lblYourZipCode.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblYourZipCode.setBounds(45, 179, 108, 13);
		contentPane.add(lblYourZipCode);
		
		lblYourCity = new JLabel("Your City:");
		lblYourCity.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblYourCity.setBounds(45, 202, 108, 13);
		contentPane.add(lblYourCity);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(163, 155, 200, 19);
		contentPane.add(addressTextField);
		
		zipCodeTextField = new JTextField();
		zipCodeTextField.setColumns(10);
		zipCodeTextField.setBounds(163, 178, 200, 19);
		contentPane.add(zipCodeTextField);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(163, 201, 200, 19);
		contentPane.add(cityTextField);
		
		lblWillBeGenerated = new JLabel("will be generated automatically.");
		lblWillBeGenerated.setVerticalTextPosition(SwingConstants.TOP);
		lblWillBeGenerated.setVerticalAlignment(SwingConstants.TOP);
		lblWillBeGenerated.setFont(new Font("Barlow", Font.PLAIN, 14));
		lblWillBeGenerated.setBounds(163, 61, 215, 19);
		contentPane.add(lblWillBeGenerated);
		
		btnNewButton = new JButton("Create Account");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Barlow SemiBold", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( passwordTextField.getText().isEmpty() || fNameTextField.getText().isEmpty() || lNameTextField.getText().isEmpty() 
				|| addressTextField.getText().isEmpty() || zipCodeTextField.getText().isEmpty() || cityTextField.getText().isEmpty() ) { 
					JOptionPane.showMessageDialog(null, "Please fill out all fields!", "Error!", JOptionPane.CANCEL_OPTION);

				}
				else {
					Patient a = new Patient();
					a.setPassword(passwordTextField.getText());
					a.setFirstname(fNameTextField.getText());
					a.setLastname(lNameTextField.getText());
					a.setAddress(addressTextField.getText());
					a.setZipCode(zipCodeTextField.getText());
					a.setCity(cityTextField.getText());
					try {
						pm.createPatient(a);
					} catch (RemoteException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error No acc created "+a.getFirstname(), "Error Created!", JOptionPane.DEFAULT_OPTION);
					}
					
					JOptionPane.showMessageDialog(null, "Your Account was created succesfully!\nYour Username:" +pm.getPatients().get(0).getUsername() +"\nPlease write down the username to login.\n","Account Created!", JOptionPane.DEFAULT_OPTION);
					LogIn frame1 = new LogIn(pm);
			        setVisible(false);
			        frame1.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(407, 179, 145, 40);
		contentPane.add(btnNewButton);
		
		btnBackToLogin = new JButton("Back To Login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn frame2 = new LogIn(pm);
		        setVisible(false);
		        frame2.setVisible(true);
			}
		});
		btnBackToLogin.setFont(new Font("Barlow", Font.PLAIN, 10));
		btnBackToLogin.setBounds(45, 27, 108, 21);
		contentPane.add(btnBackToLogin);
		
		
	}

}*/
