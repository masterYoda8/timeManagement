package org.acme.timeManagement;

import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class checkInService{
    @Inject 
    EntityManager em;
    
    @Transactional
    public boolean checkIn(String id){
        timeElement timeElement = new timeElement(); 
        timeElement.setUserId(id);
        timeElement.setCheckInTime(System.currentTimeMillis());
        try{
            em.persist(timeElement);
        }catch(Exception e){
            return false;
        }
        return true;
        
    }

}
