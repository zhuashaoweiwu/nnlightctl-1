package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.WorkOrderDao;
import com.nnlightctl.jdbcmapper.LightingGroupMapBatch;
import com.nnlightctl.jdbcmapper.WorkflowerNodeMapBatch;
import com.nnlightctl.po.WorkOrder;
import com.nnlightctl.request.WorkFlowerRequest;
import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.vo.CountWorkOrderStateView;
import com.nnlightctl.vo.StatisticWorkOrderView;
import com.nnlightctl.vo.WorkFlowerNodeMapView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WorkOrderDaoImpl implements WorkOrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderMouthTotalByProject(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.project_name as projectName FROM ");
        sql.append("(SELECT p.project_name from nnlightctl_work_order o INNER JOIN nnlightctl_project p ON o.nnlightctl_project_id = p.id ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,7) = ? ) c ");
            param.add(date);
        }
        sql.append("GROUP BY c.project_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setMouthTotalByProject(resultSet.getString("total"));
                statisticWorkOrderView.setProjectName(resultSet.getString("projectName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderMouthFinishByProject(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.project_name as projectName FROM ");
        sql.append("(SELECT p.project_name from nnlightctl_work_order o INNER JOIN nnlightctl_project p ON o.nnlightctl_project_id = p.id and o.state = 3 ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,7) = ? ) c ");
            param.add(date);
        }
        sql.append(" GROUP BY c.project_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setMouthFinishByProject(resultSet.getString("total"));
                statisticWorkOrderView.setProjectName(resultSet.getString("projectName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearTotalByProject(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.project_name as projectName FROM ");
        sql.append("(SELECT p.project_name from nnlightctl_work_order o INNER JOIN nnlightctl_project p ON o.nnlightctl_project_id = p.id ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,4) = ? ) c ");
            param.add(date);
        }
        sql.append("GROUP BY c.project_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setYearTotalByProject(resultSet.getString("total"));
                statisticWorkOrderView.setProjectName(resultSet.getString("projectName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearFinishByProject(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.project_name as projectName FROM ");
        sql.append("(SELECT p.project_name from nnlightctl_work_order o INNER JOIN nnlightctl_project p ON o.nnlightctl_project_id = p.id and o.state = 3 ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,4) = ? ) c ");
            param.add(date);
        }
        sql.append("GROUP BY c.project_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setYearFinishByProject(resultSet.getString("total"));
                statisticWorkOrderView.setProjectName(resultSet.getString("projectName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public  List<StatisticWorkOrderView> statisticWorkOrderMouthTotalByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.area_name as areaName FROM ");
        sql.append("(SELECT r.area_name from nnlightctl_work_order o INNER JOIN nnlightctl_region r ON o.nnlightctl_region_id = r.id ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,7) = ? ) c ");
            param.add(date);
        }
        sql.append("GROUP BY c.area_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setMouthTotalByRegion(resultSet.getString("total"));
                statisticWorkOrderView.setAreaName(resultSet.getString("areaName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderMouthFinishByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.area_name as areaName FROM ");
        sql.append("(SELECT r.area_name from nnlightctl_work_order o INNER JOIN nnlightctl_region r ON o.nnlightctl_region_id = r.id and o.state =3 ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,7) = ? ) c ");
            param.add(date);
        }
        sql.append("GROUP BY c.area_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setMouthFinishByRegion(resultSet.getString("total"));
                statisticWorkOrderView.setAreaName(resultSet.getString("areaName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearTotalByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.area_name as areaName FROM ");
        sql.append("(SELECT r.area_name from nnlightctl_work_order o INNER JOIN nnlightctl_region r ON o.nnlightctl_region_id = r.id ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,4) = ? ) c ");
            param.add(date);
        }
        sql.append("GROUP BY c.area_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setYearTotalByRegion(resultSet.getString("total"));
               statisticWorkOrderView.setAreaName(resultSet.getString("areaName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearFinishByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) as total, c.area_name as areaName FROM ");
        sql.append("(SELECT r.area_name from nnlightctl_work_order o INNER JOIN nnlightctl_region r ON o.nnlightctl_region_id = r.id and o.state = 3 ");
        if (date != null){
            sql.append(" and SUBSTR(o.work_created ,1,4) = ? ) c ");
            param.add(date);
        }
        sql.append("GROUP BY c.area_name");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setYearFinishByRegion(resultSet.getString("total"));
                statisticWorkOrderView.setAreaName(resultSet.getString("areaName"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public  List<WorkOrder> listWorkOrderMouth(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
       /* sql.append("SELECT id ,gmt_created ,gmt_updated ,serial_number ,classify ,work_created ,work_done ,nnlightctl_workflower_id ,state ,priority , nnlightctl_region_id ,address ,nnlightctl_workflower_move_record_id ,nnlightctl_masker_id ,content ,attach_file_path ,work_source ,nnlightctl_project_id from nnlightctl_work_order where state = 3 ");
        if (date != null){
            sql.append(" and SUBSTR(work_created ,1,7) = ? ");
            param.add(date);
        }*/
       sql.append("SELECT o.gmt_created ,o.work_created , o.work_done ,p.project_name ,o.state ,o.nnlightctl_region_id from nnlightctl_work_order o INNER JOIN nnlightctl_project p ON o.nnlightctl_project_id = p.id AND o.state=3 ");
        if (date != null){
            sql.append(" AND SUBSTR(o.work_created ,1,7) = ? ");
            param.add(date);
        }
        List<WorkOrder> workOrderList = jdbcTemplate.query(sql.toString(),param.toArray(),new RowMapper<WorkOrder>() {
            @Override
            public WorkOrder mapRow(ResultSet resultSet, int i) throws SQLException {
                WorkOrder workOrder = new WorkOrder();
                //workOrder.setId(resultSet.getLong("id"));
                workOrder.setGmtCreated(resultSet.getDate("gmt_created"));
                /*workOrder.setGmtUpdated(resultSet.getDate("gmt_updated"));
                workOrder.setSerialNumber(resultSet.getString("serial_number"));
                workOrder.setClassify(resultSet.getByte("classify"));*/
                workOrder.setWorkCreated(resultSet.getTimestamp("work_created"));
                workOrder.setWorkDone(resultSet.getTimestamp("work_done"));
                //workOrder.setNnlightctlWorkflowerId(resultSet.getLong("nnlightctl_workflower_id"));
                workOrder.setState(resultSet.getByte("state"));
                // workOrder.setPriority(resultSet.getByte("priority"));
                workOrder.setNnlightctlRegionId(resultSet.getLong("nnlightctl_region_id"));
                workOrder.setAddress(resultSet.getString("project_name"));
                /*  workOrder.setNnlightctlWorkflowerMoveRecordId(resultSet.getLong("nnlightctl_workflower_move_record_id"));
                workOrder.setNnlightctlMaskerId(resultSet.getLong("nnlightctl_masker_id"));
                workOrder.setContent(resultSet.getString("content"));
                workOrder.setAttachFilePath(resultSet.getString("attach_file_path"));
                workOrder.setWorkSource(resultSet.getByte("work_source"));
                workOrder.setNnlightctlProjectId(resultSet.getLong("nnlightctl_project_id"));*/
                return workOrder;
            }
        });
        return workOrderList;
    }
    @Override
    public List<WorkOrder> listWorkOrderYear(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        /*sql.append("SELECT id ,gmt_created ,gmt_updated ,serial_number ,classify ,work_created ,work_done ,nnlightctl_workflower_id ,state ,priority , ");
        sql.append("nnlightctl_region_id ,address ,nnlightctl_workflower_move_record_id ,nnlightctl_masker_id ,content ,attach_file_path ,work_source ,nnlightctl_project_id from nnlightctl_work_order where state = 3 ");
        if (date != null){
            sql.append(" and SUBSTR(work_created ,1,4) = ? ");
            param.add(date);
        }*/
        sql.append("SELECT o.gmt_created ,o.work_created , o.work_done ,p.project_name ,o.state ,o.nnlightctl_region_id from nnlightctl_work_order o INNER JOIN nnlightctl_project p ON o.nnlightctl_project_id = p.id AND o.state=3 ");
        if (date != null){
            sql.append(" AND SUBSTR(o.work_created ,1,4) = ? ");
            param.add(date);
        }
        List<WorkOrder> workOrderList = jdbcTemplate.query(sql.toString(), param.toArray(),new RowMapper<WorkOrder>() {
            @Override
            public WorkOrder mapRow(ResultSet resultSet, int i) throws SQLException {
                WorkOrder workOrder = new WorkOrder();
                //workOrder.setId(resultSet.getLong("id"));
                workOrder.setGmtCreated(resultSet.getDate("gmt_created"));
                /*workOrder.setGmtUpdated(resultSet.getDate("gmt_updated"));
                workOrder.setSerialNumber(resultSet.getString("serial_number"));
                workOrder.setClassify(resultSet.getByte("classify"));*/
                workOrder.setWorkCreated(resultSet.getTimestamp("work_created"));
                workOrder.setWorkDone(resultSet.getTimestamp("work_done"));
                //workOrder.setNnlightctlWorkflowerId(resultSet.getLong("nnlightctl_workflower_id"));
                workOrder.setState(resultSet.getByte("state"));
                // workOrder.setPriority(resultSet.getByte("priority"));
                workOrder.setNnlightctlRegionId(resultSet.getLong("nnlightctl_region_id"));
                workOrder.setAddress(resultSet.getString("project_name"));
                /*  workOrder.setNnlightctlWorkflowerMoveRecordId(resultSet.getLong("nnlightctl_workflower_move_record_id"));
                workOrder.setNnlightctlMaskerId(resultSet.getLong("nnlightctl_masker_id"));
                workOrder.setContent(resultSet.getString("content"));
                workOrder.setAttachFilePath(resultSet.getString("attach_file_path"));
                workOrder.setWorkSource(resultSet.getByte("work_source"));
                workOrder.setNnlightctlProjectId(resultSet.getLong("nnlightctl_project_id"));*/
                return workOrder;
            }
        });
        return workOrderList;
    }
    @Override
    public int addOrUpdateWorkFlowerMap(List<Long> workFlowerNodeIds , Long WorkFlowerId){
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO nnlightctl_workflower_node_map(gmt_created, gmt_updated, nnlightctl_workflower_id, nnlightctl_workflower_node_id ,order_number) " +
                "values (?, ?, ?, ?,?)");

        int[] result = jdbcTemplate.batchUpdate(sql.toString(), new WorkflowerNodeMapBatch(WorkFlowerId, workFlowerNodeIds));

        return result.length;
    }
    @Override
    public List<WorkFlowerNodeMapView> listWorkflowerNodeMapByWorkflowerId(Long workflowerId){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT id,gmt_created ,gmt_updated ,nnlightctl_workflower_id ,nnlightctl_workflower_node_id ,order_number FROM nnlightctl_workflower_node_map ");
        if (workflowerId !=null ){
            sql.append(" where nnlightctl_workflower_id = ?");
            param.add(workflowerId);
        }
        List<WorkFlowerNodeMapView> workFlowerNodeMapViewList = jdbcTemplate.query(sql.toString(), param.toArray(),new RowMapper<WorkFlowerNodeMapView>() {
            @Override
            public WorkFlowerNodeMapView mapRow(ResultSet resultSet, int i) throws SQLException {
                WorkFlowerNodeMapView workFlowerNodeMapView = new WorkFlowerNodeMapView();
                workFlowerNodeMapView.setId(resultSet.getLong("id"));
                workFlowerNodeMapView.setGmtCreated(resultSet.getDate("gmt_created"));
                workFlowerNodeMapView.setGmtUpdated(resultSet.getDate("gmt_updated"));
                workFlowerNodeMapView.setNnlightctlWorkflowerId(resultSet.getLong("nnlightctl_workflower_id"));
                workFlowerNodeMapView.setNnlightctlWorkflowerNodeId(resultSet.getLong("nnlightctl_workflower_node_id"));
                workFlowerNodeMapView.setOrderNumber(resultSet.getLong("order_number"));
                return workFlowerNodeMapView;
            }
        });
        return workFlowerNodeMapViewList;
    }
    @Override
    public int deleteWorkflowerNodeMapByWorkflowerId(Long workflowerId){
        StringBuilder sql = new StringBuilder();
        sql.append("delete from nnlightctl_workflower_node_map where nnlightctl_workflower_id = ?");
        return jdbcTemplate.update(sql.toString(), new Object[] {workflowerId});
    }
}
