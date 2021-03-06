package myapp.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import myapp.model.MyObject;
import myapp.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api("@Api аннотация MyController")
@RequestMapping("/mycontr")
@Slf4j
public class MyController {

    @Autowired
    FeignService feignService;

    List<MyObject> objectList = new ArrayList<>();

    @GetMapping()
    public String myStrings() {
        return "/obj /obj/new /obj/new2 /test";
    }

    @ApiOperation("Взаимодействие с другим апи через FeignClient")
    @GetMapping("/feign")
    public String feign() {
        log.info("feign запрос");
        return feignService.getFeignR();
    }

    @ApiOperation("Обычное взаимодействие с другим апи")
    @GetMapping("/notFeign")
    public String notFeign() {
        RestTemplate template = new RestTemplate();
        String notFeignResourceUrl = "http://127.0.0.1:8778/feign/notFeign";
        String result = template.getForObject(notFeignResourceUrl,String.class);
        return result;
    }

    @ApiOperation("Получение всех объектов")
    @RequestMapping(method = RequestMethod.GET, value = "/obj")
    public List<MyObject> getObjects() {
        return objectList;
    }

    @ApiOperation(value = "Запись объекта", response = MyObject.class)
    @ApiResponses(value = {
            @ApiResponse(code = 504, message = "System over 504"),
            @ApiResponse(code = 505, message = "System over 505")
    })

    @PostMapping(value = "/obj/new")
    public MyObject addObject(@ApiParam(value = "Give name to object", required = true) @RequestParam String name) {
        int id = objectList.size() + 1;
        MyObject myobject = MyObject.builder().id(id).name(name).build();
        objectList.add(myobject);
        return myobject;
    }

    @PostMapping(value = "/obj/new2")
    public ResponseEntity<MyObject> addObjectEntity(@RequestBody MyObject object) {
        int id = objectList.size() + 1;
        MyObject myobject = MyObject.builder().id(id).name(object.getName()).build();
        objectList.add(myobject);
        return new ResponseEntity<>(myobject, HttpStatus.OK);
    }

    @ApiOperation("Получение всех объектов")
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String testObject() {
        return "tesstString";
    }
}
