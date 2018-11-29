package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LightingGroupMapper;
import com.nnlightctl.dao.SceneMapper;
import com.nnlightctl.dao.SceneShotcutMapper;
import com.nnlightctl.dao.SwitchTaskMapper;
import com.nnlightctl.jdbcdao.LightingGroupMapDao;
import com.nnlightctl.jdbcdao.LightingGroupMapGroupDao;
import com.nnlightctl.jdbcdao.SceneMapLightingGroupDao;
import com.nnlightctl.jdbcdao.SceneMapSwitchTaskDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.LightServer;
import com.nnlightctl.server.SceneServer;
import com.nnlightctl.vo.SceneView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SceneServerImpl implements SceneServer {

    @Autowired
    private SceneMapper sceneMapper;

    @Autowired
    private SceneMapLightingGroupDao sceneMapLightingGroupDao;

    @Autowired
    private SceneMapSwitchTaskDao sceneMapSwitchTaskDao;

    @Autowired
    private LightingGroupMapper lightingGroupMapper;

    @Autowired
    private SwitchTaskMapper switchTaskMapper;

    @Autowired
    private SceneShotcutMapper sceneShotcutMapper;

    @Autowired
    private LightingGroupMapDao lightingGroupMapDao;

    @Autowired
    private LightingGroupMapGroupDao lightingGroupMapGroupDao;

    @Autowired
    private LightServer lightServer;

    @Override
    public int addOrUpdateScene(SceneRequest request) {
        Scene scene = new Scene();
        ReflectCopyUtil.beanSameFieldCopy(request, scene);
        scene.setGmtUpdated(new Date());

        if (request.getId() == null) {
            //新增
            scene.setGmtCreated(new Date());

            sceneMapper.insertSelective(scene);
        } else {
            //修改
            sceneMapper.updateByPrimaryKeySelective(scene);
        }

        //编辑场景与灯组分组的映射关系
        sceneMapLightingGroupDao.deleteSceneMap(scene.getId());
        if (request.getLightingGroupIds() != null && request.getLightingGroupIds().size() > 0) {
            sceneMapLightingGroupDao.batchAddSceneLightingGroupMap(scene.getId(), request.getLightingGroupIds());
        }

        //编辑场景与任务开关的映射关系
        sceneMapSwitchTaskDao.deleteSceneMap(scene.getId());
        if (request.getSwitchTaskIds() != null && request.getSwitchTaskIds().size() > 0) {
            sceneMapSwitchTaskDao.batchAddSceneSwitchTaskMap(scene.getId(), request.getSwitchTaskIds());
        }

        return 1;
    }
    @Override
    public int getCountSceneShotcutByShotcutName(String shotcutName){
        SceneShotcutExample sceneShotcutExample = new SceneShotcutExample();
        sceneShotcutExample.createCriteria().andShotcutNameEqualTo(shotcutName);
        int total =sceneShotcutMapper.countByExample(sceneShotcutExample);
        return total;
    }
    @Override
    public int getCountSceneShotcutBySceneId(Long sceneId){
        SceneShotcutExample sceneShotcutExample = new SceneShotcutExample();
        sceneShotcutExample.createCriteria().andNnlightctlSceneIdEqualTo(sceneId.longValue());
        int total =sceneShotcutMapper.countByExample(sceneShotcutExample);
        return total;
    }
    @Override
    public Tuple.TwoTuple<List<Scene>, Integer> listScene(SceneRequest request) {
        Tuple.TwoTuple<List<Scene>, Integer> tuple = new Tuple.TwoTuple<>();

        SceneExample sceneExample = new SceneExample();
        if(request.getSceneName() != null){
            sceneExample.createCriteria().andSceneNameEqualTo(request.getSceneName());
        }
        sceneExample.setOrderByClause("id DESC");

        int total = sceneMapper.countByExample(sceneExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Scene> sceneList = sceneMapper.selectByExample(sceneExample);
        tuple.setFirst(sceneList);

        return tuple;
    }

    @Override
    public SceneView getScene(Long id) {
        Scene scene = sceneMapper.selectByPrimaryKey(id);

        SceneView sceneView = new SceneView();
        ReflectCopyUtil.beanSameFieldCopy(scene, sceneView);

        //获取场景对应的灯具分组集合
        List<SceneView.LightingGroup> sceneViewLightingGroupList = new ArrayList<>(8);
        List<Long> lightingGroupIds = this.sceneMapLightingGroupDao.getLightingGroupIds(id);
        for (Long lightingGroupId : lightingGroupIds) {
            LightingGroup lightingGroup = lightingGroupMapper.selectByPrimaryKey(lightingGroupId);
            SceneView.LightingGroup viewLightingGroup = new SceneView.LightingGroup();
            ReflectCopyUtil.beanSameFieldCopy(lightingGroup, viewLightingGroup);
            sceneViewLightingGroupList.add(viewLightingGroup);
        }
        sceneView.setLightingGroups(sceneViewLightingGroupList);

        //获取场景对应的任务开关集合
        List<SceneView.SwitchTask> sceneViewSwitchTaskList = new ArrayList<>(8);
        List<Long> switchTaskIds = this.sceneMapSwitchTaskDao.getSwitchTaskIds(id);
        for (Long switchTaskId : switchTaskIds) {
            SwitchTask switchTask = switchTaskMapper.selectByPrimaryKey(switchTaskId);
            SceneView.SwitchTask viewSwitchTask = new SceneView.SwitchTask();
            ReflectCopyUtil.beanSameFieldCopy(switchTask, viewSwitchTask);
            sceneViewSwitchTaskList.add(viewSwitchTask);
        }
        sceneView.setSwitchTasks(sceneViewSwitchTaskList);

        return sceneView;
    }

    @Override
    public int deleteScene(SceneConditionRequest request) {
        List<Long> sceneIds = request.getSceneIds();

        for (Long sceneId : sceneIds) {
            this.sceneMapLightingGroupDao.deleteSceneMap(sceneId);
            this.sceneMapSwitchTaskDao.deleteSceneMap(sceneId);
            this.sceneMapper.deleteByPrimaryKey(sceneId);
        }

        return 1;
    }

    @Override
    public int addOrUpdateSceneShotcut(SceneShotcutRequest request) {
        SceneShotcut sceneShotcut = new SceneShotcut();
        ReflectCopyUtil.beanSameFieldCopy(request, sceneShotcut);
        sceneShotcut.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            sceneShotcut.setGmtCreated(new Date());

            ret = sceneShotcutMapper.insertSelective(sceneShotcut);
        } else {
            //修改
            ret = sceneShotcutMapper.updateByPrimaryKeySelective(sceneShotcut);
        }

        return ret;
    }

    @Override
    public int deleteSceneShotcut(SceneShotcutConditionRequest request) {
        List<Long> sceneShotcutIds = request.getSceneShotcutIds();
        for (Long id : sceneShotcutIds) {
            sceneShotcutMapper.deleteByPrimaryKey(id);
        }

        return 1;
    }

    @Override
    public int getInvokeSceneShotcut(String shotcutName) {
        SceneShotcutExample sceneShotcutExample = new SceneShotcutExample();
        sceneShotcutExample.createCriteria().andShotcutNameEqualTo(shotcutName);

        List<SceneShotcut> sceneShotcuts = this.sceneShotcutMapper.selectByExample(sceneShotcutExample);

        for (SceneShotcut sceneShotcut : sceneShotcuts) {
            Long sceneId = sceneShotcut.getNnlightctlSceneId();
            Scene scene = this.sceneMapper.selectByPrimaryKey(sceneId);


        }

        return 1;
    }

    @Override
    public List<SceneShotcut> listSceneShotcut() {
        return sceneShotcutMapper.selectByExample(new SceneShotcutExample());
    }

    private List<Long> getLightingIdsByLightGroupId(Long lightGroupId) {
        List<Long> lightingIds = new ArrayList<>(8);

        //组映射
        List<Long> lightIdList = lightingGroupMapDao.getLightingIdsByGroupId(lightGroupId);
        if (lightIdList != null) {
            lightingIds.addAll(lightIdList);
        }

        //组组映射
        List<Long> lightingGroupIdList = lightingGroupMapGroupDao.getLightGroupIdsByGroupId(lightGroupId);
        if (lightingGroupIdList != null && lightingGroupIdList.size() > 0) {
            for (Long subLightingGroupId : lightingGroupIdList) {
                lightingIds.addAll(getLightingIdsByLightGroupId(subLightingGroupId));
            }
        }

        return lightingIds;
    }

    @Override
    public List<Lighting> listLightingsOfScene(Long sceneId) {
        SceneView sceneView = getScene(sceneId);
        List<SceneView.LightingGroup> lightingGroupList = sceneView.getLightingGroups();
        List<Long> lightIds = new ArrayList<>(8);

        for (SceneView.LightingGroup lightingGroup : lightingGroupList) {
            lightIds.addAll(getLightingIdsByLightGroupId(lightingGroup.getId()));
        }

        List<Lighting> lightingList = new ArrayList<>(8);

        for (Long id : lightIds) {
            lightingList.add(lightServer.getLighting(id));
        }

        return lightingList;
    }

    @Override
    public List<SwitchTask> listSwitchTaskOfScene(Long scendId) {
        SceneView sceneView = getScene(scendId);

        List<SceneView.SwitchTask> switchTasks = sceneView.getSwitchTasks();

        List<SwitchTask> switchTaskList = new ArrayList<>(8);

        for (SceneView.SwitchTask switchTask : switchTasks) {
            SwitchTask switchTask1 = new SwitchTask();
            ReflectCopyUtil.beanSameFieldCopy(switchTask, switchTask1);
            switchTaskList.add(switchTask1);
        }

        return switchTaskList;
    }
}
