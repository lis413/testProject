package servlet;

import model.User;
import service.UserService;

import javax.servlet.http.HttpServlet;

public class AddUserSrvlet extends HttpServlet {
    UserService userService = new UserService();

}
