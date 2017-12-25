package org.sj.iot.gateway.data.model;

import org.sj.iot.model.DataBody;

public class Gatewayinfo extends DataBody.GatewayInfo {
    private Integer uuid;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", uuid=").append(uuid);
        sb.append(", ").append(super.toString());
        sb.append("]");
        return sb.toString();
    }
}