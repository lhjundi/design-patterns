package com.lhjundi.factory_method.refactoring_guru.factory;

import com.lhjundi.factory_method.refactoring_guru.buttons.Button;
import com.lhjundi.factory_method.refactoring_guru.buttons.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    protected Button createButton() {
        return new HtmlButton();
    }
}
