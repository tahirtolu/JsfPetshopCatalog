/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
/**
 *
 * @author Muhsin21
 */
import dao.AnimalDAO;
import entity.Animal;
import entity.Brand;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "AnimalBean")
@SessionScoped
public class AnimalBean implements Serializable{

    private Animal animal = new Animal();
    private AnimalDAO animalDao = new AnimalDAO();
    private Animal entity;
    
    
    
    
    
    public List<Animal> getAnimals() {
        return animalDao.readList();
    }

    public AnimalDAO getAnimalDao() {
         if(this.animalDao == null){
            this.animalDao = new AnimalDAO();
        }
        
        
        return animalDao;
        
       
    }

    public void setAnimalDao(AnimalDAO animalDao) {
        this.animalDao = animalDao;
    }

    public Animal getEntity() {
        if (this.entity == null) {
            this.entity = new Animal();
        }
        return entity;
    }

    public void setEntity(Animal entity) {
        this.entity = entity;
    }
    
    

    public String create() {
        animalDao.create(animal);
        animal = new Animal(); // Formu sıfırla
        return "animalList"; // Listeleme sayfasına yönlendir
    }

    public String update() {
        animalDao.update(animal);
        return "animalList"; // Listeleme sayfasına yönlendir
    }

    public String delete() {
        animalDao.delete(animal);
        return "animalList"; // Listeleme sayfasına yönlendir
    }

    // Getter ve Setter metodları
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}