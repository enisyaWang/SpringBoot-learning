package cn.clboy.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author cloudlandboy
 * @Date 2019/11/24 上午10:42
 * @Since 1.0.0
 */

@ConfigurationProperties(prefix = "clboy")
public class ClboyProperties {

    private String prefix;
    private String suffix;

    public ClboyProperties() {
        this.prefix = "";
        this.suffix = "";
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}