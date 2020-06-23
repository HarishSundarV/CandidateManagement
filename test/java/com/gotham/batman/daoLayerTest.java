package com.gotham.batman;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class daoLayerTest {
	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup () {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    @Test
    public void testUserController () throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

       MockHttpServletRequestBuilder builder  = MockMvcRequestBuilders.get("/getallcandidates");
                                      //  .header("User-Agent", "spring test");
        this.mockMvc.perform(builder)
                    .andExpect(ok);

        builder  = MockMvcRequestBuilders.get("/getlocationcount");
                                    
         this.mockMvc.perform(builder)
                     .andExpect(ok);
         builder  = MockMvcRequestBuilders.get("/getjob");
        
         this.mockMvc.perform(builder)
         .andExpect(ok);

    builder  = MockMvcRequestBuilders.get("/getcandidatebylocation/chennai");
    
    this.mockMvc.perform(builder)
    .andExpect(ok);
    }
}