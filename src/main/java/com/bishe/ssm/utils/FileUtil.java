package com.bishe.ssm.utils;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * 
 * @author 李寒丽
 * @date 2020年5月6日
 */
public class FileUtil {

	//图片存储的根目录
	private static String photoRoot = "D:\\imgs\\";

	/**
	 * 下载文件到客户端 （将图片显示在模态框中,图片展示）
	 * @param file
	 * @param response
	 * @throws Exception
	 */
	public static void downloadFile(File file,HttpServletResponse response) throws Exception {
		//将传过来的图片转化为输入流
		InputStream fis = new FileInputStream(file);
		//创建一个空的输出流
		OutputStream fileOut = new BufferedOutputStream(response.getOutputStream());
		try{
			//available()获取读的文件的所有字节个数
	    	byte[] buffer = new byte[fis.available()];
	    	//将图片全部读到输出流中
	    	fis.read(buffer);
	    	//编译的时候首部会有空白行产生，利用该方法清除首部空白行
	    	response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("utf-8"), "ISO-8859-1"));
			response.addHeader("Content-Length", ""+buffer.length);
			response.setContentType("application/octet-stream");
			fileOut.write(buffer);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				fis.close();
				fileOut.flush();
				fileOut.close();
			}catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}	
	

}
