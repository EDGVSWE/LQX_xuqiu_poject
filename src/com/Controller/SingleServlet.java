package com.Controller;

import com.Entity.single;
import com.Service.SingleService;
import com.Service.SingleServiceImpl.SingleServiceimpl;
import com.Util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "SingleServlet",urlPatterns = "/singleservlet")
//试题集controller
public class SingleServlet extends BaseServlet{
    //创建SingleService的对象，为了使用他的服务（方法）
    //多态特性，目的为了编码稳定
    SingleService service=new SingleServiceimpl();
    //试卷获取与批改
    public String checkTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*1.获取用户传递的数据（试题）
        2.取出数据库中对应科目的答案
        3.答案核对
        4.计算分数
        5.（数据传递）跳转界面
         */
        //获取科目名
        String paper=request.getParameter("paper");
            //获取所有参数名
        Enumeration<String> parameter=request.getParameterNames();
        //取出数据库中对应科目的答案
        List<String> answerList=service.queryAnswer(paper);
        //用户答案收集器
        List<String> userAnswerList=new ArrayList<>();
        //正确答案计数
        int count=0;
        //parameter.hasMoreElements(),表示是否还有下一个值
        while (parameter.hasMoreElements()){
                //获取当前题号
               String number=parameter.nextElement();
               try{
                   //字符串题号转int
                   int index=Integer.parseInt(number);
                   //获取用户答案
                   String userAnswer=request.getParameter(number);
                   //答案核对
                   if(userAnswer.equals(answerList.get(index))) count++;
                   userAnswerList.add(userAnswer);
               }catch (NumberFormatException e){
                   continue;
               }
        }
        //分数
        int fraction= count*(100/answerList.size());
        //分数，用户答案，正确答案 传递给jsp
        request.setAttribute("fraction",fraction);
        request.setAttribute("userAnswerList",userAnswerList);
        request.setAttribute("answerList",answerList);
        //跳转新jsp
       return "WEB-INF/Exam/result.jsp";
    }
    public String getsubjectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收处理后的数据
        List<String>  list=  service.queryBySubject();
        //数据整理（携带）
        request.setAttribute("subjectList",list);
        //跳转
     return "WEB-INF/Exam/SubjectList.jsp";
    }
    public String getParperList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              //获取jsp传递的科目名
        String paper=request.getParameter("paper");
            //调用服务层的对应方法,并创建List接受服务层返回的数据
         List<single> list=  service.queryBypaper(paper);
         //向新JSP页面返回数据（传递参数）
        request.setAttribute("paperList",list);
        //向新jsp页面传递科目名
        request.setAttribute("paper",paper);
        //跳转指定JSP页面
       return "WEB-INF/Exam/exam1.jsp";
}
}
