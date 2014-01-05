package mgr.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mgr.entity.Dept;
import mgr.entity.User;
import mgr.service.DeptServiceImpl;
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
public class DeptAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private DeptServiceImpl deptService;

	private User user;

	private Dept dept;
	private Dept newDept;

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
			List<Dept> all = deptService.findAll();
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
					header.setCenter("部门表");
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
						Dept dept = all.get(i);
						row = sheet.createRow((short) (i + 1));
						row.setHeight((short) 400);
						cell = row.createCell(0);
						cell.setCellValue(dept.getDeptid());
						cell.setCellStyle(style);
						cell = row.createCell(1);
						cell.setCellValue(dept.getDeptname());
						cell.setCellStyle(style);
						cell = row.createCell(2);
						cell.setCellValue(dept.getDeptmgr());
						cell.setCellStyle(style);
						cell = row.createCell(3);
						cell.setCellValue(dept.getDeptparent());
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
				String headerStr = "客户";
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
			List<Dept> all = deptService.findAll();
			System.out.println("all= " + all);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String jsonparam = request.getParameter("jsonparam");
			System.out.println("jsonparam=" + jsonparam);
			JSONArray jsonArray = JSONArray.fromObject(jsonparam);

			int sEcho = 0;
			int iDisplayLength = 0;
			int iDisplayStart = 0;
			String sSearch = "";
			String searchDeptid = "";
			String searchDeptname = "";
			String searchDeptmgr = "";
			String searchDeptparent = "";
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
				} else if ("searchDeptid".equals(name)) {
					searchDeptid = value;
				} else if ("searchDeptname".equals(name)) {
					searchDeptname = value;
				} else if ("searchDeptmgr".equals(name)) {
					searchDeptmgr = value;
				} else if ("searchDeptparent".equals(name)) {
					searchDeptparent = value;
				}
			}
			JSONObject returnObject = new JSONObject();
			List<Dept> resultList = all;
			System.out
					.println("---------------------------------------------------------------------------------");
			System.out.println("search deptid=" + searchDeptid + ", deptname="
					+ searchDeptname + ", searchDeptmgr=" + searchDeptmgr
					+ ", searchDeptparent=" + searchDeptparent);
			List<Dept> searchList = new ArrayList<Dept>();
			for (int i = 0; i < all.size(); i++) {
				Dept dept = all.get(i);
				if (("".equals(searchDeptid) || dept.getDeptid().equals(
						searchDeptid))
						&& ("".equals(searchDeptname) || dept.getDeptname()
								.equals(searchDeptname))
						&& ("".equals(searchDeptmgr) || dept.getDeptmgr()
								.equals(searchDeptmgr))
						&& ("".equals(searchDeptparent) || dept.getDeptparent()
								.equals(searchDeptparent))) {
					searchList.add(dept);
				}
			}
			List<Dept> subSearchList = new ArrayList<Dept>();
			if (!("".equals(sSearch))) {
				System.out.println("二级查询...");
				for (int i = 0; i < all.size(); i++) {
					Dept dept = all.get(i);
					if (dept.getDeptid().contains(sSearch)
							|| dept.getDeptname().contains(sSearch)
							|| dept.getDeptmgr().contains(sSearch)
							|| dept.getDeptparent().contains(sSearch)) {
						subSearchList.add(dept);
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
			List<Dept> list = resultList.subList(iDisplayStart, iDisplayEnd);
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
	public JSONArray json(List<Dept> list) {
		JSONArray jsonDataArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Dept dept = list.get(i);
			Map map = new HashMap<String, Object>();
			map.put("deptid", dept.getDeptid());
			map.put("deptname", dept.getDeptname());
			map.put("deptmgr", dept.getDeptmgr());
			map.put("deptparent", dept.getDeptparent());
			map.put("id", dept.getId());
			jsonDataArray.add(map);
		}
		return jsonDataArray;
	}

	public String add() {
		System.out.println("add dept...");
		User user = (User) session.get("user");
		if (user == null) {
			addInfo = "登录超时，请重新登录操作";
		} else {
			try {
				deptService.add(dept);
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
		System.out.println("edit dept...");
		User user = (User) session.get("user");
		if (user == null) {
			editInfo = "登录超时，请重新登录后操作";
		} else {
			try {
				deptService.update(newDept);
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
		System.out.println("delete dept...");
		User user = (User) session.get("user");
		if (user == null) {
			deleteInfo = "登录超时，请重新登录后操作";
		} else {
			int index = Integer.valueOf(request.getParameter("index"));
			List<Dept> list = (List<Dept>) session.get("curlist");
			System.out.println("curlist=" + list + " index=" + index);
			if (list.size() != 0) {
				Dept dept = list.get(index);
				if (dept != null) {
					System.out.println("delete dept = " + dept);
					try {
						deptService.delete(dept);
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
	public DeptServiceImpl getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptServiceImpl deptService) {
		this.deptService = deptService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Dept getNewDept() {
		return newDept;
	}

	public void setNewDept(Dept newDept) {
		this.newDept = newDept;
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
