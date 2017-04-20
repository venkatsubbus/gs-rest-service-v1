package hello;

import javax.persistence.Entity;

/**
 * Created by tkmagh5 on 2/27/17.
 */

@Entity
public class Batsman extends Player {
    public Batsman(String fName, String lName, String playerId) {
        super(fName, lName, playerId);
    }

    public Batsman() {
        super();
    }
}