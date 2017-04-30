package commands;

import DAO.IDAOMeaning;
import controllers.ICommand;
import datasource.DAOFactory;
import entities.Meaning;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by aliubivyi on 18.04.17.
 */
public class CommandUpdateOrCreate implements ICommand {
    private static final String WORD="WORD";
    private static final String MEANING="MEANING";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String word=request.getParameter(WORD);
        String meaning=request.getParameter(MEANING);
        IDAOMeaning idaoMeaning=DAOFactory.getDaoMeaning();
        Meaning entity=new Meaning(word,meaning);
        if(idaoMeaning.findByWord(word)!=null){
            idaoMeaning.update(entity);
        }else{
            idaoMeaning.create(entity);
        }
        response.sendRedirect("/index.jsp");
        return null;
    }
}
