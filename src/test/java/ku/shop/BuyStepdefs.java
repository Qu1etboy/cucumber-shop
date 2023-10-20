// Weerawong Vonggatunyu 6410406860

package ku.shop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Given("the store is ready to service customers")
    public void the_store_is_ready_to_service_customers() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} and stock of {int} exists")
    public void a_product_exists(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @When("a product {string} got sold for {int} pieces")
    public void a_product_got_sold_times(String name, int pieces) {
        Product prod = catalog.getProduct(name);
        prod.cutStock(pieces);
    }

    @Then("leftover stock of {string} should be {int}")
    public void quantity_of_product_should_be(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        assertEquals(quantity, prod.getStock());
    }
}
