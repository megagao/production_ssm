package com.megagao.production.ssm.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

  /* ======================================== *
   * Class Methods
   * ======================================== */

   
	public String getFileExt(String s){
	    String s1 = new String();
	    int i = 0;
	    int j = 0;
	    if(s == null)
	        return null;
	    i = s.lastIndexOf(46) + 1;
	    j = s.length();
	    s1 = s.substring(i, j);
	    if(s.lastIndexOf(46) > 0)
	        return s1.toLowerCase();
	    else
	        return "";
	}
	

    private String getNameWithoutExtension(String fileName){
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
	
	public boolean isImgFile(String file)
	{
		if(UtilFuns.isNotEmpty(file)){
			String s1 = "."+this.getFileExt(file);
			if(".jpg.jpeg.bmp.gif.png".indexOf(s1)>-1){
				return true;
			}
		}
		return false;
	}
	
	public String getFileName(String s){
		try{
			s = s.replaceAll("/", "\\\\");
			int fileIndex= s.lastIndexOf("\\")+1;
			return s.substring(fileIndex,s.length());
		}catch(Exception e){
			return "";
		}
	}
	
	public String getFilePath(String s){
		try{
			s = s.replaceAll("/", "\\\\");
			int fileIndex= s.lastIndexOf("\\");
			return s.substring(0,fileIndex);
		}catch(Exception e){
			return "";
		}
	}
	
	/* 目录下已经有同名文件,则文件重命名,增加文件序号 add by tony 20110712 */
	public String newFile(String sPath, String sFile){
		String newFileName = new String();
		String withoutExt = new String();
		File curFile = new File(sPath + "\\" + sFile);
		if (curFile.exists()) {
			for(int counter = 1; curFile.exists(); counter++){
				withoutExt = this.getNameWithoutExtension(curFile.getName());
				if(withoutExt.endsWith(counter-1 + ")")){
					withoutExt = withoutExt.substring(0,withoutExt.indexOf("("));		//idea
				}
                newFileName = withoutExt + "(" + counter + ")" + "." + getFileExt(curFile.getName());
                curFile = new File(sPath + "\\" + newFileName);
            }
		}else{
			newFileName = curFile.getName();
		}
		return newFileName;
	}
    
  /* 只清空文件夹，不删除文件夹 */
  public static synchronized void clearDir(String dir_path)
   throws FileNotFoundException {
    
    File file = new File(dir_path);
    if (!file.exists()) {
      throw new FileNotFoundException();
    }
    if (file.isDirectory()) {
      File[] fe = file.listFiles();
      for (int i = 0; i < fe.length; i++) {
        deleteFiles(fe[i].toString());
        fe[i].delete(); //删除已经是空的子目录
      }
    }
  }
   
  //ex: deleteDir(new File("c://aaa"));
  /* 清空文件夹，并删除文件夹 */
  public static synchronized void deleteDir(String dir_path)
   throws FileNotFoundException,IOException {
	deleteDir(new File(dir_path));
  }
  
  //ex: deleteDir(new File("c://aaa"));
  /* 清空文件夹，并删除文件夹 */
  public static synchronized void deleteDir(File f)
  throws FileNotFoundException,IOException {
	  
	  if(!f.exists()){//文件夹不存在不存在
		  throw new IOException("指定目录不存在:"+f.getName());
	  }
	  boolean rslt=true;//保存中间结果
	  if(!(rslt=f.delete())){//先尝试直接删除
		  //若文件夹非空。枚举、递归删除里面内容
		  File subs[] = f.listFiles();
		  for (int i = 0; i <= subs.length - 1; i++) {
			  if (subs[i].isDirectory())
				  deleteDir(subs[i]);//递归删除子文件夹内容
			  rslt = subs[i].delete();//删除子文件夹本身
		  }
		  rslt = f.delete();//删除此文件夹本身
	  }
	  //if(!rslt)
	  //　throw new IOException("无法删除:"+f.getName());
	  //return;
  }
     
  //路径中的多层目录,如果不存在,则建立(mkdir－只可建最后一层目录)
  public static synchronized void makeDir(String dirPath)
   throws FileNotFoundException {
	String s = "";

	dirPath = dirPath.replaceAll("\\t","/t"); 	//replace tab key
	dirPath = dirPath.replaceAll("\\\\","/");
	String[] aPath = dirPath.split("/");
	for (int i=0;i<aPath.length;i++){
		s = s + aPath[i] + "/";
		//System.out.println(s);
	    File d = new File(s);
		if(!d.exists()){
			d.mkdir();
		}
	}
  }

  //修改目录名称或文件名称 dir and file
  public static synchronized void rename(String sOld,String sNew)
   throws FileNotFoundException {
   	boolean b = false;
	File d = new File(sOld);
	if(d.exists()){
		b = d.renameTo(new File(sNew));
	}
  }
  
  public static synchronized String formulaDirName(String dirName){
	  dirName = dirName.replaceAll("/","\\\\");
	  return dirName;
  }
  
  public static synchronized String formulaPath(String dirName){
	  dirName = dirName.replaceAll("\\\\","/");
	  return dirName;
  }

  public static synchronized String lastDir(String dir_path){
    if(dir_path.trim().compareTo("")==0){
      return "";
    }else{
      //两个位置，谁后取谁。因为路径中常包含这两种标识
      int i= dir_path.lastIndexOf("\\")>dir_path.lastIndexOf("/")?dir_path.lastIndexOf("\\"):dir_path.lastIndexOf("/");
      if(i>0){
    	  return dir_path.substring(i);
      }else{
    	  return "";
      }
    }
  }
  
  //删除给定的文件
  public static void deleteFile(String FileName) {
    File f2 = new File(FileName);
    f2.delete(); //del file
    f2 = null;
  }
  
  
  /*public boolean deleteFile(String sPath) {  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	    }  
	    return true;  
	}  */
  
  
/*
 *删除目录下的所有文件
 **/
  public static boolean deleteFiles(String dir) {
    if(dir==null || "".equals(dir))
      return true;

    File f0 = new File(dir);
    if( !f0.isDirectory() )
      return false;
    File[] files = f0.listFiles();
    boolean status = true;
    for(int i=0; i<files.length; i++) {
      File f = files[i];
      if( !f.isFile() )
        continue;

      boolean b = f.delete();
      status = ( status && b );
    }
    return status;
  }


  /** Deletes each file in <tt>files</tt> which is under <tt>path</tt>.
   * It does not delete directory.
   *
   * @param path
   * @param files
   * @return <tt>true</tt> if and only if all the files are successfully
   *   deleted; <tt>false</tt> otherwise.
   */
  public static boolean deleteFiles(String path, String[] files) {
    if(path==null || files==null)
      return true;

    boolean status = true;
    for(int i=0; i<files.length; i++) {
      File f = new File(path, files[i]);
      if( !f.isFile() )
        continue;
		//?  (f.getAbsoluteFile()).
      boolean b = f.delete();
      status = ( status && b );
    }
    return status;
  }
  
  public static boolean deleteFiles(List files) {
	  
    if(files==null || files.size()<=0)
      return true;
    
    String fileName = "";
    boolean status = true;
    for(int i=0; i<files.size(); i++) {
      fileName = (String)files.get(i);
      File f = new File(fileName);
      if( !f.isFile() )
        continue;
		//?  (f.getAbsoluteFile()).
      boolean b = f.delete();
      status = ( status && b );
    }
    return status;
  }

  /** Copies byte-content of <tt>f</tt> to <tt>os</tt>.
   *
   * @param f
   * @param os
   * @throws IOException
   */
  public static void fileToOutputStream(File f, OutputStream os)
      throws IOException {
    //
    InputStream is = new BufferedInputStream( new FileInputStream(f) );
    byte[] barr = new byte[1024];
    int count;
    while(true) {
      count = is.read(barr);
      if(count == -1)
        break;

      os.write(barr, 0, count);
    }
    is.close();
    return;
  }
  //读日志文件 "c:\\Log.txt"
  //输入参数：sFile = Path + FileName 文件路径＋文件名称
  public List<String> readTxtFile(String sFile) {
	String str = "";
    List<String> sList = new ArrayList<String>();
    try {
      FileReader fr = new FileReader(sFile);
      BufferedReader bfr = new BufferedReader(fr);
      while((str = bfr.readLine())!=null){
    	  sList.add(str);
      }
      fr.close();
    }catch (IOException ex){System.out.println("readTxtFile IOException Error."+ex.getMessage());
    }catch (Exception ex) {System.out.println("readTxtFile Exception Error."+ex.getMessage());}
    return sList;
  }
  
  public String WriteTxt(String sPath,String sFile,String sContent) {
  	String s = "";
  	File d=new File(sPath);//建立代表Sub目录的File对象，并得到它的一个引用
  	if(!d.exists()){//检查Sub目录是否存在
  		d.mkdir();//建立Sub目录
  	}
  	
	try {
      FileWriter fw = new FileWriter(sPath + "\\" + sFile,true);
      BufferedWriter bfw = new BufferedWriter(fw);
      bfw.write(sContent);
      bfw.flush();
      fw.close();
    }catch (IOException ex){ s = "WriteTxt IOException Error."; 
    }catch (Exception ex) { s = "WriteTxt Exception Error.";}
    
	return s;
  }
  
  /* 创建新文本文件，如果文件已经存在则覆盖 */
  public String createTxt(String sPathFile,String sContent) throws FileNotFoundException {
  	String s = "";
  	String sPath = this.getFilePath(sPathFile);
  	String sFile = this.getFileName(sPathFile);
  	
  	File d=new File(sPath);		//建立代表Sub目录的File对象，并得到它的一个引用
  	if(!d.exists()){			//检查Sub目录是否存在
  		this.makeDir(sPath); 	//建立Sub目录
  	}
  	
	try {
      FileWriter fw = new FileWriter(sPath + "\\" + sFile,false);
      BufferedWriter bfw = new BufferedWriter(fw);
      bfw.write(sContent);
      bfw.flush();
      fw.close();
    }catch (IOException ex){ s = "createTxt IOException Error."; 
    }catch (Exception ex) { s = "createTxt Exception Error.";}
    
	return s;
  }
  
  /* 创建新文本文件，如果文件已经存在则覆盖 */
  public String createTxt(String sPath,String sFile,String sContent) throws FileNotFoundException {
	  String s = "";
	  File d=new File(sPath);		//建立代表Sub目录的File对象，并得到它的一个引用
	  if(!d.exists()){			//检查Sub目录是否存在
		  this.makeDir(sPath); 	//建立Sub目录
	  }
	  
	  try {
		  FileWriter fw = new FileWriter(sPath + "\\" + sFile,false);
		  BufferedWriter bfw = new BufferedWriter(fw);
		  bfw.write(sContent);
		  bfw.flush();
		  fw.close();
	  }catch (IOException ex){ s = "createTxt IOException Error."; 
	  }catch (Exception ex) { s = "createTxt Exception Error.";}
	  
	  return s;
  }
  
  /* 创建新文本文件，如果文件已经存在则覆盖，在文件后追加内容 文件格式：encode:UTF-8  add by tony 20100118 */
  public String createTxt(String sPath,String sFile,String sContent,String enCoding) throws FileNotFoundException {
  	String s = "";
  	File d=new File(sPath);		//建立代表Sub目录的File对象，并得到它的一个引用
  	if(!d.exists()){			//检查Sub目录是否存在
  		this.makeDir(sPath); 	//建立Sub目录
  	}
  	
	try {
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(sPath + "\\" + sFile), enCoding);
	    out.write(sContent);
	    out.flush();
	    out.close();
    }catch (IOException ex){ s = "createTxt IOException Error."; 
    }catch (Exception ex)  { s = "createTxt Exception Error."; }
    
	return s;
  }
  
  /* 创建新文本文件，如果文件已经存在则覆盖，只覆盖不追加 文件格式：encode:UTF-8  add by tony 20100118 */
  public String newTxt(String sPath,String sFile,String sContent,String enCoding) throws FileNotFoundException {
	  String s = "";
	  File d=new File(sPath);		//建立代表Sub目录的File对象，并得到它的一个引用
	  if(!d.exists()){			//检查Sub目录是否存在
		  this.makeDir(sPath); 	//建立Sub目录
	  }
	  
	  try {
		  OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(sPath + "\\" + sFile, false), enCoding);
		  out.write(sContent);
		  out.flush();
		  out.close();
	  }catch (IOException ex){ s = "createTxt IOException Error."; 
	  }catch (Exception ex)  { s = "createTxt Exception Error."; }
	  
	  return s;
  }
  
/*
    
    s = "c:\\ex.txt";
    String[] aTitle = null; //表示没有标题
    String[] aContent = {"a","b","c","a1","a2","a3"};
    
    sMsg = fileUtil.WriteTxt(s,aTitle,aContent,"\t",3); //\t TAB键

 */
  public String WriteTxt(String sFile,String[] aTitle,String[] aContent,String sSplitFlag,int iColumns) {
    String sMsg = "";
    long lTime = System.currentTimeMillis();
    try {
      if (aTitle!=null){     
        if (aTitle.length!=iColumns){
          throw new Exception("Title Length is not right!");
        }
      }
      
      File f = new File(sFile);
      if(f.exists())
      {
        f.delete();   //if exist then delete()
      }
      
      FileWriter fw = new FileWriter(sFile,true);
      BufferedWriter bfw = new BufferedWriter(fw);
      
      //write Title
      if (aTitle!=null){
        for(int i=0;i<aTitle.length;i++){    
          bfw.write(aTitle[i] + sSplitFlag);
        }
        bfw.newLine(); //插入换行符号
      }
      
      //write content
      for(int i=0;i<aContent.length;i++){    
        bfw.write(aContent[i] + sSplitFlag);
        
        if ((i+1)%iColumns==0){
          bfw.newLine(); //插入换行符号
        }
      }
      bfw.flush();   //将缓冲区内的数据写入文件中
      fw.close();
    }catch (IOException ex){ 
      sMsg = "WriteTxt IOException Error."+ex.getMessage();
    }catch (Exception ex) {
      sMsg = "WriteTxt Exception Error."+ex.getMessage();
    }
    return sMsg;
  }

 
  //边生成边写XML文件  对单表结构
  public String WriteXML(String sFile,String indent,String root,String[] aTrunk,String[] aLeaf,String[] aContent) {
    int i=0,j=0,k=0;
    String sIndent = "";
    String[] aTrunkSuffix = new String[aTrunk.length];
    String[] aLeafSuffix  = new String[aLeaf.length];
    
    
    String sMsg = "";
    long lTime = System.currentTimeMillis();
    
    try {
      
      File f = new File(sFile);
      if(f.exists())
      {
        f.delete();   //if exist then delete()
      }
      
      //inital array
      for(i=0;i<aTrunk.length;i++){
        for(j=0;j<i;j++){
          sIndent = indent + sIndent;  //add space
        }
        aTrunk[i] = sIndent + "<" + aTrunk[i] + ">";
        aTrunkSuffix[i] = aTrunk[i].replaceFirst("<","</");
        //System.out.println(i + " " + aTrunk[i]+aTrunkSuffix[i]);
      }
      
      sIndent = indent + sIndent;  //add space
      for(i=0;i<aLeaf.length;i++){
        aLeafSuffix[i] = "</" + aLeaf[i] + ">";
        aLeaf[i] = sIndent + "<" + aLeaf[i] + ">";
      }
              
      FileWriter fw = new FileWriter(sFile,true);
      BufferedWriter bfw = new BufferedWriter(fw);
     
      bfw.write("<?xml version=\"1.0\" ?>");bfw.newLine();
      if(root.length()>0){
        bfw.write("<"+root+">");bfw.newLine();        
      }
      
      while(k<aContent.length){
        for(i=0;i<aTrunk.length;i++){
          bfw.write(aTrunk[i]);bfw.newLine();
        }
        for(i=0;i<aLeaf.length;i++){
          bfw.write(aLeaf[i] + aContent[k++] + aLeafSuffix[i]);bfw.newLine();  
        }
        
        for(i=aTrunkSuffix.length-1;i>-1;i--){
          bfw.write(aTrunkSuffix[i]);bfw.newLine();
        }
      }//end while
      
      if(root.length()>0){
        bfw.write("</"+root+">");bfw.newLine();
      }    
      
      
      bfw.flush();   //将缓冲区内的数据写入文件中
      fw.close();
    }catch (IOException ex){ 
      sMsg = this.getClass().getName()+ " WriteXML IOException Error."+ex.getMessage();
    }catch (Exception ex) {
      sMsg = this.getClass().getName()+ " WriteXML Exception Error."+ex.getMessage();
    }
    return sMsg;
  }


 
  //create xml lines to ArrayList
  public ArrayList CreateXML(String StartIndent,String indent,String[] aTrunk,String[] aLeaf,String[] aContent) {
    
    ArrayList aList = new ArrayList();

    int i=0,j=0,k=0;
    String sIndent = StartIndent;
    String[] aTrunkSuffix = new String[aTrunk.length];
    String[] aLeafSuffix  = new String[aLeaf.length];
    
    String sMsg = "";
    long lTime = System.currentTimeMillis();
    
    try {
      
      //inital array
      for(i=0;i<aTrunk.length;i++){
        for(j=0;j<i;j++){
          sIndent = indent + sIndent;  //add space
        }
        aTrunk[i] = sIndent + "<" + aTrunk[i] + ">";
        aTrunkSuffix[i] = aTrunk[i].replaceFirst("<","</");
      }
      
      sIndent = indent + sIndent;  //add space
      for(i=0;i<aLeaf.length;i++){
        aLeafSuffix[i] = "</" + aLeaf[i] + ">";
        aLeaf[i] = sIndent + "<" + aLeaf[i] + ">";
      }
                    
      while(k<aContent.length){
        for(i=0;i<aTrunk.length;i++){
          aList.add(aTrunk[i]);   
        }
        for(i=0;i<aLeaf.length;i++){
          aList.add(aLeaf[i] + aContent[k++] + aLeafSuffix[i]);     
        }
        
        for(i=aTrunkSuffix.length-1;i>-1;i--){
          aList.add(aTrunkSuffix[i]);   
        }
      }//end while
      
      return aList;
    }catch (Exception ex) {
      sMsg = this.getClass().getName()+ " CreateXML Exception Error."+ex.getMessage();
    }
    return null;
  }


  //边生成边写XML文件 
  public String WriteXML(String sFile,String sXmlVer,String root,ArrayList aList) {

    String sMsg = "";
    long lTime = System.currentTimeMillis();
    try {
      
      File f = new File(sFile);
      if(f.exists())
      {
        f.delete();   //if exist then delete()
      }
      
      FileWriter fw = new FileWriter(sFile,true);
      BufferedWriter bfw = new BufferedWriter(fw);
     
      bfw.write("<?"+sXmlVer+"?>");bfw.newLine();  
      
      if(root.length()>0){
        bfw.write("<"+root+">");bfw.newLine();        
      }
      
      //write txt
      for(int i=0;i<aList.size();i++){
        bfw.write((String)aList.get(i));bfw.newLine();        
      }      
      
      if(root.length()>0){
         //去掉元素后面的属性
        bfw.write("</"+root.substring(0,root.indexOf(" "))+">");
      }        
      
      bfw.flush();   //将缓冲区内的数据写入文件中
      fw.close();
    }catch (IOException ex){ 
      sMsg = this.getClass().getName()+ " WriteXML IOException Error."+ex.getMessage();
    }catch (Exception ex) {
      sMsg = this.getClass().getName()+ " WriteXML Exception Error."+ex.getMessage();
    }
    return sMsg;
  }

	public boolean isExist(String filename){
		try{
			File file = new File(filename);
			if(!file.exists()){
				return false;
			}else{
				return true;			
			}
		}catch(Exception e){
			return false;
		}
	}
	
	//用于判断是绝对路径还是相对路径	add by tony 20100413
	public boolean isAbsolutePath(String path){
		if(path.indexOf(":")>0){
			return true;
		}
		return false;
	}

	/** * 功能:利用nio来快速复制文件 */
    public void copyFile(String srcFile, String destFile)
            throws java.io.FileNotFoundException, java.io.IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        FileChannel fcin = fis.getChannel();
        FileChannel fcout = fos.getChannel();
        fcin.transferTo(0, fcin.size(), fcout);
        fcin.close();
        fcout.close();
        fis.close();
        fos.close();
    }


	/** 忽略拷贝文件时发生的错误，可能是文件不存在 */
	public  boolean copyFileIgnore(String file1,String file2){
		try{
			File file_in = new File(file1);
			File file_out = new File(file2);
			FileInputStream in1 = new FileInputStream(file_in);
			FileOutputStream out1 = new FileOutputStream(file_out);
			byte[] bytes = new byte[1024];
			int c;
			while((c=in1.read(bytes))!=-1){
				out1.write(bytes,0,c);
			}
			in1.close();
			out1.close();
			return true;	//if sucess then return true
		}catch(Exception e){
			return false;	//if fail then return false
		}
		
	}

	
	/* create by czs 2006-08-08 */
	public void copyDir(String dir1,String dir2) throws java.io.FileNotFoundException, IOException{
		(new File(dir2)).mkdir();
		File[] file = (new File(dir1)).listFiles();
		
		for(int i=0;i<file.length;i++){
			
			if(file[i].getName().compareTo("Thumbs.db")!=0){
				if(file[i].isFile()){
					copyFile(dir1+"\\"+file[i].getName(),dir2+"\\"+file[i].getName());
				}else if(file[i].isDirectory()){
					copyDir(dir1+"\\"+file[i].getName(),dir2+"\\"+file[i].getName());
				}
			}
		}
	}
	
    /** * 功能:利用nio快速复制目录 */
    public void copyDirectory(String srcDirectory, String destDirectory)
            throws java.io.FileNotFoundException, java.io.IOException { // 得到目录下的文件和目录数组

        File srcDir = new File(srcDirectory);
        File[] fileList = srcDir.listFiles();
        // 循环处理数组
        
        if(fileList==null){
        	throw new java.io.FileNotFoundException();
        }
        
        (new File(destDirectory)).mkdir();
        
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                // 数组中的对象为文件
                // 如果目标目录不存在，创建目标目录
                File descDir = new File(destDirectory);
                if (!descDir.exists()) {
                    descDir.mkdir();
                } // 复制文件到目标目录
                if(fileList[i].getName().compareTo("Thumbs.db")!=0){	//windows bug
                	copyFile(srcDirectory + "/" + fileList[i].getName(),
                        destDirectory + "/" + fileList[i].getName());
                }
            } else {
                // 数组中的对象为目录
                // 如果该子目录不存在就创建（其中也包含了对多级目录的处理）
                File subDir = new File(destDirectory + "/"
                        + fileList[i].getName());
                if (!subDir.exists()) {
                    subDir.mkdir();
                }
                // 递归处理子目录
                copyDirectory(srcDirectory + "/" + fileList[i].getName(),
                        destDirectory + "/" + fileList[i].getName());

            }
        }
    }

	/* 列出目录下的所有文件 */
	public List fileList(String dir){
		File f = new File(dir);
		File[] files = f.listFiles();
		if (files==null){
			return null;
		}
		int count = files.length;
		List list = new ArrayList(count);
		for (int i=0;i<count;i++){
			if (!files[i].isDirectory()){
				list.add(files[i]);
			}
		}
		return list;
	}
	
	/* 列出目录下的所有文件，去除prefix路径~虚拟路径 */
	public List fileList(String dir, String prefix){
		FormatStyle formatStyle = new FormatStyle();
		File f = new File(dir);
		File[] files = f.listFiles();
		if (files==null){
			return null;
		}
		int count = files.length;
		List list = new ArrayList(count);
		for (int i=0;i<count;i++){
			if (!files[i].isDirectory()){
				list.add(String.valueOf(files[i]).substring(prefix.length()));
				list.add(formatStyle.fileSize(String.valueOf(files[i].length())));
			}
		}
		return list;
	}
	
	/* 列出目录下前缀为prefix，后缀为suffix的文件 by tony 20110930 */
	public List<String> fileList(String dir, String prefix, String suffix){
		FormatStyle formatStyle = new FormatStyle();
		File f = new File(dir);
		File[] files = f.listFiles();
		if (files==null){
			return null;
		}
		int count = files.length;
		List _list = new ArrayList(count);
		for (int i=0;i<count;i++){
			if (!files[i].isDirectory()){
				if(files[i].getName().startsWith(prefix) && files[i].getName().endsWith(suffix)){
					_list.add(dir+"/"+files[i].getName());
				}
			}
		}
		return _list;
	}


	/* 列出目录下的所有目录 */
	public List fileDir(String dir){
		File f = new File(dir);
		File[] files = f.listFiles();
		if (files==null){
			return null;
		}
		int count = files.length;
		List list = new ArrayList(count);
		for (int i=0;i<count;i++){
			if (files[i].isDirectory()){
				list.add(files[i]);
			}
		}
		return list;
	}
	
	/* 列出目录下的所有目录，去除prefix路径~虚拟路径 */
	public List fileDir(String dir, String prefix){
		FormatStyle formatStyle = new FormatStyle();
		File f = new File(dir);
		File[] files = f.listFiles();
		if (files==null){
			return null;
		}
		int count = files.length;
		List list = new ArrayList(count);
		for (int i=0;i<count;i++){
			if (files[i].isDirectory()){
				list.add(String.valueOf(files[i]).substring(prefix.length()));
				list.add(String.valueOf(files[i].listFiles().length));
			}
		}
		return list;
	}

	public List dirfileList(String dir){
		File f = new File(dir);
		File[] files = f.listFiles();
		if (files==null){
			return null;
		}
		int count = files.length;
		List list = new ArrayList(count);
		for (int i=0;i<count;i++){
			list.add(files[i]);
		}
		return list;
	}

    /**
     * Moving a File to Another Directory
     * @param srcFile  eg: c:\windows\abc.txt
     * @param destPath eg: c:\temp
     * @return success 
     */
    public boolean moveFile(String srcFile, String destPath){
        // File (or directory) to be moved
        File file = new File(srcFile);
        
        // Destination directory
        File dir = new File(destPath);
        
        // Move file to new directory
        boolean success = file.renameTo(new File(dir, file.getName()));
        
        return success;
    }

  /* ======================================== *
   * Tests Methods
   * ======================================== */

  public static void main(String[] args) throws IOException {
  	FileUtil fu = new FileUtil();
  	
  	
  	
  	//fu.copyDir("E:\\WorkSpace\\java\\pan\\userstyle\\one","E:\\WorkSpace\\java\\pan\\user\\test");
  	fu.rename("c:\\t","c:\\a");
  	//fu.fileList("E:\\WorkSpace\\java\\pan\\21pan");
  	
  	//fu.copyDirectory("c:\\123","c:\\456");
    //String dir = "D:\tmp\t/t";
    //makeDir(dir);

/**	FileUtil fu = new FileUtil();
	boolean copy_ok=fu.copyFile("E://WorkSpace//java//eCargo//comm//uploadfile//do_upload.jsp","E://WorkSpace//java//eCargo//comm//uploadfile//hello_backup.jsp");
	System.out.print(copy_ok);
	
	fu.copyDir("c:/eclog","c:/ec");

    String path = "d:/tmp";
    String f1 = "links.txt";
    boolean b = deleteFiles(path, new String[]{f1});
    System.out.println(b);

    FileUtil fileUtil = new FileUtil();
    String[] aTrunk = {"gaosin","ex"};
    String[] aLeaf = {"编号","姓名","标题","价格"};
    String[] aContent = {"a","b","c","d","a1","a2","a3","a4"};
    //String[] aContent = sqlDAO.CNRecordToStrings(sql);

    String sMsg = fileUtil.WriteXML("c:\\ex.xml","  ","gaosin-info",aTrunk,aLeaf,aContent);
    System.out.print(sMsg);
    
    try{
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder=factory.newDocumentBuilder();
      Document doc=builder.parse("links.xml");
      doc.normalize();
       //---取得变量----
      String text="Wudong's Homepage";
      String url="www.wudong.com";
      String author="Wudong Liu";
      String discription="A site from Wudong Liu, give u lots of suprise!!!";
      //-------------
      Text textseg;
      Element link=doc.createElement("link");
    
      Element linktext=doc.createElement("text");
      textseg=doc.createTextNode(text);
      linktext.appendChild(textseg);
      link.appendChild(linktext);
    
      Element linkurl=doc.createElement("url");
      textseg=doc.createTextNode(url);
      linkurl.appendChild(textseg);
      link.appendChild(linkurl);
    
      Element linkauthor=doc.createElement("author");
      textseg=doc.createTextNode(author);
      linkauthor.appendChild(textseg);
      link.appendChild(linkauthor);
    
      java.util.Calendar rightNow = java.util.Calendar.getInstance();
      String day=Integer.toString(rightNow.get(java.util.Calendar.DAY_OF_MONTH));
      String month=Integer.toString(rightNow.get(java.util.Calendar.MONTH));
      String year=Integer.toString(rightNow.get(java.util.Calendar.YEAR));
      Element linkdate=doc.createElement("date");
    
      Element linkdateday=doc.createElement("day");
      textseg=doc.createTextNode(day);
      linkdateday.appendChild(textseg);
    
      Element linkdatemonth=doc.createElement("month");
      textseg=doc.createTextNode(month);
      linkdatemonth.appendChild(textseg);
    
    
      Element linkdateyear=doc.createElement("year");
      textseg=doc.createTextNode(year);
      linkdateyear.appendChild(textseg);
    
      linkdate.appendChild(linkdateday);
      linkdate.appendChild(linkdatemonth);
      linkdate.appendChild(linkdateyear);
      link.appendChild(linkdate);
    
      Element linkdiscription=doc.createElement("description");
      textseg=doc.createTextNode(discription);
      linkdiscription.appendChild(textseg);
      link.appendChild(linkdiscription);
    
      doc.getDocumentElement().appendChild(link);
    
      TransformerFactory tFactory =TransformerFactory.newInstance();
      Transformer transformer = tFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new java.io.File("links.xml"));
      transformer.transform(source, result);
      }catch(Exception e){
        e.printStackTrace();
      }
    */
  }

}