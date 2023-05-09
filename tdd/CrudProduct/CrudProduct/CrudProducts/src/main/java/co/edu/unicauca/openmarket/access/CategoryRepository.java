package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryRepository implements ICategoryRepository {

    private Connection conn;

    public CategoryRepository() {
        initDataBase();
    }

    @Override
    public boolean save(Category newCategory) {
        try {
            //Validate Category
            if (newCategory == null || newCategory.getName().isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO category ( name ) "
                    + "VALUES ( ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,  newCategory.getName());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean edit(Long id, Category category) {
        try {
            //Validate Category
            if (id <= 0 || category == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  category "
                    + "SET name=? "
                    + "WHERE cat_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        try {
            //Validate Category
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM category "
                    + "WHERE cat_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Category findById(Long id) {
        try {

            String sql = "SELECT * FROM category  "
                    + "WHERE cat_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Category category = new Category();
                category.setCategoryId(res.getLong("cat_id"));
                category.setName(res.getString("name"));
                return category;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {

            String sql = "SELECT * FROM category";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getLong("cat_id"));
                category.setName(rs.getString("name"));
                
                categories.add(category);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public Category findByName(String name) {
        try {

            String sql = "SELECT * FROM category  "
                    + "WHERE name = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
              Category category = new Category();
                category.setCategoryId(res.getLong("cat_id"));
                category.setName(res.getString("name"));
                
                return category;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void initDataBase() {
         // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS category (\n"
                + "	cat_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
     public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./myDatabase.db"; //Para Linux/Mac
        //String url = "jdbc:sqlite:C:/sqlite/db/myDatabase.db"; //Para Windows
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
