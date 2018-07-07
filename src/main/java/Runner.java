import db.DBActor;
import db.DBFilm;
import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Actor actor1 = new Actor("Matthew", "Goode", 10000);
        Actor actor2 = new Actor("Bojana", "Novakovic", 8000);
        Actor actor3 = new Actor("Mel", "Gibson", 50000);
        DBHelper.save(actor1);
        DBHelper.save(actor2);
        DBHelper.save(actor3);

        Director director1 = new Director("Jonathan", "Teplitzky", 13000);
        Director director2 = new Director("Mel", "Gibson", 13000);
        DBHelper.save(director1);
        DBHelper.save(director2);

        Studio studio1 = new Studio("Screen Australia", "Australia", 800000);
        DBHelper.save(studio1);
        Studio studio2 = new Studio("20th Century Fox", "U.S.A.", 1000000);
        DBHelper.save(studio2);



        Film film1 = new Film("Burning Man", Genre.DRAMA, director1, studio1, 2011);
        Film film2 = new Film("Braveheart", Genre.WAR, director2, studio2, 1995);
        DBHelper.save(film1);
        DBHelper.save(film2);


        List<Film> allFilms = DBHelper.getAll(Film.class);

        List<Actor> allActors = DBHelper.getAll(Actor.class);

        DBFilm.addActorToCast(actor1, film1);
        DBFilm.addActorToCast(actor2, film1);

        List<Actor> allActorsForFilm = DBFilm.getAllActorsForFilm(film1);
//        List<Film> allFilmsForActor  = DBActor.getAllFilmsForActor(actor1);

//        List<Film> allDramaByActor = DBActor.getAllFilmsByGenre(Genre.DRAMA);
    }
}
