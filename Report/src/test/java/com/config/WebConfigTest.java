package com.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/06/28 15:19:08 $
 * $Log: WebConfigTest.java,v $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class WebConfigTest
{
  @Autowired
  private WebApplicationContext wac;
  private MockMvc mockMvc;

  @Before
  public void setup()
  {
    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
    this.mockMvc = builder.build();
  }

  @Test
  public void testUserRequest() throws Exception
  {
    /*MockHttpServletRequestBuilder builder =
        MockMvcRequestBuilders.get("/user")
            .param("id", "100");

    this.mockMvc.perform(builder)
        .andExpect(MockMvcResultMatchers.status()
            .isOk())
        .andDo(MockMvcResultHandlers.print());*/
  }

}
