/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Music;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jvbarbosa1
 */
@Stateless
public class MusicFacade extends AbstractFacade<Music> {

    // Interface como privada para acessarmos pelo método getEntityManager()
    @PersistenceContext(unitName = "HackathonPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MusicFacade() {
        super(Music.class);
    }
}
