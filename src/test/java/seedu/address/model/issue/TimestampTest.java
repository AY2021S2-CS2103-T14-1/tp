package seedu.address.model.issue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TimestampTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Timestamp(null));
    }

    @Test
    public void constructor_invalidTimestamp_throwsIllegalArgumentException() {
        String invalidTimestamp = "abc";
        assertThrows(IllegalArgumentException.class, () -> new Timestamp(invalidTimestamp));
    }

    @Test
    public void isValidTimestamp() {
        // null timestamp
        assertThrows(NullPointerException.class, () -> Timestamp.isValidTimestamp(null));

        // invalid timestamps
        assertFalse(Timestamp.isValidTimestamp("")); // empty string
        assertFalse(Timestamp.isValidTimestamp("2021/12/31 23:59")); // 24-hour time
        assertFalse(Timestamp.isValidTimestamp("2021-12-31 23:59")); // - instead of /
        assertFalse(Timestamp.isValidTimestamp("2021/12/32 0:00pm")); // invalid midnight
        assertFalse(Timestamp.isValidTimestamp("0000/1/1 0:00am")); // invalid year
        assertFalse(Timestamp.isValidTimestamp("-9999/1/1 0:00am")); // invalid year
        assertFalse(Timestamp.isValidTimestamp("2021/13/1 0:00am")); // invalid month
        assertFalse(Timestamp.isValidTimestamp("2021/12/32 11:59pm")); // invalid date
        assertFalse(Timestamp.isValidTimestamp("2021/12/32 000:00pm")); // invalid hour
        assertFalse(Timestamp.isValidTimestamp("2021/12/32 0:000pm")); // invalid minute

        // valid timestamps
        assertTrue(Timestamp.isValidTimestamp("2021/12/31 12:00am")); // midnight
        assertTrue(Timestamp.isValidTimestamp("2021/12/31 12:00AM")); // AM capitalized
        assertTrue(Timestamp.isValidTimestamp("2021/12/31 12:00Am")); // partially capitalized
        assertTrue(Timestamp.isValidTimestamp("2021/12/31 12:00aM")); // partially capitalized
        assertTrue(Timestamp.isValidTimestamp("2021/12/31 11:59pm")); // 11:59 pm
        assertTrue(Timestamp.isValidTimestamp("0001/1/1 12:00am")); // earliest datetime
    }
}
