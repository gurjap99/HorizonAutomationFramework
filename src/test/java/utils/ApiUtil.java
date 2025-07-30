package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtil {

    private static final String BASE_URL = "https://horizonservices-test.acsf.horizonservices.com";
    private static final String TOKEN_URL = BASE_URL + "/oauth/token";
    private static final String GRAPHQL_URL = BASE_URL + "/graphql";
    private static final String CLIENT_ID = ConfigReader.get("client_id");
    private static final String CLIENT_SECRET = ConfigReader.get("client_secret");

    private static final String query = """
        query MyQuery {
          qAoffersOverviewGraphql {
            display
            results {
              ... on NodeOffer {
                id
                title
                icon {
                  ... on MediaIcon {
                    id
                    name
                    mediaImage1 {
                      alt
                      url
                    }
                  }
                }
                teaserText {
                  processed
                  format
                  value
                }
                details {
                  format
                  processed
                  value
                }
                expiryDate {
                  time
                  timestamp
                  timezone
                }
                daysToAdd
                automaticallyRenew
                timeUnit
                priceCurrency
                price
                weight
              }
            }
          }
        }
    """;

    private static String accessToken;

    static {
        accessToken = fetchAccessToken();
    }

    private static String fetchAccessToken() {
        RestAssured.useRelaxedHTTPSValidation();
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", CLIENT_ID)
                .formParam("client_secret", CLIENT_SECRET)
                .post(TOKEN_URL);

        response.then().statusCode(200);
        return response.jsonPath().getString("access_token");
    }

    public static JsonObject sendGraphQLQuery(String query) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("query", query);

        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(GRAPHQL_URL);

        response.then().statusCode(200);
        return JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
    }

    public static String getExpiryDateByTitle(String title) {
        JsonObject responseJson = sendGraphQLQuery(query);
        JsonArray results = responseJson
                .getAsJsonObject("data")
                .getAsJsonObject("qAoffersOverviewGraphql")
                .getAsJsonArray("results");

        for (JsonElement element : results) {
            JsonObject offer = element.getAsJsonObject();
            String offerTitle = offer.get("title").getAsString().trim();

            if (offerTitle.equalsIgnoreCase(title.trim())) {
                JsonObject expiryDate = offer.getAsJsonObject("expiryDate");
                return expiryDate.get("time").getAsString();
            }
        }
        return null;
    }
}
