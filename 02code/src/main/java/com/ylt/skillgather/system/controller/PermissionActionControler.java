package com.ylt.skillgather.system.controller;

import com.ylt.skillgather.system.mapper.PermissionActionMapper;
import com.ylt.skillgather.system.entity.PermissionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PermissionActionControler {

    @Autowired
    PermissionActionMapper permissionactionmapper;

    @ResponseBody
    @GetMapping(value = "/action/{actioncode}")
    public PermissionAction getPermissionAction(@PathVariable(value = "actioncode") String actioncode)
    {
        return null;
        //return permissionactionmapper.selectByPrimaryKey(actioncode);
    }
}
