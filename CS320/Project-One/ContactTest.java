import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test Contact ID Requirements
    @Test
    public void testContactIDNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactIDNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactIDMaxLength() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactID());
    }

    @Test
    public void testContactIDNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactIDNotUpdatable() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        String originalID = contact.getContactID();
        assertEquals("123", originalID);
    }

    // Test First Name Requirements
    @Test
    public void testFirstNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "JohnDoeNameTooLong", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameMaxLength() {
        Contact contact = new Contact("123", "1234567890", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getFirstName());
    }

    @Test
    public void testFirstNameNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameUpdatable() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    // Test Last Name Requirements
    @Test
    public void testLastNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "DoeLastNameTooLong", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameMaxLength() {
        Contact contact = new Contact("123", "John", "1234567890", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getLastName());
    }

    @Test
    public void testLastNameNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameUpdatable() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    // Test Phone Requirements
    @Test
    public void testPhoneNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main St");
        });
    }

    @Test
    public void testPhoneExactly10Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123456789", "123 Main St");
        });
    }

    @Test
    public void testPhoneNotMoreThan10Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345678901", "123 Main St");
        });
    }

    @Test
    public void testPhoneOnlyDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123456789a", "123 Main St");
        });
    }

    @Test
    public void testPhoneValidFormat() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    public void testPhoneUpdatable() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }

    // Test Address Requirements
    @Test
    public void testAddressNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    public void testAddressNotTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "123 Main Street Address Way Too Long");
        });
    }

    @Test
    public void testAddressMaxLength() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123456789012345678901234567890");
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    @Test
    public void testAddressNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "");
        });
    }

    @Test
    public void testAddressUpdatable() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    // Integration tests
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("C001", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testMultipleFieldUpdates() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("9876543210");
        contact.setAddress("456 Oak Ave");
        
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}
