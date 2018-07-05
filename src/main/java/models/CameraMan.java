package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cameramen")
public class CameraMan extends CrewMember {

    private String camera;

    public CameraMan() {
    }

    public CameraMan(String first_name, String last_name, int money, String camera) {
        super(first_name, last_name, money);
        this.camera = camera;
    }

    @Column(name="camera")
    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }
}
