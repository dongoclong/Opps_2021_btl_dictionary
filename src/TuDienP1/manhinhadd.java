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
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manhinhadd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DictionaryManagement dictionaryManagemment = new DictionaryManagement();
	DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
	
	private static String taikhoan;
	private JTextField textenglish;
	private JTextField textVietnam;
	private JTextField textTuloai;
	

	/**
	 * Create the frame.
	 */
	public manhinhadd(final String taikhoan) {

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
		lbl_name.setBounds(627, 90, 147, 19);
		lbl_name.setForeground(new Color(255, 127, 80));
		contentPane.add(lbl_name);
		lbl_name.setFont(new Font("Lobster", Font.PLAIN, 15));
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisSearch(true,taikhoan);
			}
		});
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(true);
			}
		});
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisdelete(true,taikhoan);
			}
		});
		final JLabel inforAdd = new JLabel("");
		inforAdd.setForeground(Color.WHITE);
		inforAdd.setHorizontalAlignment(SwingConstants.CENTER);
		inforAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		inforAdd.setBounds(294, 415, 270, 29);
		contentPane.add(inforAdd);
		
		textenglish = new JTextField();
		textenglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textVietnam.getText().equals("") || textenglish.getText().equals("") || textTuloai.getText().equals("")) {
					inforAdd.setText("Nhập thiếu dữ kiện");
					} else if(dictionaryManagemment.checkWord(textenglish.getText())) {
						inforAdd.setText("Từ này đã có trong từ điển");
					}else {
						dictionaryManagemment.insertFromCommandline(textVietnam.getText(), textenglish.getText(), textTuloai.getText());
						try {
							dictionaryManagemment.dictionaryExportToFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						inforAdd.setText("Đã nhập dữ kiện");
					}
			}
		});
		textenglish.setBounds(410, 215, 172, 19);
		contentPane.add(textenglish);
		textenglish.setColumns(10);
		
		textVietnam = new JTextField();
		textVietnam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textVietnam.getText().equals("") || textenglish.getText().equals("") || textTuloai.getText().equals("")) {
					inforAdd.setText("Nhập thiếu dữ kiện");
					} else if(dictionaryManagemment.checkWord(textenglish.getText())) {
						inforAdd.setText("Từ này đã có trong từ điển");
					}else {
						dictionaryManagemment.insertFromCommandline(textVietnam.getText(), textenglish.getText(), textTuloai.getText());
						try {
							dictionaryManagemment.dictionaryExportToFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						inforAdd.setText("Đã nhập dữ kiện");
					}
			}
		});
		textVietnam.setColumns(10);
		textVietnam.setBounds(410, 265, 172, 19);
		contentPane.add(textVietnam);
		
		textTuloai = new JTextField();
		textTuloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textVietnam.getText().equals("") || textenglish.getText().equals("") || textTuloai.getText().equals("")) {
					inforAdd.setText("Nhập thiếu dữ kiện");
					} else if(dictionaryManagemment.checkWord(textenglish.getText())) {
						inforAdd.setText("Từ này đã có trong từ điển");
					}else {
						dictionaryManagemment.insertFromCommandline(textVietnam.getText(), textenglish.getText(), textTuloai.getText());
						try {
							dictionaryManagemment.dictionaryExportToFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						inforAdd.setText("Đã nhập dữ kiện");
					}
			}
		});
		textTuloai.setColumns(10);
		textTuloai.setBounds(410, 324, 172, 19);
		contentPane.add(textTuloai);
		
		
		
		JLabel lbl_add = new JLabel("");
		lbl_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(textVietnam.getText().equals("") || textenglish.getText().equals("") || textTuloai.getText().equals("")) {
					inforAdd.setText("Nhập thiếu dữ kiện");
					} else if(dictionaryManagemment.checkWord(textenglish.getText())) {
						inforAdd.setText("Từ này đã có trong từ điển");
					}else {
						dictionaryManagemment.insertFromCommandline(textVietnam.getText(), textenglish.getText(), textTuloai.getText());
						try {
							dictionaryManagemment.dictionaryExportToFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						inforAdd.setText("Đã nhập dữ kiện");
					}
			}
			}
		});
		lbl_add.setBounds(339, 364, 127, 40);
		contentPane.add(lbl_add);
		
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\admin\\Downloads\\dictionary\\bản1_add.jpg"));
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(670, 492, 114, 29);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisOut(true);
			}
		});
		lblNewLabel.setBounds(0, 0, 790, 528);
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
	
	public void setVisSearch(boolean check, String name) {
		
		 if (check == true) {
			this.setVisible(false);
			this.dispose();
			manhinhchinh new_search = new manhinhchinh(name);
			new_search.setVisible(true);
		} 
	}
	
	public void setVisdelete(boolean check, String tk) {
		
		 if (check == true) {
			this.setVisible(false);
			this.dispose();
			manhinhdelete add_vis = new manhinhdelete(tk);
			add_vis.setVisible(true);
		} 
	}

}
