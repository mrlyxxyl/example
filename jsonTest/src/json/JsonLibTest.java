package json;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class JsonLibTest {

	/*
     *  普通类型、List、Collection等都是用JSONArray解析
	 *  
	 *  Map、自定义类型是用JSONObject解析
	 *  可以将Map理解成一个对象，里面的key/value对可以理解成对象的属性/属性值
	 *  即{key1:value1,key2,value2......}
	 * 
	 * 1.JSONObject是一个name:values集合，通过它的get(key)方法取得的是key后对应的value部分(字符串)
	 * 		通过它的getJSONObject(key)可以取到一个JSONObject，--> 转换成map,
	 * 		通过它的getJSONArray(key) 可以取到一个JSONArray ，
	 * 
	 * 
	 */

    @Test
    public void writeJsonFile() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "id1");
        jsonObject.put("name", "nanmeiyng");


        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("id", "id2");
        jsonObject.put("name", "nanmeiyng2");
        jsonArray.add(jsonObject);

        FileWriter writer = new FileWriter("e:/testarray.json");
        jsonArray.write(writer);
        writer.close();
    }

    @Test
    public void testJSONToObject1() throws Exception {
//        String json = "{id:1,name:\"nanmeiying\",age:34}";
        FileInputStream fis = new FileInputStream("e:/testarray.json");
        StringBuffer sb = new StringBuffer();
        int i;
        byte[] buff = new byte[1024];
        while ((i = fis.read(buff)) > 0) {
            String str = new String(buff, 0, i);
            sb.append(str);
        }
        fis.close();
        JSONArray jsonArray = JSONArray.fromObject(sb.toString());
        Object[] objects = jsonArray.toArray();
        List<People> list = getObjs(objects, People.class);
        for (People p : list) {
            System.out.println(p);
        }

    }

    public List getObjs(Object[] objects, Class clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List list = new ArrayList();
        Object o;
        Map<String, String> map;
        for (Object obj : objects) {
            map = (Map<String, String>) obj;
            o = clazz.newInstance();
            BeanUtils.populate(o, map);
            list.add(o);
        }
        return list;
    }


    //一般数组转换成JSON
    @Test
    public void testArrayToJSON() {
        boolean[] boolArray = new boolean[]{true, false, true};
        JSONArray jsonArray = JSONArray.fromObject(boolArray);
        System.out.println(jsonArray);        // prints [true,false,true]
    }


    //Collection对象转换成JSON
    @Test
    public void testListToJSON() {
        List list = new ArrayList();
        list.add("first");
        list.add("second");
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        // prints ["first","second"]
    }


    //字符串json转换成json， 根据情况是用JSONArray或JSONObject
    @Test
    public void testJsonStrToJSON() {
        JSONArray jsonArray = JSONArray.fromObject("['json','is','easy']");
        System.out.println(jsonArray);
        // prints ["json","is","easy"]
    }


    //Map转换成json， 是用jsonObject
    @Test
    public void testMapToJSON() {
        Map map = new HashMap();
        map.put("name", "json");
        map.put("bool", Boolean.TRUE);
        map.put("int", new Integer(1));
        map.put("arr", new String[]{"a", "b"});
        map.put("func", "function(i){ return this.arr[i]; }");

        JSONObject jsonObject = JSONObject.fromObject(map);
        System.out.println(jsonObject);
    }

    //复合类型bean转成成json
    @Test
    public void testBeadToJSON() {
        MyBean bean = new MyBean();
        bean.setId("001");
        bean.setName("yinhangka");
        bean.setDate(new Date());

        List cardNum = new ArrayList();
        cardNum.add("nonghang");
        cardNum.add("gh");
        cardNum.add("jh");
        cardNum.add(new Person("test"));

        bean.setCardNum(cardNum);

        JSONObject jsonObject = JSONObject.fromObject(bean);
        System.out.println(jsonObject);

    }

    //普通类型的json转换成对象
    @Test
    public void testJSONToObject() throws Exception {
        String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        System.out.println(jsonObject);
        Object bean = JSONObject.toBean(jsonObject);
        assertEquals(jsonObject.get("name"), PropertyUtils.getProperty(bean, "name"));
        assertEquals(jsonObject.get("bool"), PropertyUtils.getProperty(bean, "bool"));
        assertEquals(jsonObject.get("int"), PropertyUtils.getProperty(bean, "int"));
        assertEquals(jsonObject.get("double"), PropertyUtils.getProperty(bean, "double"));
        assertEquals(jsonObject.get("func"), PropertyUtils.getProperty(bean, "func"));
        System.out.println(PropertyUtils.getProperty(bean, "name"));
        System.out.println(PropertyUtils.getProperty(bean, "bool"));
        System.out.println(PropertyUtils.getProperty(bean, "int"));
        System.out.println(PropertyUtils.getProperty(bean, "double"));
        System.out.println(PropertyUtils.getProperty(bean, "func"));
        System.out.println(PropertyUtils.getProperty(bean, "array"));

        List arrayList = (List) JSONArray.toCollection(jsonObject.getJSONArray("array"));
        for (Object object : arrayList) {
            System.out.println(object);
        }
    }


    //将json解析成复合类型对象, 包含List
    @Test
    public void testJSONToBeanHavaList() {
        String json = "{teachers:[{name:'test1'},{name:'test2'}]}";
        Map classMap = new HashMap();
        classMap.put("teachers", Teacher.class);
        TeacherBean diyBean = (TeacherBean) JSONObject.toBean(JSONObject.fromObject(json), TeacherBean.class, classMap);
        List list = diyBean.getTeachers();
        for (Object o : list) {
            if (o instanceof Teacher) {
                Teacher p = (Teacher) o;
                System.out.println(p.getName());
            }
        }
    }


    //将json解析成复合类型对象, 包含Map
    @Test
    public void testJSONToBeanHavaMap() {
        //把Map看成一个对象
        String json = "{list:[{name:'test1'},{name:'test2'}],map:{test1:{name:'test1'},test2:{name:'test2'}}}";
        Map classMap = new HashMap();
        classMap.put("list", Person.class);
        classMap.put("map", Map.class);
        //使用暗示，直接将json解析为指定自定义对象，其中List完全解析,Map没有完全解析
        MyBeanWithPerson diyBean = (MyBeanWithPerson) JSONObject.toBean(JSONObject.fromObject(json), MyBeanWithPerson.class, classMap);
        System.out.println(diyBean);

        System.out.println("do the list release");
        List<Person> list = diyBean.getList();
        for (Person o : list) {
            Person p = (Person) o;
            System.out.println(p.getName());
        }

        System.out.println("do the map release");

        //先往注册器中注册变换器，需要用到ezmorph包中的类
        MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
        Morpher dynaMorpher = new BeanMorpher(Person.class, morpherRegistry);
        morpherRegistry.registerMorpher(dynaMorpher);


        Map map = diyBean.getMap();
        System.out.println(map);
        List<Person> output = new ArrayList();
        for (Iterator i = map.values().iterator(); i.hasNext(); ) {
            //使用注册器对指定DynaBean进行对象变换
            output.add((Person) morpherRegistry.morph(Person.class, i.next()));
        }

        for (Person p : output) {
            System.out.println(p.getName());
        }

    }


}
