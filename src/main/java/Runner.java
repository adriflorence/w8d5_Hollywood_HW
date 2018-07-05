import db.DBFilm;
import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Actor actor1 = new Actor("Matthew", "Goode", 10000);
        Actor actor2 = new Actor("Bojana", "Novakovic", 8000);
        DBHelper.save(actor1);
        DBHelper.save(actor2);

        Director director1 = new Director("Jonathan", "Teplitzky", 13000);
        DBHelper.save(director1);
        Studio studio1 = new Studio("Screen Australia", "Australia");
        DBHelper.save(studio1);
        Film film1 = new Film("Burning Man", Genre.DRAMA, director1, studio1, 2011);
        DBHelper.save(film1);

        List<Film> allFilms = DBHelper.getAll(Film.class);
        List<Film> allFilmsForActor = DBFilm.getAllFilms(actor1);
    }
}
