package com.nicr0n.swagger.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: Nicr0n
 * @date: 2021/12/16    16:01
 * @email: Nicr0nFF@gmail.com
 */
@Schema(description = "分页VO")
@Data
public class PageParam {

    @Schema(description = "页数",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer page;

    @Schema(description = "每页数量",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer perPage;
}
