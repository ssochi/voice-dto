package com.xperdit.dto.models;

import com.xperdit.dto.annotations.Model;
import com.xperdit.dto.utils.Interfaces.Utils;


/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/21 0021.
 */
@Model
public interface UserInfo extends Utils {

    public String getToken();

    public void setToken(String token);

    public String getScreenName();

    public void setScreenName(String screenName) ;

    public String getUid() ;

    public void setUid(String uid) ;
}
