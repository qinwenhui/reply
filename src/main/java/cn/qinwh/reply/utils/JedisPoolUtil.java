package cn.qinwh.reply.utils;


public class JedisPoolUtil {
//	// Jedispool
//    static JedisCommands jedisCommands;
//    static JedisPool jedisPool;
//    static JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//    static String ip = "127.0.0.1";
//    static int port = 6379;
//    static int timeout = 2000;
//
//    static {
//    	//初始化jedis
//    	// 设置配置
//        jedisPoolConfig.setMaxTotal(10);//最大连接数
//        jedisPoolConfig.setMaxIdle(100);//最大空闲连接数
//        jedisPoolConfig.setMaxWaitMillis(100);//最大等待时间
//        jedisPoolConfig.setTestOnBorrow(false);//jedis 第一次启动时，会报错
//        jedisPoolConfig.setTestOnReturn(true);
//        // 初始化JedisPool
//        jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout);
//
//    }
//
//    public static void setValue(String key, String value) {
//    	Jedis jedis = jedisPool.getResource();
//        jedisCommands = jedis;
//        jedisCommands.set(key, value);
//        jedis.close();
//    }
//    public static String setex(String key, int seconds, String value) {
//    	Jedis jedis = jedisPool.getResource();
//        jedisCommands = jedis;
//        String result = jedisCommands.setex(key, seconds, value);
//        jedis.close();
//        return result;
//    }
//    public static String getValue(String key) {
//    	Jedis jedis = jedisPool.getResource();
//        jedisCommands = jedis;
//        String result = jedisCommands.get(key);
//        jedis.close();
//        return result;
//    }
//    public static Jedis getJedis(){
//    	return jedisPool.getResource();
//    }
//    //保存对象
//    public static void setObject(String key, Object obj) {
//    	//先序列化对象
//    	String value = serializable(obj);
//    	//保存
//    	Jedis jedis = jedisPool.getResource();
//        jedisCommands = jedis;
//        jedisCommands.set(key, value);
//        jedis.close();
//    }
//
//    //获取对象
//    public static Object getObject(String key){
//    	Object obj = null;
//    	Jedis jedis = jedisPool.getResource();
//        jedisCommands = jedis;
//    	String value = jedisCommands.get(key);
//    	if(value == null)
//    		return null;
//    	//反序列化
//    	obj = deserializable(value);
//    	jedis.close();
//    	return obj;
//    }
//
//
//    //序列化
//  	private static String serializable(Object obj){
//  		String result = "";
//  		ByteArrayOutputStream baos = null;
//  		ObjectOutputStream oos = null;
//  		try {
//  			baos = new ByteArrayOutputStream();
//  			oos = new ObjectOutputStream(baos);
//  			oos.writeObject(obj);
//  			result = baos.toString("iso-8859-1");
//  			oos.close();
//  			baos.close();
//  		} catch (IOException e) {
//  			System.out.println("序列化失败"+e.getMessage());
//  			e.printStackTrace();
//  		}
//  		return result;
//  	}
//
//  	//反序列化
//  	private static Object deserializable(String s){
//  		Object obj = null;
//  		ByteArrayInputStream bais = null;
//  		try {
//  			bais = new ByteArrayInputStream(s.getBytes("iso-8859-1"));
//  			ObjectInputStream ois = new ObjectInputStream(bais);
//  			obj = ois.readObject();
//  			ois.close();
//  			bais.close();
//  		} catch (IOException | ClassNotFoundException e) {
//  			System.out.println("反序列化失败"+e.getMessage());
//  			e.printStackTrace();
//  		}
//  		return obj;
//  	}

}
