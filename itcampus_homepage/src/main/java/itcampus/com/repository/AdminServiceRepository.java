package itcampus.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itcampus.com.vo.MemberVO;

@Repository
public interface AdminServiceRepository extends JpaRepository<MemberVO,Long>{
    MemberVO findByMidAndMpwd(String mid, String mpwd);
}
