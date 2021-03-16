//Solution below adapted from https://github.com/briyanii/main
package seedu.address.commons.core;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ViewHistoryCommand;
import seedu.address.logic.commands.alias.AliasCommand;
import seedu.address.logic.commands.issue.AddIssueCommand;
import seedu.address.logic.commands.issue.DeleteIssueCommand;
import seedu.address.logic.commands.issue.EditIssueCommand;
import seedu.address.logic.commands.issue.FindIssueCommand;
import seedu.address.logic.commands.issue.ListIssueCommand;
import seedu.address.logic.commands.resident.AddResidentCommand;
import seedu.address.logic.commands.resident.DeleteResidentCommand;
import seedu.address.logic.commands.resident.EditResidentCommand;
import seedu.address.logic.commands.resident.FindResidentCommand;
import seedu.address.logic.commands.resident.ListResidentCommand;
import seedu.address.logic.commands.room.AddRoomCommand;
import seedu.address.logic.commands.room.DeleteRoomCommand;
import seedu.address.logic.commands.room.EditRoomCommand;
import seedu.address.logic.commands.room.FindRoomCommand;
import seedu.address.logic.commands.room.ListRoomCommand;

/**
 * Represents the current user's {@code Alias} command mapping.
 * Guarantees: fields are present and not null, fields values are mutable
 */
public class AliasMapping implements Serializable {
    private Map<String, Alias> mapping;

    public AliasMapping() {
        this.mapping = new HashMap<>();
    }

    private AliasMapping(AliasMapping aliasMapping) {
        requireNonNull(aliasMapping);
        this.mapping = new HashMap<>(aliasMapping.mapping);
    }

    /**
     * Returns an Alias object from alias name.
     * @param aliasName name of the alias
     * @return Alias object
     */
    public Alias getAlias(String aliasName) {
        return mapping.get(aliasName);
    }

    /**
     * Adds a new Alias object to the current mapping.
     * @param alias
     */
    public void addAlias(Alias alias) {
        mapping.put(alias.getAliasName(), alias);
    }

    /**
     * Checks if the current mapping contains an Alias based on alias name.
     * @param aliasName
     * @return
     */
    public boolean containsAlias(String aliasName) {
        return mapping.containsKey(aliasName);
    }

    /**
     * Check if alias name is a reserved keyword.
     * @param aliasName
     * @return
     */
    public boolean isReservedKeyword(String aliasName) {
        switch (aliasName) {
        //====== System Commands ======
        case AliasCommand.COMMAND_WORD:
        case ClearCommand.COMMAND_WORD:
        case ExitCommand.COMMAND_WORD:
        case HelpCommand.COMMAND_WORD:
        case ViewHistoryCommand.COMMAND_WORD:

        //====== Resident Commands ======
        case AddResidentCommand.COMMAND_WORD:
        case EditResidentCommand.COMMAND_WORD:
        case DeleteResidentCommand.COMMAND_WORD:
        case FindResidentCommand.COMMAND_WORD:
        case ListResidentCommand.COMMAND_WORD:

        //====== Room Commands ======
        case AddRoomCommand.COMMAND_WORD:
        case EditRoomCommand.COMMAND_WORD:
        case DeleteRoomCommand.COMMAND_WORD:
        case FindRoomCommand.COMMAND_WORD:
        case ListRoomCommand.COMMAND_WORD:

        //====== Issue Commands ======
        case AddIssueCommand.COMMAND_WORD:
        case ListIssueCommand.COMMAND_WORD:
        case FindIssueCommand.COMMAND_WORD:
        case EditIssueCommand.COMMAND_WORD:
        case DeleteIssueCommand.COMMAND_WORD:
            return true;
        default:
            return false;
        }
    }

    /**
     * Check if the command used is an existing alias.
     * @param commandWord
     * @return
     */
    public boolean isRecursiveKeyword(String commandWord) {
        return mapping.containsKey(commandWord);
    }

    @Override
    public int hashCode() {
        return mapping.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AliasMapping)) {
            return false;
        }

        AliasMapping am = (AliasMapping) o;

        return mapping.keySet().stream().allMatch(key -> mapping.get(key).equals(am.mapping.get(key)));
    }
}
