-- 网关信息
CREATE TABLE IF NOT EXISTS gatewayinfo(
    uuid integer primary key autoincrement,
    manufacturer text,
    name text,
    mac text,
    type integer,
    init integer,
    mode integer,
    swversion text,
    hwversion text,
    channel integer,
    netid integer,
    power integer,
    userid integer,
    rawuserid integer,
    lightcount integer,
    radioon integer,
    wifimode integer,
    wifissid text,
    wifipwd text,
    connssid text,
    connpwd text,
    autoupdate integer,
    autobackup integer,
    wgkgilighton integer,
    wgkgilightsync integer,
    geekmode integer,
    geekkey text,
    remoteenable integer,
    serverip text,
    serverport integer,
    mapwidth integer,
    mapheight integer,
    userdata text,
    serverconnected integer,
    reserve1 integer,
    reserve2 integer,
    reserve3 integer
);

-- 账号
CREATE TABLE IF NOT EXISTS accounts(
    id integer primary key autoincrement,
    userid text,
    username text,
    userheadpic text,
    gpassword text
);

-- 分组
CREATE TABLE IF NOT EXISTS groups(
    id integer primary key autoincrement,
    groupid integer,
    zgroupid integer,
    name text,
    parentid integer,
    type integer,
    hidden integer,
    order_index integer,
    roomtype text,
    on1 integer,
    on2 integer,
    reserve1 integer,
    reserve2 integer,
    creation_time integer
);

--情景
CREATE TABLE IF NOT EXISTS scenes(
    id integer primary key autoincrement,
    sceneid integer,
    name text,
    type integer,
    active integer,
    defscene integer,
    hidden integer,
    icontype integer,
    iconurl text,
    order_index integer,
    userdata text,
    scenecmds text,
    dynamic integer,
    zsceneids text,
    defaultbri integer,
    offsetbri integer,
    reserve1 integer,
    reserve2 integer,
    creation_time integer
);

-- 分组下情景排序
CREATE TABLE IF NOT EXISTS group_scene_orders(
    id integer primary key autoincrement,
    groupid integer,
    sceneid integer,
    order_index integer,
    reserve1 integer
);

-- 灯设备
CREATE TABLE IF NOT EXISTS lights(
    uuid integer primary key autoincrement,
    net_addr integer,
    mac text,
    dnlm integer,
    major_type integer,
    minor_type integer,
    versw integer,
    verhw integer,
    fun_code integer,
    reserveXX integer,
    m_light_des integer,
    s_light_des integer,
    m_color_mode integer,
    s_color_mode integer,
    name text,
    lightsnum integer,
    pixels integer,
    mode1 integer,
    r1 integer,
    g1 integer,
    b1 integer,
    h1 integer,
    s1 integer,
    w1 integer,
    c1 integer,
    cri1 integer,
    warm1 integer,
    bri1 integer,
    on1 integer,
    mode2 integer,
    r2 integer,
    g2 integer,
    b2 integer,
    h2 integer,
    s2 integer,
    w2 integer,
    c2 integer,
    cri2 integer,
    warm2 integer,
    bri2 integer,
    on2 integer,
    online integer,
    locx integer,
    locy integer,
    dynamic integer,
    newdevice integer,
    reserve1 integer,
    reserve2 integer,
    reserve3 integer,
    creation_time integer
);

-- 分组下的设备
CREATE TABLE IF NOT EXISTS group_devices(
    id integer primary key autoincrement,
    mac text,
    dnlm integer,
    groupid integer,
    type integer,
    order_index integer,
    reserve1 integer,
    creation_time integer
);

-- 情景下的灯设备
CREATE TABLE IF NOT EXISTS scene_lights(
    uuid integer primary key autoincrement,
    sceneid integer,
    type integer,
    mac text,
    dnlm integer,
    mode1 integer,
    r1 integer,
    g1 integer,
    b1 integer,
    h1 integer,
    s1 integer,
    w1 integer,
    c1 integer,
    cri1 integer,
    warm1 integer,
    bri1 integer,
    on1 integer,
    mode2 integer,
    r2 integer,
    g2 integer,
    b2 integer,
    h2 integer,
    s2 integer,
    w2 integer,
    c2 integer,
    cri2 integer,
    warm2 integer,
    bri2 integer,
    on2 integer,
    dynamic integer,
    order_index integer,
    reserve1 integer,
    creation_time integer
);

-- 开关设备
CREATE TABLE IF NOT EXISTS switchs(
    uuid integer primary key autoincrement,
    net_addr integer,
    mac text,
    dnlm integer,
    major_type integer,
    minor_type integer,
    versw integer,
    verhw integer,
    fun_code integer,
    reserveXX integer,
    fun_des integer,
    control integer,
    knob_des integer,
    key_list integer,
    key_scenes integer,
    power integer,
    name text,
    newdevice integer,
    online integer,
    mode integer,
    pmac text,
    reserve1 integer,
    reserve2 integer,
    creation_time integer
);

-- 开关设备按键
CREATE TABLE IF NOT EXISTS switch_keys(
    uuid integer primary key autoincrement,
    mac text,
    key integer,
    knob integer,
    func integer,
    step integer,
    funcmode integer,
    sceneid integer,
    lumin integer,
    lights text,
    cmds text,
    reserve1 integer,
    reserve2 integer,
    creation_time integer
);


