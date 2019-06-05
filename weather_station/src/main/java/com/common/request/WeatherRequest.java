package com.common.request;

import com.Controller.BaseController;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherRequest extends BaseController {
    private List<Long> gisIDList;
    private int pageNumber;
    private int pageSize;
}
