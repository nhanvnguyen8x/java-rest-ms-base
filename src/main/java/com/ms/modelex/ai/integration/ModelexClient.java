package com.ms.modelex.ai.integration;

import com.ms.modelex.ai.api.dto.integration.ModelexInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Component
public class ModelexClient {
    private final RestTemplate restTemplate;

    public ModelexInfoResponse getInfo(String fqdn, String rpcPort) {
        String baseUrl = String.format("http://%s:%s/info", fqdn, rpcPort);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ModelexInfoResponse> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, ModelexInfoResponse.class);
        HttpStatusCode statusCode = response.getStatusCode();
        log.info("Get Modelex Info status code: {}", statusCode);

        return response.getBody();
    }
}
