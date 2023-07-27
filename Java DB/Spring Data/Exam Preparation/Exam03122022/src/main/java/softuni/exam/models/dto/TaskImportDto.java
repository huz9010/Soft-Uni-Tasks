package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDto {

    @XmlElement(name = "date")
    private String date;
    @XmlElement(name = "price")
    @Positive
    private BigDecimal price;
    @XmlElement(name = "car")
    private TaskImportCarIdDto car;
    @XmlElement(name = "mechanic")
    private TaskImportMechanicFirstNameDto mechanic;
    @XmlElement(name = "part")
    private TaskImportPartIdDto part;


    public TaskImportDto() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TaskImportCarIdDto getCar() {
        return car;
    }

    public void setCar(TaskImportCarIdDto car) {
        this.car = car;
    }

    public TaskImportMechanicFirstNameDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(TaskImportMechanicFirstNameDto mechanic) {
        this.mechanic = mechanic;
    }

    public TaskImportPartIdDto getPart() {
        return part;
    }

    public void setPart(TaskImportPartIdDto part) {
        this.part = part;
    }
}
