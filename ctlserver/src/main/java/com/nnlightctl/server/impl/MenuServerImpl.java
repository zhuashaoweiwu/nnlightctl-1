package com.nnlightctl.server.impl;

import com.nnlightctl.dao.RighterMapper;
import com.nnlightctl.jdbcdao.MenuDao;
import com.nnlightctl.po.Righter;
import com.nnlightctl.po.RighterExample;
import com.nnlightctl.po.User;
import com.nnlightctl.request.SaveUserMapRightersRequest;
import com.nnlightctl.server.MenuServer;
import com.nnlightctl.vo.GetUserWithRighterView;
import com.nnlightctl.vo.MenuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuServerImpl implements MenuServer {

    @Autowired
    private RighterMapper righterMapper;
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Righter> listMenuLevel1(){
        RighterExample righterExample = new RighterExample();
        Byte level = 0;

        righterExample.createCriteria().andRighterLevelEqualTo(level);
        righterExample.setOrderByClause("id DESC");
        return  righterMapper.selectByExample(righterExample);
    }
    @Override
    public List<MenuView> listMenuLevelSub(Integer parentId){
        RighterExample righterExample = new RighterExample();
        righterExample.createCriteria().andParentRighterIdEqualTo(parentId.longValue());

        List<MenuView> menuViewList=new ArrayList<>();
        //List<Righter> righterList = new ArrayList<>();
        List<Righter> righterList = righterMapper.selectByExample(righterExample);
        for (Righter righter : righterList) {
            if (righter.getRighterLevel()==1){
                menuViewList.add(getMenuView1(righter,righterList));
            }
            if (righter.getRighterLevel()==2){
                menuViewList.add(getMenuView2(righter,righterList));
            }
            if (righter.getRighterLevel()==3){
                menuViewList.add(getMenuView3(righter,righterList));
            }
            if (righter.getRighterLevel()==4){
                menuViewList.add(getMenuView4(righter,righterList));
            }
            if (righter.getRighterLevel()==5){
                menuViewList.add(getMenuView5(righter,righterList));
            }

        }
        //return righterList;
        return menuViewList;
      /*  List<Righter> righterList = new ArrayList<>();
        righterList = righterMapper.selectByExample(righterExample);*/


        /*return righterList;*/
    }

    public MenuView getMenuView1(Righter righter,List<Righter> righterList){
        MenuView menuView=new MenuView();
        setMenuViewRighht(righter,menuView);
        return menuView;
    }

    public MenuView getMenuView2(Righter righter,List<Righter> righterList){
        MenuView menuView=new MenuView();
        setMenuViewRighht(righter,menuView);

        List<MenuView> menuViewList=new ArrayList<>();
        //判断二级菜单
        for (Righter righter1 : righterList) {
            if (righter1.getRighterLevel()==22){
                MenuView menuView1 = setMenuView(righter1);
                menuViewList.add(menuView1);
            }

        }
        menuView.setSubMenuViewList(menuViewList);
        return menuView;
    }

    public MenuView getMenuView3(Righter righter,List<Righter> righterList){
        MenuView menuView=new MenuView();
        setMenuViewRighht(righter,menuView);

        List<MenuView> menuViewList=new ArrayList<>();
        //判断二级菜单
        for (Righter righter1 : righterList) {
            if (righter1.getRighterLevel()==23){
                MenuView menuView1 = setMenuView(righter1);
                menuViewList.add(menuView1);
            }

        }
        menuView.setSubMenuViewList(menuViewList);
        return menuView;
    }

    public MenuView getMenuView4(Righter righter,List<Righter> righterList){
        MenuView menuView=new MenuView();
        setMenuViewRighht(righter,menuView);

        List<MenuView> menuViewList=new ArrayList<>();
        //判断二级菜单
        for (Righter righter1 : righterList) {
            if (righter1.getRighterLevel()==24){
                MenuView menuView1 = setMenuView(righter1);
                menuViewList.add(menuView1);
            }

        }
        menuView.setSubMenuViewList(menuViewList);
        return menuView;
    }

    public MenuView getMenuView5(Righter righter,List<Righter> righterList){
        MenuView menuView=new MenuView();
        setMenuViewRighht(righter,menuView);
        return menuView;
    }
    public MenuView setMenuViewRighht(Righter righter,MenuView menuView){
        menuView.setName(righter.getRighterName());
        menuView.setUrl(righter.getUrl());
        menuView.setId(righter.getId());
        return menuView;
    }

    public MenuView setMenuView(Righter righter){
        MenuView menuView=new MenuView();
        menuView.setName(righter.getRighterName());
        menuView.setUrl(righter.getUrl());
        menuView.setId(righter.getId());
        return menuView;
    }




    @Override
    public int insertSaveUserMapRighters(SaveUserMapRightersRequest request){
        return menuDao.insertSaveUserMapRighters(request);
    }
    @Override
    public List<GetUserWithRighterView> getUserWithRighter(Integer userId){
        return menuDao.getUserWithRighter(userId);
    }
}
