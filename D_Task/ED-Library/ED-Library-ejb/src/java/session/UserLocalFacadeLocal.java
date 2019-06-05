/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.LbUser;
import javax.ejb.Local;

/**
 *
 * @author iOSDev
 */
@Local
public interface UserLocalFacadeLocal {
    LbUser find(String id);
    LbUser findByEmail(String email); 
}
