package org.sj.iot.gateway.data.model;

public class SceneLights {
    private Integer uuid;

    private Integer sceneid;

    private Integer type;

    private String mac;

    private Integer dnlm;

    private Integer mode1;

    private Integer r1;

    private Integer g1;

    private Integer b1;

    private Integer h1;

    private Integer s1;

    private Integer w1;

    private Integer c1;

    private Integer cri1;

    private Integer warm1;

    private Integer bri1;

    private Integer on1;

    private Integer mode2;

    private Integer r2;

    private Integer g2;

    private Integer b2;

    private Integer h2;

    private Integer s2;

    private Integer w2;

    private Integer c2;

    private Integer cri2;

    private Integer warm2;

    private Integer bri2;

    private Integer on2;

    private Integer dynamic;

    private Integer orderIndex;

    private Integer reserve1;

    private Integer creationTime;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getSceneid() {
        return sceneid;
    }

    public void setSceneid(Integer sceneid) {
        this.sceneid = sceneid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getDnlm() {
        return dnlm;
    }

    public void setDnlm(Integer dnlm) {
        this.dnlm = dnlm;
    }

    public Integer getMode1() {
        return mode1;
    }

    public void setMode1(Integer mode1) {
        this.mode1 = mode1;
    }

    public Integer getR1() {
        return r1;
    }

    public void setR1(Integer r1) {
        this.r1 = r1;
    }

    public Integer getG1() {
        return g1;
    }

    public void setG1(Integer g1) {
        this.g1 = g1;
    }

    public Integer getB1() {
        return b1;
    }

    public void setB1(Integer b1) {
        this.b1 = b1;
    }

    public Integer getH1() {
        return h1;
    }

    public void setH1(Integer h1) {
        this.h1 = h1;
    }

    public Integer getS1() {
        return s1;
    }

    public void setS1(Integer s1) {
        this.s1 = s1;
    }

    public Integer getW1() {
        return w1;
    }

    public void setW1(Integer w1) {
        this.w1 = w1;
    }

    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

    public Integer getCri1() {
        return cri1;
    }

    public void setCri1(Integer cri1) {
        this.cri1 = cri1;
    }

    public Integer getWarm1() {
        return warm1;
    }

    public void setWarm1(Integer warm1) {
        this.warm1 = warm1;
    }

    public Integer getBri1() {
        return bri1;
    }

    public void setBri1(Integer bri1) {
        this.bri1 = bri1;
    }

    public Integer getOn1() {
        return on1;
    }

    public void setOn1(Integer on1) {
        this.on1 = on1;
    }

    public Integer getMode2() {
        return mode2;
    }

    public void setMode2(Integer mode2) {
        this.mode2 = mode2;
    }

    public Integer getR2() {
        return r2;
    }

    public void setR2(Integer r2) {
        this.r2 = r2;
    }

    public Integer getG2() {
        return g2;
    }

    public void setG2(Integer g2) {
        this.g2 = g2;
    }

    public Integer getB2() {
        return b2;
    }

    public void setB2(Integer b2) {
        this.b2 = b2;
    }

    public Integer getH2() {
        return h2;
    }

    public void setH2(Integer h2) {
        this.h2 = h2;
    }

    public Integer getS2() {
        return s2;
    }

    public void setS2(Integer s2) {
        this.s2 = s2;
    }

    public Integer getW2() {
        return w2;
    }

    public void setW2(Integer w2) {
        this.w2 = w2;
    }

    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    public Integer getCri2() {
        return cri2;
    }

    public void setCri2(Integer cri2) {
        this.cri2 = cri2;
    }

    public Integer getWarm2() {
        return warm2;
    }

    public void setWarm2(Integer warm2) {
        this.warm2 = warm2;
    }

    public Integer getBri2() {
        return bri2;
    }

    public void setBri2(Integer bri2) {
        this.bri2 = bri2;
    }

    public Integer getOn2() {
        return on2;
    }

    public void setOn2(Integer on2) {
        this.on2 = on2;
    }

    public Integer getDynamic() {
        return dynamic;
    }

    public void setDynamic(Integer dynamic) {
        this.dynamic = dynamic;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getReserve1() {
        return reserve1;
    }

    public void setReserve1(Integer reserve1) {
        this.reserve1 = reserve1;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SceneLights other = (SceneLights) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getSceneid() == null ? other.getSceneid() == null : this.getSceneid().equals(other.getSceneid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMac() == null ? other.getMac() == null : this.getMac().equals(other.getMac()))
            && (this.getDnlm() == null ? other.getDnlm() == null : this.getDnlm().equals(other.getDnlm()))
            && (this.getMode1() == null ? other.getMode1() == null : this.getMode1().equals(other.getMode1()))
            && (this.getR1() == null ? other.getR1() == null : this.getR1().equals(other.getR1()))
            && (this.getG1() == null ? other.getG1() == null : this.getG1().equals(other.getG1()))
            && (this.getB1() == null ? other.getB1() == null : this.getB1().equals(other.getB1()))
            && (this.getH1() == null ? other.getH1() == null : this.getH1().equals(other.getH1()))
            && (this.getS1() == null ? other.getS1() == null : this.getS1().equals(other.getS1()))
            && (this.getW1() == null ? other.getW1() == null : this.getW1().equals(other.getW1()))
            && (this.getC1() == null ? other.getC1() == null : this.getC1().equals(other.getC1()))
            && (this.getCri1() == null ? other.getCri1() == null : this.getCri1().equals(other.getCri1()))
            && (this.getWarm1() == null ? other.getWarm1() == null : this.getWarm1().equals(other.getWarm1()))
            && (this.getBri1() == null ? other.getBri1() == null : this.getBri1().equals(other.getBri1()))
            && (this.getOn1() == null ? other.getOn1() == null : this.getOn1().equals(other.getOn1()))
            && (this.getMode2() == null ? other.getMode2() == null : this.getMode2().equals(other.getMode2()))
            && (this.getR2() == null ? other.getR2() == null : this.getR2().equals(other.getR2()))
            && (this.getG2() == null ? other.getG2() == null : this.getG2().equals(other.getG2()))
            && (this.getB2() == null ? other.getB2() == null : this.getB2().equals(other.getB2()))
            && (this.getH2() == null ? other.getH2() == null : this.getH2().equals(other.getH2()))
            && (this.getS2() == null ? other.getS2() == null : this.getS2().equals(other.getS2()))
            && (this.getW2() == null ? other.getW2() == null : this.getW2().equals(other.getW2()))
            && (this.getC2() == null ? other.getC2() == null : this.getC2().equals(other.getC2()))
            && (this.getCri2() == null ? other.getCri2() == null : this.getCri2().equals(other.getCri2()))
            && (this.getWarm2() == null ? other.getWarm2() == null : this.getWarm2().equals(other.getWarm2()))
            && (this.getBri2() == null ? other.getBri2() == null : this.getBri2().equals(other.getBri2()))
            && (this.getOn2() == null ? other.getOn2() == null : this.getOn2().equals(other.getOn2()))
            && (this.getDynamic() == null ? other.getDynamic() == null : this.getDynamic().equals(other.getDynamic()))
            && (this.getOrderIndex() == null ? other.getOrderIndex() == null : this.getOrderIndex().equals(other.getOrderIndex()))
            && (this.getReserve1() == null ? other.getReserve1() == null : this.getReserve1().equals(other.getReserve1()))
            && (this.getCreationTime() == null ? other.getCreationTime() == null : this.getCreationTime().equals(other.getCreationTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getSceneid() == null) ? 0 : getSceneid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMac() == null) ? 0 : getMac().hashCode());
        result = prime * result + ((getDnlm() == null) ? 0 : getDnlm().hashCode());
        result = prime * result + ((getMode1() == null) ? 0 : getMode1().hashCode());
        result = prime * result + ((getR1() == null) ? 0 : getR1().hashCode());
        result = prime * result + ((getG1() == null) ? 0 : getG1().hashCode());
        result = prime * result + ((getB1() == null) ? 0 : getB1().hashCode());
        result = prime * result + ((getH1() == null) ? 0 : getH1().hashCode());
        result = prime * result + ((getS1() == null) ? 0 : getS1().hashCode());
        result = prime * result + ((getW1() == null) ? 0 : getW1().hashCode());
        result = prime * result + ((getC1() == null) ? 0 : getC1().hashCode());
        result = prime * result + ((getCri1() == null) ? 0 : getCri1().hashCode());
        result = prime * result + ((getWarm1() == null) ? 0 : getWarm1().hashCode());
        result = prime * result + ((getBri1() == null) ? 0 : getBri1().hashCode());
        result = prime * result + ((getOn1() == null) ? 0 : getOn1().hashCode());
        result = prime * result + ((getMode2() == null) ? 0 : getMode2().hashCode());
        result = prime * result + ((getR2() == null) ? 0 : getR2().hashCode());
        result = prime * result + ((getG2() == null) ? 0 : getG2().hashCode());
        result = prime * result + ((getB2() == null) ? 0 : getB2().hashCode());
        result = prime * result + ((getH2() == null) ? 0 : getH2().hashCode());
        result = prime * result + ((getS2() == null) ? 0 : getS2().hashCode());
        result = prime * result + ((getW2() == null) ? 0 : getW2().hashCode());
        result = prime * result + ((getC2() == null) ? 0 : getC2().hashCode());
        result = prime * result + ((getCri2() == null) ? 0 : getCri2().hashCode());
        result = prime * result + ((getWarm2() == null) ? 0 : getWarm2().hashCode());
        result = prime * result + ((getBri2() == null) ? 0 : getBri2().hashCode());
        result = prime * result + ((getOn2() == null) ? 0 : getOn2().hashCode());
        result = prime * result + ((getDynamic() == null) ? 0 : getDynamic().hashCode());
        result = prime * result + ((getOrderIndex() == null) ? 0 : getOrderIndex().hashCode());
        result = prime * result + ((getReserve1() == null) ? 0 : getReserve1().hashCode());
        result = prime * result + ((getCreationTime() == null) ? 0 : getCreationTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", sceneid=").append(sceneid);
        sb.append(", type=").append(type);
        sb.append(", mac=").append(mac);
        sb.append(", dnlm=").append(dnlm);
        sb.append(", mode1=").append(mode1);
        sb.append(", r1=").append(r1);
        sb.append(", g1=").append(g1);
        sb.append(", b1=").append(b1);
        sb.append(", h1=").append(h1);
        sb.append(", s1=").append(s1);
        sb.append(", w1=").append(w1);
        sb.append(", c1=").append(c1);
        sb.append(", cri1=").append(cri1);
        sb.append(", warm1=").append(warm1);
        sb.append(", bri1=").append(bri1);
        sb.append(", on1=").append(on1);
        sb.append(", mode2=").append(mode2);
        sb.append(", r2=").append(r2);
        sb.append(", g2=").append(g2);
        sb.append(", b2=").append(b2);
        sb.append(", h2=").append(h2);
        sb.append(", s2=").append(s2);
        sb.append(", w2=").append(w2);
        sb.append(", c2=").append(c2);
        sb.append(", cri2=").append(cri2);
        sb.append(", warm2=").append(warm2);
        sb.append(", bri2=").append(bri2);
        sb.append(", on2=").append(on2);
        sb.append(", dynamic=").append(dynamic);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", creationTime=").append(creationTime);
        sb.append("]");
        return sb.toString();
    }
}