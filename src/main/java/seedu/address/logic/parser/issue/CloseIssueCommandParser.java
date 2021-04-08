package seedu.address.logic.parser.issue;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.issue.CloseIssueCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new CloseIssueCommand object
 */
public class CloseIssueCommandParser implements Parser<CloseIssueCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the CloseIssueCommand
     * and returns a CloseIssueCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public CloseIssueCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new CloseIssueCommand(index);
        } catch (IllegalArgumentException iex) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, CloseIssueCommand.MESSAGE_USAGE), iex);
        }
    }

}
