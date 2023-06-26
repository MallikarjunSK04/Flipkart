package testComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReadFromJson {
	
	public List<HashMap<String, String>> getDataFromJson() throws IOException {
		
		String json = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testComponents\\Data.json")
				,StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;
		
	}

}
