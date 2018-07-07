package db;

import models.Actor;
import models.Film;
import models.Genre;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBActor {

    private static Session session;

    public static List<Film> getAllFilmsForActor(Actor actor) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("films", "film");
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Film> getAllFilmsByGenre(Genre genre) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq("genre", genre));
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
