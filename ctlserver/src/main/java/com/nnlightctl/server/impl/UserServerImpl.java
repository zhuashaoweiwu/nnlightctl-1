package com.nnlightctl.server.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.github.pagehelper.PageHelper;
import com.nnlight.common.DigesterUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.UserMapper;
import com.nnlightctl.po.User;
import com.nnlightctl.po.UserExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.UserConditionRequest;
import com.nnlightctl.request.UserRequest;
import com.nnlightctl.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addOrUpdateUser(UserRequest request) {
        User user = new User();
        ReflectCopyUtil.beanSameFieldCopy(request, user);
        user.setGmtUpdated(new Date());

        if (!StringUtils.isEmpty(request.getLoginPwd())) {
            user.setLoginPwd(DigesterUtil.digestSHA256(request.getLoginPwd() + request.getLoginName()));
        }

        int ret = -1;
        if (request.getId() == null) {
            //新增
            user.setGmtCreated(new Date());

            ret = userMapper.insertSelective(user);
        } else {
            //修改
            ret = userMapper.updateByPrimaryKeySelective(user);
        }

        return ret;
    }

    @Override
    public Tuple.TwoTuple<List<User>, Integer> listUser(UserConditionRequest request) {
        Tuple.TwoTuple<List<User>, Integer> tuple = new Tuple.TwoTuple<>();

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        userExample.setOrderByClause("id DESC");

        UserConditionRequest userConditionRequest =
                request instanceof UserConditionRequest ? (UserConditionRequest)request : null;

        if (userConditionRequest != null && userConditionRequest.getUserType() != null) {
            criteria.andUserTypeEqualTo(userConditionRequest.getUserType().byteValue());
        }
        if(userConditionRequest != null && userConditionRequest.getCodeNumber() != null){
            criteria.andCodeNumberLike("%" + userConditionRequest.getCodeNumber() + "%");
        }
        if(userConditionRequest != null && userConditionRequest.getUserName() != null){
            criteria.andUserNameLike("%" + userConditionRequest.getUserName() + "%");
        }
        if(userConditionRequest != null && userConditionRequest.getPhone() != null){
            criteria.andPhoneLike("%" + userConditionRequest.getPhone() + "%");
        }
        if (userConditionRequest != null && userConditionRequest.getLoginName() != null){
            criteria.andLoginNameLike("%" + userConditionRequest.getLoginName() + "%");
        }

        int total = userMapper.countByExample(userExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<User> users = userMapper.selectByExample(userExample);
        tuple.setFirst(users);

        return tuple;
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName);

        List<User> findUsers = userMapper.selectByExample(userExample);
        if (findUsers != null && findUsers.size() > 0) {
            return findUsers.get(0);
        }

        return null;
    }

    @Override
    public int deleteUser(List<Long> userIds) {

        for (Long id : userIds) {
            userMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public int updateUserPwd(UserConditionRequest request) {
        User user = new User();
        user.setId(request.getId());

        user.setLoginPwd(DigesterUtil.digestSHA256(request.getNewPwd()));

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Tuple.TwoTuple<List<User>, Integer> listOnlineUser() {
        Tuple.TwoTuple<List<User>, Integer> tuple = new Tuple.TwoTuple<>();
        List<User> userList = new ArrayList<>(2);

        User user = new User();
        user.setLoginName("loginUser1");
        user.setCodeNumber("001");
        user.setPlace("测试人员");
        user.setSex((byte)0);
        user.setUserType((byte)1);

        User user2 = new User();
        user2.setLoginName("loginUser2");
        user2.setCodeNumber("002");
        user2.setPlace("测试人员2");
        user2.setSex((byte)1);
        user2.setUserType((byte)2);

        userList.add(user);
        userList.add(user2);

        tuple.setFirst(userList);
        tuple.setSecond(2);

        return tuple;
    }

}
