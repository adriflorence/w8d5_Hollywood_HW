import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Actor actor1, actor2;
    Studio studio1, studio2;
    Director director1, director2;
    Film film1, film2;

    @Before
    public void setUp() throws Exception {
        actor1 = new Actor("Matthew", "Goode", 100000);
        actor2 = new Actor("Bojana", "Novakovic", 80000);

        studio1 = new Studio("Screen Australia", "Australia", 800000);
        studio2 = new Studio("Indian Paintbrush", "U.S.A.", 1000000);

        director1 = new Director("Jonathan", "Teplitzky", 130000);
        director2 = new Director("Chan-wook", "Park", 450000);

        film1 = new Film("Burning Man", Genre.DRAMA, director1, studio1, 2011);
        film2 = new Film("Stoker", Genre.DRAMA, director2, studio1, 2013);
    }

    @Test
    public void canAddFilm(){
        assertEquals(0, actor1.getFilms().size());
        actor1.addFilm(film1);
        assertEquals(1, actor1.getFilms().size());
    }

    @Test
    public void canGetPaid(){
        assertEquals(100000, actor1.getMoney());
        assertEquals(800000, studio1.getBudget());
        studio1.payActor(actor1, 30000);
        assertEquals(130000, actor1.getMoney());
        assertEquals(770000, studio1.getBudget());
    }
}
