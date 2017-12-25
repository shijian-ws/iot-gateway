package org.sj.iot.gateway.data.model;

public class Scenes {
    private Integer id;

    private Integer sceneid;

    private String name;

    private Integer type;

    private Integer active;

    private Integer defscene;

    private Integer hidden;

    private Integer icontype;

    private String iconurl;

    private Integer orderIndex;

    private String userdata;

    private String scenecmds;

    private Integer dynamic;

    private String zsceneids;

    private Integer defaultbri;

    private Integer offsetbri;

    private Integer reserve1;

    private Integer reserve2;

    private Integer creationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSceneid() {
        return sceneid;
    }

    public void setSceneid(Integer sceneid) {
        this.sceneid = sceneid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getDefscene() {
        return defscene;
    }

    public void setDefscene(Integer defscene) {
        this.defscene = defscene;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Integer getIcontype() {
        return icontype;
    }

    public void setIcontype(Integer icontype) {
        this.icontype = icontype;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getUserdata() {
        return userdata;
    }

    public void setUserdata(String userdata) {
        this.userdata = userdata;
    }

    public String getScenecmds() {
        return scenecmds;
    }

    public void setScenecmds(String scenecmds) {
        this.scenecmds = scenecmds;
    }

    public Integer getDynamic() {
        return dynamic;
    }

    public void setDynamic(Integer dynamic) {
        this.dynamic = dynamic;
    }

    public String getZsceneids() {
        return zsceneids;
    }

    public void setZsceneids(String zsceneids) {
        this.zsceneids = zsceneids;
    }

    public Integer getDefaultbri() {
        return defaultbri;
    }

    public void setDefaultbri(Integer defaultbri) {
        this.defaultbri = defaultbri;
    }

    public Integer getOffsetbri() {
        return offsetbri;
    }

    public void setOffsetbri(Integer offsetbri) {
        this.offsetbri = offsetbri;
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
        Scenes other = (Scenes) that;
        return this.getId() == null ? other.getId() == null : this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSceneid() == null) ? 0 : getSceneid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getActive() == null) ? 0 : getActive().hashCode());
        result = prime * result + ((getDefscene() == null) ? 0 : getDefscene().hashCode());
        result = prime * result + ((getHidden() == null) ? 0 : getHidden().hashCode());
        result = prime * result + ((getIcontype() == null) ? 0 : getIcontype().hashCode());
        result = prime * result + ((getIconurl() == null) ? 0 : getIconurl().hashCode());
        result = prime * result + ((getOrderIndex() == null) ? 0 : getOrderIndex().hashCode());
        result = prime * result + ((getUserdata() == null) ? 0 : getUserdata().hashCode());
        result = prime * result + ((getScenecmds() == null) ? 0 : getScenecmds().hashCode());
        result = prime * result + ((getDynamic() == null) ? 0 : getDynamic().hashCode());
        result = prime * result + ((getZsceneids() == null) ? 0 : getZsceneids().hashCode());
        result = prime * result + ((getDefaultbri() == null) ? 0 : getDefaultbri().hashCode());
        result = prime * result + ((getOffsetbri() == null) ? 0 : getOffsetbri().hashCode());
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
        sb.append(", sceneid=").append(sceneid);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", active=").append(active);
        sb.append(", defscene=").append(defscene);
        sb.append(", hidden=").append(hidden);
        sb.append(", icontype=").append(icontype);
        sb.append(", iconurl=").append(iconurl);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", userdata=").append(userdata);
        sb.append(", scenecmds=").append(scenecmds);
        sb.append(", dynamic=").append(dynamic);
        sb.append(", zsceneids=").append(zsceneids);
        sb.append(", defaultbri=").append(defaultbri);
        sb.append(", offsetbri=").append(offsetbri);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", creationTime=").append(creationTime);
        sb.append("]");
        return sb.toString();
    }
}