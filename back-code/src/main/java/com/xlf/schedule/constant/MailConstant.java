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

package com.xlf.schedule.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 邮件常量
 * <p>
 * 该类用于定义邮件常量信息;
 *
 * @author xiao_lfeng
 * @version v1.0.0
 * @since v1.0.0
 */
public class MailConstant {
    private MailConstant() {
        throw new IllegalStateException("Utility class");
    }

    @Getter
    @Setter
    private static String mailUsername;
    @Getter
    @Setter
    private static String mailNickName;
    @Getter
    @Setter
    private static String mailDefaultEncoding;
}
