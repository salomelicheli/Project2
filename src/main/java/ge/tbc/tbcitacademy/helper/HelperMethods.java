package ge.tbc.tbcitacademy.helper;

import com.codeborne.selenide.SelenideElement;

public class HelperMethods {
    public static double extractPrice(SelenideElement element){
        String numericText = element.getText().replaceAll("[^\\d.]", "");
        if (!numericText.isEmpty()) {
            try {
                return Double.parseDouble(numericText);
            } catch (NumberFormatException e) {
                System.err.println("Failed to parse: " + numericText);
                return -1;
            }
        }
        return -1;
    }
}
