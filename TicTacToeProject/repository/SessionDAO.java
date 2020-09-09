package repository;


import model.Session;
import utils.DAOUtils;



public class SessionDAO extends DAOUtils {

    private static SessionDAO instance;


    // singleton
    public static SessionDAO getInstance() {

        if ( instance == null ) {
            instance = new SessionDAO();
        }

        return instance;
    }


    private SessionDAO() {

        entityManager = getEntityManager();
    }



    public Session getByCode(String code ) {

        return entityManager.find( Session.class, code );

    }


    public void persist( Session state ) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist( state );
            entityManager.getTransaction().commit();
        } catch ( Exception ex ) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void remove( Session state ) {

        try {
            entityManager.getTransaction().begin();
            state = entityManager.find( Session.class, state.getCode() );
            entityManager.remove( state );
            entityManager.getTransaction().commit();
        } catch ( Exception ex ) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void removeById( String code ) {

        try {
            Session state = getByCode( code );
            remove( state );
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }

}
