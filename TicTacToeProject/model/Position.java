package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name = "position" )
public class Position {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "positionValue")
    private int positionValue;

    @Column(name = "marked")
    private String marked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code",unique = true)
    private Session session;

    public int getId() {

        return id;
    }


    public int getPositionValue() {

        return positionValue;
    }


    public void setPositionValue( int positionValue ) {

        this.positionValue = positionValue;
    }


    public String getMarked() {

        return marked;
    }


    public void setMarked( String marked ) {

        this.marked = marked;
    }


    public Session getSession() {

        return session;
    }


    public void setSession( Session session ) {

        this.session = session;
    }
}
