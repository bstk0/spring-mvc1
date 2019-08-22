package br.com.dbe.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.dbe.entity.Employee;
import br.com.dbe.utils.NetClientGet;
import br.com.dbe.utils.NetClientPost;

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
	
	public void addEmployee(Employee emp) {
		JSONObject snuttgly = employeeToJSON(emp);
		new NetClientPost().doPOST(snuttgly.toJSONString());

	}

	@SuppressWarnings("unchecked")
	private JSONObject employeeToJSON(Employee employee) {
		JSONObject snuttgly = new JSONObject();
		snuttgly.put("id", "1000");
		snuttgly.put("name", employee.getName());
		snuttgly.put("title", employee.getTitle() );
		//snuttgly.put("NovaColuna", "They are the best");
		return snuttgly;
	}
}
