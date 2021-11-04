package TuDienP1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.awt.Toolkit;


public class dangnhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	
	private String taikhoan;
	private String matkhau;
	private String ten;
	private static boolean checkTT;
	
	AlogIn login = new AlogIn();
	
	

	
	


	/**
	 * Create the frame.
	 */
	public dangnhap() {
		setTitle("Đăng nhập");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\sach_icon (1).png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTk = new JLabel("T\u00E0i kho\u1EA3n");
		labelTk.setBounds(71, 63, 72, 22);
		contentPane.add(labelTk);
		
		JLabel labelMk = new JLabel("M\u1EADt kh\u1EA9u");
		labelMk.setBounds(71, 119, 72, 22);
		contentPane.add(labelMk);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(153, 64, 171, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JPanel panel = (JPanel) getContentPane();
		
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login.LogInFromFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 String s = String.copyValueOf(passwordField.getPassword());
				if(login.AccountLookup(textField.getText(),s)) {
						checkTT = true;
					JOptionPane.showMessageDialog(
		                    panel, 
		                    "Đăng nhập thành công", 
		                    "Thông báo", 
		                    JOptionPane.INFORMATION_MESSAGE);
							//setVis(checkTT);
						
						setVis(checkTT,login.accName(textField.getText()));
				} else {
					JOptionPane.showMessageDialog(
		                    panel, 
		                    "Tai khoản hoặc Mật khẩu sai", 
		                    "Thông báo", 
		                    JOptionPane.ERROR_MESSAGE);
							checkTT = false;
				}
					
			}
		});
		passwordField.setBounds(153, 120, 171, 20);
		contentPane.add(passwordField);
		
		btnLogIn = new JButton("\u0110\u0103ng nh\u1EADp");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login.LogInFromFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 String s = String.copyValueOf(passwordField.getPassword());
				if(login.AccountLookup(textField.getText(),s)) {
						checkTT = true;
					JOptionPane.showMessageDialog(
		                    panel, 
		                    "Đăng nhập thành công", 
		                    "Thông báo", 
		                    JOptionPane.INFORMATION_MESSAGE);
							//setVis(checkTT);
						
						setVis(checkTT,login.accName(textField.getText()));
				} else {
					JOptionPane.showMessageDialog(
		                    panel, 
		                    "Tai khoản hoặc Mật khẩu sai", 
		                    "Thông báo", 
		                    JOptionPane.ERROR_MESSAGE);
							checkTT = false;
				}
				
			}
		});
		
		btnLogIn.setBounds(180, 181, 104, 33);
		contentPane.add(btnLogIn);
		
		JButton btn_dangki = new JButton("Đăng kí");
		btn_dangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDki(true);
			}
		});
		btn_dangki.setToolTipText("nếu chưa có tài khoản hãy đăng kí");
		btn_dangki.setBounds(306, 186, 89, 23);
		contentPane.add(btn_dangki);
		
		
	}
	
	public String getTaikhoan() {
		return taikhoan;
	}
	
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
	
	public void setVis(boolean check, String s) {
		
		 if (check == true) {
			this.setVisible(false);
			manhinhchinh frm2 = new manhinhchinh(s);
			frm2.setVisible(true);
		}
	}
	
	public void setDki(boolean check) {
		
		 if (check == true) {
			this.setVisible(false);
			this.dispose();
			dangki dk1 = new dangki();
			dk1.setVisible(true);
		}
	}
	
	/**
	 * ham chay chuong trinh theo format cua window
	 */
	public static void setSystemLookAndFeel() {
	    try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
	            | UnsupportedLookAndFeelException e) {
	    }
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
}
