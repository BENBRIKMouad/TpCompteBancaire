/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.benbrik.tpcomptebancaire.entities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import ma.benbrik.tpcomptebancaire.ejb.GestionnaireCompte;

/**
 *
 * @author benbrik_mouad
 */
@Startup
@Singleton
public class Init {

    @EJB
  private GestionnaireCompte gestionnaireCompte;

  @PostConstruct
  public void initComptes() {
    if (gestionnaireCompte.nbComptes() == 0) {
    gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
    gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
    gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
    gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }
    
  }
}
