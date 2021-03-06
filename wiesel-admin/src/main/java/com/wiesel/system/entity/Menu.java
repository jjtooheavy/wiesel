package com.wiesel.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
*
* @ClassName 类名：Menu
* @Description 功能说明：菜单管理
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
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "menu_id", type = IdType.ID_WORKER)
    private Long menuId;
    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 创建时间
     */
    private String gmtCreate;
    /**
     * 修改时间
     */
    private String gmtModified;


    public static final String MENU_ID = "menu_id";

    public static final String PARENT_ID = "parent_id";

    public static final String NAME = "name";

    public static final String URL = "url";

    public static final String PERMS = "perms";

    public static final String TYPE = "type";

    public static final String ICON = "icon";

    public static final String ORDER_NUM = "order_num";

    public static final String GMT_CREATE = "gmt_create";

    public static final String GMT_MODIFIED = "gmt_modified";

    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

}
