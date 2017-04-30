package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aliubivyi on 17.04.17.
 */
public interface ICommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
