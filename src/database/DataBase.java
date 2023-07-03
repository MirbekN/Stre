package database;
import model.Phone;
import java.util.ArrayList;
import java.util.List;
public class DataBase {

        private List<Phone> phones;

        public DataBase() {
            phones = new ArrayList<>();
        }

        public List<Phone> getPhones() {
            return phones;
        }

        public void setPhones(List<Phone> phones) {
            this.phones = phones;
        }

        public Phone getPhoneById(Long id) {
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    return phone;
                }
            }
            return null;
        }
    }

