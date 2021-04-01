package it.polito.tdp.corsi.model;

import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	CorsoDAO corsi;
	
	public Model() {
		corsi = new CorsoDAO();
	}
	
	public List<Corso> getCorsiPerPd(int pd){
		return corsi.getCorsiPerPd(pd);
	}
	public int NumIscrittiPerPD(Integer periodoDidatico) {
		return corsi.NumIscrittiPerPD(periodoDidatico);
	}
}
