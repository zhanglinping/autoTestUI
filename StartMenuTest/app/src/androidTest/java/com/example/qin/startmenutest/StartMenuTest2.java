package com.example.qin.startmenutest;

import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;


/**
 * Created by qin on 9/7/17.
 */

public class StartMenuTest2 extends UiAutomatorTestCase {

    //暂时不支持菜单
    public void test0Preparation() throws UiObjectNotFoundException, IOException{
        UiDevice uiDevice = getUiDevice();
        uiDevice.pressHome();
        sleep(2000);

        //删除常用软件列表的应用，为后续常用软件测试做准备
        while (new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/lv_usually_view")).exists()) {
            if (new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/lv_usually_view")).exists()) {
                UiScrollable functionItems = null;
                functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/lv_usually_view"));
                UiObject apps = null;
                functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).longClick();
                new UiObject(new UiSelector().text("从此列表中删除")).click();
            }
            sleep(1000);
        }
    }

    public void test1OfTools() throws UiObjectNotFoundException, IOException {
        UiDevice uiDevice = getUiDevice();

        //搜索测试
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/et_text")).setText("VLC");
        sleep(1000);

        UiScrollable functionItems = null;
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        UiObject apps = null;
        apps = functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1);
        String app_Search = apps.getChild(new UiSelector().className("android.widget.TextView")).getText().toString();
        Log.d("AAAAAAAAA",app_Search);
        assertTrue(app_Search.equals("VLC"));

        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/et_text")).setText("");
        sleep(1000);

        //排序测试
        //A-Z 正序
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/iv_arrow_white")).click();
        new UiObject(new UiSelector().text("A-Z")).click();
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        apps = functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1);
        String app_Seq1 = apps.getChild(new UiSelector().className("android.widget.TextView")).getText().toString();
        Log.d("AAAAAAAAA",app_Seq1);
        assertTrue(app_Seq1.equals("Internet 浏览器"));

        //A-Z 逆序
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/tv_sort_show")).click();
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        apps = functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1);
        String app_Seq2 = apps.getChild(new UiSelector().className("android.widget.TextView")).getText().toString();
        Log.d("AAAAAAAAA",app_Seq2);
        assertTrue(app_Seq2.equals("终端控制台"));

        //使用频率
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/iv_arrow_white")).click();
        new UiObject(new UiSelector().text("使用频率")).click();
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/tv_sort_show")).click();
        //安装时间
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/iv_arrow_white")).click();
        new UiObject(new UiSelector().text("安装时间")).click();
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/tv_sort_show")).click();
    }
    public void test2OfAllApp() throws UiObjectNotFoundException, IOException {
        UiDevice uiDevice = getUiDevice();

        //单击打开应用
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/et_text")).setText("计算器");
        sleep(1000);
        UiScrollable functionItems = null;
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).click();
        assertTrue(new UiObject(new UiSelector().text("log")).exists());
        uiDevice.executeShellCommand("am force-stop com.android.calculator2");
        uiDevice.pressHome();

        //菜单打开应用
        //暂时不支持菜单
        /*new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/et_text")).setText("计算器");
        sleep(1000);
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).longClick();
        new UiObject(new UiSelector().text("打开")).click();
        sleep(2000);
        assertTrue(new UiObject(new UiSelector().text("log")).exists());
        uiDevice.executeShellCommand("am force-stop com.android.calculator2");
        uiDevice.pressHome();

        //菜单手机模式
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/et_text")).setText("计算器");
        sleep(1000);
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).longClick();
        new UiObject(new UiSelector().text("以手机模式运行")).click();
        sleep(2000);
        assertTrue(new UiObject(new UiSelector().text("log")).exists());
        uiDevice.executeShellCommand("am force-stop com.android.calculator2");
        uiDevice.pressHome();

        //菜单桌面模式
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/et_text")).setText("计算器");
        sleep(1000);
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).longClick();
        new UiObject(new UiSelector().text("以桌面模式运行")).click();
        sleep(2000);
        assertTrue(new UiObject(new UiSelector().text("log")).exists());
        uiDevice.executeShellCommand("am force-stop com.android.calculator2");
        uiDevice.pressHome();

        //菜单固定到任务栏
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/et_text")).setText("计算器");
        sleep(1000);
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/gv_view"));
        functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).longClick();
        new UiObject(new UiSelector().text("固定到任务栏")).click();
        sleep(2000);

        //菜单解除固定
        functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).longClick();
        new UiObject(new UiSelector().text("解除固定")).click();
        sleep(2000);

        //菜单卸载
        functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1).longClick();
        new UiObject(new UiSelector().text("卸载")).click();
        sleep(2000);
        assertTrue(new UiObject(new UiSelector().text("停用")).exists());
        new UiObject(new UiSelector().resourceId("android:id/mwCloseBtn")).click();
        uiDevice.pressHome();*/
    }
    //由于不支持菜单，常用软件暂时无法测试
    /*public void test3OfFreqApp() throws UiObjectNotFoundException, IOException {
        //确认常用软件的第一位是否时计算器
        UiDevice uiDevice = getUiDevice();
        UiScrollable functionItems = null;
        functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/lv_usually_view"));
        UiObject apps = null;
        apps = functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1);
        String app_Freq = apps.getChild(new UiSelector().className("android.widget.TextView")).getText().toString();
        Log.d("AAAAAAAAA",app_Freq);
        assertTrue(app_Freq.equals("计算器"));

        if (app_Freq.equals("计算器")){
            //单击打开
            UiObject app_Cal = apps.getChild(new UiSelector().className("android.widget.TextView"));
            app_Cal.click();
            sleep(2000);
            assertTrue(new UiObject(new UiSelector().text("log")).exists());
            uiDevice.executeShellCommand("am force-stop com.android.calculator2");
            uiDevice.pressHome();

            //菜单打开
            app_Cal.longClick();
            new UiObject(new UiSelector().text("打开")).click();
            sleep(2000);
            assertTrue(new UiObject(new UiSelector().text("log")).exists());
            uiDevice.executeShellCommand("am force-stop com.android.calculator2");
            uiDevice.pressHome();

            //菜单手机模式
            app_Cal.longClick();
            new UiObject(new UiSelector().text("以手机模式运行")).click();
            sleep(2000);
            assertTrue(new UiObject(new UiSelector().text("log")).exists());
            uiDevice.executeShellCommand("am force-stop com.android.calculator2");
            uiDevice.pressHome();

            //菜单桌面模式
            app_Cal.longClick();
            new UiObject(new UiSelector().text("以桌面模式运行")).click();
            sleep(2000);
            assertTrue(new UiObject(new UiSelector().text("log")).exists());
            uiDevice.executeShellCommand("am force-stop com.android.calculator2");
            uiDevice.pressHome();

            //菜单删除
            app_Cal.longClick();
            new UiObject(new UiSelector().text("从此列表中删除")).click();

            if (! new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/lv_usually_view")).exists()) {
                assertTrue(true);
                Log.d("AAAAAAAAA","常用软件已清空");
            }else {
                functionItems = new UiScrollable(new UiSelector().resourceId("com.android.startupmenu:id/lv_usually_view"));
                apps = functionItems.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 1);
                String app_FreqNew = apps.getChild(new UiSelector().className("android.widget.TextView")).getText().toString();
                Log.d("AAAAAAAAA","常用软件列表有其它项: "+ app_FreqNew);
                assertTrue(! app_FreqNew.equals("计算器"));
            }
        }
    }*/

    public void test4OfSysApp() throws UiObjectNotFoundException, IOException {
        //测试文件管理器打开
        UiDevice uiDevice = getUiDevice();
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/openthos_file_manager")).click();
        sleep(2000);
        assertTrue(new UiObject(new UiSelector().text("计算机")).exists());
        new UiObject(new UiSelector().resourceId("android:id/mwCloseBtn")).click();
        uiDevice.pressHome();

        //测试设置打开
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/system_setting")).click();
        sleep(2000);
        assertTrue(new UiObject(new UiSelector().text("蓝牙")).exists());
        new UiObject(new UiSelector().resourceId("android:id/mwCloseBtn")).click();
        uiDevice.pressHome();

        //测试电源打开
        new UiObject(new UiSelector().resourceId("com.android.startupmenu:id/power_off")).click();
        sleep(2000);
        assertTrue(new UiObject(new UiSelector().text("睡眠")).exists());
        new UiObject(new UiSelector().resourceId("com.android.powersource:id/power_close")).click();
    }
}