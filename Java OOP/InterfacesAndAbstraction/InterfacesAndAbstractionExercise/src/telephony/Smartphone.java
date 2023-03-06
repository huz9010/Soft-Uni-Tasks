package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (!isValidNumber(number)) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (!isValidUrl(url)) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidUrl(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
