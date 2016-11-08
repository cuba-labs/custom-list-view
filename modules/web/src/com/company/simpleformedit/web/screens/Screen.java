package com.company.simpleformedit.web.screens;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Frame;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.util.UUID;

public class Screen extends AbstractWindow {
    @Inject
    protected Metadata metadata;

    @Inject
    protected CollectionDatasource<User, UUID> usersDs;

    @Inject
    protected VBoxLayout editPane;

    public void addNewUser() {
        User user = metadata.create(User.class);
        user.setName("<New User name>");

        usersDs.addItem(user);

        Frame editFrame = openFrame(null, "itemFrame", ParamsMap.of("item", user));
        editPane.add(editFrame);
    }
}