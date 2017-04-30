package controllers;

import commands.CommandDeleteWord;
import commands.CommandGetMeanings;
import commands.CommandUpdateOrCreate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aliubivyi on 17.04.17.
 */
public class ControllerHelper {
    private static final String COMMAND = "command";
    private static final String DEFAULT_COMMAND_NAME = "default";
    private static ControllerHelper instance = null;

    private static Map<String, ICommand> commands = new HashMap<>();


    static{
        commands.put("default",new CommandGetMeanings());
        commands.put("updateOrCreate",new CommandUpdateOrCreate());
        commands.put("deleteWord",new CommandDeleteWord());
    }

    public static ControllerHelper getInstance(){
        if(instance==null){
            instance=new ControllerHelper();
        }
        return instance;
    }

    public static ICommand getCommand(HttpServletRequest request){
        String command = request.getParameter(COMMAND);

//        System.out.println("The command is \"" + command+"\"");

        if(command==null) return commands.get(DEFAULT_COMMAND_NAME);
        ICommand t=commands.get(command);
        if(t==null){
//            System.out.println("        But this command isn't existing!!!");
            return commands.get(DEFAULT_COMMAND_NAME);
        }

        return t;
    }

}

