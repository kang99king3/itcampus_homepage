package itcampus.com.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itcampus.com.vo.QnaVO;

@Repository
public interface QnaServiceRepository extends JpaRepository<QnaVO, Long> {
	List<QnaVO> findAll();
}
