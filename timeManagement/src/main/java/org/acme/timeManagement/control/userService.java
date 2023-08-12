package org.acme.timeManagement;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class userService{

   @Inject 
   EntityManager em;

   @Transactional
   public void createUser(){
       User user = new User();
       user.setFirstName("first");
       user.setLastName("last");
       user.setEmail("");  
       em.persist(user);
   }

   public User getUser(int id){
       return em.find(User.class, id);
   }
}
