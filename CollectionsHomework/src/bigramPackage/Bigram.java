package bigramPackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Bigram {

	public static void main(String[] args) {
		
//		Scanner in = new Scanner(System.in);
		String recenica = "abbcceeeeeeabcc" ;
//		recenica = in.nextLine();
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
		
		String stringZaPredvidjanje = "ja";
		char pocetnoSlovoZaPrevidjanje = 
				stringZaPredvidjanje.charAt(
							(stringZaPredvidjanje.length() - 1));
		String predvidjeniTekst = "";
		
		int brojSlovaZaPredvidjanje = 2;
		
		for(int j = 0; j < brojSlovaZaPredvidjanje; j++){
			i = mapa.entrySet().iterator();
			int frekvencija = 0;
			char predvidjenoSlovo = 0;
			
			while(i.hasNext()){
				Entry<String, Integer> e = (Entry<String, Integer>)i.next();
				if(e.getKey().charAt(0) == pocetnoSlovoZaPrevidjanje){
					if(e.getValue() > frekvencija){
						predvidjenoSlovo = e.getKey().charAt(1);
						frekvencija = e.getValue();
					}
				}
			}
			if(predvidjenoSlovo != 0){
				predvidjeniTekst += predvidjenoSlovo;
				pocetnoSlovoZaPrevidjanje = predvidjenoSlovo;
			}else throw new RuntimeException("Ne postoji bigram koji sadrzi dato slovo");
		}
		System.out.println(predvidjeniTekst);
	}

}
