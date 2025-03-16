package com.currychoco.board.features.user.action;

import com.currychoco.board.features.user.domain.User;
import com.currychoco.board.features.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class UserApiAction extends ActionSupport {

    @Getter
    private User responseUser;

    private final UserService userService = new UserService();

    public String signup() {
        var request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");

        responseUser = userService.signup(id, password, nickname);
        return SUCCESS;
    }

    //TODO: jsession 기반 로그인 세션 유지 처리
    public String login() {
        var request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(!userService.login(id, password)) {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return SUCCESS;
    }
}
