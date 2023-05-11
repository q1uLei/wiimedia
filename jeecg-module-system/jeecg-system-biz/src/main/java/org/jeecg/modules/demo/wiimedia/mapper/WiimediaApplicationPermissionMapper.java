package org.jeecg.modules.demo.wiimedia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.system.vo.UserPermissionVo;

/**
 * @Description: 单点登录-权限管理
 * @Author: jeecg-boot
 * @Date:   2023-05-09
 * @Version: V1.0
 */
public interface WiimediaApplicationPermissionMapper extends BaseMapper<WiimediaApplicationPermission> {

    /**
     * 用户权限查询
     * @param userId
     * @return
     */
    List<UserPermissionVo> queryPermissionList(String userId);
}
