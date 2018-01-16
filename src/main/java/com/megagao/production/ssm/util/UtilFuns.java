package com.megagao.production.ssm.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


/** UtilFuns is a JavaBean.  */
 public class UtilFuns {


  static public String newLine(){
  	return System.getProperty("line.separator"); 
  }
  

	/* 验证数组是否为空 */
	public static boolean arrayValid(Object[] objects) {
		if (objects != null && objects.length > 0) {
			return true;
		} else {
			return false;
		}
	}

	/* 验证list是否为空 */
	public boolean listValid(List list) {
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
  

  //获得年龄
  public int age(String dateStart, String dateEnd) throws Exception{
	  int yearStart = Integer.parseInt(dateStart.substring(0,4));
	  int yearEnd = Integer.parseInt(dateEnd.substring(0,4));
	  return yearEnd-yearStart;
  }
  
  //是否为奇数
  public boolean isOdd(int i){
	  if(i%2==0){
		  return false;
	  }else{
		  return true;
	  }
  }

  public String cutStr(String str,int len){
  	try{
  		str = str.substring(0,len);
  	}catch(Exception e){
  		return str;
  	}
  	return str;
  }
  
  //返回固定长度串，空白地方用空格填充 by tony 20110926
  public String fixSpaceStr(String str,int len){
	  StringBuffer sBuf = new StringBuffer();
	  try{
		  if(str.length()>len){
			  return str;
		  }else{
			  sBuf.append(str);
			  for(int i=0;i<(len-str.length());i++){
				  sBuf.append(" ");
			  }
			  return sBuf.toString();
		  }
	  }catch(Exception e){
		  return str;
	  }
  }
  
  public String fixSpaceStr(int number,int len){
	  return fixSpaceStr(String.valueOf(number),len);
  }
  
  //前缀空格
  public String prefixSpaceStr(String str,int len){
	  StringBuffer sBuf = new StringBuffer();
	  try{
		  if(str.length()>len){
			  return str;
		  }else{
			  for(int i=0;i<(len-str.length());i++){
				  sBuf.append(" ");
			  }
			  sBuf.append(str);
			  return sBuf.toString();
		  }
	  }catch(Exception e){
		  return str;
	  }
  }
  
  //截取字符,如果超过长度,截取并加省略号 by tony 20101108
  public String suspensionStr(String str,int len){
	  try{
		  str = str.substring(0,len) + "...";
	  }catch(Exception e){
		  return str;
	  }
	  return str;
  }

  //url get方式传递参数 by tony 20110328
  public static String joinUrlParameter(List<String> sList){
	  StringBuffer sBuf = new StringBuffer();
	  for(Iterator it = sList.iterator(); it.hasNext();){
		  sBuf.append("&").append(it.next()).append("=").append(it.next());
	  }
	  return sBuf.substring(1, sBuf.length());	//去掉第一个&符号
  }
  
  /** SplitStr 功能：返回分割后的数组
   * <br>输入参数：String str 设置返回系统时间样式
   * <br>输入参数：String SplitFlag 设置分割字符
   * <br>输出参数：string[] 返回分割后的数组
   * <br>作者：陈子枢
   * <br>时间：2003-9-7
   * <br>用法：
   */
/*
      String s[] = SplitStr("asd asd we sd"," ");
      for (int i=0;i<s.length;i++){
        System.out.println(s[i]);
      }
*/
  static public String[] splitStr(String str,String SplitFlag){
    int i =0;
    try{
      StringTokenizer st = new StringTokenizer(str, SplitFlag);
      String tokens[] = new String[st.countTokens()];
      //System.out.println(st.countTokens());
      while (st.hasMoreElements()) {
        tokens[i] = st.nextToken();
        //System.out.println(tokens[i]);
        i++;
      }
      return tokens;
    }catch(Exception e){
      return null;
    }
  }
  
  //类似google那样实现多个关键字的查询，关键字之间用空格或逗号隔开 by tony 20110523
  //支持的分隔符 英文逗号,中文逗号,空格
  public String[] splitFindStr(String str){
	if(str==null){
		return null;
	}
	String[] aStr = null;
	str = str.replaceAll(",", " ");		//英文逗号
	str = str.replaceAll("，", " ");		//中文逗号
	aStr = this.splitStr(str, " ");		//空格  
	return aStr;
 }
 
  /* 阶梯函数,例如，a,b,c 返回 a;a,b;a,b,c by tony 20110330 */
  static public String[] splitStair(String str,String SplitFlag){
	  try{
		  String[] _temp = splitStr(str, SplitFlag);
		  for(int i=1;i<_temp.length;i++){
			  _temp[i] = _temp[i-1]+SplitFlag+_temp[i];
		  }
		  return _temp;
	  }catch(Exception e){
		  return null;
	  }
  }

  /** SplitStr 功能：将数组合并为一个字符串
   * <br>输入参数：String aStr 要合并数组
   * <br>输入参数：String SplitFlag 设置分割字符
   * <br>输出参数：String 要合并数组
   * <br>作者：陈子枢
   * <br>时间：2004-1-9
   * <br>用法：
   */


  static public String joinStr(String[] aStr,String SplitFlag){
    StringBuffer sBuffer = new StringBuffer();
    if (aStr != null){
      for (int i=0;i<aStr.length;i++){
        sBuffer.append(aStr[i]).append(SplitFlag);
      }
      sBuffer.delete(sBuffer.length() - 1, sBuffer.length()); //去掉最后的分隔符 SplitFlag
    }else{
      sBuffer = sBuffer.append("");
    }
    return sBuffer.toString();
  }

  /* 链接,但中间无链接符号 add by tony 20100322 */
  static public String joinStr(String[] aStr){
    StringBuffer sBuffer = new StringBuffer();
    if (aStr != null){
      for (int i=0;i<aStr.length;i++){
        sBuffer.append(aStr[i]);
      }
    }else{
      sBuffer = sBuffer.append("");
    }
    return sBuffer.toString();
  }
  
  /** JoinStr 
   * <br>功能：将数组合并为一个字符串
   * <br>输入参数：String sPrefix 数组元素加的前缀
   * <br>输入参数：String sSuffix 数组元素加的后缀
   * <br>输入参数：String SplitFlag 设置分割字符
   * <br>输出参数：String 合并后的字符串
   * <br>作者：陈子枢
   * <br>时间：2005-3-17
   * <br>用法：
   */


  static public String joinStr(String[] aStr,String sPrefix,String sSuffix,String SplitFlag){
    StringBuffer sBuffer = new StringBuffer();
    if (aStr != null){
      for (int i=0;i<aStr.length;i++){
        sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix).append(SplitFlag);
      }
      sBuffer.delete(sBuffer.length() - SplitFlag.length(), sBuffer.length()); //去掉最后的分隔符 SplitFlag
    }else{
      sBuffer = sBuffer.append("");
    }
    return sBuffer.toString();
  }
  
  /* 返回用于in查询的串  'x','y' */
  static public String joinInStr(String[] aStr){
	  StringBuffer sBuffer = new StringBuffer();
	  if (aStr != null){
		  for (int i=0;i<aStr.length;i++){
			  sBuffer.append("'").append(aStr[i]).append("'").append(",");
		  }
		  sBuffer.delete(sBuffer.length() - 1, sBuffer.length());
	  }else{
		  sBuffer = sBuffer.append("");
	  }
	  return sBuffer.toString();
  }

  /* 链接,但中间无链接符号 add by tony 20100322 */
  static public String joinStr(String[] aStr,String sPrefix,String sSuffix){
    StringBuffer sBuffer = new StringBuffer();
    if (aStr != null){
      for (int i=0;i<aStr.length;i++){
        sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix);
      }
    }else{
      sBuffer = sBuffer.append("");
    }
    return sBuffer.toString();
  }

  /* 链接len(s)个symbol符号 add by tony 20100407 */
  static public String joinStr(String s, String symbol){
	  StringBuffer sBuf = new StringBuffer();
	  for (int i=0;i<s.length();i++){
		  sBuf.append(symbol);
      }
	  return sBuf.toString();
  }
  
  static public String joinStr(int len, String symbol){
	  StringBuffer sBuf = new StringBuffer();
	  for (int i=0;i<len;i++){
		  sBuf.append(symbol);
      }
	  return sBuf.toString();
  }  
  
  /** SysTime 功能：返回系统时间
 * <br>输入参数：int style 设置返回系统时间样式
 * <br>输出参数：string 返回系统时间样式
 * <br>作者：陈子枢
 * <br>时间：2003-6-24
 * <br>存在问题：中文乱码，但JSP中显示正常。
 */
  static public String SysTime(String strStyle){
    String s = "";
    if (strStyle.compareTo("")==0){
    	strStyle = "yyyy-MM-dd HH:mm:ss";	//default
    }
    java.util.Date date=new java.util.Date();
    SimpleDateFormat dformat=new SimpleDateFormat(strStyle);
    s = dformat.format(date);
    return s;
  }

  static public String sysTime(){
    String s = "";
    java.util.Date date=new java.util.Date();
    SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    s = dformat.format(date);
    return s;
  }

  static public String sysDate(){
    String s = "";
    java.util.Date date=new java.util.Date();
    SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
    s = dformat.format(date);
    return s;
  }


  /* add by tony 20091113 */
  public static boolean isNull(Object obj){
    try{
      if(obj==null){
    	  return true;
      }
      return false;
    }catch(Exception e){
      return false;
    }
  }
  
  public static boolean isNotNull(Object obj){
    try{
      if(obj==null){
    	  return false;
      }
      return true;
    }catch(Exception e){
      return true;
    }
  }  

  public static boolean isEmpty(String str){
    try{
      if(str==null || str.equals("null") || str.equals("")){
    	  return true;
      }
      return false;
    }catch(Exception e){
      return false;
    }
  }
  
  public static boolean isEmpty(String strs[]){
	  try{
		  if(strs==null || strs.length<=0){
			  return true;
		  }
		  return false;
	  }catch(Exception e){
		  return false;
	  }
  }

  public static boolean isNotEmpty(String str){
    try{
      if(str==null || str.equals("null") || str.equals("")){
    	  return false;
      }
      return true;
    }catch(Exception e){
      return true;
    }
  }

  public static boolean isNotEmpty(Object obj){
    try{
      if(obj==null || obj.toString().equals("null") || obj.toString().equals("")){
    	  return false;
      }
      return true;
    }catch(Exception e){
      return true;
    }
  }
  
  public static boolean isNotEmpty(List obj){
	  try{
		  if(obj==null || obj.size()<=0){
			  return false;
		  }
		  return true;
	  }catch(Exception e){
		  return true;
	  }
  }
  
  /** 功能：用于转换为null的字段。
   * <br>入参：String strvalue 设置要转换的字符串
   * <br>出参：不为“null”的返回原串；为“null”返回""。
   * <br>作者：陈子枢
   * <br>时间：2003-9-16
   * <p>用法：optionFuns.convertNull(String.valueOf(oi.next()))</p>
   */
  public static String convertNull(String strvalue)
  {
    try{
      if(strvalue.equals("null") || strvalue.length()==0){
        return "";
      }else{
        return strvalue.trim();
      }
    }catch(Exception e){
      return "";
    }
  }

  public static String[] convertNull(String[] aContent)
  {
    try{
      for(int i=0;i<aContent.length;i++){
        if(aContent[i].toLowerCase().compareTo("null")==0){
          aContent[i] = "";
        }
      }
      return aContent;
    }catch(Exception e){
      return null;
    }
  }
    
  public static String convertNull(Object o)
  {
    try{
      String strvalue = String.valueOf(o);
      if(strvalue.equals(null) || strvalue.equals("null") || strvalue.length()==0){
        return "";
      }else{
        return strvalue.trim();
      }
    }catch(Exception e){
      return "";
    }
  }
  
  //将为null的数据转为0，用在数值的值从数据库中读出的情况
  public static int ConvertZero(Object o)
  {
    try{
      String s = convertNull(o);
      if(s==""){
        return 0;
      }else{
        return Integer.parseInt(s);
      }
    }catch(Exception e){
      return 0;
    }
  }
  
  //将为null的数据转为0，用在数值的值从数据库中读出的情况
  public static int cvtPecrent(Object o)
  {
    try{
      String s = convertNull(o);
      if(s==""){
        return 0;
      }else{
        return Integer.parseInt(s);
      }
    }catch(Exception e){
      return 0;
    }
  }  
  
  //if 0 then return "";
  public static String FormatZero(Object o)
  {
    try{
      String s = convertNull(o);
      if(s.compareTo("")==0){
        return "";
      }else{
        return String.valueOf(s);
      }
    }catch(Exception e){
      return "";
    }
  }
  
  //if 0 then return "";
  public static String FormatZero(String s)
  {
    try{
      if(s.compareTo("0")==0){
        return "";
      }else{
        return s;
      }
    }catch(Exception e){
      return "";
    }
  }
  
  //patter="####.000"
  public static String FormatNumber(Object o,String patter)
  {
  	double d = 0;
    try {
      d = Double.parseDouble(String.valueOf(o));
      DecimalFormat df = new DecimalFormat(patter);
      return df.format(d);
    }
    catch (Exception e) {
    	System.out.println(e.getMessage());
       	return "";
    }
  }

  
  //patter="####.00"
  public static String FormatNumber(String s)
  {
  	double d = 0;
    try {
      d = Double.parseDouble(s);
      DecimalFormat df = new DecimalFormat(",###.00");
      return df.format(d);
    }
    catch (Exception e) {
    	System.out.println(e.getMessage());
    	return "";
    }
  }
  
  //只用在表格的输出
  public static String ConvertTD(String strvalue)
  {
    try{
      strvalue = strvalue.trim();
      if(strvalue.equals("null") || strvalue.length()==0){
        return "&nbsp;";
      }else{
        return strvalue;
      }
    }catch(Exception e){
      return "&nbsp;";
    }
  }

  public static String ConvertSpaceTD(Object o)
  {
    try{
      String strvalue = String.valueOf(o);
      strvalue = strvalue.trim();
      if(strvalue.equals("null") || strvalue.length()==0){
        return "&nbsp;";
      }else{
        return " " + strvalue.trim();
      }
    }catch(Exception e){
      return "&nbsp;";
    }
  }
  
  /*
    只转中文，不处理null
    读取记录时去掉数据两边的空格；而录入数据时，维持用户的输入，哪怕用户多输入了空格
    原因在于有时可能用户有意输入空格。例如：备注字段原来有内容，现在用户想清空。
  */
  public static String ConvertCH(String strvalue)
  {
    System.out.println("ConvertCH:"+strvalue);
    try{
      if(strvalue==null){
        return "null";
      }else if(strvalue.length()==0){
        return "";      
      }else{
        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GB2312");
        return strvalue;
      }
    }catch(Exception e){
      return "";
    }
  }
  
  public static String ConvertCStr(String strvalue)
  {
    try{
      strvalue = convertNull(strvalue);
      if(strvalue.equals("")){
        return "";
      }else{
        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GB2312");
        return strvalue;
      }
    }catch(Exception e){
      return "";
    }
  }

  public static String ConvertCStr(Object o)
  {
    String strvalue = "";
    try{
      strvalue = String.valueOf(o);
      strvalue = convertNull(strvalue);
      if(strvalue.equals("")){
        return "";
      }else{
        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GB2312");
        return strvalue;
      }
    }catch(Exception e){
      System.out.println("ConvertCStr:" + e.toString());
      return "";
    }
  }
  
  /**
   *UrlEncoder 进行URL编码
   */
    public String UrlEncoder(String s)
    {
        String s1 = "";
        if(s == null)
            return "";
        try
        {
            s1 = URLEncoder.encode(s);
        }
        catch(Exception e)
        {
            System.out.println("URL Encoder :" + e.toString());
            s1 = "";
        }
        return s1;
    }

  /**
   *URLDecoder 进行URL解码
   */
    public String UrlDecoder(String s)
    {
        String s1 = "";
        if(s == null)
            return "";
        try
        {
            s1 = URLDecoder.decode(s);
        }
        catch(Exception e)
        {
            System.out.println("URL Encoder :" + e.toString());
            s1 = "";
        }
        return s1;
    }
    
  /**
   * 将字符串转化成首字母大写，其余字母小写的格式
   * @param source 传入字符串
   * @return String
   */
  public static String format_Aaa(String source) {

    if (source==null) return null;
    if (source.equals("")) return "";

    String a;
    a = source.substring(0, 1);
    a = a.toUpperCase();
    return a + source.substring(1);

  }
  
  /**
   * 将字符串转换成Long型
   * @param param 传入字符串
   * @return 长整形
   */
  public static long parseLong(String param) {
    long l=0;
    try {
      l = Long.parseLong(param);
    }
    catch (Exception e) {
    }

    return l;
  }

  /**
   * 将字符串转换成Float型
   * @param param 传入字符串
   * @return 浮点型
   */
  public static float parseFloat(String param) {
    float l=0;
    try {
      l = Float.parseFloat(param);
    }
    catch (Exception e) {
    }

    return l;
  }

  /**
   * 将字符串转换成Integer型
   * @param param 传入字符串
   * @return 整形
   */
  public static int parseInt(String param) {
    int l=0;
    try {
      l = Integer.parseInt(param);
    }
    catch (Exception e) {
    }

    return l;
  }


	public static Date parseDate(String currDate, String format) {
	    SimpleDateFormat dtFormatdB = null;
	    try {
	        dtFormatdB = new SimpleDateFormat(format);
	        return dtFormatdB.parse(currDate);
	    }catch (Exception e){
	        dtFormatdB = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            return dtFormatdB.parse(currDate);
	        }catch (Exception ex){}
	    }
	    return null;
	}

	public static Date parseDate(String currDate) {
	    SimpleDateFormat dtFormatdB = null;
	    dtFormatdB = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        return dtFormatdB.parse(currDate);
	    }catch (Exception e){
	        try {
	            return dtFormatdB.parse(currDate);
	        }catch (Exception ex){}
	    }
	    return null;
	}
	
	public static Date parseTime(String currDate, String format) {
	    SimpleDateFormat dtFormatdB = null;
	    try {
	        dtFormatdB = new SimpleDateFormat(format);
	        return dtFormatdB.parse(currDate);
	    }catch (Exception e){
	        dtFormatdB = new SimpleDateFormat("HH:mm:ss");
	        try {
	            return dtFormatdB.parse(currDate);
	        }catch (Exception ex){}
	    }
	    return null;
	}

	public static Date parseDateTime(String currDate, String format) {
	    SimpleDateFormat dtFormatdB = null;
	    try {
	        dtFormatdB = new SimpleDateFormat(format);
	        return dtFormatdB.parse(currDate);
	    }catch (Exception e){
	        dtFormatdB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        try {
	            return dtFormatdB.parse(currDate);
	        }catch (Exception ex){}
	    }
	    return null;
	}
	
  /**
   * 将字符串转换成Double型
   * @param param 传入字符串
   * @return double型
   */
  public static double parseDouble(String param) {
    double l=0;
    try {
      l = Double.parseDouble(param);
    }
    catch (Exception e) {
    }

    return l;
  }

  /**
   * s是否存在ArrayList中，存在返回数组下标，不存在返回-1
   */
  public static int existElements(String s,ArrayList aList) {
    try{
      for (int i = 0; i < aList.size(); i ++) {
        if (s.equals(aList.get(i))){
          return i;
        }
      }
    }catch(Exception e){   }
    return -1;
  }

  /**
   * s是否存在String数组中，存在返回数组下标，不存在返回-1
   */
  public static int existElements(String s,String[] a) {
    try{
      for (int i = 0; i < a.length; i ++) {
        if (s.compareTo((a[i].trim()))==0){  
          return i;
        }
      }
    }catch(Exception e){   }
    return -1;
  }
  
  /**
   * 判断对象o是否存在于set对象集合中 create by tony 20090611
   */  
  public static boolean existElements(Object o, Set set) {
	  boolean isExists = false;
	  Iterator it = set.iterator();
	  while(it.hasNext())
	  {
	       Object obj = it.next();
	       if(o.equals(obj))
	       {
	    	   isExists=true;
	    	   break;
	       }
	  }
	  return isExists;
  }

  /**
   * s是否存在ArrayList中，存在返回数组下标，不存在返回-1
   */
  public static int IsIndexOfElements(String s,ArrayList aList) {
    try{
      String s1 = "";
      for (int i = 0; i < aList.size(); i ++) {
        s1 = String.valueOf(aList.get(i));
        if (s1.indexOf(s)!=-1){
          return i;
        }
      }
    }catch(Exception e){   }
    return -1;
  }
  
  /**
   * 将ArrayList转换为一维String数组，并把其中的null换成空字符串
   * @param aList 传入的Arraylist
   */
  public String[] ArrayListToString(ArrayList aList) {
    String[] s = new String[aList.size()];
    for (int i = 0; i < aList.size(); i ++) {
      s[i] = this.convertNull(aList.get(i));
    }
    return s;
  }
  
  
  /**
   * 将数组中的null换成空字符串
   * @param al 传入的Arraylist，同时也是输出结果
   */
  public static void formatArrayList(ArrayList al) {

    for (int i = 0; i < al.size(); i ++) {
      if (al.get(i) == null)
        al.set(i, "");
    }

  }

    /** ComboList 功能：选定在下拉列表框中与查找到数据,相符的那一项内容
     * <br>输入参数：String CurrentValue 查找出的数据库中的数据
     *               String[] content 需要输出的所有下拉列表框的内容
     * <br>输出参数：返回下拉列表
      * <br>注意事项：values为0开始,而且中间不能断开
     */
    public String ComboList(String CurrentValue, String[] content) {
      int i = 0;
      StringBuffer sBuf = new StringBuffer();
      String selected = " selected";
      try{
        sBuf.append("<option value='' selected>--请选择--</option>");
        for (i = 0; i < content.length; i++) {
          sBuf.append("\n<option value='").append(i).append("'");
          if (CurrentValue.compareTo(String.valueOf(i)) == 0) {
            sBuf.append(selected);
          }
          sBuf.append(">").append(content[i]).append("</option>");
        }
        return sBuf.toString();
      }catch(Exception e){
        return "";
      }
    }

    public String ComboListMust(String CurrentValue, String[] content) {
      int i = 0;
      StringBuffer sBuf = new StringBuffer();
      String selected = " selected";
      try{
        for (i = 0; i < content.length; i++) {
          sBuf.append("\n<option value='").append(i).append("'");
          if (CurrentValue.compareTo(String.valueOf(i)) == 0) {
            sBuf.append(selected);
          }
          sBuf.append(">").append(content[i]).append("</option>");
        }
        return sBuf.toString();
      }catch(Exception e){
        return "";
      }
    }
    
    /** ComboList 功能：选定在下拉列表框中与查找到数据,相符的那一项内容
     * <br>输入参数：String CurrentValue 查找出的数据库中的数据
     *               String[] values  需要输出的所有下拉列表框的内容所对应的值
     *               String[] content 需要输出的所有下拉列表框的内容
     * <br>输出参数：返回下拉列表
     * <br>修改：陈子枢
     * <br>修改时间：2003-9-4
     * <br>注意事项：values和content数组个数必须相同.适合从数据库中取值
	<%
	  String[] aContextOPERATE_TYPE = {"定检","轮换","抽检"};
	  out.print(optionFuns.ComboList("",aContextOPERATE_TYPE,aContextOPERATE_TYPE));
	%>
     */
    public String ComboList(String CurrentValue,String[] values, String[] content) {
      int i = 0;
      StringBuffer sBuf = new StringBuffer();
      String selected = " selected";

      try{
    	if(CurrentValue==null){
    		CurrentValue = "";
    	}
        sBuf.append("<option value='' selected>--请选择--</option>");
        for (i = 0; i < content.length; i++) {
          sBuf.append("<option value='").append(values[i]).append("'");
          if (CurrentValue.compareTo(values[i]) == 0) {
            sBuf.append(selected);
          }
          sBuf.append(">").append(content[i]).append("</option>");
        }
        return sBuf.toString();
      }catch(Exception e){
        return "";
      }
    }

    public String ComboListMust(String CurrentValue,String[] values, String[] content) {
      int i = 0;
      StringBuffer sBuf = new StringBuffer();
      String selected = " selected";

      try{
        for (i = 0; i < content.length; i++) {
          sBuf.append("<option value='").append(values[i]).append("'");
          if (CurrentValue.compareTo(values[i]) == 0) {
            sBuf.append(selected);
          }
          sBuf.append(">").append(content[i]).append("</option>");
        }
        return sBuf.toString();
      }catch(Exception e){
        return "";
      }
    } 
    
  /** StrToTimestamp 功能：将字符串转换为Timestamp 。
   * <br>输入参数：String timestampStr 设置要转换的字符串
   *              String pattern 要转换的format
   * <br>输出参数：如果格式正确返回格式后的字符串。
   *              不正确返回系统日期。
   * <br>作者：陈子枢
   * <br>时间：2003-8-26
   */
  public static Timestamp StrToTimestamp(String timestampStr,String pattern) throws ParseException {
    java.util.Date date = null;
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    try {
      date = format.parse(timestampStr);
    } catch (ParseException ex) {
      throw ex;
    }
    return date == null ? null : new Timestamp(date.getTime());
  }

  //ex:utilFuns.StrToDateTimeFormat("2005-12-01 00:00:00.0,"yyyy-MM-dd")
  public static String StrToDateTimeFormat(String timestampStr,String pattern) throws ParseException {
    String s ="";
    try{
      s = String.valueOf(StrToTimestamp(timestampStr, pattern));
      s = s.substring(0,pattern.length());
    }catch(Exception e){ }
    return s;
  }

  //ex:utilFuns.StrToDateTimeFormat("2005-12-01 00:00:00.0,"yyyy-MM-dd")
  public static String dateTimeFormat(Date date,String pattern) throws ParseException {
    String s ="";
    try{
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s = dformat.format(date);
        s = String.valueOf(StrToTimestamp(s, pattern));
        s = s.substring(0,pattern.length());
    }catch(Exception e){ }
    return s;
  }
  public static String dateTimeFormat(Date date) throws ParseException {
	  String s ="";
	  try{
		  SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
		  s = dformat.format(date);
		  s = String.valueOf(StrToTimestamp(s, "yyyy-MM-dd"));
		  s = s.substring(0,"yyyy-MM-dd".length());
	  }catch(Exception e){ }
	  return s;
  }
  
  //add by tony 20100228 转换中文 格式必须为："yyyy-MM-dd HH:mm:ss"的一部分
  public static String formatDateTimeCN(String date) throws ParseException {
	  String s ="";
	  try{
		  if(UtilFuns.isEmpty(date)){
			  return "";
		  }
		  if(date.indexOf(".")>-1){
			  date = date.substring(0, date.indexOf("."));
		  }
		  if(date.length()==4){			//yyyy
			  s = date+"年";
		  }else if(date.length()==7){	//yyyy-MM
			  s = date.replaceAll("-0", "-").replaceFirst("-", "年")+"月";
		  }else if(date.length()==10){	//yyyy-MM-dd
			  s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月")+"日";
		  }else if(date.length()==2){	//HH
			  s = date+"时";
		  }else if(date.length()==5){	//HH:mm
			  s = date.replaceAll(":0", ":").replaceFirst(":", "时")+"分";
		  }else if(date.length()==8){	//HH:mm:ss
			  s = date.replaceAll(":0", ":").replaceFirst(":", "时").replaceFirst(":", "分")+"秒";
		  }else if(date.length()==13){	//yyyy-MM-dd HH
			  s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月").replaceAll(" 0", " ").replaceFirst(" ", "日")+"时";
		  }else if(date.length()==16){	//yyyy-MM-dd HH:mm
			  s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月").replaceAll(" 0", " ").replaceFirst(" ", "日").replaceAll(":0", ":").replaceFirst(":", "时")+"分";
		  }else if(date.length()==19){	//yyyy-MM-dd HH:mm:ss
			  s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月").replaceAll(" 0", " ").replaceFirst(" ", "日").replaceAll(":0", ":").replaceFirst(":", "时").replaceFirst(":", "分")+"秒";
		  }
		  s = s.replaceAll("0[时分秒]", "");	//正则 0时0分0秒的都替换为空
	  }catch(Exception e){ }
	  
	  return s;
  }
  
  //add by tony 2011-07-26 返回英文格式日期 oct.10.2011
  public static String formatDateEN(String date) throws ParseException {
	  String s ="";
	  int whichMonth = 1;
	  try{
		  if(UtilFuns.isEmpty(date)){
			  return "";
		  }
		  String[] aString = date.replaceAll("-0", "-").split("-");
		  whichMonth = Integer.parseInt(aString[1]);
		  if(whichMonth==1){
			  s = "Jan";
		  }else if(whichMonth==2){
			  s = "Feb";
		  }else if(whichMonth==3){
			  s = "Mar";
		  }else if(whichMonth==4){
			  s = "Apr";
		  }else if(whichMonth==5){
			  s = "May";
		  }else if(whichMonth==6){
			  s = "Jun";
		  }else if(whichMonth==7){
			  s = "Jul";
		  }else if(whichMonth==8){
			  s = "Aug";
		  }else if(whichMonth==9){
			  s = "Sept";
		  }else if(whichMonth==10){
			  s = "Oct";
		  }else if(whichMonth==11){
			  s = "Nov";
		  }else if(whichMonth==12){
			  s = "Dec";
		  }
		  s = s+"."+aString[2]+","+aString[0];
		  
	  }catch(Exception e){ }
	  
	  return s;
  }

  //返回年月格式 2010-7
  public String formatShortMonth(String strDate){
	  return strDate.substring(0,7).replaceAll("-0", "-");
  }
  
  //返回年月格式 2010-07
  public String formatMonth(String strDate){
	  return strDate.substring(0,7);
  }
  
  
  
  //删除最后1个字符
  public static String delLastChar(String s){
    try{
      if(s.length()>0){
        s = s.substring(0,s.length()-1);  
      }      
    }catch(Exception e){
      return "";
    }
    return s;
  }
  
  //删除最后len个字符
  public static String delLastChars(String s,int len){
    try{
      if(s.length()>0){
        s = s.substring(0,s.length()-len);  
      }      
    }catch(Exception e){
      return "";
    }
    return s;
  }
  
  //替换网页用字符-配合FCKEditor使用 .replaceAll("'","&apos;") //for viewpage
  public String htmlReplaceAll(String s){
	  try{
		  StringBuffer sBuf = new StringBuffer();
		  //.replaceAll("\\\\","\\\\\\\\").replaceAll("&","&amp;")
		  sBuf.append(s.replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\"","&quot;").replaceAll("\n","<br\\>"));
		  return sBuf.toString();
	  }catch(Exception e){
		  return "";
	  }
  }
  
  //for viewpage by jstl/make html
  public static String htmlNewline(String s){
	  try{
		  //如不替换空格,html解释时会自动把多个空格显示为一个空格,这样当我们通过空格来布局时就出现textarea中和html页面展现不一致的情况 tony
		  //s.replaceAll(" ","&nbsp;") 不能进行空格的替换，否则页面内容中如果有<img src="xxx.jpg" \>等标签，内容就会显示乱；<img&nbsp;src="xxx.jpg"nbsp;\>
		  return s.replaceAll(" ","&nbsp;").replaceAll("\n","<br\\>");  
	  }catch(Exception e){
		  return "";
	  }
  }
  

  /** getPassString 功能：用于转换为后几位的为*。
   * <br>输入参数：String strvalue 设置要转换的字符串
   *              int Flag 位数。
   * <br>输出参数：。
   * <br>作者：范波
   * <br>时间：2006-8-7
   * <br>存在问题：
   * <br>用法：
   *          <%=utilFuns.ConvertString("abcdef",3)%>
   */
  public static String getPassString( String strvalue, int Flag ) {
    try {
      if ( strvalue.equals("null") || strvalue.compareTo("")==0){
        return "";
      } else {
        int intStrvalue = strvalue.length();
        if ( intStrvalue > Flag ) {
          strvalue = strvalue.substring( 0, intStrvalue - Flag );

        }
        for ( int i = 0; i < Flag; i++ ) {
          strvalue = strvalue + "*";
        }

        //System.out.print( "strvalue:" + strvalue );
        return strvalue;
      }
    }
    catch (Exception e) {
      return strvalue;
    }
  }
  
 /** getPassString 功能：用于转换为后几位的为*。
 * <br>输入参数：String strvalue 设置要转换的字符串
 *              int Flag 起位数。
 *              int sFlag 末位数。 
 * <br>输出参数：。
 * <br>作者：范波
 * <br>时间：2006-8-7
 * <br>存在问题：
 * <br>用法：
 *          <%=optionFuns.getPassString(String.valueOf(oi.next()),3)%>
 */
public static String getPassString( String strvalue, int Flag, int sFlag ,int iPassLen ) {
  try {
    
    if ( strvalue.equals( "null" ) ) {
      return "";
    } else {
      String strvalue1="";
      String strvalue2="";
      int intStrvalue = strvalue.length();
      if(sFlag>=Flag){
        if ( intStrvalue > Flag ) {
          strvalue1 = strvalue.substring( 0,  Flag );
          strvalue2 = strvalue.substring(  sFlag, intStrvalue );
        } else {
          strvalue1 = "";
          strvalue2 = "";
        }
        for ( int i = 0; i < iPassLen; i++ ) {
          strvalue1 = strvalue1 + "*";
        }
        strvalue=strvalue1+strvalue2;
      }
      //System.out.print( "strvalue:" + strvalue );
      return strvalue;
    }
  }
  catch (Exception e) {
    return strvalue;
  }
  } 
  
  
  /* 
	by czs 2006-8-17
	OPTION:
		取得字符串iStartPos位置到iEndPos位置，将中间这部分转换iPatternLen个sPattern
	EXSAMPLE:
		getPatternString("CHEN ZISHU",5,7,"*",3)
		RESULT: CHEN ***SHU

		getPatternString("CHEN ZISHU",10,0,".",3)
		RESULT: CHEN******

  */
  public static String getPatternString( String s, int iStartPos, int iEndPos, String sPattern, int iPatternLen ) {
    try {
	  if (iEndPos==0) {
		iEndPos = s.length();
	  }
	  
	  String sStartStr = "";
	  String sCenterStr = "";
	  String sEndStr = "";
	  
      if ( s.equals("null")){
        return "";
      } else {
        int ints = s.length();
        if ( ints > iStartPos ) {
          sStartStr = s.substring( 0, iStartPos );
        }else{
          return s;
        }
		if ( ints > iEndPos) {
          sEndStr = s.substring( iEndPos, ints );
		}
        for ( int i = 0; i < iPatternLen; i++ ) {
          sCenterStr = sCenterStr + sPattern;
        }
        return sStartStr + sCenterStr + sEndStr;
      }
    }
    catch (Exception e) {
      System.out.println(e);
      return s;
    }
  }

  public static String getPatternString( String s, int iStartPos, String sPattern, int iPatternLen ) {
    return getPatternString(s,iStartPos,0,sPattern,iPatternLen);
  }

  public static String getPatternString( String s, int iStartPos, String sPattern ) {
    return getPatternString(s,iStartPos,0,sPattern,3);
  }

  
    /** getQQString 功能：用于转换为后几位的为*。
* <br>输入参数：String strvalue 设置要转换的字符串
*               
* <br>输出参数：。
* <br>作者：范波
* <br>时间：2006-8-7
* <br>存在问题：
* <br>用法：
*          <%=optionFuns.getQQString(String.valueOf(oi.next()))%>
*/
public static String getQQString( String strvalue ) {
	try {
	  String QQ="";
	  if ( strvalue.equals("") ) {
	    return "";
	  } else {
	     QQ="<img src=\"http://wpa.qq.com/pa?p=1:"+strvalue
	        +":4\">"
	        +" <SPAN title=\"有事叫我!\" style=\"CURSOR: hand\""
	        +" onclick=\"window.open('http://wpa.qq.com/msgrd?V=1&amp;Uin="+strvalue
	        +"&amp;Site=21pan&amp;Menu=yes')\">"+strvalue+"</SPAN>";
	    }
	    strvalue=QQ;
	    //System.out.print( "strvalue:" + strvalue );
	    return strvalue;
	  
	}
	
	catch (Exception e) {
	  return strvalue;
	}
}

	public String getNoExistString(String allString, String existString){
		return this.getNoExistString(this.splitStr(allString, ","), existString);
	}
	
	/* 返回existString中的每个字串不在allString中的 */
	public String getNoExistString(String[] allString, String existString){
		existString = existString + ",";
		if(allString==null&&allString.length==0){
			return "";
		}
		StringBuffer sBuf = new StringBuffer();
		for(int i=0;i<allString.length;i++){
			if(existString.indexOf(allString[i])==-1){
				sBuf.append(allString[i]).append(",");
			}
		}
		if(sBuf.length()>1){
			sBuf.delete(sBuf.length()-1, sBuf.length());
		}
		return sBuf.toString();
	}
	
  public static void main(String[] args) throws Exception {

//	  
//	  
//	  java.util.List aList = new ArrayList();
//	  System.out.println(UtilFuns.isNotEmpty(aList));
//	  
//	  System.out.println(uf.formatDateTimeCN("2011"));
//	  System.out.println(uf.formatDateTimeCN("2011-01"));
//	  System.out.println(uf.formatDateTimeCN("2011-01-02"));
//	  System.out.println(uf.formatDateTimeCN("2011-01-02 03"));
//	  System.out.println(uf.formatDateTimeCN("2011-01-02 13:05"));
//	  System.out.println(uf.formatDateTimeCN("2011-01-02 13:05:05"));
//	  System.out.println(uf.formatDateTimeCN("03"));
//	  System.out.println(uf.formatDateTimeCN("13:05"));
//	  System.out.println(uf.formatDateTimeCN("13:05:05"));
	  
//	  UtilFuns uf = new UtilFuns();
//	  System.out.println(uf.getNoExistString("1,2,3", "1,2,3,4"));
//	  System.out.println(uf.getNoExistString("安全,生产,营销", "生产,营销"));
//	  System.out.println("finish!");
	  
//	  Set<String> set = new HashSet<String>();
//	  set.add("abc");
//	  set.add("xyz"); 
//	  set.add("abc");  
//	  for(Iterator<String> it = set.iterator();it.hasNext();){
//	   System.out.println(it.next());   
//	  } 
	
  	/*
    System.out.println(SysTime("yyyy-MM-dd"));
    System.out.println(SysTime("yyyy-MM-dd HH:mm:ss"));
    
    System.out.println(Double.parseDouble("12.11"));
    System.out.println(FormatNumber("12.11000000000f"));
    
    System.out.println(getPatternString("CHEN ZISHU",8,0,".",3));
    */
    
    //System.out.println(SysTime("yyyy年MM月"));
    //System.out.println(SysTime("yyyyMM"));
    //System.out.println(ConvertSpaceTD(""));
    //System.out.println(ConvertTD(""));
    
		/* process the stat data Start 
		Statement stmt1 = conn.createStatement(); 
		String sTableName = find_Type;
		String sUserName = findName;
		StringBuffer sBuffer = new StringBuffer();

		//Step 1 clear Table userState
		sBuffer.append("delete * from userStat;");

		//Step 2 read username from User_P and write inputnum in it
		sBuffer.append("select User_P.loginname,").append(sTableName).append(".createby,count(").append(sTableName).append(".createby)")
			.append(" from ").append(sTableName).append("")
			.append(" right join")
			.append(" User_P")
			.append(" on User_P.loginname=").append(sTableName).append(".createby")
			.append(" where 1=1");
		if (find_Name.compareTo("")!=0){
			sBuffer.append(" and ").append(sTableName).append(".createby='").append(sTableName).append("'");
		}
		if (find_DateStart.compareTo("")!=0){
			sBuffer.append(" and createdate<='").append(find_DateStart).append(" 00:00:00'");
		}
		if (find_DateStart.compareTo("")!=0){
			sBuffer.append(" and createdate>='").append(find_DateEnd).append(" 23:59:59'");
		}
		sBuffer.append(" group by ").append(sTableName).append(".createby")
			.append(";");


		//Step 3 read updatenum
		sBuffer.append("select count(updateby) from ").append(sTableName).append("")
			.append(" where ").append(sTableName).append(".updateby=''")
			.append(" and updatedate<='").append(find_DateStart).append(" 00:00:00'")
			.append(" and updatedate>='").append(find_DateEnd).append(" 23:59:59'")
			.append(";");

		//Step 4 update the userStat.updatenum value
		sBuffer.append("update userStat set updatenum='3' where updateby='").append(sTableName).append("'")
			.append(";");

		sBuffer.toString();

		 process the stat data End */

/*    
    try{
      System.out.println(SysDate());
       System.out.println(StrToDateTimeFormat("2003-08-21 18:28:47", "yyyy-MM-"));
    }catch(Exception e){
       
    }
    String s[] = SplitStr("asd,asd,we,sd",",");
    for (int curLayNum=0;curLayNum<s.length;curLayNum++){
      System.out.println(s[curLayNum]);
    }
    System.out.println(JoinStr(s,","));

    System.out.println(ReturnSysTime("yyyy-MM-dd"));
    //System.out.println(CoverDate(ReturnSysTime("yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd"));
    try {
      System.out.println(StrToTimestamp("2003-08-21 18:28:47", "yyyy-MM"));
      System.out.println(StrToDateTimeFormat("2003-08-21 18:28:47", "yyyy-MM"));
    }
    catch (ParseException ex) {
    }

    try {
      System.out.println(StrToTimestamp("2003-08-26", "yyyy-MM-dd"));
    }
    catch (ParseException ex) {
      System.out.println("StrToTimestamp error.");
    }*/
	  
	  System.out.println("finish!");
  }

/*
<script language=JavaScript>

  var today = new Date();
  var strDate = (today.getFullYear() + "年" +
(today.getMonth() + 1) + "月" + today.getDate() + "日 ");
  var n_day = today.getDay();
  switch (n_day)
  {
  case 0:{
  strDate = strDate + "星期日"
  }break;
  case 1:{
  strDate = strDate + "星期一"
  }break;
  case 2:{
  strDate = strDate + "星期二"
  }break;
  case 3:{
  strDate = strDate + "星期三"
  }break;
  case 4:{
  strDate = strDate + "星期四"
  }break;
  case 5:{
  strDate = strDate + "星期五"
  }break;
  case 6:{
  strDate = strDate + "星期六"
  }break;
  case 7:{
  strDate = strDate + "星期日"
  }break;
  }
  document.write(strDate);

</script>
*/

	public String replaceLast(String string, String toReplace, String replacement) {
		int pos = string.lastIndexOf(toReplace);
		if (pos > -1) {
			return string.substring(0, pos) + replacement + string.substring(pos + toReplace.length(), string.length());
		} else {
			return string;
		} 
	} 
	
	public static String getROOTPath(){
		UtilFuns uf = new UtilFuns();
		return uf.getClass().getResource("/").getPath().replace("/WEB-INF/classes/", "/").substring(1);
	}
	public String getClassRootPath(){
		return this.getClass().getResource("/").getPath();
	}
}