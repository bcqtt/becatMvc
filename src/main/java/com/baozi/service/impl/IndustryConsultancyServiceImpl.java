package com.baozi.service.impl;

import com.baozi.mappers.IndustryConsultancyCategoryMapper;
import com.baozi.mappers.IndustryConsultancyMapper;
import com.baozi.po.IndustryConsultancy;
import com.baozi.service.IndustryConsultancyService;
import com.baozi.vo.IndustryConsultancyViewVo;
import com.baozi.vo.IndustryConsultancyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 16:34
 * @description 文章逻辑操作类
 **/
@Service
public class IndustryConsultancyServiceImpl implements IndustryConsultancyService{

    @Autowired
    private IndustryConsultancyMapper industryConsultancyMapper;

    @Autowired
    private IndustryConsultancyCategoryMapper industryConsultancyCategoryMapper;

    @Override
    public List<IndustryConsultancyViewVo> findIndustryConsultancyTopLimit(int limit) {
        return industryConsultancyMapper.findIndustryConsultancyTopLimit(limit);
    }

    @Override
    public PageInfo<IndustryConsultancyVo> findIndustryConsultancyPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<IndustryConsultancyVo> dataList = industryConsultancyMapper.findIndustryConsultancyPage(paramMap);
        return new PageInfo<IndustryConsultancyVo>(dataList);
    }

    @Override
    public List<Map> selectAllCategory() {
        return industryConsultancyCategoryMapper.selectAllCategory();
    }

    @Override
    public int deleteIndusSingleOrBatch(List idList) {
        return industryConsultancyMapper.deleteIndusSingleOrBatch(idList);
    }

    @Override
    public int updateIndusStatus(int id, int status) {
        IndustryConsultancy industryConsultancy = new IndustryConsultancy();
        industryConsultancy.setId(id);
        industryConsultancy.setStatus(status);
        industryConsultancy.setLastmodifytime(new Date());
        return industryConsultancyMapper.updateByPrimaryKeySelective(industryConsultancy);
    }

    @Override
    public int updateIndustryConsultancy(IndustryConsultancy industryConsultancy) {
        return industryConsultancyMapper.updateByPrimaryKeySelective(industryConsultancy);
    }

    @Override
    public int insert(IndustryConsultancy industryConsultancy) {
        return industryConsultancyMapper.insertSelective(industryConsultancy);
    }

    @Override
    public PageInfo<IndustryConsultancyViewVo> footerPagination(Map<String,Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<IndustryConsultancyViewVo> dataList = industryConsultancyMapper.footerPagination();
        return new PageInfo<IndustryConsultancyViewVo>(dataList);
    }

    @Override
    public IndustryConsultancy findIndustryConsultancyById(int id) {
        return industryConsultancyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateIndustryConsultancyLookNum(int id) {
        return industryConsultancyMapper.updateIndustryConsultancyLookNum(id);
    }
}
