package it.polito.tdp.parole.model;

import java.util.*;

public class ParoleArray {
	
	List<String> parole;

	public ParoleArray() {
		parole = new ArrayList<String>();
	}

	public void addParola(String p) {
		if (p.isEmpty())
			return;
		char[] pChar = p.toCharArray();
		for (char c : pChar) {
			if (!Character.isLetter(c))
				return;
		}
		p = p.substring(0, 1).toUpperCase() + p.substring(1, p.length()).toLowerCase();
		parole.add(p);
	}

	public List<String> getElenco() {
		LinkedList<String> pTemp = new LinkedList<String>(parole);
		
		Collections.sort(pTemp);
		return pTemp;
	}

	public void reset() {
		parole.clear();
	}
	
	public void cancellaParola(String p) {
		parole.remove(p);
	}

	public String toString() {
		String s = "";
		for (String p : getElenco()) {
			if (s.equals(""))
				s += p;
			else
				s += "\n" + p;
		}
		return s;
	}


}
