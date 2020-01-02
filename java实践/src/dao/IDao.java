package dao;//Êý¾Ý²ã
import java.io.*;
import java.util.HashMap;
import entity.IEntity;
public interface IDao {
         void insert(IEntity entity) throws Exception;
         void delete() throws Exception;
         void update() throws Exception;
         public HashMap<String ,IEntity> getAllEntities() throws Exception;
         public IEntity getEntity(String Id);
}
