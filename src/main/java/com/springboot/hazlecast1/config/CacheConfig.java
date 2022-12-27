package com.springboot.hazlecast1.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CacheConfig {
    public Config configure(){
        return new Config().setInstanceName("hazlecast-instance").addMapConfig(
                new MapConfig().setName("userCache").setTimeToLiveSeconds(20).setEvictionConfig(new EvictionConfig().setEvictionPolicy(EvictionPolicy.LRU)));
    }
}
