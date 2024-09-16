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

package com.xlf.schedule.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * 邮箱验证码表实体
 * <p>
 * 该类用于定义邮箱验证码表实体;
 *
 * @since v1.0.0
 * @version v1.0.0
 * @author xiao_lfeng
 */
@Data
@TableName("xf_mail_code")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MailCodeDO {
    /**
     * 验证码UUID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String codeUuid;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 验证码
     */
    private String code;
    /**
     * 创建时间
     */
    private Timestamp createdAt;
    private Timestamp expiredAt;
}
