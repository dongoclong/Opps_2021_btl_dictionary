package TuDienP1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.File;

public class DictionaryManagement {
	
	Dictionary myDictionary = new Dictionary();
	
	/**
	 * this method use insert list word from command line
	 * return void
	 */
	public void insertFromCommandline(String Viet, String Anh, String Loai) {
		
			Word _word = new Word();
			_word.setWord_target(Anh);
			
			_word.setWord_explain(Viet);
			_word.setWord_type(Loai);
			myDictionary.listWord.add(_word);
		
	}
	
	/**
	 * use insert list word from dictionares
	 * @throws FileNotFoundException
	 */
	public void insertFromFile() throws FileNotFoundException {
		int idxTarget = 0;
		int idxExplain = 1;
		int idxType = 2;
		Scanner scan = new Scanner(new File("dictionaries.txt"));
		while(scan.hasNext()) {
			String stringWord = scan.nextLine();
			String[] parts = stringWord.split("\t");	
			if (parts.length >= 3) {
				Word _word = new Word();
				_word.setWord_target(parts[idxTarget]);
				_word.setWord_explain(parts[idxExplain]);
				_word.setWord_type(parts[idxType]);
				Dictionary.listWord.add(_word);
			} else {
				System.out.println("Gia tri co nhieu nghia");
			}
		}
	}
	
	/**
	 * find the word  and show mean
	 */
	public String[] dictionaryLookup(String text) {
		
		
		String[] s= new String[2];
		for(Word i : Dictionary.listWord) {
			if(i.getWord_target().equalsIgnoreCase(text)) {
				s[0]= (i.getWord_explain());
				s[1]= i.getWord_type();
				return s;
			}
		} return s;
		
	}
	
	/**
	 * check newWord da xuat hien trong tu dien hay chua
	 * @param newWord
	 */
	public boolean checkWord(String newWord) {
		boolean check = false;
		for (Word i : Dictionary.listWord) {
			if (i.getWord_target().equalsIgnoreCase(newWord)) {
				check = true;
				return check;
			}
	    
		}
		return check;	
	}
	
	/**
	 * insert the word from command line
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertWord() throws FileNotFoundException,IOException {
		System.out.println("Nhap tu can them vao: ");
		Scanner scan = new Scanner(System.in);
		String stringWord = scan.nextLine();
		String stringtype = null;
		boolean check = false;
		for (Word i : Dictionary.listWord) {
			if (i.getWord_target().equalsIgnoreCase(stringWord)) {
				System.out.println("Tu nay da co trong tu dien roi ...");
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println("Nhap nghia cua tu nay: ");
			String stringExplain = scan.nextLine();
			Dictionary.listWord.add(new Word(stringWord,stringExplain,stringtype));
			System.out.println("Tu da duoc them vao thanh cong");
		}
	}
	/**
	 * remove word from command line
	 */
	public String removeWord(String word_target) {
		
		boolean check = false;
		
		for	(int i = 0;	i < Dictionary.listWord.size();	i++) {
			Word ans = Dictionary.listWord.get(i);
			if (ans.getWord_target().equalsIgnoreCase(word_target)) {
				Dictionary.listWord.remove(ans);
				check = true;
			}
		}

		if (check) {
			return ("Xóa thành công");
		} 
		else {
			return ("Từ này không có");
		}
	}
	
	
	/**
	 * edit word from command line 
	 */
	public void editWord() {
		System.out.println("Nhap tu can sua: ");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		boolean check = false;
		for (Word i : myDictionary.listWord) {
			if (i.getWord_target().equalsIgnoreCase(word)) {
				System.out.println("Nhap tu moi: ");
				String Newtarget = scan.nextLine();
				i.setWord_target(Newtarget);
				System.out.println("Nghia cua tu moi la: ");
				String Neweplain = scan.nextLine();
				i.setWord_explain(Neweplain);
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println("Tu nay khong co trong tu dien");
		}
	}
	
	public void dictionaryExportToFile() throws FileNotFoundException,IOException {
		FileOutputStream file = new FileOutputStream("dictionaries.txt");
		BufferedOutputStream bfileout = new BufferedOutputStream(file);
		for (Word i : Dictionary.listWord) {
			String line = i.getWord_target() + "\t" + i.getWord_explain() + "\t" + i.getWord_type();
			bfileout.write(line.getBytes());
			bfileout.write(System.lineSeparator().getBytes());
		}
		bfileout.close();
	}
}
