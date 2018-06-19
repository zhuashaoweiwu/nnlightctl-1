package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.UserMapper;
import com.nnlightctl.dao.UserOperationLogMapper;
import com.nnlightctl.po.User;
import com.nnlightctl.po.UserOperationLog;
import com.nnlightctl.po.UserOperationLogExample;
import com.nnlightctl.request.UserOpLogConditionRequest;
import com.nnlightctl.server.UserOpLogServer;
import com.nnlightctl.vo.UserOpLogView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOpLogServerImpl implements UserOpLogServer {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserOperationLogMapper userOperationLogMapper;

    @Override
    public Tuple.TwoTuple<List<UserOpLogView>, Integer> listUserOpLog(UserOpLogConditionRequest request) {
        Tuple.TwoTuple<List<UserOpLogView>, Integer> tuple = new Tuple.TwoTuple<>();

        UserOperationLogExample userOperationLogExample = new UserOperationLogExample();
        userOperationLogExample.setOrderByClause("id DESC");

        UserOperationLogExample.Criteria criteria = userOperationLogExample.createCriteria();
        if (request.getOperationType() != null) {
            criteria.andOperationTypeEqualTo(request.getOperationType().byteValue());
        }

        if (request.getStartDate() != null) {
            criteria.andOperationTimeGreaterThanOrEqualTo(request.getStartDate());
        }

        if (request.getEndDate() != null) {
            criteria.andOperationTimeLessThanOrEqualTo(request.getEndDate());
        }

        if (!StringUtils.isEmpty(request.getContent())) {
            criteria.andOperationDescLike("%" + request.getContent() + "%");
        }

        int total = userOperationLogMapper.countByExample(userOperationLogExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<UserOperationLog> userOperationLogList = userOperationLogMapper.selectByExample(userOperationLogExample);

        List<UserOpLogView> userOpLogViewList = new ArrayList<>(8);

        for (UserOperationLog userOperationLog : userOperationLogList) {
            Long opUserId = userOperationLog.getNnlightctlUserId();
            User user = userMapper.selectByPrimaryKey(opUserId);

            UserOpLogView userOpLogView = new UserOpLogView();
            ReflectCopyUtil.beanSameFieldCopy(user, userOpLogView);

            ReflectCopyUtil.beanSameFieldCopy(userOperationLog, userOpLogView);

            userOpLogViewList.add(userOpLogView);
        }

        tuple.setFirst(userOpLogViewList);

        return tuple;
    }
}
