package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.CreateDiscussionDto;
import com.motorbikesshop.model.entity.Comments;
import com.motorbikesshop.model.entity.Discussion;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.model.view.DiscussionViewModel;
import com.motorbikesshop.util.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class ForumControllerMockBeanIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestData testData;

    private Discussion testDiscussion, adminDiscussion;

    private Comments testComments;

    private UserEntity testUser, testAdmin;

    @BeforeEach
    void setUp() {
        testUser = testData.initTestUser();
        testAdmin = testData.initTestAdmin();
        testDiscussion = testData.initTestDiscussion(testUser);
        adminDiscussion = testData.initTestDiscussion(testAdmin);
        testComments = testData.initTestComments(testUser, testDiscussion);
    }

    @AfterEach
    void clean() {
        testData.clearTestDate();
    }

    @Test
    void testDiscussionPageShow() throws Exception {
        mockMvc.perform(get("/forum/discussion")).
                andExpect(status().isOk()).
                andExpect(view().name("discussions"));
    }

    @Test
    @WithMockUser(username = "user@mail.com", roles = "USER")
    void testCreateDiscussionPageShow() throws Exception {
        mockMvc.perform(get("/forum/discussion/create").
                        flashAttr("discussion", new CreateDiscussionDto())).
                andExpect(status().isOk()).
                andExpect(view().name("create-discussion"));
    }

    @Test
    @WithMockUser(username = "user@mail.com", roles = "USER")
    void testDiscussionDetailsPageShow() throws Exception {
        mockMvc.perform(get("/forum/discussion/details/{id}", testDiscussion.getId()).
                flashAttr("discussion", new DiscussionViewModel())).
                andExpect(status().isOk()).
                andExpect(view().name("discussion-details"));
    }

    @Test
    @WithMockUser(username = "user@mail.com", roles = "USER")
    void testCreateDiscussion() throws Exception {
        mockMvc.perform(post("/forum/discussion/create").
                param("name", "testDiscussion").
                param("description", "testDescription").
                with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/forum/discussion"));
    }

    @Test
    @WithAnonymousUser
    void testDeleteDiscussionByAnonymous_Forbidden() throws Exception {
        mockMvc.perform(delete("/forum/discussion/delete/{id}", testDiscussion.getId()).
                with(csrf())).
                andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user@mail.com", roles = "USER")
    void testDeleteDiscussionByCreator() throws Exception {
        mockMvc.perform(delete("/forum/discussion/delete/{id}", testDiscussion.getId()).
                with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/forum/discussion"));
    }

    @Test
    @WithMockUser(username = "admin@mail.com", roles = "ADMIN")
    void testDeleteDiscussionByAdmin() throws Exception {
        mockMvc.perform(delete("/forum/discussion/delete/{id}", testDiscussion.getId()).
                        with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/forum/discussion"));
    }

    @Test
    @WithMockUser(username = "user@mail.com", roles = "USER")
    void testDeleteNotCreator_Forbidden() throws Exception {
        mockMvc.perform(delete("/forum/discussion/delete/{id}", adminDiscussion.getId()).
                with(csrf())).
                andExpect(status().isForbidden());
    }
}
