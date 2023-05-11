package org.jeecg.modules.demo.wiimedia.service;

import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationManage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 单点登录-应用管理
 * @Author: jeecg-boot
 * @Date:   2023-05-09
 * @Version: V1.0
 */
public interface IWiimediaApplicationManageService extends IService<WiimediaApplicationManage> {

    /**
     * 删除应用以及权限
     * @param id
     */
    void delete(String id);
}
