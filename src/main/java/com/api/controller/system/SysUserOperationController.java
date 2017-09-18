package com.api.controller.system;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.system.SysUserOperation;
import com.api.service.system.SysUserOperationService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@RestController
public class SysUserOperationController {
    private Logger logger = Logger.getLogger(SysUserOperationController.class);
    @Autowired
    private SysUserOperationService sysUserOperationService;

    /**
     * 用户操作记录 查询
     * @param sysUserOperation
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/SysUserOperation/selectSysUserOperation")
    @ResponseBody
    public Result addSubject(SysUserOperation sysUserOperation, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);//分页 注意：紧接着后面的一个查询才会被分页
        List<SysUserOperation> lists= sysUserOperationService.selectSysUserOperation(sysUserOperation);
        Page<SysUserOperation> listCountry = (Page<SysUserOperation>)lists;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, lists,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }
}
