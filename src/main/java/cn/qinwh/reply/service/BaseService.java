package cn.qinwh.reply.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @ClassName: BaseService
 * @Description: 通用Service 接口
 * 1.用法：
 *public interface CreditApplyService  extends BaseService<Credit_apply> {}
 *
 * @Author: zhongzk 28582157@qq.com
 * @Date: 2019/6/9 9:35 *
 * @Copyright: 2018
 */
public interface BaseService<T> {

    /**
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 21:57
     * @Param: id  主键id
     * @return: pojo单个实体对象
     **/
    T queryByPrimaryKey( Object key);

    /**
     * @Description: 查询所有
     *
     *
     * @Date: 2019/6/9 21:59
     * @Param: 无
     * @return: java.util.List<T> list对象
     **/
    List<T> queryAll();

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 22:00
     * @Param: param 条件
     * @return: java.util.List<T> 返回多条记录
     **/
    List<T> queryListByWhere(T pojo);

    /**
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 22:02
     * @Param: pojo 实体对象
     * @return: 记录数
     **/
    int queryCount(T pojo);

    /**
     * @Description: 查询一条记录
     *,通常条件是给一个实体对象，这个对象只有初始了一个id值(其它唯一值的字段也可以）
     *
     * @Date: 2019/6/9 22:03
     * @Param: pojo  条件对象,它的属性必须与表字段对应（可以用@Transient忽略字段），否则会报错，并且id必须唯一
     * @return: 返回单个pojo实体对象
     **/
    T queryOne(T pojo);

    /**
     * @Description: 分页查询
     *
     *
     * @Date: 2019/6/9 18:36
     * @Param: pojo 条件,根据实体中的属性查询，查询条件使用等号
     * @Param: pageNo 当前页号
     * @Param: pageSize 页大小
     * @return:
     **/
    PageInfo<T> queryPageListByWhere(T pojo, int pageNo, int pageSize);

    /**
     * @Description: 通过字段分页查询
     *
     *
     * @Date: 2019/6/10 0:28
     * @Param:
     * @Param:
     * @return:
     **/
    PageInfo<T> queryPageListByField(Integer pageNo, Integer pageSize, Sqls where, String orderByField, String ascOrDesc, String ...fields);

    /**
     * 获取子类泛型类型
     * @return
     */
    Class<T> getTypeArguement();

    /**
     * @Description: 插入一个pojo对象,null的属性也会保存，不会使用数据库默认值
     *
     *
     * @Date: 2019/6/9 22:05
     * @Param: pojo  实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    int save(T pojo);

    /**
     * @Description: 插入非空字段,null的属性不会保存，会使用数据库默认值
     *
     *
     * @Date: 2019/6/9 22:33
     * @Param: pojo 实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    int saveSelect(T pojo);

    /**
     * @Description: 批量插入对象，非空字段,null的属性不会保存，会使用数据库默认值
     *
     *
     * @Date: 2019/6/10 0:01
     * @Param:  list 实体对象集合
     * @return: 如果数值大于0 则成功，null为失败
     **/
    int batchSave(List<T> list);

    /**
     * @Description: 根据主键更新实体全部字段，null值会被更新
     *
     *
     * @Date: 2019/6/9 22:35
     * @Param: pojo  实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    int update(T pojo);

    /**
     * @Description: 根据主键更新属性不为null的值
     *
     *
     * @Date: 2019/6/9 22:38
     * @Param: pojo 实体对象
     * @return:  如果数值大于0 则成功，null为失败
     **/
    int updateSelective(T pojo);

    /**
     * @Description: 根据主键删除记录
     *
     *
     * @Date: 2019/6/9 22:39
     * @Param: id 主键id
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    int deleteByPrimaryKey(T key);

    /**
     * @Description:  根据主键的list集合,批量删除对象
     *
     *
     * @Date: 2019/6/9 22:41
     * @Param: clazz 实体对象
     * @Param: ids 主键的list集合
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    int deleteByIds(Class<T> clazz,List<Object> ids);

    /**
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 23:46
     * @Param: pojo 实体对象
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    int  deleteByWhere(T pojo);

    /**
     * @Description: 批量删除对象，根据实体属性作为条件进行删除，查询条件使用等号
     *
     *
     * @Date: 2019/6/10 0:07
     * @Param:
     * @Param:
     * @return:
     **/
    int batchDelete(List<T> list);

    /**
     * @Description: 根据Example条件进行删除
     *
     *
     * @Date: 2019/6/9 23:55
     * @Param:  example 查询条件对象
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    int deleteByExample(Object example);
}
