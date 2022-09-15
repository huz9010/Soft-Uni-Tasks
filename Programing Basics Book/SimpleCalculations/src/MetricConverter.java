import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double value = Double.parseDouble(scanner.nextLine());
        String inmetric = scanner.nextLine().toLowerCase();
        String outmetric = scanner.nextLine().toLowerCase();

        double outvalue = 0;

        //1 meter (m)  1000 millimeters (mm)
        //1 meter (m)  100 centimeters (cm)
        //1 meter (m)  0.000621371192 miles (mi)
        //1 meter (m)  39.3700787 inches (in)
        //1 meter (m)  0.001 kilometers (km)
        //1 meter (m)  3.2808399 feet (ft)
        //1 meter (m)  1.0936133 yards (yd)

        if (inmetric.equals("mm")){
            outvalue = value * 0.001;
        } else if (inmetric.equals("cm")) {
            outvalue = value * 0.01;
        } else if (inmetric.equals("mi")) {
            outvalue = value / 0.000621371192;
        } else if (inmetric.equals("in")) {
            outvalue = value / 39.3700787;
        } else if (inmetric.equals("km")) {
            outvalue = value * 1000;
        } else if (inmetric.equals("ft")) {
            outvalue = value / 3.2808399;
        } else if (inmetric.equals("yd")) {
            outvalue = value / 1.0936133;
        }else if (inmetric.equals("m")) {
            outvalue = value;
        }

        if (outmetric.equals("mm")){
            outvalue = outvalue * 1000;
        } else if (outmetric.equals("cm")) {
            outvalue = outvalue * 100;
        } else if (outmetric.equals("mi")) {
            outvalue = outvalue * 0.000621371192;
        } else if (outmetric.equals("in")) {
            outvalue = outvalue * 39.3700787;
        } else if (outmetric.equals("km")) {
            outvalue = outvalue * 0.001;
        } else if (outmetric.equals("ft")) {
            outvalue = outvalue * 3.2808399;
        } else if (outmetric.equals("yd")) {
            outvalue = outvalue * 1.0936133;
        }else if (outmetric.equals("m")) {
            outvalue = outvalue;
        }

        System.out.println(outvalue);
    }
}
