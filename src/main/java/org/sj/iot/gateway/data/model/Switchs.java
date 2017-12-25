package org.sj.iot.gateway.data.model;

public class Switchs {
    private Integer uuid;

    private Integer netAddr;

    private String mac;

    private Integer dnlm;

    private Integer majorType;

    private Integer minorType;

    private Integer versw;

    private Integer verhw;

    private Integer funCode;

    private Integer reservexx;

    private Integer funDes;

    private Integer control;

    private Integer knobDes;

    private Integer keyList;

    private Integer keyScenes;

    private Integer power;

    private String name;

    private Integer newdevice;

    private Integer online;

    private Integer mode;

    private String pmac;

    private Integer reserve1;

    private Integer reserve2;

    private Integer creationTime;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getNetAddr() {
        return netAddr;
    }

    public void setNetAddr(Integer netAddr) {
        this.netAddr = netAddr;
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

    public Integer getMajorType() {
        return majorType;
    }

    public void setMajorType(Integer majorType) {
        this.majorType = majorType;
    }

    public Integer getMinorType() {
        return minorType;
    }

    public void setMinorType(Integer minorType) {
        this.minorType = minorType;
    }

    public Integer getVersw() {
        return versw;
    }

    public void setVersw(Integer versw) {
        this.versw = versw;
    }

    public Integer getVerhw() {
        return verhw;
    }

    public void setVerhw(Integer verhw) {
        this.verhw = verhw;
    }

    public Integer getFunCode() {
        return funCode;
    }

    public void setFunCode(Integer funCode) {
        this.funCode = funCode;
    }

    public Integer getReservexx() {
        return reservexx;
    }

    public void setReservexx(Integer reservexx) {
        this.reservexx = reservexx;
    }

    public Integer getFunDes() {
        return funDes;
    }

    public void setFunDes(Integer funDes) {
        this.funDes = funDes;
    }

    public Integer getControl() {
        return control;
    }

    public void setControl(Integer control) {
        this.control = control;
    }

    public Integer getKnobDes() {
        return knobDes;
    }

    public void setKnobDes(Integer knobDes) {
        this.knobDes = knobDes;
    }

    public Integer getKeyList() {
        return keyList;
    }

    public void setKeyList(Integer keyList) {
        this.keyList = keyList;
    }

    public Integer getKeyScenes() {
        return keyScenes;
    }

    public void setKeyScenes(Integer keyScenes) {
        this.keyScenes = keyScenes;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNewdevice() {
        return newdevice;
    }

    public void setNewdevice(Integer newdevice) {
        this.newdevice = newdevice;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public String getPmac() {
        return pmac;
    }

    public void setPmac(String pmac) {
        this.pmac = pmac;
    }

    public Integer getReserve1() {
        return reserve1;
    }

    public void setReserve1(Integer reserve1) {
        this.reserve1 = reserve1;
    }

    public Integer getReserve2() {
        return reserve2;
    }

    public void setReserve2(Integer reserve2) {
        this.reserve2 = reserve2;
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
        Switchs other = (Switchs) that;
        return this.getMac() == null ? other.getMac() == null : this.getMac().equals(other.getMac());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getNetAddr() == null) ? 0 : getNetAddr().hashCode());
        result = prime * result + ((getMac() == null) ? 0 : getMac().hashCode());
        result = prime * result + ((getDnlm() == null) ? 0 : getDnlm().hashCode());
        result = prime * result + ((getMajorType() == null) ? 0 : getMajorType().hashCode());
        result = prime * result + ((getMinorType() == null) ? 0 : getMinorType().hashCode());
        result = prime * result + ((getVersw() == null) ? 0 : getVersw().hashCode());
        result = prime * result + ((getVerhw() == null) ? 0 : getVerhw().hashCode());
        result = prime * result + ((getFunCode() == null) ? 0 : getFunCode().hashCode());
        result = prime * result + ((getReservexx() == null) ? 0 : getReservexx().hashCode());
        result = prime * result + ((getFunDes() == null) ? 0 : getFunDes().hashCode());
        result = prime * result + ((getControl() == null) ? 0 : getControl().hashCode());
        result = prime * result + ((getKnobDes() == null) ? 0 : getKnobDes().hashCode());
        result = prime * result + ((getKeyList() == null) ? 0 : getKeyList().hashCode());
        result = prime * result + ((getKeyScenes() == null) ? 0 : getKeyScenes().hashCode());
        result = prime * result + ((getPower() == null) ? 0 : getPower().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNewdevice() == null) ? 0 : getNewdevice().hashCode());
        result = prime * result + ((getOnline() == null) ? 0 : getOnline().hashCode());
        result = prime * result + ((getMode() == null) ? 0 : getMode().hashCode());
        result = prime * result + ((getPmac() == null) ? 0 : getPmac().hashCode());
        result = prime * result + ((getReserve1() == null) ? 0 : getReserve1().hashCode());
        result = prime * result + ((getReserve2() == null) ? 0 : getReserve2().hashCode());
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
        sb.append(", netAddr=").append(netAddr);
        sb.append(", mac=").append(mac);
        sb.append(", dnlm=").append(dnlm);
        sb.append(", majorType=").append(majorType);
        sb.append(", minorType=").append(minorType);
        sb.append(", versw=").append(versw);
        sb.append(", verhw=").append(verhw);
        sb.append(", funCode=").append(funCode);
        sb.append(", reservexx=").append(reservexx);
        sb.append(", funDes=").append(funDes);
        sb.append(", control=").append(control);
        sb.append(", knobDes=").append(knobDes);
        sb.append(", keyList=").append(keyList);
        sb.append(", keyScenes=").append(keyScenes);
        sb.append(", power=").append(power);
        sb.append(", name=").append(name);
        sb.append(", newdevice=").append(newdevice);
        sb.append(", online=").append(online);
        sb.append(", mode=").append(mode);
        sb.append(", pmac=").append(pmac);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", creationTime=").append(creationTime);
        sb.append("]");
        return sb.toString();
    }
}