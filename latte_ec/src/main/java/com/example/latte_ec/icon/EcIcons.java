package com.example.latte_ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-13
 * Time: 11:07
 */
public enum EcIcons implements Icon {
    icon_ceshi('\ue628');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_','-');
    }

    @Override
    public char character() {
        return character;
    }
}
