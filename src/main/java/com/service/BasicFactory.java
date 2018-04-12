package com.service;

import java.io.FileReader;
import java.util.Properties;

public class BasicFactory {
    //在工厂类内部维护一个静态的实例对象，供外界调用
    private static BasicFactory factory = new BasicFactory();
    //定义属性对象，从属性文件中读取各层接口对应实现类的全路径
    private static Properties property = null;
    //私有化构造函数
    private BasicFactory(){
    }
    //对外提供获取工厂类静态实例对象的接口
    public static BasicFactory getFactory(){
        return factory;
    }
    //当工厂类被加载到内存中，则执行静态代码块，初始化属性对象
    static{
        property = new Properties();
        try {
            //通过工厂类获取类加载器，得到类加载路径下的属性文件的硬盘路径，构造reader
            FileReader reader = new FileReader(
                    BasicFactory.class.getClassLoader().getResource("config.properties").getPath());
            //加载属性文件内容到内存对象中，完成初始化操作
            property.load(reader);
        } catch (Exception e) {
            //打印异常抛出的跟踪路径
            e.printStackTrace();
            //向Java虚拟机抛出运行时异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过工厂类获取各层接口的实现类对象
     * @param <T> 泛型，各层接口的实现类
     * @param clazz 需要获取的层接口的Class对象
     * @return 该层的实现类对象
     */
    public <T> T getInstance(Class<T> clazz){
        //获取class对象的类型名，即层接口名
        String interfaceName = clazz.getSimpleName();
        //从属性文件中读取该层接口所对应的实现类的全路径
        String implName = property.getProperty(interfaceName);
        try {
            //加载接口实现类的Class对象，从而创建出该实现类的实例对象并返回
            return (T) Class.forName(implName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
