package com.nicr0n.swagger.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Nicr0n
 * @date: 2021/12/16    16:01
 * @email: Nicr0nFF@gmail.com
 */
@ApiModel("分页PO")
@Data
public class PageParam {

    @ApiModelProperty(value = "页码",required = true)
    private Integer page;

    @ApiModelProperty(value = "每页数量",required = true)
    private Integer perPage;
}
