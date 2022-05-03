/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.zhengjie.portfolio.room.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.zhengjie.converter.StringListConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author smk
 * @website https://el-admin.vip
 * @description /
 * @date 2022-05-03
 **/
@Entity
@Data
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Long id;

    @Column(name = "type")
    @ApiModelProperty(value = "type")
    private String type;

    @Column(name = "size")
    @ApiModelProperty(value = "size")
    private String size;

    @Column(name = "air_conditional", nullable = false)
    @NotNull
    @ApiModelProperty(value = "airConditional")
    private Integer airConditional;

    @Column(name = "fan", nullable = false)
    @NotNull
    @ApiModelProperty(value = "fan")
    private Integer fan;

    @Column(name = "free_parking")
    @ApiModelProperty(value = "freeParking")
    private Integer freeParking;

    @Column(name = "description")
    @ApiModelProperty(value = "description")
    private String description;

    @Column(name = "bed", nullable = false)
    @NotNull
    @ApiModelProperty(value = "bed")
    private Integer bed;

    @Column(name = "free_breakfast")
    @ApiModelProperty(value = "freeBreakfast")
    private Integer freeBreakfast;

    @Column(name = "image", nullable = false)
    @ApiModelProperty(value = "image")
    @Convert(converter = StringListConverter.class)
    private List<String> image;

    @Column(name = "extra_information")
    @ApiModelProperty(value = "extraInformation")
    @Convert(converter = StringListConverter.class)
    private List<String> extraInformation;

    public void copy(Room source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}