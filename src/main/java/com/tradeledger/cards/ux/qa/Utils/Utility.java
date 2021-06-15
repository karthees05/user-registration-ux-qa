package com.tradeledger.cards.ux.qa.Utils;

import com.tradeledger.cards.ux.qa.steps.StepDefs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static void takeScreenShot(final WebDriver driver) {
        String fileName = "";
        DateFormat dateFormat = new SimpleDateFormat("-dd-MM-yy-hhmmss");
        Date date = new Date();
        fileName += dateFormat.format(date);
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("target/snapshots/" + StepDefs.scenarioName + fileName + ".jpg"));
        } catch (Exception e) {
            System.out.println("Failed to access the Snapshots directory");
        }
    }

}
