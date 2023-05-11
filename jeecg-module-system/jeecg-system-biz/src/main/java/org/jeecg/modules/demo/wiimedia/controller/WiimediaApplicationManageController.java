package org.jeecg.modules.demo.wiimedia.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationManage;
import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationPermission;
import org.jeecg.modules.demo.wiimedia.service.IWiimediaApplicationManageService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;


import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.wiimedia.service.IWiimediaApplicationPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 单点登录-应用管理
 * @Author: jeecg-boot
 * @Date:   2023-05-09
 * @Version: V1.0
 */
@Api(tags="单点登录-应用管理")
@RestController
@RequestMapping("/wiimedia/wiimediaApplicationManage")
@Slf4j
public class WiimediaApplicationManageController extends JeecgController<WiimediaApplicationManage, IWiimediaApplicationManageService> {
	@Autowired
	private IWiimediaApplicationManageService applicationManageService;

	/**
	 * 分页列表查询
	 *
	 * @param wiimediaApplicationManage
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "单点登录-应用管理-分页列表查询")
	@ApiOperation(value="单点登录-应用管理-分页列表查询", notes="单点登录-应用管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<WiimediaApplicationManage>> queryPageList(WiimediaApplicationManage wiimediaApplicationManage,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<WiimediaApplicationManage> queryWrapper = QueryGenerator.initQueryWrapper(wiimediaApplicationManage, req.getParameterMap());
		queryWrapper.eq("enable_flag","Y");
		Page<WiimediaApplicationManage> page = new Page<>(pageNo, pageSize);
		IPage<WiimediaApplicationManage> pageList = applicationManageService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param wiimediaApplicationManage
	 * @return
	 */
	@AutoLog(value = "单点登录-应用管理-添加")
	@ApiOperation(value="单点登录-应用管理-添加", notes="单点登录-应用管理-添加")
	@RequiresPermissions("wiimedia:wiimedia_application_manage:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody WiimediaApplicationManage wiimediaApplicationManage) {
		applicationManageService.save(wiimediaApplicationManage.setEnableFlag("Y"));
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param wiimediaApplicationManage
	 * @return
	 */
	@AutoLog(value = "单点登录-应用管理-编辑")
	@ApiOperation(value="单点登录-应用管理-编辑", notes="单点登录-应用管理-编辑")
	@RequiresPermissions("wiimedia:wiimedia_application_manage:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody WiimediaApplicationManage wiimediaApplicationManage) {
		applicationManageService.updateById(wiimediaApplicationManage);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "单点登录-应用管理-通过id删除")
	@ApiOperation(value="单点登录-应用管理-通过id删除", notes="单点登录-应用管理-通过id删除")
	@RequiresPermissions("wiimedia:wiimedia_application_manage:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id") String id) {
		applicationManageService.delete(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "单点登录-应用管理-通过id查询")
	@ApiOperation(value="单点登录-应用管理-通过id查询", notes="单点登录-应用管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<WiimediaApplicationManage> queryById(@RequestParam(name="id") String id) {
		WiimediaApplicationManage wiimediaApplicationManage = applicationManageService.getOne(
				new LambdaQueryWrapper<WiimediaApplicationManage>()
						.eq(WiimediaApplicationManage::getId,id)
						.eq(WiimediaApplicationManage::getEnableFlag,"Y"));
		if(wiimediaApplicationManage==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(wiimediaApplicationManage);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param wiimediaApplicationManage
    */
    @RequiresPermissions("wiimedia:wiimedia_application_manage:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, WiimediaApplicationManage wiimediaApplicationManage) {
        return super.exportXls(request, wiimediaApplicationManage, WiimediaApplicationManage.class, "单点登录-应用管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("wiimedia:wiimedia_application_manage:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, WiimediaApplicationManage.class);
    }

}
