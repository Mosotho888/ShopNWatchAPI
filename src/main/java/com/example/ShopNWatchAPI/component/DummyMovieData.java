package com.example.ShopNWatchAPI.component;

import com.example.ShopNWatchAPI.model.movies.*;
import com.example.ShopNWatchAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DummyMovieData implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private FavouriteRepository favouriteRepository;

    @Override
    public void run(String... args) throws Exception {
        // Delete all existing movies (optional)
        movieRepository.deleteAll();

        // Create and save actors
        Actor actor1 = new Actor(null, "Tebogo Mofokeng");
        Actor actor2 = new Actor(null, "Tebu");
        Actor actor3 = new Actor(null, "Lefu");

        List<Actor> actors = Arrays.asList(actor1, actor2, actor3);
        actorRepository.saveAll(actors);

        // Create and save languages
        Language language1 = new Language(null, "English");
        Language language2 = new Language(null, "Sesotho");
        Language language3 = new Language(null, "Korean");

        List<Language> languages = Arrays.asList(language1, language2, language3);
        languageRepository.saveAll(languages);

        // Create and save categories
        Category category1 = new Category(null, "Action");
        Category category2 = new Category(null, "Comedy");
        Category category3 = new Category(null, "Horror");

        List<Category> categories = Arrays.asList(category1, category2, category3);
        categoryRepository.saveAll(categories);

        // Create and save movies
        List<Movie> movies = Arrays.asList(
                new Movie(null, "Inception",
                        9,
                        language1,
                        category1,
                        actor1),
                new Movie(null, "The Shawshank Redemption",
                        10,
                        language2,
                        category2,
                        actor2),
                new Movie(null, "Parasite",
                        8,
                        language3,
                        category3,
                        actor3)
                // Add more movies as needed
        );

        movieRepository.saveAll(movies);

        List<Favourite> favourites = Arrays.asList(
                new Favourite(null, movies.get(1), "tebu1"),
                new Favourite(null, movies.get(2), null)
        );

        favouriteRepository.saveAll(favourites);
    }
}
