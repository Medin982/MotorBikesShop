package com.motorbikesshop.web;

import com.motorbikesshop.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerMockBeanIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService mockEmailService;

    @Test
    void testRegistrationPageShow() throws Exception {
        mockMvc.perform(get("/users/register")).
                andExpect(status().isOk()).
                andExpect(view().name("register"));
    }

    @Test
    void testUserRegistration() throws Exception {
        mockMvc.perform(post("/users/register").
                        param("firstName", "Pesho").
                        param("lastName", "Peshov").
                        param("email", "pesho@mail.com").
                        param("phoneNumber", "0877729680").
                        param("password", "12345").
                        param("confirmPassword", "12345").
                        with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("login"));

        verify(mockEmailService).
                sendRegistrationEmail("pesho@mail.com", "Pesho Peshov");
    }

    @Test
    void testUserLoginPageShow() throws Exception {
        mockMvc.perform(get("/users/login")).
                andExpect(status().isOk()).
                andExpect(view().name("login"));
    }

    @Test
    void testUSerRegisterWrongCredentials() throws Exception {
        mockMvc.perform(post("/users/register").
                        param("firstName", "Pesho").
                        param("lastName", "").
                        param("email", "pesho@mail.com").
                        param("phoneNumber", "0877729680").
                        param("password", "12345").
                        param("confirmPassword", "12345").
                        with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("register"));
    }
}
