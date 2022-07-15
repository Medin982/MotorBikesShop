package com.motorbikesshop.model.dtos;

import com.motorbikesshop.Config.CustomValidation.IsMatched;
import com.motorbikesshop.Config.CustomValidation.UniqueEmailValidation;

import javax.validation.constraints.*;

//@IsMatched(
//        first = "password",
//        second = "confirmPassword")
public class RegisterDTO {

    @NotBlank(message = "First Name cannot be empty!")
    @Size(min = 3)
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty!")
    @Size(min = 3)
    private String lastName;

    @UniqueEmailValidation
    @Email(message = "Email must be valid!")
    @NotBlank(message = "Email cannot be empty!")
    private String email;

    @Min(value = 10, message = "Phone number cannot be less than 10 symbols1")
    @NotNull(message = "Phone number cannot be empty!")
    private Integer phoneNumber;

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 5, message = "Password cannot be less than 5 symbols!")
    private String password;


    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
