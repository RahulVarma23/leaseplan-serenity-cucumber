package common;

import io.restassured.response.Response;
import config.RequestSpec;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.*;

public class SearchProductSteps {

	@Step
	public Response searchTestProducts(String product) {
		return SerenityRest.given().log().uri().spec(RequestSpec.commonSearchRequestSpec()).pathParam("product",product).get("v1/search/demo/{product}");
	}

	@Step
	public Response searchTest() {
		return SerenityRest.given().log().uri().spec(RequestSpec.commonSearchRequestSpec()).get("v1/search/demo");
	}

}
