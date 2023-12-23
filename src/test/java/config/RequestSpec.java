package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.*;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class RequestSpec {

	private static final EnvironmentVariables environmentVariables = Injectors.getInjector()
			.getInstance(EnvironmentVariables.class);

	private static final String BASE_URL = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("baseurl");

	public static RequestSpecification commonSearchRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.setBasePath("api")
				.setContentType("application/json")
				.build();
	}
}
