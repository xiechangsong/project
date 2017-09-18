package com.api;

import com.api.mapper.teacher.ClassInfoMapper;
import com.api.model.system.teacher.ClassInfo;
import com.api.utils.SHAencrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;



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
	@Test
	public void array() {
		String []a={"0","1","2","3","4","5","6"};
		String []b={"1","3","5"};
//Set是不允许重复的，所以将数组的值全部放在Set对象中
		Set set = new HashSet<Integer>();
		for(int i = 0; i < a.length ; i++){
			set.add(a[i]);
		}
		for(int i = 0; i < b.length ; i++){
			set.add(b[i]);
		}
//得到的是不重复的值，Set的长度
		System.out.println(set.size());
		Iterator i = set.iterator();
		int[] arrays = new int[set.size()];
		int num=0;
		while(i.hasNext()){
			int value = (Integer)i.next();
			arrays[num] = value;
			num = num + 1;
			System.out.println(num);
		}
		for(int s = 0; s < arrays.length ; s++){
			System.out.println(arrays[s]);
		}
//对结果进行排序
		Arrays.sort(arrays);
		for(int s = 0; s < arrays.length ; s++){
			System.out.println(arrays[s]);
		}
	}

}
