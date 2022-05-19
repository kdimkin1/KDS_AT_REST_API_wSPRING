package kds.at.restbackend.controller;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kds.at.restbackend.domain.LoginInfo;
import kds.at.restbackend.domain.UserInfo;
import kds.at.restbackend.exception.InvalidUserNameException;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private Map<String, UserInfo> users = Map.of(
            "Dima", UserInfo.builder().userName("Dima").build(),
            "Olga", UserInfo.builder().userName("Olga").build(),
            "Ivan", UserInfo.builder().userName("Ivan").build()
    );

    @PostMapping("user/login")
    @ApiOperation("авторизация")
    public UserInfo doLogin(@RequestBody LoginInfo loginInfo) {
         if (loginInfo.getUserName().equals("Dima")){
             return UserInfo.builder()
                     .loginDate(new Date())
                     .userName(loginInfo.getUserName())
                     .build();
         } else {
             throw new InvalidUserNameException();
         }
     }

     @GetMapping("user/getAll")
     @ApiOperation("получение полного списка пользователей")
     public List<UserInfo> getAllUsersInfo(){
         List <UserInfo> result = new ArrayList<>();
         for (Map.Entry<String, UserInfo> entry : users.entrySet()) {
             result.add(entry.getValue());
         }


         return users.entrySet()
                 .stream()
                 .map(Map.Entry::getValue)
                 .collect(Collectors.toList());

     }
}
