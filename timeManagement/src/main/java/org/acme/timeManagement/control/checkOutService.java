package org.acme.timeManagement;

import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class checkOutService{

    @Inject 
    EntityManager em;

    @Transactional
    public void checkOut(String id){
        Query query = em.createNamedQuery("timeElement.findLastElementForUser");
        query.setParameter("userId", id);
        int lastElementId = (int)query.getSingleResult();
        timeElement timeElement = em.find(timeElement.class, lastElementId);
        if (timeElement == null || timeElement.getCheckOutTime() != 0){
            throw new NoResultException("No check in found for user");
        }
        timeElement.setCheckOutTime(System.currentTimeMillis());
        em.persist(timeElement);
    }

}
