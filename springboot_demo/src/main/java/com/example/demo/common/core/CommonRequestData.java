package com.example.demo.common.core;

/**
 * @author SanKai
 * @since 2019-11-11
 */
public class CommonRequestData {

    /**
     * 请求头参数前缀
     */
    public static final String HEADER_PREFIX = "x-c-";

    /**
     * 神策的前缀
     */
    public static final String SENSOR_PREFIX = "x-sensor-";

    /**
     * 平台类型
     * android / ios / h5/ web
     */
    private String platform;
    /**
     * ver 版本号 示例:1.2.3
     */
    private String version;
    /**
     * 渠道id
     */
    private String cid;
    /**
     * 设备Id 设备编号 3887678564564656
     */
    private String did;
    /**
     * 设备品牌
     */
    private String db;
    /**
     * 设备型号
     */
    private String ml;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 定位城市
     */
    private String location;
    /**
     * 包名
     */
    private String from;
    /**
     * 请求的时间戳
     */
    private String timestamp;


    /**
     * 神策相关信息:或者统计相关的信息
     */
    private SensorsCommonParam sensors;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getMl() {
        return ml;
    }

    public void setMl(String ml) {
        this.ml = ml;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public SensorsCommonParam getSensors() {
        return sensors;
    }

    public void setSensors(SensorsCommonParam sensors) {
        this.sensors = sensors;
    }

    public static class SensorsCommonParam {

        /*匿名id*/
        private String anonymous_id;

        /*产品*/
        private String product;

        /*业务子产品*/
        private String module;

        /*操作系统*/
        private String os;

        /*操作系统版本*/
        private String os_version;

        /*屏幕高度*/
        private Integer screen_height;

        /*屏幕宽度*/
        private Integer screen_width;

        /*是否wifi*/
        private Boolean wifi;

        /*浏览器*/
        private String browser;

        /*浏览器版本*/
        private String browser_version;

        /*运营商名称*/
        private String carrier;

        /*网络类型*/
        private String network_type;

        /*广告系列来源*/
        private String utm_source;

        /*广告系列媒介*/
        private String utm_medium;

        /*广告系列字词*/
        private String utm_term;

        /*广告系列内容*/
        private String utm_content;

        /*广告系列名称*/
        private String utm_campaign;

        public String getAnonymous_id() {
            return anonymous_id;
        }

        public void setAnonymous_id(String anonymous_id) {
            this.anonymous_id = anonymous_id;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getOs_version() {
            return os_version;
        }

        public void setOs_version(String os_version) {
            this.os_version = os_version;
        }

        public Integer getScreen_height() {
            return screen_height;
        }

        public void setScreen_height(Integer screen_height) {
            this.screen_height = screen_height;
        }

        public Integer getScreen_width() {
            return screen_width;
        }

        public void setScreen_width(Integer screen_width) {
            this.screen_width = screen_width;
        }

        public Boolean getWifi() {
            return wifi;
        }

        public void setWifi(Boolean wifi) {
            this.wifi = wifi;
        }

        public String getBrowser() {
            return browser;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }

        public String getBrowser_version() {
            return browser_version;
        }

        public void setBrowser_version(String browser_version) {
            this.browser_version = browser_version;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getNetwork_type() {
            return network_type;
        }

        public void setNetwork_type(String network_type) {
            this.network_type = network_type;
        }

        public String getUtm_source() {
            return utm_source;
        }

        public void setUtm_source(String utm_source) {
            this.utm_source = utm_source;
        }

        public String getUtm_medium() {
            return utm_medium;
        }

        public void setUtm_medium(String utm_medium) {
            this.utm_medium = utm_medium;
        }

        public String getUtm_term() {
            return utm_term;
        }

        public void setUtm_term(String utm_term) {
            this.utm_term = utm_term;
        }

        public String getUtm_content() {
            return utm_content;
        }

        public void setUtm_content(String utm_content) {
            this.utm_content = utm_content;
        }

        public String getUtm_campaign() {
            return utm_campaign;
        }

        public void setUtm_campaign(String utm_campaign) {
            this.utm_campaign = utm_campaign;
        }
    }

}
