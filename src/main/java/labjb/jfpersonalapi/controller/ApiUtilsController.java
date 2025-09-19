package labjb.jfpersonalapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiUtilsController {

    @GetMapping
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("api-v2-hello");
    }
}
