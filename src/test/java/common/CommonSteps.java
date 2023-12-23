package common;

import net.thucydides.core.annotations.*;

import static net.serenitybdd.rest.SerenityRest.then;

public class CommonSteps {

		@Step
		public void responseCodeIs(int responseCode) {
			then().statusCode(responseCode);
		}

	}
