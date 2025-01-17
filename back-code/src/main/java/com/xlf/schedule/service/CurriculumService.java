/*
 * ***************************************************************************************
 * author: XiaoLFeng(https://www.x-lf.com)
 * about:
 *   The project contains the source code of com.xlf.schedule.
 *   All source code for this project is licensed under the MIT open source license.
 * licenseStatement:
 *   Copyright (c) 2016-2024 XiaoLFeng. All rights reserved.
 *   For more information about the MIT license, please view the LICENSE file
 *     in the project root directory or visit:
 *   https://opensource.org/license/MIT
 * disclaimer:
 *   Since this project is in the model design stage, we are not responsible for any losses
 *     caused by using this project for commercial purposes.
 *   If you modify the code and redistribute it, you need to clearly indicate what changes
 *     you made in the corresponding file.
 *   If you want to modify it for commercial use, please contact me.
 * ***************************************************************************************
 */

package com.xlf.schedule.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xlf.schedule.model.dto.ClassGradeDTO;
import com.xlf.schedule.model.dto.ClassTimeDTO;
import com.xlf.schedule.model.dto.UserDTO;
import com.xlf.schedule.model.entity.ClassTimeMarketDO;
import com.xlf.schedule.model.vo.ClassTimeVO;
import com.xlf.schedule.model.vo.ClassVO;

import java.util.Date;

/**
 * 课程表服务
 * <p>
 * 该类用于定义课程表服务;
 *
 * @author xiao_lfeng
 * @version v1.0.0
 * @since v1.0.0
 */
public interface CurriculumService {

    /*
     * ***************************************************************************************
     * 课程表服务
     * ***************************************************************************************
     */

    /**
     * 创建课程表
     * <p>
     * 该方法用于创建课程表；
     * 创建课程表时，需要提供 {@code 名称}、{@code 开始时间}、{@code 结束时间}；
     * 创建成功后，返回创建结果。
     *
     * @param name     名称
     * @param begin    开始时间
     * @param end      结束时间
     * @param userUuid 用户UUID
     * @param timeUuid 时间UUID
     * @return 创建课程表的主键
     */
    String createClassGrade(String name, Date begin, Date end, String userUuid, String timeUuid);

    /**
     * 获取课程表
     * <p>
     * 该方法用于获取课程表；
     * 获取课程表时，需要提供 {@code UUID}；
     * 获取成功后，返回课程表信息。
     *
     * @param userDTO 用户信息
     * @param uuid    课程表UUID
     * @return 课程表信息
     */
    ClassGradeDTO getClassGrade(UserDTO userDTO, String uuid);

    /**
     * 删除课程表
     * <p>
     * 该方法用于删除课程表；
     * 删除课程表时，需要提供 {@code UUID}；
     * 删除成功后，返回删除结果。
     *
     * @param userDTO        用户信息
     * @param classGradeUuid 课程表UUID
     */
    void deleteClassGrade(UserDTO userDTO, String classGradeUuid);

    /**
     * 编辑课程表
     * <p>
     * 该方法用于编辑课程表；
     * 编辑课程表时，需要提供 {@code UUID}、{@code 名称}、{@code 开始时间}、{@code 结束时间}、{@code 用户UUID}；
     * 编辑成功后，返回编辑结果。
     *
     * @param uuid     课程表UUID
     * @param name     名称
     * @param begin    开始时间
     * @param end      结束时间
     * @param userDTO  用户信息
     * @param timeUuid 时间UUID
     */
    void editClassGrade(String uuid, String name, Date begin, Date end, UserDTO userDTO, String timeUuid);

    /*
     * ***************************************************************************************
     * 课程表时间服务
     * ***************************************************************************************
     */

    /**
     * 创建课程时间
     * <p>
     * 该方法用于创建课程时间；
     * 创建课程时间时，需要提供 {@code 用户信息}、{@code 课程时间值对象}；
     * 创建成功后，返回创建结果。
     *
     * @param userDTO     用户信息
     * @param classTimeVO 课程时间值对象
     */
    void createClassTime(UserDTO userDTO, ClassTimeVO classTimeVO);

    /**
     * 获取课程时间
     * <p>
     * 该方法用于获取课程时间；
     * 获取课程时间时，需要提供 {@code 课程时间UUID}；
     * 获取成功后，返回课程时间信息。
     *
     * @param userDTO       用户信息
     * @param classTimeUuid 课程时间UUID
     * @param classTimeVO   课程时间值对象
     */
    void editClassTime(UserDTO userDTO, String classTimeUuid, ClassTimeVO classTimeVO);

    /**
     * 删除课程时间
     * <p>
     * 该方法用于删除课程时间；
     * 删除课程时间时，需要提供 {@code 用户信息}、{@code 课程时间UUID}；
     * 删除成功后，返回删除结果。
     *
     * @param userDTO       用户信息
     * @param classTimeUuid 课程时间UUID
     */
    void deleteClassTime(UserDTO userDTO, String classTimeUuid);

    /**
     * 获取课程时间列表
     * <p>
     * 该方法用于获取课程时间列表；
     * 获取课程时间列表时，需要提供 {@code 页码}、{@code 每页数量}；
     * 获取成功后，返回课程时间列表。
     *
     * @param page 页码
     * @param size 每页数量
     * @return 课程时间列表
     */
    Page<ClassTimeMarketDO> getClassTimeMarketList(Integer page, Integer size);

    /**
     * 获取课程时间
     * <p>
     * 该方法用于获取课程时间；
     * 获取课程时间时，需要提供 {@code 课程时间UUID}；
     * 获取成功后，返回课程时间信息。
     *
     * @param classTimeMarketUuid 课程时间UUID
     * @return 课程时间信息
     */
    ClassTimeDTO getClassTimeMarket(String classTimeMarketUuid);

    /*
     * ***************************************************************************************
     * 我的课程表时间服务
     * ***************************************************************************************
     */

    /**
     * 添加我的课程时间
     * <p>
     * 该方法用于添加我的课程时间；
     * 添加我的课程时间时，需要提供 {@code 用户信息}、{@code 课程时间UUID}。
     *
     * @param userDTO             用户信息
     * @param classTimeMarketUuid 课程时间UUID
     */
    void addMyClassTime(UserDTO userDTO, String classTimeMarketUuid);

    /**
     * 删除我的课程时间
     * <p>
     * 该方法用于删除我的课程时间；
     * 删除我的课程时间时，需要提供 {@code 用户信息}、{@code 课程时间UUID}。
     *
     * @param userDTO             用户信息
     * @param classTimeMarketUuid 课程时间UUID
     */
    void deleteMyClassTime(UserDTO userDTO, String classTimeMarketUuid);

    /**
     * 获取我的课程时间列表
     * <p>
     * 该方法用于获取我的课程时间列表；
     * 获取我的课程时间列表时，需要提供 {@code 用户信息}、{@code 页码}、{@code 每页数量}；
     * 获取成功后，返回我的课程时间列表。
     *
     * @param userDTO 用户信息
     * @param page    页码
     * @param size    每页数量
     * @return 我的课程时间列表
     */
    Page<ClassTimeMarketDO> getMyClassTimeList(UserDTO userDTO, Integer page, Integer size);

    /**
     * 获取我的课程时间
     * <p>
     * 该方法用于获取我的课程时间；
     * 获取我的课程时间时，需要提供 {@code 用户信息}、{@code 课程时间UUID}；
     * 获取成功后，返回我的课程时间信息。
     *
     * @param userDTO             用户信息
     * @param classTimeMarketUuid 课程时间UUID
     * @return 我的课程时间信息
     */
    ClassTimeDTO getMyClassTime(UserDTO userDTO, String classTimeMarketUuid);

    /*
     * ***************************************************************************************
     * 课程服务
     * ***************************************************************************************
     */

    /**
     * 添加课程
     * <p>
     * 该方法用于添加课程；添加课程时，需要提供 {@code 用户信息}、{@code 课程值对象}。
     *
     * @param userDTO 用户信息
     * @param classVO 课程值对象
     */
    void addClass(UserDTO userDTO, ClassVO classVO);

    /**
     * 删除课程
     * <p>
     * 该方法用于删除课程；删除课程时，需要提供 {@code 用户信息}、{@code 课程UUID}、{@code 第几周}、{@code 第几节}、{@code 第几节}、{@code 第几天}。
     *
     * @param userDTO   用户信息
     * @param classUuid 课程UUID
     * @param week      移动周数
     * @param startTick 第几节
     * @param endTick   第几节
     * @param dayTick   第几天
     */
    void moveClass(UserDTO userDTO, String classUuid, Short week, Short startTick, Short endTick, Short dayTick);

    /**
     * 删除课程
     * <p>
     * 该方法用于删除课程；删除课程时，需要提供 {@code 用户信息}、{@code 课程UUID}。
     *
     * @param userDTO   用户信息
     * @param classUuid 课程UUID
     */
    void deleteClass(UserDTO userDTO, String classUuid);

    /**
     * 获取课程列表
     * <p>
     * 该方法用于获取课程列表。
     *
     * @param getUser           用户信息
     * @param classGradeUuid    课程表UUID
     * @param className         课程名称
     * @param originalDayTick   原星期几
     * @param originalStartTick 原开始节次
     * @param originalEndTick   原结束节次
     * @param startTick         开始节次
     * @param endTick           结束节次
     * @param dayTick           星期几
     */
    void moveMutiClass(UserDTO getUser, String classGradeUuid, String className, Short originalDayTick, Short originalStartTick, Short originalEndTick, Short startTick, Short endTick, Short dayTick);

    /**
     * 删除课程
     * <p>
     * 该方法用于删除课程；删除课程时，需要提供 {@code 用户信息}、{@code 课程表UUID}、{@code 课程名称}、{@code 原星期几}、{@code 原开始节次}、{@code 原结束节次}。
     *
     * @param getUser          用户信息
     * @param classGrade       课程表UUID
     * @param className        课程名称
     * @param originalDayTick  原星期几
     * @param originalStartTick 原开始节次
     * @param originalEndTick  原结束节次
     */
    void deleteMutiClass(UserDTO getUser, String classGrade, String className, Short originalDayTick, Short originalStartTick, Short originalEndTick);
}
