package com.api.controller.system;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.system.letter.MsgSystem;
import com.api.service.system.MsgSystemService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */
@RestController
public class MsgSystemController {
    private Logger logger = Logger.getLogger(SubjectController.class);
    @Autowired
    private MsgSystemService msgSystemService;

    @RequestMapping(value = "/msgSystem/selectMsgSystem", method = RequestMethod.POST)
    @ResponseBody
    public Result msgSystemList(MsgSystem msgSystem,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<MsgSystem> list = msgSystemService.selectMsgSystem(msgSystem);

        Page<MsgSystem> listCountry = (Page<MsgSystem>)list;

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, list,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }


    @RequestMapping(value = "/msgSystem/addMsgSystem", method = RequestMethod.POST)
    @ResponseBody
    public Result addMsgSystem(MsgSystem msgSystem) {
        msgSystemService.addMsgSystem(msgSystem);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
}
