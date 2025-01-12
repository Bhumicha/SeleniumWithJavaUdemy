package Section14to;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class JavaStreams {
    public static void regular()
    {

        ArrayList<String> names=new ArrayList<>();
        names.add("Bhumika");
        names.add("Don");
        names.add("Adam");
        int count=0;

        for(int i=0; i<names.size(); i++)
        {
           String actual= names.get(i);
           if(actual.startsWith("B"))
           {
               count++;
           }
        }
        System.out.println(count);
    }
    @Test
    public void StreamFilter()
    {
        ArrayList<String> names=new ArrayList<>();
        names.add("Bhumika");
        names.add("Don");
        names.add("Adam");
        names.add("Diana");

        Long c=names.stream().filter(s->s.startsWith("D")).count();
        System.out.println(c);
    }
}
