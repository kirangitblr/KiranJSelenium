package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testcomponents.BaseTest;
import rahulshettyacademy.testcomponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException {
		

		landingPage.loginApplication("kiranblrj@gmail.com", "Hokko@12345");

		Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());
		System.out.println("test");

	}

	@Test
	public void productErrorValidation() throws IOException {
		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("kiranblrj@gmail.com", "Hokko@1234");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay("ZARACOAT33");
		Assert.assertFalse(match);

	}

}
