package softuni.exam.models.dto;

import softuni.exam.models.entity.Constellation;

public class StarExportDto {

    private String name;
    private Double lightYears;
    private String description;
    private Constellation constellation;

    public StarExportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    @Override
    public String toString() {
        return String.format("Star: %s%n" +
        "   *Distance: %.2f light years%n" +
        "   **Description: %s%n" +
        "   ***Constellation: %s%n",
                this.name,
                this.lightYears,
                this.description,
                this.constellation.getName());
    }
}
