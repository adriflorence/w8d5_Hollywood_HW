import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    Film film1;
    Director director1;
    Actor actor1, actor2;
    Studio studio1;

    @Before
    public void setUp() throws Exception {
        actor1 = new Actor("Matthew", "Goode", 10000);
        actor2 = new Actor("Bojana", "Novakovic", 8000);
        studio1 = new Studio("Screen Australia", "Australia", 800000);
        director1 = new Director("Jonathan", "Teplitzky", 13000);
        film1 = new Film("Burning Man", Genre.DRAMA, director1, studio1, 2011);
    }

    @Test
    public void canAddActor(){
        assertEquals(0, film1.getCast().size());
        film1.addActor(actor1);
        film1.addActor(actor2);
        assertEquals(2, film1.getCast().size());
    }
}
