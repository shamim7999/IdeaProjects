package com.first.springboot.helpers;

import org.springframework.ui.Model;

public class ModelTransporter {
    private static Model model;
    public static void setModel(Model model) {
        ModelTransporter.model = model;
    }

    public static Model getModel() {
        return model;
    }
}
