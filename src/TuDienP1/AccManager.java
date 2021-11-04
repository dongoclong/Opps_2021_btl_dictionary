package TuDienP1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AccManager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setSystemLookAndFeel();
					AccManager frame = new AccManager();
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
	public AccManager() {
		setResizable(false);
		setTitle("DictionariesHLN");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\sach_icon (1).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btndn = new JButton("\u0110\u0103ng nh\u1EADp");
		btndn.setToolTipText("n\u1EBFu c\u00F3 t\u00E0i kho\u1EA3n");
		btndn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDn();
			}
		});
		btndn.setBounds(156, 87, 89, 35);
		contentPane.add(btndn);
		
		JButton btndk = new JButton("\u0110\u0103ng k\u00ED");
		btndk.setToolTipText("T\u1EA1o t\u00E0i kho\u1EA3n m\u1EDBi");
		btndk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDk();
			}
		});
		btndk.setBounds(156, 160, 89, 35);
		contentPane.add(btndk);
		
		JLabel lblNewLabel = new JLabel("Welcome to DictionariesHLN");
		lblNewLabel.setToolTipText("B\u1EA1n c\u00F3 th\u1EC3 tra c\u1EE9u t\u1EEB \u0111i\u1EC3n v\u1EDBi ch\u00FAng t\u00F4i");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 30, 193, 46);
		contentPane.add(lblNewLabel);
		
	}
	
	public void setDn() {
			this.setVisible(false);
			dangnhap dang_nhap = new dangnhap();
			dang_nhap.setVisible(true);
		 
	}
	
	public void setDk() {
		this.setVisible(false);
		dangki dang_ki = new dangki();
		dang_ki.setVisible(true);
	 
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
}
