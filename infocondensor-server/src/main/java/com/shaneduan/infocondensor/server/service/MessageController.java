/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaneduan.infocondensor.server.service;

import com.google.gson.Gson;
import com.shaneduan.infocondensor.server.repository.MessageRepository;
import com.shaneduan.infocondensor.server.model.Message;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Liu Xin <xin.liu@ankoninc.com.cn>
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageRepository messageRepo;

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public List<Message> refresh(@RequestBody String rb) throws InterruptedException {
        Gson gson = new Gson();
        RefreshRequest request = gson.fromJson(rb, RefreshRequest.class);
        System.err.println(request.lastRequestTime);
        System.err.println(request.websites.get(0));
        Date current = new Date();
        ArrayList<Message> result = new ArrayList<>();
        for (String site : request.websites) {
            if (site.equals("https://www.kidsbestjobs.com")) {
                Message m = new Message();
                m.setCreateTime(current);
                m.setTitle("Teaching Assistant");
                m.setId(new Date().getTime());
                m.setContent("Job Provider: EDU Express\n"
                        + "Job Location: San Ramon,Contra Costa, California");
                m.setUrl("https://www.kidsbestjobs.com/kids-best-job-web/pages/job_detail.html?id=91");
                result.add(m);
                Thread.sleep(10l);
                m = new Message();
                m.setTitle("Programming");
                m.setCreateTime(current);
                m.setId(new Date().getTime());
                m.setContent("Job Provider: Young Ivy Academy\n"
                        + "Job Location: Pleasanton,Alameda, California");
                m.setUrl("https://www.kidsbestjobs.com/kids-best-job-web/pages/job_detail.html?id=94");
                result.add(m);
            }
            if (site.equals("https://www.amazon.com/")) {
                Message m = new Message();
                m.setCreateTime(current);
                m.setId(new Date().getTime());
                m.setTitle("Xbox 360 E console");
                m.setContent("Xbox 360 E console\n"
                        + "1 Black Wireless Controller\n"
                        + "Built in Wi-Fi\n"
                        + "1 month of Xbox LIVE Gold");
                m.setUrl("https://www.amazon.com/Xbox-360-E-4GB-Console/dp/B00D9EPI38/ref=sr_1_2?s=videogames&ie=UTF8&qid=1500294309&sr=1-2&keywords=xbox&th=1");
                result.add(m);
                Thread.sleep(10l);
                m = new Message();
                m.setCreateTime(current);
                m.setTitle("Xbox One 500GB Console - Name Your Game Bundle");
                m.setId(new Date().getTime());
                m.setContent("This product includes: 500GB hard drive Xbox One Console, digital download code to choose one of four games (listed in next bullet point),Xbox One black wireless controller with a 3.5mm headset jack so you can plug in any compatible headset, 14-day trial of Xbox Live Gold, AC Power Cable, and an HDMI Cable.");
                m.setUrl("https://www.amazon.com/gp/product/B019TYEXC8/ref=s9_acsd_zwish_hd_bw_b73oV9v_c_x_w?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-1&pf_rd_r=22B9PENKYE61QM203T11&pf_rd_r=22B9PENKYE61QM203T11&pf_rd_t=101&pf_rd_p=55c5b6f0-ca79-4c95-9c0e-1b275fcd2237&pf_rd_p=55c5b6f0-ca79-4c95-9c0e-1b275fcd2237&pf_rd_i=6469295011");
                result.add(m);
            }
        }
        //    System.err.println(request);
        return result;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Date test() {
        return new Date();
    }

    private static class RefreshRequest {

        List<String> websites;
        Date lastRequestTime;
    }

}
