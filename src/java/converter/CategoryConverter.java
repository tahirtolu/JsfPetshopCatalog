package converter;

import dao.CategoryDAO;
import entity.Category;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;

@Named
@RequestScoped
@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter<Category> {

    @EJB
    private CategoryDAO categoryDAO;

    @Override
    public Category getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                Long id = Long.valueOf(value);
                System.out.println("deenmememememe"+categoryDAO.find(id).toString());
                return categoryDAO.find(id);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Error converting value to category: " + value, e);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Category category) {
        if (category != null) {
                            System.out.println(category.toString());

            return String.valueOf(category.getId());
        }
        return null;
    }
}
