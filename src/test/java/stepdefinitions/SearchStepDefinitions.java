package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import common.SearchProductSteps;
import common.CommonSteps;
import net.thucydides.core.annotations.Steps;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinitions {

    @Steps
    public CommonSteps commonSteps;

    @Steps
    public SearchProductSteps searchProductSteps;

    @When("^I call the get search test product endpoint (.*)$")
    public void iCallTheGetSearchProductEndpoint(String product) {
        searchProductSteps.searchTestProducts(product);
    }

    @When("I call the get search test endpoint")
    public void iCallTheGetSearchTestEndpoint() {
        searchProductSteps.searchTest();
    }

    @Then("verify the search results of product should be displayed")
    public void theSearchResultsOfProductShouldBeDisplayed(){ commonSteps.responseCodeIs(200);
    }

    @Then("verify not found error should be displayed in search results")
    public void notFoundErrorShouldBeDisplayedInSearchResult() {
        then().statusCode(404).body("detail.error", is(true));
    }

    @Then("verify unauthorized error should be displayed in search result")
    public void unauthorizedErrorShouldBeDisplayedInSearchResult() {
        then().statusCode(401).body("detail", is("Not authenticated"));
    }
}
