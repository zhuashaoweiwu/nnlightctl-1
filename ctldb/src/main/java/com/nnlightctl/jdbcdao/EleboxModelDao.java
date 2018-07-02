package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;

import java.util.List;
public interface EleboxModelDao {

    List<EleboxModel> listEleboxModel(Long EleboxId);

    List<EleboxModelLoop> listEleboxModelLoop(Long EleboxModelLoopId);

}
