package com.imooc;

import com.imooc.netty.WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author 周宇
 * @create 2021-11-28 15:11
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            //启动netty
            try {
                WSServer.getInstance().start(8088);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
