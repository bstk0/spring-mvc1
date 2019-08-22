package br.com.dbe.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.dbe.entity.Employee;
import br.com.dbe.utils.NetClientGet;

public class EmployeeDAO {

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() {
		Object obj = null;
		JSONParser parser = new JSONParser();
		try {
			String reqString = new NetClientGet().getPy();
			obj = parser.parse(reqString);
			// JSONArray results = (JSONArray) (obj);
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray results = (JSONArray) jsonObject.get("emps");
			return (ArrayList<Employee>) results;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<Employee>();
	}

}
