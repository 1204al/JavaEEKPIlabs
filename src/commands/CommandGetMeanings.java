package commands;

import controllers.ICommand;
import datasource.DAOFactory;
import entities.Meaning;
import properties.Config;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by aliubivyi on 17.04.17.
 */
public class CommandGetMeanings implements ICommand {
    private static final String PAGE="PAGE";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("OK");
        List<Meaning> list= DAOFactory.getDaoMeaning().findAll();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        request.getRequestDispatcher(Config.getInstance().getProperty(Config.PAGE)).forward(request,response);
        return null;
    }
}
