package com.example.mMOZ.Rest;

import com.example.mMOZ.Entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.net.ConnectException;

@Service
public class sendOrder {

    @Autowired
    RestTemplate restTemplate;

    public HttpStatus sendOrderErp (Long order_number){
        RestTemplate rest = new RestTemplate();

        MultiValueMap<String, Long> map= new LinkedMultiValueMap<String, Long>();
        map.add("order", order_number);

        HttpEntity<MultiValueMap<String, Long>> httpEntity = new HttpEntity<>(map, new HttpHeaders());

        try {
            ResponseEntity<HttpStatus> exchange = rest.exchange("http://localhost:8082/sendorder", HttpMethod.POST,httpEntity, HttpStatus.class);
        return exchange.getStatusCode();
        } catch (Exception e) {
            return HttpStatus.NOT_FOUND;
        }

    }
}
