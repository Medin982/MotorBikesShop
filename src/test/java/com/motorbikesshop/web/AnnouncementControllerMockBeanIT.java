package com.motorbikesshop.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnnouncementControllerMockBeanIT {

    @Autowired
    private MockMvc mockMvc;

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
        mockMvc.perform(multipart("/announcement/add").
                param("modelId", "sssssssss").
                param("category", "MOTOCROSS").
                param("condition", "USED").
                param("color", "RED").
                param("dateOfManufacture", "2020/10/10").
                param("horsePower", "70").
                param("modification", "450").
                param("price", "6000").
                param("mileage", "3000").
                param("city", "Slashten").
                param("street", "Mesta").
                param("streetNumber", "5").
                param("postCode", "2937").
                param("description", "aaaaaaaaaaaaaaaaaaa").
                param("images", "img.jpeg").
                with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/"));
    }
}
