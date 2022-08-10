package com.motorbikesshop.web;

import com.motorbikesshop.model.entity.Announcement;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.model.enums.ConditionType;
import com.motorbikesshop.model.enums.EngineType;
import com.motorbikesshop.model.enums.MotorBikesType;
import com.motorbikesshop.model.enums.TransmissionType;
import com.motorbikesshop.util.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnnouncementControllerMockBeanIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestData testData;
    private UserEntity testUser, testAdmin;
    private Announcement testAnnouncement, adminAnnouncement;

    @BeforeEach
    void setUp() {
        testUser = testData.initTestUser();
        testAdmin = testData.initTestAdmin();
        var testCity = testData.intiTestCity();
        var testAddress = testData.initTestAddress(testCity);
        var testBrand = testData.initTestBrand();
        var testModel = testData.initTestModel(testBrand);
        var testImage = testData.initTestImages();
        testAnnouncement = testData.initTestAnnouncement(testUser, testModel, testAddress, List.of(testImage));
        adminAnnouncement = testData.initTestAnnouncement(testAdmin, testModel, testAddress, List.of(testImage));
    }

    @AfterEach
    void clean() {
        testData.clearTestDate();
    }

    @Test
    void testDeleteByAnonymousUser_Forbidden() throws Exception {
        mockMvc.perform(delete("/delete/{id}", testAnnouncement.getId()).
                        with(csrf())).
                andExpect(status().is3xxRedirection());
    }

    //    TODO: Test failed, expected redirection, but was 404
    @WithMockUser(username = "user@mail.com", roles = "USER")
    @Test
    void testDeleteByOwnerUser() throws Exception {
        mockMvc.perform(delete("/delete/{id}", testAnnouncement.getId()).
                        with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/announcement/all"));
    }

    //    TODO: Test failed, expected redirection, but was 404
    @WithMockUser(username = "admin@mail.com", roles = "ADMIN")
    @Test
    void testDeleteByAdmin() throws Exception {
        mockMvc.perform(delete("/delete/{id}", testAnnouncement.getId()).
                        with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/announcement/all"));
    }

    @Test
    @WithMockUser(value = "Pesho", roles = "USER")
    void testAddAnnouncementPageShow() throws Exception {
        mockMvc.perform(get("/announcement/add")).
                andExpect(status().isOk()).
                andExpect(view().name("add-announcement"));
    }

    @Test
    @WithMockUser(value = "Pesho", roles = "USER")
    void testCreateAnnouncement() throws Exception {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );
        mockMvc.perform(multipart("/announcement/add").
                        param("modelId", "sssssssss").
                        param("category", MotorBikesType.MOTOCROSS.toString()).
                        param("conditions", ConditionType.USED.toString()).
                        param("color", "RED").
                        param("dateOfManufacture", LocalDate.of(2000, 01, 01).toString()).
                        param("horsePower", "70").
                        param("modification", "450").
                        param("price", "6000").
                        param("mileage", "3000").
                        param("city", "city").
                        param("street", "street").
                        param("streetNumber", "5").
                        param("postCode", "1010").
                        param("description", "aaaaaaaaaaaaaaaaaaa").
                        param("engine", EngineType.PETROL.toString()).
                        param("transmission", TransmissionType.AUTOMATIC.toString()).
                        with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/"));
    }
}
