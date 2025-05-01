package Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"fname", "lname", "mobileNo", "address", "emailId"})
public class Employees {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty(value="fname")
	private String fname;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty(value= "lname")
	private String lname;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty(value ="mobileNo")
	private String mobileNo;
	
	@JsonProperty(value="address")
	private String address;
	
	@JsonProperty(value="emailId")
	private String emailId;
	
	

	
	
}
