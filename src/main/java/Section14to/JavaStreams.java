package Section14to;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        regular();
        JavaStreams js = new JavaStreams();
        js.streamFilter();
    }
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


    public void streamFilter()
    {
        ArrayList<String> names=new ArrayList<>();
        names.add("Bhumika");
        names.add("Don");
        names.add("Adam");
        names.add("Diana");
        Long c=names.stream().filter(s->s.startsWith("D")).count();
        System.out.println(c);

    long d=Stream.of("Bhumika","Don","Adam").filter(s->
        {
            s.startsWith("D");
            return true;
        }).count();
        System.out.println(d);
        names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

    }

    public void streamMap()
    {
        //print names in uppercase
        Stream.of("Bhumika","Don","Adam").filter(s->s.endsWith("m")).map(s->s.toUpperCase())
        .forEach(s->System.out.println(s));

        List<String> names1=Arrays.asList("", "Bhumika","Don","Adam");
        names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

    }
}


