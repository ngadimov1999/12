package com.webshop.simplewebapplication;

import com.webshop.simplewebapplication.controller.ListController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ListControllerTest {

    @Autowired
    private ListController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void itemListTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(xpath("//div[@id='item-list']/div").nodeCount(3));
    }

    @Test
    public void countCartTest() throws Exception {
        this.mockMvc.perform(get("/cart"))
                .andDo(print())
                .andExpect(xpath("//*[@id='total']").string("Итого: 49₽"));
    }

    @Test
    public void addItemPageTest() throws Exception {
        this.mockMvc.perform(get("/add"))
                .andDo(print())
                .andExpect(xpath("//*[@id='add-item']").string("Добавить новый товар"));
    }
}
