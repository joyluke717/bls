package org.bls.gnt.parse;

public class LemmaTester {
	
	public  static void main(String [] args) {
		String lemma1 = "ἄμωμον";
		String lemma2 = "ἁγιάζω";
		
		for (int i = 0 ; i < lemma1.length(); i++) {
			Character c1 = lemma1.charAt(i);
			Character c2 = lemma2.charAt(i);
			if (c1.charValue() == c2.charValue()) {
				continue;
			}
			else {
				System.out.println(  c1 + " "  + (long) (c2));
			}
		}
	}

}

