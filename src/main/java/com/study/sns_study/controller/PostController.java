package com.study.sns_study.controller;

import com.study.sns_study.entity.Post;
import com.study.sns_study.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/createPost")
    public String createPostForm() {
        //게시글 작성 폼 페이지
        return "createPost";
    }


    private static String UPLOAD_DIR= "uploads/"; //파일 저장 경로를 지정

    static {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) { //해당 경로에 uploads폴더가 없으면
                Files.createDirectories(uploadPath); //상위 경로에 uploads폴더생성
            }
        } catch (IOException e) {
            e.printStackTrace();
            //경로 생성 실패예외 처리
        }
    }

    @PostMapping("/createPost")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "content") String content,
                             @RequestParam(name = "image") MultipartFile image, RedirectAttributes redirectAttributes) {
        //게시글 처리 메소드

        String filename = null;//변수 filename 초기화

        if (!image.isEmpty()) { //업로드하는 파일이 존재하는지 검사
            try {
                filename = saveImage(image);// 파일이 존재한다면 저장 메소드 호출
            } catch (IOException e) {
                e.printStackTrace();
                // 파일 저장 실패 예외처리
                redirectAttributes.addFlashAttribute("message", "이미지 업로드 실패");
            }
        }
        //Post 객체 생성 및 저장
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setImagePath(filename);

        postService.createPost(post); //Post객체를 데이터베이스에 저장

        redirectAttributes.addFlashAttribute("successMessage", "게시글 작성완료");
        return "redirect:/main"; //저장 후 메인 페이지로
    }



    private String saveImage(MultipartFile file) throws IOException {  //파일을 저장하는 메소드
        String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename(); // 파일이름과 UUID를 사용해 고유식별가능한 id를 만듬
        Path savePath = Paths.get(UPLOAD_DIR + filename); //지정된 파일경로 UPLOAD_DIR에 파일이름저장함
        Files.copy(file.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING); //StandardCopyOption.REPLACE_EXISTING는 동일이름 파일이 존재할경우 덮어쓰기함
        return savePath.toString();//저장된 파일 이름을 문자열로 반환함
    }
}
