package com.msl.option;

import lombok.Data;
import lombok.experimental.Builder;

/**
 * Created by msl on 2019/2/27.
 */
@Data
@Builder
public class Employee {


    private String name;
    private Integer salary;
    private String office;


}
