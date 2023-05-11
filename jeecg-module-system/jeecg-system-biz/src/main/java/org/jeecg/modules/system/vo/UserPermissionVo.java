package org.jeecg.modules.system.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: UserPermissionVo
 * @Author Ql
 * @Date: 2023/5/9 14:46
 * @Version 1.0
 */
@Data
public class UserPermissionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String applicationName;
    private String applicationAddress;
    private String applicationPicture;
    private String userName;
}
