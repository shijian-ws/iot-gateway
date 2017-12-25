package org.sj.iot.gateway.data.model;

public class GroupDevices {
    private Integer id;

    private String mac;

    private Integer dnlm;

    private Integer groupid;

    private Integer type;

    private Integer orderIndex;

    private Integer reserve1;

    private Integer creationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        GroupDevices other = (GroupDevices) that;
        return (this.getMac() == null ? other.getMac() == null : this.getMac().equals(other.getMac()))
                && (this.getGroupid() == null ? other.getGroupid() == null : this.getGroupid().equals(other.getGroupid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMac() == null) ? 0 : getMac().hashCode());
        result = prime * result + ((getDnlm() == null) ? 0 : getDnlm().hashCode());
        result = prime * result + ((getGroupid() == null) ? 0 : getGroupid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", mac=").append(mac);
        sb.append(", dnlm=").append(dnlm);
        sb.append(", groupid=").append(groupid);
        sb.append(", type=").append(type);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", creationTime=").append(creationTime);
        sb.append("]");
        return sb.toString();
    }
}