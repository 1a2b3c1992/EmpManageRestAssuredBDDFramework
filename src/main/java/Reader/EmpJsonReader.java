package Reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Employees;
import java.io.FileReader;

public class EmpJsonReader {

	private static String path = System.getProperty("user.dir") + "/src/test/resources/Payload/";
	
	public static String readJsonFile(String fileName, String jsonNodeName)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
		
		FileReader file = new FileReader(path + fileName + ".json");
		JsonNode jsonNode = mapper.readTree(file); //JsonNode allows you to traverse and manipulate JSON like a tree (like jsonNode.get("key")).
		Employees employee =mapper.treeToValue(jsonNode.get(jsonNodeName), Employees.class);
		/*Extracts a specific part of the JSON using jsonNode.get(jsonNodeName).
		  Converts that part into a Java object of type Employees using Jackson's treeToValue() method.*/
		
		System.out.println("jsonNode: " + jsonNode);
		System.out.println("Target Node: " + jsonNode.get(jsonNodeName));

		
		return mapper.writeValueAsString(employee); //Converts the Employees Java object back into a JSON-formatted String.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
