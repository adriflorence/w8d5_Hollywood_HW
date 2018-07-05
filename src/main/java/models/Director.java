package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="directors")
public class Director extends CrewMember {

    private List<Film> films;

    public Director() {
        this.films = new ArrayList<Film>();
    }

    public Director(String first_name, String last_name, int money) {
        super(first_name, last_name, money);
    }

    // one director can have many films, one film can only have one director (in this case)
    @OneToMany(mappedBy="director", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
