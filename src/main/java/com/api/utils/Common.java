package com.api.utils;

import com.alibaba.fastjson.JSON;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.StringUtils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;


/*** 通用工具类 */
public class Common {
	private final static Logger logger= LoggerFactory.getLogger(Common.class);
	/** * 通用时间格式1 */
	public static SimpleDateFormat FMT_DATE_1 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	/** * 通用时间格式2 */
	public static SimpleDateFormat FMT_DATE_2 = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	/** * 通用时间格式3 */
	public static SimpleDateFormat FMT_DATE_3 = new SimpleDateFormat(
			"yyyy-MM-dd");
	/*** 通用时间格式4 */
	public static SimpleDateFormat FMT_DATE_4 = new SimpleDateFormat("MM-dd");
	/*** 通用时间格式5 */
	public static SimpleDateFormat FMT_DATE_5 = new SimpleDateFormat(
			"MM-dd HH:mm");
	/*** 通用时间格式6 */
	public static SimpleDateFormat FMT_DATE_6 = new SimpleDateFormat(
			"yyyy年MM月dd日 HH时mm分ss秒");
	/*** 通用时间格式7 */
	public static SimpleDateFormat FMT_DATE_7 = new SimpleDateFormat(
			"MM月dd日 HH:mm");
	/*** 通用时间格式8 */
	public static SimpleDateFormat FMT_DATE_8 = new SimpleDateFormat(
			"HH时mm分ss秒");
	/*** 通用时间格式8 */
	public static SimpleDateFormat FMT_DATE_9 = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm:ss");

	public static boolean isEmptyOrNull(Object obj) {
		if (obj == null)
			return true;
		if (((String) obj).length() == 0)
			return true;
		return false;
	}


	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	public static Result upload(HttpServletRequest request, MultipartFile file, Integer type) {
		if (file.isEmpty()) {
			return ResultUtil.ERROR(ResultEnum.FILE_UPLOAD_FAILED.getCode(),ResultEnum.FILE_UPLOAD_FAILED.getMsg());//文件上传失败
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		// 文件上传后的路径
		String fileUploadAddress= null;//上传文件地址
		if (type == 0) {
			fileUploadAddress = "text/"+fmtDateOn(new Date(),3) +"/";
		}else if (type == 1) {
			fileUploadAddress = "video/"+fmtDateOn(new Date(),3) +"/";
		}else if (type == 2) {
			fileUploadAddress = "images/"+fmtDateOn(new Date(),3) +"/";
		}
		//服务器上传地址
		String rootPath = request.getSession().getServletContext().getRealPath("/upload/"+fileUploadAddress);
		System.out.println("rootPath:"+rootPath);
		fileName = fmtDateOn(new Date(),2) + suffixName;
		File dest = new File(rootPath +"/" + fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			Map<Object,String> map = new HashMap<>();
			map.put("fileAddress",fileUploadAddress);
			map.put("fileName",fileName);
			Result res=new Result();
			res.setData( map );

			return ResultUtil.SUCCESS(ResultEnum.SUCCESS,res);//文件上传失败
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResultUtil.ERROR(ResultEnum.FILE_UPLOAD_FAILED.getCode(),ResultEnum.FILE_UPLOAD_FAILED.getMsg());//文件上传失败
	}
	/**
	 *	获得项目根目录
	 */
	private static String getProjectRootDirPath(HttpServletRequest request){
		return request.getSession().getServletContext().getRealPath("/");

	}
	/**
	 * 获取文件保存的路径
	 * @param request
	 * @param ext 文件后缀
	 * @param param 传入参数
	 * @return 返回文件路径
	 */
	private String getPath(HttpServletRequest request, String ext, String param){
		String filePath = "/upload/";
		if(param!=null && param.trim().length()>0){
			filePath+=param;
		}else{
			filePath+= CommonConstants.projectName;
		}
		filePath+="/"+ DateUtils.toString(new Date(), "yyyyMMdd")+"/"+System.currentTimeMillis()+"."+ext;
		return filePath;
	}
	/*** 创建18位订单号 */
	public static String createOrderNo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(new Date());
		String code = time.substring(2, 14) + (int) (100000 + Math.random() * (999999 - 100000 + 1));
		return code;
	}

	/*** 创建一个随机数，指定大小值 */
	public static int randomNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	/*** 创建一个String类型随机数，指定大小值 */
	public static String randomNumberString(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1)) + "";
	}

	/*** MD5加密 */
	public static String MD5(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
			return "";
		}
	}

	/*** 比较2个日期的大小 */
	public static int compareDate(Date d1, Date d2) {
		if (d1.getTime() > d2.getTime()) {
			return 1;
		} else if (d1.getTime() < d2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}

	/*** 计算2个日期相差天数 */
	public static Integer diffDay(Date d1, Date d2) {
		if (d2 == null) {
			d2 = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		long time1 = 0l;
		long time2 = 0l;
		try {
			time1 = sdf.parse(sdf.format(cal.getTime())).getTime();
			cal.setTime(d2);
			time2 = sdf.parse(sdf.format(cal.getTime())).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/*** 获取和指定日期相差的日期 */
	public static Date getDateOnDay(Date targetDate, Integer days) {
		if (targetDate == null) {
			targetDate = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(targetDate);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/*** 在某个日期上加多少月 */
	public static Date getDateOnMonth(Date targetDate, Integer months) {
		if (targetDate == null) {
			targetDate = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(targetDate);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}
	/*** 格式化日期，通过指定的方式类型 */
	public static String fmtDateOn(Date date, Integer fType) {
		if (date == null) {
			return "";
		}
		if (1 == fType) {
			return Common.FMT_DATE_1.format(date);
		} else if (2 == fType) {
			return Common.FMT_DATE_2.format(date);
		} else if (3 == fType) {
			return Common.FMT_DATE_3.format(date);
		} else if (4 == fType) {
			return Common.FMT_DATE_4.format(date);
		} else if (5 == fType) {
			return Common.FMT_DATE_5.format(date);
		} else if (6 == fType) {
			return Common.FMT_DATE_6.format(date);
		} else if (7 == fType) {
			return Common.FMT_DATE_7.format(date);
		} else if (8 == fType) {
			return Common.FMT_DATE_8.format(date);
		} else if (9 == fType) {
			return Common.FMT_DATE_9.format(date);
		}
		return Common.FMT_DATE_1.format(date);
	}
	
	public static String fmtDate(Date date) {
		if (date == null) {
			return "";
		}
		return Common.FMT_DATE_1.format(date);
	}

	// Double定义格式转成string
	public static String fmtAmount(Double str) {
		DecimalFormat b = new DecimalFormat();
		b.applyPattern(",##0.00");
		b.setRoundingMode(RoundingMode.FLOOR); // 不四舍五入
		return b.format(str);
	}
	public static String fmtAmount2(Double str){
		DecimalFormat b = new DecimalFormat();
		b.applyPattern(",##0.0");
		b.setRoundingMode(RoundingMode.FLOOR); // 不四舍五入
		return b.format(str);
	}

	/*** 页面上根据相关状态显示value */
	public static String show(Integer key, Map<Integer, Object> map) {
		if (map == null) {
			return "";
		}
		return map.get(key) + "";
	}

	public static String showStr(String key, Map<String, Object> map) {
		if (map == null) {
			return "";
		}
		return map.get(key) + "";
	}

	/*** 从Map对象中获取指定值 */
	public static String mapValue(Map<String, String> map, String name) {
		if (map == null) {
			return "";
		}
		return map.get(name);
	}

	/*** 字符串显示长度  start：显示长度  length:*号长度    hideChar：代替字符     */   
	public static String hide(String str, Integer start, Integer length,String hideChar) {
		if(length==0){//如果length=0的话。默认将整个字符串替换为*符号
			String st=str.replaceAll(str, "******");
			return st;
		}
		if (Common.isEmptyOrNull(hideChar)) {
			hideChar = "*";
		}
		
		if (str.length() < start) {
			return str;
		}
		if (str.length() < start + length) {
			if (str.length() == 2) {
				StringBuffer sb = new StringBuffer(str);
				return sb.replace(start, start + length, "*").toString();
			}
			return str;
		}
		StringBuffer sb = new StringBuffer(str);
		int n = length;
		StringBuffer hideCharSB = new StringBuffer();
		while (n > 0) {
			n--;
			hideCharSB.append(hideChar);
		}
		int value = start + length;
		return sb.replace(start, value, hideCharSB.toString()).toString();
	}

	/*** 多选框选中 */
	@SuppressWarnings("unchecked")
	public static Boolean inArray(Object obj, List array) {
		if (array == null) {
			return false;
		}
		for (Object arr : array) {
			if (arr.equals(obj)) {
				return true;
			}
		}
		return false;
	}


	/*** 构造URL查询字符串 */
	public static String queryParams(Map<String, String> qParam, String qName,String qValue) {
		if (qParam == null) {
			return "";
		}
		List<String> ps = new LinkedList<String>();
		String name = null;
		String value = null;
		Iterator<String> next = qParam.keySet().iterator();
		while (next.hasNext()) {
			name = next.next();
			value = qParam.get(name);
			if (name.equals(qName)) {
				if (StringUtils.isNullOrEmpty(qValue)) {
					continue;
				}
				value = qValue;
			}
			if (StringUtils.isNullOrEmpty(value)) {
				continue;
			}
			try {
				ps.add(URLEncoder.encode(name, "UTF-8") + "="
						+ URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return Common.implode("&", ps.toArray(new String[ps.size()]));
	}

	/** 将指定字符串数组，按指定分隔符拼接 */
	public static String implode(String separator, String... data) {
		if (data == null)
			return "";
		if (data.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length - 1; i++) {
			if (!data[i].matches(" *")) {
				sb.append(data[i]);
				sb.append(separator);
			}
		}
		sb.append(data[data.length - 1]);
		return sb.toString();
	}

	/*** 获取两个数值的百分比 */
	public static double percent(Double d1, Double d2) {
		return ((int) (d1 / d2 * 10000)) / 100d;
	}



	/*** 截取String字符串中图片路径对象 */
	public static String getImgUrl(String str) {
		String[] s = str.split("uploads");
		String imgUrl = "images/zhuce_icon.png";
		if (s.length >= 2) {
			if (s[1].split("alt")[0].split("png").length >= 2) {
				imgUrl = "uploads" + s[1].split("alt")[0].split("png")[0] + "png";
			} else if (s[1].split("alt")[0].split("PNG").length >= 2) {
				imgUrl = "uploads" + s[1].split("alt")[0].split("PNG")[0] + "PNG";
			} else if (s[1].split("alt")[0].split("jpg").length >= 2) {
				imgUrl = "uploads" + s[1].split("alt")[0].split("jpg")[0] + "jpg";
			} else if (s[1].split("alt")[0].split("JPG").length >= 2) {
				imgUrl = "uploads" + s[1].split("alt")[0].split("JPG")[0] + "JPG";
			}
		}else if(str.split("<img src=\\\\\"").length >= 2){
			imgUrl = str.split("<img src=\\\\\"")[1].split("\\\\\"")[0];
		}
		return imgUrl;
	}
	
	/***String转换成MAP*/
	public static Map<Integer, String> str2map(String str,String symbol) {
		String[] array = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		if(!Common.isEmptyOrNull(str)){
			array = str.split(symbol);
			for (int i = 0; i < array.length; i++) {
				map.put(i, array[i]);
			}
		}
		return map;
	}

	
	

	/** 将指定金额转为大写 */
	public static String changeToBig(double value) {
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		long midVal = (long) (value * 100); // 转化成整形
		String valStr = String.valueOf(midVal); // 转化成字符串
		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分
		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果
		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		boolean preZero = false; // 标志当前位的上一位是否为有效0位（如万位的0对千位无效）
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') { // 如果当前字符是0
				preZero = true;
				zeroSerNum++; // 连续0次数递增
				if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					preZero = false; // 不管上一位是否为0，置为无效0位
				}
			} else {
				zeroSerNum = 0; // 连续0次数清零
				if (preZero) { // 上一位为有效0位
					prefix += digit[0]; // 只有在这地方用到'零'
					preZero = false;
				}
				prefix += digit[chDig[i] - '0']; // 转化该数字表示
				if (idx > 0)
					prefix += hunit[idx - 1];
				if (idx == 0 && vidx > 0) {
					prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
				}
			}
		}
		if (prefix.length() > 0)
			prefix += '圆'; // 如果整数部分存在,则有圆的字样
		return prefix + suffix; // 返回正确表示
	}
	/*** 首字母大写 */
	public static String ucfirst(String str) {
		return str.replaceFirst(str.substring(0, 1), str.substring(0, 1)
				.toUpperCase());
	}
	/*** 直接舍去,保留两位小数 */
	public static double fixAmount1(double val) {
		return ((int) (val * 100)) / 100d;
	}

	/*** string转double */
	public static double parseDouble(String val) {
		if (Common.isEmptyOrNull(val)) {
			return 0;
		}
		try {
			return Double.parseDouble(val);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}



	/*** 深度拷贝POJO对象 */
	public static Object copyObject(Object objSource)
			throws IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		// 获取源对象类型
		Class<?> clazz = objSource.getClass();
		// 获取源对象构造函数
		Constructor<?> construtctor = clazz.getConstructor();
		// 实例化出目标对象
		Object objDes = construtctor.newInstance();
		// 获得源对象所有属性
		Field[] fields = clazz.getDeclaredFields();
		// 遍历所有属性
		for (int i = 0; i < fields.length; i++) {
			// 属性对象
			Field field = fields[i];
			// 属性名
			String fieldName = field.getName();
			// 获取属性首字母
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			// 拼接get方法名如getName
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			// 得到get方法对象
			Method getMethod = clazz.getMethod(getMethodName);
			// 对源对象调用get方法获取属性值
			Object value = getMethod.invoke(objSource);
			// 拼接set方法名
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			// 获取set方法对象
			Method setMethod = clazz.getMethod(setMethodName,
					new Class[] { field.getType() });
			// 对目标对象调用set方法装入属性值
			setMethod.invoke(objDes, new Object[] { value });
		}
		return objDes;
	}

	/*** 时间戳转换成日期格式字符串 seconds精确到秒的字符串 */
	public static String timeStamp2Date(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty()) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	/*** 日期格式字符串转换成时间戳 date_str字符串日期 */
	public static String date2TimeStamp(String date_str, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return String.valueOf(sdf.parse(date_str).getTime() / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/*** 取得当前时间戳（精确到秒） */
	public static String timeStamp() {
		long time = System.currentTimeMillis();
		String t = String.valueOf(time / 1000);
		return t;
	}

	/*** String */
	public static String valiIsNull(Object ob) {
		return ob == null ? "" : ob.toString();
	}

	/*** Integer */
	public static Integer validaIsNullInteger(Object ob) {
		if (ob == null || ob.toString().equals("")) {
			return 0;
		}
		return (int)Common.parseDouble(ob.toString());
	}

	/**
	 * 将string转换成date
	 */
	public static Date strToDateLong(String strDate,int type) {
		SimpleDateFormat formatter=null;
		if (type == 1 ){
			formatter = new SimpleDateFormat("yyyy-MM-dd");
		}else
		{
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}

		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}


	/*** 两个时间的秒数差 */
	public static String testTimeDate(Date d1, Date d2) {
		long diff = d1.getTime() - d2.getTime();
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数long diff;try {
		// 获得两个时间的毫秒时间差异
		// diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
		// long day = diff/nd;//计算差多少天
		long hour = diff % nd / nh;// 计算差多少小时
		long min = diff % nd % nh / nm;// 计算差多少分钟
		long sec = diff % nd % nh % nm / ns;// 计算差多少秒//输出结果
		System.out.println("时间相差：" + hour + "小时" + min + "分钟" + sec + "秒。");
		return hour + "时" + min + "分" + sec + "秒";
		// return "00";
	}
	/**  
	 * @param(显示类型)
     * 得到当前日期  
     * @return  
     */ 
    public static String getCurrentDate(String fomt) {  
        Calendar c = Calendar.getInstance();  
        Date date = c.getTime();  
        SimpleDateFormat simple = new SimpleDateFormat();  
        return simple.format(date);  
    }
    /**  
     * 得到当前日期  
     * @return  
     */ 
    public static String getCurrentDate() {  
        Calendar c = Calendar.getInstance();  
        Date date = c.getTime();  
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");  
        return simple.format(date);  
 
    }  
	/**  
     * @param date1 需要比较的时间 不能为空(null),需要正确的日期格式  
     * @param date2 被比较的时间  为空(null)则为当前时间  
     * @param stype 返回值类型   0为多少天，1为多少个月，2为多少年  
     * @return  
     */ 
    public static Integer calendarDate(String date1,String date2,Integer stype){  
    	 int n = 0;  
         
         String[] u = {"天","月","年"};  
         String formatStyle = stype==1?"yyyy-MM":"yyyy-MM-dd";  
            
         date2 = date2==null?getCurrentDate():date2;  
            
         DateFormat df = new SimpleDateFormat(formatStyle);  
         Calendar c1 = Calendar.getInstance();  
         Calendar c2 = Calendar.getInstance();  
         try {  
             c1.setTime(df.parse(date1));  
             c2.setTime(df.parse(date2));  
         } catch (Exception e3) {  
             System.out.println("wrong occured");  
         }  
         //List list = new ArrayList();  
         while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果  
             //list.add(df.format(c1.getTime()));    // 这里可以把间隔的日期存到数组中 打印出来  
             n++;  
             if(stype==1){  
                 c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1  
             }  
             else{  
                 c1.add(Calendar.DATE, 1);           // 比较天数，日期+1  
             }  
         }  
            
         n = n-1;  
            
         if(stype==2){  
             n = (int)n/365;  
         }     
            
              
         return n;  
    }  

    /**
	 * get方式
	 * @param url
	 * @author www.yoodb.com
	 * @return
	 */
	public static String getHttp(String url) {
		String responseMsg = "";
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
		try {
			httpClient.executeMethod(getMethod);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InputStream in = getMethod.getResponseBodyAsStream();
			int len = 0;
			byte[] buf = new byte[1024];
			while((len=in.read(buf))!=-1){
				out.write(buf, 0, len);
			}
			responseMsg = out.toString("UTF-8");
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//释放连接
			getMethod.releaseConnection();
		}
		return responseMsg;
	}
    
	/**
	 * post方式 Map格式提交
	 */
	public static String postHttp(String url, Map<String, Object> map) {
		String responseMsg = "";
		// 1.构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("utf-8");
		// 2.构造PostMethod的实例
		PostMethod postMethod = new PostMethod(url);
		// 3.把参数值放入到PostMethod对象中
		for (Entry<String, Object> entry : map.entrySet()) {
			postMethod.addParameter(entry.getKey(), entry.getValue().toString());
		}
		try {
			// 4.执行postMethod,调用http接口
			httpClient.executeMethod(postMethod);// 200
			// 5.读取内容
			InputStream in = postMethod.getResponseBodyAsStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String msg = "";
			while ((msg = reader.readLine()) != null) {
				responseMsg += msg;
			}
			logger.info("接口调用 ：" + url + " 返回: " + responseMsg);
			logger.info("执行成功：Common.postHTTP");
			// 6.处理返回的内容
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 7.释放连接
			postMethod.releaseConnection();
		}
		return responseMsg;
	}
	
	/**
     * @description 向指定的URL发起一个post请求
     * @return
     * @author xiechangsong
     * @throws IOException
     */
    public static String doPost(String url,String data){  
        String resStr = null;
        HttpClient htpClient = new HttpClient();  
        PostMethod putMethod = new PostMethod(url);  
        putMethod.addRequestHeader("Accept" ,"application/json"); 
        putMethod.addRequestHeader("Content-type" , "application/x-www-form-urlencoded;charset=utf-8");
        putMethod.getParams().setParameter( HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8" );
        putMethod.setRequestBody(data);
        try{ 
            int statusCode = htpClient.executeMethod( putMethod );  
//            log.info(statusCode);  
            if(statusCode != HttpStatus.SC_OK){
                return null;  
            }
            byte[] responseBody = putMethod.getResponseBody();           
            resStr = new String(responseBody,"UTF-8");  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            putMethod.releaseConnection();  
        }  
        return resStr;  
    }  
	
	/*** 将MAP对象转为HTML属性的字符串 */
	public static String mapToStr(Map<String, String> map) {
		if (map == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey() + "=\"" + entry.getValue() + "\" ");
		}
		return sb.toString().trim();
	}

	
	/*** 把POJO对象转为Map对象 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapFromPOJO(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Class c = obj.getClass();
			Field[] fields = c.getFields();
			for (Field field : fields) {
				map.put(field.getName(), field.get(obj));
			}
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return map;
	}
	
	/*** 把Map,List对象转为JSON字符串 */
	public static String object2JsonStr(Object obj) {
		return JSON.toJSON(obj).toString();
	}
	

	

	
	/*** 把数组,Map,List等对象转化为json字符串 */
	public static String parseObjToJson(Object obj) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonfromList = mapper.writeValueAsString(obj);
		return jsonfromList;
	}

	/*** 得到json字符串中key是name的值*/
	public static String getStringByName(String name, String json)throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(json); // 读取Json
		// rootNode.path("xx")返回的还是一个JsonNode对象，调用该JsonNode的相应方法，得到键对应的值
		String value = rootNode.path(name).asText();
		return value;
	}
	public static void main(String [] agrs){
		String sdf="asdfasdf,oihwefho,uwhyusdf,sjwlkdnf";
		String [] url = sdf.split(",");
		if (url.length>1) {
			System.out.println(111);
		}
		sdf="asdfasdf";
		url = sdf.split(",");
		if (url.length>1) {
			System.out.println(111);
		}
	}
	/**
	 * 获取中文对应的全拼
	 * @author 向蓬
	 * @date 2016-8-11下午6:06:42
	 * @param chines
	 * @return
	 * String
	 */
	public static String converterToFirstSpell(String chines) {
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			String s = String.valueOf(nameChar[i]);
			if (s.matches("[\\u4e00-\\u9fa5]")) {
				try {
					String[] mPinyinArray = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
					pinyinName += mPinyinArray[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}

}
