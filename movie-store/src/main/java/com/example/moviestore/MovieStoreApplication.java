package com.example.moviestore;

import com.example.moviestore.model.Movie;
import com.example.moviestore.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner init(MovieRepository repo) {
        return args -> {
            repo.save(new Movie(null, "Inception", "Sci-Fi", 2010,
                    "A thief enters people's dreams to steal their secrets.", 12.99));
            repo.save(new Movie(null, "The Godfather", "Drama", 1972,
                    "The aging patriarch of an organized crime dynasty transfers control to his reluctant son.", 14.50));
            repo.save(new Movie(null, "The Dark Knight", "Action", 2008,
                    "Batman faces the Joker, a criminal mastermind unleashing chaos on Gotham.", 11.99));
            repo.save(new Movie(null, "Forrest Gump", "Drama", 1994,
                    "The life story of Forrest, a simple man with a big heart.", 9.99));
            repo.save(new Movie(null, "Interstellar", "Sci-Fi", 2014,
                    "A group of astronauts travels through a wormhole in search of a new home for humanity.", 13.50));
            repo.save(new Movie(null, "Home Alone", "Family", 1990,
                    "A young boy defends his home from burglars after being left behind.", 8.75));
            repo.save(new Movie(null, "Toy Story", "Animation", 1995,
                    "Toys come to life when humans aren't around and go on adventures.", 7.99));
            repo.save(new Movie(null, "The Matrix", "Sci-Fi", 1999,
                    "A hacker discovers reality is a simulation and joins the rebellion.", 10.49));
            repo.save(new Movie(null, "The Lion King", "Animation", 1994,
                    "A lion cub must embrace his destiny as king of the savanna.", 8.99));
            repo.save(new Movie(null, "Shrek", "Comedy", 2001,
                    "An ogre goes on a quest to rescue a princess and reclaim his swamp.", 9.50));
            repo.save(new Movie(null, "Finding Nemo", "Family", 2003,
                    "A clownfish travels across the ocean to find his missing son.", 8.25));
            repo.save(new Movie(null, "Avengers: Endgame", "Action", 2019,
                    "The Avengers unite for a final battle against Thanos to save the universe.", 14.75));
            repo.save(new Movie(null, "Titanic", "Romance", 1997,
                    "A love story unfolds aboard the ill-fated RMS Titanic.", 11.5));
            repo.save(new Movie(null, "La La Land", "Romance", 2016,
                    "A jazz musician and aspiring actress fall in love in Los Angeles.", 10.5));
        };
    }
}