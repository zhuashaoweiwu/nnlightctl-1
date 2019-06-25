package com.nnlightctl.springmvc.controller;

import com.nnlightctl.po.Righter;
import com.nnlightctl.request.SaveUserMapRightersRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.MenuServer;
import com.nnlightctl.vo.GetUserWithRighterView;
import com.nnlightctl.vo.MenuView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/menu")
public class MenuController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuServer menuServer;

    /*
    *菜单权限资源操作
    *一、获取全部一级菜单信息
    * */
    @RequestMapping("listMenuLevel1")
    public String listMenuLevel1(){
        logger.info("[POST] /api/menu/listMenuLevel1");
        List<Righter> righterList = menuServer.listMenuLevel1();
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(righterList);
        return toJson(jsonResult);
    }
    /*
     *菜单权限资源操作
     *二、获取全部子菜单
     * */
    @RequestMapping("listMenuLevelSub")
    public String  listMenuLevelSub(Integer parentId){
        logger.info("[POST] /api/menu/listMenuLevelSub");
        List<Righter> righterList = menuServer.listMenuLevelSub(parentId);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(righterList);

        return toJson(jsonResult);
    }

    /*
     *菜单权限资源操作
     *三、保存用户菜单的映射
     * */
    @RequestMapping("saveUserMapRighters")
    public String saveUserMapRighters(SaveUserMapRightersRequest request){
        logger.info("[POST] /api/menu/saveUserMapRighters");
         int ret = menuServer.insertSaveUserMapRighters(request);
        JsonResult jsonResult =null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }

    /*
     *菜单权限资源操作
     *四、获取带菜单id集合的用户信息
     * */
    @RequestMapping("getUserWithRighter")
    public String getUserWithRighter(Integer userId){
        logger.info("[POST] /api/menu/getUserWithRighter");
        List<GetUserWithRighterView> list = menuServer.getUserWithRighter(userId);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(list);

        return toJson(jsonResult);
    }
}
