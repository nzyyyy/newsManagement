package com.news.newsmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宁致远
 * @since 2022-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("newInfo")
public class NewInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "newId", type = IdType.AUTO)
    private Integer newId;

    private String title;

    private String description;

    private String content;

    private Integer published;

}
