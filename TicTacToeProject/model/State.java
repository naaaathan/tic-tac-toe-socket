package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "state" )
public class State {

    @Id
    private String code;

    @Column
    private int position;

    @Column
    private String isMarked;

    public void setCode( String code ) {

        this.code = code;
    }


    public void setPosition( int position ) {

        this.position = position;
    }


    public void setIsMarked( String isMarked ) {

        this.isMarked = isMarked;
    }


    public String getCode() {

        return code;
    }


    public int getPosition() {

        return position;
    }


    public String getIsMarked() {

        return isMarked;
    }
}
