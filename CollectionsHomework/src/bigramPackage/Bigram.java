package bigramPackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Bigram {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String recenica = in.nextLine();
		recenica = recenica.replace(" ", "");
		
		Map<String, Integer> mapa = new HashMap<>();
		
		for (int i = 0; i < recenica.length() - 1; i++) {
			String s = recenica.substring(i, i + 2);
			if(mapa.get(s) != null){
				mapa.put(s, mapa.get(s) + 1);
			}else {
				mapa.put(s, 1);
			}
		}
		
		Iterator i = mapa.entrySet().iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
