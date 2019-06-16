import java.util.List;

public interface ItemRepository {
    List<Item> findAll();

    Item getItemById(String id);
}
