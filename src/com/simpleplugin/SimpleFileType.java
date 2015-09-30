package com.simpleplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SimpleFileType extends LanguageFileType {
    public static final SimpleFileType INSTANCE = new SimpleFileType();

    public static final String EXTENSION = "tencent";

    private SimpleFileType() {
        super(SimpleLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Tencent file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Tencent language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SimpleIcons.FILE;
    }
}