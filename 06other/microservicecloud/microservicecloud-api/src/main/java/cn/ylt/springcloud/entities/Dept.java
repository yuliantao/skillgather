package cn.ylt.springcloud.entities;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yuliantao
 * @create 2019-01-08 22:53
 * @description 功能描述
 */
@NoArgsConstructor //创建无参构造函数
@Data//创建get、set方法
@Accessors(chain = true)//实现链式调用
public class Dept implements Serializable {//微服务必须序列化
    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
}
