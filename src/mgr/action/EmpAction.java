package mgr.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mgr.entity.Emp;
import mgr.entity.User;
import mgr.service.EmpServiceImpl;
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
public class EmpAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private EmpServiceImpl empService;

	private String addInfo;
	private String listInfo;
	private String editInfo;
	private String deleteInfo;
	private String exportInfo;
	private String countInfo;

	private User user;
	private Emp emp;
	private Emp editEmp;
	private Emp newEmp;

	public String export() {
		System.out.println("export...");
		try {
			user = (User) session.get("user");
			if (user == null) {
				setMessage("SendStatus", "您的操作超时，请登录后重试。");
				return "Error";
			}
			List<Emp> all = empService.findAll();
			System.out.println("list= " + all);
			System.out
					.println("----------------------------------------------------------------");
			String[] tableHeader = { "员工工号", "员工姓名", "身份证号", "籍贯", "所属部门",
					"岗位", "手机号码", "出生日期", "性别", "学历", "QQ", "技能", "紧急联系人",
					"联系人电话", "住址", "入职日期", "合同期限" };
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
					header.setCenter("员工表");
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
						Emp emp = all.get(i);
						row = sheet.createRow((short) (i + 1));
						row.setHeight((short) 400);
						cell = row.createCell(0);
						cell.setCellValue(emp.getEmpid());
						cell.setCellStyle(style);
						cell = row.createCell(1);
						cell.setCellValue(emp.getEmpname());
						cell.setCellStyle(style);
						cell = row.createCell(2);
						cell.setCellValue(emp.getIcid());
						cell.setCellStyle(style);
						cell = row.createCell(3);
						cell.setCellValue(emp.getEplace());
						cell.setCellStyle(style);
						cell = row.createCell(4);
						cell.setCellValue(emp.getDeptid());
						cell.setCellStyle(style);
						cell = row.createCell(5);
						cell.setCellValue(emp.getEmppost());
						cell.setCellStyle(style);
						cell = row.createCell(6);
						cell.setCellValue(emp.getEmpphone());
						cell.setCellStyle(style);
						cell = row.createCell(7);
						cell.setCellValue(emp.getEmpbirth());
						cell.setCellStyle(style);
						cell = row.createCell(8);
						cell.setCellValue(emp.getEmpsex());
						cell.setCellStyle(style);
						cell = row.createCell(9);
						cell.setCellValue(emp.getEmpedu());
						cell.setCellStyle(style);
						cell = row.createCell(10);
						cell.setCellValue(emp.getEmpqq());
						cell.setCellStyle(style);
						cell = row.createCell(11);
						cell.setCellValue(emp.getEmptech());
						cell.setCellStyle(style);
						cell = row.createCell(12);
						cell.setCellValue(emp.getElinkman());
						cell.setCellStyle(style);
						cell = row.createCell(13);
						cell.setCellValue(emp.getElinkphone());
						cell.setCellStyle(style);
						cell = row.createCell(14);
						cell.setCellValue(emp.getEmpaddr());
						cell.setCellStyle(style);
						cell = row.createCell(15);
						cell.setCellValue(emp.getEmpin());
						cell.setCellStyle(style);
						cell = row.createCell(16);
						cell.setCellValue(emp.getEmpout());
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
				String headerStr = "员工";
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

	public String add() {
		System.out.println("add...");
		System.out.println("emp=" + emp);
		if (emp != null) {
			try {
				empService.add(emp);
				addInfo = "AddSuccess";
			} catch (Exception e) {
				addInfo = "Error";
				e.printStackTrace();
			}
		} else {
			addInfo = "请求超时，请重新登陆后操作。";
		}
		System.out.println("addInfo=" + addInfo);
		return "AddInfo";
	}

	@SuppressWarnings("unchecked")
	public String toedit() {
		System.out.println("to edit...");
		List<Emp> list = (List<Emp>) session.get("curlist");
		int index = Integer.valueOf(request.getParameter("index"));
		if (list.size() != 0) {
			System.out.println("put edit emp...");
			editEmp = list.get(index);
			session.remove("editEmp");
			session.put("editEmp", editEmp);
			System.out.println("editEmp=" + editEmp);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String delete() {
		System.out.println("delete...");
		List<Emp> list = (List<Emp>) session.get("curlist");
		int index = Integer.valueOf(request.getParameter("index"));
		if (list.size() != 0) {
			Emp emp = list.get(index);
			if (emp != null) {
				System.out.println("deleteemp=" + emp);
				try {
					empService.delete(emp);
					deleteInfo = "DeleteSuccess";
				} catch (Exception e) {
					deleteInfo = "Error";
					e.printStackTrace();
				}
			}
		}
		return "DeleteInfo";
	}

	public String edit() {
		System.out.println("edit...");
		try {
			if (newEmp != null) {
				empService.modify(newEmp);
				session.remove("editEmp");
				editInfo = "EditSuccess";
			}
		} catch (Exception e) {
			editInfo = "Error";
			e.printStackTrace();
		}
		System.out.println("editInfo=" + editInfo);
		return "EditInfo";
	}

	public String list() {
		System.out.println("list...");
		try {
			user = (User) session.get("user");
			if (user == null) {
				setMessage("SendStatus", "您的操作超时，请登录后重试。");
				return "Error";
			}
			List<Emp> all = empService.findAll();
			System.out.println("list= " + all);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String jsonparam = request.getParameter("jsonparam");
			System.out.println("jsonparam=" + jsonparam);
			JSONArray jsonArray = JSONArray.fromObject(jsonparam);

			int sEcho = 0;
			int iDisplayLength = 0;
			int iDisplayStart = 0;
			String sSearch = "";
			String searchEmpid = "";
			String searchEmpname = "";
			String searchDeptid = "";
			String searchIcid = "";
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
				} else if ("searchEmpid".equals(name)) {
					searchEmpid = value;
				} else if ("searchEmpname".equals(name)) {
					searchEmpname = value;
				} else if ("searchDeptid".equals(name)) {
					searchDeptid = value;
				} else if ("searchIcid".equals(name)) {
					searchIcid = value;
				}
			}
			JSONObject returnObject = new JSONObject();
			List<Emp> resultList = all;
			System.out
					.println("---------------------------------------------------------------------------------");
			System.out.println("search searchEmpid=" + searchEmpid
					+ ", searchEmpname=" + searchEmpname + ", searchIcid="
					+ searchIcid + ", searchDeptid=" + searchDeptid);
			List<Emp> searchList = new ArrayList<Emp>();
			for (int i = 0; i < all.size(); i++) {
				Emp emp = all.get(i);
				if (("".equals(searchDeptid) || emp.getDeptid().equals(
						searchDeptid))
						&& ("".equals(searchEmpid) || emp.getEmpid().equals(
								searchEmpid))
						&& ("".equals(searchEmpname) || emp.getEmpname()
								.equals(searchEmpname))
						&& ("".equals(searchIcid) || emp.getIcid().equals(
								searchIcid))) {
					searchList.add(emp);
				}
			}
			System.out.println("searchlist=" + searchList);
			List<Emp> subSearchList = new ArrayList<Emp>();
			if (!("".equals(sSearch))) {
				System.out.println("二级查询...");
				for (int i = 0; i < all.size(); i++) {
					Emp emp = all.get(i);
					if (emp.getDeptid().contains(sSearch)
							|| emp.getEmpid().contains(sSearch)
							|| emp.getEmpname().contains(sSearch)
							|| emp.getIcid().contains(sSearch)) {
						subSearchList.add(emp);
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
			List<Emp> list = resultList.subList(iDisplayStart, iDisplayEnd);
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
	public JSONArray json(List<Emp> list) {
		JSONArray jsonDataArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Emp emp = list.get(i);
			Map map = new HashMap<String, Object>();
			map.put("empid", emp.getEmpid());
			map.put("empname", emp.getEmpname());
			map.put("icid", emp.getIcid());
			map.put("deptid", emp.getDeptid());
			map.put("emppost", emp.getEmppost());
			map.put("eplace", emp.getEplace());
			map.put("empphone", emp.getEmpphone());
			map.put("empbirth", emp.getEmpbirth());
			map.put("empsex", emp.getEmpsex());
			map.put("empedu", emp.getEmpedu());
			map.put("empqq", emp.getEmpqq());
			map.put("emptech", emp.getEmptech());
			map.put("elinkman", emp.getElinkman());
			map.put("elinkphone", emp.getElinkphone());
			map.put("empaddr", emp.getEmpaddr());
			map.put("empin", emp.getEmpin());
			map.put("empout", emp.getEmpout());
			map.put("id", emp.getId());
			jsonDataArray.add(map);
		}
		return jsonDataArray;
	}

	@JSON(serialize = false)
	public EmpServiceImpl getEmpService() {
		return empService;
	}

	public void setEmpService(EmpServiceImpl empService) {
		this.empService = empService;
	}

	public String getListInfo() {
		return listInfo;
	}

	public void setListInfo(String listInfo) {
		this.listInfo = listInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Emp getEditEmp() {
		return editEmp;
	}

	public void setEditEmp(Emp editEmp) {
		this.editEmp = editEmp;
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

	public String getCountInfo() {
		return countInfo;
	}

	public void setCountInfo(String countInfo) {
		this.countInfo = countInfo;
	}

	public Emp getNewEmp() {
		return newEmp;
	}

	public void setNewEmp(Emp newEmp) {
		this.newEmp = newEmp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
