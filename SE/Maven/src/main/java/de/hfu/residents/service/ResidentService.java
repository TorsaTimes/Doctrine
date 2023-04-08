package de.hfu.residents.service;

import java.util.List;

import de.hfu.residents.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentService {//blabla

  Resident getUniqueResident(Resident filterResident) throws ResidentServiceException;

  List<Resident> getFilteredResidentsList(Resident filterResident);
  
  //kommentar für letzte Aufgabe 

}