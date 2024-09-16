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

package com.xlf.schedule.logic;

import com.xlf.schedule.dao.TokenDAO;
import com.xlf.schedule.dao.UserDAO;
import com.xlf.schedule.model.dto.UserDTO;
import com.xlf.schedule.model.entity.TokenDO;
import com.xlf.schedule.model.entity.UserDO;
import com.xlf.schedule.service.UserService;
import com.xlf.utility.ErrorCode;
import com.xlf.utility.exception.BusinessException;
import com.xlf.utility.util.HeaderUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 用户逻辑
 * <p>
 * 该类用于定义用户逻辑；
 * 该类使用 {@link Service} 注解标记；
 * 该类实现 {@link UserService} 接口；
 *
 * @author xiao_lfeng
 * @version v1.0.0
 * @since v1.0.0
 */
@Service
@RequiredArgsConstructor
public class UserLogic implements UserService {
    private final UserDAO userDAO;
    private final TokenDAO tokenDAO;

    @Override
    public UserDTO getUserForThreeType(String user) {
        // 检查用户类型
        UserDO userDO;
        if (Pattern.matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", user)) {
            userDO = userDAO.lambdaQuery().eq(UserDO::getPhone, user).one();
        } else if (Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", user)) {
            userDO = userDAO.lambdaQuery().eq(UserDO::getEmail, user).one();
        } else if (Pattern.matches("^[a-zA-Z0-9_-]{4,36}$", user)) {
            userDO = userDAO.lambdaQuery().eq(UserDO::getUsername, user).one();
        } else {
            userDO = null;
        }
        if (userDO == null) {
            throw new BusinessException("用户不存在", ErrorCode.NOT_EXIST);
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);

        return userDTO;
    }

    @Override
    public UserDTO getUserByUuid(String userUuid) {
        UserDO userDO = userDAO.lambdaQuery().eq(UserDO::getUuid, userUuid).one();
        if (userDO == null) {
            throw new BusinessException("用户不存在", ErrorCode.NOT_EXIST);
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);

        return userDTO;
    }

    @Override
    public UserDTO getUserByToken(HttpServletRequest request) {
        UUID getUserUuid = HeaderUtil.getAuthorizeUserUuid(request);
        if (getUserUuid == null) {
            throw new BusinessException("令牌不存在", ErrorCode.NOT_EXIST);
        }
        TokenDO getTokenDO = tokenDAO.lambdaQuery().eq(TokenDO::getTokenUuid, getUserUuid.toString()).one();
        if (getTokenDO == null) {
            throw new BusinessException("令牌不存在", ErrorCode.NOT_EXIST);
        }
        return this.getUserByUuid(getTokenDO.getUserUuid());
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserDO userDO = userDAO.lambdaQuery().eq(UserDO::getEmail, email).one();
        if (userDO == null) {
            throw new BusinessException("用户不存在", ErrorCode.NOT_EXIST);
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO getUserByPhone(String phone) {
        UserDO userDO = userDAO.lambdaQuery().eq(UserDO::getPhone, phone).one();
        if (userDO == null) {
            throw new BusinessException("用户不存在", ErrorCode.NOT_EXIST);
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);
        return userDTO;
    }
}
