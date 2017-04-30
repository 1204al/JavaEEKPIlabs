package datasource;

import DAO.IDAOMeaning;
import DAO.MongoDAOMeaning;
import DAO.MySQLDAOMeaning;

/**
 * Created by aliubivyi on 17.04.17.
 */
public class DAOFactory {
//    public static IDAOMeaning getDaoMeaning() {
//        return new MySQLDAOMeaning();
//    }

    public static IDAOMeaning getDaoMeaning() {
        return new MongoDAOMeaning();
    }
}
