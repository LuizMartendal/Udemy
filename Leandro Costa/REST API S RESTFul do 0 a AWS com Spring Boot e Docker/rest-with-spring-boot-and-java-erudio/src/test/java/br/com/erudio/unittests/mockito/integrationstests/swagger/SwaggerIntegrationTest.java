package br.com.erudio.unittests.mockito.integrationstests.swagger;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.erudio.unittests.mockito.configs.TestConfigs;
import br.com.erudio.unittests.mockito.integrationstests.testcontainer.AbstracticIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstracticIntegrationTest {

    @Test
    public void showDisplaySwaggerUiPage() {
        var content = given()
                .basePath("swagger-ui.html")
                    .port(TestConfigs.SERVER_PORT)
                    .when()
                        .get()
                    .then()
                        .statusCode(200)
                    .extract()
                        .body().asString();
        assertTrue(content.contains("Swagger UI"));
    }
}
