package org.jeecg.common.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title: LoginSkipUserDTO
 * @Author Ql
 * @Date: 2023/5/9 11:22
 * @Version 1.0
 */
@Data
@ApiModel(value="登录对象", description="登录对象")
public class LoginSkipUserDTO {
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "密钥")
    private String token;

    @ApiModelProperty(value = "子系统Id")
    private String appId;
}
