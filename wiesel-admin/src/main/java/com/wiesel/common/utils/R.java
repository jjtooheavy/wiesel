package com.wiesel.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ClassName 类名：R
 * @Description 功能说明：
 *              <p>
 *              TODO
 *              </p>
 ************************************************************************
 * @date 创建日期：2018年7月21日
 * @author 创建人：wuj
 * @version 版本号：V1.0
 *          <p>
 ***************************          修订记录*************************************
 * 
 *          2018年7月21日 wuj 创建该类功能。
 *
 ***********************************************************************
 *          </p>
 */
public class R extends HashMap<String, Object> {

	public R() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(500, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok(Object object) {
		R r = new R();
		r.put("data", object);
		return r;
	}
	
	public static R ok() {
		return new R();
	}
	

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public static R toMap(String key, Object value) {
		R r = new R();
		r.clear();
		r.put(key, value);
		return r;
		
	}
}
