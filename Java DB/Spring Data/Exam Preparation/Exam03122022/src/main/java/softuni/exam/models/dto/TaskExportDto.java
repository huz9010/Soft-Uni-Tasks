package softuni.exam.models.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class TaskExportDto {

    private Long id;
    private BigDecimal price;
    private CarBasicInfoDto car;
    private MechanicBasicInfoSto mechanic;

    public TaskExportDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarBasicInfoDto getCar() {
        return car;
    }

    public void setCar(CarBasicInfoDto car) {
        this.car = car;
    }

    public MechanicBasicInfoSto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBasicInfoSto mechanic) {
        this.mechanic = mechanic;
    }

    @Override
    public String toString() {
        DecimalFormat engineDf = new DecimalFormat("#.0#", new DecimalFormatSymbols(Locale.US));
        DecimalFormat priceDf = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US));
        String FORMAT = "Car %s %s with %dkm%n" +
                "-Mechanic: %s %s - task №%d:%n" +
                " --Engine: %s%n" +
                "---Price: %s$%n";
        return String.format(FORMAT,
                this.car.getCarMake(), this.car.getCarModel(), this.car.getKilometers(),
                this.mechanic.getFirstName(), this.mechanic.getLastName(), this.id,
                engineDf.format(this.car.getEngine()),
                priceDf.format(this.price));
    }
}
