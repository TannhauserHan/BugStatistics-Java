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
public class ZtBug implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer product;

    private Integer branch;

    private Integer module;

    private Integer project;

    private Integer plan;

    private Integer story;

    @TableField("storyVersion")
    private Integer storyversion;

    private Integer task;

    @TableField("toTask")
    private Integer totask;

    @TableField("toStory")
    private Integer tostory;

    private String title;

    private String keywords;

    private Integer severity;

    private Integer pri;

    private String type;

    private String os;

    private String browser;

    private String hardware;

    private String found;

    private String steps;

    private String status;

    @TableField("subStatus")
    private String substatus;

    private String color;

    private Boolean confirmed;

    @TableField("activatedCount")
    private Integer activatedcount;

    @TableField("activatedDate")
    private LocalDateTime activateddate;

    private String mailto;

    @TableField("openedBy")
    private String openedby;

    @TableField("openedDate")
    private LocalDateTime openeddate;

    @TableField("openedBuild")
    private String openedbuild;

    @TableField("assignedTo")
    private String assignedto;

    @TableField("assignedDate")
    private LocalDateTime assigneddate;

    private LocalDate deadline;

    @TableField("resolvedBy")
    private String resolvedby;

    private String resolution;

    @TableField("resolvedBuild")
    private String resolvedbuild;

    @TableField("resolvedDate")
    private LocalDateTime resolveddate;

    @TableField("closedBy")
    private String closedby;

    @TableField("closedDate")
    private LocalDateTime closeddate;

    @TableField("duplicateBug")
    private Integer duplicatebug;

    @TableField("linkBug")
    private String linkbug;

    private Integer Case;

    @TableField("caseVersion")
    private Integer caseversion;

    private Integer result;

    private Integer repo;

    private String entry;

    private String lines;

    private String v1;

    private String v2;

    @TableField("repoType")
    private String repotype;

    private Integer testtask;

    @TableField("lastEditedBy")
    private String lasteditedby;

    @TableField("lastEditedDate")
    private LocalDateTime lastediteddate;

    private String deleted;


}
