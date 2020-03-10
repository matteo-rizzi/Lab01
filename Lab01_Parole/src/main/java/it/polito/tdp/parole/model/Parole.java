package it.polito.tdp.parole.model;

import java.util.List;
import java.util.*;

public class Parole {

	List<String> parole;

	public Parole() {
		parole = new LinkedList<String>();
	}

	public void addParola(String p) {
		if(p.contains(" "))
			return;
		else
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
