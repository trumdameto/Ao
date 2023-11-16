package repository;

import java.util.ArrayList;

abstract public class MeoDAO<Entity, DataType> {

    abstract public ArrayList<Entity> getAll();
    //đang test
    abstract public Integer insert(Entity entity);
    abstract public Integer update(Entity entity);
    abstract public Integer delete(DataType id);
}

