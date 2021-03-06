//package com.wiesel.system.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.wiesel.common.enums.ErrorCode;
//import com.wiesel.system.controller.req.DeptReq;
//import com.wiesel.system.entity.Dept;
//import com.wiesel.system.service.IDeptService;
//
//import cn.hutool.core.bean.BeanUtil;
//import io.swagger.annotations.ApiOperation;
//import springfox.documentation.annotations.ApiIgnore;
//import wiesel.common.api.ApiResult;
//import wiesel.common.base.entity.PageReq;
//import wiesel.common.base.entity.PageResp;
//
///**
// *
// * @ClassName 类名：Dept2Controller
// * @Description 功能说明：
// *              <p>
// *              TODO
// *              </p>
// ************************************************************************
// * @date 创建日期：2018年8月23日
// * @author 创建人：wuj
// * @version 版本号：V1.0
// *          <p>
// ***************************          修订记录*************************************
// * 
// *          2018年8月23日 wuj 创建该类功能。
// *
// ***********************************************************************
// *          </p>
// */
//@Controller
//@RequestMapping("/sys/dept")
//public class Dept2Controller {
//
//	private String prefix = "system/dept";
//
//	@Autowired
//	private IDeptService deptService;
//
//	@ApiIgnore
//	@GetMapping()
//	@RequiresPermissions("sys:dept:dept")
//	String dept() {
//		return prefix + "/dept";
//	}
//
//	@ApiOperation(value = "获取部门列表", notes = "")
//	@ResponseBody
//	@GetMapping("/list")
//	@RequiresPermissions("sys:dept:dept")
//	public ApiResult<PageResp<Dept>> list(PageReq<Dept> pageReq) {
//
//		Page<Dept> page = new Page<Dept>(pageReq.getPageNo(), pageReq.getPageSize());
//		EntityWrapper<Dept> wrapper = new EntityWrapper<>();
//
//		page = deptService.selectPage(page, wrapper);
//
//		PageResp<Dept> pageResp = new PageResp<Dept>();
//		pageResp.setRows(page.getRecords());
//		pageResp.setTotal(page.getTotal());
//		return ApiResult.ok(pageResp);
//	}
//
//	@ApiOperation(value = "新增部门")
//	@RequiresPermissions("sys:dept:add")
//	@GetMapping("/add")
//	String add() {
//		return prefix + "/add";
//	}
//
//	@ApiOperation(value = "编辑部门")
//	@GetMapping("/edit/{id}")
//	@RequiresPermissions("sys:dept:edit")
//	String edit(@PathVariable("id") String id, Model model) {
//		Dept dept = deptService.selectById(Long.valueOf(id));
//		model.addAttribute("dept", dept);
//
//		return prefix + "/edit";
//	}
//
//	/**
//	 * 保存
//	 */
//	@ApiOperation(value = "保存部门")
//	@ResponseBody
//	@PostMapping("/save")
//	@RequiresPermissions("sys:dept:add")
//	public ApiResult<String> save(DeptReq deptReq) {
//		Dept dept = new Dept();
//		BeanUtil.copyProperties(deptReq, dept);
//		deptService.insert(dept);
//		return ApiResult.ok();
//	}
//
//	/**
//	 * 修改
//	 */
//	@ApiOperation(value = "修改部门")
//	@ResponseBody
//	@RequestMapping("/update")
//	@RequiresPermissions("sys:dept:edit")
//	public ApiResult<String> update(DeptReq deptReq) {
//		Dept dept = new Dept();
//		BeanUtil.copyProperties(deptReq, dept);
//		deptService.updateById(dept);
//
//		return ApiResult.ok();
//	}
//
//	@ApiOperation(value = "删除部门")
//	@PostMapping("/delete")
//	@ResponseBody
//	@RequiresPermissions("sys:dept:delete")
//	public  ApiResult<String> delete(String id) {
//		if (StringUtils.isEmpty(id)) {
//			return ApiResult.error(ErrorCode.PARAM_IS_NULL);
//		}
//		deptService.deleteById(Long.valueOf(id));
//		return ApiResult.ok();
//	}
//
//	@ApiOperation(value = "批量删除部门")
//	@PostMapping("/batchDelete")
//	@ResponseBody
//	@RequiresPermissions("sys:dept:batchDelete")
//	public  ApiResult<String> batchDelete(String[] ids) {
//		if (ids==null||ids.length <= 0) {
//			return ApiResult.error(ErrorCode.PARAM_IS_NULL);
//		}
//		List<Long> delIds = new ArrayList<>();
//		for (String id : ids) {
//			delIds.add(Long.valueOf(id));
//		}
//
//		deptService.deleteBatchIds(delIds);
//
//		return ApiResult.ok();
//	}
//}
