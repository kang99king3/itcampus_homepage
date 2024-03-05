package itcampus.com.service;

import itcampus.com.validation.EgovNotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleVO extends SampleDefaultVO {

	private static final long serialVersionUID = 1L;

	/** 아이디 */
	private String id;

	/** 이름 */
	@EgovNotNull(message="{confirm.required.name}")
	private String name;

	/** 내용 */
	@EgovNotNull(message="{confirm.required.description}")
	private String description;

	/** 사용여부 */
	private String useYn;

	/** 등록자 */
	@EgovNotNull(message="{confirm.required.user}")
	private String regUser;

}
