/*
 * TODO Copyright
 */

package com.company.simpleformedit.web.screens;

import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractFrame;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.DsBuilder;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.util.Map;

public class ItemFrame extends AbstractFrame {
    @Inject
    protected TextField valueField;
    @Inject
    protected Label valueLabel;
    @WindowParam
    private User item;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        Datasource userDs = new DsBuilder()
                .setJavaClass(User.class)
                .setAllowCommit(false)
                .buildDatasource();

        userDs.invalidate();

        valueField.setDatasource(userDs, "name");
        valueLabel.setDatasource(userDs, "name");

        userDs.refresh();
        userDs.setItem(item);
    }

    public void switchMode() {
        valueField.setVisible(!valueField.isVisible());
        valueLabel.setVisible(!valueLabel.isVisible());

        if (valueField.isVisible()) {
            valueField.requestFocus();
        }
    }
}