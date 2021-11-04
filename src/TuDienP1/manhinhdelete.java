package TuDienP1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manhinhdelete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField deleteField;
	DictionaryManagement dictionaryManagemment = new DictionaryManagement();
	DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
	
	

	
	/**
	 * Create the frame.
	 */
	public manhinhdelete(final String taikhoan) {
		setResizable(false);
		setTitle("HLN Dictionary");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\sach_icon (1).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel();
		
		lblNewLabel_1.setBounds(34, 129, 189, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(34, 205, 189, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(34, 293, 189, 40);
		contentPane.add(lblNewLabel_3);
		
		String welcome = "Welcome " + taikhoan ;
		JLabel lbl_name = new JLabel(welcome);
		lbl_name.setForeground(new Color(255, 127, 80));
		lbl_name.setBounds(627, 90, 147, 20);
		contentPane.add(lbl_name);
		lbl_name.setFont(new Font("Lobster", Font.PLAIN, 15));
		
		deleteField = new JTextField();
		
		deleteField.setBounds(331, 139, 158, 20);
		contentPane.add(deleteField);
		deleteField.setColumns(10);
		
		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(331, 231, 158, 34);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel_4);
		
		JLabel lbl_delete = new JLabel("");
		lbl_delete.addMouseListener(new MouseAdapter() {
		
				private String delete_word;

				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == MouseEvent.BUTTON1) {
					
						delete_word = dictionaryManagemment.removeWord(deleteField.getText());
						try {
							dictionaryManagemment.dictionaryExportToFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lblNewLabel_4.setText(delete_word);
						
					}
				}
			
		});
		lbl_delete.setBounds(514, 129, 84, 40);
		contentPane.add(lbl_delete);
		
		deleteField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete_word = dictionaryManagemment.removeWord(deleteField.getText());
				try {
					dictionaryManagemment.dictionaryExportToFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblNewLabel_4.setText(delete_word);
			}
		});

		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisSearch(true, taikhoan);
			}
		});
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisAdd(true, taikhoan);
			}
		});
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(true);
			}
		});
		
		JLabel dangxuat = new JLabel("");
		dangxuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisOut(true);
			}
		});
		dangxuat.setBounds(665, 484, 119, 37);
		contentPane.add(dangxuat);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\admin\\Downloads\\dictionary\\bản1_delete.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 521);
		contentPane.add(lblNewLabel);	
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
	
	public void setVisOut(boolean check) {
		
		 if (check == true) {
			this.setVisible(false);
			this.dispose();
			dangnhap dang_nhap = new dangnhap();
			dang_nhap.setVisible(true);
		} 
	}
	
	public void setVisAdd(boolean check, String tk) {
		
		 if (check == true) {
			this.setVisible(false);
			this.dispose();
			manhinhadd add_vis = new manhinhadd(tk);
			add_vis.setVisible(true);
		} 
	}
	
	public void setVisSearch(boolean check, String tk) {
		
		 if (check == true) {
			this.setVisible(false);
			this.dispose();
			manhinhchinh add_vis = new manhinhchinh(tk);
			add_vis.setVisible(true);
		} 
	}

}
