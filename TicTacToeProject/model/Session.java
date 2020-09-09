package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "session" )
public class Session {

    @Id
    private String code;

    @Column
    private String current_player;

    public String getCurrent_player() {

        return current_player;
    }


    public void setCurrent_player( String current_player ) {

        this.current_player = current_player;
    }


    public String getCode() {

        return code;
    }


    public void setCode( String code ) {

        this.code = code;
    }
}
