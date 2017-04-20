package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    //private PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public String demo(PlayerRepository playerRepository) {
//        //this.playerRepository = playerRepository;
//        //playerRepository.findOne("");
//        return "demo done!";
//    }
}