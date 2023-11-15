package com.saiyingge.localVenue.controllerTest;

import com.saiyingge.localVenue.controller.UserAccountController;
import com.saiyingge.localVenue.service.UserService;
import com.saiyingge.localVenue.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(UserAccountController.class)
public class UserAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private ReviewService reviewService;

    @Autowired
    private Model model;

    @BeforeEach
    public void setUp() {
        // Mock the behavior of reviewService to return a list of reviews when getAllReviews is called
        when(reviewService.getAllReviews()).thenReturn(Collections.emptyList());
    }

    @Test
    public void testAccountPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/account"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("account"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("reviewList"));

        // Add more assertions as needed based on your controller's behavior
    }
}
