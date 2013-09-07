package de.eimantas.steuer.server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private TreeMap<String, Object> query;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside doPost");

		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
		// Create a new file upload handler
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		// sizeMax - The maximum allowed size, in bytes. The default value of -1
		// indicates, that there is no limit.
		// 1048576 bytes = 1024 Kilobytes = 1 Megabyte
		fileUpload.setSizeMax(1048576);

		if (!ServletFileUpload.isMultipartContent(request)) {
			try {
				System.out.println(request);
				throw new FileUploadException(
						"error multipart request not found");
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {

			List<FileItem> items = fileUpload.parseRequest(request);
			ServletFileUpload upload = new ServletFileUpload(); // from Commons

			FileItemIterator iter = upload.getItemIterator(request);

			if (items == null) {
				response.getWriter().write("File not correctly uploaded");
				return;
			}

			Iterator<FileItem> iter1 = items.iterator();

			while (iter.hasNext()) {

				// //////////////////////////////////////////////
				// http://commons.apache.org/fileupload/using.html
				// //////////////////////////////////////////////

				while (iter1.hasNext()) {

					FileItem item = iter1.next();
					String fileName = item.getName();
					System.out.println("fileName is : " + fileName);
					String typeMime = item.getContentType();
					System.out.println("typeMime is : " + typeMime);
					int sizeInBytes = (int) item.getSize();
					System.out.println("Size in bytes is : " + sizeInBytes);
					// byte[] file = item.get();
					item.write(new File("fileOutput.txt"));
				}

				FileItemStream fileItem = iter.next();

				// String name = fileItem.getFieldName(); // file name, if you
				// need it

				ServletOutputStream out = response.getOutputStream();
				response.setBufferSize(32768);
				int bufSize = response.getBufferSize();
				byte[] buffer = new byte[bufSize];

				InputStream in = fileItem.openStream();
				BufferedInputStream bis = new BufferedInputStream(in, bufSize);

				long length = 0;

				int bytes;
				while ((bytes = bis.read(buffer, 0, bufSize)) >= 0) {
					out.write(buffer, 0, bytes);
					length += bytes;
				}

				response.setContentType("text/html");
				response.setContentLength(length > 0
						&& length <= Integer.MAX_VALUE ? (int) length : 0);

				bis.close();
				in.close();
				out.flush();
				out.close();
			}

			PrintWriter out = response.getWriter();
			response.setHeader("Content-Type", "text/html");
			out.println("Upload OK");
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			response.setHeader("Content-Type", "text/html");
			out.println("Error");
			out.flush();
			out.close();
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}