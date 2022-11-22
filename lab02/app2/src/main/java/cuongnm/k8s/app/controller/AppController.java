package cuongnm.k8s.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/app/")
@RequiredArgsConstructor
public class AppController {

    @Value("${application.version}")
    private String version;

    @GetMapping("version")
    public ResponseEntity<String> getUserName() {
        log.info("Start get app version");
        return ResponseEntity.ok(version);
    }
}
