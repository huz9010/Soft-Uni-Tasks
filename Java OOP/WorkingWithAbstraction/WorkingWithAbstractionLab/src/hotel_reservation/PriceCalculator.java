package hotel_reservation;

public class PriceCalculator {

    public static double calculateHoliday(double pricePerDay, int numberOfDays, Season season, Discount discountType)    {
        return pricePerDay * season.getValue() * numberOfDays * ((100.0 - discountType.getValue()) / 100);
    }
}
