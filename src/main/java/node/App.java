package node;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.33.66", 6379);
            Jedis jedis = pool.getResource();
            Transaction multi = jedis.multi();
            multi.set("aa", "abc");
            multi.set("aaa", "aabc");
            List<Object> exec = multi.exec();
            System.out.println(exec);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }

    }
}
