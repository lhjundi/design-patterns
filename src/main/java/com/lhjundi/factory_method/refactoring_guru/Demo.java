package com.lhjundi.factory_method.refactoring_guru;

import com.lhjundi.factory_method.refactoring_guru.factory.Dialog;
import com.lhjundi.factory_method.refactoring_guru.factory.HtmlDialog;
import com.lhjundi.factory_method.refactoring_guru.factory.WindowsDialog;

public class Demo {
    private static Dialog dialog;

    void main(){
        configure();
        runBusinessLogic();
    }


    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    private void configure() {
        if (System.getProperty("os.name").equals("Windows 11")){
            dialog = new WindowsDialog();
        } else{
            dialog = new HtmlDialog();
        }
    }


    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    private void runBusinessLogic() {
        dialog.renderWindow();
    }
}