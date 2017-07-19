package com.api.controller.user;


import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.system.SysUser;
import com.api.model.teaching.system.SysUserOperation;
import com.api.service.system.SysUserService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private SysUserService sysUserService;

    /**
     * 注册
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result register(@Valid SysUser sysUser, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            return ResultUtil.ERROR(ResultEnum.ERROR.getCode(),ResultEnum.PARAMETER_MISSING.getMsg() + "(" + bindingResult.getFieldError().getDefaultMessage() +")");
        }
        sysUserService.register(sysUser);
        SysUser returnUser=sysUserService.getUserInfo(sysUser.getUserName());
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, returnUser);
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(SysUser sysUser) throws Exception {
        Result result=sysUserService.login(sysUser);
        return result;
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delete/{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteSysUser(@PathVariable("userId") int id) {
        sysUserService.deleteSysUser(id);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 修改
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateSysUser(SysUser sysUser) throws Exception {
        sysUserService.updateSysUser(sysUser);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    /**
     * 模糊查询系统操作日志
     * @param sysUserOperation
     * @return
     */
    @RequestMapping("/addSysUserOperation")
    @ResponseBody
    public Result addSysUserOperation(SysUserOperation sysUserOperation) throws Exception {
        sysUserService.addSysUserOperation(sysUserOperation);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    /**
     * 模糊查询系统操作日志
     * @param sysUserOperation
     * @return
     */
    @RequestMapping("/selectSysUserOperation")
    @ResponseBody
    public Result selectSysUserOperation(SysUserOperation sysUserOperation, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                         @RequestParam(required = true, defaultValue = "5") Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUserOperation> lists =sysUserService.selectSysUserOperation(sysUserOperation);
        Page<SysUserOperation> listOperation = (Page<SysUserOperation>)lists;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listOperation,listOperation.getTotal(),listOperation.getPages(),listOperation.getPageNum(),listOperation.getPageSize());
    }
}
