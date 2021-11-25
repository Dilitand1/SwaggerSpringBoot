package myapp.controller;

import myapp.model.MyObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@WebMvcTest(MyController.class)
class MyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MyController controller;

    @Test
    void testt() throws Exception {
        //controller.objectList.add(new MyObject(1, "testObject"));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String actual = result.getResponse().getContentAsString();

        System.out.println(actual);
        assertEquals("tesstString", actual);
    }

    @Test
    void getObjects() throws Exception {
        controller.objectList.add(new MyObject(1, "testObject"));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/obj");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String actual = result.getResponse().getContentAsString();

        assertEquals("[{\"id\":1,\"name\":\"testObject\"}]", actual);
    }

//    @Test
//    void addObject() throws Exception {
//        MyObject object = new MyObject(1, "testObject");
//
////        RestTemplate
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/obj/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("[{\"id\":1,\"name\":\"testObject\"}]");
//
//        this.mockMvc.perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }
}