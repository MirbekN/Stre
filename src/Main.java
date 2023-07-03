
import database.DataBase;
import model.Contact;
import model.Phone;
import service.impl.ContactServiceIMPL;
import service.impl.PhoneServiceIMPL;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание базы данных
        DataBase database = new DataBase();

        // Создание экземпляров служб
        PhoneServiceIMPL phoneService = new PhoneServiceIMPL(database);
        ContactServiceIMPL contactService = new ContactServiceIMPL(database);

        // Создание объектов Phone
        Phone phone1 = new Phone(1L, "Phone 1", "Brand 1");
        Phone phone2 = new Phone(2L, "Phone 2", "Brand 2");

        // Добавление телефонов в базу данных
        phoneService.addPhone(phone1);
        phoneService.addPhone(phone2);

        // Создание объектов Contact
        Contact contact1 = new Contact("Contact 1", 1234567890L);
        Contact contact2 = new Contact("Contact 2", 9876543210L);

        // Добавление контактов к телефонам
        contactService.addContactToPhone(phone1.getId(), contact1);
        contactService.addContactToPhone(phone2.getId(), contact2);

        // Тестирование методов PhoneServiceIMPL
        Long phoneId = phone1.getId();
        Phone retrievedPhone = (Phone) phoneService.getPhoneById(phoneId);
        System.out.println("Полученный телефон: " + retrievedPhone);

        String newName = "New Phone";
        String newBrand = "New Brand";
        String updateResult = phoneService.updatePhoneById(phoneId, newName, newBrand);
        System.out.println("Результат обновления телефона: " + updateResult);

        List<Phone> allPhones = phoneService.getAllPhones();
        System.out.println("Все телефоны: " + allPhones);

        // Тестирование методов ContactServiceIMPL
        Contact retrievedContact = contactService.findContactByName(phone1.getId(), "Contact 1");
        System.out.println("Полученный контакт: " + retrievedContact);

        Contact foundContact = contactService.findContactByPhoneNumber(phone1.getId(), 1234567890L);
        System.out.println("Найденный контакт: " + foundContact);
    }
}
