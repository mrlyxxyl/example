��������mybatisӦ�ã�mybatis+spring���ϵ��ۺ�����
˵����
    1���mybatis������Ҫ����Ӧ�࣬mapper�ļ���sqlMapconfig.xml�ļ�
    2��mapper�ļ��е�namespace��ֵ��Ϊ�ӿڵ�ȫ·�����Ա����ֱ��ʹ�ýӿڲ������ݿ⣬����Ҫ��дʵ�ֽӿڵľ�����
    3��ʵ������ֱ��ͨ���ӿڲ������ݵ�����
    4������ʹ��mybatisʱд��MyBatisUtil������
    5���myba+springʱ��spring jar��Ҫ��3.0���ϱ�ʵ���е�jar������
    6��spring�����ļ���
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <property name="basePackage" value="com.yuexin.dao"/>
        </bean>
        ��value��ֵ�ǽӿ�dao�ļ��İ���
    7��dao�ӿ��ļ����Բ���@Repositoryע��
    8���ӿ��е�@Select("select id,name from user where id = #{id}")��mapper�ļ��е�<selectԪ����ͬ�ȼ��ģ�������д
    9���ӿ��еĲ�ѯ��ʽ��һ�£�
    @Select("select id,name from user where id = #{id}")
    User getUserById2(@Param("id") int id);

    10����ʵ���������������Ժ����ݿ��ֶβ���ͬ�Ľ���취������resultMap