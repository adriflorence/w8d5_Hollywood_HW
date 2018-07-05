package db;

import models.Actor;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFilm {

    private static Session session;
    

    public static List<Film> getAllFilms(Actor actor) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq("actor", actor));
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
