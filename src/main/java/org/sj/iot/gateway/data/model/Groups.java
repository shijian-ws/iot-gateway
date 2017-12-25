package org.sj.iot.gateway.data.model;

public class Groups {
    private Integer id;

    private Integer groupid;

    private Integer zgroupid;

    private String name;

    private Integer parentid;

    private Integer type;

    private Integer hidden;

    private Integer orderIndex;

    private Integer on1;

    private Integer on2;

    private Integer reserve1;

    private Integer reserve2;

    private Integer creationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getZgroupid() {
        return zgroupid;
    }

    public void setZgroupid(Integer zgroupid) {
        this.zgroupid = zgroupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getOn1() {
        return on1;
    }

    public void setOn1(Integer on1) {
        this.on1 = on1;
    }

    public Integer getOn2() {
        return on2;
    }

    public void setOn2(Integer on2) {
        this.on2 = on2;
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
        Groups other = (Groups) that;
        return this.getId() == null ? other.getId() == null : this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupid() == null) ? 0 : getGroupid().hashCode());
        result = prime * result + ((getZgroupid() == null) ? 0 : getZgroupid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getHidden() == null) ? 0 : getHidden().hashCode());
        result = prime * result + ((getOrderIndex() == null) ? 0 : getOrderIndex().hashCode());
        result = prime * result + ((getOn1() == null) ? 0 : getOn1().hashCode());
        result = prime * result + ((getOn2() == null) ? 0 : getOn2().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", groupid=").append(groupid);
        sb.append(", zgroupid=").append(zgroupid);
        sb.append(", name=").append(name);
        sb.append(", parentid=").append(parentid);
        sb.append(", type=").append(type);
        sb.append(", hidden=").append(hidden);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", on1=").append(on1);
        sb.append(", on2=").append(on2);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", creationTime=").append(creationTime);
        sb.append("]");
        return sb.toString();
    }
}