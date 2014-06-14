本例子是mybatis应用，mybatis+spring整合的综合例子
说明：
    1、搭建mybatis环境需要：相应类，mapper文件，sqlMapconfig.xml文件
    2、mapper文件中的namespace的值设为接口的全路径，以便可以直接使用接口操作数据库，不必要在写实现接口的具体类
    3、实例中有直接通过接口操作数据的例子
    4、单独使用mybatis时写个MyBatisUtil工具类
    5、搭建myba+spring时，spring jar包要用3.0以上本实例中的jar包即可
    6、spring配置文件中
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <property name="basePackage" value="com.yuexin.dao"/>
        </bean>
        中value的值是接口dao文件的包名
    7、dao接口文件可以不见@Repository注解
    8、接口中的@Select("select id,name from user where id = #{id}")和mapper文件中的<select元素是同等级的，不能重写
    9、接口中的查询方式如一下：
    @Select("select id,name from user where id = #{id}")
    User getUserById2(@Param("id") int id);

    10、本实例还包括，类属性和数据库字段不相同的解决办法，利用resultMap