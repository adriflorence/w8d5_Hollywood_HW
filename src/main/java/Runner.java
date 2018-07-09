import db.DBActor;
import db.DBDirector;
import db.DBFilm;
import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Actor actor1 = new Actor("Matthew", "Goode", 10000);
        Actor actor2 = new Actor("Bojana", "Novakovic", 8000);
        Actor actor3 = new Actor("Mel", "Gibson", 50000);
        Actor actor4 = new Actor("Leonardo", "DiCaprio", 500000);
        DBHelper.save(actor1);
        DBHelper.save(actor2);
        DBHelper.save(actor3);
        DBHelper.save(actor4);

        Director director1 = new Director("Jonathan", "Teplitzky", 13000);
        Director director2 = new Director("Mel", "Gibson", 70000);
        Director director3 = new Director("Park", "Chan-wook", 20000);
        Director director4 = new Director("Martin", "Scorsese", 20000);
        Director director5 = new Director("Christopher", "Nolan", 500000);
        Director director6 = new Director("James", "Cameron", 500000);
        DBHelper.save(director1);
        DBHelper.save(director2);
        DBHelper.save(director3);
        DBHelper.save(director4);
        DBHelper.save(director5);
        DBHelper.save(director6);

        Studio studio1 = new Studio("Screen Australia", "Australia", 800000);
        Studio studio2 = new Studio("20th Century Fox", "U.S.A.", 1000000);
        Studio studio3 = new Studio("Paramount Pictures", "U.S.A.", 1000000);
        Studio studio4 = new Studio("Warner Bros. Pictures", "U.S.A.", 900000);
        DBHelper.save(studio1);
        DBHelper.save(studio2);
        DBHelper.save(studio3);
        DBHelper.save(studio4);


        Film film1 = new Film("Burning Man", Genre.DRAMA, director1, studio1, 2011);
        Film film2 = new Film("Braveheart", Genre.WAR, director2, studio2, 1995);
        Film film3 = new Film("Stoker", Genre.DRAMA, director2, studio2, 1995);
        Film film4 = new Film("Shutter Island", Genre.DRAMA, director2, studio2, 1995);
        Film film5 = new Film("Titanic", Genre.ROMANCE_DISASTER, director6, studio3, 1997);
        Film film6 = new Film("Inception", Genre.SCI_FI, director5, studio4, 2010);
        DBHelper.save(film1);
        DBHelper.save(film2);
        DBHelper.save(film3);
        DBHelper.save(film4);
        DBHelper.save(film5);
        DBHelper.save(film6);


        List<Film> allFilms = DBHelper.getAll(Film.class);
        List<Actor> allActors = DBHelper.getAll(Actor.class);
        List<Actor> allStudios = DBHelper.getAll(Studio.class);

        DBFilm.addActorToFilm(actor1, film1);
        DBFilm.addActorToFilm(actor2, film1);
        DBFilm.addActorToFilm(actor3, film2);
        DBFilm.addActorToFilm(actor1, film3);
        DBFilm.addActorToFilm(actor4, film4);
        DBFilm.addActorToFilm(actor4, film5);
        DBFilm.addActorToFilm(actor4, film6);

        List<Film> allFilmsFromTeplitzky = DBDirector.allFilmsFromDirector(director1);

        List<Actor> allActorsForBurningMan = DBFilm.getAllActorsForFilm(film1);
        List<Film> allFilmsForMatthewGoode  = DBActor.getAllFilmsForActor(actor1);
        List<Film> allFilmsForMelGibson  = DBActor.getAllFilmsForActor(actor3);

        List<Film> allDramas = DBActor.getAllFilmsByGenre(Genre.DRAMA);
        List<Film> filmsbyGenreForActor = DBActor.getAllFilmsOfActorByGenre(actor3);

    }
}
