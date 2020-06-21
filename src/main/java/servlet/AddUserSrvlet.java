package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUsers")
public class AddUserSrvlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int money = Integer.parseInt(req.getParameter("money"));
        User user = new User(name, age, money);
        ;userService.addUser(user);
        //super.doPost(req, resp);
    }



}
