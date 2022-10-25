package com.simple.storage;

import com.simple.storage.service.UtilService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilServiceTest {

    UtilService utilService = new UtilService();

    @Test
    public void testTypicalId() {
        String id = "aabbcc1111";
        assertEquals("aa\\bb\\cc\\", utilService.getPathFromID(id));
    }

    @Test
    public void testParamId() {
        String id = "aabbcc1111";
        assertEquals("aab\\bcc\\", utilService.getPathFromID(id,2,3));
    }
}
