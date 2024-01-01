package com.sh.diet.qaboard.controller;

//@WebServlet("/qaboard/qaboardList")
//public class QuestionBoardListServlet extends HttpServlet {
//    private QuestionBoardService questionBoardService = new QuestionBoardService();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       // 사용자 입력값 가져오기
//        int page = 1;
//        int limit = 10;
//        try{
//            page = Integer.parseInt(req.getParameter("page"));
//        } catch (NumberFormatException ignore){}
//
//        Map<String, Object> param = Map.of("page",page,"limit",limit);
////        System.out.println(param);
//        // 2. 업무로직
//        List<QuestionBoard> questionBoards = questionBoardService.findAll(param);
//        req.setAttribute("questionBoards",questionBoards);
//        System.out.println(questionBoards);
//        req.getRequestDispatcher("/WEB-INF/views/questionboard/qaboardList.jsp").forward(req,resp);
//    }
//}
