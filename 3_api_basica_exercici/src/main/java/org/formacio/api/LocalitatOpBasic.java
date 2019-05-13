package org.formacio.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */
@Component
public class LocalitatOpBasic {
	
	@PersistenceContext
    private EntityManager entityManager = null;
	Localitat localitat = new Localitat();
	
	public Localitat carrega (long id) {
		Localitat localitat = entityManager.find(Localitat.class, id);
        return localitat;
	}
	
	@Transactional
	public void alta (String nom, Integer habitants) {
		localitat.setNom(nom);
		localitat.setHabitants(habitants);
		entityManager.persist(localitat);
	}
	
	@Transactional
	public void elimina (long id) {
		Localitat eliminarLocalitat = this.carrega(id);
		entityManager.remove(eliminarLocalitat);
	}
	
	public void modifica (Localitat localitat) {
	}

}
