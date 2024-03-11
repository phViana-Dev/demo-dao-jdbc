package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Seller;

public class DaoFactory {

    // Dessa forma, a classe vai expôr um método que retorna o tipo da interface, mas internamente vai instanciar uma implementação
    // é um macete para não precisar expôr a implementação
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
