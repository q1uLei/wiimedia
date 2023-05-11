package org.jeecg.modules.demo.wiimedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationManage;
import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationPermission;
import org.jeecg.modules.demo.wiimedia.mapper.WiimediaApplicationManageMapper;
import org.jeecg.modules.demo.wiimedia.service.IWiimediaApplicationManageService;
import org.jeecg.modules.demo.wiimedia.service.IWiimediaApplicationPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 单点登录-应用管理
 * @Author: jeecg-boot
 * @Date: 2023-05-09
 * @Version: V1.0
 */
@Service
public class WiimediaApplicationManageServiceImpl extends ServiceImpl<WiimediaApplicationManageMapper, WiimediaApplicationManage> implements IWiimediaApplicationManageService {

    @Autowired
    private IWiimediaApplicationPermissionService permissionService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String id) {
        update(new LambdaUpdateWrapper<WiimediaApplicationManage>()
                .eq(WiimediaApplicationManage::getId, id)
                .set(WiimediaApplicationManage::getEnableFlag, "N"));
        permissionService.update(new LambdaUpdateWrapper<WiimediaApplicationPermission>()
                .eq(WiimediaApplicationPermission::getApplicationId, id)
                .set(WiimediaApplicationPermission::getEnableFlag, "N"));
    }
}
