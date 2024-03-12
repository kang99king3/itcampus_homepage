package itcampus.com.vo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name="qna")
@Schema(description = "상담현황")
public class QnaVO {
	
	@Id
	@Column(name="registertime")
	@Schema(description = "등록일")
	private LocalDateTime registertime;
	
	@Column(name="email")
	@Schema(description = "이메일")
	private String email;
	
	@Column(name="agree")
	@Schema(description = "사용자동의")
	private String agree;
	
	@Column(name="name")
	@Schema(description = "이름")
	private String name;
	
    @Column(name="birth")
    @Schema(description = "생년월일")
    private String birth;

    @Column(name="phone")
    @Schema(description = "전화번호")
    private String phone;

    @Column(name="addr")
    @Schema(description = "주소")
    private String addr;

    @Column(name="sex")
    @Schema(description = "성별")
    private String sex;

    @Column(name="edulevel")
    @Schema(description = "교육 수준")
    private String edulevel;

    @Column(name="major")
    @Schema(description = "전공")
    private String major;

    @Column(name="qualifications")
    @Schema(description = "자격증")
    private String qualifications;

    @Column(name="card")
    @Schema(description = "카드")
    private String card;

    @Column(name="path")
    @Schema(description = "경로")
    private String path;

    @Column(name="questions")
    @Schema(description = "질문")
    private String questions;

    @Column(name="contactperson")
    @Schema(description = "상담 담당자")
    private String contactperson;

    @Column(name="contactdate")
    @Schema(description = "상담 날짜")
    private String contactdate; // 날짜 타입이 필요하다면 LocalDate 또는 LocalDateTime을 사용하세요.

    @Column(name="contactdetail")
    @Schema(description = "상담 내용")
    private String contactdetail;
	
}
