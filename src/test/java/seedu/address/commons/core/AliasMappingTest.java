package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_1_TO_2;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_3_TO_1;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ALIAS_ADD;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ALIAS_DELETE;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ALIAS_LIST;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_CLEAR;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_EXIT;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_HELP;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_HISTORY;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ISSUE_ADD;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ISSUE_CLOSE;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ISSUE_DELETE;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ISSUE_EDIT;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ISSUE_FIND;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ISSUE_LIST;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_RESIDENT_ADD;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_RESIDENT_DELETE;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_RESIDENT_EDIT;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_RESIDENT_FIND;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_RESIDENT_LIST;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ROOM_ADD;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ROOM_DELETE;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ROOM_EDIT;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ROOM_FIND;
import static seedu.address.testutil.alias.AliasUtil.ALIAS_ROOM_LIST;
import static seedu.address.testutil.alias.AliasUtil.VALID_ALIAS_1;
import static seedu.address.testutil.alias.AliasUtil.VALID_ALIAS_2;
import static seedu.address.testutil.alias.AliasUtil.VALID_ALIAS_3;

import org.junit.jupiter.api.Test;

public class AliasMappingTest {
    @Test
    void containsAlias() {
        AliasMapping aliasMapping = new AliasMapping();
        aliasMapping.addAlias(VALID_ALIAS_1);

        assertTrue(aliasMapping.containsAlias(VALID_ALIAS_1.getAliasName()));
    }

    @Test
    void isReservedKeyword_aliasNameIsReserved_returnsTrue() {
        AliasMapping aliasMapping = new AliasMapping();

        assertTrue(aliasMapping.isReservedKeyword(ALIAS_HELP.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_HISTORY.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_EXIT.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_CLEAR.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ALIAS_ADD.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ALIAS_LIST.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ALIAS_DELETE.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_RESIDENT_ADD.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_RESIDENT_LIST.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_RESIDENT_FIND.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_RESIDENT_EDIT.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_RESIDENT_DELETE.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_ADD.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_LIST.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_FIND.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_EDIT.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_DELETE.getAliasName()));
        //assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_ALLOC.getAliasName()));
        //assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_DEALLOC.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ISSUE_ADD.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ISSUE_LIST.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ISSUE_FIND.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ISSUE_EDIT.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ISSUE_DELETE.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ISSUE_CLOSE.getAliasName()));
        assertTrue(aliasMapping.isReservedKeyword(ALIAS_ROOM_EDIT.getAliasName()));
    }

    @Test
    void isReservedKeyword_aliasNameIsNotReserved_returnsFalse() {
        AliasMapping aliasMapping = new AliasMapping();

        assertFalse(aliasMapping.isReservedKeyword(VALID_ALIAS_1.getAliasName()));
        assertFalse(aliasMapping.isReservedKeyword(VALID_ALIAS_2.getAliasName()));
        assertFalse(aliasMapping.isReservedKeyword(VALID_ALIAS_3.getAliasName()));
    }

    @Test
    void isRecursiveKeyword_aliasCommandIsNotRecursive_returnsFalse() {
        AliasMapping aliasMapping = new AliasMapping();

        assertFalse(aliasMapping.isRecursiveKeyword(VALID_ALIAS_1.getCommand()));
        assertFalse(aliasMapping.isRecursiveKeyword(VALID_ALIAS_2.getCommand()));
        assertFalse(aliasMapping.isRecursiveKeyword(VALID_ALIAS_3.getCommand()));
    }

    @Test
    void isRecursiveKeyword_aliasCommandIsRecursive_returnsTrue() {
        AliasMapping aliasMapping = new AliasMapping();
        aliasMapping.addAlias(ALIAS_1_TO_2);
        assertTrue(aliasMapping.isRecursiveKeyword(ALIAS_3_TO_1.getCommand()));
    }
}