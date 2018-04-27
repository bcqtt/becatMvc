package com.baozi.service;

import com.baozi.po.SysUser;
import com.baozi.vo.PlatEventVo;
import com.baozi.vo.SysUserVo;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 15:05
 * @description 用户相关的service
 **/
public interface SysUserService {

    /**
     * 查找平台用户数量
     * @return
     */
    public int findAllUserCount();

    /**
     * 根据用户ID查询用户最后登录时间
     * @param userId
     * @return
     */
    public Date findUserLastLoginTime(int userId);

    /**
     * 根据主键查询用户
     * @param userId
     * @return
     */
    public SysUser findSysUserByUserId(int userId);

    /**
     * 修改个人资料
     * @param sysUser
     */
    public int updateUserInfo(SysUser sysUser);

    /**
     * 修改个人密码
     * @param userId
     * @param newpwd
     * @return
     */
    public int updateUserPwd(int userId,String newpwd);

    /**
     * 分页查询平台用户数据
     * @param paramMap
     * @return
     */
    public PageInfo<SysUserVo> findSysUserPage (Map<String,Object> paramMap);

    /**
     * 启动或者禁用用户登录
     * @param usercode
     * @param lock
     * @return
     */
    public void updateSysUserLock(String usercode,String lock);
}
