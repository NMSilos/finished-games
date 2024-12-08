package com.github.nmsilos.gamesapi.util;

import org.apache.commons.lang3.StringUtils;

public class SlugUtil {

    public static String toSlug(String input) {
        return StringUtils.stripAccents(input)
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");
    }

}
