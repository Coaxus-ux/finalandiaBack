package finlandia.finlandia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/systemstatus")
public class SystemStatus {
    @RequestMapping("/status")
    public String status() {
        return "OK";
    }

}
