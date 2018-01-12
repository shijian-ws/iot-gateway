package org.sj.iot.gateway.data.service.impl;

import org.sj.iot.gateway.data.model.Accounts;
import org.sj.iot.gateway.data.model.Gatewayinfo;
import org.sj.iot.gateway.data.service.tx.IAccountsService;
import org.sj.iot.gateway.data.service.IControlService;
import org.sj.iot.gateway.data.service.tx.IGatewayinfoService;
import org.sj.iot.model.Cmd.CmdInfo;
import org.sj.iot.model.Message;
import org.sj.iot.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-07
 */
@Service
public class ControlServiceImpl implements IControlService {
    @Autowired
    private IGatewayinfoService service;
    @Autowired
    private IAccountsService accountsService;

    private String[] name = new String[1];

    @PostConstruct
    public void init() {
        /*new Thread(() -> CommUtil.ssdp("ssdp\n".getBytes(), "ssdp\n0\n".getBytes(), result -> name[0] = new String(result))).start();*/
    }

    @Override
    public Gatewayinfo getgatewayinfo() {
        return service.get();
    }

    @Override
    public Accounts getuserdata() {
        return accountsService.get();
    }

    private static Message getMessage() {
        return ThreadLocalUtil.get(Message.class);
    }

    private static CmdInfo getCmdInfo() {
        return ThreadLocalUtil.get(CmdInfo.class);
    }

    @Override
    public void setlighton() {
        Message message = getMessage();
        CmdInfo cmdInfo = getCmdInfo();
        Map<String, Object> cmdMap = cmdInfo.getCmdMap(); // 命令参数
        int oper = Integer.valueOf(0).equals(null) ? 0 : 1;
        String name = this.name[0];
        if (name != null) {
            /*CommUtil.send(name, String.format("oper\n%s", oper).getBytes(), 3000);*/
        }
    }

    @Override
    public void setlightcolor() {
        Message message = getMessage();
        CmdInfo cmdInfo = getCmdInfo();
        Map<String, Object> cmdMap = cmdInfo.getCmdMap(); // 命令参数
        int r = 167;
        int g = 77;
        int b = 10;
        String name = this.name[0];
        if (name != null) {
            /*CommUtil.send(name, String.format("color\n%s%s%s", Integer.toHexString(r), Integer.toHexString(g), Integer.toHexString(b)).getBytes(), 3000);*/
        }
    }
}
