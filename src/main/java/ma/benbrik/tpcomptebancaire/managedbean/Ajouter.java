/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.benbrik.tpcomptebancaire.managedbean;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import ma.benbrik.tpcomptebancaire.ejb.GestionnaireCompte;
import ma.benbrik.tpcomptebancaire.entities.CompteBancaire;

/**
 *
 * @author benbrik_mouad
 */
@Named(value = "ajouter")
@RequestScoped
public class Ajouter {
    private String nom;
    private int solde;
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    /**
     * Creates a new instance of Ajouter
     */
    public Ajouter() {
    }
    public String  ajouter(){
        gestionnaireCompte.creerCompte(new CompteBancaire(nom, solde));
        return "listeComptes?faces-redirect=true";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    
}
