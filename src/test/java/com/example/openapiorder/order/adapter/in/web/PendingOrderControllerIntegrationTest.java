package com.example.openapiorder.order.adapter.in.web;

import com.example.openapiorder.order.application.port.out.PendingOrderRepository;
import com.example.openapiorder.order.domain.PendingOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.tej.SwaggerCodgen.model.PendingOrderRequest;
import io.tej.SwaggerCodgen.model.PendingOrderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class PendingOrderControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PendingOrderRepository pendingOrderRepository;

    @Test
    void createPendingOrder() throws Exception {
        long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = new PendingOrderRequest()
                .productId(productId)
                .quantity(quantity);

        MockHttpServletResponse response = mockMvc.perform(post("/orders/pendingOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        PendingOrderResponse pendingOrderResponse = objectMapper.readValue(response.getContentAsString(), PendingOrderResponse.class);
        assertThat(pendingOrderResponse.getId()).isPositive();
    }

    @Test
    void getOrderById() throws Exception {
        long productId = 2L;
        int quantity = 3;
        PendingOrder pendingOrder = PendingOrder.create(productId, quantity);
        pendingOrderRepository.save(pendingOrder);

        MockHttpServletResponse response = mockMvc.perform(get("/orders/pendingOrder/{id}", pendingOrder.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        PendingOrderResponse pendingOrderResponse = objectMapper.readValue(response.getContentAsString(), PendingOrderResponse.class);
        assertThat(pendingOrderResponse.getId()).isEqualTo(pendingOrder.getId());
    }
}