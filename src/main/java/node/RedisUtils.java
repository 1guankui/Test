package node;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private static JedisPool pool = null;

    public static JedisPool open(String host, int port) {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10);
            config.setMaxIdle(3);
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, host, port);
        }
        return pool;
    }

    public static void close() {
        if (pool != null) {
            pool.close();
        }
    }
}
