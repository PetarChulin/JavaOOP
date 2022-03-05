package Problem5Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;


    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public String call() {
        StringBuilder build = new StringBuilder();
        for (String number : numbers) {
            if (number.chars().anyMatch(Character::isLetter)) {
                build.append("Invalid number!").append("\n");
            } else {
                build.append(String.format("Calling... %s", number)).append("\n");
            }
        }
        return build.toString();
    }

    public String browse() {
        StringBuilder build = new StringBuilder();
        for (String url : urls) {
            if (url.chars().anyMatch(Character::isDigit)) {
                build.append("Invalid URL!").append("\n");
            } else {
                build.append(String.format("Browsing: %s!", url)).append("\n");
            }
        }
        return build.toString();
    }
}
