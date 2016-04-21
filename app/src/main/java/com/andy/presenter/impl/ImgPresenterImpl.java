package com.andy.presenter.impl;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.ClassifyBean;
import com.andy.modle.domain.ImgClassitfyModel;
import com.andy.modle.domain.ImgClassitfyModelImpl;
import com.andy.presenter.api.ImgPresenter;
import com.andy.ui.iview.ImgView;

import java.util.List;

/**
 * Created by tengshuai on 2016/2/24.
 */
public class ImgPresenterImpl implements ImgPresenter, ImgClassitfyModelImpl.OnloadImgListener {

    ImgView mImgView;
    ImgClassitfyModel mImgClassitfyModel;
    ApiService apiService;

    public ImgPresenterImpl(ImgView imgView,ApiService apiService) {
        this.mImgView = imgView;
        this.mImgClassitfyModel = new ImgClassitfyModelImpl();
        this.apiService=apiService;
    }

    @Override
    public void loadList(int id) {
        mImgView.showProgress();
        mImgClassitfyModel.loadSuccess(apiService,id,this);
    }

    @Override
    public void success(List<ClassifyBean> list) {
        mImgView.hideProgress();
        mImgView.loadImgDatas(list);
    }
}
