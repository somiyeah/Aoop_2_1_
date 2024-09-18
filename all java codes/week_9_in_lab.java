import java.util.*;

class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movie m) {
        return this.year - m.getYear();
    }

    @Override
    public String toString() {
        return this.name + " " + this.rating + " " + this.year;
    }
}

public class week_9_in_lab {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie A", 8.7, 2022));
        movies.add(new Movie("Movie B", 7.4, 2021));
        movies.add(new Movie("Movie C", 9.0, 2023));

        Collections.sort(movies);

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
