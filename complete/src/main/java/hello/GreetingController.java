package hello;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private PlayerRepository playerRepository;

    private HashMap<String, Player> playerMap=new HashMap<>();

    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
    public Player greeting(@RequestParam(value="playerId", defaultValue="1") String playerId) {
        return new Batsman("Sachin", "Tendulkar", playerId);
    }

    @RequestMapping("/players")
    public Player players(@RequestParam(value="playerId", defaultValue="1") String playerId) {
        return playerMap.get(playerId);
    }

    @RequestMapping(value = "/players", method=RequestMethod.PUT)
    public String players(@RequestParam(value="playerId", defaultValue="1") String playerId,
                         String fName, String lName) {
        playerMap.put(playerId, new Batsman(fName, lName, playerId));
        return "Player "+playerId+" added";
    }

    @RequestMapping(value = "/playerFromRepo")
    public Player playerFromRepo(@RequestParam(value="playerId", defaultValue="1") String playerId) {
        if (null!=playerRepository.findOne(playerId)) {
            return playerRepository.findOne(playerId);
        } else {
            return playerRepository.findByLName("Chanjeevaram").get(0);
        }
    }

    @RequestMapping(value = "/playerFromRepo", method=RequestMethod.PUT)
    public String playerFromRepo(@RequestParam(value="playerId", defaultValue="1") String playerId,
                                 String fName, String lName) {
        playerRepository.save(new Batsman(fName, lName, playerId));
        return "Player "+playerId+" added";
    }
}