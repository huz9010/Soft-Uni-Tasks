package military_elite;

public class SpecialisedSoldier extends Private implements SpecialisedInterface{

    private Corps corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary,String corps) {
        super(id, firstName, lastName, salary);
        this.corps = Corps.valueOf(corps);
    }

    @Override
    public Corps getCorps() {
        return corps;
    }
}
