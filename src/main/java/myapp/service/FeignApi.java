package myapp.service;

import org.springframework.web.bind.annotation.GetMapping;


public interface FeignApi {

    @GetMapping(path = "/feign")
    String getFeignR();

}
