package com.ms.modelex.ai.controller;

import com.ms.modelex.ai.api.dto.data.DataApiResponse;
import com.ms.modelex.ai.api.dto.data.DataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/data")
public class DataController {

    @GetMapping
    public ResponseEntity<DataApiResponse> getData() {
        List<DataDto> dataDtos =  List.of(
                DataDto.builder().id(1L).ipAddress("192.168.1.1").label("HR Dept").lastSession("6 Aug, 2024").method("Basic auth").status("bg-success").build(),
                DataDto.builder().id(2L).ipAddress("2001:db8:0:1234:0:567:8:5").label("Guy Hawkins").lastSession("22 Jul 2024").method("Web").status("bg-success").build(),
                DataDto.builder().id(3L).ipAddress("2001:db8:0:1234:0:567:8:4").label("Sales Dept").lastSession("18 Jul, 2024").method("SSH").status("bg-danger").build(),
                DataDto.builder().id(4L).ipAddress("192.168.1.2").label("Sales Dept").lastSession("15 Jul, 2024").method("Kerberos").status("bg-success").build(),
                DataDto.builder().id(5L).ipAddress("2001:db8:0:1234:0:567:8:3").label("Legal Dept").lastSession("30 Jul, 2024").method("Token").status("bg-warning").build(),
                DataDto.builder().id(6L).ipAddress("10.0.0.2").label("Finance Dept").lastSession("28 Jul, 2024").method("API Key").status("bg-warning").build(),
                DataDto.builder().id(7L).ipAddress("192.168.1.4").label("Design Dept").lastSession("16 Jul, 2024").method("FIDO U2F").status("bg-success").build(),
                DataDto.builder().id(8L).ipAddress("2001:db8:0:1234:0:567:8:6").label("Compliance Dept").lastSession("11 Aug, 2024").method("OpenID").status("bg-danger").build(),
                DataDto.builder().id(9L).ipAddress("2001:db8:0:1234:0:567:8:9").label("Alice Smith").lastSession("19 Jul, 2024").method("Biometric").status("bg-success").build(),
                DataDto.builder().id(10L).ipAddress("192.168.1.1").label("HR Dept").lastSession("6 Aug, 2024").method("Basic auth").status("bg-success").build()
                );

        DataApiResponse apiResponse = DataApiResponse.builder().data(dataDtos).build();
        return ResponseEntity.ok(apiResponse);
    }
}
