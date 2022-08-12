package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.CreateDiscussionDto;
import com.motorbikesshop.model.entity.Comments;
import com.motorbikesshop.model.entity.Discussion;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.util.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class ForumControllerMockBeanIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestData testData;

    private Discussion testDiscussion;

    private Comments testComments;

    private UserEntity testUser;

    @BeforeEach
    void setUp() {
        testUser = testData.initTestUser();
        testDiscussion = testData.initTestDiscussion(testUser);
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
    @WithAnonymousUser
    void testCreateDiscussionByAnonymous_Forbidden() throws Exception {
        mockMvc.perform(get("/forum.discussion/create").
                        flashAttr("discussion", new CreateDiscussionDto())).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/users/login"));
    }
}
