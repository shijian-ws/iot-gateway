void setup() {
  Serial.begin(9600);
  pinMode(3, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(9, OUTPUT);
}
boolean flag=false; // 是否读取串口数据标记
String buf="";
void loop() {
  while(Serial.available()>0){
    delay(10);
    if(!flag){flag=true;}
    buf+=char(Serial.read());
  }
  // 未读取串口数据 结束
  if(!flag){return;}
  // 已读取
  if(buf.equals("ssdp") || buf.startsWith("ssdp\n")){
    // 处理ssdp发现服务
    Serial.print("ssdp\n0\n");
  }else if(buf.startsWith("color\n")){
    // 处理RGB颜色
    String rgb = buf.substring(6);
    rgb.toUpperCase();
    int r = hex2Int(rgb.charAt(0))<<4|hex2Int(rgb.charAt(1));
    int g = hex2Int(rgb.charAt(2))<<4|hex2Int(rgb.charAt(3));
    int b = hex2Int(rgb.charAt(4))<<4|hex2Int(rgb.charAt(5));
    analogWrite(3, r);
    analogWrite(6, g);
    analogWrite(9, b);
    Serial.print("color\n0\n");
    Serial.print(rgb);
    Serial.print('\n');
  }else if(buf.startsWith("oper\n")){
    // 处理打开关闭
    char oper = buf.charAt(5);
    int num = 0;
    if(oper=='1'){
      num = 128;
    }
    analogWrite(3, num);
    analogWrite(6, num);
    analogWrite(9, num);
    Serial.print("oper\n0\n");
    Serial.print(num);
    Serial.print('\n');
  }else{
    // 暂不支持命令
    int pos=buf.indexOf('\n');
    String name;
    if(pos==-1){
      name=buf;
    }else{
      name=buf.substring(0, pos);
    }
    Serial.print((name+"\n-1\n"));
  }
  Serial.flush();
  buf="";
  flag=false;
  delay(100);
}

// 16进制转10进制
int hex2Int(char c){
  int i=c-'0';
  if(i<1){
    return 0;
  }else if(i<10){
    return i;
  }
  i=c-'A';
  if(i>6){
    return 16;
  }
  return i+10;
}

