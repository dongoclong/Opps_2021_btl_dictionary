package TuDienP1;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;


import java.awt.Toolkit;

public class manhinhchinh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String taikhoan;
	private JTextField searchField;
	DictionaryManagement dictionaryManagemment = new DictionaryManagement();
	DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
	private JLabel giainghia;
	private JLabel tuloai;
	speech newspeech = new speech();
	private static int nhapfile=0; 
	


	/**
	 * Create the frame.
	 */
	public manhinhchinh(final String taikhoan) {
		if (nhapfile == 0)
		{
			try {
				dictionaryManagemment.insertFromFile();
				nhapfile++;
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
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
		
		searchField = new JTextField();
		searchField.setBounds(313, 139, 158, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		
		final JLabel lblShowone = new JLabel();
		lblShowone.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowone.setFont(new Font("Lobster", Font.PLAIN, 15));
		lblShowone.setBounds(313, 205, 158, 20);
		contentPane.add(lblShowone);
		
		final JLabel lblShowone_1 = new JLabel();
		lblShowone_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowone_1.setFont(new Font("Lobster", Font.PLAIN, 15));
		lblShowone_1.setBounds(313, 236, 158, 20);
		contentPane.add(lblShowone_1);
		
		final JLabel lblShowone_2 = new JLabel();
		lblShowone_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowone_2.setFont(new Font("Lobster", Font.PLAIN, 15));
		lblShowone_2.setBounds(313, 267, 158, 20);
		contentPane.add(lblShowone_2);
		
		final JLabel lblShowone_3 = new JLabel();
		lblShowone_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowone_3.setFont(new Font("Lobster", Font.PLAIN, 15));
		lblShowone_3.setBounds(313, 298, 158, 20);
		contentPane.add(lblShowone_3);
		
		final JLabel lblShowone_4 = new JLabel();
		lblShowone_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowone_4.setFont(new Font("Lobster", Font.PLAIN, 15));
		lblShowone_4.setBounds(313, 329, 158, 20);
		contentPane.add(lblShowone_4);
		
		giainghia = new JLabel();
		giainghia.setForeground(new Color(255, 215, 0));
		giainghia.setFont(new Font("Lobster", Font.PLAIN, 16));
		giainghia.setHorizontalAlignment(SwingConstants.CENTER);
		giainghia.setBounds(282, 417, 177, 29);
		contentPane.add(giainghia);
		
		
		tuloai = new JLabel();
		tuloai.setFont(new Font("Lobster", Font.PLAIN, 16));
		tuloai.setHorizontalAlignment(SwingConstants.CENTER);
		tuloai.setBounds(577, 417, 182, 29);
		contentPane.add(tuloai);
	
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1 = searchField.getText();
				String[] s = dictionaryManagemment.dictionaryLookup(text1);
				
					
					giainghia.setText(s[0]);
					tuloai.setText(s[1]);
					
					String[] textsearch = new String[5];
					textsearch = dictionaryCommandline.searchFive(text1);
					
					lblShowone.setText(textsearch[0]);
					lblShowone_1.setText(textsearch[1]);
					lblShowone_2.setText(textsearch[2]);
					lblShowone_3.setText(textsearch[3]);
					lblShowone_4.setText(textsearch[4]);
				
			}
		});
		
		
	
	
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(true);
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
				setVisdelete(true, taikhoan);
			}
		});
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\admin\\Downloads\\dictionary\\bản1_search.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 521);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_search = new JLabel("New label");
		lbl_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text1 = searchField.getText();
				
				String[] s = dictionaryManagemment.dictionaryLookup(text1);
				giainghia.setText(s[0]);
				tuloai.setText(s[1]);
				String[] textsearch = new String[5];
				textsearch = dictionaryCommandline.searchFive(text1);
				lblShowone.setText(textsearch[0]);
				lblShowone_1.setText(textsearch[1]);
				lblShowone_2.setText(textsearch[2]);
				lblShowone_3.setText(textsearch[3]);
				lblShowone_4.setText(textsearch[4]);
			}
		});
		lbl_search.setBounds(514, 129, 75, 40);
		contentPane.add(lbl_search);
		
		JLabel lbl_speech = new JLabel("");
		lbl_speech.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 newspeech.speech(searchField.getText());
			}
		});
		lbl_speech.setBounds(756, 417, 28, 40);
		contentPane.add(lbl_speech);
		
		JLabel dangxuat = new JLabel("");
		dangxuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisOut(true);
			}
		});
		dangxuat.setBounds(665, 484, 119, 37);
		contentPane.add(dangxuat);
		
	
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
	
	public void setVisdelete(boolean check, String tk) {
		
		 if (check == true) {
			this.setVisible(false);
			this.dispose();
			manhinhdelete add_vis = new manhinhdelete(tk);
			add_vis.setVisible(true);
		} 
	}
}
