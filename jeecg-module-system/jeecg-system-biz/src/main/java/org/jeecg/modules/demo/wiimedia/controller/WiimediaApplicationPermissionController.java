package org.jeecg.modules.demo.wiimedia.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;

import org.jeecg.modules.demo.wiimedia.entity.WiimediaApplicationPermission;
import org.jeecg.modules.demo.wiimedia.service.IWiimediaApplicationPermissionService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.system.vo.UserPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 单点登录-权限管理
 * @Author: jeecg-boot
 * @Date:   2023-05-09
 * @Version: V1.0
 */
@Api(tags="单点登录-权限管理")
@RestController
@RequestMapping("/wiimedia/wiimediaApplicationPermission")
@Slf4j
public class WiimediaApplicationPermissionController extends JeecgController<WiimediaApplicationPermission, IWiimediaApplicationPermissionService> {
	@Autowired
	private IWiimediaApplicationPermissionService wiimediaApplicationPermissionService;

	/**
	 * 分页列表查询
	 *
	 * @param wiimediaApplicationPermission
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "单点登录-权限管理-分页列表查询")
	@ApiOperation(value="单点登录-权限管理-分页列表查询", notes="单点登录-权限管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<WiimediaApplicationPermission>> queryPageList(WiimediaApplicationPermission wiimediaApplicationPermission,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<WiimediaApplicationPermission> queryWrapper = QueryGenerator.initQueryWrapper(wiimediaApplicationPermission, req.getParameterMap());
		queryWrapper.eq("enable_flag","Y");
		Page<WiimediaApplicationPermission> page = new Page<>(pageNo, pageSize);
		IPage<WiimediaApplicationPermission> pageList = wiimediaApplicationPermissionService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	 @ApiOperation(value="查询用户权限", notes="查询用户权限")
	 @GetMapping(value = "/permissionList")
	 public Result<List<UserPermissionVo>> queryPermissionList(@RequestParam(name="userId", required = false)String userId){
		 return wiimediaApplicationPermissionService.queryPermissionList(userId);
	 }

	/**
	 *   添加
	 *
	 * @param wiimediaApplicationPermission
	 * @return
	 */
	@AutoLog(value = "单点登录-权限管理-添加")
	@ApiOperation(value="单点登录-权限管理-添加", notes="单点登录-权限管理-添加")
	@RequiresPermissions("wiimedia:wiimedia_application_permission:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody WiimediaApplicationPermission wiimediaApplicationPermission) {
		List<String> applicationIds = Arrays.asList(wiimediaApplicationPermission.getApplicationId().split(","));
		List<WiimediaApplicationPermission> list = new ArrayList<>();
		applicationIds.forEach(id -> {
			WiimediaApplicationPermission applicationPermission = new WiimediaApplicationPermission();
			applicationPermission.setUserId(wiimediaApplicationPermission.getUserId());
			applicationPermission.setApplicationId(id);
			applicationPermission.setEnableFlag("Y");
			list.add(applicationPermission);
		});
		wiimediaApplicationPermissionService.saveBatch(list);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param wiimediaApplicationPermission
	 * @return
	 */
	@AutoLog(value = "单点登录-权限管理-编辑")
	@ApiOperation(value="单点登录-权限管理-编辑", notes="单点登录-权限管理-编辑")
	@RequiresPermissions("wiimedia:wiimedia_application_permission:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody WiimediaApplicationPermission wiimediaApplicationPermission) {
		wiimediaApplicationPermissionService.updateById(wiimediaApplicationPermission);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "单点登录-权限管理-通过id删除")
	@ApiOperation(value="单点登录-权限管理-通过id删除", notes="单点登录-权限管理-通过id删除")
	@RequiresPermissions("wiimedia:wiimedia_application_permission:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id") String id) {
		wiimediaApplicationPermissionService.update(new LambdaUpdateWrapper<WiimediaApplicationPermission>()
				.eq(WiimediaApplicationPermission::getId,id)
				.set(WiimediaApplicationPermission::getEnableFlag,"N"));
		return Result.OK("删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "单点登录-权限管理-通过id查询")
	@ApiOperation(value="单点登录-权限管理-通过id查询", notes="单点登录-权限管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<WiimediaApplicationPermission> queryById(@RequestParam(name="id") String id) {
		WiimediaApplicationPermission wiimediaApplicationPermission = wiimediaApplicationPermissionService.getOne(
				new LambdaQueryWrapper<WiimediaApplicationPermission>()
						.eq(WiimediaApplicationPermission::getId,id)
						.eq(WiimediaApplicationPermission::getEnableFlag,"Y"));
		if(wiimediaApplicationPermission==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(wiimediaApplicationPermission);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param wiimediaApplicationPermission
    */
    @RequiresPermissions("wiimedia:wiimedia_application_permission:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, WiimediaApplicationPermission wiimediaApplicationPermission) {
        return super.exportXls(request, wiimediaApplicationPermission, WiimediaApplicationPermission.class, "单点登录-权限管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("wiimedia:wiimedia_application_permission:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, WiimediaApplicationPermission.class);
    }

}
