package hello;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by tkmagh5 on 3/2/17.
 */

public interface PlayerRepository extends CrudRepository<Player, String> {
    List<Player> findByLName(String lName);
}