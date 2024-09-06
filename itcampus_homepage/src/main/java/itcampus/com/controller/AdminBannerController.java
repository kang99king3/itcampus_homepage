package itcampus.com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import itcampus.com.dto.BannerDto;
import itcampus.com.service.AdminBannerService;
import itcampus.com.service.AdminMediaService;
import itcampus.com.service.EgovFileMngUtil;
import itcampus.com.vo.BannerVO;
import itcampus.com.vo.MediaVO;

@Controller
@RequestMapping("/admin")
public class AdminBannerController {

    Logger logger = LoggerFactory.getLogger(AdminBannerController.class);

    @Autowired
    AdminBannerService adminBannerService;

    @Autowired
	private AdminMediaService adminMediaService;

    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;

    // 배너 목록
    @GetMapping("/banner")
    public String bannerList(Model model) {
        logger.debug("배너목록");
        List<BannerVO> bList = adminBannerService.bannerList();
        model.addAttribute("bList", bList);
        System.out.println("bList size:" + bList.size());
        return "admin/bannerlist";
    }

    // 배너 등록 폼
    @GetMapping("/banner/add")
    public String bannerAddForm(Model model) {
        logger.debug("배너등록폼");
        List<MediaVO> list=adminMediaService.mediaList();
		
        model.addAttribute("mediaList", list);
        return "admin/banneradd";
    }

    // 배너 등록
    @PostMapping("/banner/add")
    public String bannerAdd(BannerDto bannerDto) throws Exception {
        logger.debug("배너등록");
        logger.debug("bannerDto param:" + bannerDto); // 입력 폼에서 전달된 파라미터를 DTO 객체로 받음
        
        // 등록일을 자동으로 추가해준다.
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        bannerDto.setBregdate(formattedDate);

        adminBannerService.insertBanner(bannerDto);

        return "redirect:/admin/banner";
    }

    // 배너 상세 보기
    @GetMapping("/banner/view")
    public String bannerUpdateForm(int bid, Model model) {
        logger.debug("배너 상세보기");
        BannerVO bDetail = adminBannerService.bannerView(bid);
        List<MediaVO> list=adminMediaService.mediaList();
		
        model.addAttribute("mediaList", list);

        model.addAttribute("bDetail", bDetail);
        System.out.println("bUpdateForm bDetail.burl:" + bDetail.toString());
        return "admin/bannerview";
    }

    // 배너 수정하기
    @PostMapping("/banner/update")
    public String bannerUpdate(BannerDto bannerDto, Model model) throws Exception {
        logger.debug("배너 수정하기");
        logger.debug("bannerDto:" + bannerDto);

        // 배너 정보 수정
        adminBannerService.updateBanner(bannerDto);
        //return "redirect:/admin/banner/view?bid=" + bannerDto.getBid();
        return "redirect:/admin/banner";

    }

    // 배너 삭제하기
    @GetMapping("/banner/delete")
    public String bannerDelete(int bid, Model model) throws Exception {
        logger.info("배너 삭제하기");
        adminBannerService.deleteBanner(bid);
        return "redirect:/admin/banner";
    }
}
