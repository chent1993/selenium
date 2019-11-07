package com.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.plaf.basic.BasicPopupMenuUI;

public class MaterialPage extends BasePage{
    //上传图片
    public int upload(String file){
        findElement(By.partialLinkText("图片")).click();
        findElement(By.partialLinkText("添加图片")).click();
        findElement(By.id("js_upload_input"),0).sendKeys(file);
        findElement(By.linkText("完成")).click();
        return Integer.valueOf(findElement(By.className("js_list_total")).getText());
    }
    //获取图片数量
    public int getNum(){
        return Integer.valueOf(findElement(By.className("js_list_total")).getText());
    }

    //上传图文
    public void ImageText(String title,String body,String file,String cover){
        findElement(By.partialLinkText("图文")).click();
        findElement(By.partialLinkText("添加图文")).click();
        findElement(By.id("js_mpNews_editor_wrap")).findElement(By.className("ww_editorTitleWrap")).click();
        findElement(By.id("js_mpNews_editor_wrap")).findElement(By.className("ww_editorTitle")).sendKeys(title);
        driver.switchTo().frame("ueditor_0");
        findElement(By.className("msg_mpNewsEditor_frameBody")).sendKeys(body);
        driver.switchTo().defaultContent();
        findElement(By.id("AttachFrame")).findElement(By.className("js_amrd_uploadFile")).sendKeys(file);

       ((JavascriptExecutor) driver).executeScript("document.getElementById('js_mpNews_editor_wrap').scrollTop=1000");
        findElement(By.className("msg_infoItem_coverPlaceHolder")).click();

        findElement(By.className("js_no_img")).findElement(By.className("ww_fileInput")).sendKeys(cover);

        findElement(By.linkText("确定")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        findElement(By.cssSelector("#js_mpNews_editor_wrap>.msg_edit_infoItem_Last>.js_amrd_save"),0).click();
    }
}