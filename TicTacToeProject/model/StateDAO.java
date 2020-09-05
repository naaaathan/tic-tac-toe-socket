package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StateDAO {

    private static StateDAO instance;
    protected EntityManager entityManager;

    //singleton
    public static StateDAO getInstance (){

        if(instance == null){
            instance = new StateDAO();
        }

        return instance;
    }

    private StateDAO(){

        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("tictactoe");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public State getByCode(String code){

        return entityManager.find(State.class,code);

    }

    public void persist(State state) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(state);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(State state) {
        try {
            entityManager.getTransaction().begin();
            state = entityManager.find(State.class, state.getCode());
            entityManager.remove(state);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(String code) {
        try {
            State state = getByCode(code);
            remove(state);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }




}
