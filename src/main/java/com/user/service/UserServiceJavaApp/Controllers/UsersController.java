package com.user.service.UserServiceJavaApp.Controllers;

import com.user.service.UserServiceJavaApp.Model.UserModel;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {

    public static List<UserModel> getUserList() {
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Gourav Sharma", "abc@gmail.com", "Anaj"));
        users.add(new UserModel(2, "Gourav", "adc@gmail.com", "Anaj"));
        users.add(new UserModel(3, "Test", "adc@gmail.com", "Anaj"));
        users.add(new UserModel(4, "Test 1", "adc@gmail.com", "Anaj"));
        users.add(new UserModel(5, "Test 2", "adc@gmail.com", "Anaj"));
        users.add(new UserModel(6, "Test 3", "adc@gmail.com", "Anaj"));
        users.add(new UserModel(7, "Test 4", "adc@gmail.com", "Anaj"));
        return users;
    }


    @GetMapping
    public List<UserModel> getAllUser() {
        return getUserList();
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable int id) {
        System.out.println(id);
        var userList = getAllUser();
        System.out.println(userList);
//        userList.stream().map(BigDecimal::new)
//                .map(this::findByIdPointage)
//                .collect(Collectors.toList())
//        var userLoopIndex = 0;
//        while (userLoopIndex < userList.size()) {
//            System.out.println(userList.get(userLoopIndex));
//            userLoopIndex++;
//        }

        UserModel userOfIndexZero = userList.get(0);
        return userOfIndexZero;
    }
}