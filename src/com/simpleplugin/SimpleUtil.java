package com.simpleplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.simpleplugin.psi.SimpleFile;
import com.simpleplugin.psi.SimpleProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimpleUtil {
    public static List<SimpleProperty> findProperties(Project project, String key) {
        List<SimpleProperty> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, SimpleFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                SimpleProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty.class);
                if (properties != null) {
                    for (SimpleProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            if (result == null) {
                                result = new ArrayList<SimpleProperty>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<SimpleProperty>emptyList();
    }

    public static List<SimpleProperty> findProperties(Project project) {
        List<SimpleProperty> result = new ArrayList<SimpleProperty>();
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, SimpleFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                SimpleProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}
