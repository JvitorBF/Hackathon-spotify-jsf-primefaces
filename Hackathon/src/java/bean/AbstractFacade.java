/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jvbarbosa1
 * @param <T>
 */
// Classe abstrata
public abstract class AbstractFacade<T> {

    // Atributo privado da classe
    // Nome: entityClass
    // entity = entidade. É utilizado para representar a tabela do BD
    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // O EntityManager provê APIs para criar consultas, buscando objetos,
    // sincronizando objetos, e inserindo objetos no banco de dados etc.
    protected abstract EntityManager getEntityManager();

    // Faz o entity persistir
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    // Faz um merge da atual entity com o entity já persistente
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    // Remove o entity
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    // Retorna o objeto pelo ID
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
