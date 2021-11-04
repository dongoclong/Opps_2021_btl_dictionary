package TuDienP1;

import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DictionaryCommandline {
	
	DictionaryManagement dictionaryManagemment = new DictionaryManagement();
	
	/**
	 * the method use show all word in dictionary
	 */
	public void showAllWord() {
		Dictionary myDictionary = new Dictionary();
		int count = 1;
		System.out.println("No     | English  \t| Vietnamses");
		for(Word i : myDictionary.listWord) {
			System.out.println(count + "      |" + i.getWord_target() + "\t\t|" + i.getWord_explain());
			count++;
		}
	}
	
	/**
	 * the method dictionary basic from version 1
	 * insert the list word from command line
	 * call insertFromCommandlinde method and showAllWord method 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void dictionaryBasic() throws FileNotFoundException, IOException {
		//dictionaryManagemment.insertFromCommandline();
		//dictionaryManagemment.removeWord();
		dictionaryManagemment.editWord();
		dictionaryManagemment.insertWord();
		this.showAllWord();
	}
	
	public void dictionaryAdvanced() throws FileNotFoundException, IOException{
		dictionaryManagemment.insertFromFile();
		//dictionaryManagemment.dictionaryLookup();
		//dictionaryManagemment.dictionaryExportToFile();
		//this.showAllWord();
		//this.dictionarySreach();
	}

	// k dung
	public String[] dictionarySreach(String s) {
		
		
		
		String [] a= new String[100];
//		forEach duyet listWord
//		i.getWord_target().indexOf(s) dung de kiem tra co bao nhieu tu bat dau bang s or cung co the la s.target giong trong listWord
		int i=0;
		for( Word word : Dictionary.listWord) {			
			int index = word.getWord_target().indexOf(s);
			if	(index == 0) {
				a[i]=word.getWord_target()+ "\r\n";
			}
		}
		
		return a;
	}
	
	public ArrayList<Word> dictionarySearch1(String input) {
		ArrayList<Word> list = new ArrayList<>();
		for( Word word : Dictionary.listWord) {			
			int index = word.getWord_target().toUpperCase().indexOf(input.toUpperCase());
			if	(index == 0) {
				list.add(word);
			}
		}
		return list;
	}
	
	public String[] searchFive(String word) {
		
		String [] s = new String[5];
		String [] str = new String[1];
		ArrayList<Word> list = this.dictionarySearch1(word);
		if (list.size() == 0) {
			str[0] = "Không có";
			return str;
		} else  if (list.size() > 6) {
			List<Word> fiveElement = list.subList(0, 5);
			s = this.showListWord(fiveElement);
			return s;
		} else {
			s = this.showListWord(list);
			return s;
		}
	}
	
	public String[] showListWord(List<Word> list) {
		String[] result = new String[5];
		int j=0;
		for(Word i : list) {
			String wResult =  i.getWord_target()+ "\n";
			result[j] = wResult;
			j++;
		}
		return result; 
	}
	
	
}
