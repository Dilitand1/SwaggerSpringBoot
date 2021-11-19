package myapp.controller;

import io.swagger.annotations.*;
import myapp.model.MyObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api("@Api аннотация MyController")
public class MyController {

    List<MyObject> objectList = new ArrayList<>();

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

}
