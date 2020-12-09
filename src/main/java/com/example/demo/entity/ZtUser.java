package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author han
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZtUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer dept;

    private String account;

    private String password;

    private String role;

    private String realname;

    private String nickname;

    private String commiter;

    private String avatar;

    private LocalDate birthday;

    private String gender;

    private String email;

    private String skype;

    private String qq;

    private String mobile;

    private String phone;

    private String weixin;

    private String dingding;

    private String slack;

    private String whatsapp;

    private String address;

    private String zipcode;

    private LocalDate join;

    private Integer visits;

    private String ip;

    private Integer last;

    private Integer fails;

    private LocalDateTime locked;

    private String ranzhi;

    private Integer score;

    @TableField("scoreLevel")
    private Integer scorelevel;

    private String deleted;

    @TableField("clientStatus")
    private String clientstatus;

    @TableField("clientLang")
    private String clientlang;


}
