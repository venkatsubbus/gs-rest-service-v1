package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by tkmagh5 on 2/23/17.
 */
@Entity
public abstract class Player {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    protected String playerId;

    protected String fName;
    protected String lName;

    public Player (String fName, String lName, String playerId) {
        this.fName=fName;
        this.lName=lName;
        this.playerId=playerId;
    }

    public Player() {}

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPlayerId() {
        return playerId;
    }
}