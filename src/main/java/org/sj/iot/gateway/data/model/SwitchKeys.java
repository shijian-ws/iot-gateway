package org.sj.iot.gateway.data.model;

public class SwitchKeys {
    private Integer uuid;
    private String mac;
    private Integer key;
    private Integer knob;
    private Integer func;
    private Integer step;
    private Integer funcmode;
    private Integer sceneid;
    private Integer lumin;
    private String lights;
    private String cmds;
    private Integer reserve1;
    private Integer reserve2;
    private Integer creationTime;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getKnob() {
        return knob;
    }

    public void setKnob(Integer knob) {
        this.knob = knob;
    }

    public Integer getFunc() {
        return func;
    }

    public void setFunc(Integer func) {
        this.func = func;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getFuncmode() {
        return funcmode;
    }

    public void setFuncmode(Integer funcmode) {
        this.funcmode = funcmode;
    }

    public Integer getSceneid() {
        return sceneid;
    }

    public void setSceneid(Integer sceneid) {
        this.sceneid = sceneid;
    }

    public Integer getLumin() {
        return lumin;
    }

    public void setLumin(Integer lumin) {
        this.lumin = lumin;
    }

    public String getLights() {
        return lights;
    }

    public void setLights(String lights) {
        this.lights = lights;
    }

    public String getCmds() {
        return cmds;
    }

    public void setCmds(String cmds) {
        this.cmds = cmds;
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
        SwitchKeys other = (SwitchKeys) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid())) && (this.getMac() == null ? other.getMac() == null : this.getMac().equals(other.getMac())) && (this.getKey() == null ? other.getKey() == null : this.getKey().equals(other.getKey())) && (this.getKnob() == null ? other.getKnob() == null : this.getKnob().equals(other.getKnob())) && (this.getFunc() == null ? other.getFunc() == null : this.getFunc().equals(other.getFunc())) && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep())) && (this.getFuncmode() == null ? other.getFuncmode() == null : this.getFuncmode().equals(other.getFuncmode())) && (this.getSceneid() == null ? other.getSceneid() == null : this.getSceneid().equals(other.getSceneid())) && (this.getLumin() == null ? other.getLumin() == null : this.getLumin().equals(other.getLumin())) && (this.getLights() == null ? other.getLights() == null : this.getLights().equals(other.getLights())) && (this.getCmds() == null ? other.getCmds() == null : this.getCmds().equals(other.getCmds())) && (this.getReserve1() == null ? other.getReserve1() == null : this.getReserve1().equals(other.getReserve1())) && (this.getReserve2() == null ? other.getReserve2() == null : this.getReserve2().equals(other.getReserve2())) && (this.getCreationTime() == null ? other.getCreationTime() == null : this.getCreationTime().equals(other.getCreationTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getMac() == null) ? 0 : getMac().hashCode());
        result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
        result = prime * result + ((getKnob() == null) ? 0 : getKnob().hashCode());
        result = prime * result + ((getFunc() == null) ? 0 : getFunc().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getFuncmode() == null) ? 0 : getFuncmode().hashCode());
        result = prime * result + ((getSceneid() == null) ? 0 : getSceneid().hashCode());
        result = prime * result + ((getLumin() == null) ? 0 : getLumin().hashCode());
        result = prime * result + ((getLights() == null) ? 0 : getLights().hashCode());
        result = prime * result + ((getCmds() == null) ? 0 : getCmds().hashCode());
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
        sb.append(", mac=").append(mac);
        sb.append(", key=").append(key);
        sb.append(", knob=").append(knob);
        sb.append(", func=").append(func);
        sb.append(", step=").append(step);
        sb.append(", funcmode=").append(funcmode);
        sb.append(", sceneid=").append(sceneid);
        sb.append(", lumin=").append(lumin);
        sb.append(", lights=").append(lights);
        sb.append(", cmds=").append(cmds);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", creationTime=").append(creationTime);
        sb.append("]");
        return sb.toString();
    }
}