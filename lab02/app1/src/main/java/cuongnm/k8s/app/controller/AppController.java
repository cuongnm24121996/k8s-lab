package cuongnm.k8s.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("/api/app/")
@RequiredArgsConstructor
public class AppController {

    @Value("${application.version}")
    private String version;

    private final RestTemplate restTemplate;

    @GetMapping("version")
    public ResponseEntity<String> getUserName() {
        log.info("Start get app version");
        return ResponseEntity.ok(version);
    }

    @GetMapping("combine")
    public ResponseEntity<String> getCombine() throws URISyntaxException {
        log.info("Start get app combine");
        String res = restTemplate.getForObject(new URI("http://lab02-app2:8080/api/app/version"), String.class);
        return ResponseEntity.ok(version + res);
    }
}
