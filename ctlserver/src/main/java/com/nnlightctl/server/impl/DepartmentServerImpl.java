package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.DepartmentMapper;
import com.nnlightctl.dao.InstitutionMapper;
import com.nnlightctl.po.Department;
import com.nnlightctl.po.DepartmentExample;
import com.nnlightctl.po.Institution;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DepartmentRequest;
import com.nnlightctl.server.DepartmentServer;
import com.nnlightctl.vo.DepartmentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentServerImpl implements DepartmentServer {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private InstitutionMapper institutionMapper;
    @Override
    public int addOrUpdateDepartment(DepartmentRequest request) {
        Department department = new Department();
        ReflectCopyUtil.beanSameFieldCopy(request, department);
        department.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            department.setGmtCreated(new Date());
            department.setCreateTime(new Date());
            department.setDepartmentLevel((byte)0);

            ret = departmentMapper.insertSelective(department);
        } else {
            //更新
            ret = departmentMapper.updateByPrimaryKeySelective(department);
        }
        return ret;
    }
    @Override
    public int getCountDepartmentByName(String departmentName){
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDepartmentNameEqualTo(departmentName);
        int total = departmentMapper.countByExample(departmentExample);
        return total;
    }

    @Override
    public Tuple.TwoTuple<List<DepartmentView>, Integer> listDepartment(DepartmentRequest request) {
        Tuple.TwoTuple<List<DepartmentView>, Integer> tuple = new Tuple.TwoTuple<>();

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        if(!StringUtils.isEmpty(request.getAddr())){
            criteria.andAddrLike("%" + request.getAddr() + "%");
        }
        if(!StringUtils.isEmpty(request.getDepartmentName())){
            criteria.andDepartmentNameLike("%" + request.getDepartmentName() + "%");
        }
        departmentExample.setOrderByClause("id DESC");

        int total = departmentMapper.countByExample(departmentExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        List<DepartmentView> departmentViewList = new ArrayList<>();
        if (!departmentList.isEmpty()){
            for (int i = 0 ; i < departmentList.size() ; i++){
                DepartmentView departmentView = new DepartmentView();
                Institution institution = institutionMapper.selectByPrimaryKey(departmentList.get(i).getNnlightctlInstitutionIdBelong());
                departmentView.setAddr(departmentList.get(i).getAddr());
                departmentView.setCreateTime(departmentList.get(i).getCreateTime());
                departmentView.setDepartmentLevel(departmentList.get(i).getDepartmentLevel());
                departmentView.setDepartmentName(departmentList.get(i).getDepartmentName());
                departmentView.setGmtCreated(departmentList.get(i).getGmtCreated());
                departmentView.setGmtUpdated(departmentList.get(i).getGmtUpdated());
                departmentView.setId(departmentList.get(i).getId());
                departmentView.setMem(departmentList.get(i).getMem());
                departmentView.setNnlightctlDepartmentIdParent(departmentList.get(i).getNnlightctlDepartmentIdParent());
                departmentView.setNnlightctlInstitutionIdBelong(departmentList.get(i).getNnlightctlInstitutionIdBelong());
                if (null != institution ){
                    departmentView.setInstitutionName(institution.getInstitutionName());
                }
                departmentViewList.add(departmentView);
            }
        }

        tuple.setFirst(departmentViewList);

        return tuple;
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteDepartment(List<Long> departmentIds) {
        for (Long id : departmentIds) {
            departmentMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
}
