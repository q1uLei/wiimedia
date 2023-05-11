package org.jeecg.modules.demo.wiimedia.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.vo.UserPermissionVo;

import java.util.List;

/**
 * @Description: 单点登录-权限管理
 * @Author: jeecg-boot
 * @Date:   2023-05-09
 * @Version: V1.0
 */
public interface IWiimediaApplicationPermissionService extends IService<WiimediaApplicationPermission> {

    /**
     * 用户权限查询
     * @param userId
     * @return
     */
    Result<List<UserPermissionVo>> queryPermissionList(String userId);
}
