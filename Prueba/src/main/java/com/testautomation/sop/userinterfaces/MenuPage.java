package com.testautomation.sop.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {
    public static final Target LINK_MENU_ELEMENTOS= Target.the("link menu elementos").located(By.xpath("//div[@class='category-cards']//child::div[@class='card mt-4 top-card'][1]"));
    public static final Target LINK_MENU_TABLA= Target.the("link menu tabla").located(By.xpath("//ul[@class='menu-list']//child::li[@class='btn btn-light '][@id='item-3']"));
    public static final Target LINK_MENU_WIDGETS= Target.the("link menu widgets").located(By.xpath("//div[@class='category-cards']//child::div[@class='card mt-4 top-card'][4]"));
    public static final Target LINK_MENU_DATAPICKER= Target.the("link menu datapicker").located(By.xpath("//span[text() = 'Date Picker']//parent::li"));
    public static final Target LINK_MENU_ALERTSFRAME= Target.the("link menu alerts").located(By.xpath("//div[@class='category-cards']//child::div[@class='card mt-4 top-card'][3]"));
    public static final Target LINK_MENU_ALERTS= Target.the("link menu alerts").located(By.xpath("//span[text() = 'Alerts']//parent::li"));


}
