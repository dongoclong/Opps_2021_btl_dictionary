package TuDienP1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.util.concurrent.TimeUnit;
public class dangki extends JFrame {
	private String taikhoan;
	private String matkhau;
	private String ten;
	private static boolean checkTT;
	AlogIn re_new = new AlogIn();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField accField;
	private JPasswordField passField;
	private JLabel lbl_ten;
	private JTextField tenField;
	private JButton btndangnhap;



	/**
	 * Create the frame.
	 */
	public dangki() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\sach_icon (1).png"));
		setTitle("\u0110\u0103ng k\u00ED t\u00E0i kho\u1EA3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_tk = new JLabel("T\u00E0i kho\u1EA3n");
		lbl_tk.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tk.setBounds(66, 33, 62, 24);
		contentPane.add(lbl_tk);
		
		accField = new JTextField();
		accField.setBounds(131, 35, 132, 20);
		contentPane.add(accField);
		accField.setColumns(10);
		
		JLabel lbl_mk = new JLabel("M\u1EADt kh\u1EA9u");
		lbl_mk.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mk.setBounds(66, 68, 62, 24);
		contentPane.add(lbl_mk);
		
		passField = new JPasswordField();
		passField.setBounds(131, 68, 132, 20);
		contentPane.add(passField);
		
		final JPanel panel = (JPanel) getContentPane();
		JButton btn_Dk = new JButton("\u0110\u0103ng k\u00ED");
		btn_Dk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passWord = String.copyValueOf(passField.getPassword());
				try {
					re_new.LogInFromFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (re_new.checkAccount(accField.getText())) {
					JOptionPane.showMessageDialog(
		                    panel, 
		                    "Tai khoản đã có", 
		                    "Thông báo", 
		                    JOptionPane.ERROR_MESSAGE);
							checkTT = false;
				}
				else {
					try {
						re_new.accountExportToFile(accField.getText(), passWord,tenField.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(
		                    panel, 
		                    "Tạo Thành Công", 
		                    "Thông báo", 
		                    JOptionPane.INFORMATION_MESSAGE);
							checkTT = true;
							try {
								TimeUnit.SECONDS.sleep(2);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							setVis(checkTT);
				}
			}
		});
		btn_Dk.setBounds(147, 145, 89, 32);
		contentPane.add(btn_Dk);
		
		lbl_ten = new JLabel("Tên");
		lbl_ten.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ten.setBounds(66, 103, 62, 24);
		contentPane.add(lbl_ten);
		
		tenField = new JTextField();
		tenField.setBounds(131, 105, 132, 20);
		contentPane.add(tenField);
		tenField.setColumns(10);
		
		btndangnhap = new JButton("Đăng nhập");
		btndangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVis(true);
			}
		});
		btndangnhap.setBounds(280, 150, 89, 23);
		contentPane.add(btndangnhap);
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
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public void setVis(boolean check) {
		
		 if (check == true) {
			this.setVisible(false);
			dangnhap dang_nhap = new dangnhap();
			dang_nhap.setVisible(true);
		} 
	}
	
	

}
