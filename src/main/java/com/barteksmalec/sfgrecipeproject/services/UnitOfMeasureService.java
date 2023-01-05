package com.barteksmalec.sfgrecipeproject.services;

import com.barteksmalec.sfgrecipeproject.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
