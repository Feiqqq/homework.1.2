package ru.vulfert.homework.task.service.impl;

import ru.vulfert.homework.task.service.ReplaceService;

public class ReplaceServiceImpl implements ReplaceService {
    @Override
    public String replace(String text, String oldWord, String newWorld) {
        return text.replace(oldWord.trim(), newWorld.trim());
    }
}
