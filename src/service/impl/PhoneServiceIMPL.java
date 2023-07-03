package service.impl;
import database.DataBase;
import model.Phone;
import service.PhoneService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class PhoneServiceIMPL implements PhoneService {
    private DataBase database;
    private static Long phoneId = 1L;

    public PhoneServiceIMPL(DataBase database) {
        this.database = database;
    }

    @Override
    public String addPhone(Phone phone) {
        phone.setId(phoneId++);
        database.getPhones().add(phone);
        return "New phone successfully added!";
    }

    @Override
    public Phone getPhoneById(Long id) {
        return database.getPhones().stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public String updatePhoneById(Long id, String newName, String newBrand) {
        Optional<Phone> phoneToUpdate = database.getPhones().stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst();

        phoneToUpdate.ifPresent(phone -> {
            phone.setName(newName);
            phone.setBrand(newBrand);
        });

        return phoneToUpdate.isPresent() ? "Phone updated successfully!" : "Phone not found!";
    }

    @Override
    public List<Phone> getAllPhones() {
        return new ArrayList<>(database.getPhones());
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return database.getPhones().stream()
                .filter(phone -> phone.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePhoneById(Long id) {
        database.getPhones().removeIf(phone -> phone.getId().equals(id));
        System.out.println("Phone successfully deleted!");
    }
}
