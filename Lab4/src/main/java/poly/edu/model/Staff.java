package poly.edu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Staff {
	private String id;
	private String fullname;
	
	@Builder.Default
	private String photo = "photo.jpg";
	
	private Boolean gender;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Builder.Default
	private Date birthday = new Date();
	
	@Builder.Default
	private Double salary = 12345.6789;
	
	@Builder.Default
	private Integer level = 0;
}