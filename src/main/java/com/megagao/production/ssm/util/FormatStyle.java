package com.megagao.production.ssm.util;


public class FormatStyle {
	
	public static void main(String[] args) {
		// TODO: Add your code here
		FormatStyle formatStyle = new FormatStyle();
		System.out.println(formatStyle.fileSize("10737418240"));
	}


	public String fileSize(String s1) {
		int iPos = 0;
		String s ="";
		StringBuffer sBuf = new StringBuffer();
		try{
			if(s1.trim().compareTo("")==0){
				return "";
			}
			long g = Long.parseLong("1099511627776");//数字太大，JAVA直接写会无法识别，会引起下面比较失败
			//int i = Integer.parseInt(s1);
			double i = Double.parseDouble(s1);

			if(i<=0){
				sBuf.append("");
			}else if(i<1024){
				sBuf.append(i).append(" B");	//四舍五入
				iPos = sBuf.lastIndexOf(".00 B");	
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-2);	
				}
			}else if(i<1024*1024){
				sBuf.append(new java.text.DecimalFormat(".00").format(i/1024)).append(" KB");	//四舍五入
				iPos = sBuf.lastIndexOf(".00 KB");	
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-3);	
				}
			}else if(i<1024*1024*1024){
				sBuf.append(new java.text.DecimalFormat(".00").format(i/(1024*1024))).append(" M");	//四舍五入
				iPos = sBuf.lastIndexOf(".00 M");
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-2);	
				}
			}else{
				sBuf.append(new java.text.DecimalFormat(".00").format(i/(1024*1024*1024))).append(" G");	//四舍五入
				iPos = sBuf.lastIndexOf(".00 G");
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-2);	
				}
			}			
		}catch(Exception e){
			return "";
		}
		return sBuf.toString();
	}
	
	
}
