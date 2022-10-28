package com.logger.Logger.enums;

import java.util.HashMap;
import java.util.Map;

public enum LogTypeEnum {
    INFO(0),
    WARNING(1),
    ERROR(2);

    private final int value;
    private static final Map<Integer, LogTypeEnum> BY_NUMBER = new HashMap<>();

    static {
        for(LogTypeEnum e : values()) {
            BY_NUMBER.put(e.value, e);
        }
    }

    LogTypeEnum(int typeNum){
        this.value = typeNum;
    }

    public static LogTypeEnum valueOfInt(int i){
        return BY_NUMBER.get(i);
    }

    public int  getValue() {
        return value;
    }

}
