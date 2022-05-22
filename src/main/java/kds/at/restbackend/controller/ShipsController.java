package kds.at.restbackend.controller;

import io.swagger.annotations.ApiOperation;
import kds.at.restbackend.domain.ShipsInfo;
import kds.at.restbackend.domain.ShipsStatus;
import kds.at.restbackend.exception.InvalidShipsIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShipsController {

    private List<ShipsInfo> ships = List.of(
            ShipsInfo.builder()
                    .id(1)
                    .name("Маленький Принц")
                    .description("Теплоход-пансионат рассчитан на 280 человек")
                    .level("полулюкс")
                    .passengerCnt(280)
                    .cabinLevel("полулюкс")
                    .buildYear("2005")
                    .build(),
            ShipsInfo.builder()
                    .id(2)
                    .name("Мамин Сибиряк")
                    .description("Названный в честь российского писателя и драматурга Дмитрия Мамина-Сибиряка теплоход рассчитан на 60 посадочных мест")
                    .level("полулюкс")
                    .passengerCnt(60)
                    .cabinLevel("зконом")
                    .buildYear("1970")
                    .build(),
            ShipsInfo.builder()
                    .id(3)
                    .name("Александр Свирский")
                    .description("Двухпалубный теплоход «Александр Свирский» получил свое название в честь преподобного святого, 7 лет прожившего в качестве послушника в пещере на Валааме.Уютное и комфортабельное судно рассчитано на 186 пассажиров")
                    .level("эконом")
                    .passengerCnt(186)
                    .cabinLevel("зконом")
                    .buildYear("1962")
                    .build()

    );

    @GetMapping("ships/getAll")
    @ApiOperation("Get all ships")
    public List<ShipsInfo> getAllShips() {
        List<ShipsInfo> result = new ArrayList<>();
        for (ShipsInfo ships : ships) {
            result.add(ships);
            System.out.println(result);
        }
        return result;
    }

    @PostMapping("ships/getShipsInfoListById")
    @ApiOperation("Get ship by ID")
    public List<ShipsInfo> getShipsInfoListById(@RequestBody ShipsStatus id) {
        if (ships.stream().filter(shipsInfo -> shipsInfo.getId().equals(id.getId())).collect(Collectors.toList()).isEmpty()) {
            throw new InvalidShipsIdException(HttpStatus.NOT_FOUND);
        } else {
            return ships.stream().filter(shipsInfo -> shipsInfo.getId().equals(id.getId())).collect(Collectors.toList());
        }
    }

    @PostMapping("ships/getShipsInfoListByLevel")
    @ApiOperation("Get ship by Level")
    public List<ShipsInfo> getShipsInfoListByLevel(@RequestBody ShipsStatus level) {
        if (ships.stream().filter(shipsInfo -> shipsInfo.getLevel().equals(level.getLevel())).collect(Collectors.toList()).isEmpty()) {
            throw new InvalidShipsIdException(HttpStatus.NOT_FOUND);
        } else {
            return ships.stream().filter(shipsInfo -> shipsInfo.getLevel().equals(level.getLevel())).collect(Collectors.toList());
        }
    }

    @PostMapping("ships/addShip")
    @ApiOperation("Add ship to the fleet")
    public ShipsInfo addShip(@RequestBody ShipsInfo shipsStatus) {
        return ShipsInfo.builder()
                .id(shipsStatus.getId())
                .name(shipsStatus.getName())
                .description(shipsStatus.getDescription())
                .level(shipsStatus.getLevel())
                .passengerCnt(shipsStatus.getPassengerCnt())
                .cabinLevel(shipsStatus.getCabinLevel())
                .buildYear(shipsStatus.getBuildYear())
                .build();
    }

}
