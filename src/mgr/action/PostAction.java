package mgr.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mgr.entity.Post;
import mgr.entity.User;
import mgr.service.PostServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

@Component
public class PostAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private PostServiceImpl postService;

	private User user;

	private Post post;
	private Post newPost;

	private String addInfo;
	private String editInfo;
	private String deleteInfo;
	private String exportInfo;

	public String export() {
		System.out.println("export...");
		try {
			user = (User) session.get("user");
			if (user == null) {
				setMessage("SendStatus", "您的操作超时，请登录后重试。");
				return "Error";
			}
			List<Post> all = postService.findAll();
			System.out.println("all= " + all);
			System.out
					.println("----------------------------------------------------------------");
			String[] tableHeader = { "部门编号", "部门名称", "部门经理", "上级部门" };
			short cellNumber = (short) tableHeader.length;
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCell cell = null;
			HSSFRow row = null;
			HSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style1 = workbook.createCellStyle();
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFFont font = workbook.createFont();
			HSSFSheet sheet = workbook.createSheet("sheet1");
			HSSFHeader header = sheet.getHeader();
			try {
				if (all.size() < 1) {
					header.setCenter("查无资料");
				} else {
					header.setCenter("客户表");
					row = sheet.createRow(0);
					row.setHeight((short) 400);
					for (int k = 0; k < cellNumber; k++) {
						cell = row.createCell(k);
						cell.setCellValue(tableHeader[k]);
						sheet.setColumnWidth(k, 8000);
						font.setColor(HSSFFont.COLOR_NORMAL);
						font.setFontHeight((short) 350);
						style1.setFont(font);
						cell.setCellStyle(style1);
					}

					for (int i = 0; i < all.size(); i++) {
						Post post = all.get(i);
						row = sheet.createRow((short) (i + 1));
						row.setHeight((short) 400);
						cell = row.createCell(0);
						cell.setCellValue(post.getPostid());
						cell.setCellStyle(style);
						cell = row.createCell(1);
						cell.setCellValue(post.getDeptid());
						cell.setCellStyle(style);
						cell = row.createCell(2);
						cell.setCellValue(post.getPostname());
						cell.setCellStyle(style);
						cell = row.createCell(3);
						cell.setCellValue(post.getPostctn());
						cell.setCellStyle(style);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			HttpServletResponse response = null;
			OutputStream out = null;
			try {
				response = ServletActionContext.getResponse();
				out = response.getOutputStream();
				String headerStr = "岗位表";
				headerStr = new String(headerStr.getBytes("gb2312"),
						"ISO8859-1");
				response.setHeader("Content-disposition",
						"attachment; filename=" + headerStr + ".xls");
				response.setContentType("application/msexcel;charset=UTF-8");
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				workbook.write(out);
				out.flush();
				workbook.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null) {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out
					.println("----------------------------------------------------------------");
		} catch (Exception e) {
			exportInfo = "Error";
		}
		System.out.println("exportInfo=" + exportInfo);
		return null;
	}

	public String list() {
		System.out.println("list...");
		try {
			user = (User) session.get("user");
			if (user == null) {
				setMessage("SendStatus", "您的操作超时，请登录后重试。");
				return "Error";
			}
			List<Post> all = postService.findAll();
			System.out.println("all= " + all);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String jsonpost = request.getParameter("jsonpost");
			System.out.println("jsonpost=" + jsonpost);
			JSONArray jsonArray = JSONArray.fromObject(jsonpost);

			int sEcho = 0;
			int iDisplayLength = 0;
			int iDisplayStart = 0;
			String sSearch = "";
			String searchPostid = "";
			String searchPostname = "";
			String searchPostctn = "";
			String searchPostdeptid = "";
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				String name = obj.getString("name");
				String value = obj.getString("value");
				if ("sEcho".equals(name)) {
					sEcho = Integer.valueOf(value);
				} else if ("iDisplayStart".equals(name)) {
					iDisplayStart = Integer.valueOf(value);
				} else if ("iDisplayLength".equals(name)) {
					iDisplayLength = Integer.valueOf(value);
				} else if ("sSearch".equals(name)) {
					sSearch = value;
				} else if ("searchPostid".equals(name)) {
					searchPostid = value;
				} else if ("searchPostname".equals(name)) {
					searchPostname = value;
				} else if ("searchPostctn".equals(name)) {
					searchPostctn = value;
				} else if ("searchPostdeptid".equals(name)) {
					searchPostdeptid = value;
				}
			}
			JSONObject returnObject = new JSONObject();
			List<Post> resultList = all;
			System.out
					.println("---------------------------------------------------------------------------------");
			System.out.println("search searchPostid=" + searchPostid
					+ ", searchPostname=" + searchPostname + ", searchPostctn="
					+ searchPostctn + ", searchPostdeptid=" + searchPostdeptid);
			List<Post> searchList = new ArrayList<Post>();
			for (int i = 0; i < all.size(); i++) {
				Post post = all.get(i);
				if (("".equals(searchPostid) || post.getPostid().equals(
						searchPostid))
						&& ("".equals(searchPostname) || post.getPostname()
								.equals(searchPostname))
						&& ("".equals(searchPostctn) || post.getPostctn()
								.equals(searchPostctn))
						&& ("".equals(searchPostdeptid) || post.getDeptid()
								.equals(searchPostdeptid))) {
					searchList.add(post);
				}
			}
			List<Post> subSearchList = new ArrayList<Post>();
			if (!("".equals(sSearch))) {
				System.out.println("二级查询...");
				for (int i = 0; i < all.size(); i++) {
					Post post = all.get(i);
					if (post.getPostid().contains(sSearch)
							|| post.getPostname().contains(sSearch)
							|| post.getPostctn().contains(sSearch)
							|| post.getDeptid().contains(sSearch)) {
						subSearchList.add(post);
					}
				}
			} else {
				subSearchList = searchList;
			}
			resultList = subSearchList;
			System.out.println("searchlist=" + subSearchList);
			int iDisplayEnd = iDisplayLength < (resultList.size() - iDisplayStart) ? (iDisplayStart + iDisplayLength)
					: resultList.size();
			System.out.println("index from " + iDisplayStart + " to "
					+ iDisplayEnd);
			List<Post> list = resultList.subList(iDisplayStart, iDisplayEnd);
			session.put("curlist", list);
			returnObject.put("sEcho", sEcho);
			returnObject.put("iTotalRecords", resultList.size());
			returnObject.put("iTotalDisplayRecords", resultList.size());
			returnObject.put("aaData", json(list));

			String returnString = returnObject.toString();
			response.setContentType("text/plain; charset=utf-8");
			response.getWriter().print(returnString);
			response.flushBuffer();
			response.getWriter().close();
			System.out.println("resultString : " + returnString);
			System.out
					.println("---------------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public JSONArray json(List<Post> list) {
		JSONArray jsonDataArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Post post = list.get(i);
			Map map = new HashMap<String, Object>();
			map.put("postid", post.getPostid());
			map.put("postname", post.getPostname());
			map.put("postctn", post.getPostctn());
			map.put("postdeptid", post.getDeptid());
			map.put("id", post.getId());
			jsonDataArray.add(map);
		}
		return jsonDataArray;
	}

	public String add() {
		System.out.println("add post...");
		User user = (User) session.get("user");
		if (user == null) {
			addInfo = "登录超时，请重新登录操作";
		} else {
			try {
				postService.add(post);
				addInfo = "AddSuccess";
			} catch (Exception e) {
				addInfo = "Error";
				e.printStackTrace();
			}
		}
		System.out.println("addInfo=" + addInfo);
		return "AddInfo";
	}

	public String edit() {
		System.out.println("edit post...");
		User user = (User) session.get("user");
		if (user == null) {
			editInfo = "登录超时，请重新登录后操作";
		} else {
			try {
				postService.update(newPost);
				editInfo = "EditSuccess";
			} catch (Exception e) {
				editInfo = "Error";
				e.printStackTrace();
			}
		}
		System.out.println("editInfo=" + editInfo);
		return "EditInfo";
	}

	@SuppressWarnings("unchecked")
	public String delete() {
		System.out.println("delete post...");
		User user = (User) session.get("user");
		if (user == null) {
			deleteInfo = "登录超时，请重新登录后操作";
		} else {
			int index = Integer.valueOf(request.getParameter("index"));
			List<Post> list = (List<Post>) session.get("curlist");
			System.out.println("curlist=" + list + " index=" + index);
			if (list.size() != 0) {
				Post post = list.get(index);
				if (post != null) {
					System.out.println("delete dept = " + post);
					try {
						postService.delete(post);
						deleteInfo = "DeleteSuccess";
					} catch (Exception e) {
						deleteInfo = "Error";
						e.printStackTrace();
					}
				}
			}

		}
		System.out.println("deleteInfo=" + deleteInfo);
		return "DeleteInfo";
	}

	@JSON(serialize = false)
	public PostServiceImpl getPostService() {
		return postService;
	}

	public void setPostService(PostServiceImpl postService) {
		this.postService = postService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Post getNewPost() {
		return newPost;
	}

	public void setNewPost(Post newPost) {
		this.newPost = newPost;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	public String getEditInfo() {
		return editInfo;
	}

	public void setEditInfo(String editInfo) {
		this.editInfo = editInfo;
	}

	public String getDeleteInfo() {
		return deleteInfo;
	}

	public void setDeleteInfo(String deleteInfo) {
		this.deleteInfo = deleteInfo;
	}

	public String getExportInfo() {
		return exportInfo;
	}

	public void setExportInfo(String exportInfo) {
		this.exportInfo = exportInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
