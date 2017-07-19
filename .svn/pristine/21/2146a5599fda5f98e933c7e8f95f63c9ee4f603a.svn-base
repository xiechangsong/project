package com.api;

import com.api.mapper.teacher.ClassInfoMapper;
import com.api.model.system.teacher.ClassInfo;
import com.api.utils.SHAencrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApiApplicationTests {
	@Autowired
	private ClassInfoMapper classInfoService;
	@Test
	public void contextLoads() {
		try {
			//测试加密
			String str= SHAencrypt.encryptSHA("xpp520");
			System.out.println(str);
			String test="xpp520";//区分大小写
			if (str.equals(SHAencrypt.encryptSHA(test))) {
				System.out.println("两者相等");
			}else {
				System.out.println("尽扯淡");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void addClass(){
		ClassInfo classInfo=new ClassInfo();
		classInfo.setClassName("java专业班");
		classInfo.setCreateTime(new Date());
		classInfo.setPresetNumber(100);
		classInfo.setProfile("专业的java班级，让你快且精的学好java");
		classInfo.setStatus(0);
		classInfoService.addClass(classInfo);
	}

}
