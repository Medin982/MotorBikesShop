package com.motorbikesshop.web;

import com.motorbikesshop.service.AnnouncementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerMockBeanIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AnnouncementService announcementService;

    @Test
    void testHomePageShowAndPresentLatestAnnouncement() throws Exception {
        mockMvc.perform(get("/").
                flashAttr("latestAnnouncement", announcementService.getLatest(LocalDateTime.now()))).
                andExpect(status().isOk()).
                andExpect(view().name("index"));
    }
}
