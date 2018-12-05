package com.nnlightctl.server.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.github.pagehelper.PageHelper;
import com.nnlight.common.DigesterUtil;
import com.nnlight.common.PingYingUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.DepartmentMapper;
import com.nnlightctl.dao.UserMapper;
import com.nnlightctl.po.Department;
import com.nnlightctl.po.User;
import com.nnlightctl.po.UserExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.UserConditionRequest;
import com.nnlightctl.request.UserRequest;
import com.nnlightctl.server.UserServer;
import com.nnlightctl.vo.UserView;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
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
            user.setUserState((byte)1);

            ret = userMapper.insertSelective(user);
        } else {
            //修改
            //不通过此服务修改密码
            user.setLoginPwd(null);
            ret = userMapper.updateByPrimaryKeySelective(user);
        }

        return ret;
    }

    @Override
    public int getCountUserByLoginName(String loginName){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName);
        int total =userMapper.countByExample(userExample);
        return total;
    }
    @Override
    public int getCountUserByCodeNumber(String codeNumber){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andCodeNumberEqualTo(codeNumber);
        int total =userMapper.countByExample(userExample);
        return total;
    }

    @Override
    public Tuple.TwoTuple<List<UserView>, Integer> listUser(UserConditionRequest request) {
        Tuple.TwoTuple<List<UserView>, Integer> tuple = new Tuple.TwoTuple<>();

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        userExample.setOrderByClause("id DESC");

        UserConditionRequest userConditionRequest =
                request instanceof UserConditionRequest ? (UserConditionRequest)request : null;

        if (userConditionRequest != null && userConditionRequest.getUserType() != null && userConditionRequest.getUserType() != -1) {
            criteria.andUserTypeEqualTo(userConditionRequest.getUserType().byteValue());
        }
        if(userConditionRequest != null && !StringUtils.isEmpty(userConditionRequest.getCodeNumber())){
            criteria.andCodeNumberLike("%" + userConditionRequest.getCodeNumber() + "%");
        }
        if(userConditionRequest != null && !StringUtils.isEmpty(userConditionRequest.getUserName())){
            criteria.andUserNameLike("%" + userConditionRequest.getUserName() + "%");
        }
        if(userConditionRequest != null && !StringUtils.isEmpty(userConditionRequest.getPhone())){
            criteria.andPhoneLike("%" + userConditionRequest.getPhone() + "%");
        }
        if (userConditionRequest != null && !StringUtils.isEmpty(userConditionRequest.getLoginName())){
            criteria.andLoginNameLike("%" + userConditionRequest.getLoginName() + "%");
        }

        int total = userMapper.countByExample(userExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<User> users = userMapper.selectByExample(userExample);
        List<UserView> userViewList = new ArrayList<>();
        if (!users.isEmpty()){
            for (int i = 0 ; i < users.size() ; i++){
                Department department = departmentMapper.selectByPrimaryKey(users.get(i).getNnlightctlDepartmentId());
                UserView userView = new UserView();
                userView.setAge(users.get(i).getAge());
                userView.setCodeNumber(users.get(i).getCodeNumber());
                userView.setEmail(users.get(i).getEmail());
                userView.setGmtCreated(users.get(i).getGmtCreated());
                userView.setGmtUpdated(users.get(i).getGmtUpdated());
                userView.setId(users.get(i).getId());
                userView.setIsRemenberPwd(users.get(i).getIsRemenberPwd());
                userView.setLoginName(users.get(i).getLoginName());
                userView.setLoginPwd(users.get(i).getLoginPwd());
                userView.setNnlightctlDepartmentId(users.get(i).getNnlightctlDepartmentId());
                userView.setPhone(users.get(i).getPhone());
                userView.setPlace(users.get(i).getPlace());
                userView.setSex(users.get(i).getSex());
                userView.setUserName(users.get(i).getUserName());
                userView.setUserState(users.get(i).getUserState());
                userView.setUserType(users.get(i).getUserType());
                if (null != department){
                    userView.setDepartmentName(department.getDepartmentName());
                }else {
                    userView.setDepartmentName("");
                }

                userViewList.add(userView);
            }
        }
        tuple.setFirst(userViewList);

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
            User user = userMapper.selectByPrimaryKey(id);
            user.setUserState((byte)0);
            userMapper.updateByPrimaryKeySelective(user);
        }
        return 1;
    }

    @Override
    public int updateUserPwd(UserConditionRequest request) {
        User user = new User();
        user.setId(request.getId());

        String loginName = this.userMapper.selectByPrimaryKey(request.getId()).getLoginName();

        user.setLoginPwd(DigesterUtil.digestSHA256(request.getNewPwd() + loginName));

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Tuple.TwoTuple<List<UserView>, Integer> listOnlineUser() {
        Tuple.TwoTuple<List<UserView>, Integer> tuple = new Tuple.TwoTuple<>();

        List<UserView> userList = new ArrayList<>(2);

        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        Iterator iterator = principalCollection.iterator();
        while (iterator.hasNext()) {
            Object loginObject = iterator.next();
            String loginName = loginObject instanceof User ? ((User)loginObject).getLoginName() : (String)loginObject;
            User user = getUserByLoginName(loginName);
            UserView userView = new UserView();
            ReflectCopyUtil.beanSameFieldCopy(user, userView);
            Department department = departmentMapper.selectByPrimaryKey(user.getNnlightctlDepartmentId());
            if (department != null) {
                userView.setDepartmentName(department.getDepartmentName());
            }

            userList.add(userView);
        }

        tuple.setFirst(userList);
        tuple.setSecond(userList.size());

        return tuple;
    }

    @Override
    public int updateInitUserPwd(Long userId) {
        User user = this.userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new RuntimeException("初始化密码用户不存在");
        }

        user.setLoginPwd(DigesterUtil.digestSHA256(PingYingUtil.cn2FirstSpell(user.getUserName()) + "12345678" + user.getLoginName()));

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateUserLockState(Long userId, Integer state) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new RuntimeException("该用户不存在");
        }

        user.setUserState(state.byteValue());
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
