package com.yzw.apitest.entity.portal;

import com.yzw.apitest.entity.Base;
import lombok.Data;

import java.util.Date;

@Data
public class User extends Base {
    private String loginCode;
    private String loginPassword;
    private String name;
    private Integer orgId;
    private String orgCode;
    private Integer type;
    private int gender;
    private String mobile;
    private String email;
    private String jobTitle;
    private String qq;
    private Date lastChangePwdDate;
    private Date lastLoginTime;
    private String countryCode;
    private String randomCode;
    private String openId;
    private String note;
    private String avatarImageUrl;
    private Long jcId;
    private int status;
    //user_extend table
    private Long supplierId;
    private Integer supplierType;
    private Long parentSupplierId;
    private Integer companyId;
    private String extendContent;
    private Integer subcontractorId;
    private String appId;
}
