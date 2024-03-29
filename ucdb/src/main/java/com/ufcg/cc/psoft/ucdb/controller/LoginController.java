package com.ufcg.cc.psoft.ucdb.controller;

import com.ufcg.cc.psoft.exceptions.InvalidLoginException;
import com.ufcg.cc.psoft.exceptions.NotCorrespondingStudentLogin;
import com.ufcg.cc.psoft.ucdb.model.Student;
import com.ufcg.cc.psoft.ucdb.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * LoginController: LoginController, this class is responsible for managing a system of user authentication
 * on the system.
 */
@Api(value = "Controller do Login")
@RestController
@RequestMapping("v1/login")
public class LoginController {


    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * From a user is generated an authorization token, if the user of the request is a user already registered.
     * @param requestStudent : is a user created for the post method.
     * @return :  an authorization token for the user.
     * @throws NotCorrespondingStudentLogin : if the request user does not correspond to a user registered in the database.
     * @throws InvalidLoginException : if one of the parameters (email or password) is passed with an invalid value
     *  (null, or invalid string).
     */
    @ApiOperation(value = "Realiza o login do usuario, passado por JSON: email e password")
    @PostMapping("/")
    @ResponseBody
    public @NotNull ResponseEntity<LoginService.LoginResponse> authenticate(@RequestBody Student requestStudent) throws NotCorrespondingStudentLogin,
            InvalidLoginException {
        return this.loginService.getLoginResponseEntity(requestStudent);
    }

}


