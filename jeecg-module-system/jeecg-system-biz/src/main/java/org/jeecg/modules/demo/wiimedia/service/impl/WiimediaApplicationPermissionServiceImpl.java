package org.jeecg.modules.demo.wiimedia.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationPermission;
import org.jeecg.modules.demo.wiimedia.mapper.WiimediaApplicationPermissionMapper;
import org.jeecg.modules.demo.wiimedia.service.IWiimediaApplicationPermissionService;
import org.jeecg.modules.system.vo.UserPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Collections;
import java.util.List;

/**
 * @Description: 单点登录-权限管理
 * @Author: jeecg-boot
 * @Date:   2023-05-09
 * @Version: V1.0
 */
@Service
public class WiimediaApplicationPermissionServiceImpl extends ServiceImpl<WiimediaApplicationPermissionMapper, WiimediaApplicationPermission> implements IWiimediaApplicationPermissionService {

    @Autowired
    private WiimediaApplicationPermissionMapper permissionMapper;

    @Override
    public Result<List<UserPermissionVo>> queryPermissionList(String userId) {
        List<UserPermissionVo> permissionList = permissionMapper.queryPermissionList(userId);
        if (CollectionUtils.isEmpty(permissionList)){
            return Result.OK(Collections.emptyList());
        }
        return Result.OK(permissionList);
    }
}
