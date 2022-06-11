package org.jeecg.modules.cesfieldkongj.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: online表单控件
 * @Author: jeecg-boot
 * @Date:   2022-06-10
 * @Version: V1.0
 */
@Data
@TableName("ces_field_kongj")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ces_field_kongj对象", description="online表单控件")
public class CesFieldKongj implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;
	/**用户名*/
	@Excel(name = "用户名", width = 15)
    @ApiModelProperty(value = "用户名")
    private String name;
	/**下拉框*/
	@Excel(name = "下拉框", width = 15, dicCode = "sex")
	@Dict(dicCode = "sex")
    @ApiModelProperty(value = "下拉框")
    private String sex;
	/**radio*/
	@Excel(name = "radio", width = 15, dicCode = "sex")
	@Dict(dicCode = "sex")
    @ApiModelProperty(value = "radio")
    private String radio;
	/**checkbox*/
	@Excel(name = "checkbox", width = 15, dicCode = "sex")
	@Dict(dicCode = "sex")
    @ApiModelProperty(value = "checkbox")
    private String checkbox;
	/**下拉多选*/
	@Excel(name = "下拉多选", width = 15, dicCode = "sex")
	@Dict(dicCode = "sex")
    @ApiModelProperty(value = "下拉多选")
    private String selMut;
	/**下拉搜索*/
	@Excel(name = "下拉搜索", width = 15, dictTable = "sys_user", dicText = "username", dicCode = "username")
	@Dict(dictTable = "sys_user", dicText = "username", dicCode = "username")
    @ApiModelProperty(value = "下拉搜索")
    private String selSearch;
	/**生日*/
	@Excel(name = "生日", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private Date birthday;
	/**图片*/
	@Excel(name = "图片", width = 15)
    @ApiModelProperty(value = "图片")
    private String pic;
	/**文件*/
	@Excel(name = "文件", width = 15)
    @ApiModelProperty(value = "文件")
    private String files;
	/**markdown*/
	@Excel(name = "markdown", width = 15)
    @ApiModelProperty(value = "markdown")
    private String remakr;
	/**富文本*/
	@Excel(name = "富文本", width = 15)
    @ApiModelProperty(value = "富文本")
    private String fuwenb;
	/**选择用户*/
	@Excel(name = "选择用户", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "username")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "username")
    @ApiModelProperty(value = "选择用户")
    private String userSel;
	/**选择部门*/
	@Excel(name = "选择部门", width = 15, dictTable = "sys_depart", dicText = "depart_name", dicCode = "id")
	@Dict(dictTable = "sys_depart", dicText = "depart_name", dicCode = "id")
    @ApiModelProperty(value = "选择部门")
    private String depSel;
	/**double数字*/
	@Excel(name = "double数字", width = 15)
    @ApiModelProperty(value = "double数字")
    private Double dnum;
	/**打卡时间*/
	@Excel(name = "打卡时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "打卡时间")
    private Date ccc;
}
