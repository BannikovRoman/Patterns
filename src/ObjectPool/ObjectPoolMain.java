package ObjectPool;

import java.util.LinkedList;
import java.util.List;

//Используется для того чтобы уменьшить количество создаваемых объектов, т.е. переиспользовать их
public class ObjectPoolMain {
    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool();
        PooledObject pooledObject = objectPool.getPooledObject();

        objectPool.releasedPooledObject(pooledObject);
    }
}

class PooledObject {}

class ObjectPool {
    private List<PooledObject> free = new LinkedList<>();
    private List<PooledObject> used = new LinkedList<>();

    public PooledObject getPooledObject() {
        if(free.isEmpty()) {
            PooledObject pooledObject = new PooledObject();
            free.add(pooledObject);
            return pooledObject;
        } else {
            PooledObject pooledObject = free.get(0);
            used.add(pooledObject);
            free.remove(pooledObject);
            return pooledObject;
        }
    }

    public void releasedPooledObject(PooledObject pooledObject) {
        used.remove(pooledObject);
        free.add(pooledObject);
    }
}