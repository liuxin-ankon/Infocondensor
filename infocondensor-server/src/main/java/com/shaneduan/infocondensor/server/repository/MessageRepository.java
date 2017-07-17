package com.shaneduan.infocondensor.server.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.shaneduan.infocondensor.server.model.Message;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Liu Xin <xin.liu@ankoninc.com.cn>
 */
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "elements", path = "message")  
public interface MessageRepository extends PagingAndSortingRepository<Message, String> {
    
}
