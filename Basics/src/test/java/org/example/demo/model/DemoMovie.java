package org.example.demo.model;

import org.example.model.Movie;
import org.example.utils.CsvTools;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class DemoMovie {

    @Test
    void demoMovie(){
        Movie movie1 = new Movie();
        movie1.setTitle("Top Gun");
        Movie movie2 = new Movie("The Mandalorian and Grogu", 2026, 132);
        Movie movie3 = new Movie("Dune Part 3", 2026);
        List<Movie> movies = List.of(movie1, movie2, movie3);
        for (Movie movie: movies) {
            System.out.println(movie);
            System.out.println(MessageFormat.format(
                    "{0} ({1,number,#}, {2} mn)",
                    movie.getTitle(),
                    movie.getYear(),
                    movie.getDuration()
            ));
        }
    }


}
