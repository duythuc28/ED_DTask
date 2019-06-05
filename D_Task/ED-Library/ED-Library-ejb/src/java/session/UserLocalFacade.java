/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.LbBook;
import entity.LbUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author iOSDev
 */
@Stateless
public class UserLocalFacade implements UserLocalFacadeLocal {

    @PersistenceContext(unitName = "ED-Library-ejbPU")
    private EntityManager em;
    
    @Override
    public LbUser find(String id) {
        return em.find(LbUser.class, id);
    }
    
    
    @Override
    public LbUser findByEmail(String email) {
        Query query = em.createQuery("SELECT e FROM LbUser e where e.email = :email");
        query.setParameter("email", email);
        return (LbUser) query.getSingleResult();
    }
    

    
}
