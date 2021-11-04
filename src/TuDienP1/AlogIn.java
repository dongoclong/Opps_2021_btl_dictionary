package TuDienP1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlogIn {
	public static ArrayList<dangnhap> listAccount  = new ArrayList<>();
	
	/**
	 * use insert list word from dictionares
	 * @throws FileNotFoundException
	 */
	
	public void LogInFromFile() throws FileNotFoundException {
		int idxTK = 0;
		int idxMK = 1;
		int idxName = 2;
		Scanner scan = new Scanner(new File("account.txt"));
		while(scan.hasNext()) {
			String stringAcc = scan.nextLine();
			String[] parts = stringAcc.split("\t");	
			if (parts.length >= 3) {
				dangnhap _logIn = new dangnhap();
				_logIn.setTaikhoan(parts[idxTK]);
				_logIn.setMatkhau(parts[idxMK]);
				_logIn.setTen(parts[idxName]);
				listAccount.add(_logIn);
			}
			
		}
	}
	
	/**
	 * find the account and check password
	 */
	public boolean AccountLookup(String textTk, String textMk) {
		for(dangnhap i : listAccount) {
			if(i.getTaikhoan().equals(textTk) && i.getMatkhau().equals(textMk)) {
				
				return true;
			}
		}
			return false;
	}
	
	/**
	 * find the account .
	 */
	public boolean checkAccount(String textTk) {
		for(dangnhap i : listAccount) {
			if(i.getTaikhoan().equals(textTk)) {
				
				return true;
			}
		}
			return false;
	}
	
	/**
	 * return the name.
	 */
	public String accName(String textTk) {
		for(dangnhap i : listAccount) {
			if(i.getTaikhoan().equals(textTk)) {
				
				return i.getTen();
			}
			
		}
		return "No";
	}
	
	/**
	 * export new account to file.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void accountExportToFile(String tai_khoan, String mat_khau, String ten) throws FileNotFoundException,IOException {
		
		dangnhap newdangki = new dangnhap();
		newdangki.setTaikhoan(tai_khoan);
		newdangki.setMatkhau(mat_khau);
		newdangki.setTen(ten);
		listAccount.add(newdangki);
		FileOutputStream file = new FileOutputStream("account.txt");
		BufferedOutputStream bfileout = new BufferedOutputStream(file);
		for (dangnhap i : listAccount) {
			String line = i.getTaikhoan() + "\t" + i.getMatkhau() + "\t" + i.getTen();
			bfileout.write(line.getBytes());
			bfileout.write(System.lineSeparator().getBytes());
		}
		bfileout.close();
	}
}
