package com.Stone.Util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wed on 03.02.16.
 */
public class StringModule {

    public class StMod
    {
        private String ru="Unknown_Ru_Msg_";
        private String en="Unknown_En_Msg_";
        private String name="Unknown_Name";

        public StMod(String name) {
            this.name = name;
        }

        public void setRu(String ru) {
            this.ru = ru;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getRu() {
            return ru;
        }

        public String getEn() {
            return en;
        }

        public String getName() {
            return name;
        }
    }

    public enum Lng
    {
        None,Ru,En
    }

    static Map<String,StMod> _listString=new HashMap<>();

    public static String  getString(String name,Lng lng)
    {
        if(_listString.size()==0)
            new StringModule().LoadStrings();

        if(_listString.containsKey(name)) {
            switch (lng)
            {
                case Ru:
                    return _listString.get(name).getRu();
                default:
                    return _listString.get(name).getEn();
            }
        }

        return "No MSG";
    }

    public void LoadStrings()
    {
        _listString.clear();

        try {

            DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
            factory2.setValidating(false);
            factory2.setIgnoringComments(true);
            Document doc2 = factory2.newDocumentBuilder().parse(this.getClass().getResource("/Strings.xml").getFile());
            for (Node n2 = doc2.getFirstChild(); n2 != null; n2 = n2.getNextSibling()) {
                if ("st".equalsIgnoreCase(n2.getNodeName())) {
                    StMod mod=new StMod(getString(n2,"name",""));
                    for (Node d2 = n2.getFirstChild(); d2 != null; d2 = d2.getNextSibling()) {
                        if ("ru".equalsIgnoreCase(d2.getNodeName()))
                            mod.setRu(getString(d2,"value",""));
                        else if("en".equalsIgnoreCase(d2.getNodeName()))
                            mod.setEn(getString(d2,"value",""));
                    }
                    _listString.put(mod.getName(),mod);
                }
            }

        }catch (Exception e)
        {
            System.err.println("Faild load Strings: "+e);
        }
        }


    private String getString(Node n,String name,String defValue)
    {
        if(n.getAttributes().getNamedItem(name)==null)
            return defValue;
        return n.getAttributes().getNamedItem(name).getNodeValue();
    }

    private boolean getBoolean(Node n,String name,boolean defValue)
    {
        if(n.getAttributes().getNamedItem(name)==null)
            return defValue;
        return n.getAttributes().getNamedItem(name).getNodeValue().equals("1") || n.getAttributes().getNamedItem(name).getNodeValue().equals("true");
    }

    private Integer getInteger(Node n,String name,Integer defValue)
    {
        if(n.getAttributes().getNamedItem(name) == null)
            return defValue;
        return Integer.parseInt(n.getAttributes().getNamedItem(name).getNodeValue());
    }

    private Long getLong(Node n,String name,Long defValue)
    {
        if(n.getAttributes().getNamedItem(name) == null)
            return defValue;
        return Long.parseLong(n.getAttributes().getNamedItem(name).getNodeValue());
    }

    private boolean isSet(Node n,String name)
    {
        return n.getAttributes().getNamedItem(name).getNodeValue() != null;
    }

}
