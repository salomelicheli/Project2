package ge.tbc.tbcitacademy.data;

import org.testng.annotations.DataProvider;

public class PricesData {
    @DataProvider
    public static Object[][] priceData(){
        return new Object[][] {
                {40, 80},
                {75, 113},
                {111, 140},
                {130, 170},
                {160, 200}
        };
    }
}
