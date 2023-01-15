
package ch.hearc.jee.tldr.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TLDRDto
	{

	private Long id;
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@NotEmpty(message = "Content should not be empty")
	private String content;
	private Long userId;
	}
