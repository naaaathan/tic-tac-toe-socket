package repository;


import model.Position;
import utils.DAOUtils;


import javax.persistence.EntityManager;
import java.util.List;


public class PositionDAO extends DAOUtils {

    private static PositionDAO instance;

    protected EntityManager entityManager;

    public static PositionDAO getInstance() {

        if ( instance == null ) {
            instance = new PositionDAO();
        }
        return instance;
    }


    private PositionDAO() {

        entityManager = getEntityManager();

    }


    public Position getById(int id ) {

        return entityManager.find( Position.class, id );

    }


    public List<Position> getByCode( String code ) {

        return (List<Position>) getEntityManager().createQuery( "select p from Position p where p.session.code = :value order by p.positionValue asc" )
            .setParameter( "value", code ).getResultList();

    }
    

    public void removeByCode( String code ) {

        List< Position > list = getByCode( code );

        for ( Position position : list ) {

            remove( position );

        }
    }
    

    public void persist( Position position ) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist( position );
            entityManager.getTransaction().commit();
        } catch ( Exception ex ) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void remove( Position position ) {

        try {
            entityManager.getTransaction().begin();
            position = entityManager.find( Position.class, position.getId() );
            entityManager.remove( position );
            entityManager.getTransaction().commit();
        } catch ( Exception ex ) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void removeById( int id ) {

        try {
            Position position = getById( id );
            remove( position );
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }

}
