package com.sh.diet.member.model.controller;

import com.sh.diet.member.model.service.MemberService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/member/memberRegister")
public class MemberRegisterServlet extends HttpServlet {

    private MemberService memberService = new MemberService();


}