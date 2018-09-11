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
        sql.append("SELECT count(*) total , a.mouth from (SELECT count(*) ,SUBSTR(work_created ,1,7) as mouth from nnlightctl_work_order GROUP BY nnlightctl_project_id) a where 1=1 ");
        if (date != null){
            sql.append(" and a.mouth = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.mouth ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                statisticWorkOrderView.setMouthTotalByProject(resultSet.getString("total"));
                statisticWorkOrderView.setMouth(resultSet.getString("mouth"));
                /*statisticWorkOrderView.setProjectTotal(resultSet.getString("total"));
                statisticWorkOrderView.setTime(resultSet.getString("mouth"));*/
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderMouthFinishByProject(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) totalFinish , a.mouthFinish from (SELECT count(*) ,SUBSTR(work_created ,1,7) as mouthFinish ,state from nnlightctl_work_order GROUP BY nnlightctl_project_id) a where a.state = '3' ");
        if (date != null){
            sql.append(" and a.mouthFinish = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.mouthFinish ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                /*statisticWorkOrderView.setProjectTotal(resultSet.getString("total"));
                statisticWorkOrderView.setTime(resultSet.getString("mouth"));*/
                statisticWorkOrderView.setMouthFinishByProject(resultSet.getString("totalFinish"));
                statisticWorkOrderView.setMouth(resultSet.getString("mouthFinish"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearTotalByProject(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) total , a.year from (SELECT count(*) ,SUBSTR(work_created ,1,4) as year from nnlightctl_work_order GROUP BY nnlightctl_project_id) a where 1=1 ");
        if (date != null){
            sql.append(" and a.year = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.year ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();

                statisticWorkOrderView.setYearTotalByProject(resultSet.getString("total"));
                statisticWorkOrderView.setYear(resultSet.getString("year"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearFinishByProject(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) totalFinish , a.yearFinish from (SELECT count(*) ,SUBSTR(work_created ,1,4) as yearFinish ,state from nnlightctl_work_order GROUP BY nnlightctl_project_id) a where a.state ='3' ");
        if (date != null){
            sql.append(" and a.yearFinish = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.yearFinish ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                /*statisticWorkOrderView.setProjectTotal(resultSet.getString("total"));
                statisticWorkOrderView.setTime(resultSet.getString("mouth"));*/
                statisticWorkOrderView.setYearFinishByProject(resultSet.getString("totalFinish"));
                statisticWorkOrderView.setYear(resultSet.getString("yearFinish"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public  List<StatisticWorkOrderView> statisticWorkOrderMouthTotalByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) total , a.mouth from (SELECT count(*) ,SUBSTR(work_created ,1,7) as mouth from nnlightctl_work_order GROUP BY nnlightctl_region_id) a where 1=1 ");
        if (date != null){
            sql.append(" and a.mouth = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.mouth ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                /*statisticWorkOrderView.setProjectTotal(resultSet.getString("total"));
                statisticWorkOrderView.setTime(resultSet.getString("mouth"));*/
                statisticWorkOrderView.setMouthTotalByRegion(resultSet.getString("total"));
                statisticWorkOrderView.setMouth(resultSet.getString("mouth"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderMouthFinishByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) totalFinish , a.mouthFinish from (SELECT count(*) ,SUBSTR(work_created ,1,7) as mouthFinish ,state from nnlightctl_work_order GROUP BY nnlightctl_region_id) a where a.state = '3' ");
        if (date != null){
            sql.append(" and a.mouthFinish = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.mouthFinish ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                /*statisticWorkOrderView.setProjectTotal(resultSet.getString("total"));
                statisticWorkOrderView.setTime(resultSet.getString("mouth"));*/
                statisticWorkOrderView.setMouthFinishByRegion(resultSet.getString("totalFinish"));
                statisticWorkOrderView.setMouth(resultSet.getString("mouthFinish"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearTotalByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) total , a.year from (SELECT count(*) ,SUBSTR(work_created ,1,4) as year from nnlightctl_work_order GROUP BY nnlightctl_region_id) a where 1=1 ");
        if (date != null){
            sql.append(" and a.year = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.year ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
                /*statisticWorkOrderView.setProjectTotal(resultSet.getString("total"));
                statisticWorkOrderView.setTime(resultSet.getString("mouth"));*/
                statisticWorkOrderView.setYearTotalByRegion(resultSet.getString("total"));
                statisticWorkOrderView.setYear(resultSet.getString("year"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderYearFinishByRegion(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT count(*) totalFinish , a.yearFinish from (SELECT count(*) ,SUBSTR(work_created ,1,4) as yearFinish ,state from nnlightctl_work_order GROUP BY nnlightctl_region_id) a where a.state ='3' ");
        if (date != null){
            sql.append(" and a.yearFinish = ? ");
            param.add(date);
        }
        sql.append(" GROUP BY a.yearFinish ");
        List<StatisticWorkOrderView> statisticWorkOrderViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<StatisticWorkOrderView>() {
            @Override
            public StatisticWorkOrderView mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
               /* statisticWorkOrderView.setProjectTotal(resultSet.getString("total"));
                statisticWorkOrderView.setTime(resultSet.getString("mouth"));*/
               statisticWorkOrderView.setYearFinishByRegion(resultSet.getString("totalFinish"));
               statisticWorkOrderView.setYear(resultSet.getString("yearFinish"));
                return statisticWorkOrderView;
            }
        });
        return statisticWorkOrderViewList;
    }
    @Override
    public  List<WorkOrder> listWorkOrderMouth(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT id ,gmt_created ,gmt_updated ,serial_number ,classify ,work_created ,work_done ,nnlightctl_workflower_id ,state ,priority , nnlightctl_region_id ,address ,nnlightctl_workflower_move_record_id ,nnlightctl_masker_id ,content ,attach_file_path ,work_source ,nnlightctl_project_id from nnlightctl_work_order where state = 3 ");
        if (date != null){
            sql.append(" and SUBSTR(work_created ,1,7) = ? ");
            param.add(date);
        }
        List<WorkOrder> workOrderList = jdbcTemplate.query(sql.toString(),param.toArray(),new RowMapper<WorkOrder>() {
            @Override
            public WorkOrder mapRow(ResultSet resultSet, int i) throws SQLException {
                WorkOrder workOrder = new WorkOrder();
                workOrder.setId(resultSet.getLong("id"));
                workOrder.setGmtCreated(resultSet.getDate("gmt_created"));
                workOrder.setGmtUpdated(resultSet.getDate("gmt_updated"));
                workOrder.setSerialNumber(resultSet.getString("serial_number"));
                workOrder.setClassify(resultSet.getByte("classify"));
                workOrder.setWorkCreated(resultSet.getTimestamp("work_created"));
                workOrder.setWorkDone(resultSet.getTimestamp("work_done"));
                workOrder.setNnlightctlWorkflowerId(resultSet.getLong("nnlightctl_workflower_id"));
                workOrder.setState(resultSet.getByte("state"));
                workOrder.setPriority(resultSet.getByte("priority"));
                workOrder.setNnlightctlRegionId(resultSet.getLong("nnlightctl_region_id"));
                workOrder.setAddress(resultSet.getString("address"));
                workOrder.setNnlightctlWorkflowerMoveRecordId(resultSet.getLong("nnlightctl_workflower_move_record_id"));
                workOrder.setNnlightctlMaskerId(resultSet.getLong("nnlightctl_masker_id"));
                workOrder.setContent(resultSet.getString("content"));
                workOrder.setAttachFilePath(resultSet.getString("attach_file_path"));
                workOrder.setWorkSource(resultSet.getByte("work_source"));
                workOrder.setNnlightctlProjectId(resultSet.getLong("nnlightctl_project_id"));
                return workOrder;
            }
        });
        return workOrderList;
    }
    @Override
    public List<WorkOrder> listWorkOrderYear(String date){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT id ,gmt_created ,gmt_updated ,serial_number ,classify ,work_created ,work_done ,nnlightctl_workflower_id ,state ,priority , ");
        sql.append("nnlightctl_region_id ,address ,nnlightctl_workflower_move_record_id ,nnlightctl_masker_id ,content ,attach_file_path ,work_source ,nnlightctl_project_id from nnlightctl_work_order where state = 3 ");
        if (date != null){
            sql.append(" and SUBSTR(work_created ,1,4) = ? ");
            param.add(date);
        }
        List<WorkOrder> workOrderList = jdbcTemplate.query(sql.toString(), param.toArray(),new RowMapper<WorkOrder>() {
            @Override
            public WorkOrder mapRow(ResultSet resultSet, int i) throws SQLException {
                WorkOrder workOrder = new WorkOrder();
                workOrder.setId(resultSet.getLong("id"));
                workOrder.setGmtCreated(resultSet.getDate("gmt_created"));
                workOrder.setGmtUpdated(resultSet.getDate("gmt_updated"));
                workOrder.setSerialNumber(resultSet.getString("serial_number"));
                workOrder.setClassify(resultSet.getByte("classify"));
                workOrder.setWorkCreated(resultSet.getDate("work_created"));
                workOrder.setWorkDone(resultSet.getDate("work_done"));
                workOrder.setNnlightctlWorkflowerId(resultSet.getLong("nnlightctl_workflower_id"));
                workOrder.setState(resultSet.getByte("state"));
                workOrder.setPriority(resultSet.getByte("priority"));
                workOrder.setNnlightctlRegionId(resultSet.getLong("nnlightctl_region_id"));
                workOrder.setAddress(resultSet.getString("address"));
                workOrder.setNnlightctlWorkflowerMoveRecordId(resultSet.getLong("nnlightctl_workflower_move_record_id"));
                workOrder.setNnlightctlMaskerId(resultSet.getLong("nnlightctl_masker_id"));
                workOrder.setContent(resultSet.getString("content"));
                workOrder.setAttachFilePath(resultSet.getString("attach_file_path"));
                workOrder.setWorkSource(resultSet.getByte("work_source"));
                workOrder.setNnlightctlProjectId(resultSet.getLong("nnlightctl_project_id"));
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
