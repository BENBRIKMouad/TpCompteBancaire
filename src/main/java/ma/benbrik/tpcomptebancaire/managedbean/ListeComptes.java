/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.benbrik.tpcomptebancaire.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import ma.benbrik.tpcomptebancaire.ejb.GestionnaireCompte;
import ma.benbrik.tpcomptebancaire.entities.CompteBancaire;

/**
 *
 * @author benbrik_mouad
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable{
private List<CompteBancaire> customerList; 
    
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }
    
     public List<CompteBancaire> getAllCustomers(){
        if (customerList == null)
            customerList = gestionnaireCompte.getAllComptes();
        return customerList;
    }
    public String supprimer(CompteBancaire compte) {
        gestionnaireCompte.supprimer(compte);
        Util.addFlashInfoMessage("Compte de " + compte.getNom() + " supprimé");
  return "listeComptes?faces-redirect=true";
  }
}
