package myapp.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feignclient",
        url = "http://127.0.0.1:8778")
public interface FeignService extends  FeignApi{
}
