package service.impl;

import database.DataBase;
import model.Contact;
import service.ContactService;

import model.Contact;
import model.Phone;
import service.ContactService;
public class ContactServiceIMPL implements ContactService {
    private DataBase database;

    public ContactServiceIMPL(DataBase database) {
        this.database = database;
    }

    @Override
    public void addContactToPhone(Long phoneId, Contact contact) {
        Phone phone = database.getPhoneById(phoneId);
        if (phone != null) {
            phone.getContacts().add(contact);
        } else {
            System.out.println("Phone not found!");
        }
    }

    @Override
    public Contact findContactByName(Long phoneId, String name) {
        Phone phone = database.getPhoneById(phoneId);
        if (phone != null) {
            for (Contact contact : phone.getContacts()) {
                if (contact.getName().equals(name)) {
                    return contact;
                }
            }
        }
        return null;
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, Long phoneNumber) {
        Phone phone = database.getPhoneById(phoneId);
        if (phone != null) {
            for (Contact contact : phone.getContacts()) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    return contact;
                }
            }
        }
        return null;
    }

    @Override
    public void deleteContactByNamefromPhone(Long phoneId, String name) {
        Phone phone = database.getPhoneById(phoneId);
        if (phone != null) {
            phone.getContacts().removeIf(contact -> contact.getName().equals(name));
            System.out.println("Contact successfully deleted!");
        } else {
            System.out.println("Phone not found!");
        }
}
}
