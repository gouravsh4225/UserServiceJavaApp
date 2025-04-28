package com.user.service.UserServiceJavaApp.Controllers;
import com.user.service.UserServiceJavaApp.Model.UserModel.UpdateRequestUserModel;
import com.user.service.UserServiceJavaApp.Response.ResponseHandler;
import com.user.service.UserServiceJavaApp.Model.UserModel.UserModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Slf4j
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
    public ResponseEntity<Object> getAllUser() {
        List<UserModel> userLists = getUserList();
        return ResponseHandler.generateResponse(true,userLists,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        List<UserModel> userList = getUserList();
       return userList.stream()
                .filter(userItem -> userItem.getId() == id)
                .findFirst()
                .map(user -> ResponseHandler.generateResponse(true, user, HttpStatus.OK))
                .orElseGet(() -> ResponseHandler.generateResponse(false, "User not found with ID: " + id, HttpStatus.NOT_FOUND));

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable int id, @RequestBody UpdateRequestUserModel updateUserData) {
        List<UserModel> userAllList = getUserList();
        Optional<UserModel> userOptional = userAllList.stream().filter(user-> user.getId() == id).findFirst();
        if(userOptional.isPresent()) {
            UserModel updateUser = userOptional.get();
            updateUser.setName(updateUserData.getName());
            updateUser.setEmail(updateUserData.getEmail());
            updateUser.setAddress(updateUserData.getAddress());
            return ResponseHandler.generateResponse(true,updateUser,HttpStatus.OK);
        } else {
            return ResponseHandler.generateResponse(false,"User is not found " + id,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        List<UserModel> userAllList = getUserList();
        /* first way */
//        boolean userRemoved = userAllList.removeIf(user -> user.getId() == id);
//        if(userRemoved) {
//            return  ResponseHandler.generateResponse(true,"User is removed",HttpStatus.OK);
//        } else {
//            return  ResponseHandler.generateResponse(false,"User is not found" + id,HttpStatus.NOT_FOUND);
//        }
        /* second way and when we need to return object */
        UserModel currentUser = userAllList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
        if(currentUser != null) {
            userAllList.remove(currentUser);
            return  ResponseHandler.generateResponse(true,currentUser,HttpStatus.OK);
        } else  {
     return  ResponseHandler.generateResponse(false,"User is not found" + id,HttpStatus.NOT_FOUND);
        }



    }
}