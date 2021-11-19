package myapp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel(description = "This is MyObject")
public class MyObject {

    int id;

    @ApiModelProperty("eng name of object name")
    String name;

}
