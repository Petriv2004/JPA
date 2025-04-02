/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RayAj
 */
public class PersistenceManager {
    
    public static final boolean DEBUG=true;
    private static final PersistenceManager singleton = new PersistenceManager();
    protected EntityManagerFactory emf;

    private PersistenceManager() {
    }
    
    public static PersistenceManager getInstance(){
        return singleton;
    }

    public static PersistenceManager getSingleton() {
        return singleton;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if(emf==null){
            createEntityManagerFactory();
        }
        return emf;
    }
    

    protected void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("CompetitorsPU", System.getProperties());
        if(DEBUG){
            System.out.println("Persistence started at " + new java.util.Date());
        }
    }
    
    public void closeEntitymanagerFactory(){
        if(emf != null){
            emf.close();
            emf=null;
            
            if(DEBUG){
                System.out.println("Persistence finished at + " + new java.util.Date());
            }
        }
    }
    
}
