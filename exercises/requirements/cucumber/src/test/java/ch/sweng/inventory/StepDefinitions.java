package ch.sweng.inventory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;

import static org.junit.Assert.*;

public class StepDefinitions {
    private Inventory inventory;


    @Given("there are {int} sweaters in the inventory")
    public void withXSweatersInInventory(int nSweaters) {
        this.inventory = new Inventory();
        for (int i = 0; i < nSweaters; i++) {
            this.inventory.add(Product.SWEATER);
        }

    }

    @When("I add {int} sweaters in the inventory")
    public void addingXSweaters(int nSweaters){
        for(int i = 0; i < nSweaters; i++){
            this.inventory.add(Product.SWEATER);
        }
    }

    @When("I remove {int} sweaters from the inventory")
    public void iRemoveSweatersFromTheInventory(int nSweaters) {
        for (int i = 0; i < nSweaters; i++) {
            this.inventory.remove(Product.SWEATER);
        }
    }

    @Then("there should be {int}")
    public void checkTotalSweaters(int nSweaters){
        assertEquals(inventory.getProductQuantity(Product.SWEATER), nSweaters);
    }





}

