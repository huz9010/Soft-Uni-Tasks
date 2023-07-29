package softuni.exam.models.entity;

import softuni.exam.constants.enumeration.StarType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

    private String name;
    private Double lightYears;
    private String description;
    private StarType starType;
    private Constellation constellation;
    private List<Astronomer> observers;

    public Star() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "light_years", nullable = false)
    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    @Column(columnDefinition = "TEXT" ,nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "star_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    @ManyToOne
    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    @OneToMany(mappedBy = "observingStar")
    public List<Astronomer> getObservers() {
        return observers;
    }

    public void setObservers(List<Astronomer> observers) {
        this.observers = observers;
    }
}
