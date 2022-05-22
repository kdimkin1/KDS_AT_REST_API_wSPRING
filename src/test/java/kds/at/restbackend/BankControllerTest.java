package kds.at.restbackend;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import kds.at.restbackend.domain.UserInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.with;

public class BankControllerTest {

    static {
        RestAssured.baseURI = "http://localhost:8081";
    }
    private RequestSpecification spec =
            with()
                    .baseUri("http://localhost:8081")
                    .basePath("/");

    @Test
    @Tag("lessonTests")
    void bankControllerTest() {
        UserInfo[] userInfos = spec.get("user/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);

        Stream.of(userInfos)
                .filter(userInfo -> userInfo.getUserName().equals("Dima"))
                .peek(userInfo -> System.out.println(userInfo.getUserName()))
                .map(userInfo -> userInfo.toString())
                .collect(Collectors.toList());
    }
}
