package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROOM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_YEAR;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditResidentCommand;
import seedu.address.logic.commands.EditResidentCommand.EditResidentDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EditResidentCommand object
 */
public class EditCommandParser implements Parser<EditResidentCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditResidentCommand
     * and returns an EditResidentCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditResidentCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_YEAR, PREFIX_ROOM);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                EditResidentCommand.MESSAGE_USAGE), pe);
        }

        EditResidentDescriptor editResidentDescriptor = new EditResidentDescriptor();
        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            editResidentDescriptor.setName(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            editResidentDescriptor.setPhone(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
        }
        if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
            editResidentDescriptor.setEmail(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
        }
        if (argMultimap.getValue(PREFIX_YEAR).isPresent()) {
            editResidentDescriptor.setYear(ParserUtil.parseYear(argMultimap.getValue(PREFIX_YEAR).get()));
        }
        if (argMultimap.getValue(PREFIX_ROOM).isPresent()) {
            editResidentDescriptor.setRoom(ParserUtil.parseRoom(argMultimap.getValue(PREFIX_ROOM).get()));
        }
        if (!editResidentDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditResidentCommand.MESSAGE_NOT_EDITED);
        }

        return new EditResidentCommand(index, editResidentDescriptor);
    }
}
