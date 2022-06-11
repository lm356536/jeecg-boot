package org.jeecg.modules.cesfieldkongj.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.cesfieldkongj.entity.CesFieldKongj;
import org.jeecg.modules.cesfieldkongj.service.ICesFieldKongjService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: online表单控件
 * @Author: jeecg-boot
 * @Date:   2022-06-10
 * @Version: V1.0
 */
@Api(tags="online表单控件")
@RestController
@RequestMapping("/cesfieldkongj/cesFieldKongj")
@Slf4j
public class CesFieldKongjController extends JeecgController<CesFieldKongj, ICesFieldKongjService> {
	@Autowired
	private ICesFieldKongjService cesFieldKongjService;
	
	/**
	 * 分页列表查询
	 *
	 * @param cesFieldKongj
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "online表单控件-分页列表查询")
	@ApiOperation(value="online表单控件-分页列表查询", notes="online表单控件-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CesFieldKongj>> queryPageList(CesFieldKongj cesFieldKongj,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CesFieldKongj> queryWrapper = QueryGenerator.initQueryWrapper(cesFieldKongj, req.getParameterMap());
		Page<CesFieldKongj> page = new Page<CesFieldKongj>(pageNo, pageSize);
		IPage<CesFieldKongj> pageList = cesFieldKongjService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param cesFieldKongj
	 * @return
	 */
	@AutoLog(value = "online表单控件-添加")
	@ApiOperation(value="online表单控件-添加", notes="online表单控件-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CesFieldKongj cesFieldKongj) {
		cesFieldKongjService.save(cesFieldKongj);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param cesFieldKongj
	 * @return
	 */
	@AutoLog(value = "online表单控件-编辑")
	@ApiOperation(value="online表单控件-编辑", notes="online表单控件-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CesFieldKongj cesFieldKongj) {
		cesFieldKongjService.updateById(cesFieldKongj);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "online表单控件-通过id删除")
	@ApiOperation(value="online表单控件-通过id删除", notes="online表单控件-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		cesFieldKongjService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "online表单控件-批量删除")
	@ApiOperation(value="online表单控件-批量删除", notes="online表单控件-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.cesFieldKongjService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "online表单控件-通过id查询")
	@ApiOperation(value="online表单控件-通过id查询", notes="online表单控件-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CesFieldKongj> queryById(@RequestParam(name="id",required=true) String id) {
		CesFieldKongj cesFieldKongj = cesFieldKongjService.getById(id);
		if(cesFieldKongj==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(cesFieldKongj);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param cesFieldKongj
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CesFieldKongj cesFieldKongj) {
        return super.exportXls(request, cesFieldKongj, CesFieldKongj.class, "online表单控件");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CesFieldKongj.class);
    }

}
