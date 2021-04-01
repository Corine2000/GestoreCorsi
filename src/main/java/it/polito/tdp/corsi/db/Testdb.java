package it.polito.tdp.corsi.db;

import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class Testdb {

	public static void main(String[] args) {
		
		CorsoDAO cdao = new CorsoDAO();
		List<Corso> list =cdao.getCorsiPerPd(1);
		
		for(Corso c: list)
		System.out.println(c.getCodins()+"  "+c.getCrediti()+"  "+c.getNome()+"  "+c.getPd());
		
		System.out.println("\n************Numero Iscritti*************");
		System.out.println(cdao.NumIscrittiPerPD(1));

	}

}
