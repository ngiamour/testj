import java.util.ArrayList;

public class Admin extends User {
    protected ArrayList<Product> productList;

    public Admin(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password);
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Προϊόν μπηκε:" + product.getTitle());
    }

    public void editProduct(Product product, String newTitle, String newDescription, String newCategory,
                            String newSubCategory, double newPrice, double newAvailableQuantity )
    {
        product.setTitle(newTitle);
        product.setDescription(newDescription);
        product.setCategory(newCategory);
        product.setSubcategory(newSubCategory);
        product.setPrice(newPrice);
        product.setAvailableQuantity(newAvailableQuantity);
        System.out.println("Προϊόν που ανανεώθηκε: "+product.getTitle());
    }
}
