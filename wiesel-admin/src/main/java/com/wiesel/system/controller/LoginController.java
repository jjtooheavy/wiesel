package com.wiesel.system.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wiesel.common.base.entity.CommonError;
import com.wiesel.common.base.entity.Tree;
import com.wiesel.common.controller.BaseController;
import com.wiesel.common.utils.ErrorCode;
import com.wiesel.common.utils.MD5Utils;
import com.wiesel.common.utils.R;
import com.wiesel.common.utils.ShiroUtils;
import com.wiesel.system.entity.Menu;
import com.wiesel.system.service.IMenuService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @ClassName 类名：LoginController
 * @Description 功能说明：登录操作类
 *              <p>
 *              TODO
 *              </p>
 ************************************************************************
 * @date 创建日期：2018年7月4日
 * @author 创建人：wuj
 * @version 版本号：V1.0
 *          <p>
 ***************************          修订记录*************************************
 * 
 *          2018年7月4日 wuj 创建该类功能。
 *
 ***********************************************************************
 *          </p>
 */
@ApiModel(value = "用户登录接口")
@Controller
public class LoginController extends BaseController {

	@Autowired
	private IMenuService menuService;

	@ApiIgnore
	@GetMapping({ "/", "" })
	String welcome(Model model) {
		// return "redirect:/blog";
		return "index";
	}

	@ApiIgnore
	@GetMapping("/login")
	String login() {
		return "login";
	}

	@ApiIgnore
	@GetMapping("/api")
	String api() {
		return "redirect:/swagger-ui.html";
	}

	@ApiIgnore
	@GetMapping({ "/index" })
	String index(Model model) {

		List<Tree<Menu>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());
		// FileDO fileDO = fileService.get(getUser().getPicId());
		// if(fileDO!=null&&fileDO.getUrl()!=null){
		// if(fileService.isExist(fileDO.getUrl())){
		// model.addAttribute("picUrl",fileDO.getUrl());
		// }else {
		// model.addAttribute("picUrl","/img/photo_s.jpg");
		// }
		// }else {
		// model.addAttribute("picUrl","/img/photo_s.jpg");
		// }
		model.addAttribute("picUrl", "/img/photo_s.jpg");
		model.addAttribute("username", getUser().getUsername());
		return "index";
	}

	@ApiOperation(value = "登录", notes = "用户填写账号密码进入后台")
	@ResponseBody
	@PostMapping(value = "/login")
	R ajaxLogin(String username, String password) {

		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			CommonError commonError = new CommonError();
			commonError.setCode(ErrorCode.LOGIN_FAIL.getCode()).setMsg(ErrorCode.LOGIN_FAIL.getMsg());
			return R.ok();
		} catch (AuthenticationException e) {
			return R.error("用户或密码错误");
		}
	}

	@ApiOperation(value = "登出")
	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@ApiIgnore
	@GetMapping("/main")
	String main() {
		return "main";
	}
}
