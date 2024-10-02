package com.kh.web.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {
	public static void main(String[] args) {
		JSONObject in = new JSONObject();
		in.put("name", "김자바");
		in.put("gender", "남자");
		in.put("age", "10");
		in.put("name", "김자");
		in.put("gender", "남");
		in.put("age", "1");
		System.out.println(in.toJSONString());
		
		JSONObject out = new JSONObject();
		out.put("in", in);
		System.out.println(out.toJSONString());
		System.out.println("-----------------------------------------------------");
		
		String json = out.toJSONString();
		// {"in":{"gender":"남자","name":"김자바","age":"10"}}
		JSONParser parser = new JSONParser();
		JSONObject p_out = null;
		JSONObject p_in = null;
		String gender = null;
		String name = null;
		int age = 0;
		
		try {
			p_out = (JSONObject)parser.parse(json);
			p_in = (JSONObject)p_out.get("in");
			name = (String)p_in.get("name");
			gender = (String)p_in.get("gender");
			age = Integer.parseInt((String)p_in.get("age"));
			
			System.out.println("이름 : " + name);
			System.out.println("성별 : " + gender);
			System.out.println("나이 : " + age);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
