package com.logger.Logger.enums;

import java.util.HashMap;
import java.util.Map;

public enum LogTypeEnum {
    INFO(0),
    WARNING(1),
    ERROR(2);

    private final int typeNum;
    private static final Map<Integer, LogTypeEnum> BY_NUMBER = new HashMap<>();

    static {
        for(LogTypeEnum e : values()) {
            BY_NUMBER.put(e.typeNum, e);
        }
    }

    LogTypeEnum(int typeNum){
        this.typeNum = typeNum;
    }

    public static LogTypeEnum valueOfInt(int i){
        return BY_NUMBER.get(i);
    }

}
