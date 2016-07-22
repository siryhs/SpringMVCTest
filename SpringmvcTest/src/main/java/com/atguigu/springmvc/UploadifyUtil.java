package com.atguigu.springmvc;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class UploadifyUtil {
	@RequestMapping("/pic")
	public void uploadExe(HttpServletRequest request, HttpServletResponse response){
		String savePath = request.getSession().getServletContext().getRealPath("upload");
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List<FileItem> fileList = null;
		try {
			fileList = upload.parseRequest(request);
			Iterator<FileItem> it = fileList.iterator();
			String name = "";
			String extName = "";
			while (it.hasNext()) {
				FileItem item = it.next();
				if (!item.isFormField()) {
					name = item.getName();
					long size = item.getSize();
					String type = item.getContentType();
					System.out.println(size + " " + type);
					if (name == null || name.trim().equals("")) {
						continue;
					}
					// 扩展名格式：
					if (name.lastIndexOf(".") >= 0) {
						extName = name.substring(name.lastIndexOf("."));
					}
					File file = null;
					do {
						name = UUID.randomUUID().toString();// 生成文件名：
						file = new File(savePath + name + extName);
					} while (file.exists());
					File saveFile = new File(savePath + File.separator + name + extName);
					item.write(saveFile);
				}
			}
			response.getWriter().print("123");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}