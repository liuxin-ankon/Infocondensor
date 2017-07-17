/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaneduan.infocondensor.server.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Liu Xin <xin.liu@ankoninc.com.cn>
 */
@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 1024)
    private String title;
    @Size(max = 40960)
    private String content;
    @Size(max = 1024)
    private String url;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createTime;
}
