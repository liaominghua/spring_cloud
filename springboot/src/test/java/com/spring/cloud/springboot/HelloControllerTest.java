package com.spring.cloud.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//使用了某些静态函数
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by minghua on 2017/6/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)//引入spring对JUnit4的支持
@SpringBootTest(classes = HelloController.class)//制定springBoot的启动类（原来是@SpringApplicationConfiguration,在1.4.x的版本中取消，用SpringBootTest替换）
@WebAppConfiguration//开启web应用的配置，用于模拟ServletContext
public class HelloControllerTest {

    //MockMvc对象：用于模拟调用Controller的接口发起请求，在@Test定义的hello测试用力中，perform函数执行一次请求调用,Accept用于执行接收的数据类型。
    //andExpect用于判断接口返回的期望值。
    private MockMvc mvc;

    @Before //初始化HelloController的模拟
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void hello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello world")));
    }
}
