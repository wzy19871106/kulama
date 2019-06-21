package cn.shianxian.supervise.common.utils;

import java.util.UUID;

/**
 * UUID
 */
public class UUIDGenerator {

    public static String generatorUUID() {
        String s = UUID.randomUUID().toString();
        // delete "-"
        return s.replace("-", "");
    }

}
