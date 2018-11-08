import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;


import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CodeGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        //region  ***  数据源配置  ***

        DataSourceConfig dsc = new DataSourceConfig();
        //dsc.setDbQuery();//一般不用设置
        //dsc.setDbType();//一般不用设置
        // dsc.setSchemaName("public");//一般不设置
        //dsc.setTypeConvert();//一般不设置,默认由 dbType 类型决定选择对应数据库内置实现
        dsc.setUrl("jdbc:mysql://localhost:3306/skillgather?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        //dsc.setDriverName("com.mysql.cj.jdbc.Driver");//mysql 8以上驱动
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        //endregion

        //region   ***  策略配置(数据表配置)  ***

        StrategyConfig strategy = new StrategyConfig();
        //strategy.setCapitalMode(false);//是否大写命名,默认false
        strategy.setSkipView(false);//跳过视图
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        //strategy.setTablePrefix("ta_");//一般不用
        //strategy.setFieldPrefix("");//字段前缀
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");//自定义继承的Entity类全称，带包名()
        //strategy.setSuperEntityColumns("");//自定义基础的Entity类，公共字段
        //strategy.setSuperMapperClass();//不用设置默认已经设置苞米豆的父类
        //strategy.setSuperServiceClass();//不用设置默认已经设置苞米豆的父类
        //strategy.setSuperServiceImplClass()//不用设置默认已经设置苞米豆的父类
        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");//设置controler集成父类
        strategy.setInclude("[\\s\\S]*");//选择的表名，可以使用正则表达式
        //strategy.setExclude("");//排除的表和Include互斥
        //strategy.setEntityColumnConstant(false);//是否生成字段常量，默认false
        strategy.setEntityBuilderModel(false);//【实体】是否为构建者模型（默认 false）
        strategy.setEntityLombokModel(false);//设置是否是取消get,set,tostring(）等模板方法，如果删除但启用Lombok在编译时会自动生成
        //strategy.setEntityBooleanColumnRemoveIsPrefix();//Boolean类型字段是否移除is前缀（默认 false）
        strategy.setRestControllerStyle(true);//生成@RestController 控制器
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        //strategy.entityTableFieldAnnotationEnable()//是否生成实体时，生成字段注解
        //strategy.setVersionFieldName();//乐观锁属性名称
        //strategy.setLogicDeleteFieldName();//逻辑删除属性名称
        //strategy.setTableFillList();//表填充字段
        mpg.setStrategy(strategy);

        //endregion

        //region  ***  包配置  ***

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ylt.skillgather");
        pc.setModuleName("system");
        //pc.setEntity();//默认已经设置
        //pc.setService();//默认已经设置
        //pc.setServiceImpl();//默认已经设置
        //pc.setMapper();//默认已经设置
        //pc.setXml();//默认已经设置
        //pc.setController();//默认已经设置
        //pc.setPathInfo();//暂时没有找到何用
        mpg.setPackageInfo(pc);

        //endregion

        //region  ***  模板配置  ***

        //根据需求制定生成模板，如果为null则不生成,可以拷贝jar中的模板进行修改，主要修改controller
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/controller.java.vm");
/*      tc.setEntity(null);
        tc.setEntityKt(null);
        tc.setMapper(null);
        tc.setXml(null);
        tc.setService(null);
        tc.setServiceImpl(null);*/

        mpg.setTemplate(tc);

        //endregion

        // region  ***  全局配置  ***

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");//生成文件输出位置
        gc.setAuthor("yuliantao");
        gc.setFileOverride(true);//覆盖已有文件
        gc.setOpen(false);//是否打开输出目录
        gc.setEnableCache(false);//是否在xml中添加二级缓存配置
        gc.setKotlin(false);//是否开启 Kotlin 模式（多平台应用中可编译成Java字节码，也可编译成JavaScript，方便在没有JVM的设备上运行）
        gc.setSwagger2(false);//取消生成自动文档生成模式，待以后软件成熟了在开启
        gc.setActiveRecord(false);//是否生成领域模型，java语言中意义不大，JavaScript和其它动态语言比较流行
        gc.setBaseResultMap(true);//设置在xml的mapper配置文件中是否生成默认的返回类型（根据表返回字段）
        gc.setBaseColumnList(true);//设置基础的列
        gc.setDateType(DateType.TIME_PACK);//设置时间策略
        gc.setEntityName(null);//实体命名方式。默认值：null 例如：%sEntity 生成 UserEntity
        gc.setMapperName("%sMapper");//mapper 命名方式,默认值：null 例如：%sDao 生成 UserDao
        //gc.setXmlName("%sMappersss");//默认值：null 例如：%sDao 生成 UserDao.xml,当前测试没有生效
        //gc.setServiceName("%sBusiness");//默认值：null 例如：%sBusiness 生成 UserBusiness
        //gc.setServiceImplName("%sBusinessImpl");//默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        //gc.setControllerName("%sAction");//默认值：null 例如：%sAction 生成 UserAction
        //gc.setIdType();//生成主键ID类型,AUTO:"数据库ID自增", INPUT:"用户输入ID",ID_WORKER:"全局唯一ID (数字类型唯一ID)", UUID:"全局唯一ID UUID";
        mpg.setGlobalConfig(gc);

        //endregion

        //region  ***  injectionConfig配置  ***

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】  ${cfg.abc}
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 自定义模板生成，可以生成各层级别的文件，但主要是生成html（增删改查），以下生成查看为例
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/list.html.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath+"/src/main/resources/templates/"+ pc.getModuleName()+ "/" + tableInfo.getEntityName() + "list.html";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //endregion

        mpg.execute();
    }
}