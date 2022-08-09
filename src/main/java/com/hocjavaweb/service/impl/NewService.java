package com.hocjavaweb.service.impl;

import com.hocjavaweb.DAO.INewDAO;
import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.paging.Pageble;
import com.hocjavaweb.service.INewService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService {

    @Inject
    private INewDAO newDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setCreatedBy("");
        Long newId = newDAO.save(newsModel);
        return newDAO.findOne(newId);
    }

    @Override
    public NewsModel update(NewsModel updateNewsModel) {
        NewsModel oldNew = newDAO.findOne(updateNewsModel.getId());
        updateNewsModel.setCreatedDate(oldNew.getCreatedDate());
        updateNewsModel.setCreatedBy(oldNew.getCreatedBy());
        updateNewsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNewsModel.setModifiedby("");
        newDAO.update(updateNewsModel);
        return newDAO.findOne(updateNewsModel.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (long id:ids) {
            newDAO.delete(id);
        }
    }
    @Override
    public List<NewsModel> findAll(Pageble pageble) {
        return newDAO.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return newDAO.getTotalItem();
    }
}
