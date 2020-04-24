package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @ClassName: BaseServiceImpl
 * @Description: 通用service实现类
 * 用法：
 *@Service
 *如果出错，数据库能回滚，建议所有的serviceImpl都要这样声明定义
 *@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
 *public class CreditApplyServiceImpl extends BaseServiceImpl<Credit_apply> implements CreditApplyService {}
 * @Author: zhongzk 28582157@qq.com
 * @Date: 2019/6/9 17:09 *
 * @Copyright: 2018 字节码团队www.bjsurong.com. All rights reserved.  *
 */
public class BaseServiceImpl<T> implements BaseService<T> {
    // 注入mapper
    @Autowired
    private Mapper<T> mapper;

    // 缓存子类泛型类型
    private Class<T> cache=null;


    /**
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 21:57
     * @Param: id  主键id
     * @return: pojo单个实体对象
     **/
    public T queryByPrimaryKey( Object key){
        return this.mapper.selectByPrimaryKey(key);
    }

    /**
     * @Description: 查询所有对象
     *
     *
     * @Date: 2019/6/9 21:59
     * @Param: 无
     * @return: java.util.List<T> list对象
     **/
    public List<T> queryAll(){
        return this.mapper.select(null);
    }


    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 22:00
     * @Param: param 条件
     * @return: java.util.List<T> 返回多条记录
     **/
    public List<T> queryListByWhere(T pojo){
        return this.mapper.select(pojo);
    }


    /**
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 22:02
     * @Param: pojo 实体对象
     * @return: 记录数
     **/
    public int queryCount(T pojo){
        return this.mapper.selectCount(pojo);
    }


    /**
     * @Description: 查询一条记录
     *,通常条件是给一个实体对象，这个对象只有初始了一个id值(其它唯一值的字段也可以）
     *
     * @Date: 2019/6/9 22:03
     * @Param: pojo  条件对象,它的属性必须与表字段对应（可以用@Transient忽略字段），否则会报错，并且id必须唯一
     * @return: 返回单个pojo实体对象
     **/
    public T queryOne(T pojo){
        return this.mapper.selectOne(pojo);
    }

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
    public PageInfo<T> queryPageListByWhere(T pojo, int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<T> list =  this.mapper.select(pojo);
        return new PageInfo<T>(list);

    }

    /**
     * @Description: 通过字段分页查询
     *
     *
     * @Date: 2019/6/10 0:28
     * @Param:
     * @Param:
     * @return:
     **/
    public PageInfo<T> queryPageListByField(Integer pageNo, Integer pageSize, Sqls whereSqls, String orderByField, String ascOrDesc, String ...fields){
        return new PageInfo<T>(queryByFiledBase(pageNo,pageSize,whereSqls,orderByField, ascOrDesc, fields));
    }

    /**
     * @Description: 子函数：通用分页字段查询
     *
     *
     * @Date: 2019/6/10 0:30
     * @Param: pageNo 当前页号
     * @Param: pageSize 页大小
     * @Param: whereSqls   sql条件,where的内容拿出来进行动态sql拼接
     * @Param: orderByField  单个排序字段
     * @Param: fields  可变长度的数组等同于String [] str={}
     * @return: java.util.List<T> list 记录集合
     **/
    private List<T> queryByFiledBase(Integer pageNo,Integer pageSize,Sqls whereSqls,String orderByField, String ascOrDesc, String ...fields){
        Example.Builder builder=null;
        if(null==fields||fields.length==0){
            //查询所有
            builder = Example.builder(getTypeArguement());

        }else{
            //查询指定字段,where的内容拿出来进行动态sql拼接
            builder= Example.builder(getTypeArguement()).select(fields);
        }
        if(whereSqls!=null){
            builder=builder.where(whereSqls);
        }

        if(orderByField!=null){
            if (ascOrDesc.toUpperCase().equals("DESC")){
                builder= builder
                        .orderByDesc(orderByField);
            }else{
                builder= builder
                        .orderByAsc(orderByField);
            }
        }
        Example example=builder.build();

        if(pageNo!=null&&pageSize!=null) {
            // 分页插件
            PageHelper.startPage(pageNo, pageSize);
        }
        List list = this.mapper.selectByExample(example);
        return  list;
    }

    /**
     * 获取子类泛型类型
     * @return
     */
    public Class<T> getTypeArguement() {
        if(cache==null)
            cache= (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return  cache;
    }




    /**
     * @Description: 插入一个pojo对象,null的属性也会保存，不会使用数据库默认值
     *
     *
     * @Date: 2019/6/9 22:05
     * @Param: pojo  实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    public int save(T pojo){
        return this.mapper.insert(pojo);
    }

    /**
     * @Description: 插入非空字段,null的属性不会保存，会使用数据库默认值
     *
     *
     * @Date: 2019/6/9 22:33
     * @Param: pojo 实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    public int saveSelect(T pojo){
        return this.mapper.insertSelective(pojo);
    }

    /**
     * @Description: 批量插入对象，非空字段,null的属性不会保存，会使用数据库默认值
     *
     *
     * @Date: 2019/6/10 0:01
     * @Param:  list 实体对象集合
     * @return: 如果数值大于0 则成功，null为失败
     **/
    public int batchSave(List<T> list) {
        int result = 0;
        for (T record : list) {
            int count = mapper.insertSelective(record);
            result += count;
        }
        return result;
    }

    /**
     * @Description: 根据主键更新实体全部字段，null值会被更新
     *
     *
     * @Date: 2019/6/9 22:35
     * @Param: pojo  实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    public int update(T pojo){
        return this.mapper.updateByPrimaryKey(pojo);
    }

    /**
     * @Description: 根据主键更新属性不为null的值
     *
     *
     * @Date: 2019/6/9 22:38
     * @Param: pojo 实体对象
     * @return:  如果数值大于0 则成功，null为失败
     **/
    public int updateSelective(T pojo){
        return this.mapper.updateByPrimaryKeySelective(pojo);
    }

    /**
     * @Description: 根据主键删除记录
     *
     *
     * @Date: 2019/6/9 22:39
     * @Param: id 主键id
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int deleteByPrimaryKey(T key){
        return this.mapper.deleteByPrimaryKey(key);
    }

    /**
     * @Description: 根据主键的list集合,批量删除对象
     *
     *
     * @Date: 2019/6/9 22:41
     * @Param: clazz 实体对象
     * @Param: ids 主键的list集合
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int deleteByIds(Class<T> clazz,List<Object> ids){
        // where条件
        Example example = new Example(clazz);
        example.createCriteria().andIn("id", ids);
        return this.mapper.deleteByExample(example);
        /*
           等效于where id in (#{ids})
         */
    }

    /**
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     *
     *
     * @Date: 2019/6/9 23:46
     * @Param: pojo 实体对象
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int  deleteByWhere(T pojo){
        return this.mapper.delete(pojo);
    }

    /**
     * @Description: 批量删除对象，根据实体属性作为条件进行删除，查询条件使用等号
     *
     *
     * @Date: 2019/6/10 0:07
     * @Param:
     * @Param:
     * @return:
     **/
    public int batchDelete(List<T> list) {
        int result = 0;
        for (T record : list) {
            int count = mapper.delete(record);
            if (count < 1) {
                //throw new BusinessException("删除数据失败!");
            }
            result += count;
        }
        return result;
    }

    /**
     * @Description: 根据Example条件进行删除
     *
     *
     * @Date: 2019/6/9 23:55
     * @Param:  example 查询条件对象
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int deleteByExample(Object example){
        return this.mapper.deleteByPrimaryKey(example);
    }
}