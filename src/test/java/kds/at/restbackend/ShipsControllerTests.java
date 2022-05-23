package kds.at.restbackend;

import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import kds.at.restbackend.domain.ShipsInfo;
import kds.at.restbackend.domain.ShipsStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.stream.Stream;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static listeners.CustomAllureListener.withCustomTemplates;
import static org.assertj.core.api.Assertions.assertThat;
public class ShipsControllerTests {
    static {
        RestAssured.baseURI = "http://localhost:8081";
    }
    private RequestSpecification spec =
            with()
                    .baseUri("http://localhost:8081")
                    .basePath("/");
    @Test
    @Story("Ships")
    @DisplayName("Positive:Get all ships from test fleet (ships/getAll)")
    void shipsGetAllPositiveTest() {
        ShipsInfo[] shipsInfo =
                given()
                        .filter(withCustomTemplates())
                        .when()
                        .get("ships/getAll")
                        .then()
                        .log().body()
                        .statusCode(200)
                        .extract()
                        .as(ShipsInfo[].class);

        Optional<ShipsInfo> first = Stream.of(shipsInfo)
                .filter(id -> id.getId().toString().contains("1"))
                .filter(name -> name.getName().contains("Маленький Принц"))
                .findFirst();
        assertThat(first.get().getLevel()).isEqualTo("полулюкс");
        assertThat(first.get().getPassengerCnt()).isEqualTo(280);
        assertThat(first.get().getCabinLevel()).isEqualTo("полулюкс");
        assertThat(first.get().getBuildYear()).isEqualTo("2005");
    }


    @Test
    @Story("Ships")
    @DisplayName("Negative:Get all ships from test fleet(ships/getAll)")
    void shipsGetAllNegativeTest() {
        ShipsInfo[] shipsInfo =
                given()
                        .filter(withCustomTemplates())
                        .when()
                        .get("ships/getAll")
                        .then()
                        .log().body()
                        .statusCode(200)
                        .extract()
                        .as(ShipsInfo[].class);

        Optional<ShipsInfo> first = Stream.of(shipsInfo)
                .filter(id -> id.getId().toString().contains("1"))
                .filter(name -> name.getName().contains("Маленький Принц"))
                .findFirst();
        assertThat(first.get().getLevel()).isEqualTo("полулюкс");
        assertThat(first.get().getPassengerCnt()).isNotEqualTo(290);
        assertThat(first.get().getCabinLevel()).isEqualTo("полулюкс");
        assertThat(first.get().getBuildYear()).isNotEqualTo("2007");
    }


    @Test
    @Story("Ships")
    @DisplayName("Positive:Post ships by ID from test fleet(ships/getShipsInfoListById)")
    void shipsGetByIDPositiveTest() {
        ShipsInfo[] shipsInfo =
                given()
                        .filter(withCustomTemplates())
                        .contentType(JSON)
                        .body(ShipsStatus.builder().id(2).build())
                        .when()
                        .post("ships/getShipsInfoListById")
                        .then()
                        .log().body()
                        .statusCode(200)
                        .extract()
                        .as(ShipsInfo[].class);

        Optional<ShipsInfo> first = Stream.of(shipsInfo)
                .findFirst();
        assertThat(first.get().getId()).isEqualTo(2);
        assertThat(first.get().getName()).isEqualTo("Мамин Сибиряк");
        assertThat(first.get().getLevel()).isEqualTo("полулюкс");
        assertThat(first.get().getPassengerCnt()).isEqualTo(60);
        assertThat(first.get().getCabinLevel()).isEqualTo("зконом");
        assertThat(first.get().getBuildYear()).isEqualTo("1970");
    }

    @Test
    @Story("Ships")
    @DisplayName("Negative:Post ships by ID from test fleet(ships/getShipsInfoListById)")
    void shipsGetByIDNegativeTest() {
        ShipsInfo[] shipsInfo =
                given()
                        .filter(withCustomTemplates())
                        .contentType(JSON)
                        .body(ShipsStatus.builder().id(2).build())
                        .when()
                        .post("ships/getShipsInfoListById")
                        .then()
                        .log().body()
                        .statusCode(200)
                        .extract()
                        .as(ShipsInfo[].class);

        Optional<ShipsInfo> first = Stream.of(shipsInfo)
                .findFirst();
        assertThat(first.get().getId()).isNotEqualTo(3);
        assertThat(first.get().getName()).isNotEqualTo("Быстрый");
        assertThat(first.get().getLevel()).isNotEqualTo("зконом");
        assertThat(first.get().getPassengerCnt()).isNotEqualTo(55);
        assertThat(first.get().getCabinLevel()).isNotEqualTo("полулюкс");
        assertThat(first.get().getBuildYear()).isNotEqualTo("1975");
    }
}
