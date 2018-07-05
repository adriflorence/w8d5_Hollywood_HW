package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actors")
public class Actor extends CrewMember {

//    private List<Film> films;

    public Actor() {
    }

    public Actor(String first_name, String last_name, int money) {
        super(first_name, last_name, money);
//        this.films = new ArrayList<Film>();
    }


//    public List<Film> getFilms() {
//        return films;
//    }
//
//    public void setFilms(List<Film> films) {
//        this.films = films;
//    }
}
