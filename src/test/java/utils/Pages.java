package utils;

import lombok.Getter;
import Pages.*;

@Getter
public class Pages {
    protected BasePage basePage;
    protected LandingPage landingPage;
    protected HomePage homePage;
    protected MyCartPage myCartPage;
    protected Header header;
    protected PaymentPage paymentPage;

    public Pages(){
        this.basePage = new BasePage();
        this.landingPage = new LandingPage();
        this.homePage = new HomePage();
        this.myCartPage = new MyCartPage();
        this.header = new Header();
        this.paymentPage = new PaymentPage();
    }
}