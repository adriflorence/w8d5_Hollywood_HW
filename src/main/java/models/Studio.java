package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="studios")
public class Studio {

    private int id;
    private String name;
    private String location;
    private List<Film> films;

    public Studio() {
    }

    public Studio(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // one studio has many films, one film can only have one studio
    @OneToMany(mappedBy="studio", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
