package com.user.service.UserServiceJavaApp.Model.UserModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateRequestUserModel {
    private String name;
    private String email;
    private String address;

}
