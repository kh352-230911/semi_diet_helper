package com.sh.diet.member.controller;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/UpdatePasswordAfterLookup")
public class UpdatePasswordAfterLookupServlet extends HttpServlet {
    private MemberService memberService = new MemberService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Member matchMember = (Member) session.getAttribute("matchMember");

        System.out.println("matchMember: " + matchMember);


        String location = req.getContextPath();
        String msg = null;

        String newPassword = req.getParameter("newPassword");
        String newPasswordConfirmation = req.getParameter("newPasswordConfirmation");



//        matchMember.setPassword(newPassword); // 세션 갱신
//        int result = memberService.updateMemberPassword(matchMember);



        // Check if loginMember is not null
//        if (matchMember != null) {
            // 1. 사용자 입력값 처리: 기존비밀번호/신규비밀번호 암호화처리 필수

//            String newPassword = req.getParameter("newPassword");
//
//            Member loginMember = matchMember;
//            String oldPassword = loginMember.getPassword();

            // 2. 기존비밀번호 비교: session의 loginMember객체 이용
//            if (oldPassword.equals(loginMember.getPassword())) {
//                // 3. 업무로직: 기존비밀번호가 일치한 경우만 신규비밀번호로 업데이트
//                loginMember.setPassword(newPassword); // 세션 갱신
//                int result = memberService.updateMemberPassword(loginMember);
//                msg = "비밀번호를 성공적으로 변경했습니다.";
//                location += "/member/memberDetail";
//            } else {
//                msg = "비밀번호가 일치하지 않습니다.";
//                location += "/member/updatePassword";
//            }
//        } else {
//            msg = "로그인 정보를 찾을 수 없습니다.";
//            location += "/"; // Redirect to home page or login page
//        }
        if(newPassword.equals(newPasswordConfirmation)) {
            matchMember.setPassword(newPassword); // 세션 갱신
            memberService.updateMemberPassword(matchMember);

            msg = "비밀번호가 변경되었습니다.";
            session.setAttribute("matchMember", matchMember);
            // 4. 사용자 경고창 및 리다이렉트 처리
            session.setAttribute("msg", msg);
            resp.sendRedirect(location);
        }else {
            req.getRequestDispatcher("/WEB-INF/views/member/updatePasswordAfterLookup.jsp").forward(req, resp);
        }

    }
}

