package edu.iselab.grocery.features.manageproducts;

import edu.iselab.grocery.database.AbstractDatabase;
import edu.iselab.grocery.database.SQLDatabase;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepository extends AbstractDatabase<Product> {

    private static ProductRepository instance;

    public static ProductRepository getInstance() {

        if (instance == null) {
            instance = new ProductRepository();
        }

        return instance;
    }

    public Product findById(Long id) {
        return (Product) super.findById(Product.class, id);
    }

    public List<Product> findByDescription(String term) {

        Session session = SQLDatabase.getInstance().openSession();

        String hql = "from Product c where lower(c.description) LIKE lower(:term)";

        TypedQuery<Product> query = session.createQuery(hql, Product.class);

        query.setParameter("term", "%" + term + "%");

        return query.getResultList();
    }

    public List<Product> findAll(){

        Session session = SQLDatabase.getInstance().openSession();

        return session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
    }
}
