package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOUtils {

    protected EntityManager entityManager;

    protected EntityManager getEntityManager() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "tictactoe" );

        if ( entityManager == null ) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;

    }


}
