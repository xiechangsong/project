package com.api.utils;

import com.api.model.user.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

  
/** 
 * Excel工具类 
 * @author lp 
 * 
 */  
public class ReadExcel{
	//数字格式，防止长数字成为科学计数法形式，或者int变为double形式
	private static DecimalFormat df = new DecimalFormat("0");

	/**
	 * 导入学员信息批量创建学员用户
	 * @param file
	 * @param type
	 * @return
	 * @throws IOException
	 */
	public static List<User> createStudent(HttpServletRequest request, MultipartFile file, int type) throws Exception {
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		String rootPath = request.getSession().getServletContext().getRealPath("/upload/temp/");
		System.out.println("rootPath:"+rootPath);
		fileName = Common.fmtDateOn(new Date(),2) + suffixName;
		File tempFile = new File(rootPath + fileName);
		// 检测是否存在目录
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdirs();
		}
		file.transferTo(tempFile);
		InputStream is = null;
		User user = null;
		  List<User> list = new ArrayList<User>();
		  Workbook wb = null;
		  Sheet sheet = null;
		  Cell cell = null;
		  org.apache.poi.ss.usermodel.Row row = null;

		if (fileName.endsWith(".xls")){
			is = new FileInputStream(tempFile);
			 wb = (Workbook) new HSSFWorkbook(is);
		}else{
			is = new FileInputStream(tempFile);
			wb = (Workbook) new XSSFWorkbook(is);
		}
		    // 循环工作表Sheet
		    for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
		        sheet = wb.getSheetAt(numSheet);
		        if (sheet == null) {
		            continue;
		        }
		        // 循环行Row
		        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
		        	row = sheet.getRow(rowNum);
		            if (row != null) {
		                user = new User();
						Cell realName = row.getCell(0);
						Cell email = row.getCell(1);
						Cell phone = row.getCell(2);
						Cell age = row.getCell(3);
						Cell sex = row.getCell(4);
						String name= Common.converterToFirstSpell(getValue(realName).toString());
						user.setUserName(name);//用户名为真实姓名的拼音全拼
						user.setRealName(getValue(realName));
						String mobile=df.format(phone.getNumericCellValue()).toString();
						String passWord=mobile.substring(5,11);
						user.setPassWord(passWord,true);//密码默认为电话号码的后6位
						if ( null != email) {
							user.setEmail(getValue(email));
						}
						if (null != phone) {
							user.setPhone(df.format(phone.getNumericCellValue()));
						}
						if (null != age) {
							user.setAge(Integer.parseInt(df.format(age.getNumericCellValue())));
						}
						if (null != sex) {
							user.setSex(getValue(sex));
						}
					}
					user.setAddTime(new Date());
		            user.setUserType(0);
		            user.setStatus(0);
					list.add(user);
		            }
		        }
		//删除上传的临时文件
		if(tempFile.exists()){
			tempFile.delete();
		}
		return list;
}



public static void main(String[] args) {
	int[] arrViewCount = new int[] { 69, 70, 71, 72, 73, 74, 75, 76, 77 }; 
	int random=Integer.parseInt(Common.randomNumberString(0, 8));
	System.out.println(arrViewCount[random]);
}
 	@SuppressWarnings("static-access")
	private static String getValue(Cell hssfCell) {
		 Object inputValue = null;// 单元格值
		 if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			 // 返回布尔类型的值
			 return String.valueOf(hssfCell.getBooleanCellValue());

		 } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			 // 返回数值类型的值
			 long longVal = Math.round(hssfCell.getNumericCellValue());
			 double doubleVal=0;
			 if (Double.parseDouble(longVal + ".0") == doubleVal)
				 return String.valueOf(inputValue = longVal);
			 else
				 return String.valueOf(inputValue = doubleVal);
		 } else {
			 // 返回字符串类型的值
			 return String.valueOf(hssfCell.getStringCellValue());
		 }
	 }


    }     
