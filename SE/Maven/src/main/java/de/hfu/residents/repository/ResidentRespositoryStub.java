package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRespositoryStub implements ResidentRepository {

	List<Resident> einwohner = new ArrayList<Resident>();
	
	@Override
	public List<Resident> getResidents() {
		return einwohner;
	}

	
	public void add(Resident element) {
		einwohner.add(element);
		
	}
	
	
	
	
}
