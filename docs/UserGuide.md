---
layout: page
title: User Guide
---

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Introduction
**SunRez** is a desktop app designed for college residential staff to efficiently manage student housing services. It 
features a Graphical User Interface (GUI) but is optimized for use via a Command Line Interface (CLI).

**SunRez** has the following features:
* Keeps track of maintenance issues
* Keeps track of student records
* Keeps track of room records

## About this Guide

### User Interface

### Command Format

Commands in this user guide follow this format:

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `radd n/NAME ...`, `NAME` is a parameter which can be used as `radd n/John Doe ...`.

* Items in square brackets are optional.<br>
  e.g. `d/DESCRIPTION [t/TIMESTAMP]` can be used as `d/Broken chair t/2020/3/23 11:59pm` or as `d/Broken chair`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `n/John Doe n/Jane Doe`, only `n/Jane Doe` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `ilist`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.


### Command Parameters

Many SunRez commands use various parameters. Their formats, constraints and rationale are provided in this subsection.

#### `ALIAS_NAME`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `CATEGORY`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `COMMAND`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `COUNT`
The number of items wanted (from some collection).
* Must be a positive integer: 1, 2, 3, ...
* Must be at most the size of the collection of items (this number depends on the relevant collection).


#### `DESCRIPTION`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `EMAIL`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `INDEX`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `KEYWORD`
Keyword used in commands such as find
* Format: Single word consisting of any character except spaces.
* For best usage: Use English characters only.


#### `NAME`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `PHONE_NUMBER`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `ROOM_NUMBER`
Room number for a room
* Format: `XY-YYY`, where `X` is an integer from 1-9 inclusive, while `Y` is an integer from 0-9 inclusive. The hyphen is necessary.
    * Valid examples: 01-000, 11-100, 12-345
    * Invalid examples: 00-000, 00-100
* Room numbers are unique within the SunRez
* We disallow floor numbers being 00, as that is not a common practice in Singapore. However, unit numbers can be 000.


#### `ROOM_TYPE`
DESCRIPTION OF PARAMETER
* Format: One of the following strings: `corridor_ac`, `corridor_non_ac`, `suite_ac`, `suite_non_ac`.
* Strings are not case-sensitive.


#### `STATUS`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `TAG`
The tag associated with a room or issue.
* Tags must be non-blank and alphanumeric (spaces are not allowed).
* Tags are limited to 25 characters.
* Tags are case-sensitive: e.g. `SHN`,`shn` and `Shn` are each considered separate tags.
* Duplicate tags will be accepted as input, but only one instance will be recorded.
* For the best experience, we recommend keeping tags short and having fewer than 20 of them per entry. There is no 
  theoretical limit to the number of tags an entry can have, but SunRez may slow down or run into unexpected problems 
  for a huge number of tags.


#### `TIMESTAMP`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)


#### `YEAR`
DESCRIPTION OF PARAMETER
* FORMAT AND RESTRICTIONS WITH JUSTIFICATION
* (if applicable) For best usage, ...
* (if applicable) Valid examples (if not clear from above)



## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `sunrez.jar` from [here](https://github.com/AY2021S2-CS2103-T14-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your SunRez.

4. Double-click the file to start the app. A GUI like the one pictured below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type a command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * **`rlist`** : Lists all residents.

    * **`radd`**`n/Joseph Tan p/84666774 e/e0103994@u.nus.edu y/2` : Adds a resident named `Joseph Tan` with phone number `84666774`, email `e0103994@u.nus.edu`, a 2nd year student.

    * **`rdel`**`3` : Deletes the 3rd resident shown in the current resident list.

    * **`exit`** : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

This section contains the details on SunRez commands and features. 

### Resident Management

#### Add a resident : `radd`

Adds a resident to the housing management system.

Format: `radd n/NAME p/PHONE_NUMBER e/EMAIL y/YEAR`
* `NAME` is the unique identifier of a resident.

Examples:
* `radd n/John Doe p/91234567 e/e0123456@u.nus.edu y/3` Adds a resident named `John Doe` with phone number `91234567`, email `e0123456@u.nus.edu`, and as a 3rd year student, without any room allocated.


#### List all residents : `rlist`

Shows a list of all residents in the system sorted by alphabetical order.

Format: `rlist`


#### Find residents : `rfind`

Finds residents whose names contain any of the given keywords.

Format: `rfind KEYWORD [MORE_KEYWORDS]`
* The search is case-insensitive. e.g. `hans` will match `Hans`.
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`.
* Residents matching at least one keyword will be returned (i.e. OR search). e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`.

Examples:
* `rfind john` returns `john` and `John Doe`.
* `rfind alex david` returns `Alex Yeoh`, `Alexander Graham`, and `David Li`.


#### Edit a resident record : `redit`

Edits the existing resident record at a specified index.

Format: `redit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL]`
* `INDEX` refers to the index number shown in the displayed resident list. `INDEX` **must be a positive integer: 1, 2, 3, …**.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* `redit` will be blocked if the resident has an active room allocation. Run `dealloc` before making further edits.
e.g. `dealloc n/John Tan r/03-100`.

Example:
* `redit 1 p/91234567 e/e0123456@u.nus.edu` Edits the phone number and email address of the 1st resident to be `91234567` and `e0123456@u.nus.edu` respectively.


#### Delete a resident : `rdel`

Deletes the resident record at a specified index.

Format: `rdel INDEX`
* `INDEX` refers to the index number shown in the displayed resident list. `INDEX` **must be a positive integer 1,2,3, ...**.
*  A resident allocated to a room cannot be deleted until it is first deallocated. Run `dealloc` commmand before deletion.
e.g. `dealloc n/John Tan r/03-100`.

Example:
* `rdel 1` deletes the 1st resident in the resident list.

### Room Management

<div markdown="block" class="alert alert-secondary">
:thinking: Why do room commands start with `o`?<br>
:point_right: Room commands are prefixed with `o` as `r` is taken up by Resident commands. `o` is the second character in R**o**om. 
</div>

#### Add a room : `oadd`

Adds a room to the housing management system.

Format: `oadd r/ROOM_NUMBER t/ROOM_TYPE [g/TAG]`
* Room is initialised with default occupancy status of "No".
* The occupancy status cannot be defaulted to "Yes" during room addition.
* Room occupancy status can only be changed through the `alloc` or `dealloc` command when a resident is allocated or deallocated. See [allocate a resident](#allocate-resident-to-room-alloc) or [deallocate a resident](#deallocate-resident-from-room--dealloc) for more info. 
  
Parameters:
* [ROOM_NUMBER](#room_number) The room number of the room to add.
* [ROOM_TYPE](#room_type) The type of the room being added.
* [TAG](#tag) Optional tags that may be specified to assist in management of the room.

Example:
* `oadd r/10-112 t/corridor_ac g/SHN` Adds a room numbered `10-112` of type `corridor_ac` with the tag `SHN`.


#### List all rooms : `olist`

Shows a list of all rooms in the system sorted by room number.

Format: `olist`


#### Find rooms : `ofind`

Finds all rooms by room number or tag that contain any of the given keywords.

Format: `ofind KEYWORD [MORE_KEYWORDS]`
* The search matches any part of the room number. e.g. `10` will match `10-111` and `14-101`.
* The search for tags matches any part of the tag and is NOT case-sensitive. e.g `mell`, `smell`, `smelly` or `room` all work to match `smellyroom`. `s` will match both `smellyroom` and `SHN`.
* The order of the keywords does not matter. e.g. `11- 10-` will match `10-100`, `10-101`, `11-100`, and `11-101`.
* Only the room number and tags are searched.
* Rooms matching at least one keyword will be returned (i.e. OR search). e.g. `10 20` will return `10-100`, `11-120`.

Parameters:
* [KEYWORD](#keyword) The keyword to search for in the room list

Examples:
* `ofind 10-` returns `10-100`, `10-101`, and `10-102`.
* `ofind 10- 15-` returns `10-100`, `10-101`, `15-100`, and`15-101`.
* `ofind 10` returns `09-100`, `09-110`, `10-100`, and `10-101`.
* `ofind s` returns `SHN` and `smellyroom`.
* `ofind 1 s` returns `10-100` and `SHN`.


#### Edit a room record : `oedit`

Edits the existing room record at a specified index.

Format: `oedit INDEX [r/ROOM_NUMBER] [t/ROOM_TYPE] [g/TAG]`
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* `oedit` will be blocked if the room is occupied. Run [`dealloc`](#deallocate-resident-from-room-dealloc) to deallocate the room before making further edits.
* The occupancy status is not controllable through the `oedit` command.
* Room occupancy status can only be changed through the `alloc` or `dealloc` command when a resident is allocated or deallocated. See [allocate a resident](#allocate-resident-to-room-alloc) or [deallocate a resident](#deallocate-resident-from-room--dealloc) for more info.   


Parameters:
* [INDEX](#index) The index of the room to edit.
* [ROOM_NUMBER](#room_number) The room number to change the room identified by [INDEX](#index) to.
* [ROOM_TYPE](#room_type) The room type to change the room identified by [INDEX](#index) to.
* [TAG](#tag) Optional tags that may be updated for the room identified by [INDEX](#index).

Example:
* `oedit 1 g/SHN g/Blue` Edits the 1st room's tags to `SHN` and `Blue`.


#### Delete a room : `odel`

Deletes the room at a specified index.

Format: `odel INDEX`
* `odel` will be blocked if the room is occupied. Run [`dealloc`](#deallocate-resident-from-room-dealloc) to deallocate the room before attempting to delete the room.

Parameters:
* [INDEX](#index) The index of the room to delete.

Example:
* `odel 1` Deletes the 1st room in the room list.

### Room Allocation/Deallocation

#### List all unallocated residents : `rulist`

Shows a list of all unallocated residents in the system sorted by alphabetical order.

Format: `rulist`

#### Allocate resident to room: `alloc`
Allocates an existing resident to an existing room.

Format: `alloc n/NAME r/ROOM_NUMBER`
* `NAME` and `ROOM_NUMBER` must already exist.
* Exact match for `NAME` is required.
* `NAME` is case-sensitive.
* Both fields must be provided.

Example:
* `alloc r/John Tan n/03-100` Allocates resident named John Tan to room 03-100.

#### Deallocate resident from room: `dealloc`
Deallocates an existing resident from an existing room.

Format: `dealloc INDEX`
* `INDEX` refers to the index number shown in the displayed resident list. `INDEX` **must be a positive integer 1,2,3, ...**.
* The resident at the `INDEX` must already be allocated.

Example:
* `dealloc 1` Deallocates the 1st resident in the resident list from its allocated room.

### Issue Management

#### Add an open issue : `iadd`

Adds an issue to the housing management system.

Format: `iadd r/ROOM_NUMBER d/DESCRIPTION [t/TIMESTAMP] [s/STATUS] [c/CATEGORY] [g/TAG]`

Example:
* `iadd r/10-100 d/Broken light c/Furniture` Creates an issue for room number `10-100` with description `Broken light` under the category `Furniture`.


#### List all issues : `ilist`

Shows a list of all issues in the system sorted by their timestamp.

Format: `ilist`


#### Find issues : `ifind`

Finds all issues that contain any of the given keywords in the description, room number or tags.

Format: `ifind KEYWORD [MORE_KEYWORDS]`
* The search is case-insensitive. e.g. `broken` will match `Broken`.
* The order of the keywords does not matter. e.g. `Broken light` will match `light broken`.
* The search for tags and description matches any part of the tag and is NOT case-sensitive. e.g `high`, `HIGH` or `h` all work to match `High`. `H` will match both `Hot` and `High`.
* The search matches any part of the room number. e.g. `10` will match `10-111` and `14-101`.
* Only the description, room number, and tags are searched.
* Issues matching at least one keyword will be returned (i.e. OR search). e.g. `Broken window` will return `Broken light`, `Dirty window`, and `Broken window`.

Examples:
* `ifind chair` returns `Broken chair` and `Chair missing wheel`.
* `ifind wardrobe table` returns `Wardrobe door broke`, `Table unstable`, and `Table stuck in wardrobe`.
* `ifind 1 s` returns room number `10-100`, description `Table unstable` and tag `Insect` as they all either contain `1` or the string `s`.


#### Edit an issue record : `iedit`

Edits the existing issue record at a specified index.

Format: `iedit INDEX [r/ROOM_NUMBER] [d/DESCRIPTION] [t/TIMESTAMP] [s/STATUS] [c/CATEGORY] [g/TAG]`
* `INDEX` refers to the index number shown in the displayed issue list. `INDEX` **must be a positive integer 1, 2, 3, …**.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Example:
* `iedit 1 r/20-109 s/Closed` Edits the room number and status of the 1st issue to be `20-109` and `Closed` respectively.


#### Close an issue : `iclo`

Marks as closed the issue at a specified index.

Format: `iclo INDEX`
* `INDEX` refers to the index number shown in the displayed issue list. `INDEX` **must be a positive integer 1, 2, 3, …**.

Example:
* `iclo 1` Closes the 1st issue.


#### Delete an issue : `idel`

Deletes the issue at a specified index.

Format: `idel INDEX`
* `INDEX` refers to the index number shown in the displayed resident list. `INDEX` **must be a positive integer 1,2,3, ...**.

Example:
* `idel 1` Deletes the 1st issue.

### General

#### Show help : `help`

Shows a message explaining how to access the help page.

Format: `help`

#### Delete all data : `clear`

Deletes all rooms, residents and issues in SunRez.

Format: `clear`

#### Undo previous command : `undo`

Restores SunRez to its state before an _undoable_ command was executed.

<div markdown="block" class="alert alert-info">

**:information_source: _Undoable_ command:**<br>
An undoable command is one which modifies the data of SunRez.

e.g. `radd`, `redit`, `idel`, `clear`, etc.
</div>

Format: `undo`

Examples:
* `rdel 1` <br>
  `undo` Undoes the `rdel 1` command.

* `iedit 1 r/20-109 s/Closed` <br>
  `clear` <br>
  `undo` Undoes the `clear` command. <br>
  `undo` Undoes the `iedit 1 r/20-109 s/Closed` command.

* `history 5` <br>
  `undo` Fails because `history 5` did not modify SunRez's data.

<div markdown="block" class="alert alert-info">

**:information_source: Shortcuts to undo:**<br>
1. **GUI:** Select `Edit` -> `Undo` in the menu at the top of SunRez.
2. **Keyboard:** Press `CTRL+Z` (Windows, Linux) or `CMD+Z` (Mac).

These behave as if you entered `undo` in the command box and hit `ENTER`; an `undo` command will be registered in
command history.
</div>

#### Redo previously undone command: `redo`

Reverses the previous undo operation.

Format: `redo`

Examples:
* `rdel 1` <br>
  `undo` Undoes the `rdel 1` command.
  `redo` Redoes the `rdel 1` command.

* `rdel 1` <br>
  `redo` Fails because there are no previous `undo` commands.

* `iedit 1 r/20-109 s/Closed` <br>
  `clear` <br>
  `undo` Undoes the `clear` command. <br>
  `undo` Undoes the `iedit 1 r/20-109 s/Closed` command. <br>
  `redo` Redoes the `iedit 1 r/20-109 s/Closed` command. <br>
  `redo` Redoes the `clear` command.

<div markdown="block" class="alert alert-info">

**:information_source: Shortcuts to redo:**<br>
1. **GUI:** Select `Edit` -> `Redo` in the menu at the top of SunRez.
2. **Keyboard:** Press `CTRL+SHIFT+Z` (Windows, Linux) or `CMD+SHIFT+Z` (Mac).

These behave as if you entered `redo` in the command box and hit `ENTER`; a `redo` command will be registered in
command history.
</div>

#### Add an alias : `alias`

Adds a user-defined alias, which represents a shortcut to a longer command.

Format: `alias a/ALIAS_NAME cmd/COMMAND`
* Parameters must be in this exact order.
* Any parameters after `cmd/` will be parsed as part of the command.

Examples:
* `alias a/ol cmd/olist` Adds the `ol` alias which is a shortcut for `olist` command.
* `alias a/fNemo cmd/rfind Nemo` Adds the `fNemo` alias which is a shortcut for `rfind Nemo` command.

#### Delete an alias : `unalias`

Deletes a previously defined alias.

Format: `unalias a/ALIAS_NAME`

Example:
* `unalias a/findBob` Deletes the `findBob` alias, provided that the alias was previously added.

#### List all aliases : `aliases`

Shows a list of current aliases in the system sorted by their time of creation.

Format: `aliases`

#### View command history : `history`

Displays the user's valid command history, sorted from most to least recent.

Format: `history [COUNT]`
* Displays the `COUNT` most recent command entries, if `COUNT` is specified. Otherwise, displays all command entries.

Parameters:
* [`COUNT`](#count) The number of most recent command entries to display.

Examples:
* `history` Displays all command entries.
* `history 5` Displays the 5 most recent command entries.

#### Access command history

Previous successful commands can be accessed via the UP and DOWN arrow keys on the keyboard. 
UP selects the previous command. DOWN selects the next command.

Example usage:
1. Enter some commands as per normal.
1. Make sure the command box is in focus (e.g. click on it).
1. Press the UP arrow key on your keyboard.
1. SunRez should display the most recent successful command in the command box.
    * Hit ENTER to run that command again.
    * Alternatively, select other commands via the UP and DOWN arrow keys.

#### Exit the program : `exit`

Exits the program.

Format: `exit`

### SunRez Data Files

SunRez main application data and command history are saved in the hard disk automatically after any command
that changes the data. There is no need to save manually.

#### Undo/redo history

Undo/redo history is not saved to the hard disk, so it will be lost when SunRez is exited.

#### Edit the data files

* SunRez main application data is saved as a JSON file `[JAR_file_location]/data/sunrez.json`.
* SunRez command history is saved as a plain-text file `[JAR_file_location]/data/commandhistory.txt`.
    * Each command history entry is a single line in the file.
    * The entire command history can be cleared by simply deleting the contents of the command history file.

Advanced users are welcome to edit these files directly.

<div markdown="span" class="alert alert-warning">
**Caution**: <br>
If your changes to the data file makes its format invalid, SunRez will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

### How do I transfer my data to another computer?
* On the computer with your data, do the following:
    1. Navigate to where SunRez is installed: the location of `sunrez.jar`.
    1. Copy the following files to your other computer: `preferences.json`, `data/commandhistory.txt`, 
       `data/sunrez.json`
* Then, on your other computer, do the following:
    1. Download SunRez (`sunrez.jar`) and place it in a suitable folder.
    1. Paste the files from earlier in this folder. If prompted to replace existing files, do so.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Show help** | `help`
**Add a resident** | `radd n/NAME p/PHONE_NUMBER e/EMAIL y/YEAR` <br> e.g. `radd n/Joseph Tan p/84666774 e/e0103994@u.nus.edu y/2`
**List all residents** | `rlist`
**List all unallocated residents** | `rulist`
**Find residents** | `rfind KEYWORD [MORE_KEYWORDS]` <br> e.g. `rfind bob bobby`
**Edit a resident record** | `redit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL]` <br> e.g. `redit 1 p/91234567 e/e0123456@u.nus.edu`
**Delete a resident** |  `rdel INDEX` <br> e.g. `rdel 1`
**Add a room** |  `oadd r/ROOM_NUMBER t/ROOM_TYPE [g/TAG]` <br> e.g. `oadd r/17-101 t/corridor_ac g/SHN`
**List all rooms** |  `olist`
**Find rooms** |  `ofind KEYWORD [MORE_KEYWORDS]` <br> e.g. `ofind 10- 15-`
**Edit a room record** |  `oedit INDEX [r/ROOM_NUMBER] [t/ROOM_TYPE] [g/TAG]` <br> e.g. `oedit 1 g/SHN`
**Delete a room** | `odel INDEX` <br> e.g. `odel 1`
**Allocate a Resident to Room** | `alloc n/NAME r/ROOM_NUMBER` <br> e.g. `alloc n/John Tan r/03-100`
**Deallocate a Resident from Room** | `dealloc n/NAME r/ROOM_NUMBER` <br> e.g. `dealloc n/John Tan r/03-100`
**Add an open issue** | `iadd r/ROOM_NUMBER d/DESCRIPTION [t/TIMESTAMP] [s/STATUS] [c/CATEGORY] [g/TAG]` <br> e.g. `iadd r/10-100 d/Broken light c/Furniture g/HIGH`
**List all issues** | `ilist`
**Find issues** | `ifind KEYWORD [MORE_KEYWORDS]` <br> e.g. `ifind wardrobe table`
**Edit an issue record** | `iedit INDEX [r/ROOM_NUMBER] [d/DESCRIPTION] [t/TIMESTAMP] [s/STATUS] [c/CATEGORY] [g/TAG]` <br> e.g. `iedit 1 r/20-109 s/Closed`
**Close an issue** | `iclo INDEX` <br> e.g. `iclo 1`
**Delete an issue** | `idel INDEX` <br> e.g. `idel 1`
**View command history** | `history [COUNT]` <br> e.g. `history 5`
**Undo previous command** | `undo` <br> `CTRL+Z`/`CMD+Z` (keyboard shortcuts)
**Redo previously undone command** | `redo` <br> `CTRL+SHIFT+Z`/`CMD+SHIFT+Z` (keyboard shortcuts)
**Add an alias** | `alias a/ALIAS_NAME cmd/COMMAND` <br> e.g. `alias a/il cmd/ilist`
**Delete an alias** | `unalias a/ALIAS_NAME` <br> e.g. `unalias a/findBob`
**List all aliases** | `aliases`
**Delete all data** | `clear`
**Exit the app** | `exit`
