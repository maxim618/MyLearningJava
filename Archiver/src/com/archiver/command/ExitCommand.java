package com.archiver.command;

import com.archiver.ConsoleHelper;

public class ExitCommand extends ZipCommand {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
