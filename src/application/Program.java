package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Department obj = new Department(1, "Books");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, obj);

        // dessa forma o programa não conhece a implementação, só a interface.
        // é também uma forma de injetar dependências sem explicitar a implementação
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}
