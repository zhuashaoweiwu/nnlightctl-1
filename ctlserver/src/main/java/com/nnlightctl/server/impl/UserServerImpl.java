package com.nnlightctl.server.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.github.pagehelper.PageHelper;
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
            Digester sha256 = new Digester(DigestAlgorithm.SHA256);

            user.setLoginPwd(sha256.digestHex(request.getLoginPwd()));
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
    public Tuple.TwoTuple<List<User>, Integer> listUser(BaseRequest request) {
        Tuple.TwoTuple<List<User>, Integer> tuple = new Tuple.TwoTuple<>();

        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id DESC");

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
    public int deleteUser(UserConditionRequest request) {
        List<Long> userIds = request.getUserIds();
        for (Long id : userIds) {
            userMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public int updateUserPwd(UserConditionRequest request) {
        User user = new User();
        user.setId(request.getId());

        Digester sha256 = new Digester(DigestAlgorithm.SHA256);

        user.setLoginPwd(sha256.digestHex(request.getNewPwd()));

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Tuple.TwoTuple<List<User>, Integer> listOnlineUser() {
        return null;
    }
}
